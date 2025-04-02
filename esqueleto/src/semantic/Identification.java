package semantic;

import ast.*;
import ast.cuerpoprograma.Function;
import ast.cuerpoprograma.StructDefinition;
import ast.expr.FunctionCall;
import ast.expr.Variable;
import ast.statement.If;
import ast.statement.StmtFunctionCall;
import ast.statement.While;
import ast.tipo.NomType;
import main.ErrorManager;
import visitor.DefaultVisitor;

// This class will be implemented in identification phase

public class Identification extends DefaultVisitor {

    private ErrorManager errorManager;
    private ContextMap<Declaracion> variables=new ContextMap<Declaracion>();
	private ContextMap<Function> funciones=new ContextMap<Function>();
	private ContextMap<StructDefinition> structs=new ContextMap<StructDefinition>();

    public Identification(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    public void process(AST ast) {
        ast.accept(this, null);
    }

    // # ----------------------------------------------------------
 // class Program(List<CuerpoPrograma> cuerpoProgramas)
 	@Override
 	public Object visit(Program program, Object param) {
 		variables.set();
 		// program.getCuerpoProgramas().forEach(cuerpoPrograma -> cuerpoPrograma.accept(this, param));
 		super.visit(program, param);
 		variables.reset();
 		
 		return null;
 	}

 	// class StructDefinition(String nombre, List<VarDefinition> atributos, List<Function> metodos)
 	@Override
 	public Object visit(StructDefinition structDefinition, Object param) {
 		variables.set();
 		if(structs.getFromAny(structDefinition.getNombre())==null) {
 			//System.out.println("Nuevo struct:"+ structDefinition.getNombre());
 			structs.put(structDefinition.getNombre(), structDefinition);
 		}else {
 			notifyError("Ese struct ya está definido: "+structDefinition.getNombre());
 		}
 		// structDefinition.getAtributos().forEach(varDefinition -> varDefinition.accept(this, param));
 		// structDefinition.getMetodos().forEach(function -> function.accept(this, param));
 		super.visit(structDefinition, param);
 		variables.reset();
 		return null;
 	}
 	// class Declaracion(String nombre, Tipo tipo)
 	@Override
 	public Object visit(Declaracion declaracion, Object param) {
 		//Añadimos que se añadan las variables no definidas en el hámbito
 		if(variables.getFromTop(declaracion.getNombre()) == null) {
 			//System.out.println("Nueva declaración:"+ declaracion.getNombre());
 			variables.put(declaracion.getNombre(), declaracion);
 		}else {
 			notifyError("Error variable ya definida:"+ declaracion.getNombre());
 		}
 		// declaracion.getTipo().accept(this, param);
 		super.visit(declaracion, param);

 		return null;
 	}
 	
 	// class Variable(String nombre)
 		@Override
 		public Object visit(Variable variable, Object param) {
 			Declaracion d= this.variables.getFromAny(variable.getNombre());
 			if(d!=null) {
 				//Lo relacionamos
 				variable.setDeclaracion(d);
 			}else {
 				notifyError("La variable no se ha definido previamente: "+variable.getNombre());
 			}
 			return null;
 		}


 	// class Function(String nombre, List<Declaracion> parametros, Tipo tipoRetorno, List<Statement> cuerpo)
 	@Override
 	public Object visit(Function function, Object param) {
 		//Añadimos un nuevo hámbito
 		variables.set();
 		if(funciones.getFromAny(function.getNombre())==null) {
 			funciones.put(function.getNombre(), function);
 		}else {
 			notifyError("La función ya ha sido definida previamente: "+function.getNombre());
 		}
 		// function.getParametros().forEach(declaracion -> declaracion.accept(this, param));
 		// function.getTipoRetorno().accept(this, param);
 		// function.getCuerpo().forEach(statement -> statement.accept(this, param));
 		super.visit(function, param);
 		variables.reset();
 		return null;
 	}
 	
 	
 	
 	

 	// class If(Expr condition, List<Statement> thenBlock, List<Statement> elseBlock)
 	@Override
 	public Object visit(If ifValue, Object param) {
 		variables.set();
 		// ifValue.getCondition().accept(this, param);
 		// ifValue.getThenBlock().forEach(statement -> statement.accept(this, param));
 		// ifValue.getElseBlock().forEach(statement -> statement.accept(this, param));
 		super.visit(ifValue, param);
 		variables.reset();
 		return null;
 	}

 	// class While(Expr condition, List<Statement> body)
 	@Override
 	public Object visit(While whileValue, Object param) {
 		variables.set();
 		// whileValue.getCondition().accept(this, param);
 		// whileValue.getBody().forEach(statement -> statement.accept(this, param));
 		super.visit(whileValue, param);
 		variables.reset();
 		return null;
 	}

 	// class FunctionCall(String nombre, List<Expr> exprs)
 	@Override
 	public Object visit(FunctionCall functionCall, Object param) {
 		Function f=funciones.getFromAny(functionCall.getNombre());
 		if(f!=null) {
 			functionCall.setFunction(f);
 		}else {
 			
 			notifyError("La función no ha sido definida previamente: "+functionCall.getNombre());
 		}
 		// functionCall.getExprs().forEach(expr -> expr.accept(this, param));
 		super.visit(functionCall, param);

 		return null;
 	}
 	
 	
 // class FunctionCall(String nombre, List<Expr> exprs)
  	@Override
  	public Object visit(StmtFunctionCall functionCall, Object param) {
  		Function f=funciones.getFromAny(functionCall.getNombre());
  		if(f!=null) {
  			functionCall.setFunction(f);
  		}else {
  			notifyError("La función no ha sido definida previamente: "+functionCall.getNombre());
  		}
  		// functionCall.getExprs().forEach(expr -> expr.accept(this, param));
  		super.visit(functionCall, param);

  		return null;
  	}
  	
  	
 	
 // class NomType(String nombre)
 	@Override
 	public Object visit(NomType nomType, Object param) {
 		StructDefinition s=structs.getFromAny(nomType.getNombre());
 		if(structs.getFromAny(nomType.getNombre())!=null) {
 			nomType.setStructDefinition(s);
 		}else {
 			notifyError("El struct no ha sido definido previamente: "+nomType.getNombre());
 		}
 		return null;
 	}
    // # --------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------

    private void notifyError(String msg) {
        errorManager.notify("Identification", msg);
    }

    private void notifyError(String msg, Position position) {
        errorManager.notify("Identification", msg, position);
    }

    private void notifyError(String msg, AST node) {
        notifyError(msg, node.start());
    }

}

// Generated with VGen 2.0.0


/*

Este fichero es un esqueleto para facilitar la creación de una clase visitor. Para
usarlo hay que realizar dos pasos:
1. Ubicar este código.
2. Completar cada método visit.

## Paso 1. Ubicación de este Código

Este esqueleto será SOBREESCRITO la próxima vez que se ejecuta VGen. Por ello, se debe
copiar su contenido antes de hacer cualquier cambio.

Hay dos opciones:

1) Si ya se tiene hecha una clase para el visitor, basta con copiar a dicha clase los
   métodos visit de este esqueleto (y los import) ignorando el resto.

2) Si no se tiene hecha aún la clase, este esqueleto vale como tal si se mueve a la
   carpeta deseada del proyecto y se le pone el package correspondiente a dicha ubicación.

Una vez hecho esto, ya se tendría un visitor que compilaría sin errores y que, al
ejecutarlo, recorrería todo el árbol (aunque sin hacer nada en cada nodo).


## Paso 2 Completar cada Método Visit

El visit generado para cada nodo se limita a recorrer sus hijos. El código de recorrido
se encuentra en la llamada a 'super.visit'. Los 'accept' comentados encima de cada
'super.visit' son sólo un recordatorio de lo que hace dicho método (son una copia de su
implementación, que se hereda de DefaultVisitor).

Por tanto, hay tres opciones a la hora de implementar cada visit:

1. Si en el visit de un nodo SÓLO SE NECESITA RECORRER sus hijos, se puede borrar
   completamente dicho visit de esta clase. Al no estar el método, se heredará de
   DefaultVisitor la misma implementación que se acaba de borrar. Es decir, en esta
   clase sólo será necesario dejar los visit que tengan alguna acción que realizar.

2. Si se necesita hacer alguna tarea adicional ANTES o DESPUÉS de recorrer todos
   los hijos, se debe añadir su código antes o después de la llamada a 'super.visit' (y
   se pueden borrar los 'accept' comentados).

3. Y, finalmente, si se necesita hacer alguna tarea INTERCALADA en el recorrido de los
   hijos (por ejemplo, comprobar su tipo), se debe borrar el 'super.visit' y descomentar
   los 'accept'. Así se tendría ya implementado el recorrido de los hijos, que es la
   estructura donde se intecalará el código de las acciones adicionales.

*/

// TODO: write package name
// package ...;
package visitor;

import ast.*;
import ast.cuerpoprograma.*;
import ast.statement.*;
import ast.expr.*;
import semantic.ContextMap;


public class IdentificationVisitor extends DefaultVisitor {
	private ContextMap<Declaracion> variables=new ContextMap<Declaracion>();
	private ContextMap<Function> funciones=new ContextMap<Function>();
	private ContextMap<StructDefinition> structs=new ContextMap<StructDefinition>();

    public void process(AST ast) {
        ast.accept(this, null);
    }

    // Visit Methods --------------------------------------------------------------

	// class Program(List<CuerpoPrograma> cuerpoProgramas)
	@Override
	public Object visit(Program program, Object param) {
		System.out.println("Empieza");
		variables.set();
		// program.getCuerpoProgramas().forEach(cuerpoPrograma -> cuerpoPrograma.accept(this, param));
		super.visit(program, param);
		variables.reset();
		System.out.println("Acaba");
		
		return null;
	}

	// class StructDefinition(String nombre, List<VarDefinition> atributos, List<Function> metodos)
	@Override
	public Object visit(StructDefinition structDefinition, Object param) {
		variables.set();
		if(structs.getFromAny(structDefinition.getNombre())==null) {
			System.out.println("Nuevo struct:"+ structDefinition.getNombre());
			structs.put(structDefinition.getNombre(), structDefinition);
		}else {
			System.err.println("Ese struct ya está definido: "+structDefinition.getNombre());
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
			System.out.println("Nueva declaración:"+ declaracion.getNombre());
			variables.put(declaracion.getNombre(), declaracion);
		}else {
			System.err.println("Herror variable ya definida:"+ declaracion.getNombre());
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
				System.err.println("La variable no se ha definido previamente: "+variable.getNombre());
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
			System.err.println("La función ya ha sido definida previamente: "+function.getNombre());
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
			System.err.println("La función no ha sido definida previamente: "+functionCall.getNombre());
		}
		// functionCall.getExprs().forEach(expr -> expr.accept(this, param));
		super.visit(functionCall, param);

		return null;
	}

}

/**
 * MLang. Programming Language Design Tutorial
 * @author Raúl Izquierdo (raul@uniovi.es)
 */

package semantic;

import java.beans.Statement;

import org.antlr.v4.runtime.atn.SemanticContext.Operator;

import ast.*;
import ast.cuerpoprograma.Function;
import ast.cuerpoprograma.StructDefinition;
import ast.cuerpoprograma.VarDefinition;
import ast.expr.ArrayAccess;
import ast.expr.Cast;
import ast.expr.CharLiteral;
import ast.expr.Comparacion;
import ast.expr.FieldAccess;
import ast.expr.FunctionCall;
import ast.expr.IntLiteral;
import ast.expr.Not;
import ast.expr.OperacionAritmetica;
import ast.expr.OperacionLogica;
import ast.expr.Parentesis;
import ast.expr.RealLiteral;
import ast.expr.Variable;
import ast.statement.Asignacion;
import ast.statement.If;
import ast.statement.OneExpr;
import ast.statement.Print;
import ast.statement.PrintLn;
import ast.statement.PrintSp;
import ast.statement.Read;
import ast.statement.Return;
import ast.statement.StmtFunctionCall;
import ast.statement.While;
import ast.tipo.ArrayType;
import ast.tipo.CharType;
import ast.tipo.FloatType;
import ast.tipo.IntType;
import ast.tipo.NomType;
import ast.tipo.Tipo;
import ast.tipo.VoidType;
import main.ErrorManager;
import visitor.DefaultVisitor;

// This class will be implemented in type checking phase

public class TypeChecking extends DefaultVisitor {

    private ErrorManager errorManager;

    public TypeChecking(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    public void process(AST ast) {
        ast.accept(this, null);
    }

    // # ----------------------------------------------------------
    /*
     * Los atributos sintetizados se inicializan deués de llamar al visit de los hijos
     * Los atributos heredados se inicializan en el opoadre para pasarselo al hijo (el visit después de inicializarlo)
     * Se pueden marcar los atributos como heredados: [inherited]
     * 
     */
    /*
    * Implement visit methods here.
    */

 	// class Function(String nombre, List<Declaracion> parametros, Tipo tipoRetorno, List<Statement> cuerpo)
 	@Override
 	public Object visit(Function function, Object param) {
 		for (var statement : function.getCuerpo()) {
 			statement.setPadre(function);
 			statement.accept(this, param);
		}
		function.getParametros().forEach(declaracion -> declaracion.accept(this, param));
 		function.getTipoRetorno().accept(this, param);
		for (var parametro : function.getParametros()) {
		 			predicate(checkSipleType(parametro.getTipo()),
		 					"El parámetro tiene que ser de tipo simple",function);
				}
		predicate(checkSipleType(function.getTipoRetorno()) || function.getTipoRetorno().getClass().equals(VoidType.class),
					"El tipo de retorno tiene que ser de tipo simple o void",function);
 		return null;
 	}

 	// class Print(List<Expr> exprs)
 	@Override
 	public Object visit(Print print, Object param) {

 		print.getExprs().forEach(expr ->{
 			expr.accept(this, param);
 			predicate(checkSipleType(expr.getType()),
 					"Los métodos print solo pueden recivir expresiones de tipo simple.",
 					print);
 			});

 		return null;
 	}

 	// class PrintSp(List<Expr> exprs)
 	@Override
 	public Object visit(PrintSp printSp, Object param) {
 		printSp.getExprs().forEach(expr ->{
 			expr.accept(this, param);
 			predicate(checkSipleType(expr.getType()),
 					"Los métodos print solo pueden recivir expresiones de tipo simple.",
 					printSp);
 			});

 		return null;
 	}

 	// class PrintLn(List<Expr> exprs)
 	@Override
 	public Object visit(PrintLn printLn, Object param) {

 		printLn.getExprs().forEach(expr ->{
 			expr.accept(this, param);
 			predicate(checkSipleType(expr.getType()),
 					"Los métodos print solo pueden recivir expresiones de tipo simple.",
 					printLn);
 			});

 		return null;
 	}

 	

	// class Asignacion(Expr left, Expr right)
 	@Override
 	public Object visit(Asignacion asignacion, Object param) {
 		
 		asignacion.getLeft().accept(this, param);
 		asignacion.getRight().accept(this, param);
 		
 		if(asignacion.getLeft().getType().getClass().equals(ArrayType.class) &&  asignacion.getRight().getType().getClass().equals(ArrayType.class)) {
 			ArrayType array1=(ArrayType)asignacion.getLeft().getType();
 			ArrayType array2=(ArrayType)asignacion.getRight().getType();
 			if(predicate(array1.getIntValue()==array2.getIntValue() && sameType(array1.getTipoBase(), array2.getTipoBase()),
 					"Los tipos no coinciden, ya que los array no tienen las mismas características",
 					asignacion)) {
 			}
 			
 		}else if(asignacion.getLeft().getType().getClass().equals(NomType.class) &&  asignacion.getRight().getType().getClass().equals(NomType.class)){
 			NomType struct1=(NomType)asignacion.getLeft().getType();
 			NomType struct2=(NomType)asignacion.getRight().getType();
 			if(predicate(struct1.getNombre().endsWith(struct2.getNombre()),
 					"A la variable solo se le puede asignar un elemento de su mismo tipo",
 					asignacion)) {
 			}
 		}else {
 			predicate(sameType (asignacion.getLeft().getType(), asignacion.getRight().getType()),
 	 				"A la variable solo se le puede asignar un elemento de su mismo tipo",
 	 				asignacion);
 		}
 		predicate(asignacion.getLeft().isLvalue(),
 				"La expresión izquierda tiene que ser Lvalue",
 				asignacion);
 		predicate(checkSipleType(asignacion.getLeft().getType()),
 				"La expresión izquierda tiene que ser de tipo simple",
 				asignacion);
 		return null;
 	}

	// class Return(Optional<Expr> expr)
 	@Override
 	public Object visit(Return returnValue, Object param) {
 		returnValue.getExpr().ifPresent(expr -> {
 			expr.accept(this, param);
 			predicate(sameType(returnValue.getExpr().get().getType(),returnValue.getPadre().getTipoRetorno()),
 	 				"El tipo de retorno de la función es: "+returnValue.getPadre().getTipoRetorno()
 	 				+" y se está intentando devolver un elemento de tipo: "+returnValue.getExpr().get().getType(),
 	 				returnValue);
 			});
 		if(returnValue.getExpr().isEmpty()) {
 			predicate(returnValue.getPadre().getTipoRetorno().getClass().equals(VoidType.class),
	 				"El tipo de retorno de la función es: "+returnValue.getPadre().getTipoRetorno()+" y no se está devolviendo nada.",
	 				returnValue);
 		}
 		
 		
 		return null;
 	}
 	// class If(Expr condition, List<Statement> thenBlock, List<Statement> elseBlock)
 	@Override
 	public Object visit(If ifValue, Object param) {

 		ifValue.getCondition().accept(this, param);
 		predicate(sameType(ifValue.getCondition().getType(), new IntType()),
 				"Las condiciones del método if tienen que ser de tipo entero",
 				ifValue);
 		
 		ifValue.getThenBlock().forEach(statement -> {	
 			statement.setPadre(ifValue.getPadre());
 			statement.accept(this, param);
 		});
 		ifValue.getElseBlock().forEach(statement -> {	
 			statement.setPadre(ifValue.getPadre());
 			statement.accept(this, param);
 		});

 		return null;
 	}

 	// class While(Expr condition, List<Statement> body)
 	@Override
 	public Object visit(While whileValue, Object param) {

 		whileValue.getCondition().accept(this, param);
 		predicate(sameType(whileValue.getCondition().getType(), new IntType()),
 				"Las condiciones del método while tienen que ser de tipo entero",
 				whileValue);
 		whileValue.getBody().forEach(statement -> {
 			statement.setPadre(whileValue.getPadre());
 			statement.accept(this, param);
 			});

 		return null;
 	}

 	// class Read(Expr expr)
 	@Override
 	public Object visit(Read read, Object param) {

 		read.getExpr().accept(this, param);
 		predicate(checkSipleType(read.getExpr().getType()),
 				"No se puede llamar a la función read con un parámetro que no es de tipo simple",
 				read);
 		predicate(read.getExpr().isLvalue(),
 				"No se puede llamar a la función read con un parámetro al que nos se le puede asignar un valor",
 				read);
 		return null;
 	}
 	// class StmtFunctionCall(String nombre, List<Expr> exprs)
 	// phase TypeChecking { Function padre }
 	@Override
 	public Object visit(StmtFunctionCall stmtFunctionCall, Object param) {
 		stmtFunctionCall.getExprs().forEach(expr -> expr.accept(this, param));
 		
 		if(predicate(!(stmtFunctionCall.getExprs().size()!=stmtFunctionCall.getFunction().parametros().count()),
 				"El número de parametros que se le pasan a la llamada de la función no son los mismos que se especificaron en su declaración",
 				stmtFunctionCall)) {
 		
	 		for(int i=0; i<stmtFunctionCall.getFunction().parametros().count();i++) {
	 			predicate(sameType(stmtFunctionCall.getExprs().get(i).getType(), stmtFunctionCall.getFunction().parametros().skip(i).findFirst().get().getTipo()),
	 	 				"El parámetro y el elemento que se ha pasado en su posición no son del mismo tipo.",
	 	 				stmtFunctionCall);
	 		}
 		}
 		return null;
 	}

 	// class FieldAccess(Expr object, String field)
 	@Override
 	public Object visit(FieldAccess fieldAccess, Object param) {
 		fieldAccess.getObject().accept(this, param);
 		if(fieldAccess.getObject().getType().getClass().equals(NomType.class)) {
 			NomType struct= (NomType)fieldAccess.getObject().getType();
 		boolean isDefined=false;
 		Declaracion d=null;
 		for(int i=0;i<struct.getStructDefinition().getAtributos().size();i++ ) {
 			if(struct.getStructDefinition().getAtributos().get(i).getDeclaracion().getNombre().equals(fieldAccess.getField())) {
 				d=struct.getStructDefinition().getAtributos().get(i).getDeclaracion();
 				isDefined=true;
 				fieldAccess.setStructAccedido(struct.getStructDefinition());
 				break;
 			}
 		}
 		if(predicate(isDefined,
 				"El campo al que se intenta acceder no se encuentra definido en el struct",
 				fieldAccess)) {
 			fieldAccess.setType(d.getTipo());
 			fieldAccess.setLvalue(true);
 		}else {
 			//ESTO HACE QUE FALLE
 			fieldAccess.setType(new VoidType());
 			fieldAccess.setLvalue(true);
 		}
 		}else {
 			//ESTO HACE QUE FALLE
 			fieldAccess.setLvalue(true);
 	 		fieldAccess.setType(new VoidType());
 		}
 		predicate(fieldAccess.getObject().getType().getClass().equals(NomType.class),
 				"El elemento del que se intenta extraer el valor del campo: "+fieldAccess.getField()+", no es un struct.", fieldAccess);
	 		return null;
 		
 	}

 	// class ArrayAccess(Expr array, Expr index)
 	@Override
 	public Object visit(ArrayAccess arrayAccess, Object param) {
 		arrayAccess.getArray().accept(this, param);
 		arrayAccess.getIndex().accept(this, param);
 		predicate(sameType(arrayAccess.getIndex().getType(), new IntType()),
 				"El acceso a un aray solo se puede hacer con un elemento de tipo entero",
 				arrayAccess);
 		if(!predicate(arrayAccess.getArray().getType().getClass().equals(ArrayType.class),
 				"Se está intentando acceder al elemento de un array en un elemento que no es un array",
 				arrayAccess)) {
 			arrayAccess.setType(arrayAccess.getArray().getType());
 			arrayAccess.setLvalue(true);
 		}else {
 			ArrayType a=(ArrayType)arrayAccess.getArray().getType();
 			arrayAccess.setType(a.getTipoBase());
 			arrayAccess.setLvalue(true);
 		}
 		
 		return null;
 	}

 	// class Cast(Tipo tipo, Expr target)
 	@Override
 	public Object visit(Cast cast, Object param) {
 		cast.getTipo().accept(this, param);
 		cast.getTarget().accept(this, param);
 		
 		predicate(!cast.getTarget().getType().getClass().equals(ArrayType.class),
 				"No se puede convertir un array",cast);
 		predicate(!cast.getTarget().getType().getClass().equals(NomType.class),
 				"No se puede convertir un struct",cast);
 		predicate(!cast.getTipo().getClass().equals(cast.getTarget().getType().getClass()),
 				"El tipo de la expresión y el tipo destino deben ser distintos",cast); 
 		predicate(!cast.getTipo().getClass().equals(ArrayType.class),
 				"No se puede hacer cast a tipo array",cast); 
 		predicate(!cast.getTipo().getClass().equals(NomType.class),
 				"No se puede hacer cast a tipo  struct",cast); 
 		cast.setType(cast.getTipo());
 		cast.setLvalue(false);

 		return null;
 	}

 	// class Not(Expr expr)
 	@Override
 	public Object visit(Not not, Object param) {

 		not.getExpr().accept(this, param);
 		predicate(not.getExpr().getType().getClass().equals(IntType.class),
 				"No se puede negar un operando que no sea un entero",not);
 		not.setType(not.getExpr().getType());
 		not.setLvalue(false);
 		return null;
 	}

 	// class OperacionAritmetica(Expr left, String operador, Expr right)
 	@Override
 	public Object visit(OperacionAritmetica operacionAritmetica, Object param) {
 		operacionAritmetica.getLeft().accept(this, param);
 		operacionAritmetica.getRight().accept(this, param);
 		predicate(operacionAritmetica.getLeft().getType().getClass().equals(operacionAritmetica.getRight().getType().getClass()),
 				"Los tipos tienen que ser iguales en una operación aritmética",
 				operacionAritmetica);
 		predicate(!operacionAritmetica.getLeft().getType().getClass().equals(CharType.class) &&
 				!operacionAritmetica.getRight().getType().getClass().equals(CharType.class),
 				"Los tipos no pueden ser char en una operación aritmética",
 				operacionAritmetica);
 		if(operacionAritmetica.getOperador().equals("%")) {
 			predicate(operacionAritmetica.getLeft().getType().getClass().equals(IntType.class)  &&
 				operacionAritmetica.getRight().getType().getClass().equals(IntType.class),
 				"El módulo solo se puede hacer con enteros.",
 				operacionAritmetica);
 		}
 		operacionAritmetica.setLvalue(false);
 		operacionAritmetica.setType(operacionAritmetica.getLeft().getType());

 		return null;
 	}

 	// class OperacionLogica(Expr left, String operador, Expr right)
 	@Override
 	public Object visit(OperacionLogica operacionLogica, Object param) {

 		operacionLogica.getLeft().accept(this, param);
 		operacionLogica.getRight().accept(this, param);
 		predicate(operacionLogica.getLeft().getType().getClass().equals(operacionLogica.getRight().getType().getClass()),
 				"Los tipos tienen que ser iguales en una operación lógica",
 				operacionLogica);
 		predicate(operacionLogica.getLeft().getType().getClass().equals(IntType.class) &&
 				operacionLogica.getRight().getType().getClass().equals(IntType.class),
 				"Los tipos tienen que ser enteros en una operación lógica",
 				operacionLogica);
 		operacionLogica.setType(new IntType());
 		operacionLogica.setLvalue(false);
 		return null;
 	}

 	// class Comparacion(Expr left, String operador, Expr right)
 	@Override
 	public Object visit(Comparacion comparacion, Object param) {
 		comparacion.getLeft().accept(this, param);
 		comparacion.getRight().accept(this, param);
 		predicate(!(comparacion.getLeft().getType().getClass().equals(CharType.class) || comparacion.getRight().getType().getClass().equals(CharType.class)),
 				"Ni operando izquierdo ni el derecho pueden ser de tipo char",
 				comparacion);
 		predicate(comparacion.getLeft().getType().getClass().equals(comparacion.getRight().getType().getClass()),
 				"Los tipos tienen que ser iguales en una operación aritmética",
 				comparacion);
 		
 		comparacion.setLvalue(false);
 		comparacion.setType(new IntType());

 		return null;
 	}

 	// class FunctionCall(String nombre, List<Expr> exprs)
 	// phase Identification { Function function }
 	@Override
 	public Object visit(FunctionCall functionCall, Object param) {
 		functionCall.getExprs().forEach(expr -> expr.accept(this, param));
 		
 		if(predicate(functionCall.getExprs().size()==functionCall.getFunction().parametros().count(),
 				"El número de parametros que se le pasan a la llamada de la función no son los mismos que se especificaron en su declaración",
 				functionCall)) {
 			for(int i=0; i<functionCall.getFunction().parametros().count();i++) {
 			predicate(functionCall.getExprs().get(i).getType().getClass().equals(functionCall.getFunction().parametros().skip(i).findFirst().get().getTipo().getClass()),
 	 				"El tipo del parámetro que se le pasa no es el mismo que se había declarado:"+functionCall.getFunction().parametros().skip(i).findFirst().get().getTipo(),
 	 				functionCall);
 		}
 		}
 		
 		predicate(!functionCall.getFunction().getTipoRetorno().getClass().equals(VoidType.class),
 				"Una llamada a función que es una expresión no puede devolver void",
 				functionCall);
 		functionCall.setType(functionCall.getFunction().getTipoRetorno());
 		functionCall.setLvalue(false);

 		return null;
 	}

 	// class Parentesis(Expr expr)
 	@Override
 	public Object visit(Parentesis parentesis, Object param) {
 		super.visit(parentesis, param);
 		parentesis.setLvalue(false);
 		parentesis.setType(parentesis.getExpr().getType());
 		// parentesis.getExpr().accept(this, param);
 		

 		return null;
 	}

 	// class Variable(String nombre)
 	// phase Identification { Declaracion declaracion }
 	@Override
 	public Object visit(Variable variable, Object param) {
 		variable.setType(variable.getDeclaracion().getTipo());
 		variable.setLvalue(true);
 		return null;
 	}

 	// class IntLiteral(int intValue)
 	@Override
 	public Object visit(IntLiteral intLiteral, Object param) {
 		intLiteral.setType(new IntType());
 		intLiteral.setLvalue(false);
 		return null;
 	}

 	// class RealLiteral(float floatValue)
 	@Override
 	public Object visit(RealLiteral realLiteral, Object param) {
 		realLiteral.setType(new FloatType());
 		realLiteral.setLvalue(false);
 		return null;
 	}

 	// class CharLiteral(char charValue)
 	@Override
 	public Object visit(CharLiteral charLiteral, Object param) {
 		charLiteral.setType(new CharType());
 		charLiteral.setLvalue(false);
 		return null;
 	}

 	// class IntType()
 	@Override
 	public Object visit(IntType intType, Object param) {

 		return null;
 	}

 	// class FloatType()
 	@Override
 	public Object visit(FloatType floatType, Object param) {

 		return null;
 	}

 	// class CharType()
 	@Override
 	public Object visit(CharType charType, Object param) {

 		return null;
 	}

 	// class VoidType()
 	@Override
 	public Object visit(VoidType voidType, Object param) {

 		return null;
 	}

 	// class ArrayType(Tipo tipoBase, int intValue)
 	@Override
 	public Object visit(ArrayType arrayType, Object param) {

 		// arrayType.getTipoBase().accept(this, param);
 		super.visit(arrayType, param);

 		return null;
 	}

 	// class NomType(String nombre)
 	// phase Identification { StructDefinition structDefinition }
 	@Override
 	public Object visit(NomType nomType, Object param) {
 		return null;
 	}

    //# ----------------------------------------------------------
    //# Auxiliary methods (optional)

    private void notifyError(String errorMessage, Position position) {
        errorManager.notify("Type Checking", errorMessage, position);
    }

    private void notifyError(String msg) {
        errorManager.notify("Type Checking", msg);
    }

    /**
     * predicate. Auxiliary method to implement predicates. Delete if not needed.
     *
     * Usage examples:
     *
     *    predicate(expr.type != null), "Type cannot be null", expr.start());
     *
     *    predicate(expr.type != null), "Type cannot be null", expr);       // expr.start() is assumed
     *
     * The start() method (example 1) indicates the position in the file where the node was. If VGen is used, this method
     * will have been generated in all AST nodes.
     *
     * @param condition     Must be met to avoid an error
     * @param errorMessage  Printed if the condition is not met
     * @param errorPosition Row and column in the file where the error occurred.
     * @return true if the condition is met
     */

    private boolean predicate(boolean condition, String errorMessage, Position position) {
        if (!condition) {
            notifyError(errorMessage, position);
            return false;
        }

        return true;
    }

    private boolean predicate(boolean condition, String errorMessage, AST node) {
        return predicate(condition, errorMessage, node.start());
    }
    
    private boolean checkSipleType(Tipo type) {
    	return type.getClass().equals(IntType.class) || type.getClass().equals(CharType.class) || type.getClass().equals(FloatType.class);
	}
    private boolean sameType(Tipo type, Tipo type2) {
		return type.getClass().equals(type2.getClass());
		
		
	}

}

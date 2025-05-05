// Generated with VGen 2.0.0

/*

Este fichero es un esqueleto para facilitar la implementación de una gramática atribuida
('ATTRIBUTE GRAMMAR' de VGen). Para usarlo hay que realizar dos pasos:
1. Ubicar este código.
2. Completar cada método visit.

## Paso 1. Ubicación de este Código

Este esqueleto será SOBREESCRITO la próxima vez que se ejecuta VGen. Por ello, se debe
copiar su contenido antes de hacer cualquier cambio.

Hay dos opciones:

1) Si ya se tiene hecha una clase para el visitor, basta con copiar a dicha clase los
   métodos visit de este esqueleto (y los import) ignorando el resto.

2) Si no se tiene hecha aún la clase, este esqueleto vale como tal si se mueve a la
   carpeta deseada del proyecto y se le pone el package correspondiente a dicha
   ubicación.

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

2. Si se necesita hacer alguna tarea adicional ANTES o DESPUÉS de recorrer todos los
   hijos, se debe añadir su código antes o después de la llamada a 'super.visit' (y se
   pueden borrar los 'accept' comentados).

3. Y, finalmente, si se necesita hacer alguna tarea INTERCALADA en el recorrido de los
   hijos (por ejemplo, comprobar su tipo), se debe borrar el 'super.visit' y descomentar
   los 'accept'. Así se tendría ya implementado el recorrido de los hijos, que es la
   estructura donde se intecalará el código de las acciones adicionales.

NOTA 1. En los visit en los que haya que inicializar atributos heredados de los hijos
antes de recorrerlos, se han añadido recordatorios en los puntos en los que es
aconsejable hacerlo.

NOTA 2. En los visit de los nodos que tengan atributos sintetizados, se han añadido
recordatorios de que se deben inicializar dichos atributos.

*/

// TODO: write package name
// package ...;

import visitor.DefaultVisitor;
import ast.*;
import ast.cuerpoprograma.*;
import ast.statement.*;
import ast.expr.*;
import ast.tipo.*;


public class TypeChecking extends DefaultVisitor {

    public void process(AST ast) {
        ast.accept(this, null);
    }

    // Visit Methods --------------------------------------------------------------

	// class Program(List<CuerpoPrograma> cuerpoProgramas)
	@Override
	public Object visit(Program program, Object param) {

		// program.getCuerpoProgramas().forEach(cuerpoPrograma -> cuerpoPrograma.accept(this, param));
		super.visit(program, param);

		return null;
	}

	// class StructDefinition(String nombre, List<VarDefinition> atributos, List<Function> metodos)
	@Override
	public Object visit(StructDefinition structDefinition, Object param) {

		// structDefinition.getAtributos().forEach(varDefinition -> varDefinition.accept(this, param));
		// structDefinition.getMetodos().forEach(function -> function.accept(this, param));
		super.visit(structDefinition, param);

		return null;
	}

	// class VarDefinition(Declaracion declaracion)
	@Override
	public Object visit(VarDefinition varDefinition, Object param) {

		// varDefinition.getDeclaracion().accept(this, param);
		super.visit(varDefinition, param);

		return null;
	}

	// class Declaracion(String nombre, Tipo tipo)
	@Override
	public Object visit(Declaracion declaracion, Object param) {

		// declaracion.getTipo().accept(this, param);
		super.visit(declaracion, param);

		return null;
	}

	// class Function(String nombre, List<Declaracion> parametros, List<VarDefinition> variables, Tipo tipoRetorno, List<Statement> cuerpo)
	@Override
	public Object visit(Function function, Object param) {

		for (var statement : function.getCuerpo()) {
			// TODO: Remember to initialize INHERITED attributes <----
			// statement.setPadre(?);
		}

		// function.getParametros().forEach(declaracion -> declaracion.accept(this, param));
		// function.getVariables().forEach(varDefinition -> varDefinition.accept(this, param));
		// function.getTipoRetorno().accept(this, param);
		// function.getCuerpo().forEach(statement -> statement.accept(this, param));
		super.visit(function, param);

		return null;
	}

	// class Print(List<Expr> exprs)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(Print print, Object param) {

		// print.getExprs().forEach(expr -> expr.accept(this, param));
		super.visit(print, param);

		return null;
	}

	// class PrintSp(List<Expr> exprs)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(PrintSp printSp, Object param) {

		// printSp.getExprs().forEach(expr -> expr.accept(this, param));
		super.visit(printSp, param);

		return null;
	}

	// class PrintLn(List<Expr> exprs)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(PrintLn printLn, Object param) {

		// printLn.getExprs().forEach(expr -> expr.accept(this, param));
		super.visit(printLn, param);

		return null;
	}

	// class Asignacion(Expr left, Expr right)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(Asignacion asignacion, Object param) {

		// asignacion.getLeft().accept(this, param);
		// asignacion.getRight().accept(this, param);
		super.visit(asignacion, param);

		return null;
	}

	// class Return(Optional<Expr> expr)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(Return returnValue, Object param) {

		// returnValue.getExpr().ifPresent(expr -> expr.accept(this, param));
		super.visit(returnValue, param);

		return null;
	}

	// class If(Expr condition, List<Statement> thenBlock, List<Statement> elseBlock)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(If ifValue, Object param) {

		for (var statement : ifValue.getThenBlock()) {
			// TODO: Remember to initialize INHERITED attributes <----
			// statement.setPadre(ifValue.getPadre());
		}

		for (var statement : ifValue.getElseBlock()) {
			// TODO: Remember to initialize INHERITED attributes <----
			// statement.setPadre(ifValue.getPadre());
		}

		// ifValue.getCondition().accept(this, param);
		// ifValue.getThenBlock().forEach(statement -> statement.accept(this, param));
		// ifValue.getElseBlock().forEach(statement -> statement.accept(this, param));
		super.visit(ifValue, param);

		return null;
	}

	// class While(Expr condition, List<Statement> body)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(While whileValue, Object param) {

		for (var statement : whileValue.getBody()) {
			// TODO: Remember to initialize INHERITED attributes <----
			// statement.setPadre(whileValue.getPadre());
		}

		// whileValue.getCondition().accept(this, param);
		// whileValue.getBody().forEach(statement -> statement.accept(this, param));
		super.visit(whileValue, param);

		return null;
	}

	// class Read(Expr expr)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(Read read, Object param) {

		// read.getExpr().accept(this, param);
		super.visit(read, param);

		return null;
	}

	// class StmtFunctionCall(String nombre, List<Expr> exprs)
	// phase Identification { Function function }
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(StmtFunctionCall stmtFunctionCall, Object param) {

		// stmtFunctionCall.getExprs().forEach(expr -> expr.accept(this, param));
		super.visit(stmtFunctionCall, param);

		return null;
	}

	// class FieldAccess(Expr object, String field)
	// phase TypeChecking { Tipo type, boolean lvalue, StructDefinition structAccedido }
	@Override
	public Object visit(FieldAccess fieldAccess, Object param) {

		// fieldAccess.getObject().accept(this, param);
		super.visit(fieldAccess, param);

		// TODO: Remember to initialize SYNTHESIZED attributes <-----
		// fieldAccess.setType(?);
		// fieldAccess.setLvalue(?);
		// fieldAccess.setStructAccedido(?);
		return null;
	}

	// class ArrayAccess(Expr array, Expr index)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(ArrayAccess arrayAccess, Object param) {

		// arrayAccess.getArray().accept(this, param);
		// arrayAccess.getIndex().accept(this, param);
		super.visit(arrayAccess, param);

		// TODO: Remember to initialize SYNTHESIZED attributes <-----
		// arrayAccess.setType(?);
		// arrayAccess.setLvalue(?);
		return null;
	}

	// class Cast(Tipo tipo, Expr target)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(Cast cast, Object param) {

		// cast.getTipo().accept(this, param);
		// cast.getTarget().accept(this, param);
		super.visit(cast, param);

		// TODO: Remember to initialize SYNTHESIZED attributes <-----
		// cast.setType(?);
		// cast.setLvalue(?);
		return null;
	}

	// class Not(Expr expr)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(Not not, Object param) {

		// not.getExpr().accept(this, param);
		super.visit(not, param);

		// TODO: Remember to initialize SYNTHESIZED attributes <-----
		// not.setType(?);
		// not.setLvalue(?);
		return null;
	}

	// class OperacionAritmetica(Expr left, String operador, Expr right)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(OperacionAritmetica operacionAritmetica, Object param) {

		// operacionAritmetica.getLeft().accept(this, param);
		// operacionAritmetica.getRight().accept(this, param);
		super.visit(operacionAritmetica, param);

		// TODO: Remember to initialize SYNTHESIZED attributes <-----
		// operacionAritmetica.setType(?);
		// operacionAritmetica.setLvalue(?);
		return null;
	}

	// class OperacionLogica(Expr left, String operador, Expr right)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(OperacionLogica operacionLogica, Object param) {

		// operacionLogica.getLeft().accept(this, param);
		// operacionLogica.getRight().accept(this, param);
		super.visit(operacionLogica, param);

		// TODO: Remember to initialize SYNTHESIZED attributes <-----
		// operacionLogica.setType(?);
		// operacionLogica.setLvalue(?);
		return null;
	}

	// class Comparacion(Expr left, String operador, Expr right)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(Comparacion comparacion, Object param) {

		// comparacion.getLeft().accept(this, param);
		// comparacion.getRight().accept(this, param);
		super.visit(comparacion, param);

		// TODO: Remember to initialize SYNTHESIZED attributes <-----
		// comparacion.setType(?);
		// comparacion.setLvalue(?);
		return null;
	}

	// class FunctionCall(String nombre, List<Expr> exprs)
	// phase Identification { Function function }
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(FunctionCall functionCall, Object param) {

		// functionCall.getExprs().forEach(expr -> expr.accept(this, param));
		super.visit(functionCall, param);

		// TODO: Remember to initialize SYNTHESIZED attributes <-----
		// functionCall.setType(?);
		// functionCall.setLvalue(?);
		return null;
	}

	// class Parentesis(Expr expr)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(Parentesis parentesis, Object param) {

		// parentesis.getExpr().accept(this, param);
		super.visit(parentesis, param);

		// TODO: Remember to initialize SYNTHESIZED attributes <-----
		// parentesis.setType(?);
		// parentesis.setLvalue(?);
		return null;
	}

	// class Variable(String nombre)
	// phase Identification { Declaracion declaracion }
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(Variable variable, Object param) {

		// TODO: Remember to initialize SYNTHESIZED attributes <-----
		// variable.setType(?);
		// variable.setLvalue(?);
		return null;
	}

	// class IntLiteral(int intValue)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(IntLiteral intLiteral, Object param) {

		// TODO: Remember to initialize SYNTHESIZED attributes <-----
		// intLiteral.setType(?);
		// intLiteral.setLvalue(?);
		return null;
	}

	// class RealLiteral(float floatValue)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(RealLiteral realLiteral, Object param) {

		// TODO: Remember to initialize SYNTHESIZED attributes <-----
		// realLiteral.setType(?);
		// realLiteral.setLvalue(?);
		return null;
	}

	// class CharLiteral(String name)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(CharLiteral charLiteral, Object param) {

		// TODO: Remember to initialize SYNTHESIZED attributes <-----
		// charLiteral.setType(?);
		// charLiteral.setLvalue(?);
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

}

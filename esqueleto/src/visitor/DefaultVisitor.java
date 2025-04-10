// Generated with VGen 2.0.0

/**
* El objetivo de esta clase DefaultVisitor es ser la implementación base de la que
* deriven todos los demás visitor.
*
* Sus métodos visit recorren los hijos del nodo que se está visitando. Por tanto,
* todo visitor que derive de este ya tendrá implementado todo el código de
* recorrido del AST.
*
* Para crear nuevos visitor, en vez de modificar esta clase, se recomienda copiar
* 'SkeletonForNewVisitors.java' o, mejor aún, definir una nueva PHASE en la gramática
* y usar el visitor generado para la misma.
*/

package visitor;

import ast.*;
import ast.cuerpoprograma.*;
import ast.statement.*;
import ast.expr.*;
import ast.tipo.*;




public class DefaultVisitor implements Visitor {
	@Override
	public Object visit(Program program, Object param) {

		program.getCuerpoProgramas().forEach(cuerpoPrograma -> cuerpoPrograma.accept(this, param));
		return null;
	}

	@Override
	public Object visit(StructDefinition structDefinition, Object param) {

		structDefinition.getAtributos().forEach(varDefinition -> varDefinition.accept(this, param));
		structDefinition.getMetodos().forEach(function -> function.accept(this, param));
		return null;
	}

	@Override
	public Object visit(VarDefinition varDefinition, Object param) {

		varDefinition.getDeclaracion().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Declaracion declaracion, Object param) {

		declaracion.getTipo().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Function function, Object param) {

		function.getParametros().forEach(declaracion -> declaracion.accept(this, param));
		function.getTipoRetorno().accept(this, param);
		function.getCuerpo().forEach(statement -> statement.accept(this, param));
		return null;
	}

	@Override
	public Object visit(Print print, Object param) {

		print.getExprs().forEach(expr -> expr.accept(this, param));
		return null;
	}

	@Override
	public Object visit(PrintSp printSp, Object param) {

		printSp.getExprs().forEach(expr -> expr.accept(this, param));
		return null;
	}

	@Override
	public Object visit(PrintLn printLn, Object param) {

		printLn.getExprs().forEach(expr -> expr.accept(this, param));
		return null;
	}

	@Override
	public Object visit(Asignacion asignacion, Object param) {

		asignacion.getLeft().accept(this, param);
		asignacion.getRight().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Return returnValue, Object param) {

		returnValue.getExpr().ifPresent(expr -> expr.accept(this, param));
		return null;
	}

	@Override
	public Object visit(OneExpr oneExpr, Object param) {

		oneExpr.getExpr().accept(this, param);
		return null;
	}

	@Override
	public Object visit(If ifValue, Object param) {

		ifValue.getCondition().accept(this, param);
		ifValue.getThenBlock().forEach(statement -> statement.accept(this, param));
		ifValue.getElseBlock().forEach(statement -> statement.accept(this, param));
		return null;
	}

	@Override
	public Object visit(While whileValue, Object param) {

		whileValue.getCondition().accept(this, param);
		whileValue.getBody().forEach(statement -> statement.accept(this, param));
		return null;
	}

	@Override
	public Object visit(Read read, Object param) {

		read.getExpr().accept(this, param);
		return null;
	}

	@Override
	public Object visit(StmtFunctionCall stmtFunctionCall, Object param) {

		stmtFunctionCall.getExprs().forEach(expr -> expr.accept(this, param));
		return null;
	}

	@Override
	public Object visit(FieldAccess fieldAccess, Object param) {

		fieldAccess.getObject().accept(this, param);
		return null;
	}

	@Override
	public Object visit(ArrayAccess arrayAccess, Object param) {

		arrayAccess.getArray().accept(this, param);
		arrayAccess.getIndex().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Cast cast, Object param) {

		cast.getTipo().accept(this, param);
		cast.getTarget().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Not not, Object param) {

		not.getExpr().accept(this, param);
		return null;
	}

	@Override
	public Object visit(OperacionAritmetica operacionAritmetica, Object param) {

		operacionAritmetica.getLeft().accept(this, param);
		operacionAritmetica.getRight().accept(this, param);
		return null;
	}

	@Override
	public Object visit(OperacionLogica operacionLogica, Object param) {

		operacionLogica.getLeft().accept(this, param);
		operacionLogica.getRight().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Comparacion comparacion, Object param) {

		comparacion.getLeft().accept(this, param);
		comparacion.getRight().accept(this, param);
		return null;
	}

	@Override
	public Object visit(FunctionCall functionCall, Object param) {

		functionCall.getExprs().forEach(expr -> expr.accept(this, param));
		return null;
	}

	@Override
	public Object visit(Parentesis parentesis, Object param) {

		parentesis.getExpr().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Variable variable, Object param) {

		return null;
	}

	@Override
	public Object visit(IntLiteral intLiteral, Object param) {

		return null;
	}

	@Override
	public Object visit(RealLiteral realLiteral, Object param) {

		return null;
	}

	@Override
	public Object visit(CharLiteral charLiteral, Object param) {

		return null;
	}

	@Override
	public Object visit(IntType intType, Object param) {

		return null;
	}

	@Override
	public Object visit(FloatType floatType, Object param) {

		return null;
	}

	@Override
	public Object visit(CharType charType, Object param) {

		return null;
	}

	@Override
	public Object visit(VoidType voidType, Object param) {

		return null;
	}

	@Override
	public Object visit(ArrayType arrayType, Object param) {

		arrayType.getTipoBase().accept(this, param);
		return null;
	}

	@Override
	public Object visit(NomType nomType, Object param) {

		return null;
	}


}

// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.Declaracion;
import ast.cuerpoprograma.VarDefinition;
import ast.expr.ArrayAccess;
import ast.expr.Cast;
import ast.expr.CharLiteral;
import ast.expr.Comparacion;
import ast.expr.Expr;
import ast.expr.FieldAccess;
import ast.expr.FunctionCall;
import ast.expr.IntLiteral;
import ast.expr.Not;
import ast.expr.OperacionAritmetica;
import ast.expr.OperacionLogica;
import ast.expr.Parentesis;
import ast.expr.RealLiteral;
import ast.expr.Variable;
import ast.tipo.CharType;
import ast.tipo.FloatType;
import ast.tipo.IntType;
import ast.tipo.Tipo;
import ast.tipo.VoidType;
import codegeneration.mapl.AbstractCodeFunction;
import codegeneration.mapl.MaplCodeSpecification;

public class Valor extends AbstractCodeFunction {

	public Valor(MaplCodeSpecification specification) {
		super(specification);
	}

	// class FieldAccess(Expr object, String field)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(FieldAccess fieldAccess, Object param) {

		// EL OBJECT ES UNA MALA NOMINACIÓN QUE HICE NO OLVIDARME QUE NOOOOO ES UN
		// OBJECT DE VERDAD
		direccion(fieldAccess);
		out("load" + getFormatTipo(fieldAccess.getType()));
		return null;
	}

	// class ArrayAccess(Expr array, Expr index)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(ArrayAccess arrayAccess, Object param) {

		direccion(arrayAccess);
		out("load" + getFormatTipo(arrayAccess.getType()));
		return null;
	}

	// class Cast(Tipo tipo, Expr target)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(Cast cast, Object param) {

		valor(cast.getTarget());
		out(getFormatTipo(cast.getTarget().getType()) + "2" + getFormatTipo(cast.getTipo()));

		return null;
	}

	// class Not(Expr expr)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(Not not, Object param) {

		valor(not.getExpr());
		out("not");

		return null;
	}

	// class OperacionAritmetica(Expr left, String operador, Expr right)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(OperacionAritmetica operacionAritmetica, Object param) {

		valor(operacionAritmetica.getLeft());
		valor(operacionAritmetica.getRight());

		if (operacionAritmetica.getOperador().equals("+")) {
			out("add" + getFormatTipo(operacionAritmetica.getType()));
		} else if (operacionAritmetica.getOperador().equals("-")) {
			out("sub" + getFormatTipo(operacionAritmetica.getType()));
		} else if (operacionAritmetica.getOperador().equals("*")) {
			out("mul" + getFormatTipo(operacionAritmetica.getType()));
		} else if (operacionAritmetica.getOperador().equals("/")) {
			out("div" + getFormatTipo(operacionAritmetica.getType()));
		}

		return null;
	}

	// class OperacionLogica(Expr left, String operador, Expr right)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(OperacionLogica operacionLogica, Object param) {

		valor(operacionLogica.getLeft());
		valor(operacionLogica.getRight());

		if (operacionLogica.getOperador().equals("&&")) {
			out("and");
		} else if (operacionLogica.getOperador().equals("||")) {
			out("or");
		}

		return null;
	}

	// class Comparacion(Expr left, String operador, Expr right)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(Comparacion comparacion, Object param) {

		valor(comparacion.getLeft());
		valor(comparacion.getRight());
		if (comparacion.getOperador().equals("<")) {
			out("lt" + getFormatoMayorTipo(comparacion.getLeft().getType(), comparacion.getRight().getType()));
		} else if (comparacion.getOperador().equals(">")) {
			out("gt" + getFormatoMayorTipo(comparacion.getLeft().getType(), comparacion.getRight().getType()));
		} else if (comparacion.getOperador().equals("==")) {
			out("eq" + getFormatoMayorTipo(comparacion.getLeft().getType(), comparacion.getRight().getType()));
		} else if (comparacion.getOperador().equals("!=")) {
			out("nef" + getFormatoMayorTipo(comparacion.getLeft().getType(), comparacion.getRight().getType()));
		} else if (comparacion.getOperador().equals("<=")) {
			out("le" + getFormatoMayorTipo(comparacion.getLeft().getType(), comparacion.getRight().getType()));
		} else if (comparacion.getOperador().equals(">=")) {
			out("ge" + getFormatoMayorTipo(comparacion.getLeft().getType(), comparacion.getRight().getType()));
		}

		return null;
	}

	// class FunctionCall(String nombre, List<Expr> exprs)
	// phase Identification { Function function }
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(FunctionCall functionCall, Object param) {

		if(functionCall.getExprs().size()>0) {
			for(Expr e:functionCall.getExprs()) {
				valor(e);
			}
		}
		out("call "+functionCall.getNombre());

		return null;
	}

	// class Parentesis(Expr expr)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(Parentesis parentesis, Object param) {

		valor(parentesis.getExpr());
		return null;
	}

	// class Variable(String nombre)
	// phase Identification { Declaracion declaracion }
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(Variable variable, Object param) {

		direccion(variable);
		out("load" + getFormatTipo(variable.getType()));

		return null;
	}

	// class IntLiteral(int intValue)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(IntLiteral intLiteral, Object param) {
		out("pushi " + intLiteral.getIntValue());
		return null;
	}

	// class RealLiteral(float floatValue)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(RealLiteral realLiteral, Object param) {
		out("pushf " + realLiteral.getFloatValue());

		return null;
	}

	// class CharLiteral(char charValue)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(CharLiteral charLiteral, Object param) {
		out("pushb " + charLiteral.getCharValue());
		return null;
	}

	// Auxiliary methods for the generation of code
	private String getFormatTipo(Tipo tipo) {
		if (IntType.class.equals(tipo.getClass())) {
			return "i";
		} else if (FloatType.class.equals(tipo.getClass())) {
			return "f";
		} else if (CharType.class.equals(tipo.getClass())) {
			return "b";
		}
		return "";
	}

	private String getFormatoMayorTipo(Tipo type, Tipo tipo) {
		return type.getSize() > tipo.getSize() ? getFormatTipo(type) : getFormatTipo(tipo);
	}

}

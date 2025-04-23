// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.expr.*;
import codegeneration.mapl.*;


public class Valor extends AbstractCodeFunction {

    public Valor(MaplCodeSpecification specification) {
        super(specification);
    }


	// class FieldAccess(Expr object, String field)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(FieldAccess fieldAccess, Object param) {

		// valor(fieldAccess.getObject());
		// direccion(fieldAccess.getObject());

		out("<instruction>");

		return null;
	}

	// class ArrayAccess(Expr array, Expr index)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(ArrayAccess arrayAccess, Object param) {

		// valor(arrayAccess.getArray());
		// direccion(arrayAccess.getArray());

		// valor(arrayAccess.getIndex());
		// direccion(arrayAccess.getIndex());

		out("<instruction>");

		return null;
	}

	// class Cast(Tipo tipo, Expr target)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(Cast cast, Object param) {

		// valor(cast.getTarget());
		// direccion(cast.getTarget());

		out("<instruction>");

		return null;
	}

	// class Not(Expr expr)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(Not not, Object param) {

		// valor(not.getExpr());
		// direccion(not.getExpr());

		out("<instruction>");

		return null;
	}

	// class OperacionAritmetica(Expr left, String operador, Expr right)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(OperacionAritmetica operacionAritmetica, Object param) {

		// valor(operacionAritmetica.getLeft());
		// direccion(operacionAritmetica.getLeft());

		// valor(operacionAritmetica.getRight());
		// direccion(operacionAritmetica.getRight());

		out("<instruction>");

		return null;
	}

	// class OperacionLogica(Expr left, String operador, Expr right)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(OperacionLogica operacionLogica, Object param) {

		// valor(operacionLogica.getLeft());
		// direccion(operacionLogica.getLeft());

		// valor(operacionLogica.getRight());
		// direccion(operacionLogica.getRight());

		out("<instruction>");

		return null;
	}

	// class Comparacion(Expr left, String operador, Expr right)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(Comparacion comparacion, Object param) {

		// valor(comparacion.getLeft());
		// direccion(comparacion.getLeft());

		// valor(comparacion.getRight());
		// direccion(comparacion.getRight());

		out("<instruction>");

		return null;
	}

	// class FunctionCall(String nombre, List<Expr> exprs)
	// phase Identification { Function function }
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(FunctionCall functionCall, Object param) {

		// valor(functionCall.exprs());
		// direccion(functionCall.exprs());

		out("<instruction>");

		return null;
	}

	// class Parentesis(Expr expr)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(Parentesis parentesis, Object param) {

		// valor(parentesis.getExpr());
		// direccion(parentesis.getExpr());

		out("<instruction>");

		return null;
	}

	// class Variable(String nombre)
	// phase Identification { Declaracion declaracion }
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(Variable variable, Object param) {

		out("<instruction>");

		return null;
	}

	// class IntLiteral(int intValue)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(IntLiteral intLiteral, Object param) {

		out("<instruction>");

		return null;
	}

	// class RealLiteral(float floatValue)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(RealLiteral realLiteral, Object param) {

		out("<instruction>");

		return null;
	}

	// class CharLiteral(char charValue)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(CharLiteral charLiteral, Object param) {

		out("<instruction>");

		return null;
	}

}

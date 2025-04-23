// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.statement.*;
import codegeneration.mapl.*;


public class Ejecuta extends AbstractCodeFunction {

    public Ejecuta(MaplCodeSpecification specification) {
        super(specification);
    }


	// class Print(List<Expr> exprs)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(Print print, Object param) {

		// valor(print.exprs());
		// direccion(print.exprs());

		out("<instruction>");

		return null;
	}

	// class PrintSp(List<Expr> exprs)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(PrintSp printSp, Object param) {

		// valor(printSp.exprs());
		// direccion(printSp.exprs());

		out("<instruction>");

		return null;
	}

	// class PrintLn(List<Expr> exprs)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(PrintLn printLn, Object param) {

		// valor(printLn.exprs());
		// direccion(printLn.exprs());

		out("<instruction>");

		return null;
	}

	// class Asignacion(Expr left, Expr right)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(Asignacion asignacion, Object param) {

		// valor(asignacion.getLeft());
		// direccion(asignacion.getLeft());

		// valor(asignacion.getRight());
		// direccion(asignacion.getRight());

		out("<instruction>");

		return null;
	}

	// class Return(Optional<Expr> expr)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(Return returnValue, Object param) {

		// valor(returnValue.getExpr());
		// direccion(returnValue.getExpr());

		out("<instruction>");

		return null;
	}

	// class OneExpr(Expr expr)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(OneExpr oneExpr, Object param) {

		// valor(oneExpr.getExpr());
		// direccion(oneExpr.getExpr());

		out("<instruction>");

		return null;
	}

	// class If(Expr condition, List<Statement> thenBlock, List<Statement> elseBlock)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(If ifValue, Object param) {

		// valor(ifValue.getCondition());
		// direccion(ifValue.getCondition());

		// ejecuta(ifValue.thenBlock());

		// ejecuta(ifValue.elseBlock());

		out("<instruction>");

		return null;
	}

	// class While(Expr condition, List<Statement> body)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(While whileValue, Object param) {

		// valor(whileValue.getCondition());
		// direccion(whileValue.getCondition());

		// ejecuta(whileValue.body());

		out("<instruction>");

		return null;
	}

	// class Read(Expr expr)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(Read read, Object param) {

		// valor(read.getExpr());
		// direccion(read.getExpr());

		out("<instruction>");

		return null;
	}

	// class StmtFunctionCall(String nombre, List<Expr> exprs)
	// phase Identification { Function function }
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(StmtFunctionCall stmtFunctionCall, Object param) {

		// valor(stmtFunctionCall.exprs());
		// direccion(stmtFunctionCall.exprs());

		out("<instruction>");

		return null;
	}

}

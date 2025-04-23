// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import java.util.List;

import ast.AST;
import ast.Position;
import ast.expr.Expr;
import ast.statement.*;
import ast.tipo.CharType;
import ast.tipo.FloatType;
import ast.tipo.IntType;
import ast.tipo.Tipo;
import codegeneration.mapl.*;


public class Ejecuta extends AbstractCodeFunction {

    public Ejecuta(MaplCodeSpecification specification) {
        super(specification);
    }


	// class Print(List<Expr> exprs)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(Print print, Object param) {
		line(print);
		for(Expr e:print.getExprs()) {
			valor(e);
			out("out"+getFormatTipo(e.getType()));
		}
		

		return null;
	}

	


	// class PrintSp(List<Expr> exprs)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(PrintSp printSp, Object param) {

		line(printSp);
		for(Expr e:printSp.getExprs()) {
			valor(e);
			out("out"+getFormatTipo(e.getType()));
			out("pushb 32");
			out("outb");
			
		}
		

		return null;
	}

	// class PrintLn(List<Expr> exprs)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(PrintLn printLn, Object param) {

		line(printLn);
		for(Expr e:printLn.getExprs()) {
			valor(e);
			out("out"+getFormatTipo(e.getType()));
			out("pushb 10");
			out("outb");
			
		}
		return null;
	}

	// class Asignacion(Expr left, Expr right)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(Asignacion asignacion, Object param) {
		line(asignacion);
		
		direccion(asignacion.getLeft());
		valor(asignacion.getRight());

		out("store"+getFormatTipo(asignacion.getLeft().getType()));

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
	
	// Auxiliary methods for the generation of code

    private void line(AST node) {
        line(node.end());
    }

    private void line(Position pos) {
        if (pos != null)
            out("\n#line " + pos.getLine());
        else
            System.out.println("#line no generado. Se ha pasado una Position null. Falta información en el AST");
    }
    private String getFormatTipo(Tipo tipo) {
		if(IntType.class.equals(tipo.getClass())) {
			return "h";
		}else if(FloatType.class.equals(tipo.getClass())) {
			return "f";
		}else if(CharType.class.equals(tipo.getClass())) {
			return "b";
		}
		return "";
	}

}

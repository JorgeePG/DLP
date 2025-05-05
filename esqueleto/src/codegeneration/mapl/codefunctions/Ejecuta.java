// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;


import ast.AST;
import ast.Declaracion;
import ast.Position;
import ast.cuerpoprograma.VarDefinition;
import ast.expr.Expr;
import ast.statement.*;
import ast.tipo.CharType;
import ast.tipo.FloatType;
import ast.tipo.IntType;
import ast.tipo.Tipo;
import ast.tipo.VoidType;
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
		line(returnValue);
		valor(returnValue.getExpr());
		
		int totalVarSize=0;
		for(VarDefinition v:returnValue.getPadre().getVariables()) {
			totalVarSize+=v.getDeclaracion().getTipo().getSize();
		}
		int totalParamSize=0;
		for(Declaracion d:returnValue.getPadre().getParametros()) {
			totalParamSize+=d.getTipo().getSize();
		}
		if(!returnValue.getPadre().getTipoRetorno().getClass().equals(VoidType.class)) {
			out("ret "+returnValue.getPadre().getTipoRetorno().getSize()+", "+totalVarSize+", "+totalParamSize);
		}else {
			out("ret 0, "+totalVarSize+", "+totalParamSize);
		}
		
		return null;
	}

	// class If(Expr condition, List<Statement> thenBlock, List<Statement> elseBlock)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(If ifValue, Object param) {
		line(ifValue);
		String elseLabel="else_block"+contadorUnico++;
		String finLabel="if_end_label"+contadorUnico++;
		
		valor(ifValue.getCondition());
		out("jz "+elseLabel);
		// Procesar thenBlock (sin recursión)
	    for (Statement stmt : ifValue.thenBlock().toList()) {
	    	ejecuta(stmt);
	    }
		out("jmp "+finLabel);
		//Etiqueta para el bloque del else
		out(elseLabel+":");
		if (ifValue.elseBlock() != null) {
			for (Statement stmt : ifValue.elseBlock().toList()) {
				//System.out.println(stmt.toString());
				ejecuta(stmt);
	        }
		}
		out(finLabel+":");

		return null;
	}

	// class While(Expr condition, List<Statement> body)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(While whileValue, Object param) {
		line(whileValue);
		String startLabel = "while_start_" +contadorUnico++;
	    String endLabel = "while_end_" +contadorUnico++;
	    
	    out(startLabel + ":");
	    valor(whileValue.getCondition());
	    out("jz " + endLabel);
	    
	    // Procesar el cuerpo del while (sin recursión)
	    for (Statement stmt : whileValue.getBody()) {
	    	ejecuta(stmt);
	    }
	    
	    out("jmp " + startLabel);
	    out(endLabel + ":");
	    return null;
	}

	// class Read(Expr expr)
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(Read read, Object param) {

		line(read);
		
		direccion(read.getExpr());
		out("in"+getFormatTipo(read.getExpr().getType()));
		out("store"+getFormatTipo(read.getExpr().getType()));

		return null;
	}

	// class StmtFunctionCall(String nombre, List<Expr> exprs)
	// phase Identification { Function function }
	// phase TypeChecking { Function padre }
	@Override
	public Object visit(StmtFunctionCall stmtFunctionCall, Object param) {
		line(stmtFunctionCall);
		if(stmtFunctionCall.getExprs().size()>0) {
			for(Expr e:stmtFunctionCall.getExprs()) {
				valor(e);
			}
		}
		out("call "+stmtFunctionCall.getNombre());
		if(!stmtFunctionCall.getFunction().getTipoRetorno().getClass().equals(VoidType.class)) {
			out("pop"+getFormatTipo(stmtFunctionCall.getFunction().getTipoRetorno()));
		}
		return null;
	}
	
	// Auxiliary methods for the generation of code

	private int contadorUnico=0;
	
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
			return "i";
		}else if(FloatType.class.equals(tipo.getClass())) {
			return "f";
		}else if(CharType.class.equals(tipo.getClass())) {
			return "b";
		}
		return "";
	}
    

}

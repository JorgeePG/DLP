// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.AST;
import ast.Declaracion;
import ast.Position;
import ast.cuerpoprograma.VarDefinition;
import ast.expr.*;
import ast.tipo.CharType;
import ast.tipo.FloatType;
import ast.tipo.IntType;
import ast.tipo.Tipo;
import ast.tipo.VoidType;
import codegeneration.mapl.*;


public class Valor extends AbstractCodeFunction {

    public Valor(MaplCodeSpecification specification) {
        super(specification);
    }


	// class FieldAccess(Expr object, String field)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(FieldAccess fieldAccess, Object param) {

		//EL OBJECT ES UNA MALA NOMINACIÓN QUE HICE NO OLVIDARME QUE NOOOOO ES UN OBJECT DE VERDAD
		direccion(fieldAccess);
		out("load"+ getFormatTipo(fieldAccess.getType()));
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
		out(getFormatTipo(cast.getTarget().getType())+"2"+getFormatTipo(cast.getTipo()));
		
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

		if(operacionAritmetica.getOperador().equals("+")) {
			out("add"+getFormatTipo(operacionAritmetica.getType()));
		}else if(operacionAritmetica.getOperador().equals("-")) {
			out("sub"+getFormatTipo(operacionAritmetica.getType()));
		}else if(operacionAritmetica.getOperador().equals("*")) {
			out("mul"+getFormatTipo(operacionAritmetica.getType()));
		}else if(operacionAritmetica.getOperador().equals("/")) {
			out("div"+getFormatTipo(operacionAritmetica.getType()));
		}

		return null;
	}

	// class OperacionLogica(Expr left, String operador, Expr right)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(OperacionLogica operacionLogica, Object param) {

		valor(operacionLogica.getLeft());
		valor(operacionLogica.getRight());

		if(operacionLogica.getOperador().equals("&&")) {
			out("and");
		}else if(operacionLogica.getOperador().equals("||")) {
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
		if(comparacion.getOperador().equals("<")) {
			out("lt" + getFormatoMayorTipo(comparacion.getLeft().getType(),comparacion.getRight().getType()));
		}else if(comparacion.getOperador().equals(">")) {
			out("gt"+ getFormatoMayorTipo(comparacion.getLeft().getType(),comparacion.getRight().getType()));
		}else if(comparacion.getOperador().equals("==")) {
			out("eq"+ getFormatoMayorTipo(comparacion.getLeft().getType(),comparacion.getRight().getType()));
		}else if(comparacion.getOperador().equals("!=")) {
			out("nef"+getFormatoMayorTipo(comparacion.getLeft().getType(),comparacion.getRight().getType()));
		}else if(comparacion.getOperador().equals("<=")) {
			out("le"+ getFormatoMayorTipo(comparacion.getLeft().getType(),comparacion.getRight().getType()));
		}else if(comparacion.getOperador().equals(">=")) {
			out("ge"+ getFormatoMayorTipo(comparacion.getLeft().getType(),comparacion.getRight().getType()));
		}

		return null;
	}

	


	// class FunctionCall(String nombre, List<Expr> exprs)
	// phase Identification { Function function }
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(FunctionCall functionCall, Object param) {

		// define(function.parametros());
				out(functionCall.getNombre()+":");
				out("#func "+functionCall.getNombre());
				ejecuta(functionCall.getFunction().cuerpo());
				int totalVarSize=0;
				for(VarDefinition v:functionCall.getFunction().getVariables()) {
					totalVarSize+=v.getDeclaracion().getTipo().getSize();
				}
				int totalParamSize=0;
				for(Declaracion d:functionCall.getFunction().getParametros()) {
					totalParamSize+=d.getTipo().getSize();
				}
				if(!functionCall.getFunction().getTipoRetorno().getClass().equals(VoidType.class)) {
					out("ret "+functionCall.getFunction().getTipoRetorno().getSize()+", "+totalVarSize+", "+totalParamSize);
				}else {
					out("ret 0, "+totalVarSize+", "+totalParamSize);
				}
				
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
		out("pushi "+intLiteral.getIntValue());
		return null;
	}

	// class RealLiteral(float floatValue)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(RealLiteral realLiteral, Object param) {
		out("pushf "+realLiteral.getFloatValue());

		return null;
	}

	// class CharLiteral(char charValue)
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(CharLiteral charLiteral, Object param) {
		out("pushc "+charLiteral.getCharValue());
		return null;
	}
	
	// Auxiliary methods for the generation of code
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
    
    private String getFormatoMayorTipo(Tipo type, Tipo tipo) {	
		return type.getSize()>tipo.getSize()? getFormatTipo(type):getFormatTipo(tipo);
	}
    

}

package codegeneration;

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
import ast.statement.StmtVarDefinition;
import ast.statement.While;
import ast.tipo.ArrayType;
import ast.tipo.CharType;
import ast.tipo.FloatType;
import ast.tipo.IntType;
import ast.tipo.NomType;
import ast.tipo.VoidType;
import visitor.DefaultVisitor;

// This class will be implemented in memory allocation phase

public class MemoryAllocation extends DefaultVisitor {

    public void process(AST ast) {
        ast.accept(this, null);
    }
    
    // Visit Methods --------------------------------------------------------------

 // class Program(List<CuerpoPrograma> cuerpoProgramas)
 	@Override
 	public Object visit(Program program, Object param) {
 		int address=0;
 		for (var cuerpoPrograma : program.getCuerpoProgramas()) {
 			//Sacamos las variables globales y les damos una dirección de memoria.
 			if(cuerpoPrograma.getClass().equals(VarDefinition.class)) {
 				VarDefinition v= (VarDefinition)cuerpoPrograma;
 				cuerpoPrograma.setAddress(address);
 				address += v.getDeclaracion().getTipo().getSize();
 				System.out.println("Variable: "+v.getDeclaracion().getNombre()+" - dirección: "+cuerpoPrograma.getAddress());
 			}
 			
 		}
 		super.visit(program, param);

 		return null;
 	}

  	// class StructDefinition(String nombre, List<VarDefinition> atributos, List<Function> metodos)
  	@Override
  	public Object visit(StructDefinition structDefinition, Object param) {
  		int address=0;
  		//Guardamos la dirección de las definiciones de variables.
  		for(VarDefinition v:structDefinition.getAtributos()) {
  			v.getDeclaracion().setAddress(address);
  			address+=v.getDeclaracion().getTipo().getSize();
  			System.out.println("Variable: "+v.getDeclaracion().getNombre()+" - dirección: "+v.getDeclaracion().getAddress());
  			v.accept(this, param);
  			
  		}
  		
  		structDefinition.getMetodos().forEach(function -> function.accept(this, param));

  		return null;
  	}

  	// class Function(String nombre, List<Declaracion> parametros, Tipo tipoRetorno, List<Statement> cuerpo)
  	@Override
  	public Object visit(Function function, Object param) {
  		int address=4;//Empieza en 4 para saltarse el BP y lo otro.
  		for(int i = function.getParametros().size()-1;i>=0;i--) { //Tiene que ir al revés ya que se apilan de derecha a izquierda
  			Declaracion declaracion= function.getParametros().get(i);
  			declaracion.setAddress(address);
  			System.out.println("Variable: "+declaracion.getNombre()+" - dirección: "+declaracion.getAddress());
  			declaracion.accept(this, param);
  			address+=declaracion.getTipo().getSize();
  		}
  		address=0;//Acuerdate que aqí va al revés
  		for (var statement : function.getCuerpo()) {
  			if(statement.getClass().isInstance(Declaracion.class)) {
  				Declaracion declaracion= (Declaracion)statement;
  				declaracion.setAddress(-1*(address+declaracion.getTipo().getSize()));
  				System.out.println("Variable: "+declaracion.getNombre()+" - dirección: "+declaracion.getAddress());
  				statement.accept(this, param);
  	  			address-=declaracion.getTipo().getSize();
  			}else {
  				statement.accept(this, param);
  			}
  			
  		}
  		function.getTipoRetorno().accept(this, param);
  		
  		return null;
  	}

  	// class If(Expr condition, List<Statement> thenBlock, List<Statement> elseBlock)
  	// phase TypeChecking { Function padre }
  	@Override
  	public Object visit(If ifValue, Object param) {

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

  	// class StmtVarDefinition(Declaracion declaracion)
  	// phase TypeChecking { Function padre }
  	@Override
  	public Object visit(StmtVarDefinition stmtVarDefinition, Object param) {

  		// TODO: Remember to initialize INHERITED attributes <----
  		// stmtVarDefinition.getDeclaracion().setAddress(?);

  		// stmtVarDefinition.getDeclaracion().accept(this, param);
  		super.visit(stmtVarDefinition, param);

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
  	// phase TypeChecking { Tipo type, boolean lvalue }
  	@Override
  	public Object visit(FieldAccess fieldAccess, Object param) {

  		// fieldAccess.getObject().accept(this, param);
  		super.visit(fieldAccess, param);

  		return null;
  	}

  	// class ArrayAccess(Expr array, Expr index)
  	// phase TypeChecking { Tipo type, boolean lvalue }
  	@Override
  	public Object visit(ArrayAccess arrayAccess, Object param) {

  		// arrayAccess.getArray().accept(this, param);
  		// arrayAccess.getIndex().accept(this, param);
  		super.visit(arrayAccess, param);

  		return null;
  	}

  	// class Cast(Tipo tipo, Expr target)
  	// phase TypeChecking { Tipo type, boolean lvalue }
  	@Override
  	public Object visit(Cast cast, Object param) {

  		// cast.getTipo().accept(this, param);
  		// cast.getTarget().accept(this, param);
  		super.visit(cast, param);

  		return null;
  	}

  	// class Not(Expr expr)
  	// phase TypeChecking { Tipo type, boolean lvalue }
  	@Override
  	public Object visit(Not not, Object param) {

  		// not.getExpr().accept(this, param);
  		super.visit(not, param);

  		return null;
  	}

  	// class OperacionAritmetica(Expr left, String operador, Expr right)
  	// phase TypeChecking { Tipo type, boolean lvalue }
  	@Override
  	public Object visit(OperacionAritmetica operacionAritmetica, Object param) {

  		// operacionAritmetica.getLeft().accept(this, param);
  		// operacionAritmetica.getRight().accept(this, param);
  		super.visit(operacionAritmetica, param);

  		return null;
  	}

  	// class OperacionLogica(Expr left, String operador, Expr right)
  	// phase TypeChecking { Tipo type, boolean lvalue }
  	@Override
  	public Object visit(OperacionLogica operacionLogica, Object param) {

  		// operacionLogica.getLeft().accept(this, param);
  		// operacionLogica.getRight().accept(this, param);
  		super.visit(operacionLogica, param);

  		return null;
  	}

  	// class Comparacion(Expr left, String operador, Expr right)
  	// phase TypeChecking { Tipo type, boolean lvalue }
  	@Override
  	public Object visit(Comparacion comparacion, Object param) {

  		// comparacion.getLeft().accept(this, param);
  		// comparacion.getRight().accept(this, param);
  		super.visit(comparacion, param);

  		return null;
  	}

  	// class FunctionCall(String nombre, List<Expr> exprs)
  	// phase Identification { Function function }
  	// phase TypeChecking { Tipo type, boolean lvalue }
  	@Override
  	public Object visit(FunctionCall functionCall, Object param) {

  		// functionCall.getExprs().forEach(expr -> expr.accept(this, param));
  		super.visit(functionCall, param);

  		return null;
  	}

  	// class Parentesis(Expr expr)
  	// phase TypeChecking { Tipo type, boolean lvalue }
  	@Override
  	public Object visit(Parentesis parentesis, Object param) {

  		// parentesis.getExpr().accept(this, param);
  		super.visit(parentesis, param);

  		return null;
  	}

  	// class Variable(String nombre)
  	// phase Identification { Declaracion declaracion }
  	// phase TypeChecking { Tipo type, boolean lvalue }
  	@Override
  	public Object visit(Variable variable, Object param) {

  		return null;
  	}

  	// class IntLiteral(int intValue)
  	// phase TypeChecking { Tipo type, boolean lvalue }
  	@Override
  	public Object visit(IntLiteral intLiteral, Object param) {

  		return null;
  	}

  	// class RealLiteral(float floatValue)
  	// phase TypeChecking { Tipo type, boolean lvalue }
  	@Override
  	public Object visit(RealLiteral realLiteral, Object param) {

  		return null;
  	}

  	// class CharLiteral(char charValue)
  	// phase TypeChecking { Tipo type, boolean lvalue }
  	@Override
  	public Object visit(CharLiteral charLiteral, Object param) {

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

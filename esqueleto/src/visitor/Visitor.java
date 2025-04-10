// Generated with VGen 2.0.0

/**
* Este interfaz es el resultado de la aplicación del patrón Visitor a los nodos del AST.
*/

package visitor;

import ast.*;
import ast.cuerpoprograma.*;
import ast.statement.*;
import ast.expr.*;
import ast.tipo.*;




public interface Visitor {
	public Object visit(Program program, Object param);

	public Object visit(StructDefinition structDefinition, Object param);

	public Object visit(VarDefinition varDefinition, Object param);

	public Object visit(Declaracion declaracion, Object param);

	public Object visit(Function function, Object param);

	public Object visit(Print print, Object param);

	public Object visit(PrintSp printSp, Object param);

	public Object visit(PrintLn printLn, Object param);

	public Object visit(Asignacion asignacion, Object param);

	public Object visit(Return returnValue, Object param);

	public Object visit(OneExpr oneExpr, Object param);

	public Object visit(If ifValue, Object param);

	public Object visit(While whileValue, Object param);

	public Object visit(Read read, Object param);

	public Object visit(StmtFunctionCall stmtFunctionCall, Object param);

	public Object visit(FieldAccess fieldAccess, Object param);

	public Object visit(ArrayAccess arrayAccess, Object param);

	public Object visit(Cast cast, Object param);

	public Object visit(Not not, Object param);

	public Object visit(OperacionAritmetica operacionAritmetica, Object param);

	public Object visit(OperacionLogica operacionLogica, Object param);

	public Object visit(Comparacion comparacion, Object param);

	public Object visit(FunctionCall functionCall, Object param);

	public Object visit(Parentesis parentesis, Object param);

	public Object visit(Variable variable, Object param);

	public Object visit(IntLiteral intLiteral, Object param);

	public Object visit(RealLiteral realLiteral, Object param);

	public Object visit(CharLiteral charLiteral, Object param);

	public Object visit(IntType intType, Object param);

	public Object visit(FloatType floatType, Object param);

	public Object visit(CharType charType, Object param);

	public Object visit(VoidType voidType, Object param);

	public Object visit(ArrayType arrayType, Object param);

	public Object visit(NomType nomType, Object param);


}

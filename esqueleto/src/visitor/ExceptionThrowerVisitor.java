// Generated with VGen 2.0.0

/**
* Visitor del que derivar cuando se quiera que todo visit no redefinido lance
* una excepción si es invocado.
*
*/

package visitor;

import ast.*;
import ast.cuerpoprograma.*;
import ast.statement.*;
import ast.expr.*;
import ast.tipo.*;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------


public class ExceptionThrowerVisitor implements Visitor {
	@Override
	public Object visit(Program program, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Program)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(StructDefinition structDefinition, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(StructDefinition)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(VarDefinition varDefinition, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(VarDefinition)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Declaracion declaracion, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Declaracion)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Function function, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Function)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Print print, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Print)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(PrintSp printSp, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(PrintSp)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(PrintLn printLn, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(PrintLn)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Asignacion asignacion, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Asignacion)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Return returnValue, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Return)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(OneExpr oneExpr, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(OneExpr)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(If ifValue, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(If)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(While whileValue, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(While)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Read read, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Read)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(StmtVarDefinition stmtVarDefinition, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(StmtVarDefinition)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(StmtFunctionCall stmtFunctionCall, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(StmtFunctionCall)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(FieldAccess fieldAccess, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(FieldAccess)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(ArrayAccess arrayAccess, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(ArrayAccess)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Cast cast, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Cast)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Not not, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Not)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(OperacionAritmetica operacionAritmetica, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(OperacionAritmetica)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(OperacionLogica operacionLogica, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(OperacionLogica)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Comparacion comparacion, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Comparacion)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(FunctionCall functionCall, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(FunctionCall)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Parentesis parentesis, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Parentesis)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Variable variable, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Variable)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(IntLiteral intLiteral, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(IntLiteral)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(RealLiteral realLiteral, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(RealLiteral)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(CharLiteral charLiteral, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(CharLiteral)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(IntType intType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(IntType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(FloatType floatType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(FloatType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(CharType charType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(CharType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(VoidType voidType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(VoidType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(ArrayType arrayType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(ArrayType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(NomType nomType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(NomType)' has been invoked but it has not been implemented.");
	}

    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

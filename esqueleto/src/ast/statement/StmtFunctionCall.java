// Generated with VGen 2.0.0

package ast.statement;

import ast.expr.*;
import ast.cuerpoprograma.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	stmtFunctionCall: statement -> nombre:string exprs:expr*
	statement -> 
	
	PHASE Identification
	stmtFunctionCall -> function:function
	
	PHASE TypeChecking
	statement -> padre:function
*/
public class StmtFunctionCall extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// stmtFunctionCall: statement -> nombre:string expr*
	private String nombre;
	private List<Expr> exprs;

    // PHASE Identification
	private Function function;

    // ----------------------------------
    // Constructors

	public StmtFunctionCall(String nombre, List<Expr> exprs) {
		super();

		if (nombre == null)
			throw new IllegalArgumentException("Parameter 'nombre' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.nombre = nombre;

		if (exprs == null)
			exprs = new ArrayList<>();
		this.exprs = exprs;

		updatePositions(nombre, exprs);
	}

	public StmtFunctionCall(Object nombre, Object exprs) {
		super();

        if (nombre == null)
            throw new IllegalArgumentException("Parameter 'nombre' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.nombre = (nombre instanceof Token) ? ((Token) nombre).getText() : (String) nombre;

        this.exprs = castList(exprs, unwrapIfContext.andThen(Expr.class::cast));
		updatePositions(nombre, exprs);
	}


    // ----------------------------------
    // stmtFunctionCall: statement -> nombre:string expr*

	// Child 'nombre:string' 

	public void setNombre(String nombre) {
		if (nombre == null)
			throw new IllegalArgumentException("Parameter 'nombre' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.nombre = nombre;

	}

    public String getNombre() {
        return nombre;
    }


	// Child 'expr*' 

	public void setExprs(List<Expr> exprs) {
		if (exprs == null)
			exprs = new ArrayList<>();
		this.exprs = exprs;

	}

    public List<Expr> getExprs() {
        return exprs;
    }

    public Stream<Expr> exprs() {
        return exprs.stream();
    }



    // --------------------------------
    // PHASE Identification

	// Attribute 'function' 

	public void setFunction(Function function) {
		if (function == null)
			throw new IllegalArgumentException("Parameter 'function' can't be null. Pass a non-null value or use 'function?' in the abstract grammar");
		this.function = function;

	}

    public Function getFunction() {
        return function;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "StmtFunctionCall{" + " nombre=" + this.getNombre() + " exprs=" + this.getExprs() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

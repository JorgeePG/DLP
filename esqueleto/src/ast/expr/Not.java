// Generated with VGen 2.0.0

package ast.expr;

import ast.tipo.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	not: expr -> expr:expr
	expr -> 
	
	PHASE TypeChecking
	expr -> type:tipo
	expr -> lvalue:boolean
*/
public class Not extends AbstractExpr  {

    // ----------------------------------
    // Instance Variables

	// not: expr -> expr
	private Expr expr;

    // ----------------------------------
    // Constructors

	public Not(Expr expr) {
		super();

		if (expr == null)
			throw new IllegalArgumentException("Parameter 'expr' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.expr = expr;

		updatePositions(expr);
	}

	public Not(Object expr) {
		super();

        if (expr == null)
            throw new IllegalArgumentException("Parameter 'expr' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.expr = (Expr) expr;

		updatePositions(expr);
	}


    // ----------------------------------
    // not: expr -> expr

	// Child 'expr' 

	public void setExpr(Expr expr) {
		if (expr == null)
			throw new IllegalArgumentException("Parameter 'expr' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.expr = expr;

	}

    public Expr getExpr() {
        return expr;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Not{" + " expr=" + this.getExpr() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

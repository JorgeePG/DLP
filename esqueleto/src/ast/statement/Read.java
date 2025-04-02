// Generated with VGen 2.0.0

package ast.statement;

import ast.expr.*;
import ast.cuerpoprograma.*;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	read: statement -> expr:expr
	statement -> 
	
	PHASE TypeChecking
	statement -> padre:function
*/
public class Read extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// read: statement -> expr
	private Expr expr;

    // ----------------------------------
    // Constructors

	public Read(Expr expr) {
		super();

		if (expr == null)
			throw new IllegalArgumentException("Parameter 'expr' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.expr = expr;

		updatePositions(expr);
	}

	public Read(Object expr) {
		super();

        if (expr == null)
            throw new IllegalArgumentException("Parameter 'expr' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.expr = (Expr) expr;

		updatePositions(expr);
	}


    // ----------------------------------
    // read: statement -> expr

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
        return "Read{" + " expr=" + this.getExpr() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

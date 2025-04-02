// Generated with VGen 2.0.0

package ast.statement;

import ast.expr.*;
import ast.cuerpoprograma.*;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	asignacion: statement -> left:expr right:expr
	statement -> 
	
	PHASE TypeChecking
	statement -> padre:function
*/
public class Asignacion extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// asignacion: statement -> left:expr right:expr
	private Expr left;
	private Expr right;

    // ----------------------------------
    // Constructors

	public Asignacion(Expr left, Expr right) {
		super();

		if (left == null)
			throw new IllegalArgumentException("Parameter 'left' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.left = left;

		if (right == null)
			throw new IllegalArgumentException("Parameter 'right' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.right = right;

		updatePositions(left, right);
	}

	public Asignacion(Object left, Object right) {
		super();

        if (left == null)
            throw new IllegalArgumentException("Parameter 'left' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.left = (Expr) left;

        if (right == null)
            throw new IllegalArgumentException("Parameter 'right' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.right = (Expr) right;

		updatePositions(left, right);
	}


    // ----------------------------------
    // asignacion: statement -> left:expr right:expr

	// Child 'left:expr' 

	public void setLeft(Expr left) {
		if (left == null)
			throw new IllegalArgumentException("Parameter 'left' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.left = left;

	}

    public Expr getLeft() {
        return left;
    }


	// Child 'right:expr' 

	public void setRight(Expr right) {
		if (right == null)
			throw new IllegalArgumentException("Parameter 'right' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.right = right;

	}

    public Expr getRight() {
        return right;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Asignacion{" + " left=" + this.getLeft() + " right=" + this.getRight() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

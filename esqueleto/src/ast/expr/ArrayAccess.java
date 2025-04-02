// Generated with VGen 2.0.0

package ast.expr;

import ast.tipo.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	arrayAccess: expr -> array:expr index:expr
	expr -> 
	
	PHASE TypeChecking
	expr -> type:tipo
	expr -> lvalue:boolean
*/
public class ArrayAccess extends AbstractExpr  {

    // ----------------------------------
    // Instance Variables

	// arrayAccess: expr -> array:expr index:expr
	private Expr array;
	private Expr index;

    // ----------------------------------
    // Constructors

	public ArrayAccess(Expr array, Expr index) {
		super();

		if (array == null)
			throw new IllegalArgumentException("Parameter 'array' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.array = array;

		if (index == null)
			throw new IllegalArgumentException("Parameter 'index' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.index = index;

		updatePositions(array, index);
	}

	public ArrayAccess(Object array, Object index) {
		super();

        if (array == null)
            throw new IllegalArgumentException("Parameter 'array' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.array = (Expr) array;

        if (index == null)
            throw new IllegalArgumentException("Parameter 'index' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.index = (Expr) index;

		updatePositions(array, index);
	}


    // ----------------------------------
    // arrayAccess: expr -> array:expr index:expr

	// Child 'array:expr' 

	public void setArray(Expr array) {
		if (array == null)
			throw new IllegalArgumentException("Parameter 'array' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.array = array;

	}

    public Expr getArray() {
        return array;
    }


	// Child 'index:expr' 

	public void setIndex(Expr index) {
		if (index == null)
			throw new IllegalArgumentException("Parameter 'index' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.index = index;

	}

    public Expr getIndex() {
        return index;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "ArrayAccess{" + " array=" + this.getArray() + " index=" + this.getIndex() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

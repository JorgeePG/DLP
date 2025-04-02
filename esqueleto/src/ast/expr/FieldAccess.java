// Generated with VGen 2.0.0

package ast.expr;

import ast.tipo.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	fieldAccess: expr -> object:expr field:string
	expr -> 
	
	PHASE TypeChecking
	expr -> type:tipo
	expr -> lvalue:boolean
*/
public class FieldAccess extends AbstractExpr  {

    // ----------------------------------
    // Instance Variables

	// fieldAccess: expr -> object:expr field:string
	private Expr object;
	private String field;

    // ----------------------------------
    // Constructors

	public FieldAccess(Expr object, String field) {
		super();

		if (object == null)
			throw new IllegalArgumentException("Parameter 'object' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.object = object;

		if (field == null)
			throw new IllegalArgumentException("Parameter 'field' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.field = field;

		updatePositions(object, field);
	}

	public FieldAccess(Object object, Object field) {
		super();

        if (object == null)
            throw new IllegalArgumentException("Parameter 'object' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.object = (Expr) object;

        if (field == null)
            throw new IllegalArgumentException("Parameter 'field' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.field = (field instanceof Token) ? ((Token) field).getText() : (String) field;

		updatePositions(object, field);
	}


    // ----------------------------------
    // fieldAccess: expr -> object:expr field:string

	// Child 'object:expr' 

	public void setObject(Expr object) {
		if (object == null)
			throw new IllegalArgumentException("Parameter 'object' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.object = object;

	}

    public Expr getObject() {
        return object;
    }


	// Child 'field:string' 

	public void setField(String field) {
		if (field == null)
			throw new IllegalArgumentException("Parameter 'field' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.field = field;

	}

    public String getField() {
        return field;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "FieldAccess{" + " object=" + this.getObject() + " field=" + this.getField() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

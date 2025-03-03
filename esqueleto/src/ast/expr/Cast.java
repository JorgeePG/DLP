// Generated with VGen 2.0.0

package ast.expr;

import ast.tipo.*;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	cast: expr -> tipo:tipo target:expr
	expr -> 
*/
public class Cast extends AbstractExpr  {

    // ----------------------------------
    // Instance Variables

	// cast: expr -> tipo:tipo target:expr
	private Tipo tipo;
	private Expr target;

    // ----------------------------------
    // Constructors

	public Cast(Tipo tipo, Expr target) {
		super();

		if (tipo == null)
			throw new IllegalArgumentException("Parameter 'tipo' can't be null. Pass a non-null value or use 'tipo?' in the abstract grammar");
		this.tipo = tipo;

		if (target == null)
			throw new IllegalArgumentException("Parameter 'target' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.target = target;

		updatePositions(tipo, target);
	}

	public Cast(Object tipo, Object target) {
		super();

        if (tipo == null)
            throw new IllegalArgumentException("Parameter 'tipo' can't be null. Pass a non-null value or use 'tipo?' in the abstract grammar");
		this.tipo = (Tipo) tipo;

        if (target == null)
            throw new IllegalArgumentException("Parameter 'target' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.target = (Expr) target;

		updatePositions(tipo, target);
	}


    // ----------------------------------
    // cast: expr -> tipo:tipo target:expr

	// Child 'tipo:tipo' 

	public void setTipo(Tipo tipo) {
		if (tipo == null)
			throw new IllegalArgumentException("Parameter 'tipo' can't be null. Pass a non-null value or use 'tipo?' in the abstract grammar");
		this.tipo = tipo;

	}

    public Tipo getTipo() {
        return tipo;
    }


	// Child 'target:expr' 

	public void setTarget(Expr target) {
		if (target == null)
			throw new IllegalArgumentException("Parameter 'target' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.target = target;

	}

    public Expr getTarget() {
        return target;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Cast{" + " tipo=" + this.getTipo() + " target=" + this.getTarget() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

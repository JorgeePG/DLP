// Generated with VGen 2.0.0

package ast.tipo;

import ast.expr.*;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	arrayType: tipo -> tipoBase:tipo size:expr
	tipo -> 
*/
public class ArrayType extends AbstractTipo  {

    // ----------------------------------
    // Instance Variables

	// arrayType: tipo -> tipoBase:tipo size:expr
	private Tipo tipoBase;
	private Expr size;

    // ----------------------------------
    // Constructors

	public ArrayType(Tipo tipoBase, Expr size) {
		super();

		if (tipoBase == null)
			throw new IllegalArgumentException("Parameter 'tipoBase' can't be null. Pass a non-null value or use 'tipo?' in the abstract grammar");
		this.tipoBase = tipoBase;

		if (size == null)
			throw new IllegalArgumentException("Parameter 'size' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.size = size;

		updatePositions(tipoBase, size);
	}

	public ArrayType(Object tipoBase, Object size) {
		super();

        if (tipoBase == null)
            throw new IllegalArgumentException("Parameter 'tipoBase' can't be null. Pass a non-null value or use 'tipo?' in the abstract grammar");
		this.tipoBase = (Tipo) tipoBase;

        if (size == null)
            throw new IllegalArgumentException("Parameter 'size' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.size = (Expr) size;

		updatePositions(tipoBase, size);
	}


    // ----------------------------------
    // arrayType: tipo -> tipoBase:tipo size:expr

	// Child 'tipoBase:tipo' 

	public void setTipoBase(Tipo tipoBase) {
		if (tipoBase == null)
			throw new IllegalArgumentException("Parameter 'tipoBase' can't be null. Pass a non-null value or use 'tipo?' in the abstract grammar");
		this.tipoBase = tipoBase;

	}

    public Tipo getTipoBase() {
        return tipoBase;
    }


	// Child 'size:expr' 

	public void setSize(Expr size) {
		if (size == null)
			throw new IllegalArgumentException("Parameter 'size' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.size = size;

	}

    public Expr getSize() {
        return size;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "ArrayType{" + " tipoBase=" + this.getTipoBase() + " size=" + this.getSize() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

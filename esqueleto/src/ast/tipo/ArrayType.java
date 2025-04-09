// Generated with VGen 2.0.0

package ast.tipo;

import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	arrayType: tipo -> tipoBase:tipo intValue:int
	tipo -> 
*/
public class ArrayType extends AbstractTipo  {

    // ----------------------------------
    // Instance Variables

	// arrayType: tipo -> tipoBase:tipo int
	private Tipo tipoBase;
	private int intValue;

    // ----------------------------------
    // Constructors

	public ArrayType(Tipo tipoBase, int intValue) {
		super();

		if (tipoBase == null)
			throw new IllegalArgumentException("Parameter 'tipoBase' can't be null. Pass a non-null value or use 'tipo?' in the abstract grammar");
		this.tipoBase = tipoBase;

		this.intValue = intValue;

		updatePositions(tipoBase, intValue);
	}

	public ArrayType(Object tipoBase, Object intValue) {
		super();

        if (tipoBase == null)
            throw new IllegalArgumentException("Parameter 'tipoBase' can't be null. Pass a non-null value or use 'tipo?' in the abstract grammar");
		this.tipoBase = (Tipo) tipoBase;

        if (intValue == null)
            throw new IllegalArgumentException("Parameter 'intValue' can't be null. Pass a non-null value or use 'int?' in the abstract grammar");
        var intValue_temp = intValue;
        if (intValue_temp instanceof Token)
            intValue_temp = ((Token) intValue_temp).getText();
        if (intValue_temp instanceof String)
            intValue_temp = Integer.valueOf((String) intValue_temp);
        this.intValue = (int) intValue_temp;

		updatePositions(tipoBase, intValue);
	}


    // ----------------------------------
    // arrayType: tipo -> tipoBase:tipo int

	// Child 'tipoBase:tipo' 

	public void setTipoBase(Tipo tipoBase) {
		if (tipoBase == null)
			throw new IllegalArgumentException("Parameter 'tipoBase' can't be null. Pass a non-null value or use 'tipo?' in the abstract grammar");
		this.tipoBase = tipoBase;

	}

    public Tipo getTipoBase() {
        return tipoBase;
    }


	// Child 'int' 

	public void setIntValue(int intValue) {
		this.intValue = intValue;

	}

    public int getIntValue() {
        return intValue;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "ArrayType{" + " tipoBase=" + this.getTipoBase() + " intValue=" + this.getIntValue() + "}";
    }


    // %% User Members -------------------------

    @Override
	public int getSize() {
		return getTipoBase().getSize()*getIntValue();
	}

    // %% --------------------------------------
}

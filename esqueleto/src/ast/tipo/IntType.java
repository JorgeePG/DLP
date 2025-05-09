// Generated with VGen 2.0.0

package ast.tipo;

import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	intType: tipo -> 
	tipo -> 
*/
public class IntType extends AbstractTipo  {



    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "IntType{" + "}";
    }


    // %% User Members -------------------------
    @Override
	public int getSize() {
		return 2;
	}

    // %% --------------------------------------
}

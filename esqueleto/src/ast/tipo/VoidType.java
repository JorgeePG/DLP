// Generated with VGen 2.0.0

package ast.tipo;

import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	voidType: tipo -> 
	tipo -> 
*/
public class VoidType extends AbstractTipo  {



    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "VoidType{" + "}";
    }


    // %% User Members -------------------------

	    @Override
		public int getSize() {
			throw new IllegalAccessError("Nunca se debe de llamara al método getSize de un elemennto void");
		}

    // %% --------------------------------------
}

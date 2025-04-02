// Generated with VGen 2.0.0

package ast.statement;

import ast.*;
import ast.cuerpoprograma.*;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	statement -> 
	
	PHASE TypeChecking
	statement -> padre:function
*/
public abstract class AbstractStatement extends AbstractAST implements Statement {

    // ----------------------------------
    // Instance Variables


    // PHASE TypeChecking
	private Function padre;



    // --------------------------------
    // PHASE TypeChecking

	// Attribute 'padre:function' 

	public void setPadre(Function padre) {
		if (padre == null)
			throw new IllegalArgumentException("Parameter 'padre' can't be null. Pass a non-null value or use 'function?' in the abstract grammar");
		this.padre = padre;

	}

    public Function getPadre() {
        return padre;
    }



    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

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
public interface Statement extends AST {




    // --------------------------------
    // PHASE TypeChecking

	// Attribute 'padre:function' 

	public void setPadre(Function padre);
	public Function getPadre();


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

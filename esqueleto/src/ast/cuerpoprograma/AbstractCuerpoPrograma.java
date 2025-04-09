// Generated with VGen 2.0.0

package ast.cuerpoprograma;

import ast.*;
import org.antlr.v4.runtime.Token;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	cuerpoPrograma -> 
	
	PHASE MemoryAllocation
	cuerpoPrograma -> address:int
*/
public abstract class AbstractCuerpoPrograma extends AbstractAST implements CuerpoPrograma {

    // ----------------------------------
    // Instance Variables


    // PHASE MemoryAllocation
	private int address;



    // --------------------------------
    // PHASE MemoryAllocation

	// Attribute 'address:int' 

	public void setAddress(int address) {
		this.address = address;

	}

    public int getAddress() {
        return address;
    }



    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

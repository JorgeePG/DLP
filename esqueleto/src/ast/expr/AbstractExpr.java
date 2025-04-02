// Generated with VGen 2.0.0

package ast.expr;

import ast.*;
import ast.tipo.*;
import org.antlr.v4.runtime.Token;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	expr -> 
	
	PHASE TypeChecking
	expr -> type:tipo
	expr -> lvalue:boolean
*/
public abstract class AbstractExpr extends AbstractAST implements Expr {

    // ----------------------------------
    // Instance Variables


    // PHASE TypeChecking
	private Tipo type;
	private boolean lvalue;



    // --------------------------------
    // PHASE TypeChecking

	// Attribute 'type:tipo' 

	public void setType(Tipo type) {
		if (type == null)
			throw new IllegalArgumentException("Parameter 'type' can't be null. Pass a non-null value or use 'tipo?' in the abstract grammar");
		this.type = type;

	}

    public Tipo getType() {
        return type;
    }


	// Attribute 'lvalue:boolean' 

	public void setLvalue(boolean lvalue) {
		this.lvalue = lvalue;

	}

    public boolean isLvalue() {
        return lvalue;
    }



    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

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
public interface Expr extends AST {




    // --------------------------------
    // PHASE TypeChecking

	// Attribute 'type:tipo' 

	public void setType(Tipo type);
	public Tipo getType();

	// Attribute 'lvalue:boolean' 

	public void setLvalue(boolean lvalue);
	public boolean isLvalue();


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

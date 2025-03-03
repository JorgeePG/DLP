// Generated with VGen 2.0.0

package ast.statement;

import ast.*;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	stmtVarDefinition: statement -> declaracion:declaracion
	statement -> 
*/
public class StmtVarDefinition extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// stmtVarDefinition: statement -> declaracion
	private Declaracion declaracion;

    // ----------------------------------
    // Constructors

	public StmtVarDefinition(Declaracion declaracion) {
		super();

		if (declaracion == null)
			throw new IllegalArgumentException("Parameter 'declaracion' can't be null. Pass a non-null value or use 'declaracion?' in the abstract grammar");
		this.declaracion = declaracion;

		updatePositions(declaracion);
	}

	public StmtVarDefinition(Object declaracion) {
		super();

        if (declaracion == null)
            throw new IllegalArgumentException("Parameter 'declaracion' can't be null. Pass a non-null value or use 'declaracion?' in the abstract grammar");
		this.declaracion = (Declaracion) declaracion;

		updatePositions(declaracion);
	}


    // ----------------------------------
    // stmtVarDefinition: statement -> declaracion

	// Child 'declaracion' 

	public void setDeclaracion(Declaracion declaracion) {
		if (declaracion == null)
			throw new IllegalArgumentException("Parameter 'declaracion' can't be null. Pass a non-null value or use 'declaracion?' in the abstract grammar");
		this.declaracion = declaracion;

	}

    public Declaracion getDeclaracion() {
        return declaracion;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "StmtVarDefinition{" + " declaracion=" + this.getDeclaracion() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

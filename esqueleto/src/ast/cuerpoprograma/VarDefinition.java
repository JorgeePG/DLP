// Generated with VGen 2.0.0

package ast.cuerpoprograma;

import ast.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	varDefinition: cuerpoPrograma -> declaracion:declaracion
	cuerpoPrograma -> 
	
	PHASE MemoryAllocation
	cuerpoPrograma -> address:int
*/
public class VarDefinition extends AbstractCuerpoPrograma  {

    // ----------------------------------
    // Instance Variables

	// varDefinition: cuerpoPrograma -> declaracion
	private Declaracion declaracion;

    // ----------------------------------
    // Constructors

	public VarDefinition(Declaracion declaracion) {
		super();

		if (declaracion == null)
			throw new IllegalArgumentException("Parameter 'declaracion' can't be null. Pass a non-null value or use 'declaracion?' in the abstract grammar");
		this.declaracion = declaracion;

		updatePositions(declaracion);
	}

	public VarDefinition(Object declaracion) {
		super();

        if (declaracion == null)
            throw new IllegalArgumentException("Parameter 'declaracion' can't be null. Pass a non-null value or use 'declaracion?' in the abstract grammar");
		this.declaracion = (Declaracion) declaracion;

		updatePositions(declaracion);
	}


    // ----------------------------------
    // varDefinition: cuerpoPrograma -> declaracion

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
        return "VarDefinition{" + " declaracion=" + this.getDeclaracion() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

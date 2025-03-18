// Generated with VGen 2.0.0

package ast.expr;

import ast.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	variable: expr -> nombre:string
	expr -> 
	
	PHASE Identification
	variable -> declaracion:declaracion
*/
public class Variable extends AbstractExpr  {

    // ----------------------------------
    // Instance Variables

	// variable: expr -> nombre:string
	private String nombre;

    // PHASE Identification
	private Declaracion declaracion;

    // ----------------------------------
    // Constructors

	public Variable(String nombre) {
		super();

		if (nombre == null)
			throw new IllegalArgumentException("Parameter 'nombre' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.nombre = nombre;

		updatePositions(nombre);
	}

	public Variable(Object nombre) {
		super();

        if (nombre == null)
            throw new IllegalArgumentException("Parameter 'nombre' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.nombre = (nombre instanceof Token) ? ((Token) nombre).getText() : (String) nombre;

		updatePositions(nombre);
	}


    // ----------------------------------
    // variable: expr -> nombre:string

	// Child 'nombre:string' 

	public void setNombre(String nombre) {
		if (nombre == null)
			throw new IllegalArgumentException("Parameter 'nombre' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.nombre = nombre;

	}

    public String getNombre() {
        return nombre;
    }



    // --------------------------------
    // PHASE Identification

	// Attribute 'declaracion' 

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
        return "Variable{" + " nombre=" + this.getNombre() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

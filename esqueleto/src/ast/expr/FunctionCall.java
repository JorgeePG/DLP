// Generated with VGen 2.0.0

package ast.expr;

import ast.tipo.*;
import ast.cuerpoprograma.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	functionCall: expr -> nombre:string exprs:expr*
	expr -> 
	
	PHASE Identification
	functionCall -> function:function
	
	PHASE TypeChecking
	expr -> type:tipo
	expr -> lvalue:boolean
*/
public class FunctionCall extends AbstractExpr  {

    // ----------------------------------
    // Instance Variables

	// functionCall: expr -> nombre:string expr*
	private String nombre;
	private List<Expr> exprs;

    // PHASE Identification
	private Function function;

    // ----------------------------------
    // Constructors

	public FunctionCall(String nombre, List<Expr> exprs) {
		super();

		if (nombre == null)
			throw new IllegalArgumentException("Parameter 'nombre' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.nombre = nombre;

		if (exprs == null)
			exprs = new ArrayList<>();
		this.exprs = exprs;

		updatePositions(nombre, exprs);
	}

	public FunctionCall(Object nombre, Object exprs) {
		super();

        if (nombre == null)
            throw new IllegalArgumentException("Parameter 'nombre' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.nombre = (nombre instanceof Token) ? ((Token) nombre).getText() : (String) nombre;

        this.exprs = castList(exprs, unwrapIfContext.andThen(Expr.class::cast));
		updatePositions(nombre, exprs);
	}


    // ----------------------------------
    // functionCall: expr -> nombre:string expr*

	// Child 'nombre:string' 

	public void setNombre(String nombre) {
		if (nombre == null)
			throw new IllegalArgumentException("Parameter 'nombre' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.nombre = nombre;

	}

    public String getNombre() {
        return nombre;
    }


	// Child 'expr*' 

	public void setExprs(List<Expr> exprs) {
		if (exprs == null)
			exprs = new ArrayList<>();
		this.exprs = exprs;

	}

    public List<Expr> getExprs() {
        return exprs;
    }

    public Stream<Expr> exprs() {
        return exprs.stream();
    }



    // --------------------------------
    // PHASE Identification

	// Attribute 'function' 

	public void setFunction(Function function) {
		if (function == null)
			throw new IllegalArgumentException("Parameter 'function' can't be null. Pass a non-null value or use 'function?' in the abstract grammar");
		this.function = function;

	}

    public Function getFunction() {
        return function;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "FunctionCall{" + " nombre=" + this.getNombre() + " exprs=" + this.getExprs() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

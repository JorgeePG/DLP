// Generated with VGen 2.0.0

package ast.expr;

import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	operacionLogica: expr -> left:expr operador:string right:expr
	expr -> 
*/
public class OperacionLogica extends AbstractExpr  {

    // ----------------------------------
    // Instance Variables

	// operacionLogica: expr -> left:expr operador:string right:expr
	private Expr left;
	private String operador;
	private Expr right;

    // ----------------------------------
    // Constructors

	public OperacionLogica(Expr left, String operador, Expr right) {
		super();

		if (left == null)
			throw new IllegalArgumentException("Parameter 'left' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.left = left;

		if (operador == null)
			throw new IllegalArgumentException("Parameter 'operador' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.operador = operador;

		if (right == null)
			throw new IllegalArgumentException("Parameter 'right' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.right = right;

		updatePositions(left, operador, right);
	}

	public OperacionLogica(Object left, Object operador, Object right) {
		super();

        if (left == null)
            throw new IllegalArgumentException("Parameter 'left' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.left = (Expr) left;

        if (operador == null)
            throw new IllegalArgumentException("Parameter 'operador' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.operador = (operador instanceof Token) ? ((Token) operador).getText() : (String) operador;

        if (right == null)
            throw new IllegalArgumentException("Parameter 'right' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.right = (Expr) right;

		updatePositions(left, operador, right);
	}


    // ----------------------------------
    // operacionLogica: expr -> left:expr operador:string right:expr

	// Child 'left:expr' 

	public void setLeft(Expr left) {
		if (left == null)
			throw new IllegalArgumentException("Parameter 'left' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.left = left;

	}

    public Expr getLeft() {
        return left;
    }


	// Child 'operador:string' 

	public void setOperador(String operador) {
		if (operador == null)
			throw new IllegalArgumentException("Parameter 'operador' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.operador = operador;

	}

    public String getOperador() {
        return operador;
    }


	// Child 'right:expr' 

	public void setRight(Expr right) {
		if (right == null)
			throw new IllegalArgumentException("Parameter 'right' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.right = right;

	}

    public Expr getRight() {
        return right;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "OperacionLogica{" + " left=" + this.getLeft() + " operador=" + this.getOperador() + " right=" + this.getRight() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

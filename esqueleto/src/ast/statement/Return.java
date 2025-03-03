// Generated with VGen 2.0.0

package ast.statement;

import ast.expr.*;
import java.util.Optional;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	return: statement -> expr:expr?
	statement -> 
*/
public class Return extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// return: statement -> expr?
	private Optional<Expr> expr;

    // ----------------------------------
    // Constructors

	public Return(Optional<Expr> expr) {
		super();

		if (expr == null)
			expr = Optional.empty();
		this.expr = expr;

		updatePositions(expr);
	}

	public Return(Object expr) {
		super();

        this.expr = castOptional(expr, Expr.class);
		updatePositions(expr);
	}


    // ----------------------------------
    // return: statement -> expr?

	// Child 'expr?' 

	public void setExpr(Optional<Expr> expr) {
		if (expr == null)
			expr = Optional.empty();
		this.expr = expr;

	}

    public Optional<Expr> getExpr() {
        return expr;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Return{" + " expr=" + this.getExpr() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

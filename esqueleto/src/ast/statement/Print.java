// Generated with VGen 2.0.0

package ast.statement;

import ast.expr.*;
import ast.cuerpoprograma.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	print: statement -> exprs:expr*
	statement -> 
	
	PHASE TypeChecking
	statement -> padre:function
*/
public class Print extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// print: statement -> expr*
	private List<Expr> exprs;

    // ----------------------------------
    // Constructors

	public Print(List<Expr> exprs) {
		super();

		if (exprs == null)
			exprs = new ArrayList<>();
		this.exprs = exprs;

		updatePositions(exprs);
	}

	public Print(Object exprs) {
		super();

        this.exprs = castList(exprs, unwrapIfContext.andThen(Expr.class::cast));
		updatePositions(exprs);
	}


    // ----------------------------------
    // print: statement -> expr*

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


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Print{" + " exprs=" + this.getExprs() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

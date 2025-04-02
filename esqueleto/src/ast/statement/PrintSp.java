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
	printSp: statement -> exprs:expr*
	statement -> 
	
	PHASE TypeChecking
	statement -> padre:function
*/
public class PrintSp extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// printSp: statement -> expr*
	private List<Expr> exprs;

    // ----------------------------------
    // Constructors

	public PrintSp(List<Expr> exprs) {
		super();

		if (exprs == null)
			exprs = new ArrayList<>();
		this.exprs = exprs;

		updatePositions(exprs);
	}

	public PrintSp(Object exprs) {
		super();

        this.exprs = castList(exprs, unwrapIfContext.andThen(Expr.class::cast));
		updatePositions(exprs);
	}


    // ----------------------------------
    // printSp: statement -> expr*

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
        return "PrintSp{" + " exprs=" + this.getExprs() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

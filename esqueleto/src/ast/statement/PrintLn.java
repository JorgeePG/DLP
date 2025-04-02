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
	printLn: statement -> exprs:expr*
	statement -> 
	
	PHASE TypeChecking
	statement -> padre:function
*/
public class PrintLn extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// printLn: statement -> expr*
	private List<Expr> exprs;

    // ----------------------------------
    // Constructors

	public PrintLn(List<Expr> exprs) {
		super();

		if (exprs == null)
			exprs = new ArrayList<>();
		this.exprs = exprs;

		updatePositions(exprs);
	}

	public PrintLn(Object exprs) {
		super();

        this.exprs = castList(exprs, unwrapIfContext.andThen(Expr.class::cast));
		updatePositions(exprs);
	}


    // ----------------------------------
    // printLn: statement -> expr*

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
        return "PrintLn{" + " exprs=" + this.getExprs() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

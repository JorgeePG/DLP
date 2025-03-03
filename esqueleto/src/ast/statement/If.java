// Generated with VGen 2.0.0

package ast.statement;

import ast.expr.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	if: statement -> condition:expr thenBlock:statement* elseBlock:statement*
	statement -> 
*/
public class If extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// if: statement -> condition:expr thenBlock:statement* elseBlock:statement*
	private Expr condition;
	private List<Statement> thenBlock;
	private List<Statement> elseBlock;

    // ----------------------------------
    // Constructors

	public If(Expr condition, List<Statement> thenBlock, List<Statement> elseBlock) {
		super();

		if (condition == null)
			throw new IllegalArgumentException("Parameter 'condition' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.condition = condition;

		if (thenBlock == null)
			thenBlock = new ArrayList<>();
		this.thenBlock = thenBlock;

		if (elseBlock == null)
			elseBlock = new ArrayList<>();
		this.elseBlock = elseBlock;

		updatePositions(condition, thenBlock, elseBlock);
	}

	public If(Object condition, Object thenBlock, Object elseBlock) {
		super();

        if (condition == null)
            throw new IllegalArgumentException("Parameter 'condition' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.condition = (Expr) condition;

        this.thenBlock = castList(thenBlock, unwrapIfContext.andThen(Statement.class::cast));
        this.elseBlock = castList(elseBlock, unwrapIfContext.andThen(Statement.class::cast));
		updatePositions(condition, thenBlock, elseBlock);
	}


    // ----------------------------------
    // if: statement -> condition:expr thenBlock:statement* elseBlock:statement*

	// Child 'condition:expr' 

	public void setCondition(Expr condition) {
		if (condition == null)
			throw new IllegalArgumentException("Parameter 'condition' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.condition = condition;

	}

    public Expr getCondition() {
        return condition;
    }


	// Child 'thenBlock:statement*' 

	public void setThenBlock(List<Statement> thenBlock) {
		if (thenBlock == null)
			thenBlock = new ArrayList<>();
		this.thenBlock = thenBlock;

	}

    public List<Statement> getThenBlock() {
        return thenBlock;
    }

    public Stream<Statement> thenBlock() {
        return thenBlock.stream();
    }


	// Child 'elseBlock:statement*' 

	public void setElseBlock(List<Statement> elseBlock) {
		if (elseBlock == null)
			elseBlock = new ArrayList<>();
		this.elseBlock = elseBlock;

	}

    public List<Statement> getElseBlock() {
        return elseBlock;
    }

    public Stream<Statement> elseBlock() {
        return elseBlock.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "If{" + " condition=" + this.getCondition() + " thenBlock=" + this.getThenBlock() + " elseBlock=" + this.getElseBlock() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

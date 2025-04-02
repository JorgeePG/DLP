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
	while: statement -> condition:expr body:statement*
	statement -> 
	
	PHASE TypeChecking
	statement -> padre:function
*/
public class While extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// while: statement -> condition:expr body:statement*
	private Expr condition;
	private List<Statement> body;

    // ----------------------------------
    // Constructors

	public While(Expr condition, List<Statement> body) {
		super();

		if (condition == null)
			throw new IllegalArgumentException("Parameter 'condition' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.condition = condition;

		if (body == null)
			body = new ArrayList<>();
		this.body = body;

		updatePositions(condition, body);
	}

	public While(Object condition, Object body) {
		super();

        if (condition == null)
            throw new IllegalArgumentException("Parameter 'condition' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.condition = (Expr) condition;

        this.body = castList(body, unwrapIfContext.andThen(Statement.class::cast));
		updatePositions(condition, body);
	}


    // ----------------------------------
    // while: statement -> condition:expr body:statement*

	// Child 'condition:expr' 

	public void setCondition(Expr condition) {
		if (condition == null)
			throw new IllegalArgumentException("Parameter 'condition' can't be null. Pass a non-null value or use 'expr?' in the abstract grammar");
		this.condition = condition;

	}

    public Expr getCondition() {
        return condition;
    }


	// Child 'body:statement*' 

	public void setBody(List<Statement> body) {
		if (body == null)
			body = new ArrayList<>();
		this.body = body;

	}

    public List<Statement> getBody() {
        return body;
    }

    public Stream<Statement> body() {
        return body.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "While{" + " condition=" + this.getCondition() + " body=" + this.getBody() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

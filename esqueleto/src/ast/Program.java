// Generated with VGen 2.0.0

package ast;

import ast.cuerpoprograma.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	program -> cuerpoProgramas:cuerpoPrograma*
*/
public class Program extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// program -> cuerpoPrograma*
	private List<CuerpoPrograma> cuerpoProgramas;

    // ----------------------------------
    // Constructors

	public Program(List<CuerpoPrograma> cuerpoProgramas) {
		super();

		if (cuerpoProgramas == null)
			cuerpoProgramas = new ArrayList<>();
		this.cuerpoProgramas = cuerpoProgramas;

		updatePositions(cuerpoProgramas);
	}

	public Program(Object cuerpoProgramas) {
		super();

        this.cuerpoProgramas = castList(cuerpoProgramas, unwrapIfContext.andThen(CuerpoPrograma.class::cast));
		updatePositions(cuerpoProgramas);
	}


    // ----------------------------------
    // program -> cuerpoPrograma*

	// Child 'cuerpoPrograma*' 

	public void setCuerpoProgramas(List<CuerpoPrograma> cuerpoProgramas) {
		if (cuerpoProgramas == null)
			cuerpoProgramas = new ArrayList<>();
		this.cuerpoProgramas = cuerpoProgramas;

	}

    public List<CuerpoPrograma> getCuerpoProgramas() {
        return cuerpoProgramas;
    }

    public Stream<CuerpoPrograma> cuerpoProgramas() {
        return cuerpoProgramas.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Program{" + " cuerpoProgramas=" + this.getCuerpoProgramas() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

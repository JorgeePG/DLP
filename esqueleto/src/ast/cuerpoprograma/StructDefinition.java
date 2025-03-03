// Generated with VGen 2.0.0

package ast.cuerpoprograma;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	structDefinition: cuerpoPrograma -> nombre:string atributos:varDefinition* metodos:function*
	cuerpoPrograma -> 
*/
public class StructDefinition extends AbstractCuerpoPrograma  {

    // ----------------------------------
    // Instance Variables

	// structDefinition: cuerpoPrograma -> nombre:string atributos:varDefinition* metodos:function*
	private String nombre;
	private List<VarDefinition> atributos;
	private List<Function> metodos;

    // ----------------------------------
    // Constructors

	public StructDefinition(String nombre, List<VarDefinition> atributos, List<Function> metodos) {
		super();

		if (nombre == null)
			throw new IllegalArgumentException("Parameter 'nombre' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.nombre = nombre;

		if (atributos == null)
			atributos = new ArrayList<>();
		this.atributos = atributos;

		if (metodos == null)
			metodos = new ArrayList<>();
		this.metodos = metodos;

		updatePositions(nombre, atributos, metodos);
	}

	public StructDefinition(Object nombre, Object atributos, Object metodos) {
		super();

        if (nombre == null)
            throw new IllegalArgumentException("Parameter 'nombre' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.nombre = (nombre instanceof Token) ? ((Token) nombre).getText() : (String) nombre;

        this.atributos = castList(atributos, unwrapIfContext.andThen(VarDefinition.class::cast));
        this.metodos = castList(metodos, unwrapIfContext.andThen(Function.class::cast));
		updatePositions(nombre, atributos, metodos);
	}


    // ----------------------------------
    // structDefinition: cuerpoPrograma -> nombre:string atributos:varDefinition* metodos:function*

	// Child 'nombre:string' 

	public void setNombre(String nombre) {
		if (nombre == null)
			throw new IllegalArgumentException("Parameter 'nombre' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.nombre = nombre;

	}

    public String getNombre() {
        return nombre;
    }


	// Child 'atributos:varDefinition*' 

	public void setAtributos(List<VarDefinition> atributos) {
		if (atributos == null)
			atributos = new ArrayList<>();
		this.atributos = atributos;

	}

    public List<VarDefinition> getAtributos() {
        return atributos;
    }

    public Stream<VarDefinition> atributos() {
        return atributos.stream();
    }


	// Child 'metodos:function*' 

	public void setMetodos(List<Function> metodos) {
		if (metodos == null)
			metodos = new ArrayList<>();
		this.metodos = metodos;

	}

    public List<Function> getMetodos() {
        return metodos;
    }

    public Stream<Function> metodos() {
        return metodos.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "StructDefinition{" + " nombre=" + this.getNombre() + " atributos=" + this.getAtributos() + " metodos=" + this.getMetodos() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

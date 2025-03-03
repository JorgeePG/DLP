// Generated with VGen 2.0.0

package ast.cuerpoprograma;

import ast.*;
import ast.tipo.*;
import ast.statement.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	function: cuerpoPrograma -> nombre:string parametros:declaracion* tipoRetorno:tipo cuerpo:statement*
	cuerpoPrograma -> 
*/
public class Function extends AbstractCuerpoPrograma  {

    // ----------------------------------
    // Instance Variables

	// function: cuerpoPrograma -> nombre:string parametros:declaracion* tipoRetorno:tipo cuerpo:statement*
	private String nombre;
	private List<Declaracion> parametros;
	private Tipo tipoRetorno;
	private List<Statement> cuerpo;

    // ----------------------------------
    // Constructors

	public Function(String nombre, List<Declaracion> parametros, Tipo tipoRetorno, List<Statement> cuerpo) {
		super();

		if (nombre == null)
			throw new IllegalArgumentException("Parameter 'nombre' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.nombre = nombre;

		if (parametros == null)
			parametros = new ArrayList<>();
		this.parametros = parametros;

		if (tipoRetorno == null)
			throw new IllegalArgumentException("Parameter 'tipoRetorno' can't be null. Pass a non-null value or use 'tipo?' in the abstract grammar");
		this.tipoRetorno = tipoRetorno;

		if (cuerpo == null)
			cuerpo = new ArrayList<>();
		this.cuerpo = cuerpo;

		updatePositions(nombre, parametros, tipoRetorno, cuerpo);
	}

	public Function(Object nombre, Object parametros, Object tipoRetorno, Object cuerpo) {
		super();

        if (nombre == null)
            throw new IllegalArgumentException("Parameter 'nombre' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.nombre = (nombre instanceof Token) ? ((Token) nombre).getText() : (String) nombre;

        this.parametros = castList(parametros, unwrapIfContext.andThen(Declaracion.class::cast));
        if (tipoRetorno == null)
            throw new IllegalArgumentException("Parameter 'tipoRetorno' can't be null. Pass a non-null value or use 'tipo?' in the abstract grammar");
		this.tipoRetorno = (Tipo) tipoRetorno;

        this.cuerpo = castList(cuerpo, unwrapIfContext.andThen(Statement.class::cast));
		updatePositions(nombre, parametros, tipoRetorno, cuerpo);
	}


    // ----------------------------------
    // function: cuerpoPrograma -> nombre:string parametros:declaracion* tipoRetorno:tipo cuerpo:statement*

	// Child 'nombre:string' 

	public void setNombre(String nombre) {
		if (nombre == null)
			throw new IllegalArgumentException("Parameter 'nombre' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.nombre = nombre;

	}

    public String getNombre() {
        return nombre;
    }


	// Child 'parametros:declaracion*' 

	public void setParametros(List<Declaracion> parametros) {
		if (parametros == null)
			parametros = new ArrayList<>();
		this.parametros = parametros;

	}

    public List<Declaracion> getParametros() {
        return parametros;
    }

    public Stream<Declaracion> parametros() {
        return parametros.stream();
    }


	// Child 'tipoRetorno:tipo' 

	public void setTipoRetorno(Tipo tipoRetorno) {
		if (tipoRetorno == null)
			throw new IllegalArgumentException("Parameter 'tipoRetorno' can't be null. Pass a non-null value or use 'tipo?' in the abstract grammar");
		this.tipoRetorno = tipoRetorno;

	}

    public Tipo getTipoRetorno() {
        return tipoRetorno;
    }


	// Child 'cuerpo:statement*' 

	public void setCuerpo(List<Statement> cuerpo) {
		if (cuerpo == null)
			cuerpo = new ArrayList<>();
		this.cuerpo = cuerpo;

	}

    public List<Statement> getCuerpo() {
        return cuerpo;
    }

    public Stream<Statement> cuerpo() {
        return cuerpo.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Function{" + " nombre=" + this.getNombre() + " parametros=" + this.getParametros() + " tipoRetorno=" + this.getTipoRetorno() + " cuerpo=" + this.getCuerpo() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}

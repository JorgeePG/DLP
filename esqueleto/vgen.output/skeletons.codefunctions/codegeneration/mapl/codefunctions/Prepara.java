// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.cuerpoprograma.*;
import codegeneration.mapl.*;


public class Prepara extends AbstractCodeFunction {

    public Prepara(MaplCodeSpecification specification) {
        super(specification);
    }


	// class StructDefinition(String nombre, List<VarDefinition> atributos, List<Function> metodos)
	// phase MemoryAllocation { int address }
	@Override
	public Object visit(StructDefinition structDefinition, Object param) {

		// prepara(structDefinition.atributos());

		// prepara(structDefinition.metodos());

		out("<instruction>");

		return null;
	}

	// class VarDefinition(Declaracion declaracion)
	// phase MemoryAllocation { int address }
	@Override
	public Object visit(VarDefinition varDefinition, Object param) {

		// define(varDefinition.getDeclaracion());

		out("<instruction>");

		return null;
	}

	// class Function(String nombre, List<Declaracion> parametros, Tipo tipoRetorno, List<Statement> cuerpo)
	// phase MemoryAllocation { int address }
	@Override
	public Object visit(Function function, Object param) {

		// define(function.parametros());

		// ejecuta(function.cuerpo());

		out("<instruction>");

		return null;
	}

}

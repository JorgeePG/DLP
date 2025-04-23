// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.*;
import codegeneration.mapl.*;


public class Define extends AbstractCodeFunction {

    public Define(MaplCodeSpecification specification) {
        super(specification);
    }


	// class Declaracion(String nombre, Tipo tipo)
	// phase MemoryAllocation { int address }
	@Override
	public Object visit(Declaracion declaracion, Object param) {

		out("<instruction>");

		return null;
	}

}

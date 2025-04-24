// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.expr.*;
import codegeneration.mapl.*;


public class Direccion extends AbstractCodeFunction {

    public Direccion(MaplCodeSpecification specification) {
        super(specification);
    }

	// class Variable(String nombre)
	// phase Identification { Declaracion declaracion }
	// phase TypeChecking { Tipo type, boolean lvalue }
	@Override
	public Object visit(Variable variable, Object param) {

		out("pusha "+variable.getDeclaracion().getAddress());

		return null;
	}


}

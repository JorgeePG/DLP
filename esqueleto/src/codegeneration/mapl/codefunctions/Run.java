// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.*;
import codegeneration.mapl.*;


public class Run extends AbstractCodeFunction {

    public Run(MaplCodeSpecification specification) {
        super(specification);
    }


	// class Program(List<CuerpoPrograma> cuerpoProgramas)
	@Override
	public Object visit(Program program, Object param) {
		out("call main");
		out("halt");
		prepara(program.cuerpoProgramas());
		

		return null;
	}

}

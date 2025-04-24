// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.cuerpoprograma.VarDefinition;
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
		if(variable.getDeclaracion().getAmbito()==1) {
			out("pusha "+variable.getDeclaracion().getAddress());
		}else {
			out("pusha BP");
			out("pusha "+variable.getDeclaracion().getAddress());
			out("add");
		}

		return null;
	}
	// class ArrayAccess(Expr array, Expr index)
		// phase TypeChecking { Tipo type, boolean lvalue }
		@Override
		public Object visit(ArrayAccess arrayAccess, Object param) {

			direccion(arrayAccess.getArray());
			valor(arrayAccess.getIndex());
			out("pushi "+arrayAccess.getType().getSize());
			out("mul");
			//Aquí se saca el desplazamiento dentro del array
			out("add");
			//Con eso hemos sacado el elemento al que queremos acceder

			return null;
		}
	
		// class FieldAccess(Expr object, String field)
		// phase TypeChecking { Tipo type, boolean lvalue }
		@Override
		public Object visit(FieldAccess fieldAccess, Object param) {
			//EL OBJECT ES UNA MALA NOMINACIÓN QUE HICE NO OLVIDARME QUE NOOOOO ES UN OBJECT DE VERDAD
			
			direccion(fieldAccess.getObject());
			for(VarDefinition v: fieldAccess.getStructAccedido().getAtributos()) {
				if(v.getDeclaracion().getNombre().equals(fieldAccess.getField())) {
					out("pushi "+v.getDeclaracion().getAddress());
					break;
				}
			}
			out("add");
			return null;
		}


}

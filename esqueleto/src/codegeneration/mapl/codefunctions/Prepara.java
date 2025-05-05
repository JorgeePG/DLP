// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.Declaracion;
import ast.cuerpoprograma.*;
import ast.tipo.CharType;
import ast.tipo.FloatType;
import ast.tipo.IntType;
import ast.tipo.Tipo;
import ast.tipo.VoidType;
import codegeneration.mapl.*;


public class Prepara extends AbstractCodeFunction {

    public Prepara(MaplCodeSpecification specification) {
        super(specification);
    }


	// class StructDefinition(String nombre, List<VarDefinition> atributos, List<Function> metodos)
	// phase MemoryAllocation { int address }
	@Override
	public Object visit(StructDefinition structDefinition, Object param) {

		return null;
	}

	// class VarDefinition(Declaracion declaracion)
	// phase MemoryAllocation { int address }
	@Override
	public Object visit(VarDefinition varDefinition, Object param) {
		return null;
	}

	// class Function(String nombre, List<Declaracion> parametros, Tipo tipoRetorno, List<Statement> cuerpo)
	// phase MemoryAllocation { int address }
	@Override
	public Object visit(Function function, Object param) {

		// define(function.parametros());
		out(function.getNombre()+":");
		out("#func "+function.getNombre());
		
		int totalParamSize=0;
		for(Declaracion d:function.getParametros()) {
			totalParamSize+=d.getTipo().getSize();
			out("#param "+d.getNombre()+":"+sacaTipoMapl(d.getTipo()));
		}
		int totalVarSize=0;
		for(VarDefinition v:function.getVariables()) {
			totalVarSize+=v.getDeclaracion().getTipo().getSize();
			out("#local "+v.getDeclaracion().getNombre()+":"+sacaTipoMapl(v.getDeclaracion().getTipo()));
		}
		out("#ret "+sacaTipoMapl(function.getTipoRetorno()));
		out("enter "+totalVarSize);
		ejecuta(function.cuerpo());
		if(function.getTipoRetorno().getClass().equals(VoidType.class)) {
			out("ret 0, "+totalVarSize+", "+totalParamSize);
		}
		
		return null;
	}


	
	private String sacaTipoMapl(Tipo tipo) {
		if (IntType.class.equals(tipo.getClass())) {
			return "int";
		} else if (FloatType.class.equals(tipo.getClass())) {
			return "real";
		} else if (CharType.class.equals(tipo.getClass())) {
			return "byte";
		}
		return "void";
	}
	

}

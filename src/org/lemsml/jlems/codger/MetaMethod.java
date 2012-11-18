package org.lemsml.jlems.codger;

import java.util.ArrayList;
import java.util.HashMap;

import org.lemsml.jlems.codger.MetaField.Type;
import org.lemsml.jlemsviz.plot.E;

public class MetaMethod {

	String name;
	
	VarType returnType;
	String returnName;
	
	
	ArrayList<MethodArgument> arguments = new ArrayList<MethodArgument>();
	
	ArrayList<Operation> ops = new ArrayList<Operation>();
	
	
	public MetaMethod(VarType typ, String nm, String rnm) {
		returnType = typ;
		name = nm;
		returnName = rnm;
	}


	public void addFloatArgument(String s) {
		arguments.add(new FloatMethodArgument(s));
		
	}


	public MethodCall newMethodCall(String str) {
		 MethodCall mc = new MethodCall(str);
		 ops.add(mc);
		 return mc;
	}


	public void addIncrement(String vnm, Expression expr) {
		Increment inc = new Increment(vnm, expr);
		ops.add(inc);
	}

 
		
	 
	public String generateJava() {
 		StringBuilder sb = new StringBuilder();
		sb.append("public " + javaVarType(returnType) + " " + name + "(");
		boolean first = true;
		for (MethodArgument ma : arguments) {
			if (!first) {
				sb.append(", ");
			}
			first = false;
			sb.append(ma.generateJava());
		}
		sb.append(") {\n");
		
		String opindent = "    ";
		for (Operation op : ops) {
			sb.append(opindent + op.generateJava());
			sb.append("\n");
		}
		
		sb.append("}\n");
		return sb.toString();
	}


	private String javaVarType(VarType vt) {
		String ret = "";
		if (vt.equals(VarType.DOUBLE)) {
			ret = "double";
		} else if (vt.equals(VarType.STRING)) {
			ret = "string";
		} else if (vt.equals(VarType.INTEGER)) {
			ret = "int";
		} else if (vt.equals(VarType.VOID)) {
			ret = "void";
		} else {
			E.error("Unrecognized var type " + vt);
		}
		return ret;
	}


	public void addFloatAssignment(String varName, String expr) {
		FloatAssignment fa = new FloatAssignment(varName, expr);
		ops.add(fa);
	}
	
	
	

}

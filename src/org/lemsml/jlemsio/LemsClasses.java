package org.lemsml.jlemsio;
 
import java.util.ArrayList;

import org.lemsml.jlems.type.Assertion;
import org.lemsml.jlems.type.Attachments;
import org.lemsml.jlems.type.Child;
import org.lemsml.jlems.type.Children;
import org.lemsml.jlems.type.ComponentReference;
import org.lemsml.jlems.type.ComponentType;
import org.lemsml.jlems.type.Constant;
import org.lemsml.jlems.type.DerivedParameter;
import org.lemsml.jlems.type.Dimension;
import org.lemsml.jlems.type.EventPort;
import org.lemsml.jlems.type.Exposure;
import org.lemsml.jlems.type.Fixed;
import org.lemsml.jlems.type.Insertion;
import org.lemsml.jlems.type.IntegerParameter;
import org.lemsml.jlems.type.Link;
import org.lemsml.jlems.type.Parameter;
import org.lemsml.jlems.type.Path;
import org.lemsml.jlems.type.Requirement;
import org.lemsml.jlems.type.Target;
import org.lemsml.jlems.type.Text;
import org.lemsml.jlems.type.Unit;
import org.lemsml.jlems.type.dynamics.DerivedVariable;
import org.lemsml.jlems.type.dynamics.Dynamics;
import org.lemsml.jlems.type.dynamics.Edges;
import org.lemsml.jlems.type.dynamics.EventConnection;
import org.lemsml.jlems.type.dynamics.EventOut;
import org.lemsml.jlems.type.dynamics.KineticScheme;
import org.lemsml.jlems.type.dynamics.Nodes;
import org.lemsml.jlems.type.dynamics.OnCondition;
import org.lemsml.jlems.type.dynamics.OnEntry;
import org.lemsml.jlems.type.dynamics.OnEvent;
import org.lemsml.jlems.type.dynamics.OnStart;
import org.lemsml.jlems.type.dynamics.Regime;
import org.lemsml.jlems.type.dynamics.StateAssignment;
import org.lemsml.jlems.type.dynamics.StateVariable;
import org.lemsml.jlems.type.dynamics.TimeDerivative;
import org.lemsml.jlems.type.dynamics.Transition;
import org.lemsml.jlems.type.procedure.Equilibrate;
import org.lemsml.jlems.type.procedure.ForEachComponent;
import org.lemsml.jlems.type.procedure.Print;
import org.lemsml.jlems.type.procedure.Procedure;
import org.lemsml.jlems.type.simulation.DataDisplay;
import org.lemsml.jlems.type.simulation.Record;
import org.lemsml.jlems.type.simulation.Run;
import org.lemsml.jlems.type.simulation.Simulation;
import org.lemsml.jlems.type.structure.ChildInstance;
import org.lemsml.jlems.type.structure.Choose;
import org.lemsml.jlems.type.structure.CoInstantiate;
import org.lemsml.jlems.type.structure.ForEach;
import org.lemsml.jlems.type.structure.MultiInstantiate;
import org.lemsml.jlems.type.structure.Structure;
import org.lemsml.jlems.type.structure.With;

public class LemsClasses {

	
	public static LemsClasses instance;
	
	
	ArrayList<Class<?>> classList;
	
	
	public static LemsClasses getInstance() {
		if (instance == null) {
			instance = new LemsClasses();
		}
		return instance;
	}
	
	
	
	private LemsClasses() {
		classList = new ArrayList<Class<?>>();
	
		classList.addAll(getLemsClasses());
		classList.addAll(getComponentTypeClasses());
		classList.addAll(getDynamicsClasses());
		classList.addAll(getStructureClasses());
		classList.addAll(getSimulationClasses());
		classList.addAll(getProcedureClasses());
	}

	public ArrayList<Class<?>> getClasses() {
 		return classList;
	}

	

	private ArrayList<Class<?>> getLemsClasses() {
		ArrayList<Class<?>> ret =  new ArrayList<Class<?>>();
		ret.add(Dimension.class);
		ret.add(Unit.class);
		ret.add(Assertion.class);
		ret.add(ComponentType.class);
		ret.add(Target.class);
		return ret;
	}
	
	
	private ArrayList<Class<?>> getDynamicsClasses() {
		ArrayList<Class<?>> ret =  new ArrayList<Class<?>>();
	
		ret.add(Dynamics.class);
		ret.add(StateVariable.class);
		ret.add(StateAssignment.class);
		ret.add(TimeDerivative.class);
		ret.add(DerivedVariable.class);
		ret.add(OnStart.class);
	 	ret.add(OnCondition.class);	
	 	ret.add(OnEvent.class);
	 	ret.add(EventOut.class);
	 	ret.add(KineticScheme.class);
	 	ret.add(Nodes.class);
	 	ret.add(Edges.class);
	 	ret.add(Regime.class);
	 	ret.add(OnEntry.class);
	 	ret.add(Transition.class);
		return ret;
	}

	private ArrayList<Class<?>> getStructureClasses() {
		ArrayList<Class<?>> ret =  new ArrayList<Class<?>>();
	
		ret.add(Structure.class);
		ret.add(MultiInstantiate.class);
		ret.add(CoInstantiate.class);
		ret.add(Choose.class);
	 	ret.add(ChildInstance.class);	
	 	ret.add(ForEach.class);
	 	ret.add(EventConnection.class);
	 	ret.add(With.class);
		return ret;
	}


	private ArrayList<Class<?>> getComponentTypeClasses() {
		ArrayList<Class<?>> ret =  new ArrayList<Class<?>>();
		
	
		ret.add(Parameter.class);
		ret.add(DerivedParameter.class);
		ret.add(Fixed.class);
		ret.add(Requirement.class);
		ret.add(Exposure.class);
		ret.add(Child.class);
		ret.add(Children.class);
		// NB Link has to come before ComponentRef here becuase it is a subclass and we want
		// link elts in the right list. TODO - make same with different scope parameter
		ret.add(Link.class);
 		ret.add(ComponentReference.class);
		ret.add(EventPort.class);
		ret.add(Text.class);
		ret.add(Path.class);
		ret.add(Attachments.class);
		ret.add(Constant.class);	
		ret.add(Insertion.class);
		ret.add(IntegerParameter.class);
		return ret;
	}

	private ArrayList<Class<?>> getSimulationClasses() {
		ArrayList<Class<?>> ret =  new ArrayList<Class<?>>();
		
		ret.add(Simulation.class);
		ret.add(Record.class);
		ret.add(DataDisplay.class);
		ret.add(Run.class);
		return ret;
	}
	
	
	private ArrayList<Class<?>> getProcedureClasses() {
		ArrayList<Class<?>> ret =  new ArrayList<Class<?>>();
		
		ret.add(Procedure.class);
		ret.add(Equilibrate.class);
		ret.add(ForEachComponent.class);
		ret.add(Print.class);
		return ret;
	}
}

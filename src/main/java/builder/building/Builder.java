package builder.building;

import builder.elements.*;
import factory.*;
import factory.variables.*;
import factory.methods.*;
import builder.memory.Memory;

public class Builder {
	Klasa klasa;
	Factory factory;
	
	Builder(Factory f){
		klasa = null;
		factory = f;
	};
	
	void buildClass(){
		if(klasa != null) klasa = null;
		klasa = new Klasa();
	}
	
	void buildName(String s){
		klasa.setName(s);
	}
	
	void buildAtribute(String name, VariableType type){
		klasa.addAtr(factory.createVariable(name,type));
	}

	void buildAtribute(String name, VariableType type, int value){
		IntVariable v = (IntVariable) factory.createVariable(name,type);
		v.setValue(value);
		klasa.addAtr(v);
	};
	
	void buildAtribute(String name, VariableType type, char value){
		CharVariable v = (CharVariable) factory.createVariable(name,type);
		v.setValue(value);
		klasa.addAtr(v);
	};
	
	void buildAtribute(String name, VariableType type, double value){
		DoubleVariable v = (DoubleVariable) factory.createVariable(name,type);
		v.setValue(value);
		klasa.addAtr(v);
	};
	
	void buildMethod(String name){
		klasa.addMth(factory.createMethod(name));
	}
	
	void toMemory(Memory m){
		m.addClass(klasa);
		klasa = null;
	}
	
	void printClass(){
		System.out.println("Klasa w builderze: ");
		System.out.println("Nazwa: " + klasa.name);
	}
}

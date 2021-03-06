package builder.memory;

import builder.elements.*;
//import factory.*;
import factory.variables.*;

public class Memory {
	private static Memory instance = null;
	private Heap heap;
	private Stos stos;
	
	protected Memory(){
		heap = new Heap();
		stos = new Stos();
	}
	
    public static Memory getInstance(){
        if(instance == null){
        	instance = new Memory();
        }
        return instance;
    }
	
	public void addClass(Klasa k){
		heap.push(k);
	}
	
	public void onStack(Variable r){
		stos.push(r);
	}
	
	public Variable offStack(){
		return stos.pop();
	}
	
	public void clearHeap(){
		heap.clear();
	}

	public void clearStack(){
		stos.clear();
	}
	
	public void clearAll(){
		heap.clear();
		stos.clear();
	}
	
	public boolean isStosEmpty(){
		if(stos.isEmpty() == true) return true;
		return false;
	}
	
	public boolean isHeapEmpty(){
		if(heap.isEmpty() == true) return true;
		return false;
	}
	
	public Klasa find(String name){
		for(int i = 0; i < heap.klasy.size(); i++){
			if(heap.klasy.get(i).name == name) return heap.klasy.get(i); 
		}
		
		return null;
		
	}
	
	public void print(){
		System.out.println("Sterta: ");
		heap.print();
		System.out.println("Stos: "+stos.makeString());
		//stos.print();
	}
}

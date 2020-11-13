package model;
import java.util.*;
public class IntegerSet{

	//attributes
	private String name;
	private int cardinality; //cantidad de elementos que te da el size
	private ArrayList<Integer> elements;

	public IntegerSet(String name){
		this.name=name;
		cardinality=0;
		elements= new ArrayList<Integer>();
	}

	public String getName(){
		return name;
	}

	public int getCardinality(){
		return cardinality;
	}

	public ArrayList<Integer> getElements(){
		return elements;
	}

	public void addElement(int element){
		elements.add(element);
		cardinality++;
	}

	public void removeElement(int element){
		int i=elements.indexOf(element);
		elements.remove(i);
		cardinality--;
	}

	public IntegerSet union(IntegerSet set, String newName){
		IntegerSet objNew= new IntegerSet(newName);
		for(int i=0; i<cardinality;i++){
			objNew.getElements().add(elements.get(i));
		}
		return objNew;
	}

	public IntegerSet difference(IntegerSet set, String newName){
		return set;
	}

	public IntegerSet intersection(IntegerSet set, String newName){
		return set;
	}

	public IntegerSet symmetricDifference(IntegerSet set, String newName){
		return set;
	}

	public String showContents(){
		return "";
	}
}
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

	public boolean findElement(Integer element){
		boolean exit=false;
		for(int i=0; i<cardinality && !exit;i++){
			if(elements.get(i)==element){
				exit=true;
			}
		}
		return exit;
	}

	public void addElement(Integer element){
		elements.add(element);
		cardinality++;
	}

	public void removeElement(Integer element){
		int i=elements.indexOf(element);
		elements.remove(i);
		cardinality--;
	}

	public IntegerSet union(IntegerSet set, String newName){
		IntegerSet objNew= new IntegerSet(newName);
		boolean found;
		for(int i=0; i<cardinality;i++){
			objNew.addElement(elements.get(i));
		}

		for(int i=0; i<set.getCardinality();i++){
			Integer element=set.getElements().get(i);
			found=findElement(element);
			if(!found){
				objNew.addElement(element);
			}
		}
		return objNew;
	}

	public IntegerSet difference(IntegerSet set, String newName){
		IntegerSet objNew= new IntegerSet(newName);
		boolean found;
		for(int i=0; i<cardinality;i++){
			Integer element=elements.get(i);
			found=set.findElement(element);
			if(!found){
				objNew.addElement(element);
			}
		}
		return objNew;

	}

	public IntegerSet intersection(IntegerSet set, String newName){
		IntegerSet objNew= new IntegerSet(newName);
		boolean found;
		for(int i=0; i<set.getCardinality();i++){
			int element=set.getElements().get(i);
			found=findElement(element);
			if(found){
				objNew.addElement(element);
			}
		}
		return objNew;
	}

	public IntegerSet symmetricDifference(IntegerSet set, String newName){
		IntegerSet objNew= new IntegerSet(newName);
		boolean found;
		for(int i=0; i<cardinality;i++){
			int element=elements.get(i);
			found=set.findElement(element);
			if(!found){
				objNew.addElement(element);
			}
		}

		for(int i=0; i<set.getCardinality();i++){
			int element=set.getElements().get(i);
			found=findElement(element);
			if(!found){
				objNew.addElement(element);
			}
		}
		return objNew;
	}

	public String toString(){
		String elementsSet="";
		for(int i=0; i<cardinality;i++){
			if(i!=cardinality-1){
				elementsSet+=elements.get(i)+", ";
			}
			else{
				elementsSet+=elements.get(i);
			}
		}
		if(elements.isEmpty()){
			elementsSet="vacio";
		}

		return name+"={"+elementsSet+"} \n \n";
	}
}
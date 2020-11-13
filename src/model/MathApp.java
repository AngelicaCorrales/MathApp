package model;
import java.util.*;
public class MathApp{

	//attributes
	private int amount; //cantidad de conjuntos que te da el size

	//relationship
	private ArrayList<IntegerSet> sets;

	public MathApp(){
		amount=0;
		sets=new ArrayList<IntegerSet>();
	}
	
	public IntegerSet findSet(String name){
		boolean exist=false;
		IntegerSet objSet=null;

		
		for(int i=0;i<sets.size() && !exist;i++){
			if(sets.get(i).getName().equals(name)){
				exist=true;
				objSet=sets.get(i);
			}
		}
		return objSet;
	}

	public String addSetToString(String name){
		String message="";
		IntegerSet objSet=findSet(name);
		if(objSet!=null){
			message="Error. El nombre del conjunto ya existe";
		}
		else{
			addSet(name);
			message="El conjunto ha sido agregado exitosamente";
		}
		return message;
	}

	public void addSet(String name){					
		sets.add(new IntegerSet(name));
		amount++;
					
	}

	public void removeSet(String name){
		IntegerSet objSet=findSet(name);
		int i=sets.indexOf(objSet);
		sets.remove(i);
		amount--;

	}

	public String removeSetToString(String name){
		String message="";
		IntegerSet objSet=findSet(name);
		if(objSet==null){
			message="Error. El nombre del conjunto no existe";
		}
		else{
			removeSet(name);
			message="El conjunto ha sido removido exitosamente";
		}
		return message;
	}

	public void addElementToSet(String setName, int element){
		IntegerSet objSet=findSet(setName);
		objSet.addElement(element);

	}


	public String addElementToSetToString(String setName, int element){
		String message="";
		IntegerSet objSet=findSet(setName);
		boolean found=false;
		if(objSet==null){
			message="Error. El nombre del conjunto no existe";
		}
		else{
			found=objSet.findElement(element);
			if(found){
				message="Error. El elemento ya estaba en el conjunto";
			}
			else{
				addElementToSet(setName, element);
				message="El elemento ha sido agregado al conjunto exitosamente";
			}
			
		}
		return message;
	}


	public void removeElementFromSet(String setName, int element){
		IntegerSet objSet=findSet(setName);
		objSet.removeElement(element);
	}

	public String removeElementFromSetToString(String setName, int element){
		String message="";
		IntegerSet objSet=findSet(setName);
		boolean found=false;
		if(objSet==null){
			message="Error. El nombre del conjunto no existe";
		}
		else{
			found=objSet.findElement(element);
			if(found){
				removeElementFromSet(setName, element);
				message="El elemento ha sido removido del conjunto exitosamente";
				
			}
			else{
				message="Error. El elemento no esta en el conjunto";
			}
			
		}
		return message;
	}

	public void union(String name1, String name2, String newName){
		IntegerSet objSet1=findSet(name1);
		IntegerSet objSet2=findSet(name2);

		IntegerSet objSetNew=objSet1.union(objSet2, newName);
		sets.add(objSetNew);
		amount++;
	}

	public void difference(String name1, String name2, String newName){
		IntegerSet objSet1=findSet(name1);
		IntegerSet objSet2=findSet(name2);

		IntegerSet objSetNew=objSet1.difference(objSet2, newName);
		sets.add(objSetNew);
		amount++;
	}

	public void intersection(String name1, String name2, String newName){

	}

	public void symmetricDifference(String name1, String name2, String newName){

	}

	public String operationToString(String name1, String name2, String newName, int operation){
		IntegerSet objSet1=findSet(name1);
		IntegerSet objSet2=findSet(name2);
		IntegerSet objSet3=findSet(newName);
		String message="";

		if(objSet1==null){
			message=" Error. el nombre del primer conjunto no existe.";
		}

		if(objSet2==null){
			message+=" Error. el nombre del segundo conjunto no existe.";
		}

		if(objSet3!=null){
			message+=" Error. el nombre del nuevo conjunto ya existe.";
		}

		if(objSet1==objSet2){
			message="Ha ingresado los mismos conjuntos";
		}
		else{

			if(objSet1!=null && objSet2!=null && objSet3==null && operation==1){
				union(name1,name2,newName);
				message="Union realizada con exito";
			}

			if(objSet1!=null && objSet2!=null && objSet3==null && operation==2){
				difference(name1,name2,newName);
				message="Diferencia realizada con exito";

			}

			if(objSet1!=null && objSet2!=null && objSet3==null && operation==3){
				intersection(name1,name2,newName);
				message="Interseccion realizada con exito";
			}

			if(objSet1!=null && objSet2!=null && objSet3==null && operation==4){
				symmetricDifference(name1,name2,newName);
				message="Diferencia simetrica realizada con exito";
			}
		}

		return message;
	}

	public String showInfoSet(String name){
		return "";
	}

	public String showInfoSets(){
		return "";
	}


}
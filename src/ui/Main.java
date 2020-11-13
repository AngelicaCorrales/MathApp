package ui;
import java.util.*;
import model.MathApp;
public class Main{
	private MathApp mathapp;
	private Scanner sc;

	public Main(){
		sc= new Scanner(System.in);
		mathapp= new MathApp();
	}

	public static void main(String [] args){
		Main objMain= new Main();
		int option;
		do{
			option=objMain.showMenu();
			objMain.chosenOption(option);
		}while(option!=8);
		
	}

	public int showMenu(){
		System.out.println("Seleccione una opcion:\n"+
				"(1) Agregar conjunto de numeros\n"+
				"(2) Eliminar conjunto de numeros \n"+
				"(3) Agregar elemento a un conjunto\n"+
				"(4) Eliminar elemento de un conjunto \n"+
				"(5) Realizar operacion entre dos conjuntos \n"+
				"(6) Mostrar contenido de un conjunto particular \n"+
				"(7) Mostrar contenido de todos los conjuntos \n"+
				"(8) Salir");
		int option= sc.nextInt();
		return option;
	}

	public void chosenOption(int op) {
		
		switch(op) {
		case 1:
			addSet();
			break;
		case 2:
			removeSet();
			break;
		case 3:
			addElementToSet();
			break;
		case 4:
			 removeElementFromSet();
			break;
		case 5:
			setOperations();
			break;
		case 6:
			 showInfoSet();
			break;
		case 7:
			showInfoSets();
			break;
				
		case 8:
			System.out.println("\nHasta la proxima!");
			break;
			
		default:
			System.out.println("\n Error, opcion no valida \n");
		
		}
	}

	public void addSet(){
		sc.nextLine();
		System.out.println("-----------------------------------------------------------");
		System.out.println("AGREGAR UN CONJUNTO DE NUMEROS \n");

		System.out.println("Ingrese el nombre del conjunto");
		String setName=sc.nextLine();

		String message="";
		message=mathapp.addSetToString(setName);

		System.out.println("-----------------------------------------------------------");
		System.out.println(message);
		System.out.println("-----------------------------------------------------------");
	}

	public void removeSet(){
		sc.nextLine();
		System.out.println("-----------------------------------------------------------");
		System.out.println("ELIMINAR UN CONJUNTO DE NUMEROS \n");

		System.out.println("Ingrese el nombre del conjunto");
		String setName=sc.nextLine();

		String message="";
		message=mathapp.removeSetToString(setName);

		System.out.println("-----------------------------------------------------------");
		System.out.println(message);
		System.out.println("-----------------------------------------------------------");
	}

	public void addElementToSet(){
		sc.nextLine();
		System.out.println("-----------------------------------------------------------");
		System.out.println("AGREGAR ELEMENTO A UN CONJUNTO \n");

		System.out.println("Ingrese el nombre del conjunto");
		String setName=sc.nextLine();

		System.out.println("Ingrese el numero entero a agregar");
		int element=sc.nextInt();

		String message="";
		message=mathapp.addSetToString(setName);

		System.out.println("-----------------------------------------------------------");
		System.out.println(message);
		System.out.println("-----------------------------------------------------------");
	}
}
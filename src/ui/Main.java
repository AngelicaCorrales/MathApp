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

		String message=mathapp.addSetToString(setName);

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

		String message=mathapp.removeSetToString(setName);

		System.out.println("-----------------------------------------------------------");
		System.out.println(message);
		System.out.println("-----------------------------------------------------------");
	}

	public void addElementToSet(){
		sc.nextLine();
		System.out.println("-----------------------------------------------------------");
		System.out.println("AGREGAR ELEMENTO DE UN CONJUNTO \n");

		System.out.println("Ingrese el nombre del conjunto");
		String setName=sc.nextLine();

		System.out.println("\nIngrese el numero entero a agregar");
		int element=sc.nextInt();

		String message=mathapp.addElementToSetToString(setName, element);

		System.out.println("-----------------------------------------------------------");
		System.out.println(message);
		System.out.println("-----------------------------------------------------------");
	}

	public void removeElementFromSet(){
		sc.nextLine();
		System.out.println("-----------------------------------------------------------");
		System.out.println("ELIMINAR ELEMENTO A UN CONJUNTO \n");

		System.out.println("Ingrese el nombre del conjunto");
		String setName=sc.nextLine();

		System.out.println("\nIngrese el numero entero a eliminar");
		int element=sc.nextInt();

		String message=mathapp.removeElementFromSetToString(setName, element);

		System.out.println("-----------------------------------------------------------");
		System.out.println(message);
		System.out.println("-----------------------------------------------------------");
	}

	public void setOperations(){
		boolean error;
		int option;
		int op;
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("REALIZAR OPERACION ENTRE DOS CONJUNTO \n");
		do{
			error=false;
			System.out.println("Seleccione la operacion que desea realizar:\n"+
				"(1) Union\n"+
				"(2) Diferencia \n"+
				"(3) Interseccion \n"+
				"(4) Diferencia simetrica");
			option= sc.nextInt();
			if(option!=1 && option!=2 && option!=3 && option!=4){
				error=true;
			}
		}while(error);

			sc.nextLine();

			System.out.println("Ingrese el nombre del conjunto 1");
			String setName1=sc.nextLine();

			System.out.println("\nIngrese el nombre del conjunto 2");
			String setName2=sc.nextLine();

			System.out.println("\nIngrese el nombre del nuevo conjunto");
			String newName=sc.nextLine();

			if(option==2){

					do{
						error=false;
						System.out.println("\nEspecifique la diferencia\n"+
								"(1) "+setName1+" - "+setName2+"\n"+
								"(2) "+setName2+" - "+setName1);
						op= sc.nextInt();

						if(op!=1 && option!=2){
							error=true;
						}

					}while(error);
					if(op==2){
						String x=setName1;
						setName1=setName2;
						setName2=x;
					}
				}


			String message=mathapp.operationToString(setName1, setName2, newName, option);

		System.out.println("-----------------------------------------------------------\n");
		System.out.println(message);
		System.out.println("-----------------------------------------------------------");


	}

	public void showInfoSet(){
		sc.nextLine();
		System.out.println("-----------------------------------------------------------");
		System.out.println("MOSTRAR CONTENIDO DE UN CONJUNTO PARTICULAR\n");

		System.out.println("Ingrese el nombre del conjunto");
		String setName=sc.nextLine();

		String message="\n"+mathapp.showInfoSet(setName);

		System.out.println(message);
		System.out.println("-----------------------------------------------------------");
	}

	public void showInfoSets(){
		sc.nextLine();
		System.out.println("-----------------------------------------------------------");
		System.out.println("MOSTRAR CONTENIDO DE TODOS LOS CONJUNTOS\n");
		String message=mathapp.showInfoSets();

		System.out.println(message);
		System.out.println("-----------------------------------------------------------");
	}

}
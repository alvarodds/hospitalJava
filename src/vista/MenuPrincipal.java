package vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import Utilidades.Utilidades;
import controlador.Paciente;
import controlador.Pacientes;


public class MenuPrincipal {
	//Conexiones
	protected static Pacientes pacientes = new Pacientes();
	protected static Utilidades utilidades = new Utilidades();
	protected static int contador = 0;
	


	public static void main(String[] args) {
		//Variables generales
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		boolean ok = false, salir=false;

		while(!salir) {
			System.out.println("1. Aniadir paciente");
			System.out.println("2. Listar habitaciones");
			System.out.println("3. Contar dietas");
			System.out.println("Introduce la opcion que deseas (0 para salir): ");

			try {
				opcion=sc.nextInt();
				ok = true;
			} catch (InputMismatchException e) {
				System.out.println("OPCION INCORRECTA:");
				sc = new Scanner(System.in);
			}

			switch(opcion) {
			case 0: salir = true;;
			break;
			case 1: aniadirPaciente();
			break;
			case 2: listarHabitaciones();
			break;
			case 3: contarDietas();
			break;
			}
		}
	}

	private static void aniadirPaciente() {
		boolean ok = false;
		Paciente p = new Paciente();
		Scanner sc = new Scanner(System.in);

		//Habitacion cama y validación
		System.out.println("Escribe la habitación-cama:");
		String habitacionCama = sc.nextLine();
		ok = utilidades.validarHabitacion(habitacionCama);

		while(!ok) {
			System.out.println("ERROR. Escribe de nuevo la habitación-cama:");
			habitacionCama = sc.nextLine();
			ok = utilidades.validarHabitacion(habitacionCama);
		}

		ok= false;
		//NIF y validacion
		System.out.println("Escribe el NIF:");
		String nif = sc.nextLine();
		
		ok = utilidades.validarNif(nif);

		while(!ok) {
			System.out.println("ERROR.Escribe de nuevo el NIF:");
			nif = sc.nextLine();
			ok = utilidades.validarNif(nif);
		}

		ok=false;

		//Nombre paciente y validacion
		System.out.println("Escribe el nombre del paciente:");
		String nombre = sc.nextLine();
		ok = utilidades.validarNombre(nombre);

		while(!ok) {
			System.out.println("ERROR.Escribe de nuevo el nombre del paciente:");
			nombre = sc.nextLine();
			ok = utilidades.validarNombre(nombre);
		}

		ok=false;

		//Apellidos paciente y validacion
		System.out.println("Escribe los apellidos del paciente:");
		String apellidos = sc.nextLine();
		ok = utilidades.validarApellido(apellidos);

		while(!ok) {
			System.out.println("ERROR.Escribe de nuevo los apellidos del paciente:");
			apellidos = sc.nextLine();
			ok = utilidades.validarApellido(apellidos);
		}	
		
		ok=false;

		//Dieta del paciente y validacion
		System.out.println("Escribe la dieta del paciente:");
		String dieta = sc.nextLine();
		ok = utilidades.validarDieta(dieta);

		while(!ok) {
			System.out.println("ERROR.Escribe de nuevo la dieta del paciente:");
			dieta = sc.nextLine();
			ok = utilidades.validarDieta(dieta);
		}
		
		p.setHabitacionCama(habitacionCama);
		p.setNif(nif);
		p.setNombre(nombre);
		p.setApellidos(apellidos);
		p.setDieta(dieta);
		pacientes.getPacientes().add(p);
		//Cuento cuantas dietas hay con ese valor
		int numDieta = pacientes.contarDietas(dieta);
		pacientes.getContadorDietas().put(dieta, numDieta);
		System.out.println();

	}

	private static void listarHabitaciones() {
		pacientes.ordenarHabitaciones();
		for (int i = 0; i < pacientes.getPacientes().size(); i++) {
			System.out.println(pacientes.getPacientes().get(i).toString());
		}
		System.out.println();
	}

	private static void contarDietas() {
		utilidades.mostrarDietas(pacientes.getContadorDietas());
	}

}

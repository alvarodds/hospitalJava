package controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;


public class Pacientes {

	private ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	private HashMap <String, Integer> contadorDietas = new HashMap <String, Integer> ();
	
	public Pacientes() {}

	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public HashMap<String, Integer> getContadorDietas() {
		return contadorDietas;
	}

	public void setContadorDietas(HashMap<String, Integer> contadorDietas) {
		this.contadorDietas = contadorDietas;
	}
	
	public int contarDietas(String dieta) {
		int contador = 0;
		
		for (int i = 0; i < pacientes.size(); i++) {
			if(pacientes.get(i).getDieta().equals(dieta)) {
				contador++;
			}
		}
		
		return contador;
	}
	
	public void ordenarHabitaciones() {
		Collections.sort(pacientes, new Comparator<Paciente>() {
			public int compare(Paciente p1, Paciente p2) {
				return new Integer(Integer.parseInt(p1.getHabitacionCama().replace("-", ""))).compareTo(new Integer(Integer.parseInt(p2.getHabitacionCama().replace("-", ""))));
				
			}
		});
	}
	
}

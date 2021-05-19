package Utilidades;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {
	
	static String[] dietas = {"Normal", "Blanda", "Liquida", "Sin sal", "Sin gluten", "Sin lactosa", "Otra"};

	public static boolean validarHabitacion(String habitacionCama) {
		String habitacion = habitacionCama.substring(0, 3);
		String separador = habitacionCama.substring(3, 4);
		String cama = habitacionCama.substring(4);

		int numHabitacion = Integer.parseInt(habitacion);
		int numCama = Integer.parseInt(cama);

		if((numHabitacion >= 100 && numHabitacion <= 999) && separador.equals("-") && (numCama >= 1 && numCama <= 9)) {
			return true;
		}else {
			return false;
		}
	}

	public static boolean validarNif(String nif) {
		boolean correcto = false;
		Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
		Matcher matcher = pattern.matcher(nif);

		if (matcher.matches()) {
			String letra = matcher.group(2);
			String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
			int index = Integer.parseInt(matcher.group(1));
			index = index % 23;
			String reference = letras.substring(index, index + 1);

			if (reference.equalsIgnoreCase(letra)) {
				correcto = true;
			} else {
				correcto = false;
			}
		} else {
			correcto = false;
		}
		return correcto;

	}

	public static boolean validarNombre(String nombre) {
		int longitud = nombre.length();

		if(longitud >= 1 && longitud <= 20) {
			return true;
		}else {
			return false;
		}

	}

	public static boolean validarApellido(String apellido) {
		int longitud = apellido.length();

		if(longitud >= 1 && longitud <= 40) {
			return true;
		}else {
			return false;
		}

	}
	
	public static boolean validarDieta(String dieta) {
		for (int i = 0; i < dietas.length; i++) {
			if(dieta.equals(dietas[i])) {
				return true;
			}
		}
		return false;
	}
	

	public void mostrarDietas(HashMap<String, Integer> contadorDietas) {
		for(String key: contadorDietas.keySet()){
		    System.out.println("Dieta:" + key);
		    System.out.println("Pacientes:" + contadorDietas.get(key));
		    System.out.println();
		}
		
	}
}

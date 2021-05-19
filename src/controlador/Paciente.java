package controlador;

public class Paciente {
	private String nif;
	private String nombre;
	private String apellidos;
	private String habitacionCama;
	private String dieta;
	
	public Paciente() {}
	
	public Paciente(String nif, String nombre, String apellidos, String habitacionCama, String dieta) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.habitacionCama = habitacionCama;
		this.dieta = dieta;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getHabitacionCama() {
		return habitacionCama;
	}

	public void setHabitacionCama(String habitacionCama) {
		this.habitacionCama = habitacionCama;
	}

	public String getDieta() {
		return dieta;
	}

	public void setDieta(String dieta) {
		this.dieta = dieta;
	}
	
	public void copiarPaciente(Paciente copia) {
		this.habitacionCama = copia.getHabitacionCama();
		this.nif = copia.getNif();
		this.nombre = copia.getNombre();
		this.apellidos = copia.getApellidos();
		this.dieta = copia.getDieta();
	}

	@Override
	public String toString() {
		return "Paciente [nif=" + nif + ", nombre=" + nombre + ", apellidos=" + apellidos + ", habitacionCama="
				+ habitacionCama + ", dieta=" + dieta + "]";
	}
	
	
	
}

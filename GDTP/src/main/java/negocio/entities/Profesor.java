package negocio.entities;

public class Profesor {
	
	private String dni;
	private String nombre;
	private String apellidos;
	private boolean doctor;
	private int centro;
	
	public Profesor(String dni, String nombre, String apellidos, boolean doctor) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.doctor=doctor;
	}
	public Profesor(String dni) {
		this.dni=dni;
	}

	public Profesor() {
	}
	
	public String get_dni() {
		return dni;
	}

	public void set_dni(String dni) {
		this.dni = dni;
	}

	public String get_nombre() {
		return nombre;
	}

	public void set_nombre(String nombre) {
		this.nombre = nombre;
	}

	public String get_apellidos() {
		return apellidos;
	}

	public void set_apellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public boolean is_doctor() {
		return doctor;
	}

	public void set_doctor(boolean doctor) {
		this.doctor = doctor;
	}
	public int get_centro() {
		return centro;
	}
	public void set_centro(int centro) {
		this.centro = centro;
	}
	public String toString() {
		return dni;
		
		
	}
	
	
	
}
package negocio.entities;

public class Profesor {
	
	private String _dni;
	private String _nombre;
	private String _apellidos;
	private boolean _doctor;
	private int _centro;
	
	public Profesor(String dni, String nombre, String apellidos, boolean doctor) {
		this._dni=dni;
		this._nombre=nombre;
		this._apellidos=apellidos;
		this._doctor=doctor;
	}
	public Profesor(String dni) {
		this._dni=dni;
	}

	public String get_dni() {
		return _dni;
	}

	public void set_dni(String _dni) {
		this._dni = _dni;
	}

	public String get_nombre() {
		return _nombre;
	}

	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}

	public String get_apellidos() {
		return _apellidos;
	}

	public void set_apellidos(String _apellidos) {
		this._apellidos = _apellidos;
	}

	public boolean is_doctor() {
		return _doctor;
	}

	public void set_doctor(boolean _doctor) {
		this._doctor = _doctor;
	}
	public int get_centro() {
		return _centro;
	}
	public void set_centro(int _centro) {
		this._centro = _centro;
	}
	
	
	
}
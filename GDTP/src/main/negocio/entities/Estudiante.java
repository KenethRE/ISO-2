package negocio.entities;

import java.util.Vector;
import negocio.entities.Matricula;

public class Estudiante {
	private String _dni;
	private String _nombre;
	private String _apellidos;
	private String _titulacion;
	private String _cualificacion;
	
	//Un estudiante tiene muchas matrículas
	public Vector<Matricula> _matriculas = new Vector<Matricula>();
	

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

	public String get_titulacion() {
		return _titulacion;
	}

	public void set_titulacion(String _titulacion) {
		this._titulacion = _titulacion;
	}

	public String get_cualificacion() {
		return _cualificacion;
	}

	public void set_cualificacion(String _cualificacion) {
		this._cualificacion = _cualificacion;
	}
	
	
	
}

package negocio.entities;

import java.sql.SQLException;
import java.util.Vector;
import negocio.entities.Matricula;
import persistencia.EstudianteDAO;

public class Estudiante {
	private String _dni;
	private String _nombre;
	private String _apellidos;
	private String _titulacion;
	private String _cualificacion;
	
	//Un estudiante tiene muchas matr�culas
	public Vector<Matricula> _matriculas = new Vector<Matricula>();//revisar los de vectores
	private EstudianteDAO<Estudiante> agenteEstudianteDAO = new EstudianteDAO<>();

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
	
	public void persist () {
		try {
			this.agenteEstudianteDAO.crearNuevoEstudiante(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
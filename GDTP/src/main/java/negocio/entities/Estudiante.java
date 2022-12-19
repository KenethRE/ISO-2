package negocio.entities;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.*;
import persistencia.EstudianteDAO;

public class Estudiante {
	private String dni;
	private String nombre;
	private String apellidos;
	private String titulacion;
	private String cualificacion;
	
	//Un estudiante tiene muchas matriculas
	private List<Matricula> matriculas = new ArrayList<>();
	private EstudianteDAO<Estudiante> agenteEstudianteDAO = new EstudianteDAO<>();

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

	public String get_titulacion() {
		return titulacion;
	}

	public void set_titulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public String get_cualificacion() {
		return cualificacion;
	}

	public void set_cualificacion(String cualificacion) {
		this.cualificacion = cualificacion;
	}
	
	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public void persist () throws SQLException {
		this.agenteEstudianteDAO.crearNuevoEstudiante(this);
	}
}
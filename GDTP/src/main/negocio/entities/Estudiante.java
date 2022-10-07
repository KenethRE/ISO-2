package negocio.entities;

import java.util.Vector;
import negocio.entities.Matricula;

public class Estudiante {
	private String _dni;
	private String _nombre;
	private String _apellidos;
	private String _titulacion;
	private String _cualificacion;
	public Vector<Matricula> _matriculas = new Vector<Matricula>();
}
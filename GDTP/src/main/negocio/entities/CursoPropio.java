package negocio.entities;

import java.util.Vector;
import negocio.entities.Matricula;
import negocio.entities.Materia;
import persistencia.CursoPropioDAO;

public class CursoPropio {
	private String _id;
	private String _nombre;
	private int _eCTS;
	private Date _fechaInicio;
	private Date _fechaFin;
	private double _tasaMatricula;
	private int _edicion;
	public Vector<Matricula> _matriculas = new Vector<Matricula>();
	public Centro _centro;
	public ProfesorUCLM _director;
	public ProfesorUCLM _secretario;
	public Vector<Materia> _materias = new Vector<Materia>();
	public EstadoCurso _estado;
	public TipoCurso _tipo;
	public CursoPropioDAO _cursoPropioDao;
}
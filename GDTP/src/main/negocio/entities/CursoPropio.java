package negocio.entities;

import java.util.Date;
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
	
	//Un curso propio puede tener varias matriculas
	public Vector<Matricula> _matriculas = new Vector<Matricula>();
	public Centro _centro;
	public ProfesorUCLM _director;
	public ProfesorUCLM _secretario;
	//un curso propio puede tener varias materias
	public Vector<Materia> _materias = new Vector<Materia>();
	public EstadoCurso _estado;
	public TipoCurso _tipo;
	public CursoPropioDAO _cursoPropioDao;
	
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String get_nombre() {
		return _nombre;
	}
	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}
	public int get_eCTS() {
		return _eCTS;
	}
	public void set_eCTS(int _eCTS) {
		this._eCTS = _eCTS;
	}
	public Date get_fechaInicio() {
		return _fechaInicio;
	}
	public void set_fechaInicio(Date _fechaInicio) {
		this._fechaInicio = _fechaInicio;
	}
	public Date get_fechaFin() {
		return _fechaFin;
	}
	public void set_fechaFin(Date _fechaFin) {
		this._fechaFin = _fechaFin;
	}
	public double get_tasaMatricula() {
		return _tasaMatricula;
	}
	public void set_tasaMatricula(double _tasaMatricula) {
		this._tasaMatricula = _tasaMatricula;
	}
	public int get_edicion() {
		return _edicion;
	}
	public void set_edicion(int _edicion) {
		this._edicion = _edicion;
	}
	
	
	
}
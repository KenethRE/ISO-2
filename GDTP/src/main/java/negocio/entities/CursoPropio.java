package negocio.entities;

import java.util.Date;
import java.util.Vector;
import persistencia.CursoPropioDAO;

public class CursoPropio implements IdInterface{
	private String _id;
	private String _nombre;
	private int _eCTS;
	private Date _fechaInicio;
	private Date _fechaFin;
	private double _tasaMatricula;
	private int _edicion;
	
	//Un curso propio puede tener varias matriculas
	public Vector<Matricula> _matriculas = new Vector<Matricula>();//revisar vectores
	public int id_centro;
	public String id_director;
	public String id_secretario;
	//un curso propio puede tener varias materias
	public Vector<Materia> _materias = new Vector<Materia>();//revisar vectores
	public EstadoCurso _estado;
	public TipoCurso _tipo;
	public CursoPropioDAO<CursoPropio> _cursoPropioDao = new CursoPropioDAO<CursoPropio>() ;
	
	public CursoPropio() {
		
	}
	
	public CursoPropio(String id) {
		this._id = id;
	}
	
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

	public Vector<Matricula> get_matriculas() {
		return _matriculas;
	}

	public void set_matriculas(Vector<Matricula> _matriculas) {
		this._matriculas = _matriculas;
	}

	public int getId_centro() {
		return id_centro;
	}

	public void setId_centro(int id_centro) {
		this.id_centro = id_centro;
	}

	public String getId_director() {
		return id_director;
	}

	public void setId_director(String id_director) {
		this.id_director = id_director;
	}

	public String getId_secretario() {
		return id_secretario;
	}

	public void setId_secretario(String id_secretario) {
		this.id_secretario = id_secretario;
	}

	public Vector<Materia> get_materias() {
		return _materias;
	}

	public void set_materias(Vector<Materia> _materias) {
		this._materias = _materias;
	}

	public EstadoCurso get_estado() {
		return _estado;
	}

	public void set_estado(EstadoCurso _estado) {
		this._estado = _estado;
	}

	public TipoCurso get_tipo() {
		return _tipo;
	}

	public void set_tipo(TipoCurso _tipo) {
		this._tipo = _tipo;
	}
	
	public void persist () {
		this._cursoPropioDao.crearNuevoCurso(this);
	}

	@Override
	public String getId() {
		return _id;
	}
	public String toString() {
		return _nombre;
		
		
	}
	
}
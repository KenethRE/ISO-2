package negocio.entities;

import java.sql.SQLException;
import java.util.*;

import negocio.controllers.GestorPropuestasCursos;
import persistencia.CursoPropioDAO;

public class CursoPropio implements IdInterface{
	private String id;
	private String nombre;
	private int eCTS;
	private Date fechaInicio;
	private Date fechaFin;
	private double tasaMatricula;
	private int edicion;
	
	//Un curso propio puede tener varias matriculas
	private List<Matricula> matriculas = new ArrayList<>();
	private int id_centro;
	private String id_director;
	private String id_secretario;
	//un curso propio puede tener varias materias
	private List<Materia> materias = new ArrayList<>();
	private EstadoCurso estado;
	private TipoCurso tipo;
	private GestorPropuestasCursos gestorPropuestasCursos = new GestorPropuestasCursos();
	
	public CursoPropio() {
		
	}
	
	public CursoPropio(String id) {
		this.id = id;
	}
	
	public String get_id() {
		return id;
	}
	public void set_id(String id) {
		this.id = id;
	}
	public String get_nombre() {
		return nombre;
	}
	public void set_nombre(String nombre) {
		this.nombre = nombre;
	}
	public int get_eCTS() {
		return eCTS;
	}
	public void set_eCTS(int eCTS) {
		this.eCTS = eCTS;
	}
	public Date get_fechaInicio() {
		return fechaInicio;
	}
	public void set_fechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date get_fechaFin() {
		return fechaFin;
	}
	public void set_fechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public double get_tasaMatricula() {
		return tasaMatricula;
	}
	public void set_tasaMatricula(double tasaMatricula) {
		this.tasaMatricula = tasaMatricula;
	}
	public int get_edicion() {
		return edicion;
	}
	public void set_edicion(int edicion) {
		this.edicion = edicion;
	}

	public List<Matricula> get_matriculas() {
		return matriculas;
	}

	public void set_matriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
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

	public List<Materia> get_materias() {
		return materias;
	}

	public void set_materias(List<Materia> materias) {
		this.materias = materias;
	}

	public EstadoCurso get_estado() {
		return estado;
	}

	public void set_estado(EstadoCurso estado) {
		this.estado = estado;
	}

	public TipoCurso get_tipo() {
		return tipo;
	}

	public void set_tipo(TipoCurso tipo) {
		this.tipo = tipo;
	}
	
	public void persist () throws SQLException {
		this.gestorPropuestasCursos.realizarPropuestaCurso(this);
	}

	@Override
	public String getInternalID() {
		return id;
	}
	public String toString() {
		return nombre;
		
		
	}
	
}
package negocio.entities;

import java.util.Date;

import persistencia.MateriaDAO;

public class Materia implements IdInterface{
	private String nombre;
	private double horas;
	private Date fechaInicio;
	private Date fechaFin;
	public String id_Curso;
	public String id_prof_responsable;
	public MateriaDAO<Materia> MateriaDAO = new MateriaDAO<>();
	
	
	public String get_nombre() {
		return nombre;
	}
	public void set_nombre(String nombre) {
		this.nombre = nombre;
	}
	public double get_horas() {
		return horas;
	}
	public void set_horas(double horas) {
		this.horas = horas;
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
	public String getId_Curso() {
		return id_Curso;
	}
	public void setId_Curso(String id_Curso) {
		this.id_Curso = id_Curso;
	}
	public String getId_prof_responsable() {
		return id_prof_responsable;
	}
	public void setId_prof_responsable(String id_prof_responsable) {
		this.id_prof_responsable = id_prof_responsable;
	}
	@Override
	public String getInternalID() {
		return id_Curso;
	}
	public String toString() {
		return nombre;
		
		
	}
	public void persist () {
		this.MateriaDAO.crearNuevaMateria(this);

	}
	
	
}
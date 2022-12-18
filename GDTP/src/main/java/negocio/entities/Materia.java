package negocio.entities;

import java.sql.SQLException;
import java.util.Date;

import persistencia.MateriaDAO;

public class Materia implements IdInterface{
	private String id_Materia;
	
	private String _nombre;
	private double _horas;
	private Date _fechaInicio;
	private Date _fechaFin;
	public String id_Curso;
	public String id_prof_responsable;
	public MateriaDAO<Materia> _MateriaDAO = new MateriaDAO<Materia>();
	
	
	public String get_nombre() {
		return _nombre;
	}
	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}
	public double get_horas() {
		return _horas;
	}
	public void set_horas(double _horas) {
		this._horas = _horas;
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
	public String getId() {
		return id_Curso;
	}
	
	
	
	
	
	public String getId_Materia() {
		return id_Materia;
	}
	public void setId_Materia(String id_Materia) {
		this.id_Materia = id_Materia;
	}
	public String toString() {
		return _nombre;
		
		
	}
	public void persist () {
		try {
			this._MateriaDAO.crearNuevaMateria(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String getInternalID() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
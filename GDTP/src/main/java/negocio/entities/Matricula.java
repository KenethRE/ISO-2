package negocio.entities;

import java.sql.SQLException;
import java.util.Date;

import negocio.controllers.GestorMatriculacion;
import persistencia.MatriculaDAO;

public class Matricula implements IdInterface{
	private int iD;
	
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	private Date _fecha;
	private boolean _pagado;
	private Object _attribute;
	
	//una matricula tiene un estudiante
	public String id_estudiante;
	public String id_Curso;
	public ModoPago _tipoPago;
	private GestorMatriculacion agentematricula = new GestorMatriculacion();
	
	public Date get_fecha() {
		return _fecha;
	}
	public void set_fecha(Date _fecha) {
		this._fecha = _fecha;
	}
	public boolean is_pagado() {
		return _pagado;
	}
	public void set_pagado(boolean _pagado) {
		this._pagado = _pagado;
	}
	public Object get_attribute() {
		return _attribute;
	}
	public void set_attribute(Object _attribute) {
		this._attribute = _attribute;
	}
	public String getId_estudiante() {
		return id_estudiante;
	}
	public void setId_estudiante(String id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	public String getId_Curso() {
		return id_Curso;
	}
	public void setId_Curso(String id_Curso) {
		this.id_Curso = id_Curso;
	}
	public ModoPago get_tipoPago() {
		return _tipoPago;
	}
	public void set_tipoPago(ModoPago _tipoPago) {
		this._tipoPago = _tipoPago;
	}
	@Override
	public String getId() {
		return String.valueOf(iD);
	}
	public void persist () {
		try {
			this.agentematricula.realizarMatriculacion(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
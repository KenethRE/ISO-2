package negocio.entities;

import java.sql.SQLException;
import java.util.Date;

import negocio.controllers.GestorMatriculacion;

public class Matricula implements IdInterface{
	private int iD;
	
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	private Date fecha;
	private boolean pagado;
	private Object attribute;
	
	//una matricula tiene un estudiante
	public String id_estudiante;
	public String id_Curso;
	public ModoPago tipoPago;
	private GestorMatriculacion agentematricula = new GestorMatriculacion();
	
	public Date get_fecha() {
		return fecha;
	}
	public void set_fecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean is_pagado() {
		return pagado;
	}
	public void set_pagado(boolean pagado) {
		this.pagado = pagado;
	}
	public Object get_attribute() {
		return attribute;
	}
	public void set_attribute(Object attribute) {
		this.attribute = attribute;
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
		return tipoPago;
	}
	public void set_tipoPago(ModoPago tipoPago) {
		this.tipoPago = tipoPago;
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
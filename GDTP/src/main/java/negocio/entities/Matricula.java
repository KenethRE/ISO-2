package negocio.entities;

import java.util.Date;

public class Matricula {
	private Date _fecha;
	private boolean _pagado;
	private Object _attribute;
	
	//una matricula tiene un estudiante
	public String id_estudiante;
	public int id_Curso;
	public ModoPago _tipoPago;
	
	
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
	public int getId_Curso() {
		return id_Curso;
	}
	public void setId_Curso(int id_Curso) {
		this.id_Curso = id_Curso;
	}
	public ModoPago get_tipoPago() {
		return _tipoPago;
	}
	public void set_tipoPago(ModoPago _tipoPago) {
		this._tipoPago = _tipoPago;
	}
	
	
}
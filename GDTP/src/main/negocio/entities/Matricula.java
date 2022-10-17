package negocio.entities;

import java.util.Date;

public class Matricula {
	private Date _fecha;
	private boolean _pagado;
	private Object _attribute;
	//una matricula tiene un estudiante
	public Estudiante _estudiante;
	public CursoPropio _titulo;
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
	
	
}

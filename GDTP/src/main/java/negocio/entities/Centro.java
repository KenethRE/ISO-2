package negocio.entities;

import java.util.Vector;
import negocio.entities.CursoPropio;
import negocio.entities.ProfesorUCLM;

public class Centro {
	
	private String _nombre;
	private String _localizacion;
	private Object _attribute;
	public Vector<CursoPropio> _cursoPropios = new Vector<CursoPropio>();//revisar los de vectores
	public Vector<ProfesorUCLM> _plantilla = new Vector<ProfesorUCLM>();//revisar lo de vectores o mejor seria listas de objetos no se..
	
	
	public String get_nombre() {
		return _nombre;
	}
	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}
	public String get_localizacion() {
		return _localizacion;
	}
	public void set_localizacion(String _localizacion) {
		this._localizacion = _localizacion;
	}
	public Object get_attribute() {
		return _attribute;
	}
	public void set_attribute(Object _attribute) {
		this._attribute = _attribute;
	}


	
}
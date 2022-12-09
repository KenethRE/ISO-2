package negocio.entities;

import java.util.Vector;
import negocio.entities.CursoPropio;
import negocio.entities.ProfesorUCLM;

public class Centro implements IdInterface{
	
	private int _Id;
	private String _nombre;
	private String _localizacion;
	private Object _attribute;
	public Vector<CursoPropio> _cursoPropios = new Vector<CursoPropio>();//revisar los de vectores
	public Vector<ProfesorUCLM> _plantilla = new Vector<ProfesorUCLM>();//revisar lo de vectores o mejor seria listas de objetos no se..
	
	
	public int get_Id() {
		return _Id;
	}
	public void set_Id(int _Id) {
		this._Id = _Id;
	}	
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
	public Vector<CursoPropio> get_cursoPropios() {
		return _cursoPropios;
	}
	public void set_cursoPropios(Vector<CursoPropio> _cursoPropios) {
		this._cursoPropios = _cursoPropios;
	}
	public Vector<ProfesorUCLM> get_plantilla() {
		return _plantilla;
	}
	public void set_plantilla(Vector<ProfesorUCLM> _plantilla) {
		this._plantilla = _plantilla;
	}
	@Override
	public String getId() {
		return String.valueOf(_Id);
	}
	
	
}
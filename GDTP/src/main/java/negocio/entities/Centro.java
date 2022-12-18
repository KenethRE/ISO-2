package negocio.entities;

import java.util.ArrayList;
import java.util.List;

public class Centro implements IdInterface{
	
	private int Id;
	private String nombre;
	private String localizacion;
	private Object attribute;
	public List<CursoPropio> cursoPropios = new ArrayList<>();
	public List<ProfesorUCLM> plantilla = new ArrayList<>();

	
	public int get_Id() {
		return Id;
	}
	public void set_Id(int Id) {
		this.Id = Id;
	}	
	public String get_nombre() {
		return nombre;
	}
	public void set_nombre(String nombre) {
		this.nombre = nombre;
	}
	public String get_localizacion() {
		return localizacion;
	}
	public void set_localizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public Object get_attribute() {
		return attribute;
	}
	public void set_attribute(Object attribute) {
		this.attribute = attribute;
	}
	public List<CursoPropio> get_cursoPropios() {
		return cursoPropios;
	}
	public void set_cursoPropios(List<CursoPropio> cursoPropios) {
		this.cursoPropios = cursoPropios;
	}
	public List<ProfesorUCLM> get_plantilla() {
		return plantilla;
	}
	public void set_plantilla(List<ProfesorUCLM> plantilla) {
		this.plantilla = plantilla;
	}
	@Override
	public String getInternalID() {
		return String.valueOf(Id);
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
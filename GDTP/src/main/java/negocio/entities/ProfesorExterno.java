package negocio.entities;

public class ProfesorExterno extends Profesor {
	
	public ProfesorExterno(String dni, String nombre, String apellidos, boolean doctor) {
		super(dni, nombre, apellidos, doctor);
	}

	public ProfesorExterno(String dni) {
		super(dni);
	}

	public ProfesorExterno() {
		// TODO Auto-generated constructor stub
	}

	private String _titulacion;

	public String get_titulacion() {
		return _titulacion;
	}

	public void set_titulacion(String _titulacion) {
		this._titulacion = _titulacion;
	}
	
	
}
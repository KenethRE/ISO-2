package negocio.entities;

public class ProfesorUCLM extends Profesor {
	private String _nombre;
	private String _apellidos;
	private String _dni;
	public Centro _centroAdscripcion;
	public CategoriaProfesor _categoria;
	

	public ProfesorUCLM(String dni, String nombre, String apellidos, boolean doctor) {
		super(dni, nombre, apellidos, doctor);
		this._dni = dni;
		this._apellidos = apellidos;
		this._nombre = nombre;
		
	}


	public ProfesorUCLM() {
		// TODO Auto-generated constructor stub
	}


	public String get_nombre() {
		return _nombre;
	}


	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}


	public String get_apellidos() {
		return _apellidos;
	}


	public void set_apellidos(String _apellidos) {
		this._apellidos = _apellidos;
	}


	public String get_dni() {
		return _dni;
	}


	public void set_dni(String _dni) {
		this._dni = _dni;
	}
	
}
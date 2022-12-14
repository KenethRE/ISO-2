package persistencia;

import java.awt.event.FocusEvent.Cause;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import negocio.entities.CursoPropio;
import negocio.entities.Estudiante;

public class EstudianteDAO <E> extends AbstractEntityDAO<E> {
	private static final String loggerName = "GDTP_Logger";
	public int crearNuevoEstudiante(Estudiante aEstudiante) throws SQLException {
		 
		return insert (aEstudiante);
	}

	public int seleccionarEstudiante(Estudiante aEstudiante) {
		// El dni es el Estudiante que queremos seleccionar, el nombre de la clase "Estudiante" es la tabla que queremos
		// buscar y la cadena del final representa la clave que usamos para hacer la seleccion.
		int resultado = 0;
		ResultSet aux = get(aEstudiante);
		try {
			while (aux.next()) {
				aEstudiante.set_dni(aux.getString("dni"));
				aEstudiante.set_nombre(aux.getString("Nombre"));
				aEstudiante.set_apellidos(aux.getString("Apellidos"));
				aEstudiante.set_titulacion(aux.getString("Titulacion"));
				aEstudiante.set_cualificacion(aux.getNString("Cualificacion"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(loggerName).log(Level.SEVERE,"Estudiante no encontrado");
			resultado = 1;
		}
		
			
		return resultado;
		
	}

	public int  editarEstudiantes(Estudiante aEstudiante) {
		// El dni Estudiante es el estudiante que queremos editar, el nombre de la clase "Estudiante" es la tabla que queremos
				int resultado = 0;
				try{
					seleccionarEstudiante(aEstudiante);
					//primero busca que el estudiante exista si no salta la excepcion lo modifica
					resultado = update (aEstudiante);
					return resultado;
					
				} catch (NullPointerException e) {
					e.printStackTrace();
					Logger.getLogger(loggerName).log(Level.SEVERE, "Estudiante no encontrado");
				}
				
				return resultado;
	}

	public List<Estudiante> listarEstudiantes() {
		List<Estudiante> Estudiantes = new ArrayList<>();
		ResultSet aux = get("Profesor");
		try {
			while (aux.next()) {
				Estudiante aEstudiante = new Estudiante();
				aEstudiante.set_dni(aux.getString("dni"));
				aEstudiante.set_nombre(aux.getString("Nombre"));
				aEstudiante.set_apellidos(aux.getString("Apellidos"));
				aEstudiante.set_titulacion(aux.getString("Titulacion"));
				aEstudiante.set_cualificacion(aux.getString("Cualificacion"));
			}
		} catch (SQLException e) {
				e.printStackTrace();
				Logger.getLogger(loggerName).log(Level.SEVERE,"Error al acceder a la tabla Estudiante");
			}

		return Estudiantes; 
	}
	public Estudiante buscarestudiante (Estudiante aEstudiante) {
		// El dni es el Estudiante que queremos seleccionar, el nombre de la clase "Estudiante" es la tabla que queremos
		// buscar y la cadena del final representa la clave que usamos para hacer la seleccion.
		ResultSet aux = get(aEstudiante);
		Estudiante estudiante1 =null;
			
					try {
						while (aux.next()) {
						estudiante1 = new Estudiante();
						estudiante1.set_dni(aux.getString("dni"));
						estudiante1.set_nombre(aux.getString("Nombre"));
						estudiante1.set_apellidos(aux.getString("Apellidos"));
						estudiante1.set_titulacion(aux.getString("Titulacion"));
						estudiante1.set_cualificacion(aux.getString("Cualificacion"));
						}
				
					} catch (SQLException e) {
						Logger.getLogger(loggerName).log(Level.SEVERE,"Estudiante no encontrado");
		
					}		
				
			
		return estudiante1;
		
	}

}

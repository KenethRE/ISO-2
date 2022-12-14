package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import negocio.entities.Estudiante;

public class EstudianteDAO <E> extends AbstractEntityDAO<E> {
	public int crearNuevoEstudiante(Estudiante aEstudiante) {
		 
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
			Logger.getLogger("GDTP_Logger").log(Level.SEVERE,"Estudiante no encontrado");
			resultado = 1;
		}
		
			
		return resultado;
		
	}

	public int  editarEstudiantes(Estudiante aEstudiante) {
		// El dni Estudiante es el estudiante que queremos editar, el nombre de la clase "Estudiante" es la tabla que queremos
				try{
					seleccionarEstudiante(aEstudiante);
					//primero busca que el estudiante exista si no salta la excepcion lo modifica
					update (aEstudiante);
					return 0;
					
				} catch (NullPointerException e) {
					e.printStackTrace();
					Logger.getLogger("GDTP_Logger").log(Level.SEVERE, "Estudiante no encontrado");
				}
				
				return 0;
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
				aEstudiante.set_cualificacion(aux.getNString("Cualificacion"));
			}
		} catch (SQLException e) {
				e.printStackTrace();
				Logger.getLogger("GDTP_Logger").log(Level.SEVERE,"Error al acceder a la tabla Estudiante");
			}

		return Estudiantes; 
	}

}

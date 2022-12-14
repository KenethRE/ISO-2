package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import negocio.entities.ProfesorUCLM;

public class ProfesorUCLMDAO<E> extends AbstractEntityDAO<E> {
	public int crearNuevoProfesor(ProfesorUCLM aProfesor) {
		 
		return insert (aProfesor);
	}

	public int seleccionarProfesor(ProfesorUCLM aProfesor) {
		// El iD curso es el curso que queremos seleccionar, el nombre de la clase "Profesor" es la tabla que queremos
		// buscar y la cadena del final representa la clave que usamos para hacer la seleccion.
		ResultSet aux = get(aProfesor);
		try {
			while (aux.next()) {
				aProfesor.set_dni(aux.getNString("dni"));
				aProfesor.set_nombre(aux.getString("NOMBRE"));
				aProfesor.set_apellidos(aux.getString("APELLIDOS"));
				aProfesor.set_doctor(aux.getBoolean("DOCTOR"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger("GDTP_Logger").log(Level.SEVERE,"ProfesorUCLM no encontrado");
		}
		
			
		return 0;
		
	}

	public int editarProfesor(ProfesorUCLM aProfesor) {
		// El dni Profesor es el profesor que queremos editar, el nombre de la clase "Profesor" es la tabla que queremos
		try{
			seleccionarProfesor(aProfesor);
			//primero busca que el profesor exista si no salta la excepcion lo modifica
			update (aProfesor);
			return 0;
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			Logger.getLogger("GDTP_Logger").log(Level.SEVERE, "Profesor UCLM no encontrado");
		}
		
		return 0;
	}

	public List<ProfesorUCLM> listarProfesores() {
		List<ProfesorUCLM> Profesores = new ArrayList<ProfesorUCLM>();
		ResultSet aux = get("Profesor");
		try {
			while (aux.next()) {
				ProfesorUCLM aProfesor = new ProfesorUCLM();
				aProfesor.set_dni(aux.getString("DNI"));
				aProfesor.set_nombre(aux.getString("NOMBRE"));
				aProfesor.set_apellidos(aux.getString("APELLIDOS"));
				aProfesor.set_doctor(aux.getBoolean("DOCTOR"));
			}
		} catch (SQLException e) {
				e.printStackTrace();
				Logger.getLogger("GDTP_Logger").log(Level.SEVERE,"Error al acceder a la tabla ProfesoresUCLM");
			}

		return Profesores; 
	}

}

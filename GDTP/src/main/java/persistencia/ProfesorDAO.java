package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import negocio.entities.Profesor;

public class ProfesorDAO<E> extends AbstractEntityDAO<E> {

	public int crearNuevoProfesor(Profesor aProfesor) {
		 
		return insert (aProfesor);
	}

	public int seleccionarProfesor(Profesor aProfesor) {
		// El iD curso es el curso que queremos seleccionar, el nombre de la clase "Profesor" es la tabla que queremos
		// buscar y la cadena del final representa la clave que usamos para hacer la seleccion.
		int resultado = 0;
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
			resultado = 1;
			Logger.getLogger("GDTP_Logger").log(Level.SEVERE,"Profesor no encontrado");
		}
		
			
		return resultado;
		
	}

	public int editarProfesor(Profesor aProfesor) {
		// El dni Profesor es el profesor que queremos editar, el nombre de la clase "Profesor" es la tabla que queremos
		int resultado = 0;
		try{
			seleccionarProfesor(aProfesor);
			//primero busca que el profesor exista si no salta la excepcion lo modifica
			resultado = update (aProfesor);
			return resultado;
			
		} catch (NullPointerException e) {
			Logger.getLogger("GDTP_Logger").log(Level.SEVERE, "Profesor no encontrado.");
			e.printStackTrace();
		}
		
		return resultado;
	}

	public List<Profesor> listarProfesores() {
		List<Profesor> Profesores = new ArrayList<>();
		ResultSet aux = get("Profesor");
		try {
			while (aux.next()) {
				Profesor aProfesor = new Profesor();
				aProfesor.set_dni(aux.getString("DNI"));
				aProfesor.set_nombre(aux.getString("NOMBRE"));
				aProfesor.set_apellidos(aux.getString("APELLIDOS"));
				aProfesor.set_doctor(aux.getBoolean("DOCTOR"));
				Profesores.add(aProfesor);
			}
		} catch (SQLException e) {
				e.printStackTrace();
				Logger.getLogger("GDTP_Logger").log(Level.SEVERE,"Error al acceder a la tabla Profesores");
			}

		return Profesores; 
	}
}


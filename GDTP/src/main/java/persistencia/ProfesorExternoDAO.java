package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import negocio.entities.ProfesorExterno;

public class ProfesorExternoDAO<E> extends AbstractEntityDAO<E> {
	public int crearNuevoProfesor(ProfesorExterno aProfesor) throws SQLException {
		 
		return insert (aProfesor);
	}

	public int seleccionarProfesor(ProfesorExterno aProfesor) {
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
			Logger.getLogger("GDTP_Logger").log(Level.SEVERE,"Profesor Externo no encontrado");
		}
		
			
		return resultado;
		
	}

	public int editarProfesor(ProfesorExterno aProfesor) {
		// El dni Profesor es el profesor que queremos editar, el nombre de la clase "Profesor" es la tabla que queremos
		int resultado = 0;
		try{
			seleccionarProfesor(aProfesor);
			//primero busca que el profesor exista si no salta la excepcion lo modifica
			resultado = update (aProfesor);
			return resultado;
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			Logger.getLogger("GDTP_Logger").log(Level.SEVERE, "Profesor Externo no encontrado.");
		}
		
		return resultado;
	}

	public List<ProfesorExterno> listarProfesores() {
		List<ProfesorExterno> Profesores = new ArrayList<>();
		ResultSet aux = get("Profesor");
		try {
			while (aux.next()) {
				ProfesorExterno aProfesor = new ProfesorExterno();
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

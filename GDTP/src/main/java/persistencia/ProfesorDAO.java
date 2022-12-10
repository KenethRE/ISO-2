package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import negocio.entities.Profesor;
import negocio.entities.TipoCurso;

public class ProfesorDAO<E> extends AbstractEntityDAO<E> {

	public int crearNuevoProfesor(Profesor aProfesor) throws SQLException {
		 
		return insert (aProfesor);
	}

	public int seleccionarProfesor(Profesor aProfesor) {
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
			System.out.println("Profesor no encontrado");
		}
		
			
		return 0;
		
	}

	public int editarProfesor(Profesor aProfesor) {
		// El dni Profesor es el profesor que queremos editar, el nombre de la clase "Profesor" es la tabla que queremos
		try{
			seleccionarProfesor(aProfesor);
			//primero busca que el profesor exista si no salta la excepcion lo modifica
			update (aProfesor);
			return 0;
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public List<Profesor> listarProfesores() {
		List<Profesor> Profesores = new ArrayList<Profesor>();
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
				System.out.println("Error al acceder a la tabla Profesores");
			}

		return Profesores; 
	}
}


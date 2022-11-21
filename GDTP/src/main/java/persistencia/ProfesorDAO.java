package persistencia;

import java.sql.*;
import java.util.List;

import negocio.entities.Profesor;
import negocio.entities.TipoCurso;

public class ProfesorDAO<E> extends AbstractEntityDAO<E> {

	public int crearNuevoProfesor(Profesor aProfesor) {
		throw new UnsupportedOperationException();
	}

	public Profesor seleccionarProfesor(Profesor aProfesor) {
		Profesor profesor = new Profesor (aProfesor.get_dni());
		// El iD curso es el curso que queremos seleccionar, el nombre de la clase "CursoPropio" es la tabla que queremos
		// buscar y la cadena del final representa la clave que usamos para hacer la seleccion.
		ResultSet aux = get(profesor.get_dni(), profesor.getClass().getSimpleName(), "DNI");
		try {
			while (aux.next()) {
				profesor.set_nombre(aux.getString("NOMBRE"));
				profesor.set_apellidos(aux.getString("APELLIDOS"));
				profesor.set_doctor(aux.getBoolean("DOCTOR"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Profesor no encontrado");
		}
		
			
		return profesor;
		
	}

	public Profesor editarProfesor(Profesor aProfesor) {
		throw new UnsupportedOperationException();
	}

	public List<Profesor> listarProfesoresdoctores(Boolean adoctor) {
		throw new UnsupportedOperationException();
	}

	public double listarIngresos(TipoCurso aTipo, Date aFechaInicio, Date aFechaFin) {
		throw new UnsupportedOperationException();
	}

	public void listarEdicionesCursos(Date aFechaInicio, Date aFechaFin) {
		throw new UnsupportedOperationException();
	}
}
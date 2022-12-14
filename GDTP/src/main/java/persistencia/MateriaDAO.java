package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import negocio.entities.Materia;

public class MateriaDAO<E> extends AbstractEntityDAO<E> {
	public int crearNuevaMateria(Materia aMateria) {
		 
		return insert (aMateria);
	}

	public int seleccionarMateria(Materia aMateria) {
		// El nombre es la materia que queremos seleccionar, el nombre de la clase "Materia" es la tabla que queremos
		// buscar y la cadena del final representa la clave que usamos para hacer la seleccion.
		ResultSet aux = get(aMateria);
		try {
			while (aux.next()) {
				aMateria.set_nombre(aux.getString("Nombre"));
				aMateria.set_horas(aux.getDouble("horas"));
				aMateria.set_fechaInicio(aux.getDate("FechaInicio"));
				aMateria.set_fechaFin(aux.getDate("FechaFin"));
				aMateria.setId_Curso(aux.getString("idCurso"));
				aMateria.setId_prof_responsable(aux.getString("dniProfesor"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger("GDTP_Logger").log(Level.SEVERE,"Materia no encontrada");
		}
		
			
		return 0;
		
	}

	public int  editarMateria(Materia aMateria) {
		// El nombre de la materia es la materia que queremos editar, el nombre de la clase "Materia" es la tabla que queremos
				try{
					seleccionarMateria(aMateria);
					//primero busca que la materia exista si no salta la excepcion lo modifica
					update (aMateria);
					return 0;
					
				} catch (NullPointerException e) {
					e.printStackTrace();
					Logger.getLogger("GDTP_Logger").log(Level.SEVERE, "Materia no encontrada");
				}
				
				return 0;
	}

	public List<Materia> listarMaterias() {
		List<Materia> Materias = new ArrayList<>();
		ResultSet aux = get("Materia");
		try {
			while (aux.next()) {
				Materia aMateria = new Materia();
				aMateria.set_nombre(aux.getString("Nombre"));
				aMateria.set_horas(aux.getDouble("horas"));
				aMateria.set_fechaInicio(aux.getDate("FechaInicio"));
				aMateria.set_fechaFin(aux.getDate("FechaFin"));
				aMateria.setId_Curso(aux.getString("idCurso"));
				aMateria.setId_prof_responsable(aux.getString("dniProfesor"));
				Materias.add(aMateria);
			}
		} catch (SQLException e) {
				e.printStackTrace();
				Logger.getLogger("GDTP_Logger").log(Level.SEVERE,"Error al acceder a la tabla Materia");
			}

		return Materias; 
	}
}

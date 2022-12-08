package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import negocio.entities.Materia;

public class MateriaDAO<E> extends AbstractEntityDAO<E> {
	public int crearNuevaMateria(Materia aMateria) throws SQLException {
		 
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
			System.out.println("Materia no encontrada");
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
				}
				
				return 0;
	}

	public List<Materia> listarMaterias() {
		List<Materia> Materias = new ArrayList<Materia>();
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
				System.out.println("Error al acceder a la tabla Materia");
			}

		return Materias; 
	}
}

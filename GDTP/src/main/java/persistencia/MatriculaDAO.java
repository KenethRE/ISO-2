package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import negocio.entities.Matricula;
import negocio.entities.ModoPago;

public class MatriculaDAO <E> extends AbstractEntityDAO<E> {
	public int crearNuevaMatricula(Matricula aMatricula) throws SQLException {
		return insert (aMatricula);
	}

	public int seleccionarMatricula(Matricula aMatricula) {
		// El iD curso es el curso que queremos seleccionar, el nombre de la clase "Profesor" es la tabla que queremos
		// buscar y la cadena del final representa la clave que usamos para hacer la seleccion.
		ResultSet aux = get(aMatricula);
		try {
			while (aux.next()) {
				aMatricula.setiD(aux.getInt("id"));
				aMatricula.set_fecha(aux.getDate("fecha"));
				aMatricula.set_pagado(aux.getBoolean("Pagado"));
				aMatricula.setId_estudiante(aux.getString("dniEstudiante"));
				aMatricula.setId_Curso(aux.getString("idCurso"));
				aMatricula.set_tipoPago(ModoPago.valueOf(aux.getString("ModoPago")));
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Matricula no encontrado");
		}
		
			
		return 0;
		
	}

	public int editarMatricula(Matricula aMatricula) {
		
		// El iD matricula es la matricula que queremos editar, el nombre de la clase "Matricula" es la tabla que queremos
		try{
			seleccionarMatricula(aMatricula);
			//primero busca que la matricula exista si no salta la excepcion lo modifica
			update (aMatricula);
			return 0;
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public List<Matricula> listarMatricula() {
		List<Matricula> Matriculas = new ArrayList<Matricula>();
		ResultSet aux = get("Profesor");
		try {
			while (aux.next()) {
				Matricula aMatricula = new Matricula();
				aMatricula.setiD(aux.getInt("id"));
				aMatricula.set_fecha(aux.getDate("fecha"));
				aMatricula.set_pagado(aux.getBoolean("Pagado"));
				aMatricula.setId_estudiante(aux.getString("dniEstudiante"));
				aMatricula.setId_Curso(aux.getString("idCurso"));
				aMatricula.set_tipoPago(ModoPago.valueOf(aux.getString("ModoPago")));
			} 
		} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error al acceder a la tabla Matriculas");
			}

		return Matriculas; 
	}
}



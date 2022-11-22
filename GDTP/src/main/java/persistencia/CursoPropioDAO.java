package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.TipoCurso;

public class CursoPropioDAO<E> extends AbstractEntityDAO<E> {

	public int crearNuevoCurso(CursoPropio aCurso) throws SQLException {
		int aux= 0;
		aux = insert (aCurso);
		
		return aux;
	}

	public CursoPropio seleccionarCurso(CursoPropio aCurso) {
		CursoPropio curso = new CursoPropio (aCurso.get_id());
		// El iD curso es el curso que queremos seleccionar, el nombre de la clase "CursoPropio" es la tabla que queremos
		// buscar y la cadena del final representa la clave que usamos para hacer la seleccion.
		ResultSet aux = get(curso.get_id(), curso.getClass().getSimpleName(),"ID");
		try {
			while (aux.next()) {
				curso.set_nombre(aux.getString("NOMBRE"));
				curso.set_eCTS(aux.getInt("ECTS"));
				curso.set_fechaInicio(aux.getDate("FECHAINICIO"));
				curso.set_fechaFin(aux.getDate("FECHAFIN"));
				curso.set_tasaMatricula(aux.getInt("TASAMATRICULA"));
				curso.set_edicion(aux.getInt("EDICION"));
				curso.setId_centro(aux.getInt("IDCENTRO"));
				curso.setId_director(aux.getString("DIRECTOR"));
				curso.setId_secretario(aux.getString("SECRETARIO"));
				//TO DO : COMO SE HACE CON LOS ENUM
				//curso.set_tipo(aux.getString("TIPOCURSO"));
				//curso.set_estado(aux.getString("ESTADOCURSO"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Curso no encontrado");
		}
		
		return curso;
		
	}

	public CursoPropio editarCurso(CursoPropio aCurso) {
		CursoPropio curso = new CursoPropio(aCurso.get_id());
		// El iD curso es el curso que queremos editar, el nombre de la clase "CursoPropio" es la tabla que queremos
		try{
			curso = seleccionarCurso(aCurso);
			//primero busca que el curso exista si no salta la excepcion lo modifica
		
			int aux= 0;
			aux = update (aCurso);
				
			return curso;
				
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		return curso;
		
	}

	public List<CursoPropio> listarCursosPorEstado(EstadoCurso aEstado, Date aFechaInicio, Date aFechaFin) {
		List<CursoPropio> Cursos = new ArrayList<CursoPropio>();
		CursoPropio curso = new CursoPropio();
		
		ResultSet aux = get_estado(curso.getClass().getSimpleName(), aEstado, aFechaInicio, aFechaFin);
		try {
			while (aux.next()) {
				curso.set_id(aux.getString("ID"));
				curso.set_nombre(aux.getString("NOMBRE"));
				curso.set_eCTS(aux.getInt("ECTS"));
				curso.set_fechaInicio(aux.getDate("FECHAINICIO"));
				curso.set_fechaFin(aux.getDate("FECHAFIN"));
				curso.set_tasaMatricula(aux.getInt("TASAMATRICULA"));
				curso.set_edicion(aux.getInt("EDICION"));
				curso.setId_centro(aux.getInt("IDCENTRO"));
				curso.setId_director(aux.getString("DIRECTOR"));
				curso.setId_secretario(aux.getString("SECRETARIO"));
				//TO DO : COMO SE HACE CON LOS ENUM
				//curso.set_tipo(aux.getString("TIPOCURSO"));
				//curso.set_estado(aux.getString("ESTADOCURSO"));
				Cursos.add(curso);
			}
			
			return Cursos;
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Curso no encontrado");
		}
		
		return Cursos;
	}

	public double listarIngresos(TipoCurso aTipo, Date aFechaInicio, Date aFechaFin) {
		double total=0;
		CursoPropio curso = new CursoPropio();
		
		ResultSet aux = get_tipo(curso.getClass().getSimpleName(), aTipo, aFechaInicio, aFechaFin);
		try {
			if (aux.next()) {
				total = aux.getDouble(0);
				return total;
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Curso no encontrado");
		}
		
		
		return total;
	}

	public void listarEdicionesCursos(Date aFechaInicio, Date aFechaFin) {
		CursoPropio curso = new CursoPropio();
		ResultSet aux = get_edicion(curso.getClass().getSimpleName(), aFechaInicio, aFechaFin);
		try {
			while (aux.next()) {
				curso.set_id(aux.getString("ID"));
				curso.set_nombre(aux.getString("NOMBRE"));
				curso.set_eCTS(aux.getInt("ECTS"));
				curso.set_fechaInicio(aux.getDate("FECHAINICIO"));
				curso.set_fechaFin(aux.getDate("FECHAFIN"));
				curso.set_tasaMatricula(aux.getInt("TASAMATRICULA"));
				curso.set_edicion(aux.getInt("EDICION"));
				curso.setId_centro(aux.getInt("IDCENTRO"));
				curso.setId_director(aux.getString("DIRECTOR"));
				curso.setId_secretario(aux.getString("SECRETARIO"));
				//TO DO : COMO SE HACE CON LOS ENUM
				//curso.set_tipo(aux.getString("TIPOCURSO"));
				//curso.set_estado(aux.getString("ESTADOCURSO"));
			}
			

		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Curso no encontrado");
		}
		
	}
}
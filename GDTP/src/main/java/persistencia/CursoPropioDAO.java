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

	public int seleccionarCurso(CursoPropio aCurso) {
		// El iD curso es el curso que queremos seleccionar, el nombre de la clase "CursoPropio" es la tabla que queremos
		// buscar y la cadena del final representa la clave que usamos para hacer la seleccion.
		ResultSet aux = get(aCurso);
		try {
			while (aux.next()) {
				aCurso.set_nombre(aux.getString("NOMBRE"));
				aCurso.set_eCTS(aux.getInt("ECTS"));
				aCurso.set_fechaInicio(aux.getDate("FECHAINICIO"));
				aCurso.set_fechaFin(aux.getDate("FECHAFIN"));
				aCurso.set_tasaMatricula(aux.getInt("TASAMATRICULA"));
				aCurso.set_edicion(aux.getInt("EDICION"));
				aCurso.setId_centro(aux.getInt("IDCENTRO"));
				aCurso.setId_director(aux.getString("DIRECTOR"));
				aCurso.setId_secretario(aux.getString("SECRETARIO"));
				aCurso.set_tipo(TipoCurso.valueOf(aux.getString("TIPOCURSO")));
				aCurso.set_estado(EstadoCurso.valueOf(aux.getString("ESTADOCURSO")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Curso no encontrado");
		}
		
		return 0;
		
	}

	public int editarCurso(CursoPropio aCurso) {
		// El iD curso es el curso que queremos editar, el nombre de la clase "CursoPropio" es la tabla que queremos
		try{
			seleccionarCurso(aCurso);
			//primero busca que el curso exista si no salta la excepcion lo modifica
			update (aCurso);
			return 0;
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}

	public List<CursoPropio> listarCursosPorEstado(EstadoCurso aEstado, Date aFechaInicio, Date aFechaFin) {
		List<CursoPropio> Cursos = new ArrayList<CursoPropio>();
		
		
		ResultSet aux = get("Curso", aEstado, aFechaInicio, aFechaFin);
		try {
			while (aux.next()) {
				CursoPropio curso = new CursoPropio();
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
				curso.set_tipo(TipoCurso.valueOf(aux.getString("TIPOCURSO")));
				curso.set_estado(EstadoCurso.valueOf(aux.getString("ESTADOCURSO")));
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
		
		ResultSet aux = get("Curso", aTipo, aFechaInicio, aFechaFin);
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
				TipoCurso Tcurso =  TipoCurso.valueOf(aux.getString("TIPOCURSO"));
				curso.set_tipo(Tcurso);
				EstadoCurso Ecurso = EstadoCurso.valueOf(aux.getString("ESTADOCURSO"));
				curso.set_estado(Ecurso);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Curso no encontrado");
		}
		
	}
}
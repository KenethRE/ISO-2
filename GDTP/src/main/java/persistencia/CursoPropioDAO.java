package persistencia;

import java.sql.*;
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
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Curso no encontrado");
		}
		
			
		return curso;
		
	}

	public CursoPropio editarCurso(CursoPropio aCurso) {
		throw new UnsupportedOperationException();
	}

	public List<CursoPropio> listarCursosPorEstado(EstadoCurso aEstado, Date aFechaInicio, Date aFechaFin) {
		throw new UnsupportedOperationException();
	}

	public double listarIngresos(TipoCurso aTipo, Date aFechaInicio, Date aFechaFin) {
		throw new UnsupportedOperationException();
	}

	public void listarEdicionesCursos(Date aFechaInicio, Date aFechaFin) {
		throw new UnsupportedOperationException();
	}
}
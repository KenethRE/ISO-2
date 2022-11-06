package persistencia;

import java.sql.Date;

import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.TipoCurso;

public class CursoPropioDAO<E> extends AbstractEntityDAO<E> {

	public int crearNuevoCurso(CursoPropio aCurso) {
		throw new UnsupportedOperationException();
	}

	public CursoPropio seleccionarCurso(CursoPropio aCurso) {
		throw new UnsupportedOperationException();
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
package negocio.controllers;

import java.sql.Date;
import java.util.List;

import negocio.entities.CursoPropio;
import negocio.entities.TipoCurso;
import negocio.entities.EstadoCurso;

public class GestorConsultas {

	public List<CursoPropio> consultarIngresos(TipoCurso aTipo, Date aFechaInicio, Date aFechaFin) {
		throw new UnsupportedOperationException();
	}

	public List<CursoPropio> consultarEstadoCursos(EstadoCurso aEstadoCurso, Date aFechaInicio, Date aFechaFin) {
		throw new UnsupportedOperationException();
	}

	public List<CursoPropio> listarEdicionesCursos(Date aFechaInicio, Date aFechaFin) {
		throw new UnsupportedOperationException();
	}
}
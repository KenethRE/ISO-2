package negocio.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import negocio.entities.CursoPropio;
import negocio.entities.TipoCurso;
import persistencia.AbstractEntityDAO;
import persistencia.CursoPropioDAO;
import persistencia.MateriaDAO;
import negocio.entities.EstadoCurso;
import negocio.entities.Materia;

public class GestorConsultas {

	public List<CursoPropio> consultarIngresos(TipoCurso aTipo, Date aFechaInicio, Date aFechaFin) {
		CursoPropioDAO<CursoPropio> CursoDAO = new CursoPropioDAO<CursoPropio>();
		List<CursoPropio> listaCursos = new ArrayList<CursoPropio>();	
		listaCursos=CursoDAO.listaIngresos(aTipo,aFechaInicio,aFechaFin);
		return listaCursos;
	}

	public List<CursoPropio> consultarEstadoCursos(EstadoCurso aEstadoCurso, Date aFechaInicio, Date aFechaFin) {
		CursoPropioDAO<CursoPropio> CursoDAO = new CursoPropioDAO<CursoPropio>();
		List<CursoPropio> listaCursos = new ArrayList<CursoPropio>();	
		listaCursos=CursoDAO.listarCursosPorEstado(aEstadoCurso,aFechaInicio,aFechaFin);
		return listaCursos;
	}

	public List<CursoPropio> listarEdicionesCursos(Date aFechaInicio, Date aFechaFin) {
		throw new UnsupportedOperationException();
	}
}
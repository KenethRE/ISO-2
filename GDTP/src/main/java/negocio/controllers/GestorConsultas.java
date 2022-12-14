package negocio.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import negocio.entities.CursoPropio;
import negocio.entities.TipoCurso;
import persistencia.CursoPropioDAO;
import negocio.entities.EstadoCurso;

public class GestorConsultas {

	public List<List<String>> consultarIngresos(TipoCurso aTipo, Date aFechaInicio, Date aFechaFin) {
		CursoPropioDAO<CursoPropio> CursoDao = new CursoPropioDAO<>();
		List<List<String>> ingresos = new ArrayList<>();	
		ingresos=CursoDao.listarIngresos(aTipo,aFechaInicio,aFechaFin);
		return ingresos;
	}

	public List<CursoPropio> consultarEstadoCursos(EstadoCurso aEstadoCurso, Date aFechaInicio, Date aFechaFin) {
		CursoPropioDAO<CursoPropio> CursoDao = new CursoPropioDAO<>();
		List<CursoPropio> listaCursos = new ArrayList<>();	
		listaCursos=CursoDao.listarCursosPorEstado(aEstadoCurso,aFechaInicio,aFechaFin);
		return listaCursos;
	}

	public List<CursoPropio> listarEdicionesCursos(Date aFechaInicio, Date aFechaFin) {
		CursoPropioDAO<CursoPropio> CursoDao = new CursoPropioDAO<>();
		List<CursoPropio> listaEdiciones= new ArrayList<>();	
		listaEdiciones=CursoDao.listarEdicionesCursos(aFechaInicio,aFechaFin);
		return listaEdiciones;
	}
}
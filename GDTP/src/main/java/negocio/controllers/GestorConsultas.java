package negocio.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import negocio.entities.CursoPropio;
import negocio.entities.TipoCurso;
import persistencia.CursoPropioDAO;
import persistencia.EstudianteDAO;
import negocio.entities.EstadoCurso;
import negocio.entities.Estudiante;

public class GestorConsultas {

	public List<List<String>> consultarIngresos(TipoCurso aTipo, Date aFechaInicio, Date aFechaFin) {
		CursoPropioDAO<CursoPropio> cursoDao = new CursoPropioDAO<>();
		List<List<String>> ingresos = new ArrayList<>();	
		ingresos=cursoDao.listarIngresos(aTipo,aFechaInicio,aFechaFin);
		return ingresos;
	}

	public List<CursoPropio> consultarEstadoCursos(EstadoCurso aEstadoCurso, Date aFechaInicio, Date aFechaFin) {
		CursoPropioDAO<CursoPropio> cursoDao = new CursoPropioDAO<>();
		List<CursoPropio> listaCursos = new ArrayList<>();	
		listaCursos=cursoDao.listarCursosPorEstado(aEstadoCurso,aFechaInicio,aFechaFin);
		return listaCursos;
	}

	public List<CursoPropio> listarEdicionesCursos(Date aFechaInicio, Date aFechaFin) {
		CursoPropioDAO<CursoPropio> cursoDao = new CursoPropioDAO<>();
		List<CursoPropio> listaEdiciones= new ArrayList<>();	
		listaEdiciones=cursoDao.listarEdicionesCursos(aFechaInicio,aFechaFin);
		return listaEdiciones;
	}
	public CursoPropio seleccionarCursoPropio(CursoPropio cursoPropio) {
		CursoPropioDAO<CursoPropio> cursoDao = new CursoPropioDAO<>();
		cursoPropio = cursoDao.SeleccionarCursoPropio(cursoPropio);
		return cursoPropio;
		
		
	}
	public  List<CursoPropio> listartodolosCursoPropios() {
		CursoPropioDAO<CursoPropio> cursoDao = new CursoPropioDAO<>();
		List<CursoPropio> listaCursos = new ArrayList<>();	
		listaCursos=cursoDao.listartodosloscursos();
		return listaCursos;
		
		
	}
	public Estudiante buscarEstudiante(Estudiante estudiante) {
		EstudianteDAO<Estudiante> estudianteDAO = new EstudianteDAO<>();
		estudiante = estudianteDAO.buscarestudiante(estudiante);
		return estudiante;
		
	}
}
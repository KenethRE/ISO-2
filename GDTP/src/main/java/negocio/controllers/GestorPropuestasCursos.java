package negocio.controllers;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import persistencia.CursoPropioDAO;

public class GestorPropuestasCursos {

	public void realizarPropuestaCurso(CursoPropio aCurso) throws SQLDataException{
		CursoPropioDAO<CursoPropio> cursoPropioDao = new CursoPropioDAO<>() ;
		cursoPropioDao.crearNuevoCurso(aCurso);
		
		throw new SQLDataException("no permitido");
	}

	public boolean editarPropuestaCurso(CursoPropio curso) {
		CursoPropioDAO<CursoPropio> cursoDao = new CursoPropioDAO<>();
		curso.set_estado(EstadoCurso.VALIDADO);
		if(cursoDao.editarCurso(curso)==0) {
			return true;
		}
		return false;
	}

	
	public boolean rechazarPropuestaCurso(CursoPropio curso) {
		CursoPropioDAO<CursoPropio> cursoDao = new CursoPropioDAO<>();
		curso.set_estado(EstadoCurso.PROPUESTA_RECHAZADA);
		if(cursoDao.editarCurso(curso)==0) {
			return true;
		}
		return false;
	}


	
	public List<CursoPropio> listaCursoAprobado() {
		EstadoCurso aEstadoCurso = EstadoCurso.PROPUESTO;
		CursoPropioDAO<CursoPropio> cursoDAO = new CursoPropioDAO<>();
		List<CursoPropio> listaCursos = new ArrayList<>();	
		listaCursos=cursoDAO.listarCursosPorEstado(aEstadoCurso);
		return listaCursos;
	}
	
	
}
package negocio.controllers;

import java.util.ArrayList;
import java.util.List;

import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import persistencia.CursoPropioDAO;

public class GestorPropuestasCursos {

	public void realizarPropuestaCurso(CursoPropio aCurso) {
		
		throw new UnsupportedOperationException();
	}

	public boolean editarPropuestaCurso(CursoPropio curso) {
		CursoPropioDAO<CursoPropio> CursoDao = new CursoPropioDAO<>();
		curso.set_estado(EstadoCurso.VALIDADO);
		if(CursoDao.editarCurso(curso)==0) {
			return true;
		}
		return false;
	}

	
	public boolean rechazarPropuestaCurso(CursoPropio curso) {
		CursoPropioDAO<CursoPropio> CursoDao = new CursoPropioDAO<>();
		curso.set_estado(EstadoCurso.PROPUESTA_RECHAZADA);
		if(CursoDao.editarCurso(curso)==0) {
			return true;
		}
		return false;
	}

	public void altaCursoAprobado(CursoPropio aCurso) {
		throw new UnsupportedOperationException();
	}
	
	public List<CursoPropio> listaCursoAprobado() {
		EstadoCurso aEstadoCurso = EstadoCurso.PROPUESTO;
		CursoPropioDAO<CursoPropio> CursoDAO = new CursoPropioDAO<>();
		List<CursoPropio> listaCursos = new ArrayList<>();	
		listaCursos=CursoDAO.listarCursosPorEstado(aEstadoCurso);
		return listaCursos;
	}
	
	
}
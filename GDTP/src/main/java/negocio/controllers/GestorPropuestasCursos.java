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
		CursoPropioDAO<CursoPropio> CursoDAO = new CursoPropioDAO<CursoPropio>();
		curso.set_estado(EstadoCurso.VALIDADO);
		if(CursoDAO.editarCurso(curso)==0) {
			return true;
		}
		return false;
	}

	public EstadoCurso evaluarPropuesta(CursoPropio aCurso) {
		
		throw new UnsupportedOperationException();
	}

	public void altaCursoAprobado(CursoPropio aCurso) {
		throw new UnsupportedOperationException();
	}
	
	public List<CursoPropio> listaCursoAprobado() {
		EstadoCurso aEstadoCurso = EstadoCurso.PROPUESTO;
		CursoPropioDAO<CursoPropio> CursoDAO = new CursoPropioDAO<CursoPropio>();
		List<CursoPropio> listaCursos = new ArrayList<CursoPropio>();	
		listaCursos=CursoDAO.listarCursosPorEstado(aEstadoCurso);
		return listaCursos;
	}
	
	
}
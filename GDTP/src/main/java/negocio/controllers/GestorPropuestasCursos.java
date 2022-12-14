package negocio.controllers;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import persistencia.CursoPropioDAO;

public class GestorPropuestasCursos {


	public void realizarPropuestaCurso(CursoPropio aCurso) throws SQLException {
		if (aCurso==null) {
			throw new SQLDataException("no permitido");
		}
		else {
		CursoPropioDAO<CursoPropio> cursoPropioDao = new CursoPropioDAO<>() ;
		cursoPropioDao.crearNuevoCurso(aCurso);
		}
	}
	
	public boolean evaluarPropuestaCurso(CursoPropio curso, EstadoCurso estado) {
		CursoPropioDAO<CursoPropio> cursoDao = new CursoPropioDAO<>();
		curso.set_estado(estado);
		if(cursoDao.editarCurso(curso)==1) {
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
package negocio.controllers;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import negocio.entities.Matricula;
import persistencia.MatriculaDAO;

public class GestorMatriculacion {

	public void realizarMatriculacion(Matricula matricula) throws SQLException {
		MatriculaDAO<Matricula> agenteMatriculaDAO = new MatriculaDAO<>();
		try {
			agenteMatriculaDAO.crearNuevaMatricula(matricula);
		} catch (SQLSyntaxErrorException e) {
			e.printStackTrace();
			throw e;
		}
	}

//	public void realizarPagoMatricula(CursoPropio aCurso, Estudiante aEstudiante) {
//		throw new UnsupportedOperationException();
//	}
//
//	private void realizarPagoTarjeta(CursoPropio aCurso, Estudiante aEstudiante) {
//		throw new UnsupportedOperationException();
//	}
//
//	private void realizarPagoTransferencia(CursoPropio aCurso, Estudiante aEstudiante) {
//		throw new UnsupportedOperationException();
//	}
//
//	private void operation() {
//		throw new UnsupportedOperationException();
//	}
}
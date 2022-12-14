package negocio.controllers;

import java.sql.SQLException;

import negocio.entities.CursoPropio;
import negocio.entities.Estudiante;
import negocio.entities.Matricula;
import persistencia.MatriculaDAO;

public class GestorMatriculacion {

	public void realizarMatriculacion(Matricula matricula) throws SQLException {
		MatriculaDAO<Matricula> agenteMatriculaDAO = new MatriculaDAO<>();
		agenteMatriculaDAO.crearNuevaMatricula(matricula);
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
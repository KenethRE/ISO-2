package negocio.controllers;

import negocio.entities.Matricula;
import persistencia.MatriculaDAO;

public class GestorMatriculacion {

	public void realizarMatriculacion(Matricula matricula) {
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
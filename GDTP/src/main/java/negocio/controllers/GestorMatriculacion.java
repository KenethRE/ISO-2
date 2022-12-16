package negocio.controllers;

import java.sql.SQLDataException;

import negocio.entities.Matricula;
import persistencia.MatriculaDAO;

public class GestorMatriculacion {

	public void realizarMatriculacion(Matricula matricula) throws NullPointerException{
		MatriculaDAO<Matricula> agenteMatriculaDAO = new MatriculaDAO<>();
		agenteMatriculaDAO.crearNuevaMatricula(matricula);
		throw new NullPointerException("Matricula no generada");
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
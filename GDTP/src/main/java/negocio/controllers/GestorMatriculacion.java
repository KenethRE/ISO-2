package negocio.controllers;

import java.sql.SQLDataException;

import negocio.entities.Matricula;
import persistencia.MatriculaDAO;

public class GestorMatriculacion {

	public void realizarMatriculacion(Matricula matricula) throws NullPointerException{
		if (matricula == null)
			throw new NullPointerException ("matricula nula");
		else {
		MatriculaDAO<Matricula> agenteMatriculaDAO = new MatriculaDAO<>();
		agenteMatriculaDAO.crearNuevaMatricula(matricula);
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
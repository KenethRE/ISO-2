/**
 * 
 */
package negocio.controllers;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLDataException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;

/**
 * @author plati
 *
 */
public class GestorPropuestaCursoTest {
	GestorPropuestasCursos gestorPropuestaCurso;
	CursoPropio cursoPropio;
	EstadoCurso estadoCurso;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		gestorPropuestaCurso= new GestorPropuestasCursos();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link negocio.controllers.GestorPropuestasCursos#realizarPropuestaCurso(negocio.entities.CursoPropio)}.
	 */
	@Test
	public void testRealizarPropuestaCurso() {
		cursoPropio = new CursoPropio();
	    SQLDataException exception = assertThrows(SQLDataException.class, () -> {gestorPropuestaCurso.realizarPropuestaCurso(cursoPropio);});
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link negocio.controllers.GestorPropuestasCursos#evaluarPropuestaCurso(negocio.entities.CursoPropio)}.
	 */
	@Test
	public void testEvaluarPropuestaCurso() {
		cursoPropio= new CursoPropio();
		assertFalse("el booleano devuelto es correcto",gestorPropuestaCurso.evaluarPropuestaCurso(cursoPropio,estadoCurso.VALIDADO));
	}



	/**
	 * Test method for {@link negocio.controllers.GestorPropuestasCursos#listaCursoAprobado()}.
	 */
	@Test
	public void testListaCursoAprobado() {
	
		assertFalse("la lista devuelta por el metodo consultar ingreso no esta vacia",gestorPropuestaCurso.listaCursoAprobado().isEmpty());
	}

}

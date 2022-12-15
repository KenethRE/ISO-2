/**
 * 
 */
package negocio.controllers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.TipoCurso;

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
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link negocio.controllers.GestorPropuestasCursos#editarPropuestaCurso(negocio.entities.CursoPropio)}.
	 */
	@Test
	public void testEditarPropuestaCurso() {
		cursoPropio= new CursoPropio();
		cursoPropio.set_estado(estadoCurso.VALIDADO);
		assertTrue("el booleano devuelto es correcto",gestorPropuestaCurso.editarPropuestaCurso(cursoPropio));
	}

	/**
	 * Test method for {@link negocio.controllers.GestorPropuestasCursos#rechazarPropuestaCurso(negocio.entities.CursoPropio)}.
	 */
	@Test
	public void testRechazarPropuestaCurso() {
		cursoPropio = new CursoPropio();
		cursoPropio.set_estado(estadoCurso.PROPUESTA_RECHAZADA);
		assertTrue("el booleano devuelto es correcto",gestorPropuestaCurso.rechazarPropuestaCurso(cursoPropio));
	}

	/**
	 * Test method for {@link negocio.controllers.GestorPropuestasCursos#listaCursoAprobado()}.
	 */
	@Test
	public void testListaCursoAprobado() {
	
		assertFalse("la lista devuelta por el metodo consultar ingreso no esta vacia",gestorPropuestaCurso.listaCursoAprobado().isEmpty());
	}

}

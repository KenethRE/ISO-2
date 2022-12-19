/**
 * 
 */
package negocio.controllers;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import negocio.entities.Matricula;
import negocio.entities.ModoPago;

/**
 * @author plati
 *
 */
public class GestorMatriculacionTest {
	GestorMatriculacion gestorMatriculacion;
	Matricula matricula;

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
		gestorMatriculacion =new GestorMatriculacion();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link negocio.controllers.GestorMatriculacion#realizarMatriculacion(negocio.entities.Matricula)}.
	 */
	@Test
	public void testRealizarMatriculacion() {
		matricula = new Matricula();
		matricula.set_tipoPago(ModoPago.TARJETA_CREDITO);
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {gestorMatriculacion.realizarMatriculacion(matricula);});
	    assertEquals("Matricula no generada", exception.getMessage());
		
	}

}

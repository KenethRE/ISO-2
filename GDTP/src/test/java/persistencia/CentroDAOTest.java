/**
 * 
 */
package persistencia;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLDataException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import negocio.entities.Centro;

/**
 * @author plati
 *
 */
public class CentroDAOTest {
	CentroDAO centroDAO;
	Centro aCentro;

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
		centroDAO= new CentroDAO<Centro>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link persistencia.CentroDAO#crearNuevoCentro(negocio.entities.Centro)}.
	 */
	@Disabled
	public void testCrearNuevoCentro() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link persistencia.CentroDAO#seleccionarCentro(negocio.entities.Centro)}.
	 */
	@Test
	public void testSeleccionarCentro() {
		aCentro = new Centro();
		aCentro=null;
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {centroDAO.seleccionarCentro(aCentro);});
		assertEquals("Centro no encontrado", exception.getMessage());
	}

	/**
	 * Test method for {@link persistencia.CentroDAO#editarCentro(negocio.entities.Centro)}.
	 */
	@Test
	public void testEditarCentro() {
		aCentro = new Centro();
		aCentro=null;
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {centroDAO.editarCentro(aCentro);});
		assertEquals("Centro no editado", exception.getMessage());
	}

	/**
	 * Test method for {@link persistencia.CentroDAO#listarCentro()}.
	 */
	@Test
	public void testListarCentro() {
		assertTrue("la lista devuelta por el metodo listarCentro no esta vacia",centroDAO.listarCentro().isEmpty());
	}

}

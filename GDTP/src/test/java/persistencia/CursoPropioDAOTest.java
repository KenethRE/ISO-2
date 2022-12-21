/**
 * 
 */
package persistencia;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import negocio.entities.CursoPropio;

/**
 * @author plati
 *
 */
public class CursoPropioDAOTest {
	CursoPropioDAO<CursoPropio> cursoPropioDAO;
	CursoPropio cursoPropio;

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
		cursoPropio = new CursoPropio();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link persistencia.CursoPropioDAO#crearNuevoCurso(negocio.entities.CursoPropio)}.
	 */
	@Test
	public void testCrearNuevoCurso() {
		cursoPropio=null;
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {cursoPropioDAO.crearNuevoCurso(cursoPropio);});
	}

	/**
	 * Test method for {@link persistencia.CursoPropioDAO#seleccionarCurso(negocio.entities.CursoPropio)}.
	 */
	@Disabled
	public void testSeleccionarCurso() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link persistencia.CursoPropioDAO#editarCurso(negocio.entities.CursoPropio)}.
	 */
	@Disabled
	public void testEditarCurso() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link persistencia.CursoPropioDAO#listarCursosPorEstado(negocio.entities.EstadoCurso)}.
	 */
	@Disabled
	public void testListarCursosPorEstadoEstadoCurso() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link persistencia.CursoPropioDAO#listarCursosPorEstado(negocio.entities.EstadoCurso, java.sql.Date, java.sql.Date)}.
	 */
	@Disabled
	public void testListarCursosPorEstadoEstadoCursoDateDate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link persistencia.CursoPropioDAO#listarIngresos(negocio.entities.TipoCurso, java.sql.Date, java.sql.Date)}.
	 */
	@Disabled
	public void testListarIngresos() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link persistencia.CursoPropioDAO#listarEdicionesCursos(java.sql.Date, java.sql.Date)}.
	 */
	@Disabled
	public void testListarEdicionesCursos() {
		fail("Not yet implemented");
	}

}

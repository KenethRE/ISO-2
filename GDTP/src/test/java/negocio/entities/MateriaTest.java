package negocio.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MateriaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGet_nombre() {
		Materia materia = new Materia();
		assertEquals("materia", materia.get_nombre());
		//throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGet_horas() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGet_fechaInicio() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGet_fechaFin() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetId_Curso() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetId_prof_responsable() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetId() {
		throw new RuntimeException("not yet implemented");
	}

}

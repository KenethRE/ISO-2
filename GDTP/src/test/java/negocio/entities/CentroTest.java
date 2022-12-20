package negocio.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CentroTest {
	Centro centro;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		centro = new Centro();
		centro.set_Id(453);
		centro.set_nombre("pepe");
		centro.set_localizacion("lasmaldivas");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGet_Id() {
		assertEquals(453, centro.get_Id(), "FALLO");
		//throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGet_nombre() {
		assertEquals("pepe", centro.get_nombre(), "FALLO");
		//throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGet_localizacion() {
		assertEquals("lasmaldivas", centro.get_localizacion(), "FALLO");
		//throw new RuntimeException("not yet implemented");
	}


}

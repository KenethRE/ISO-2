package negocio.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CentroTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfeterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("muchas veces @BeforeClass");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}

	@Test
	public void testGet_Id() {
		Centro centro = new Centro();
		assertEquals(1, centro.get_Id());
		//throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGet_nombre() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGet_localizacion() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGet_cursoPropios() {
		throw new RuntimeException("not yet implemented");
	}

}

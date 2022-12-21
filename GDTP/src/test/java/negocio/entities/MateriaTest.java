/**
 * 
 */
package negocio.entities;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

public class MateriaTest {
	Materia materia;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		materia = new Materia();
		materia.set_nombre("Mates");
		materia.set_horas(2);
		Date date = new Date(2010,10,10);
		materia.set_fechaInicio(date);
		materia.set_fechaFin(date);
		materia.setId_Curso("ROBOT");
		materia.setId_prof_responsable("01");
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link negocio.entities.Materia#get_nombre()}.
	 */
	@Test
	public void testGet_nombre() {
		assertEquals("Mates", materia.get_nombre(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Materia#set_nombre(java.lang.String)}.
	 */
	@Test
	public void testSet_nombre() {
		materia.set_nombre("Lengua");
		assertEquals("Lengua", materia.get_nombre(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Materia#get_horas()}.
	 */
	@Test
	public void testGet_horas() {
		assertEquals(2, materia.get_horas(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Materia#set_horas(double)}.
	 */
	@Test
	public void testSet_horas() {
		materia.set_horas(3);
		assertEquals(3, materia.get_horas(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Materia#get_fechaInicio()}.
	 */
	@Test
	public void testGet_fechaInicio() {
		Date date = new Date(2010,10,10);
		assertEquals(date, materia.get_fechaInicio(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Materia#set_fechaInicio(java.util.Date)}.
	 */
	@Test
	public void testSet_fechaInicio() {
		Date date = new Date(2005,5,5);
		materia.set_fechaInicio(date);
		assertEquals(date, materia.get_fechaInicio(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Materia#get_fechaFin()}.
	 */
	@Test
	public void testGet_fechaFin() {
		Date date = new Date(2010,10,10);
		assertEquals(date, materia.get_fechaFin(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Materia#set_fechaFin(java.util.Date)}.
	 */
	@Test
	public void testSet_fechaFin() {
		Date date = new Date(2010,10,10);
		materia.set_fechaFin(date);
		assertEquals(date, materia.get_fechaFin(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Materia#getId_Curso()}.
	 */
	@Test
	public void testGetId_Curso() {
		assertEquals("ROBOT", materia.getId_Curso(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Materia#setId_Curso(java.lang.String)}.
	 */
	@Test
	public void testSetId_Curso() {
		materia.setId_Curso("INFOR");
		assertEquals("INFOR", materia.getId_Curso(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Materia#getId_prof_responsable()}.
	 */
	@Test
	public void testGetId_prof_responsable() {
		assertEquals("01", materia.getId_prof_responsable(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Materia#setId_prof_responsable(java.lang.String)}.
	 */
	@Test
	public void testSetId_prof_responsable() {
		materia.setId_prof_responsable("02");
		assertEquals("02", materia.getId_prof_responsable(), "FALLO");;
	}

	/**
	 * Test method for {@link negocio.entities.Materia#getInternalID()}.
	 */
	@Disabled
	public void testGetInternalID() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link negocio.entities.Materia#toString()}.
	 */
	@Disabled
	public void testToString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link negocio.entities.Materia#persist()}.
	 */
	@Disabled
	public void testPersist() {
		fail("Not yet implemented");
	}

}

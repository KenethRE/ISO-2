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

public class MatriculaTest {
	Matricula matricula;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		matricula = new Matricula();
		matricula.setiD(1);
		Date date = new Date(2010,10,10);
		matricula.set_fecha(date);
		matricula.set_pagado(false);
		matricula.set_attribute("atributo");
		matricula.setId_estudiante("01");
		matricula.setId_Curso("01");
		matricula.set_tipoPago(ModoPago.TARJETA_CREDITO);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link negocio.entities.Matricula#getiD()}.
	 */
	@Test
	public void testGetiD() {
		assertEquals(1, matricula.getiD(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Matricula#setiD(int)}.
	 */
	@Test
	public void testSetiD() {
		matricula.setiD(2);
		assertEquals(2, matricula.getiD(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Matricula#get_fecha()}.
	 */
	@Test
	public void testGet_fecha() {
		Date date = new Date(2010,10,10);
		assertEquals(date, matricula.get_fecha(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Matricula#set_fecha(java.util.Date)}.
	 */
	@Test
	public void testSet_fecha() {
		Date date = new Date(2005,5,5);
		matricula.set_fecha(date);
		assertEquals(date, matricula.get_fecha(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Matricula#is_pagado()}.
	 */
	@Test
	public void testIs_pagado() {
		assertEquals(false, matricula.is_pagado(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Matricula#set_pagado(boolean)}.
	 */
	@Test
	public void testSet_pagado() {
		matricula.set_pagado(true);
		assertEquals(true, matricula.is_pagado(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Matricula#get_attribute()}.
	 */
	@Test
	public void testGet_attribute() {
		assertEquals("atributo", matricula.get_attribute(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Matricula#set_attribute(java.lang.Object)}.
	 */
	@Test
	public void testSet_attribute() {
		matricula.set_attribute("atr");
		assertEquals("atr", matricula.get_attribute(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Matricula#getId_estudiante()}.
	 */
	@Test
	public void testGetId_estudiante() {
		assertEquals("01", matricula.getId_estudiante(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Matricula#setId_estudiante(java.lang.String)}.
	 */
	@Test
	public void testSetId_estudiante() {
		matricula.setId_estudiante("02");
		assertEquals("02", matricula.getId_estudiante(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Matricula#getId_Curso()}.
	 */
	@Test
	public void testGetId_Curso() {
		assertEquals("01", matricula.getId_Curso(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Matricula#setId_Curso(java.lang.String)}.
	 */
	@Test
	public void testSetId_Curso() {
		matricula.setId_Curso("02");
		assertEquals("02", matricula.getId_Curso(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Matricula#get_tipoPago()}.
	 */
	@Test
	public void testGet_tipoPago() {
		assertEquals(ModoPago.TARJETA_CREDITO, matricula.get_tipoPago(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Matricula#set_tipoPago(negocio.entities.ModoPago)}.
	 */
	@Test
	public void testSet_tipoPago() {
		matricula.set_tipoPago(ModoPago.TRANSFERENCIA);
		assertEquals(ModoPago.TRANSFERENCIA, matricula.get_tipoPago(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.Matricula#getInternalID()}.
	 */
	@Disabled
	public void testGetInternalID() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link negocio.entities.Matricula#persist()}.
	 */
	@Disabled
	public void testPersist() {
		fail("Not yet implemented");
	}

}

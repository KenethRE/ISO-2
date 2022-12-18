/**
 * 
 */
package negocio.controllers;

import static org.junit.Assert.*;
import java.sql.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import negocio.entities.EstadoCurso;
import negocio.entities.TipoCurso;

/**
 * @author plati
 *
 */
public class GestorConsultasTest {
	GestorConsultas gestorConsultas;
	Date fechacomienzoDate;
	Date fechafinDate;

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
		fechacomienzoDate= new java.sql.Date(System.currentTimeMillis());
		fechafinDate= new java.sql.Date(System.currentTimeMillis()+254845121);
		gestorConsultas= new GestorConsultas();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link negocio.controllers.GestorConsultas#consultarIngresos(negocio.entities.TipoCurso, java.sql.Date, java.sql.Date)}.
	 */
	@Test
	public void testConsultarIngresos() {
		assertTrue("la lista devuelta por el metodo consultar ingreso esta vacia",gestorConsultas.consultarIngresos(TipoCurso.MASTER,fechacomienzoDate, fechafinDate).isEmpty());
	}

	/**
	 * Test method for {@link negocio.controllers.GestorConsultas#consultarEstadoCursos(negocio.entities.EstadoCurso, java.sql.Date, java.sql.Date)}.
	 */
	@Disabled
	public void testConsultarEstadoCursos() {
		assertFalse("la lista devuelta por el metodo consultar ingreso esta vacia",gestorConsultas.consultarEstadoCursos(EstadoCurso.EN_MATRICULACION,fechacomienzoDate, fechafinDate).isEmpty());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link negocio.controllers.GestorConsultas#listarEdicionesCursos(java.sql.Date, java.sql.Date)}.
	 */
	@Test
	public void testListarEdicionesCursos() {
		assertTrue("la lista devuelta por el metodo consultar ingreso esta vacia",gestorConsultas.listarEdicionesCursos(fechacomienzoDate, fechafinDate).isEmpty());
		//fail("Not yet implemented");
	}

}

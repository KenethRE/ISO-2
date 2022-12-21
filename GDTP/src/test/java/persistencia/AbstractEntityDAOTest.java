/**
 * 
 */
package persistencia;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Date;
import java.sql.SQLDataException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runners.model.FrameworkField;

import negocio.entities.EstadoCurso;
import negocio.entities.TipoCurso;

/**
 * @author plati
 *
 */
public class AbstractEntityDAOTest {
	Object eObject;
	AbstractEntityDAO abstracDAO = new AbstractEntityDAO<>();
	String string ="";
	String idcurso="";
	Date date = new Date(2010,10,10);
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
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link persistencia.AbstractEntityDAO#get(java.lang.Object)}.
	 */
	@Test
	public void testGetObject() {
		
		eObject = null;
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {abstracDAO.get(eObject);});
	}

	/**
	 * Test method for {@link persistencia.AbstractEntityDAO#get(java.lang.String)}.
	 */
	@Test
	public void testGetString() {
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {abstracDAO.get(string);});
		
	}

	/**
	 * Test method for {@link persistencia.AbstractEntityDAO#get(java.lang.String, negocio.entities.EstadoCurso)}.
	 */
	@Test
	public void testGetStringEstadoCurso() {
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {abstracDAO.get(string,EstadoCurso.EN_IMPARTIZICION);});
		
	}

	/**
	 * Test method for {@link persistencia.AbstractEntityDAO#get(java.lang.String, negocio.entities.EstadoCurso, java.sql.Date, java.sql.Date)}.
	 */
	@Test
	public void testGetStringEstadoCursoDateDate() {
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {abstracDAO.get(string,EstadoCurso.EN_IMPARTIZICION,date,date);});
	}

	/**
	 * Test method for {@link persistencia.AbstractEntityDAO#get(negocio.entities.TipoCurso, java.sql.Date, java.sql.Date)}.
	 */
	@Test
	public void testGetTipoCursoDateDate() {
		date=null;
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {abstracDAO.get(TipoCurso.CORTA_DURACION,date,date);});
	}

	/**
	 * Test method for {@link persistencia.AbstractEntityDAO#get_edicion(java.lang.String, java.sql.Date, java.sql.Date)}.
	 */
	@Test
	public void testGet_edicion() {
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {abstracDAO.get_edicion(string, date, date);});
	}

	/**
	 * Test method for {@link persistencia.AbstractEntityDAO#insert(java.lang.Object)}.
	 */
	@Test
	public void testInsert() {
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {abstracDAO.insert(eObject);});
		
	}

	/**
	 * Test method for {@link persistencia.AbstractEntityDAO#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {abstracDAO.update(eObject);});
	}

	/**
	 * Test method for {@link persistencia.AbstractEntityDAO#delete(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDelete() {
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {abstracDAO.delete(string, idcurso, string);});
		
	}

}

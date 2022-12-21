/**
 * 
 */
package negocio.entities;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

public class CursoPropioTest {
	CursoPropio cursoPropio;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		cursoPropio = new CursoPropio();
		cursoPropio.set_id("popi");
		cursoPropio.set_nombre("pipo");
		cursoPropio.set_eCTS(20);
		
		Date date = new Date(2010,10,10);
		cursoPropio.set_fechaInicio(date);
		cursoPropio.set_fechaFin(date);
		
		cursoPropio.set_tasaMatricula(200.5);
		cursoPropio.set_edicion(1);
		
		Matricula m = new Matricula();
		List<Matricula> matriculas = new ArrayList<Matricula>();
		matriculas.add(m);
		
		cursoPropio.set_matriculas(matriculas);
		cursoPropio.setId_centro(1);
		cursoPropio.setId_director("01");
		cursoPropio.setId_secretario("01");
		cursoPropio.set_estado(EstadoCurso.VALIDADO);
		
		/*
		Materia mat = new Materia();
		List<Materia> materias = new ArrayList<Materia>();
		materias.add(mat);
		cursoPropio.set_materias(materias);
		*/
		
		cursoPropio.set_tipo(TipoCurso.MASTER);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#CursoPropio()}.
	 */
	@Disabled
	public void testCursoPropio() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#CursoPropio(java.lang.String)}.
	 */
	@Disabled
	public void testCursoPropioString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#get_id()}.
	 */
	@Test
	public void testGet_id() {
		assertEquals("popi", cursoPropio.get_id(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#set_id(java.lang.String)}.
	 */
	@Test
	public void testSet_id() {
		cursoPropio.set_id("nino");
		assertEquals("nino", cursoPropio.get_id(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#get_nombre()}.
	 */
	@Test
	public void testGet_nombre() {
		assertEquals("pipo", cursoPropio.get_nombre(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#set_nombre(java.lang.String)}.
	 */
	@Test
	public void testSet_nombre() {
		cursoPropio.set_nombre("nino");
		assertEquals("nino", cursoPropio.get_nombre(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#get_eCTS()}.
	 */
	@Test
	public void testGet_eCTS() {
		assertEquals(20, cursoPropio.get_eCTS(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#set_eCTS(int)}.
	 */
	@Test
	public void testSet_eCTS() {
		cursoPropio.set_eCTS(10);
		assertEquals(10, cursoPropio.get_eCTS(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#get_fechaInicio()}.
	 */
	@Test
	public void testGet_fechaInicio() {
		Date date = new Date(2010,10,10);
		assertEquals(date, cursoPropio.get_fechaInicio(), "FALLO");

	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#set_fechaInicio(java.util.Date)}.
	 */
	@Test
	public void testSet_fechaInicio() {
		Date date = new Date(2005,5,5);
		cursoPropio.set_fechaInicio(date);
		assertEquals(date, cursoPropio.get_fechaInicio(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#get_fechaFin()}.
	 */
	@Test
	public void testGet_fechaFin() {
		Date date = new Date(2010,10,10);
		assertEquals(date, cursoPropio.get_fechaFin(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#set_fechaFin(java.util.Date)}.
	 */
	@Test
	public void testSet_fechaFin() {
		Date date = new Date(2005,5,5);
		cursoPropio.set_fechaFin(date);
		assertEquals(date, cursoPropio.get_fechaFin(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#get_tasaMatricula()}.
	 */
	@Test
	public void testGet_tasaMatricula() {
		assertEquals(200.5, cursoPropio.get_tasaMatricula(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#set_tasaMatricula(double)}.
	 */
	@Test
	public void testSet_tasaMatricula() {
		cursoPropio.set_tasaMatricula(100.5);
		assertEquals(100.5, cursoPropio.get_tasaMatricula(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#get_edicion()}.
	 */
	@Test
	public void testGet_edicion() {
		assertEquals(1, cursoPropio.get_edicion(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#set_edicion(int)}.
	 */
	@Test
	public void testSet_edicion() {
		cursoPropio.set_edicion(2);
		assertEquals(2, cursoPropio.get_edicion(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#get_matriculas()}.
	 */
	@Test
	public void testGet_matriculas() {
		assertEquals(false, cursoPropio.get_matriculas().isEmpty(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#set_matriculas(java.util.List)}.
	 */
	@Test
	public void testSet_matriculas() {
		Matricula m = new Matricula();
		m.setId_Curso("Mates");
		List<Matricula> matriculas = new ArrayList<Matricula>();
		matriculas.add(m);
		cursoPropio.set_matriculas(matriculas);
		assertEquals(matriculas, cursoPropio.get_matriculas(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#getId_centro()}.
	 */
	@Test
	public void testGetId_centro() {
		assertEquals(1, cursoPropio.getId_centro(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#setId_centro(int)}.
	 */
	@Test
	public void testSetId_centro() {
		cursoPropio.setId_centro(2);
		assertEquals(2, cursoPropio.getId_centro(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#getId_director()}.
	 */
	@Test
	public void testGetId_director() {
		assertEquals("01", cursoPropio.getId_director(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#setId_director(java.lang.String)}.
	 */
	@Test
	public void testSetId_director() {
		cursoPropio.setId_director("02");
		assertEquals("02", cursoPropio.getId_director(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#getId_secretario()}.
	 */
	@Test
	public void testGetId_secretario() {
		assertEquals("01", cursoPropio.getId_secretario(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#setId_secretario(java.lang.String)}.
	 */
	@Test
	public void testSetId_secretario() {
		cursoPropio.setId_secretario("02");
		assertEquals("02", cursoPropio.getId_secretario(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#get_materias()}.
	 */
	
	//FALLO DAO
	/*
	@Disabled
	public void testGet_materias() {
		assertEquals(false, cursoPropio.get_materias().isEmpty(), "FALLO");
	}
	*/

	/**
	 * Test method for {@link negocio.entities.CursoPropio#set_materias(java.util.List)}.
	 */
	@Disabled
	/*
	public void testSet_materias() {
		Materia mat = new Materia();
		mat.setId_Curso("Mates");
		List<Materia> materias = new ArrayList<Materia>();
		materias.add(mat);
		cursoPropio.set_materias(materias);
		assertEquals(mat, cursoPropio.get_matriculas(), "FALLO");
	}
	*/

	/**
	 * Test method for {@link negocio.entities.CursoPropio#get_estado()}.
	 */
	@Test
	public void testGet_estado() {
		assertEquals(EstadoCurso.VALIDADO, cursoPropio.get_estado(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#set_estado(negocio.entities.EstadoCurso)}.
	 */
	@Test
	public void testSet_estado() {
		cursoPropio.set_estado(EstadoCurso.TERMINADO);
		assertEquals(EstadoCurso.TERMINADO, cursoPropio.get_estado(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#get_tipo()}.
	 */
	@Disabled
	public void testGet_tipo() {
		assertEquals(TipoCurso.MASTER, cursoPropio.get_tipo(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#set_tipo(negocio.entities.TipoCurso)}.
	 */
	@Disabled
	public void testSet_tipo() {
		cursoPropio.set_tipo(TipoCurso.ESPECIALISTA);
		assertEquals(TipoCurso.ESPECIALISTA, cursoPropio.get_tipo(), "FALLO");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#persist()}.
	 */
	@Disabled
	public void testPersist() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#getInternalID()}.
	 */
	@Disabled
	public void testGetInternalID() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link negocio.entities.CursoPropio#toString()}.
	 */
	@Disabled
	public void testToString() {
		fail("Not yet implemented");
	}

}

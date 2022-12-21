package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.TipoCurso;


public class CursoPropioDAO<E> extends AbstractEntityDAO<E> {

	private static final String nombreClase = "CursoPropio";
	
	public int crearNuevoCurso(CursoPropio aCurso) throws SQLException {
		if (aCurso==null)
		throw new NullPointerException();
		else {
		int aux= 0;
		aux = insert (aCurso);
		return aux;
		}
		
	}

	public int seleccionarCurso(CursoPropio aCurso) {
		// El iD curso es el curso que queremos seleccionar, el nombre de la clase "CursoPropio" es la tabla que queremos
		// buscar y la cadena del final representa la clave que usamos para hacer la seleccion.
		ResultSet aux = get(aCurso);
		try {
			while (aux.next()) {
				aCurso.set_nombre(aux.getString("NOMBRE"));
				aCurso.set_eCTS(aux.getInt("ECTS"));
				aCurso.set_fechaInicio(aux.getDate("FECHAINICIO"));
				aCurso.set_fechaFin(aux.getDate("FECHAFIN"));
				aCurso.set_tasaMatricula(aux.getInt("TASAMATRICULA"));
				aCurso.set_edicion(aux.getInt("EDICION"));
				aCurso.setId_centro(aux.getInt("IDCENTRO"));
				aCurso.setId_director(aux.getString("DIRECTOR"));
				aCurso.setId_secretario(aux.getString("SECRETARIO"));
				aCurso.set_tipo(TipoCurso.valueOf(aux.getString("TIPOCURSO")));
				aCurso.set_estado(EstadoCurso.valueOf(aux.getString("ESTADOCURSO")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger("GDTP_Logger").log(Level.SEVERE,"Curso no encontrado");
		}
		
		return 0;
		
	}

	public int editarCurso(CursoPropio aCurso) {
		// El iD curso es el curso que queremos editar, el nombre de la clase "CursoPropio" es la tabla que queremos
		int resultado = 0;
		try{
			resultado = update (aCurso);
			return resultado;
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			Logger.getLogger("GDTP_Logger").log(Level.SEVERE, "Curso no encontrado");
		}
		
		return resultado;
		
	}
	
	public List<CursoPropio> listarCursosPorEstado(EstadoCurso aEstado) {
		List<CursoPropio> Cursos = new ArrayList<>();

		ResultSet aux = get(nombreClase, aEstado);
		try {
			while (aux.next()) {
				CursoPropio curso = new CursoPropio();
				curso.set_id(aux.getString("ID"));
				curso.set_nombre(aux.getString("NOMBRE"));
				curso.set_eCTS(aux.getInt("ECTS"));
				curso.set_fechaInicio(aux.getDate("FECHAINICIO"));
				curso.set_fechaFin(aux.getDate("FECHAFIN"));
				curso.set_tasaMatricula(aux.getInt("TASAMATRICULA"));
				curso.set_edicion(aux.getInt("EDICION"));
				curso.setId_centro(aux.getInt("IDCENTRO"));
				curso.setId_director(aux.getString("DIRECTOR"));
				curso.setId_secretario(aux.getString("SECRETARIO"));
				curso.set_tipo(TipoCurso.valueOf(aux.getString("TIPOCURSO")));
				curso.set_estado(EstadoCurso.valueOf(aux.getString("ESTADOCURSO")));
				Cursos.add(curso);
			}
			
			return Cursos;
		
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger("GDTP_Logger").log(Level.SEVERE,"Curso no encontrado");
		}
		
		return Cursos;
	}

	public List<CursoPropio> listarCursosPorEstado(EstadoCurso aEstado, Date aFechaInicio, Date aFechaFin) {
		List<CursoPropio> Cursos = new ArrayList<>();
		
		ResultSet aux = get(nombreClase, aEstado, aFechaInicio, aFechaFin);
		try {
			while (aux.next()) {
				CursoPropio curso = new CursoPropio();
				curso.set_id(aux.getString("ID"));
				curso.set_nombre(aux.getString("NOMBRE"));
				curso.set_eCTS(aux.getInt("ECTS"));
				curso.set_fechaInicio(aux.getDate("FECHAINICIO"));
				curso.set_fechaFin(aux.getDate("FECHAFIN"));
				curso.set_tasaMatricula(aux.getInt("TASAMATRICULA"));
				curso.set_edicion(aux.getInt("EDICION"));
				curso.setId_centro(aux.getInt("IDCENTRO"));
				curso.setId_director(aux.getString("DIRECTOR"));
				curso.setId_secretario(aux.getString("SECRETARIO"));
				curso.set_tipo(TipoCurso.valueOf(aux.getString("TIPOCURSO")));
				curso.set_estado(EstadoCurso.valueOf(aux.getString("ESTADOCURSO")));
				Cursos.add(curso);
			}
			
			return Cursos;
		
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger("GDTP_Logger").log(Level.SEVERE,"Curso no encontrado");
		}
		
		return Cursos;
	}
	
	public List<List<String>> listarIngresos(TipoCurso aTipo, Date aFechaInicio, Date aFechaFin) {
		List<List<String>> Datos = new ArrayList<>();
		ResultSet aux = get(aTipo, aFechaInicio, aFechaFin);
		try {
			while(aux.next()) {
				List<String> data = new ArrayList<String>();
				data.add(aux.getString("n"));
				data.add(aux.getString("total"));
				data.add(aux.getString("idcurso"));
				Datos.add(data);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger("GDTP_Logger").log(Level.SEVERE, "Informacion de ingresos no encontrada.");
		}
		
		
		return Datos;
	}
	
	

	public List<CursoPropio> listarEdicionesCursos(Date aFechaInicio, Date aFechaFin) {
		List<CursoPropio> Cursos = new ArrayList<>();
		
		ResultSet aux = get_edicion(nombreClase, aFechaInicio, aFechaFin);
		try {
			while (aux.next()) {
				CursoPropio curso = new CursoPropio();
				curso.set_id(aux.getString("ID"));
				curso.set_nombre(aux.getString("NOMBRE"));
				curso.set_eCTS(aux.getInt("ECTS"));
				curso.set_fechaInicio(aux.getDate("FECHAINICIO"));
				curso.set_fechaFin(aux.getDate("FECHAFIN"));
				curso.set_tasaMatricula(aux.getInt("TASAMATRICULA"));
				curso.set_edicion(aux.getInt("EDICION"));
				curso.setId_centro(aux.getInt("IDCENTRO"));
				curso.setId_director(aux.getString("DIRECTOR"));
				curso.setId_secretario(aux.getString("SECRETARIO"));
				TipoCurso Tcurso =  TipoCurso.valueOf(aux.getString("TIPOCURSO"));
				curso.set_tipo(Tcurso);
				EstadoCurso Ecurso = EstadoCurso.valueOf(aux.getString("ESTADOCURSO"));
				curso.set_estado(Ecurso);
				Cursos.add(curso);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger("GDTP_Logger").log(Level.SEVERE,"Curso no encontrado");
		}
		
		return Cursos;
		
	}
	public CursoPropio SeleccionarCursoPropio(CursoPropio cursoPropio) {
		CursoPropio curso = null;
		ResultSet aux = get(cursoPropio);
		try {
			while (aux.next()) {
				curso = new CursoPropio();
				curso.set_id(aux.getString("ID"));
				curso.set_nombre(aux.getString("NOMBRE"));
				curso.set_eCTS(aux.getInt("ECTS"));
				curso.set_fechaInicio(aux.getDate("FECHAINICIO"));
				curso.set_fechaFin(aux.getDate("FECHAFIN"));
				curso.set_tasaMatricula(aux.getInt("TASAMATRICULA"));
				curso.set_edicion(aux.getInt("EDICION"));
				curso.setId_centro(aux.getInt("IDCENTRO"));
				curso.setId_director(aux.getString("DIRECTOR"));
				curso.setId_secretario(aux.getString("SECRETARIO"));
				TipoCurso Tcurso =  TipoCurso.valueOf(aux.getString("TIPOCURSO"));
				curso.set_tipo(Tcurso);
				EstadoCurso Ecurso = EstadoCurso.valueOf(aux.getString("ESTADOCURSO"));
				curso.set_estado(Ecurso);
				}
					
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger("GDTP_Logger").log(Level.SEVERE,"Curso no encontrado");
		}
		
		return curso;
		
		
		
	}
	public List<CursoPropio> listartodosloscursos () {
		String tablacurso ="CursoPropio";
		List<CursoPropio> Cursos = new ArrayList<>();

		ResultSet aux = get(tablacurso);
		try {
			while (aux.next()) {
				CursoPropio curso = new CursoPropio();
				curso.set_id(aux.getString("ID"));
				curso.set_nombre(aux.getString("NOMBRE"));
				curso.set_eCTS(aux.getInt("ECTS"));
				curso.set_fechaInicio(aux.getDate("FECHAINICIO"));
				curso.set_fechaFin(aux.getDate("FECHAFIN"));
				curso.set_tasaMatricula(aux.getInt("TASAMATRICULA"));
				curso.set_edicion(aux.getInt("EDICION"));
				curso.setId_centro(aux.getInt("IDCENTRO"));
				curso.setId_director(aux.getString("DIRECTOR"));
				curso.setId_secretario(aux.getString("SECRETARIO"));
				curso.set_tipo(TipoCurso.valueOf(aux.getString("TIPOCURSO")));
				curso.set_estado(EstadoCurso.valueOf(aux.getString("ESTADOCURSO")));
				Cursos.add(curso);
			}
			
			return Cursos;
		
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger("GDTP_Logger").log(Level.SEVERE,"Curso no encontrado");
		}
		
		return Cursos;
		
	}
}
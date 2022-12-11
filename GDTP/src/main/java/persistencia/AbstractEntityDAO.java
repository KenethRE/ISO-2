package persistencia;

import java.sql.*;
import negocio.entities.*;

public class AbstractEntityDAO<E>{

	private GestorBD agente = GestorBD.getAgente();
	
	//esto regresa un unico elemento
	public ResultSet get(Object E) {
		ResultSet result = null;
		String castName = E.getClass().getSimpleName();
		if (castName.equals("ProfesorExterno") || castName.equals("ProfesorUCLM")) result = agente.select("SELECT * FROM " + castName + " NATURAL JOIN PROFESOR"
				+ " WHERE DNI = '" + ((Profesor)E).get_dni() + "'");
		else if (castName.equals("Estudiante")) result = agente.select("SELECT * FROM ESTUDIANTE WHERE DNI = '"+((Estudiante)E).get_dni()+ "'");
		else if (castName.equals("Materia")) result = agente.select("SELECT * FROM MATERIA WHERE NOMBRE = '"+((Materia)E).get_nombre()+ "'");
		else result = agente.select("SELECT * FROM " + castName + " WHERE ID = '"+((IdInterface) E).getId()+ "'");
		return result;
	}
	
	//esto regresa todos los elementos de alguna tabla en particular
	public ResultSet get(String Table) {
		ResultSet result = null;

		if (Table.equals("ProfesorExterno") || Table.equals("ProfesorUCLM")) result = agente.select("SELECT * FROM " + Table + " NATURAL JOIN PROFESOR");
		else result = agente.select("SELECT * FROM " + Table);

		return result;
	}
	
	//get para estadoCurso
	public ResultSet get(String Table, EstadoCurso estadoCurso, Date aFechaInicio, Date aFechaFin) {
		ResultSet result = null;
		
		if (Table.equals("CursoPropio")) {
			result = agente.select("SELECT * FROM " + Table + "WHERE estadocurso = '"+estadoCurso+"' AND fechainicio > '"+aFechaInicio+"' AND fechafin < '"+aFechaFin+"'");
		}

		return result;
	}
	
	//get para coste total por tipos de curso
	public ResultSet get(TipoCurso tipoCurso,  Date aFechaInicio, Date aFechaFin) {
		ResultSet result = null;
		
		result = agente.select("SELECT DISTINCT COUNT() AS n,COUNT()*C.tasamatricula AS total,c.id FROM Matricula m\n"
				+ "INNER JOIN CursoPropio c ON m.idcurso = c.id WHERE m.pagado=1"
				+ "AND c.tipocurso='"+tipoCurso+"'"
				+ "AND c.fechainicio > '"+aFechaInicio+"'"
				+ "AND c.fechafin < '"+aFechaFin+"'"
				+ "GROUP BY m.idcurso");

		return result;
	}
	
	public ResultSet get_edicion(String Table, Date aFechaInicio, Date aFechaFin) {
		ResultSet result = null;
		
		if (Table.equals("CursoPropio")) {
			result = agente.select("SELECT edicion FROM " + Table + "WHERE fechainicio > "+aFechaInicio+" AND fechafin < "+aFechaFin);
		}

		return result;
	}
	
	
	public int insert (Object E) {
		String className = E.getClass().getSimpleName();
		int result = 0;
		switch (className) {
		
		case "CursoPropio":
			result = agente.insert("INSERT INTO " + className + " VALUES('" + ((CursoPropio) E).get_id() + "','"  + ((CursoPropio) E).get_nombre() + "'," 
					+ ((CursoPropio) E).get_eCTS() + ",'"  + ((CursoPropio) E).get_fechaInicio() + "','"  + ((CursoPropio) E).get_fechaFin() + "'," 
					+ ((CursoPropio) E).get_tasaMatricula() + ","  + ((CursoPropio) E).get_edicion() + ","  + ((CursoPropio) E).getId_centro() + ",'"
					+ ((CursoPropio) E).getId_secretario() + "','"  + ((CursoPropio) E).getId_director() + "','" + ((CursoPropio) E).get_tipo()
					+ "','" + ((CursoPropio) E).get_estado() + "')");
			break;
		case "Profesor":
			result = agente.insert("INSERT INTO " + className + " VALUES('" + ((Profesor) E).get_dni() + "','" + ((Profesor) E).get_nombre() + "','"
					 + ((Profesor) E).get_apellidos() + "'," + ((Profesor) E).is_doctor()+ "," + ((Profesor) E).get_centro() + ")");
		case "ProfesorExterno":
			result = agente.insert("INSERT INTO " + className + " VALUES('" + ((ProfesorExterno) E).get_dni() + "','" + ((ProfesorExterno) E).get_titulacion() + "')");
			break;
		
		case "Matricula":
			result = agente.insert("INSERT INTO " + className + " VALUES("+ ((Matricula) E).getiD() + ",'" + ((Matricula) E).get_fecha() + "'," + ((Matricula) E).is_pagado() + ",'"
					+ ((Matricula) E).getId_estudiante() + "','" + ((Matricula) E).getId_Curso() + "')");
			break;
		case "Materia":
			String sentencia= "INSERT INTO " + className + " VALUES('" + ((Materia) E).get_nombre()+ "',"+((Materia) E).get_horas() + ",'"+ ((Materia) E).get_fechaInicio() + "','" + ((Materia) E).get_fechaFin() + "','"+((Materia) E).getId_prof_responsable()+ "','" + ((Materia) E).getId_Curso() + "')";
			result = agente.insert(sentencia);
			break;
		case "Centro":
			result = agente.insert("INSERT INTO " + className + "VALUES(" + ((Centro) E).get_Id() + ",'" + ((Centro) E).get_nombre() + "','" + ((Centro) E).get_localizacion() 
					+ "')");
			break;
		case "Estudiante":
			result = agente.insert("INSERT INTO " + className + "VALUES('" + ((Estudiante) E).get_dni() + "','" + ((Estudiante) E).get_nombre() + "','" + ((Estudiante) E).get_apellidos() 
					+ "','" + ((Estudiante) E).get_titulacion() + "','" + ((Estudiante) E).get_cualificacion() + "')" );
			break;
		}
		return result;
	}
	public int update (Object E) {
		String className = E.getClass().getSimpleName();
		int result = 0;
		switch (className) {
		
		case "CursoPropio":
			result = agente.update("UPDATE INTO " + className + " VALUES('" + ((CursoPropio) E).get_id() + "','"  + ((CursoPropio) E).get_nombre() + "'," 
					+ ((CursoPropio) E).get_eCTS() + ",'"  + ((CursoPropio) E).get_fechaInicio() + "','"  + ((CursoPropio) E).get_fechaFin() + "'," 
					+ ((CursoPropio) E).get_tasaMatricula() + ","  + ((CursoPropio) E).get_edicion() + ","  + ((CursoPropio) E).getId_centro() + ",'"
					+ ((CursoPropio) E).getId_secretario() + "','"  + ((CursoPropio) E).getId_director() + "')" + " WHERE id = '" + ((CursoPropio) E).get_id() +"'");
			break;
		case "Profesor":
			result = agente.update("UPDATE INTO " + className + " VALUES('" + ((Profesor) E).get_dni() + "','" + ((Profesor) E).get_nombre() + "','"
					 + ((Profesor) E).get_apellidos() + "'," + ((Profesor) E).is_doctor()+ "," + ((Profesor) E).get_centro() + ")" + " WHERE dni = '" + ((Profesor) E).get_dni() +"'");
		case "ProfesorExterno":
			result = agente.update("UPDATE INTO " + className + "VALUES('" + ((ProfesorExterno) E).get_dni() + "','" + ((ProfesorExterno) E).get_titulacion() + "')"+ " WHERE dni = '" + ((ProfesorExterno) E).get_dni() +"'");
			break;
		
		case "Matricula":
			result = agente.update("UPDATE INTO " + className + "VALUES('" + ((Matricula) E).get_fecha() + "'," + ((Matricula) E).is_pagado() + ",'"
					+ ((Matricula) E).getId_estudiante() + "','" + ((Matricula) E).getId_Curso() + "')" + " WHERE ID = '" + ((Matricula) E).getiD() + "'");
		case "Materia":
			result = agente.update("UPDATE INTO " + className + "VALUES('" + ((Materia) E).get_nombre()+ "'," + ((Materia) E).get_horas() + ",'"
					+ ((Materia) E).get_fechaInicio() + "','" + ((Materia) E).get_fechaFin() + "','" + ((Materia) E).getId_Curso() + "')"+ " WHERE Nombre = '" + ((Materia) E).get_nombre() +"'"); 
			break;
		case "Centro":
			result = agente.update("UPDATE INTO " + className + "VALUES(" + ((Centro) E).get_Id() + ",'" + ((Centro) E).get_nombre() + "','" + ((Centro) E).get_localizacion() 
					+ "')"+ " WHERE id = '" + ((Centro) E).get_Id() +"'");
			break;
		case "Estudiante":
			result = agente.update("UPDATE INTO " + className + "VALUES('" + ((Estudiante) E).get_dni() + "','" + ((Estudiante) E).get_nombre() + "','" + ((Estudiante) E).get_apellidos() 
					+ "','" + ((Estudiante) E).get_titulacion() + "','" + ((Estudiante) E).get_cualificacion() + "')"+ " WHERE dni = '" + ((Estudiante) E).get_dni() +"'" );
			break;
		}	
		return result;
	}
	public int delete (String iD, String Table, String keyName) {
		int result = 0;
		if (Table.equals("ProfesorExterno") || Table.equals("ProfesorUCLM")) result = agente.update("DELETE FROM " + Table + " NATURAL JOIN PROFESOR WHERE "+keyName+" = " +iD);
		else result = agente.update("DELETE FROM" + Table + " WHERE "+keyName+" = " +iD);
		return result;
	}

}

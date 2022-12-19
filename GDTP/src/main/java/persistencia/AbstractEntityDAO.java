package persistencia;

import java.sql.*;
import negocio.entities.*;

public class AbstractEntityDAO<E>{
	private static final String profesorUCLMString = "ProfesorUCLM";
	private static final String profesorExtString = "ProfesorExterno";
	private static final String cursoPropioString = "CursoPropio";
	private GestorBD agente = GestorBD.getAgente();
	
	//esto regresa un unico elemento
	public ResultSet get(Object E) {
		ResultSet result = null;
		String castName = E.getClass().getSimpleName();
		if (castName.equals(profesorExtString) || castName.equals(profesorUCLMString)) result = agente.select("SELECT * FROM " + castName + " NATURAL JOIN PROFESOR"
				+ " WHERE DNI = '" + ((Profesor)E).get_dni() + "'");
		else if (castName.equals("Estudiante")) result = agente.select("SELECT * FROM ESTUDIANTE WHERE DNI = '"+((Estudiante)E).get_dni()+ "'");
		else if (castName.equals("Materia")) result = agente.select("SELECT * FROM MATERIA WHERE NOMBRE = '"+((Materia)E).get_nombre()+ "'");
		else if (castName.equals("CursoPropio")) result = agente.select("SELECT * FROM CURSOPROPIO WHERE ID = '"+((CursoPropio)E).get_id()+ "'");
		else result = agente.select("SELECT * FROM " + castName + " WHERE ID = '"+((IdInterface) E).getInternalID()+ "'");
		return result;
	}
	
	//esto regresa todos los elementos de alguna tabla en particular
	public ResultSet get(String Table) {
		ResultSet result = null;

		if (Table.equals(profesorExtString) || Table.equals(profesorUCLMString)) result = agente.select("SELECT * FROM " + Table + " NATURAL JOIN PROFESOR");
		else result = agente.select("SELECT * FROM " + Table);

		return result;
	}
	
	//get para estadoCurso
	public ResultSet get(String Table, EstadoCurso estadoCurso) {
		ResultSet result = null;
		
		if (Table.equals(cursoPropioString)) {
			result = agente.select("SELECT * FROM " + Table + " WHERE estadocurso = '"+estadoCurso+"'");
		}

		return result;
	}
	
	public ResultSet get(String Table, EstadoCurso estadoCurso, Date aFechaInicio, Date aFechaFin) {
		ResultSet result = null;
		
		if (Table.equals(cursoPropioString)) {
			result = agente.select("SELECT * FROM " + Table + " WHERE estadocurso = '"+estadoCurso+"' AND fechainicio >= '"+aFechaInicio+"' AND fechafin <= '"+aFechaFin+"'");
		}

		return result;
	}
	
	//get para coste total por tipos de curso
	public ResultSet get(TipoCurso tipoCurso,  Date aFechaInicio, Date aFechaFin) {
		ResultSet result = null;
		
		result = agente.select("SELECT COUNT(IDCURSO) AS n,COUNT(IDCURSO)*C.TASAMATRICULA AS total,IDCURSO FROM Matricula m "
				+ "INNER JOIN CursoPropio c ON m.idcurso = c.id WHERE m.pagado='TRUE' "
				+ "AND c.tipocurso='"+tipoCurso+"' "
				+ "AND c.fechainicio >= '"+aFechaInicio+"' "
				+ "AND c.fechafin <= '"+aFechaFin+"' "
				+ "GROUP BY IDCURSO, TASAMATRICULA");

		return result;
	}
	
	public ResultSet get_edicion(String Table, Date aFechaInicio, Date aFechaFin) {
		ResultSet result = null;
		
		if (Table.equals(cursoPropioString)) {
			result = agente.select("SELECT * FROM " + Table + " WHERE fechainicio >= '"+aFechaInicio+"' AND fechafin <= '"+aFechaFin+"'");
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
			break;
		case "ProfesorExterno":
			result = agente.insert("INSERT INTO " + className + " VALUES('" + ((ProfesorExterno) E).get_dni() + "','" + ((ProfesorExterno) E).get_titulacion() + "')");
			break;
		case "Matricula":
			String senteciamatricula= "INSERT INTO " + className + " VALUES('" + ((Matricula) E).get_fecha() +  "'," + ((Matricula) E).is_pagado() + ",'"
					+ ((Matricula) E).getId_estudiante() + "','"  + ((Matricula) E).getId_Curso() + "','"+((Matricula) E).get_tipoPago().toString()+"')";
			result = agente.insert(senteciamatricula);
			break;
		case "Materia":
			String sentencia= "INSERT INTO " + className + " VALUES('" + ((Materia) E).get_nombre()+ "',"+((Materia) E).get_horas() + ",'"+ ((Materia) E).get_fechaInicio() + "','" + ((Materia) E).get_fechaFin() +
			"','"+ ((Materia) E).getId_Curso()+ "','" +((Materia) E).getId_prof_responsable() + "')";
			result = agente.insert(sentencia);
			break;
		case "Centro":
			result = agente.insert("INSERT INTO " + className + "VALUES(" + ((Centro) E).get_Id() + ",'" + ((Centro) E).get_nombre() + "','" + ((Centro) E).get_localizacion() 
					+ "')");
			break;
		case "Estudiante":
			result = agente.insert("INSERT INTO " + className + " VALUES('" + ((Estudiante) E).get_dni() + "','" + ((Estudiante) E).get_nombre() + "','" + ((Estudiante) E).get_apellidos() 
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
			result = agente.update("UPDATE " + className + " SET ID='" + ((CursoPropio) E).get_id() + "', NOMBRE='"  + ((CursoPropio) E).get_nombre() + "', ECTS=" 
					+ ((CursoPropio) E).get_eCTS() + ", FECHAINICIO='"  + ((CursoPropio) E).get_fechaInicio() + "', FECHAFIN='"  + ((CursoPropio) E).get_fechaFin() + "', TASAMATRICULA=" 
					+ ((CursoPropio) E).get_tasaMatricula() + ", EDICION="  + ((CursoPropio) E).get_edicion() + ", IDCENTRO="  + ((CursoPropio) E).getId_centro() + ", SECRETARIO='"
					+ ((CursoPropio) E).getId_secretario() + "', DIRECTOR='"  + ((CursoPropio) E).getId_director() + "', TIPOCURSO='" + ((CursoPropio) E).get_tipo() 
					+ "', ESTADOCURSO='" + ((CursoPropio) E).get_estado() + "' WHERE ID = '" + ((CursoPropio) E).get_id() +"'");
					
			break;
		case "Profesor":
			result = agente.update("UPDATE " + className + " SET DNI='" + ((Profesor) E).get_dni() + "', NOMBRE='" + ((Profesor) E).get_nombre() + "', APELLIDOS='"
					 + ((Profesor) E).get_apellidos() + "', DOCTOR=" + ((Profesor) E).is_doctor()+ ", CENTRO=" + ((Profesor) E).get_centro() + ")" + " WHERE DNI = '" + ((Profesor) E).get_dni() +"'");
			break;
		case "ProfesorExterno":
			result = agente.update("UPDATE " + className + "SET DNI='" + ((ProfesorExterno) E).get_dni() + "', TITULACION='" + ((ProfesorExterno) E).get_titulacion() + "'"+ " WHERE DNI = '" + ((ProfesorExterno) E).get_dni() +"'");
			break;
		
		case "Matricula":
			result = agente.update("UPDATE " + className + "SET FECHA='" + ((Matricula) E).get_fecha() + "', PAGADO=" + ((Matricula) E).is_pagado() + ", DNIESTUDIANTE='"
					+ ((Matricula) E).getId_estudiante() + "', IDCURSO='" + ((Matricula) E).getId_Curso() + "', MODOPAGO='" + ((Matricula) E).get_tipoPago()+ "' WHERE ID = '" + ((Matricula) E).getiD() + "'");
			break;
		case "Materia":
			result = agente.update("UPDATE " + className + "SET NOMBRE='" + ((Materia) E).get_nombre()+ "', HORAS=" + ((Materia) E).get_horas() + ", FECHAINICIO='"
					+ ((Materia) E).get_fechaInicio() + "', FECHAFIN='" + ((Materia) E).get_fechaFin() + "', IDCURSO='" + ((Materia) E).getId_Curso() + "', DNIPROFESOR='" + ((Materia) E).getId_prof_responsable()+ "' WHERE NOMBRE = '" 
					+ ((Materia) E).get_nombre() +"'"); 
			break;
		case "Centro":
			result = agente.update("UPDATE " + className + "SET ID=" + ((Centro) E).get_Id() + ", NOMBRE='" + ((Centro) E).get_nombre() + "', LOCALIZACION='" + ((Centro) E).get_localizacion() 
					+ "' WHERE ID = '" + ((Centro) E).get_Id() +"'");
			break;
		case "Estudiante":
			result = agente.update("UPDATE " + className + "SET DNI='" + ((Estudiante) E).get_dni() + "', NOMBRE='" + ((Estudiante) E).get_nombre() + "', APELLIDOS='" + ((Estudiante) E).get_apellidos() 
					+ "', TITULACION='" + ((Estudiante) E).get_titulacion() + "', CUALIFICACION='" + ((Estudiante) E).get_cualificacion() + "' WHERE DNI = '" + ((Estudiante) E).get_dni() +"'" );
			break;
		}	
		return result;
	}
	public int delete (String iD, String Table, String keyName) {
		int result = 0;
		if (Table.equals(profesorExtString) || Table.equals(profesorUCLMString)) result = agente.update("DELETE FROM " + Table + " NATURAL JOIN PROFESOR WHERE "+keyName+" = " +iD);
		else result = agente.update("DELETE FROM" + Table + " WHERE "+keyName+" = " +iD);
		return result;
	}

}

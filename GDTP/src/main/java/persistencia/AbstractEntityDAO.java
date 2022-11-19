package persistencia;

import java.sql.*;
import negocio.entities.*;

public class AbstractEntityDAO<E>{

	private GestorBD agente = GestorBD.getAgente();
	
	//esto regresa un unico elemento
	public ResultSet get(String iD, String Table, String keyName) {
		
		ResultSet result = agente.select("SELECT * FROM " + Table + "WHERE " + keyName + " = " + iD);
		return result;
	}
	
	//esto regresa todos los elementos de alguna tabla en particular
	public ResultSet get(String iD, String Table) {
		
		ResultSet result = agente.select("SELECT * FROM " + Table);
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
					+ ((CursoPropio) E).getId_secretario() + "','"  + ((CursoPropio) E).getId_director() + "')");
			break;
			
		case "Profesor":
		}
		
		return result;
	}
	public E update (Object E) {
		E result = null;
		return result;
	}
	public int delete (Object E) {
		int i=0;
		return i;
	}
	public void operation() {
	}
}

package persistencia;

import java.sql.Date;

public class AbstractEntityDAO<E>{
	private String ID;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	
	public E get(String iD) {
		E result = null;
		
		return result;
	}
	public int insert (Object E) {
		int i=0;
		return i;
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

package persistencia;

public final class BaseDatos {
	
	private BaseDatos() {
	    throw new IllegalStateException("Clase de utilidad de Base de Datos");
	  }
	static final String DRIVER ="jdbc:derby";
	static final String CONNECTION_STRING ="jdbc:derby:BDGDTP;create=false";
	static final String DBNAME ="BDGDTP";
	static final String DBUSER ="admin";
	static final String DBPASS ="admin";
}
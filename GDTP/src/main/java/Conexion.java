import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	//Atributos de la clase relativos a la BD
	private static String CONTROLADOR = "com.mysql.cj.jdbc.Driver"; 
	private static String URL = "jdbc:mysql://localhost:3306/GDPT_bd";
	private static String USUARIO = "root";
	private static String CLAVE = "mysql"; 
	
	static {
		try {
			Class.forName(CONTROLADOR);
		}catch(ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}

	public Connection conectar() {
		Connection conexion = null;
		try {
			
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Conexion OK");
			
		}catch(SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		return conexion;
	}
		
	

} 

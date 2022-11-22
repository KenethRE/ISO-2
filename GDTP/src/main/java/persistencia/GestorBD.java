package persistencia;

import java.sql.*;

import org.apache.derby.jdbc.EmbeddedDriver;


public class GestorBD{
	
	private Statement stmt;
	private static Connection mBD;
	protected static GestorBD instancia = null;
	
	 protected GestorBD() throws SQLException {
		crearBaseDatos();
	}
	
	public static GestorBD getAgente() {
		 
		 if (instancia == null)
			try {
				instancia = new GestorBD();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 
		 return instancia;
	 }
	
	 
	public static void conectarBD() {
		Driver derbyEmbeddedDriver = new EmbeddedDriver();
		try {
			DriverManager.registerDriver(derbyEmbeddedDriver);
			mBD = DriverManager.getConnection(""+BaseDatos.DRIVER+":"+BaseDatos.DBNAME+";create=false", BaseDatos.DBUSER, BaseDatos.DBPASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void desconectarBD() {
		try {
			mBD.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet select(String consulta){
		ResultSet res = null;
		try {
			conectarBD();
			stmt = mBD.createStatement();
			res = stmt.executeQuery(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public int insert(String sentencia) {
		int res = 0;
		try {
            conectarBD();
		try(PreparedStatement pstmt = mBD.prepareStatement(sentencia)) {
                    res = pstmt.executeUpdate();
               }
        desconectarBD();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
    	
	}
	
	public int update(String consulta) {
		int res = 0;
		try {
			conectarBD();
			stmt = mBD.createStatement();
			res=stmt.executeUpdate(consulta);
                        stmt.close();
			desconectarBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
    }
	
	
	public static void crearBaseDatos() {
		try {
			Driver derbyEmbeddedDriver = new EmbeddedDriver();
			DriverManager.registerDriver(derbyEmbeddedDriver);
			mBD = DriverManager.getConnection(""+BaseDatos.DRIVER+":"+BaseDatos.DBNAME+";create=true", BaseDatos.DBUSER, BaseDatos.DBPASS);
			try (Statement stmt = mBD.createStatement()) {
				stmt.execute("CREATE TABLE Centro (id INT NOT NULL, Nombre VARCHAR (20) NOT NULL, Localizacion VARCHAR(40) NOT NULL, PRIMARY KEY (id))");
				stmt.execute("CREATE TABLE Profesor (dni VARCHAR(10) NOT NULL, Nombre VARCHAR(40) NOT NULL,Apellidos VARCHAR(40) NOT NULL,doctor BOOLEAN NOT NULL,Centro INT,PRIMARY KEY (DNI),FOREIGN KEY (Centro) REFERENCES Centro(id))");
				stmt.execute("CREATE TABLE ProfesorExterno (dni VARCHAR(10) NOT NULL, titulacion VARCHAR(40) NOT NULL,FOREIGN KEY (dni) REFERENCES Profesor(dni))");
				stmt.execute("CREATE TABLE ProfesorUCLM (dni VARCHAR(10) NOT NULL, Nombre VARCHAR(40) NOT NULL,Apellidos VARCHAR(40) NOT NULL,CategoriaProfesor VARCHAR(40) NOT NULL,FOREIGN KEY (dni) REFERENCES Profesor(dni))");
				stmt.execute("CREATE TABLE CursoPropio (id VARCHAR(10) NOT NULL, Nombre VARCHAR(40) NOT NULL, ECTS INT NOT NULL, FechaInicio DATE NOT NULL, FechaFin DATE NOT NULL, TasaMatricula FLOAT (2) NOT NULL, Edicion INT NOT NULL, idCentro INT NOT NULL, Secretario VARCHAR(10) NOT NULL,\r\n"
						+ "Director VARCHAR(10) NOT NULL, TipoCurso VARCHAR (40) NOT NULL,EstadoCurso VARCHAR(40) NOT NULL, PRIMARY KEY (ID), FOREIGN KEY (idCentro) REFERENCES Centro(id), FOREIGN KEY (Secretario) REFERENCES Profesor(dni), FOREIGN KEY (Director) REFERENCES Profesor(dni))");
				stmt.execute("CREATE TABLE Estudiante (dni VARCHAR(10) NOT NULL, Nombre VARCHAR(40) NOT NULL, Apellidos VARCHAR(40) NOT NULL, Titulacion VARCHAR(40) NOT NULL,Cualificacion VARCHAR(40) NOT NULL, PRIMARY KEY (dni))");
				stmt.execute("CREATE TABLE Materia (Nombre VARCHAR(40) NOT NULL,horas FLOAT (2) NOT NULL,FechaInicio DATE NOT NULL,FechaFin DATE NOT NULL,idCurso VARCHAR (10),dniprofesor VARCHAR(10), FOREIGN KEY (idCurso) REFERENCES CursoPropio(id),FOREIGN KEY (dniprofesor) REFERENCES Profesor(dni))");
				stmt.execute("CREATE TABLE Matricula (id INT, PRIMARY KEY(ID), Fecha DATE NOT NULL,Pagado BOOLEAN NOT NULL,dniEstudiante VARCHAR(10) NOT NULL,idCurso VARCHAR (10) NOT NULL,ModoPago VARCHAR(40) NOT NULL,FOREIGN KEY (dniEstudiante) REFERENCES Estudiante(dni),FOREIGN KEY (idCurso) REFERENCES CursoPropio(id))");
			}
		} catch (SQLException ex) {
			conectarBD();
		}
		

		try {
			DriverManager.getConnection("jdbc:derby:;shutdown=true");
		} catch (SQLException ex) {
			if (((ex.getErrorCode() == 50000) && ("XJ015".equals(ex.getSQLState())))) {
				System.out.println("Derby shut down normally");
			} else {
				System.err.println("Derby did not shut down normally");
				System.err.println(ex.getMessage());
			}
		}
	
}


	
}
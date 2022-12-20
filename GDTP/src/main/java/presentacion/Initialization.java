package presentacion;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import persistencia.GestorBD;

public class Initialization {
	static GestorBD agente;
	public static void main () {
		try {

		agente = GestorBD.getAgente();
		if (!agente.select("SELECT * FROM CENTRO").next()) {
		
		agente.insert("INSERT INTO CENTRO VALUES (1,'UCLMTALA','TALAVERA')");
		agente.insert("INSERT INTO CENTRO VALUES (2,'UCLMTOL','TOLEDO')");
		agente.insert("INSERT INTO CENTRO VALUES (3,'UCLMCR','CIUDAD REAL')");
		agente.insert("INSERT INTO ESTUDIANTE VALUES ('1','PEPE','PEREZ','INGENIERO','INGENIERO')");
		agente.insert("INSERT INTO ESTUDIANTE VALUES ('2','PEDRO','MORO','AQUITECTO','INGENIERO')");
		agente.insert("INSERT INTO ESTUDIANTE VALUES ('3','JUAN','PEREZ','DOCTOR','LOGOPEDO')");
		agente.insert("INSERT INTO PROFESOR  VALUES ('01','DAVID','PEREZ',FALSE,1)");
		agente.insert("INSERT INTO PROFESOR  VALUES ('02','PIPI','MORO',TRUE,2)");
		agente.insert("INSERT INTO PROFESOR  VALUES ('03','MAMEN','PEREZ',TRUE,3)");
		agente.insert("INSERT INTO CURSOPROPIO  VALUES ('ROBOT','ROBOTICA',20,'2009-01-01','2010-01-01',200,1,1,'01','02','MASTER','PROPUESTO')");
		agente.insert("INSERT INTO CURSOPROPIO  VALUES ('MANUAL','MANUALIDADES',30,'2010-05-15','2011-07-08',300,2,2,'02','01','EXPERTO','VALIDADO')");
		agente.insert("INSERT INTO CURSOPROPIO  VALUES ('PROG1','PROGRAMACION',50,'2011-07-15','2013-07-08',500,3,1,'03','01','EXPERTO','PROPUESTO')");
		agente.insert("INSERT INTO PROFESOREXTERNO  VALUES ('01','INGENIERO')");
		agente.insert("INSERT INTO PROFESORUCLM  VALUES ('02','PIPI','MORO','CATEDRATICO')");
		agente.insert("INSERT INTO PROFESOREXTERNO  VALUES ('03','ARQUITECTO')");
		
		}
		
		Logger.getLogger("GDTP_Logger").log(Level.INFO, "Inicializacion de BD correcta.");
		
		
		} catch (Exception e) {
			Logger.getLogger("GDTP_Logger").log(Level.SEVERE, "Problema al inicializar app. Revisar registro completo:" + e.getMessage()
			+ new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z").format(System.currentTimeMillis()));
		}
		
	}
}

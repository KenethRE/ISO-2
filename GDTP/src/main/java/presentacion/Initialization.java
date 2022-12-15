package presentacion;
import java.util.logging.Level;
import java.util.logging.Logger;

import persistencia.GestorBD;

public class Initialization {
	static GestorBD agente;
	public static void main () {
		try {
		agente = GestorBD.getAgente();
		Logger.getLogger("GDTP_Logger").log(Level.INFO, "Inicializacion de BD correcta.");
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
	}
}

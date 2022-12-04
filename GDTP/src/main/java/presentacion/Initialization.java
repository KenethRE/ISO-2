package presentacion;
import persistencia.GestorBD;

public class Initialization {
	static GestorBD agente;
	public static void main () {
		try {
		agente = GestorBD.getAgente();
		System.out.println("Inicializacion de BD correcta.");
		
		
		
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
	}
}

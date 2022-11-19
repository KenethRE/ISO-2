package presentacion;
import persistencia.*;

public class exe {
	public static void main (String [] args) {
		GestorBD agente = GestorBD.getAgente();
		System.out.println(agente.getClass().getSimpleName());
	}
}

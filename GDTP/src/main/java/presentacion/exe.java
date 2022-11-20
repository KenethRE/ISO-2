package presentacion;
import negocio.entities.*;
import persistencia.*;

public class exe {
	public static void main (String [] args) {
		Profesor agente = new ProfesorExterno("sdfasdf");
		System.out.println(agente.getClass().getSimpleName());
	}
}

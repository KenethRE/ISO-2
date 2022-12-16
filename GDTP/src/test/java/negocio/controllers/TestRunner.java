package negocio.controllers;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(GestorConsultasTest.class); //cambias aqui el nombre de la clase para saber el resultado
      System.out.println("test gestor consultas:");
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
      System.out.println("test gestor pruebas cursos:");
      
      result = JUnitCore.runClasses(GestorPropuestaCursoTest.class); //cambias aqui el nombre de la clase para saber el resultado
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
      
   }
}
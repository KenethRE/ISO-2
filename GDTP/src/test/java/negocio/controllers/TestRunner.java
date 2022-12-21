package negocio.controllers;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
   public static void main(String[] args) {
	   
      Result result = JUnitCore.runClasses(GestorConsultasTest.class); //cambias aqui el nombre de la clase para saber el resultado
      
      System.out.println("Test gestor consultas:");
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
      
      System.out.println("Test gestor pruebas cursos:");
      
      result = JUnitCore.runClasses(GestorPropuestaCursoTest.class); 
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
      
      System.out.println("Test gestor matriculacion:");
      
      result = JUnitCore.runClasses(GestorMatriculacionTest.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
   }
}
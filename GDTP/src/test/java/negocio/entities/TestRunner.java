package negocio.entities;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
   public static void main(String[] args) {
	   
      Result result = JUnitCore.runClasses(CentroTest.class); 
      
      System.out.println("Test Centro:");
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
      
      result = JUnitCore.runClasses(CursoPropioTest.class);
     
      System.out.println("Test CursoPropio:");
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
      result = JUnitCore.runClasses(MateriaTest.class);
	
      System.out.println("Test Materia:");
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
      result = JUnitCore.runClasses(MatriculaTest.class);
		
      System.out.println("Test Matricula:");
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
      result = JUnitCore.runClasses(ProfesorExternoTest.class);
	
      System.out.println("Test ProfesorExterno:");
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
      result = JUnitCore.runClasses(ProfesorTest.class);
		
      System.out.println("Test Profesor:");
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
      result = JUnitCore.runClasses(ProfesorUCLMTest.class);
	
      System.out.println("Test ProfesorUCLM:");
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
   }
}
package TestJunit;

import junit.framework.TestCase;

public class TestConexionBD extends TestCase {
	
	private TestJunit.ConexionBD conn;
	
	public void IniciarTest() {		
      conn = new TestJunit.ConexionBD();
	}

	public void testConectarMySql3() {
		System.out.println("Conexion a MySql 3 : Sin datos");
    	IniciarTest();
    	assertTrue(conn.ConectarBD("","","")== null);
    	System.out.println("\n");
    }
	
	public void testConectarMySql2() {
    	IniciarTest();
    	System.out.println("Conexion a MySql 2 : Utilizando solo URL");
    	assertTrue(conn.ConectarBD("","","jdbc:mysql://localhost:3306")== null);
    	System.out.println("\n");
    }	
		
	public void testConectarMySql1() {
    	IniciarTest();
    	System.out.println("Conexion a MySql 1 : Utilizando URL, Username y Password");
    	assertTrue(conn.ConectarBD("root","root","jdbc:mysql://localhost:3306")!= null);
    	System.out.println("\n");
    }	
	
}

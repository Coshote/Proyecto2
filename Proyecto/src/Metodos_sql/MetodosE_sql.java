package Metodos_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class MetodosE_sql {
	public static ConexiconBDE conexion= new ConexiconBDE();
	public static PreparedStatement sentencia_preparada;
	public static ResultSet resultado;
	public static String sql;
	public static int resultado_numero=0;
	
	public int guardar(String nombre, String telefono, String nivel, String profesion) {
		int resultado=0;
		Connection conexion=null;
		
		String sentencia_guardar=("INSERT INTO lista_empresas(nombre,telefono,nivel,profesion) VALUES(?,?,?,?)");
		
		try {
			conexion= ConexiconBDE.conectar();
			sentencia_preparada= conexion.prepareStatement(sentencia_guardar);
			sentencia_preparada.setString(1,nombre);
			sentencia_preparada.setString(2,telefono);
			sentencia_preparada.setString(3, nivel);
			sentencia_preparada.setString(4, profesion);

			
			resultado=sentencia_preparada.executeUpdate();
			sentencia_preparada.close(); 
			
			conexion.close();
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		return resultado;
	}


	
	

	
	
	


}

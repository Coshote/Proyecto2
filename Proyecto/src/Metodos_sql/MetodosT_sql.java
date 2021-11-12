package Metodos_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MetodosT_sql {
	public static ConexionBDT conexion= new ConexionBDT();
	public static PreparedStatement sentencia_preparada;
	public static ResultSet resultado;
	public static String sql;
	public static int resultado_numero=0;
	
	public int guardar(String nombre, String telefono) {
		int resultado=0;
		Connection conexion=null;
		
		String sentencia_guardar=("INSERT INTO lista_trabajadores(nombre,telefono) VALUES(?,?)");
		
		try {
			conexion= ConexionBDT.conectar();
			sentencia_preparada= conexion.prepareStatement(sentencia_guardar);
			sentencia_preparada.setString(1,nombre);
			sentencia_preparada.setString(2,telefono);

			
			resultado=sentencia_preparada.executeUpdate();
			sentencia_preparada.close(); 
			
			conexion.close();
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		return resultado;
	}
	


}

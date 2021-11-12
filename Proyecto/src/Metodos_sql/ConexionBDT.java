package Metodos_sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBDT {
	public static String url="jdbc:mysql://localhost/trabajadores";
	public static String usuario="root";
	public static String contraseña="Seirei345";
	public static String clase="com.mysql.jdbc.Driver";
	
	public static Connection conectar() {
		Connection conexion= null;
		try {
			Class.forName(clase);
			conexion= (Connection) DriverManager.getConnection(url,usuario,contraseña);
			System.out.println("conexion establecida");
		}catch(Exception e){
			System.out.println(e);
		}
		return conexion;
	}



}

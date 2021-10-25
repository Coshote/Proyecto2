import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ContenidoEmpresas {
	public void Grabar(String cadena) {
		try {
		FileWriter archivo= new FileWriter("Empresas.txt",true);
		try(BufferedWriter almacen= new BufferedWriter(archivo)){
			almacen.write(cadena+"\n");
			almacen.close();
		}
		archivo.close();
		}catch(Exception ex){}
		
		
	}
	public ArrayList<String> Leer(){
		ArrayList<String> datos= new ArrayList<>();
		try {
			FileReader archivo = new FileReader("Empresas.txt");
			BufferedReader lectura= new BufferedReader(archivo);
			String cadena;
			
			while((cadena= lectura.readLine())!=null) {
				datos.add(cadena); 
			}
		}catch(Exception ex) {}
		return datos;
		
	}
	
	public void Grabar_Empleados(String datos) {
		try{
			FileWriter archivo_e= new FileWriter("Empleados.txt",true);
			try(BufferedWriter almacen= new BufferedWriter(archivo_e)){
				almacen.write(datos+"\n");
				almacen.close();
			}
			archivo_e.close();
			
			
		}catch(Exception ex) {}
	}
	
	public ArrayList<String> Leer_Empleados(){
		ArrayList<String> datos= new ArrayList<>();
		try {
			FileReader archivo = new FileReader("Empleados.txt");
			BufferedReader lectura= new BufferedReader(archivo);
			String cadena;
			
			while((cadena= lectura.readLine())!=null) {
				datos.add(cadena); 
			}
		}catch(Exception ex) {}
		return datos;
		
	}
	
	
	
	
}

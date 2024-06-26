package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {
	
	// Attributes
	private String ruta;

	// Constructors
	public Archivo(String ruta) {
        this.ruta = ruta;
    }

	
	// Getters y Setters
	public String getruta() {
		return ruta;
	}
	
	public void setRuta(String ruta) {
	       this.ruta = ruta;
	 }

	public void setruta(String ruta) {
		this.ruta = ruta;
	}

	// Metodos
	public boolean exist()
	{
		File file = new File(ruta); 
		if(file.exists())
		      return true;
		return false;
	}
	
	
	//-------------------------------------------------------------------------------
	// crearArchivo
	public boolean creaArchivo(Usuario usuarioNuevo)
	{
		FileWriter escritura;
		try {
			escritura = new FileWriter(ruta, true);
			escritura.write(usuarioNuevo.toString());
			escritura.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
			
	}
	
	public boolean creaArchivo()
	{
		FileWriter escritura;
		try {
			escritura = new FileWriter(ruta, true);
			escritura.write("");
			escritura.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
			
	}
	
	//-------------------------------------------------------------------------------
	//escribeLineas
	public void escribe_lineas(String frase) {
		try 
		{	
			FileWriter entrada = new FileWriter(ruta, true);
			BufferedWriter miBuffer = new BufferedWriter(entrada);
			miBuffer.write(frase);
			miBuffer.close();
			entrada.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//-------------------------------------------------------------------------------
	
	//Funcion retornar lineas
	
		public String lee_lineas() {
		    StringBuilder contenidoArchivo = new StringBuilder();
		    try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
		        String linea;
		        while ((linea = br.readLine()) != null) {
		            contenidoArchivo.append(linea).append("\n");
		        }
		        br.close();
		    } catch (IOException e) {
		        System.out.println("No se pudo leer el archivo.");
		    }
		    return contenidoArchivo.toString();
		}
		
		
		
		//Funcion retornar usuarios en una lista de tipo Usuario
		
		public ArrayList<Usuario> retornarUsuarios() {
			FileReader entrada;
			ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
			try {
				entrada=new FileReader(ruta);
				BufferedReader br = new BufferedReader(entrada);
				String linea;
				while((linea=br.readLine())!=null){
					String partes[]=linea.split("-");
					if(partes.length==2) {
						Usuario usuario = new Usuario(Integer.parseInt(partes[0]),partes[1]);
						usuarios.add(usuario);
					}
				}
				br.close();
				entrada.close();
			}
			catch(IOException e){
				System.out.println("No se pudo leer el archivo.");
			}
			return usuarios;
		}
   
}

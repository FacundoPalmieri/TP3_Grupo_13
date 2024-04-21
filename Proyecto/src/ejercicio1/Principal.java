package ejercicio1;

import java.util.TreeSet;

public class Principal {

	public static void main(String[] args) {
	
		Usuario usuario = new Usuario();
		TreeSet<Usuario> listaUsuario = new TreeSet<Usuario>();
		Archivo archivo = new Archivo("Usuarios.txt");
		
		if(!archivo.exist()) {
			archivo.creaArchivo();
		}
		
		archivo.lee_lineas();
		

	}

}

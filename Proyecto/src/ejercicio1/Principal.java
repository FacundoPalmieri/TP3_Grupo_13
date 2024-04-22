package ejercicio1;

import java.util.TreeSet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
	
		Usuario usuario = new Usuario();
		TreeSet<Usuario> listaUsuario = new TreeSet<Usuario>();
		Archivo archivo = new Archivo("Usuarios.txt");
		
		if(!archivo.exist()) {
			archivo.creaArchivo();
		}
		

        try (BufferedReader br = new BufferedReader(new FileReader(archivo.getruta()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.isEmpty()) { // Verificar si la línea está vacía
                    String[] partes = linea.split("-");
                    if (partes.length == 2) { // Verificar si se dividió en dos partes correctamente
                        int id = Integer.parseInt(partes[0].trim());
                        String nombreUsuario = partes[1].trim();
                        
                        try {
                            if (Usuario.verificarUsuarioInvalido(nombreUsuario)) {
                                Usuario nuevoUsuario = new Usuario(id, nombreUsuario);
                                listaUsuario.add(nuevoUsuario);
                            }
                        } catch (UsuarioInvalidoException e) {
                            System.out.println("El usuario \"" + nombreUsuario + "\" no es válido.");
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo.");
        }

        System.out.println("Usuarios válidos:");
        for (Usuario u : listaUsuario) {
            System.out.println(u);
        }
    }
}

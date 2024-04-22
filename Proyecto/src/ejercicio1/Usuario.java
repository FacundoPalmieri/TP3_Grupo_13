package ejercicio1;

public class Usuario implements Comparable<Usuario>{
	
	private int id;
	private String nombre;
	
	// Constructores
	public Usuario() {
		this.id = 0;
		this.nombre = "Sin Nombre";	
	}
	
	public Usuario(int Id, String Nombre) {
		this.id = Id;
		this.nombre = Nombre;
		
	}

	
	
	public static boolean verificarUsuarioInvalido(String Usuario) throws UsuarioInvalidoException {
		
		 if (Usuario.length() < 10 || !Usuario.matches(".*\\d.*") || !Usuario.matches(".*[A-Z].*")) {
			 
			throw new UsuarioInvalidoException();
	     }
		 
		return true;	
	}
	

	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + "]";
	}

	@Override
	public int compareTo(Usuario otroUsuario) {
		return this.nombre.compareTo(otroUsuario.nombre);
	}
	
	
	
	
	

}

package ejercicio1;

public class Usuario implements Comparable<Usuario>{
	
	private int id;
	private String nombre;
	private static int contador=0;
	
	// Constructores
	public Usuario() {
		contador++;
		this.id = contador;
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
		return getId()+"-"+getNombre();
	}

	@Override
	public int compareTo(Usuario otroUsuario) {
		return this.nombre.compareTo(otroUsuario.nombre);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	

}

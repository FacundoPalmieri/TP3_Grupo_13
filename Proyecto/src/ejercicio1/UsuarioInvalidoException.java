package ejercicio1;

public class UsuarioInvalidoException extends RuntimeException {
	
	@Override
	public String getMessage() {
		
		return "Usuario Inválido";
	}
	
	

}

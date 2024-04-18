package ejercicio1;

public class UsuarioInvalidoException extends RuntimeException {
	
	public UsuarioInvalidoException()
	{
	}

	@Override
	public String getMessage() {
		
		return "Usuario Inválido";
	}
	
	

}

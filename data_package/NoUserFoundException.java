package data_package;

public class NoUserFoundException extends IllegalArgumentException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoUserFoundException(String error_string){
		super(error_string);
	}
}
	

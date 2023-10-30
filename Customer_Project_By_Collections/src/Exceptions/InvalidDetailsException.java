package Exceptions;

public class InvalidDetailsException extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidDetailsException(String msg)
	{
		super(msg);
	}

}

package vehicleException;

public class WrongPasswordException extends Exception
{
	public WrongPasswordException(String msg)
	{
		super(msg);
	}
	
}

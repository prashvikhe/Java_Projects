package vehicleException;

public class DuplicateCustomerIdException extends Exception
{
	public DuplicateCustomerIdException(String msg ) {

		super("Duplicate customer_Id !!!!!!");
	}
	
}

package EmployeeExceprion;

import java.beans.ExceptionListener;

public class EmpInvalidDetailException extends Exception
{
	public EmpInvalidDetailException(String msg)
	{
		super(msg);
	}
}

package Employee_Validation;

import java.time.LocalDate;
import java.util.Map;
import Employee.Department;
import Employee.Employee;
import EmployeeExceprion.EmpInvalidDetailException;

public class Employee_Validation 
{
	public static Employee validateDetails(String id, String First_name, String last_name,double sal,String d,String date,Map<String,Employee> map) throws EmpInvalidDetailException
	{
		checkDuplicate(id,map);
		LocalDate joinDate=validateDate(date);
		Department dept=validateDept(d);
		return new Employee(id,First_name,last_name,sal,dept,joinDate);
	}

	private static void checkDuplicate(String id,Map<String,Employee> map) throws EmpInvalidDetailException
	{
		if(map.containsKey(id))
		{
			throw new EmpInvalidDetailException("Duplicate employee ID !!!");
		}
		
	}

	private static Department validateDept(String dept) 
	{
		return Department.valueOf(dept.toUpperCase());
	}

	private static LocalDate validateDate(String d) throws EmpInvalidDetailException
	{
		LocalDate date=LocalDate.parse(d);
		if(LocalDate.now().getYear()-date.getYear()>3)
		{
			throw new  EmpInvalidDetailException("You Enter a wrong date !!!!!!!");
		}
		return date;
	}
	
	

}

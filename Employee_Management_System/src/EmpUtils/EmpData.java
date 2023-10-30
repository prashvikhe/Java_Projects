package EmpUtils;

import static Employee_Validation.Employee_Validation.validateDetails;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Employee.Employee;
import EmployeeExceprion.EmpInvalidDetailException;

public class EmpData 
{
	public static Map<String,Employee> mapEmpData() throws EmpInvalidDetailException
	{
		Map<String,Employee> map=new HashMap<String,Employee>();

		map.put("S00-123",validateDetails("S00-123","Saurabh","Nikam",26000,"RND","2022-11-12",map));
		map.put("S00-124",validateDetails("S00-124", "Aniket", "Ghadage", 30000, "FINANCE", "2021-03-04",map));
		map.put("S00-125",validateDetails("S00-125", "Mohit", "Lakhande", 15000, "HR", "2023-04-14",map));
		map.put("S00-126",validateDetails("S00-126", "Prashant", "VikhePatil", 22000, "PRODUCTION", "2022-12-03",map));
		map.put("S00-127",validateDetails("S00-127", "Pravin", "Nirmal", 29000, "SALES", "2023-01-26",map));
		
		return map;
	}
	
	
	public static List<Employee> listEmpData(Map<String,Employee> map)
	{
		List<Employee> list=new ArrayList<Employee>();
		
		for(Employee emp:map.values())
		{
			list.add(emp);
		}
		
		return list;
	}

}

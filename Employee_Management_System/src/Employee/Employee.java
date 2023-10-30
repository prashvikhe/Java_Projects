package Employee;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable
{
	private String id;
	private String first_name;
	private String last_name;
	private double sal;
	private LocalDate joinDate;
	private Department dept;
	
	
	public Employee()
	{
		
	}

	
	public Employee(String id, String first_name, String last_name,double sal,Department dept,LocalDate joinDate) 
	{
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.sal=sal;
		this.joinDate=joinDate;
		this.dept=dept;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", sal=" + sal
				+ ", joinDate=" + joinDate + "]";
	}


	public String getId()
	{
		return id;
	}


	public void setId(String id) 
	{
		this.id = id;
	}

	
}

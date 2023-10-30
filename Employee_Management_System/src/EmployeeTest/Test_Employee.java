package EmployeeTest;

import static EmpUtils.EmpData.*;
import static Employee_Validation.Employee_Validation.*;
import static IO_Utils.FilingData.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import Employee.Employee;
import EmployeeExceprion.EmpInvalidDetailException;

public class Test_Employee 
{


	public static void main(String[] args) 
	{
		try(Scanner sc=new Scanner(System.in))
		{
			
			System.out.println("1. list of all emp in map : ");
			System.out.println("2. list of all  in list  :");
			System.out.println("3. Promote an emps :");
			System.out.println("4. Delete emp details :");
			System.out.println("5. Store a data in file  : ");
			System.out.println("6. Restore a data from a file :.");
			System.out.println("0. Exit");
			boolean exit=false;
			try
			{
//				Map<String,Employee> map1=restoreData("EmpData");
				Map<String,Employee> map=mapEmpData();
				List<Employee> list=listEmpData(map);
				while(!exit)
				{
					System.out.println("Enter your choice !!!!");
					int ch=sc.nextInt();
					switch(ch)
					{
					case 1:
						
						map.forEach((k,v)->System.out.println(k+" "+v));
						break;
					case 2:
						
						list.forEach(p->System.out.println(p));
						break;
					case 3:
						System.out.println("Enter a employee details :  id,  First_name,  last_name, salary, department, date");
						map.put(sc.next(),validateDetails(sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),map));
//						map1.put(sc.next(),validateDetails(sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),map));
					break;
					case 4:
						System.out.println("Enter a id :");
						String id=sc.nextLine();
						if(map.containsKey(id))
//						if(map1.containsKey(id))
						{
							map.remove(id);
//							map1.remove(id);
						}
						else
						{
							throw new EmpInvalidDetailException("You enter wrong emp id : ");
						}
						break;
					case 5:
						System.out.println("Enter a file name ");
						System.out.println("Data In file : ");
						storeData(sc.next(),map);
//						storeData(sc.next(),map1);
						break;
					case 6:
						System.out.println("Enter a file name: ");
						System.out.println("Data restored in file : ");
						Map<String,Employee> data=restoreData(sc.next());//"EmpData.ser"
//						Map1<String,Employee> data=restoreData(sc.next());
						data.forEach((k,v)->System.out.println(k+" "+v));
						break;
					case 7:
						System.out.println("Ordered by roll number :");
						map.values().stream().sorted((a,b)->a.getId().compareTo(b.getId())).forEach(p->System.out.println(p));;
//						map1.values().stream().sorted((a,b)->a.getId().compareTo(b.getId())).forEach(p->System.out.println(p));;
						break;
					case 8:
						System.out.println("Ordered list by collections.sort()");
						Collections.sort(list, new Comparator<Employee>() 
						{

							@Override
							public int compare(Employee o1, Employee o2) {
								
								return o1.getId().compareTo(o2.getId());
							}
						});
						list.forEach(p->System.out.println(p));
						break;
					case 9:
						System.out.println("Sorted list");
					case 10:
						System.out.println("Read from file :");
						restoreData(sc.next()).values().forEach(p->System.out.println(p));;
						break;
						
					case 0:
						System.out.println("Enter your file name :");
						exit=true; 
					default:
						System.out.println("Invalid Data !!!!");
						break;
							
					}
				}
//				}storeData(sc.next(),map);
//			}storeData(sc.next(),map);
			}
			catch(Exception e)
			{
//				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			
		}
		
	}

}

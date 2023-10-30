package vehicleTest;
import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.*;

import vehicle.Customer;
import vehicle.ServicePlan;
import vehicleException.DuplicateCustomerIdException;
import vehicleException.InvalidDOBException;
import vehicleException.InvalidEmailException;
import vehicleException.WrongPasswordException;
public class CustomerValidation {

	public static void main(String[] args) throws WrongPasswordException,InvalidEmailException, ParseException, InvalidDOBException, DateTimeParseException, DuplicateCustomerIdException 
	{
		try(Scanner sc=new Scanner(System.in))
		{
//			System.out.println("Enter a how many customer you want to add");
			Customer[] cust=new Customer[5];
			System.out.println("1.Add a customer details : ");
			System.out.println("2.Show details :");
			System.out.println("3.Which plan yoy want: ");
			System.out.println("4.Change password :");
			System.out.println("5.Change DOB");
			System.out.println("6.Change Email : ");
			System.out.println("7.Exit");
			int ch=0;
			int index=0;
			do
			{
				System.out.println("Enter your choice : ");
				ch=sc.nextInt();
				switch(ch)
				{
				case 1:
					if(index<cust.length)
					{
						System.out.println("Entyer customer details : (Fisrt_name,Last_Name,Email,Password,DOB)");
						cust[index++]=new Customer(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(), cust); 
					}
					
					else
					{
						System.out.println("No vehicle is available");
					}
					break;
				case 2:
					for(Customer c:cust)
					{
						if(c!=null)
						System.out.println(c);
					}
					break;
				case 3:
					System.out.println("Enter customer id : ");
					int cid=sc.nextInt();
					for(Customer c: cust)
					{
						if(c.getCustomer_id()==cid && c!=null)
						{
							for( ServicePlan cat:ServicePlan.values())
							{
								System.out.println(cat);
							}
							System.out.println("Enert your service plan : ");
							double charge=c.planCharge(sc.next());
							System.out.println("Your charges are : "+charge);
							break;
						}
					}
					break;
				case 4:
					System.out.println("Enter customer id : ");
					cid=sc.nextInt();
					for(int i=0;i<index;i++)
					{
						if(cust[i].getCustomer_id()==cid)
						{
							
							System.out.println("Enter New pass to change: ");
							cust[i].setPassword(sc.next());
						}
					}
//					String s="sdsd";
//					String s2="sedfsdf";
//					System.out.println(s.equals(s2));
					break;
					default:
						System.out.println("Invalid choice!!!!!!");
				}
			}while(ch<8);
		}
		
	}

}

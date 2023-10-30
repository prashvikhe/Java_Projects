package Testing_Customer_Details;
import static PupulatedClass.Populated_Class.customerDetails;
import static utils.Customer_Validation.deleteSubscription;
import static utils.Customer_Validation.customerLogin;
import static utils.Customer_Validation.unsubscribe;
import static utils.Customer_Validation.validateDetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Customer_Details.Customer;
import Customer_Details.SortingCustomer;
import Exceptions.InvalidDetailsException;
public class Customer_Test 
{
	public static void main(String[] args) throws InvalidDetailsException 
	{
		try(Scanner sc=new Scanner(System.in))
		{
			ArrayList arr=new ArrayList<Integer>();
			List<Customer> list =customerDetails();
			int ch=0;
			do
			{
				System.out.println("1.Sign Up : ");
				System.out.println("2.Sign In : ");
				System.out.println("3.Display all details : ");
				System.out.println("4.Change password :");
				System.out.println("5.Unsubscribe Customer  : ");
				System.out.println("6.Sorteb by name ");
				System.out.println("7.Sorted by descending order");
				System.out.println("8.exit");
				System.out.println("Enter your choice : ");
				ch=sc.nextInt();
				try
				{
					switch(ch)
					{
					case 1:
						System.out.println("Enter details :  first_name,  last_name,  email,  password,  dob, plan,paySubscription");
						Customer cust=validateDetails(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.next(),sc.next(),list);
						list.add(cust);
						break;
					
					case 2:
						System.out.println("Enter a email and password : ");
						Customer validCustomer=customerLogin(sc.next(),sc.next(),list);
//						System.out.println(validCustomer);
						break;
					case 3:
						for(Customer c:list)
						{
							System.out.println(c);
						}
						break;
					case 4:
						System.out.println("Enter email and password :");
						System.out.println("Enter a email and password : ");
						validCustomer=customerLogin(sc.next(),sc.next(),list);
						validCustomer.setPassword();
						System.out.println("Password change Successfully : ");
						break;
					case 5:
						System.out.println("Enter email and password :");
						System.out.println("Enter a email and password : ");
						validCustomer=customerLogin(sc.next(),sc.next(),list);
						unsubscribe(validCustomer,list);
						System.out.println("Account Unsubscribe Successfully ...");
						break;
					case 6:
						System.out.println("Sorted Collections by : Emails");
						Collections.sort(list);
						break;
					case 7:
						System.out.println("sorting by Date");
						Collections.sort(list, new SortingCustomer());
						break;
					case 8:
						System.out.println("Sorted Collections by : Desceding Order by name");
						Collections.sort(list,new Comparator<Customer>()
						{
							@Override
							public int compare(Customer o1,Customer o2)
							{
								int i=o1.getFirst_name().compareTo(o2.getFirst_name());
								if(i>0)
								{
									return 1;
								}
								if(i<0)
								{
									return -1;
								}
								return 0;
							}
						});
						break;
					case 9:
						System.out.println("Pay Subscription : ");
						
						Iterator<Customer> itr=list.iterator();
						while(itr.hasNext())
						{
							Customer c=deleteSubscription(itr.next());
							if(c!=null)
							System.out.println(c);
						}
						break;
					case 10:
						System.out.println("Unsubscribed for didn't pay:");
						itr=list.iterator();
						while(itr.hasNext())
						{
							Customer c=deleteSubscription((Customer)itr.next());
							if(c!=null)
							itr.remove();;
						}
						break;
					default:
							System.out.println("Invalid choice!!!!!!");
					}
				}
				catch(Exception e)
				{
					
					System.out.println(e.getMessage());
				}
			}while(ch<11);
			
		}catch(Exception e)
		{
			e.getStackTrace();
		}
		
		
		}	
	}



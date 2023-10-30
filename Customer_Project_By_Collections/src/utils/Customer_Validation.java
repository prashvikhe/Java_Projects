package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.List;

import Customer_Details.Customer;
import Exceptions.InvalidDetailsException;

public class Customer_Validation
{

	public static Customer validateDetails(String first_name, String last_name, String email, String password,
			String dob,double regamount, String plan,String subDate, List<Customer> list) throws InvalidDetailsException 
	{

		checkEmail(email, list);
		ServicePlan s = validateServicePlan(plan.toUpperCase());
		double amount=checkregAmount(regamount,s);
		LocalDate date = validateDate(dob);
		validate(password);
		LocalDate date2=LocalDate.parse(subDate);
		Customer c=new Customer(first_name, last_name, email, password, date, s,amount,date2);
		return c;
	}

	private static void validate(String password) throws InvalidDetailsException
	{
		
		int counta=0,countb=0,countc=0;
		for(int i=0;i<password.length();i++)
		{
			char ch1=password.charAt(i);
			
			if(ch1>='A' && ch1<='Z' )
			{
				counta++;
			}
			
			else if(ch1>='1'&& ch1<='9')
			{
				countb++;
			}
			else if(ch1>='a' && ch1<='z' )
			{
				countc++;
			}
			
		}
		
		if(counta==0 || countb==0 || countc==0)
		{
			throw new InvalidDetailsException("You enter wrong format of mail");
		}
		
	}

	private static LocalDate validateDate(String dob) throws InvalidDetailsException 
	{
			LocalDate date = LocalDate.parse(dob);
			if (Period.between(date, LocalDate.now()).getYears() < 21) {
				throw new InvalidDetailsException("You enter invalid Date format");
			}
			return date;
	}

	private static void checkEmail(String email, List<Customer> list) throws InvalidDetailsException 
	{
		Customer c = new Customer(email);
		if (list.contains(c)) 
		{
			throw new InvalidDetailsException("You enter duplicate email ID");
		}

	}
//Here we always to throws IllegalArgumentException
	private static ServicePlan validateServicePlan(String plan) throws IllegalArgumentException 
	{
		return ServicePlan.valueOf(plan.toUpperCase());
	}

	public static boolean updateEmail(String password, List<Customer> list) 
	{
		Customer c = new Customer(password);
		if (list.contains(c)) {
			return true;
		}
		return false;
	}
	
	private static double checkregAmount(double amount,ServicePlan plan)throws InvalidDetailsException
	{
		if(plan.getCharges()!=amount)
		{
			throw new InvalidDetailsException("Invlaid plan amount");
		}
		else
		{
			return amount;
		}
	}
	
	public static Customer customerLogin(String email,String password,List<Customer> list) throws InvalidDetailsException
	{
		Customer c=new Customer(email);
		int index=list.indexOf(c);
		if(index==-1)
		{
			throw new InvalidDetailsException("Invalid Email"); 
		}
		Customer validCustomer = list.get(index);
		if(!validCustomer.getPassword().equals(password))
		{
			throw new InvalidDetailsException("Invalid Password");
		}
		System.out.println("Login Succefully....!");
		return validCustomer;
		
	}
	
	public static void unsubscribe(Customer c,List<Customer> list)
	{
		Iterator itr=list.iterator();
		while(itr.hasNext())
		{
			itr.next();
			itr.remove();
		}
	}
	public static Customer deleteSubscription(Customer customer)
	{
		
			if(Period.between((customer.getLastSubscriptionPaidDate()) ,LocalDate.now()).getMonths()>3)
			{
				return customer;
			}
		return null;
	}

}

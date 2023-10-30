package vehicle;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import vehicleException.DuplicateCustomerIdException;
import vehicleException.InvalidDOBException;
import vehicleException.InvalidEmailException;
import vehicleException.InvalidPasswordException;
import vehicleException.WrongPasswordException;

public class Customer 
{
	private int customer_id;
	private String first_name;
	private String last_name ;
	private String email;
	private String password;
	@SuppressWarnings("unused")
	private static SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
	private double registrationAmount;
	private LocalDate dob;       //(LocalDate)
	private static LocalDate dor=LocalDate.now();
	private static int idGen;
	private ServicePlan s;
	Scanner sc = new Scanner(System.in);
	static 
	{
		idGen=0;
	}
	@SuppressWarnings("static-access")
	public Customer( String first_name, String last_name, String email, String password, String dob,Customer[] c) throws ParseException,InvalidEmailException, DateTimeParseException,InvalidDOBException, DuplicateCustomerIdException
	{

		super();
		this.customer_id = ++idGen;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = validMail(email,c);
		this.password = password; 
		this.dob=validDob(LocalDate.parse(dob,DateTimeFormatter.ofPattern("dd-MM-yyyy")));
//		try
//		{
//			this.dob=validDob(LocalDate.parse(dob,DateTimeFormatter.ofPattern("dd-MM-yyyy")));
//		}
//		catch(DateTimeParseException p)
//		{
//			throw new InvalidDOBException("You enter a wrong Date format !!!");
//		}
		this.dor=LocalDate.now();
		System.out.println();
		
		
	}
	public Customer(String email) {
		// TODO Auto-generated constructor stub
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email,Customer[] c) throws InvalidEmailException, DuplicateCustomerIdException  
	{
		this.email = validMail(email,c);
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(String dob) throws InvalidDOBException
	{
		this.dob = validDob(LocalDate.parse(dob));
	}
	private String getPassword() 
	{
		return password;
	}
	public void setPassword(String pass)  throws WrongPasswordException
	{
		System.out.println("Enter old pass :");
		String s=sc.next();
		if(this.getPassword().equals(s))
		{
			this.password=pass;
			System.out.println("Your password change successfully....!!!!");
		}
		else
		{
		   throw new WrongPasswordException("You enter a wrong password..." );	
		}

	}
	@Override
	public String toString() {
		return "Customer Details :\n---------------------------- \ncustomer_id=" + customer_id 
				+ "\nfirst_name=" + first_name + "\nlast_name=" + last_name
				+ "\nemail=" + email + "\nregistrationAmount=" 
				+ registrationAmount + "\ndob=" + dob+"\n-----------------------------" ;
	}
	
	private static LocalDate validDob(LocalDate date) throws InvalidDOBException,DateTimeParseException
	{
	
			if(date.isBefore(dor) && (dor.getYear()-date.getYear())==18)
			{
				throw new InvalidDOBException("You enter Invlid date oF birth");
			}
			else 
			{
				return date;
			}
			
	}
	private static String validMail(String mail,Customer[]  c) throws InvalidEmailException, DuplicateCustomerIdException
	{
//		mail=check_Duplicate(mail);
		if(mail.contains("@") && mail.contains(".com") )
		{
			Customer email=new Customer(mail);
			for (Customer v : c)
			{
				if (v != null)
				{
					if (v.equals(mail))
					{
						throw new DuplicateCustomerIdException("Duplicate Email ID !!!!!!!!!!!");
					}
				}		
			}
			return mail;
		}
		else
		{
			throw new InvalidEmailException("You enter wrong format Email");	
		}

	}
	@SuppressWarnings("unused")
	private static String validPassword(String password) throws InvalidPasswordException
	{
		String str="^(?=.*[!@#$%^&*])[a-z0-9!@#$%^&*]+$";
		Pattern pattern=Pattern.compile(str);
//		Matcher matcher = pattern.matcher(password);
		
		if(password.length()>=8 && password.length()<=15 && password.matches(str) && !password.matches(".*[A-Z].*"))
		{
			return password;
		}
		else
		{
			throw new InvalidPasswordException("Invalid Password Format") ;
			
		}
	}
	public double planCharge(String plan)
	{
		s=ServicePlan.valueOf(plan.toUpperCase());
		this.registrationAmount=s.getCharges();
		return this.registrationAmount;
	}
	@Override
	public boolean equals(Object o) 
	{
		if (o instanceof Customer)
		{
			return this.email.equals(((Customer)o).email);
		}
		return false;
	}
	private static String check_Duplicate(String email,Customer[] c) throws DuplicateCustomerIdException
	{
		Customer mail=new Customer(email);
		for (Customer v : c)
		{
			if (v != null)
			{
				if (v.equals(mail))
				{
					throw new DuplicateCustomerIdException("Duplicate Email ID !!!!!!!!!!!");
				}
			}		
		}
		return email;
	
	}
}

package Customer_Details;

import java.time.LocalDate;
import java.util.List;

import utils.ServicePlan;

public class Customer implements Comparable<Customer>
{
	private int customer_id;
	private static int genid=1;
	private String first_name;
	private String last_name ;
	private String email;
	private String password;
	private LocalDate dob;
	private double regamount;
	private ServicePlan plan;
	private static int idgen;
	private LocalDate lastSubscriptionPaidDate;
	
	public Customer( String first_name, String last_name, String email, String password, LocalDate dob, ServicePlan plan,double regamount,LocalDate subDate) {
		super();
		this.customer_id = genid++;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.regamount = regamount;
		this.plan = plan;
		this.lastSubscriptionPaidDate=subDate;
	}
	
	public Customer(String email) {
		super();
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	public int getCustomer_id()
{
		return customer_id;
	}
	//	public void setEmail(String email) {
//		this.email = email;
//	}
	public LocalDate getDob() {
		return dob;
	}
	public String getFirst_name() 
	{
		return first_name;
	}
	public void setFirst_name(String first_name)
	{
		this.first_name = first_name;
	}
	//	public void setDob(LocalDate dob) {
//		this.dob = dob;
//	}
//	public ServicePlan getPlan() {
//		return plan;
//	}
//	public void setPlan(ServicePlan plan) {
//		this.plan = plan;
//	}
	public String getPassword() {
		return password;
	}
	public void setPassword() {
		this.password=password;
	}
	static
	{
		idgen=1;
	}
	
	
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", dob=" + dob + ", regamount=" + regamount + ", plan=" + plan
				+ ", lastSubscriptionPaidDate=" + lastSubscriptionPaidDate + "]";
	}

	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Customer)
			return this.email.equals(((Customer)o).email);
		return false;
	}
	public static boolean get(int index) {
		
		return false;
	}
	@Override
	public int compareTo(Customer cust)
	{
		return this.email.compareTo(cust.email);
	}

	public LocalDate getLastSubscriptionPaidDate() {
		return lastSubscriptionPaidDate;
	}

	public void setLastSubscriptionPaidDate(LocalDate lastSubscriptionPaidDate) {
		this.lastSubscriptionPaidDate = lastSubscriptionPaidDate;
	}
	
}




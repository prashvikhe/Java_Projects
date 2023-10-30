package Bank_Account;

import java.time.LocalDate;


import Bank_AccountException.BankDetailsException;


public class Bank_Account 
{


	private int acctNo;
	private String customerName;
	private AccountType type;
	private double balance;
	private LocalDate createdOn;
	private LocalDate lastUpdated;
	public AccountType getType() {
		return type;
	}

	public boolean isActive;
	
	@Override
	public String toString() 
	{
		return "Bank_Account [acctNo=" + acctNo + ", customerName=" + customerName + ", type=" + type + ", balance="
				+ balance + ", createdOn=" + createdOn + ", lastUpdated=" + lastUpdated + ", isActive=" + isActive
				+ "]";
	}
	
	
	public Bank_Account(int acctNo, String customerName, AccountType type, double balance, LocalDate createdOn)
	{
		super();
		this.acctNo = acctNo;
		this.customerName = customerName;
		this.type = type;
		this.balance = balance;
		this.createdOn = createdOn;
		this.lastUpdated = LocalDate.now();
		this.isActive = true;
	}
	
	public void withdraw(double amount)throws BankDetailsException
	{
		if(isActive)
		{
			this.balance-=amount;
			lastUpdated=LocalDate.now();
		}
		else
		{
			throw new BankDetailsException("Your account is not active ...!");
		}
	}
	
	public int getAcctNo() 
	{
		return acctNo;
	}


	public void deposit(double amount)throws BankDetailsException
	{
		if(isActive)
		{
			this.balance+=amount;
			lastUpdated=LocalDate.now();
		}
		else
		{
			throw new BankDetailsException("Your account is not active ...!");
		}
	}

	public LocalDate getCreatedOn() 
	{
		return createdOn;
	}


	public void transferFunds(Bank_Account dest, double amount) throws BankDetailsException 
	{
		// check if accts are active!
		if (this.isActive && dest.isActive) 
		{
			this.withdraw(amount);
			dest.deposit(amount);
		}
		else
			throw new BankDetailsException("Inactive A/C/s !!!!!!");
		
	}
	
	public boolean isActive() 
	{
		return isActive;
	}


	public void setActive(boolean isActive) 
	{
		this.isActive = isActive;
	}

	public double getBalance()
	{
		return balance;
	}
	
	
}

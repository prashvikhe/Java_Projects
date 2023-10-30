package Bank_AccountVAlidation;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

import Bank_Account.AccountType;
import Bank_Account.Bank_Account;
import Bank_AccountException.BankDetailsException;

public class BankDetailsValidation
{
	private static final int minBalance;
	private static final double rate;
	
	static
	{
		minBalance=5000;
		rate=0.75;
	}
	

	public static Bank_Account validateAllInputs(int acctNo, String customerName, String type, double balance, 
			String createdOn,Map<Integer,Bank_Account> bank) throws BankDetailsException
	{
		checkAccNumber(acctNo,bank);
		minBalance(balance);
		AccountType acctype= checkAccountType(type);
		LocalDate date=LocalDate.parse(createdOn);
		return new Bank_Account(acctNo, customerName, acctype, balance, date);
	}

	public static AccountType checkAccountType(String type)
	{
		AccountType account=AccountType.valueOf(type.toUpperCase());
		return account;		
	}

	public static void checkAccNumber(int acctNo, Map<Integer, Bank_Account> bank) throws BankDetailsException
	{
		if(bank.containsKey(acctNo))
		{
			throw new BankDetailsException("Account number is already present ....!");
		}
	}
	
	private static void minBalance(double balance)throws BankDetailsException
	{
		if(balance<minBalance)
		{
			throw new BankDetailsException("Balance is low");
		}
	}
	
	public static double simpleIntrest(Bank_Account account)
	{
		double simpleIntrest=0;
		System.out.println(account.getBalance());
		double month=Period.between(account.getCreatedOn(),LocalDate.now()).getMonths();
		month/=12;
		simpleIntrest=(account.getBalance()*rate* month)/100;
		return simpleIntrest;
	}

}

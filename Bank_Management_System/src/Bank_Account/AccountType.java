package Bank_Account;

public enum AccountType 
{
	SAVING(2000),DMAT(1500),LOAN(0),FD(500),CURRENT(1000);
	private double amount;
	private AccountType(double amount)
	{
		this.amount=amount;
	}
}

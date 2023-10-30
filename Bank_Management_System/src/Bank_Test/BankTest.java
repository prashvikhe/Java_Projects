package Bank_Test;

import java.util.HashMap;
import java.util.Scanner;

import static Bank_AccountVAlidation.BankUtils.*;
import static Bank_AccountVAlidation.BankDetailsValidation.*;

import Bank_Account.AccountType;
import Bank_Account.Bank_Account;
import Bank_AccountException.BankDetailsException;
import Bank_AccountVAlidation.BankDetailsValidation;

@SuppressWarnings("unused")
public class BankTest 
{
	public static void main(String[] args) throws BankDetailsException 
	{
		try(Scanner sc=new Scanner(System.in))
		{
			HashMap<Integer,Bank_Account> map=new HashMap<Integer, Bank_Account>();
			map.putAll(populateMap());
			System.out.println("1. Create A/C");
			System.out.println("2.Display all accounts");
			System.out.println("3. Transfer Funds");
			System.out.println("4.Close A/c");
			System.out.println("5.Fetch A/c Summary");
			System.out.println("6.Freeze A/cs");
			System.out.println("7.Transfer amount to inActive account : ");
			System.out.println("8.Simple Intrest .");
			System.out.println("0.exit");
			boolean exit=false;
			try 
			{
				while(!exit)
				{
					System.out.println("Enter your choice: ");
					switch(sc.nextInt())
					{
					case 1:
						System.out.println("Enter acct details :  acctNo,  customerName,  type,  balance,  createdOn(yr-mon-day)");
						Bank_Account account = validateAllInputs(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(),sc.next(),map);
						map.put(account.getAcctNo(), account);
						break;
					case 2:
						for(Bank_Account details:map.values())
						{
							System.out.println(details);
						}
						break;
					case 3:
						System.out.println("Enter source account number and amount");
						int SAccNum=sc.nextInt();
						double amount=sc.nextDouble();
						Bank_Account Sacc=map.get(SAccNum);
						if(Sacc==null)
						{
							throw new BankDetailsException("Invalid source account number  !!!!");
						}
						System.out.println("Enter destination account number ");
						int DsAccNum=sc.nextInt();
						Bank_Account Dacc=map.get(DsAccNum);
						if(Dacc==null)
						{
							throw new BankDetailsException("Invalid destination account number  !!!!");
						}
						Sacc.transferFunds(Dacc,sc.nextDouble());
						
						break;
					case 4:
						System.out.println("Enter account number and amount");
						Bank_Account rem=map.remove(sc.nextInt());
						if (rem == null)
						{
							throw new BankDetailsException("Invalid  acct no, Can't close A/c !!!!!!");
						}
						else
						{
							System.out.println("Account closed Successfully !!!!!");
						}
						break;
					case 5:
						System.out.println("Enter account number and amount");
						Bank_Account accountDetails=map.get(sc.nextInt());
						if(accountDetails!=null)
						{
							System.out.println(accountDetails);
						}
						else
						{
							System.out.println("Account closed Successfully !!!!!");
						}
						
						break;
					case 6:
						System.out.println("Enter acount number :");
						if(map.containsKey(sc.nextInt()))
						{
							account=map.get(sc.nextInt());
							if(account.isActive())
							{
								account.setActive(false);
							}
						}
						else
						{
							throw new BankDetailsException("Invalid Account Number");
						}
						System.out.println("Your account is freezed !!!!");

						break;
					case 7:
						System.out.println("Enter a source account number :");
						account=map.get(sc.nextInt());
						if(account.isActive())
						{
							System.out.println("Enter destination account number and amount :");
							Bank_Account acc=map.get(sc.nextInt());
							if(acc.isActive() && account!=null)
							{
								account.transferFunds(acc,sc.nextDouble() );
								System.out.println("Your money tranfer succefully !!!!");
							}
							else
							{
								System.out.println("Amount refund to your to account !!!");
								throw new BankDetailsException("Your account is not active  !!!");
							}
						}
						else
						{
							throw new BankDetailsException("Invalid source accouont number !!!");
						}
						
						break;
					case 8:
						System.out.println("Enter your account number :");
						double intrest=0;
						account=map.get(sc.nextInt());
						if(account!=null && account.getType()==AccountType.SAVING)
						{
							
							intrest=simpleIntrest(account);
						}
						else
						{
							throw new BankDetailsException("Invalid account number !!!");						
						}
						System.out.println("Simple intrest is : "+intrest);
						break;
					case 0:
						exit=true;
						break;
					}
				}
				
			}
			catch(Exception e)
			{
				System.err.println(e.getMessage());
			}
			
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		
	}

}

package Bank_AccountVAlidation;

import static Bank_AccountVAlidation.BankDetailsValidation.*;
import java.util.HashMap;
import java.util.Map;
import Bank_Account.Bank_Account;
import Bank_AccountException.BankDetailsException;


public class BankUtils 
{
	public static Map<Integer, Bank_Account> populateMap() throws BankDetailsException
	{
		//create empty map
		Map<Integer, Bank_Account> map=new HashMap<>();
		map.put(50, validateAllInputs(50,"Saurabh Nikam","saving",12000,"2023-01-01", map));
		map.put(70, validateAllInputs(70,"Aniket Ghadage","current",8000,"2023-02-11",map));
		map.put(60, validateAllInputs(60,"Mohit Lokhande","saving",14000,"2023-05-21",map));
		map.put(90, validateAllInputs(90,"Prajyot Pawar","fd",120000,"2022-11-01",map));
		map.put(80, validateAllInputs(80,"Rohit Reddy","saving",111000,"2022-12-11",map));
		map.put(20, validateAllInputs(20,"Prashant Vikhe","saving",18000,"2023-05-01",map));
		map.put(10, validateAllInputs(10,"Pravin Nirmal","FD",80000,"2023-12-11",map));
		return map;
	}

}

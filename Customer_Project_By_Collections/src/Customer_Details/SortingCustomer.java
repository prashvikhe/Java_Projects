package Customer_Details;

import java.util.Comparator;

public class SortingCustomer implements Comparator<Customer>
{
	@Override
	public int compare(Customer o1, Customer o2) 
	{
		int ret=o1.getDob().compareTo(o2.getDob());
		if(ret==0)
		{
			return 0;
		}
		if(ret<0)
		{
			return -1;
		}
		return ret;
	}

}

package IO_Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import Employee.Employee;

public interface FilingData 
{
	static void storeData(String file,Map<String,Employee> map) throws IOException
	{
		try(ObjectOutputStream data=new ObjectOutputStream(new FileOutputStream(file,true)))
		{
			data.writeObject(map);
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	static Map<String,Employee> restoreData(String file) throws IOException, ClassNotFoundException
	{
		try(ObjectInputStream data=new ObjectInputStream(new FileInputStream(file)))
		{
			return (Map<String,Employee>)data.readObject();
		}
	}
}

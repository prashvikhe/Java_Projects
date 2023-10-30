package PupulatedClass;

import static utils.Customer_Validation.validateDetails;

import java.util.ArrayList;
import java.util.List;

import Customer_Details.Customer;
import Exceptions.InvalidDetailsException;

public class Populated_Class 
{
	public static List<Customer> customerDetails() throws InvalidDetailsException
	{
		ArrayList<Customer> data=new ArrayList<>();
		data.add(validateDetails("aaaaa","zzzzz","aazz@111.com","aaZZ@111","2000-08-20" ,1000,"SILVER","2022-11-02",data));
		data.add(validateDetails("ccccc","yyyyy","bbyy@111.com","bbYY@111","2000-09-29" ,2000,"GOLD","2023-03-28",data));
		data.add(validateDetails("bbbbb","xxxxx","ccxx@111.com","ccXX@111","2000-10-26" ,5000,"DIAMOND","2023-05-01",data));
		data.add(validateDetails("eeeee","wwwww","ddww@111.com","ddWW@111","2000-12-28" ,1000,"SILVER","2022-08-23",data));
		data.add(validateDetails("ddddd","uuuuu","eeuu@111.com","eeUU@111","2000-11-20" ,10000,"PLATINUM","2022-12-18",data));
		return data;
	}
	

}

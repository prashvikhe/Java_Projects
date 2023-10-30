package Generics;

import java.util.HashSet;

import HashSetPractice.LocalData;

public class GenericsPractice 
{
	public static void main(String[] args) 
	{
//		List<Integer> intList=Arrays.asList(10,20,30,40,50);
//		ArrayList<Bank_Account> mgrs = new ArrayList<>(Arrays.asList(new Bank_Account(50,"Saurabh Nikam","saving",12000,"2023-01-01"), new Bank_Account(70,"Aniket Ghadage","current",8000,"2023-02-11"), new Bank_Account(60,"Mohit Lokhande","saving",14000,"2023-05-21")));
//		mgrs.forEach(p ->System.out.println(p));
//		Bank_Account.printElementsInmap(mgrs);
//		
//		ArrayList<LocalData> list=new ArrayList<LocalData>();
//		list.add(new LocalData("Saurabh",1,"Nikam",1000,20));
//		list.add(new LocalData("Aniket",2,"Ghadage",600,50));
//		list.add(new LocalData("Rohit",5,"Reddy",900,90));
//		list.add(new LocalData("Rohit",5,"Reddy",900,90));

//		System.out.println(list);
//		list.forEach(p->System.out.println(p));
		
//		LinkedList<LocalData> list2=new LinkedList<LocalData>();
//		list2.add(new LocalData("Prashant",5,"Vikhe",500,10));
//		list2.add(new LocalData("Pravin",2,"Nirmal",400,50));
//		list2.add(new LocalData("Sushant",8,"Bhor",300,90));
	
//		employeeSal(list2);
//		list2.forEach(p ->System.out.println(p));
//		printElementsInmap2(list2);
		
		HashSet<LocalData> list=new HashSet<LocalData>();
		list.add(new LocalData("Saurabh",1,"Nikam",1000,20));
		list.add(new LocalData("Aniket",2,"Ghadage",600,50));
		list.add(new LocalData("Rohit",5,"Reddy",900,90));
		list.add(new LocalData("Rohit",4,"Reddy",900,90));
		
		list.forEach(p -> System.out.println(p));
		
		
	
	}

	


}

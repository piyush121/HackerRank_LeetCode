package hackerRank;

import java.util.ArrayList;
import java.util.HashMap;

public class CompanyHeirarchy {
	
	static HashMap<String, String> employees=new HashMap<>();
	
	public static void dispHeirarchy(String[] Employee,String[] Managers)
	{		
		for(int i=0;i<Employee.length;i++)
		{
			employees.put(Employee[i], Managers[i]);
		}
		
		for(String emp : employees.keySet())
		{
			print (emp);
		}
	}
	public static void print(String emp)
	{
		if(employees.containsKey(emp))
			{
				System.out.println(emp);
				print(employees.get(emp));
			}
	}

}

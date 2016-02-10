package hackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CompanyHeirarchy {
	
	static HashMap<String, String> employees=new HashMap<>();
	static HashSet<String> hash=new HashSet<>();
	
	public static void dispHeirarchy(String[] Employee,String[] Managers)
	{		
		for(int i=0;i<Employee.length;i++)
		{
			employees.put(Employee[i], Managers[i]);
		}
		
		for(String emp : employees.keySet())
		{	if(!hash.contains(emp))
			print (emp);
		}
	}
	public static void print(String emp)
	{
		if(employees.containsKey(emp))
			{
				System.out.println("Employee:"+emp+" Manager: "+employees.get(emp));
				hash.add(emp);
				print(employees.get(emp));
			}
	}
public static void main(String[] args) {
	String[] A={"A","B","C","D"};
	String[] B={"B","F","D","E"};
	dispHeirarchy(A, B);
	
}
}

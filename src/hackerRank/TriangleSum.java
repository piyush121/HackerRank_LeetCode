package hackerRank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public  class TriangleSum {
    public static int minimumTotal(List<List<Integer>> triangle) {
    	
 int sum=0;
 int temp=Integer.MAX_VALUE;
 for(int i=0;i<triangle.size();i++)
 {
	 for(int j=0;j<triangle.get(i).size();j++)
 
		 if(triangle.get(i).get(j)<temp)
			 temp=triangle.get(i).get(j);
	sum+=temp;
	temp=Integer.MAX_VALUE;
 }
    	return sum;

    }
    
    public static void main(String[] args) {
    	
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	
    	list.add(new ArrayList<>());
    	list.add(new ArrayList<>());
    	list.add(new ArrayList<>());
    	list.get(0).add(-1);
    	list.get(1).add(2);list.get(1).add(3);
    	list.get(2).add(1);list.get(2).add(-1);list.get(2).add(-3);
    	
    	
		System.out.println(minimumTotal(list));
	}
}

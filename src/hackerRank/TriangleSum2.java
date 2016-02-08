package hackerRank;

import java.util.ArrayList;
import java.util.List;

public  class TriangleSum2 {
    public static int minimumTotal(List<List<Integer>> triangle) {
    	
    	int[] total = new int[triangle.size()];
    	int l = triangle.size() - 1;
     
    	for (int i = 0; i < triangle.get(l).size(); i++) {
    		total[i] = triangle.get(l).get(i);
    	}
     
    	// iterate from last second row
    	for (int i = triangle.size() - 2; i >= 0; i--) {
    		for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
    			total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
    		}
    	}
     
    	return total[0];
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

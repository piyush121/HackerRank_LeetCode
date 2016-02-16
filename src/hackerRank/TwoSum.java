package hackerRank;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;

public class TwoSum {
	static HashMap<Integer,Integer> hash=new HashMap<>();
	
	public static ArrayList<Pair<Integer,Integer>> twoSum(int[] A,int target)
	{	
		ArrayList<Pair<Integer,Integer>> pairs=new ArrayList<>();
		for(int i=0;i<A.length;i++)
		{
			if(hash.containsKey(target - A[i]) && hash.get(target - A[i])!=0)
					{
						pairs.add(new Pair<>(A[i],target - A[i]));
						hash.put(A[i],0);

					}
			else
				hash.put(A[i],1);
				
		}
		
		return pairs;
	}
	
	public static void main(String[] args) {
		int[] arr={4,4,4,4};
		System.out.println(twoSum(arr, 8));
	}

}

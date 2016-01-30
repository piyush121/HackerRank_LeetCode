package hackerRank;

import java.util.LinkedList;
import java.util.List;

public class rotation {
	
	List<Integer> mylist=new LinkedList<>();
	
	public static void find(int[] arr,int K,int idx)
	{
		int rot=K%arr.length;
		
		if(idx-rot>=0)
			System.out.println(arr[idx-rot]);
		else
			System.out.println(arr[idx-rot+arr.length]);

	}
	
public static void main(String[] args) {
	int[] A={3,1,1};
	find(A,1,1);
	
	
}
	
}

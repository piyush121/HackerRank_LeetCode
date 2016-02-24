package hackerRank;

import java.util.HashMap;
import java.util.Map.Entry;

public class OddFrequency {

	public static void printOdd(int[] A) {
		HashMap<Integer, Boolean> dataFreq = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			
			if(!dataFreq.containsKey(A[i]))
				dataFreq.put(A[i], true);
			else
				dataFreq.put(A[i], !dataFreq.get(A[i]));
			
		}
		
		for(Entry<Integer, Boolean> entr: dataFreq.entrySet())
		{
			if(entr.getValue())
				System.out.println(entr.getKey());
		}
	}
	
	public static void main(String[] args) {
		printOdd(new int[]{1,1,1,4,6,5,3,8,9,7,7,8,9});
	}
}

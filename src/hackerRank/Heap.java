package hackerRank;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heap {
	static PriorityQueue<Integer> queue=new PriorityQueue<>(20,Collections.reverseOrder());
	public static void topThree(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			queue.add(arr[i]);
		}
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
	}
	public static void main(String[] args) {
		int[] arr={5,3,7,4,8,1,9,2};
		topThree(arr);
	}
	
}

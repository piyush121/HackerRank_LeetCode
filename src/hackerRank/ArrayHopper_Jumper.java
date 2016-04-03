package hackerRank;

import java.util.Arrays;

public class ArrayHopper_Jumper {
	public static int jumper(int[] nums, int index, int hops) { //Inefficient Recursive solution.
		
		if(nums[index] + index >= nums.length) // Base case
			return hops + 1;
		int minHops = Integer.MAX_VALUE;
		int limit = nums[index];
		for(int i = index + 1; i <= index + limit; i++ ) {
			int temp = jumper(nums, i,  hops + 1);
			if(temp != -1)
				minHops = Math.min(minHops, temp);
			
		}
		
		return minHops == Integer.MAX_VALUE ? -1 : minHops;
	}
	
	public static int jumperDP(int[] nums) {
		int len = nums.length;
		int[] hops = new int[len];
		Arrays.fill(hops, Integer.MAX_VALUE);
		hops[len - 1] = 0;
		for(int i = len - 2; i >=0; i-- ) {
			if(nums[i] + i >= len)
				hops[i] = 1;
			else if(nums[i] == 0)
				hops[i] = -1;
			else
			{	
				int loc = 1;
				while(loc <= nums[i]) {
					if(hops[i + loc] != -1 && hops[i + loc] + 1 < hops[i]) {
						hops[i] = hops[i + loc] + 1;
					}
					loc++;
				}
			}		
		}
		System.out.println(Arrays.toString(hops));
		return hops[0];
	}
	
	public static void main(String[] args) {
		int[] arr = {1,1, 1,2,1,1};
		System.out.println(jumper(arr,0 , 0));
		System.out.println(jumperDP(arr));
	}

}

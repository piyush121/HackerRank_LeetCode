package hackerRank;

public class ArrayHopper_Jumper {
	public static int jumper(int[] nums, int index, int hops) { //Inefficient Recursive solution.
		
		if(nums[index] + index >= nums.length) // Base case
			return hops + 1;
		int minHops = Integer.MAX_VALUE;
		int limit = nums[index];
		for(int i = index + 1; i <= limit; i++ ) {
			int temp = jumper(nums, i,  hops + 1);
			if(temp != -1)
				minHops = Math.min(minHops, temp);
		}
		
		return minHops == Integer.MAX_VALUE ? -1 : minHops;
	}
	
	public static int jumperDP(int[] nums) {
		
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(jumper(arr,0 , 0));
	}

}

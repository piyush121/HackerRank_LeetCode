package hackerRank;

import java.util.Arrays;

public class Nextpermutation {
	
public static void nextPermutation(int[] nums) {
	int len = nums.length;
	int i = len;
     for(i = len - 1; i >= 0; i--) {
    	 if(i != 0 && nums[i] > nums[i-1]) //O(n)
    		 break;
     }
     if( i == -1 && len > 1 ) {
    	 Arrays.sort(nums); //O(nlogn)
    	 System.out.println(Arrays.toString(nums));
     }
     else {
    	 while (i != len && len > 1 ) {
    		 if(nums[i - 1] < nums[i]) {
	    		 int temp = nums[i - 1];
	    		 nums[i-1] = nums[i]; //O(n)
	    		 nums[i] = temp;
	    		 i++;
    		 }
    	 }
    	 System.out.println(Arrays.toString(nums));
     }
    	 
    }
public static void main(String[] args) {
	nextPermutation(new int[]{2,3,1});
}

}

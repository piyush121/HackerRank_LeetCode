package hackerRank;

public class RemoveDuplicateElementsInPlace {

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int count = 1;
		int j = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				count++;
				nums[j++] = nums[i];
			}
		}
		return count;
	}
	
	 public int removeDuplicates1(int[] nums) { // Efficient by a constant factor.
	        if(nums.length==0)
	            return 0;
	        int j=1;
	        for(int i=1;i<nums.length;i++) {
	            if(nums[i]!=nums[i-1])
	                nums[j++]=nums[i];
	        }
	        return j;
	    }

}

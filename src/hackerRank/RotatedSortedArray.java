package hackerRank;

public class RotatedSortedArray {
	 public static int search(int[] nums, int target) { //O(log n). But not very efficient due to large overhead.
	        int start = 0;
	        int end = nums.length - 1;
	        int mid;
	        while(start <= end) {
	        	mid = (start + end) / 2;
	        	int first = nums[start];
	        	int last = nums[end];
	        	int middle = nums[mid];
	        	if(middle == target)
	        		return mid;
	        	if(target < middle) {
	        		if(middle > first && first <= target || middle < first) // look at 1st element to check the rotation point.
	        			end = mid - 1;
	        		else
	        			start = mid + 1;
	        	}
	        	else {
	        		if(middle < last && target <= last || middle > last)
	        			start = mid + 1;
	        		else
	        			end = end - 1;
	        	}
	        }
	        return -1;
	    }
	 
	 public static int search1(int[] nums,int target) { //Concise log n solution.
		
		 int start = 0;
		 int len = nums.length;
		 int end = len - 1;
		 int mid;
		 while(start < end) { // calculate rotated point. when start == end. we will find that point
			 mid = (start + end)/2;
			 if(nums[mid] < nums[end])
				 end = mid;
			 else
				 start = mid + 1;
		 }
		 
		 int minIndex = target <= nums[len - 1] ? start : 0;
		 int maxIndex = target <= nums[len - 1] ? len - 1 : start;
		 
		 while(minIndex <= maxIndex) { //usual binary search.
			 int midd = (minIndex + maxIndex) / 2;
			 if(target == nums[midd])
				 return midd; 
			 if(target < nums[midd])
				 maxIndex = midd - 1;
			 else
				 minIndex = midd + 1;
		 }
		 	 
		 return -1;
		 
	 }
	 
	 public static void main(String[] args) {
		System.out.println(search1(new int[]{5,1,3},1));
	}

}

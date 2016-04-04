package hackerRank;

public class RangeSearch {
	 public int[] searchRange(int[] nums, int target) { //O(log n) solution.
		 
		 int index = binarySearch(nums, target, 0, nums.length - 1);
		 int lower = lhBound(nums, target, 0, index - 1, index); //Find lower index
		 int higher = lhBound(nums, target, index + 1,  nums.length - 1, index); // find upper indexx
		 
		 return new int[]{lower,higher};
	        
	    }
	private int binarySearch(int[] arr,int val, int start, int end) {
		if(start < end)
			return -1;
		int mid = (start + end)/2;
		if(arr[mid] == val)
			return mid;
		else if(arr[mid] < val)
			return binarySearch(arr, val, mid + 1, end);
		else
			return binarySearch(arr, val, start, mid - 1);
		
	}
	
	private static int lhBound(int[] arr, int val, int start, int end, int index) {
		if(start < end)
			return index;
		int mid = (start + end)/2;
		if(arr[mid] == val)
			return lhBound(arr, val, start, mid - 1, mid);
		else
			return lhBound(arr, val, mid + 1, end, index);
	}

}

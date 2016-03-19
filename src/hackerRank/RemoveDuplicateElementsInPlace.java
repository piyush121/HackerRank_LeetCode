package hackerRank;

public class RemoveDuplicateElementsInPlace {

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int count = 1;
		int j = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				count++;
				j++;
				nums[j] = nums[i];
			}
		}
		return count;
	}

}

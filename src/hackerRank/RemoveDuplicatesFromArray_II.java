/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new
 * length.
 *
 */
public class RemoveDuplicatesFromArray_II {

	public static int removeDuplicates(int[] nums) {
		int count = 1;
		int temp = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1])
				count++;
			if (count > 2) {
				while (i < nums.length && nums[i] == nums[i - 1]) {
					temp++;
					i++;
				}
			}
			count = 1;
		}
		return nums.length - temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicates(new int[] { 1, 1, 1 }));
	}

}

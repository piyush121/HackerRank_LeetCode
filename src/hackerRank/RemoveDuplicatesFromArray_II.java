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

	public static int removeDuplicates(int[] nums) { // Best solution.
		int count = 1;
		int index = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1])
				count++;
			else
				count = 1;
			if (count <= 2) {
				nums[index++] = nums[i]; //Key idea here.
			}

		}
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicates(new int[] { 1, 1, 1, 2 }));
	}

}

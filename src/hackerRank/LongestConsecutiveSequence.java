/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], 
 * The longest consecutive elements
 * sequence is [1, 2, 3, 4]. 
 * Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 *
 * 
 * 
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums.length == 0)
			return 0;
		int max = 0;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++)
			set.add(nums[i]);
		for (int i = 0; i < nums.length; i++) {
			int count = 1;
			int val = nums[i];
			set.remove(val);
			//search left
			while (set.contains(++val)) {
				count++;
				set.remove(val);
			}
			//search right
			val = nums[i];
			while (set.contains(--val)) {
				count++;
				set.remove(val);
			}

			if (count > max)
				max = count;
		}
		return max;
	}
	
	public int longestConsecutive1(int[] nums) { // O(n) solution but number of operations can be reduced further.
		if(nums.length == 0)
			return 0;
		HashMap<Integer, Boolean> map = new HashMap<>();
		int max = 0;
		int count = 0;
		for(int i =0; i< nums.length ; i++)
			map.put(nums[i], false);
		
		for(int i =0; i< nums.length ; i++) {
			count = 0;
			if(map.containsKey(nums[i]) && !map.get(nums[i])) {
				int temp = nums[i];
				while(map.containsKey(temp)) {
					map.put(temp, true);
					count++;
					temp++;

				}
				temp = nums[i] - 1;
				while(map.containsKey(temp)) {
					map.put(temp, true);
					count++;
					temp--;

				}
			}
			
			if(count > max)
				max = count;
		}
		return max;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

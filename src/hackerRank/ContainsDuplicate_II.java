package hackerRank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Given an array of integers and an integer k, find out whether there are two distinct indices
 * i and j in the array such that nums[i] = nums[j] and the difference between i and j is 
 * at most k.
 */
public class ContainsDuplicate_II {
	public boolean containsNearbyDuplicate(int[] nums, int k) { // Even more
																// efficient
																// sliding
																// window bassed
																// solution.
		Set<Integer> seen = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (i > k) 
				seen.remove(nums[i - k - 1]);
			
			if (seen.contains(nums[i]))
				return true;
			else
				seen.add(nums[i]);
			}
		
		return false;
	
	}

	public boolean containsNearbyDuplicate1(int[] nums, int k) { // Easy one !.
		Map<Integer, Integer> seen = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (!seen.containsKey(nums[i]))
				seen.put(nums[i], i);
			else {
				if (i - seen.get(nums[i]) <= k)
					return true;
				else
					seen.put(nums[i], i);
			}
		}
		return false;
	}
}

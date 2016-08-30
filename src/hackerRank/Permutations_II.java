/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 *
 */
public class Permutations_II {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Integer[] nums1 = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++)
            nums1[i] = Integer.valueOf(nums[i]);
        permute(nums1, 0, res);
        return res;
    }
    
    private void permute(Integer[] nums, int start, List<List<Integer>> res) {
        if(start == nums.length) {
            res.add(new ArrayList<>(Arrays.asList(nums)));
        }
        Set<Integer> seen = new HashSet<>();
        for(int i = start ; i < nums.length; i++) {
            if(seen.add(nums[i])) {
                swap(nums,start, i);
                permute(nums, start + 1, res);
                swap(nums, start, i);
            }
        }
    }
    
    private void swap(Integer[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

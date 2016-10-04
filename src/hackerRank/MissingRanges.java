/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its 
 * missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 *
 */
public class MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> res = new ArrayList<>();
        
        for(int i = 0 ; i < nums.length; i++) {
        	if(nums[i] > lower) {
        		if(lower == nums[i] - 1)
        			res.add(""+lower);
        		else
        			res.add(lower + "->" + (nums[i] - 1));
        	}
        	lower = nums[i] + 1; // key part here. Keep increasing the lower until you hit the spot.
        }
        
        if(upper >= lower) {
    		if(lower == upper)
    			res.add(""+lower);
    		else
    			res.add(lower + "->" + upper);
    	}
        return res;
    }
}

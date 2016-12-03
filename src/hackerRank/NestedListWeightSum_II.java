/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:
Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)

Example 2:
Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
 *
 */
public class NestedListWeightSum_II {
	public int depthSumInverse(List<NestedInteger> nestedList) {
		if (nestedList.size() == 0)
			return 0;
		return dfs(nestedList, 0);
	}

	public int dfs(List<NestedInteger> nestedList, int sum) {
		List<NestedInteger> list = new ArrayList<>();
		for (NestedInteger nInt : nestedList) {
			if (nInt.isInteger()) // add all nums at current level.
				sum += nInt.getInteger();
			else {
				list.addAll(nInt.getList());
			}
		}
		sum += list.size() == 0 ? 0 : dfs(list, sum); // send current sum to
														// next level so that
														// this sum gets added
														// at every level and
														// add current sum to
														// the result of the
														// next level.
		return sum;
        
    }
}

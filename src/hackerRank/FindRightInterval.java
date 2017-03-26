/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:
You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.
Example 1:
Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:
Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
Example 3:
Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
 */
public class FindRightInterval {
	public int[] findRightInterval(Interval[] intervals) { // O(nlogn) time and and O(n) space.
		int[] res = new int[intervals.length];
		Map<Integer, Integer> map = new HashMap<>();
		int j = 0;
		for (Interval interval : intervals) {
			map.put(interval.start, j++);
		}
		Arrays.sort(intervals, (a, b) -> a.start - b.start);
		for (int i = 0; i < intervals.length; i++) {
			int time = bSearch(intervals, intervals[i].end);
			res[map.get(intervals[i].start)] = time < intervals[i].end ? -1 : map.get(time);
		}
		return res;
	}

	public int bSearch(Interval[] intervals, int val) {

		int start = 0;
		int end = intervals.length - 1;
		int mid = 0;
		while (start < end) {
			mid = start + (end - start) / 2;
			if (intervals[mid].start == val)
				return intervals[mid].start;

			if (intervals[mid].start > val)
				end = mid;
			else
				start = mid + 1;
		}
		return intervals[start].start;
	}
	
	
	 public int[] findRightInterval1(Interval[] intervals) { //Another nlogn solution using TreeMap methods.
	        int[] res = new int[intervals.length];
	        TreeMap<Integer, Integer> map = new TreeMap<>();
	        int j = 0;
	        for(Interval interval : intervals) {
	            map.put(interval.start, j++);   
	        }
	        for(int i = 0 ; i < intervals.length ; i++) {
	            Integer key = map.ceilingKey(intervals[i].end);
	            res[i] = key == null ? -1 : map.get(key);
	        }
	        return res;
	    }
}

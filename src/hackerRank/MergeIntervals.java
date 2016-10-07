/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) { // pretty famous greedy solution!

		Collections.sort(intervals, new Comparator<Interval>() {

			public int compare(Interval obj1, Interval obj2) {
				return obj1.start - obj2.start;
			}
		});
		List<Interval> res = new ArrayList<>();
		if (intervals.size() == 0)
			return res;
		Interval last = intervals.get(0);

		for (Interval curr : intervals) {
			if (curr.start > last.end) {
				res.add(last);
				last = curr;
			} else {
				last.end = Math.max(curr.end, last.end);
			}
		}
		res.add(last);
		return res;
	}
}

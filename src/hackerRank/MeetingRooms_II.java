/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 *
 */
public class MeetingRooms_II {
	public int minMeetingRooms(Interval[] intervals) { // Not highly efficient but works !
		if (intervals.length == 0)
			return 0;
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		int count = 0;
		List<Interval> list = new ArrayList<>();

		for (int i = 0; i < intervals.length; i++) {
			int size = list.size();
			for (int j = 0; j <= size; j++) {
				if (j != size && list.get(j).end < intervals[i].start) {
					list.get(j).end = intervals[i].end; // Check if this interval can fit into one of the meeting rooms already acquired.
					break;
				}
				if (j == size) { // It needs new meeting room.
					list.add(intervals[i]);
					count++;
				}
			}
		}
		return count;

	}
}

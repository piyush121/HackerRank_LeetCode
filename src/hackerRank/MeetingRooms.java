/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.

/**
 * Definition for an interval.
 * */
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
 }
 
public class MeetingRooms {
	public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals.length == 0)
			return true;
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				return o1.end - o2.end;
			}
		});

		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i + 1].start - intervals[i].end < 0)
				return false;
		}

		return true;
	}
}

/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0, and to take course 0 you should also have
 * finished course 1. So it is impossible.
 * 
 * Note: The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * 
 * click to show more hints.
 * 
 * Hints: This problem is equivalent to finding if a cycle exists in a directed
 * graph. If a cycle exists, no topological ordering exists and therefore it
 * will be impossible to take all courses. Topological sort could also be done
 * via BFS.
 *
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] inDegrees = new int[numCourses];
		Queue<Integer> que = new LinkedList<>();
		for (int i = 0; i < prerequisites.length; i++)
			inDegrees[prerequisites[i][0]]++;
		for (int i = 0; i < inDegrees.length; i++)
			if (inDegrees[i] == 0)
				que.add(i);

		int count = 0;
		while (!que.isEmpty()) {
			int course = que.poll();
			count++;
			for (int i = 0; i < prerequisites.length; i++) {
				if (prerequisites[i][1] == course) {
					inDegrees[prerequisites[i][0]]--;
					if (inDegrees[prerequisites[i][0]] == 0)
						que.add(inDegrees[prerequisites[i][0]]);
				}
			}
		}

		return count == numCourses;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If
 * it is impossible to finish all courses, return an empty array.
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So the correct course order is [0,1]
 * 
 * 4, [[1,0],[2,0],[3,1],[3,2]] There are a total of 4 courses to take. To take
 * course 3 you should have finished both courses 1 and 2. Both courses 1 and 2
 * should be taken after you finished course 0. So one correct course order is
 * [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * 
 * Note: The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 *
 */
public class CourseSchedule_II {
	boolean impossible = false; // I like this way of storing the possibility of impossiblity :P

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Stack<Integer> stack = new Stack<>();
		List<List<Integer>> graph = new ArrayList<>();
		int[] path = new int[numCourses];
		for (int i = 0; i < numCourses; i++) // building the base.
			graph.add(new ArrayList<>());
		for (int i = 0; i < prerequisites.length; i++) { // Building graph.
			graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		for (int i = 0; i < numCourses; i++) { // Actual DFS calls.
			dfs(stack, graph, path, i);
			if (impossible)
				return new int[0];
		}
		int[] res = new int[numCourses];
		for (int i = numCourses - 1; i >= 0; i--) // Build result.
			res[i] = stack.pop();
		return res;

	}

	private void dfs(Stack<Integer> stack, List<List<Integer>> graph, int[] path, int course) {
		if (path[course] == 2 || impossible) {
			return;
		}
		if (path[course] == 1) {
			impossible = true;
			return;
		}
		path[course] = 1; // '1' means being explored.
		for (int nextCourse : graph.get(course)) {
			dfs(stack, graph, path, nextCourse);
			if (impossible)
				return;
		}
		stack.push(course); // done exploring.
		path[course] = 2; // '2' means Exploration complete.

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

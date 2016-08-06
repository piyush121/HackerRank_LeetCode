/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


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
	public boolean canFinish(int numCourses, int[][] prerequisites) { // optimized
																		// DFS
																		// solution
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < numCourses; i++)
			graph.add(new ArrayList<>());

		for (int i = 0; i < prerequisites.length; i++) {
			graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}

		int[] path = new int[numCourses];
		for (int i = 0; i < graph.size(); i++) {
			if (path[i] == 0)
				if (!optimizedDFS(graph, path, i))
					return false;
		}

		return true;
	}

	private boolean optimizedDFS(List<List<Integer>> graph, int[] path, int course) {
		if (path[course] == 1) // 1 means its currently on the path.
			return false;
		path[course] = 1;

		for (int currCourse : graph.get(course)) {
			boolean res = optimizedDFS(graph, path, currCourse);
			if (!res)
				return false;
		}
		path[course] = 2; // 2 means this course has been visited.
		return true;
	}
	
	
	
	public boolean canFinish2(int numCourses, int[][] prerequisites) { // DFS based solution.
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		Set<Integer> path = new HashSet<>();
		Set<Integer> visited = new HashSet<>();
		for (int i = 0; i < prerequisites.length; i++) { // cnstructing adjacency list. Although array list will also work in this case since course are in order.
			if (adjList.containsKey(prerequisites[i][0])) {
				List<Integer> list = adjList.get(prerequisites[i][0]);
				list.add(prerequisites[i][1]);
			}

			else {
				List<Integer> list = new ArrayList<>();
				list.add(prerequisites[i][1]);
				adjList.put(prerequisites[i][0], list);
			}
			if (!adjList.containsKey(prerequisites[i][1])) {
				adjList.put(prerequisites[i][1], new ArrayList<>());
			}
		}
		for (int course : adjList.keySet()) {
			if (!visited.contains(course)) {
				boolean res = dfs(adjList, course, path, visited);
				if (!res)
					return false;
			}
		}

		return true;
	}

	private boolean dfs(Map<Integer, List<Integer>> adjList, int curr,Set<Integer> path, Set<Integer> visited) {
		if(path.contains(curr))
			return false;
		path.add(curr);
		List<Integer> list = adjList.get(curr);
		boolean res = true;
		for(int course : list) {
			res = dfs(adjList, course, path, visited);
			if (!res)
				return false;
		}
		visited.add(curr);
		path.remove(curr);
		return res;
	}
	
	
	public boolean canFinish1(int numCourses, int[][] prerequisites) { // BFS
																		// based
																		// solution. O(V + E )time and O(V) space.
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
			count++; // Course finished so increase count.
			for (int i = 0; i < prerequisites.length; i++) {
				if (prerequisites[i][1] == course) { //if this course was some other courses prereq. then decrease that course's indegree.
					inDegrees[prerequisites[i][0]]--;
					if (inDegrees[prerequisites[i][0]] == 0) // if that course's indegree becomes 0 then add it to the queue.
						que.add(prerequisites[i][0]);
				}
			}
		}

		return count == numCourses; // if there is a cycle in the graph then this will never be true because the nodes on the cycle will never have an indegree of 0.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

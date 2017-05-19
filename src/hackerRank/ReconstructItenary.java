/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.*;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 *
 */
public class ReconstructItenary {
	LinkedList<String> res = new LinkedList<>();

	public List<String> findItinerary(String[][] tickets) {
		Map<String, PriorityQueue<String>> adjLst = new HashMap<>();
		// Create adjacency list.
		for (int i = 0; i < tickets.length; i++) {
			if (!adjLst.containsKey(tickets[i][0]))
				adjLst.put(tickets[i][0], new PriorityQueue<String>());
			adjLst.get(tickets[i][0]).offer(tickets[i][1]);
		}
		dfs("JFK", adjLst);
		return res;
	}

	public void dfs(String curr, Map<String, PriorityQueue<String>> adjLst) {

		while (adjLst.containsKey(curr) && adjLst.get(curr).size() > 0)
			dfs(adjLst.get(curr).poll(), adjLst);
		res.addFirst(curr);
	}
	
	public List<String> findItinerary1(String[][] tickets) {
		Map<String, PriorityQueue<String>> adjLst = new HashMap<>();
		// Create adjacency list.
		for (int i = 0; i < tickets.length; i++) {
			if (!adjLst.containsKey(tickets[i][0]))
				adjLst.put(tickets[i][0], new PriorityQueue<String>());
			adjLst.get(tickets[i][0]).offer(tickets[i][1]);
		}

		List<String> res = new LinkedList<>();
		Stack<String> curr = new Stack<>();
		curr.add("JFK");
		while (!curr.isEmpty()) {
			String next = curr.peek();
			if (adjLst.containsKey(next) && adjLst.get(next).size() > 0)
				curr.push(adjLst.get(next).poll());
			else {
				res.add(next);
				curr.pop();
			}
		}
		Collections.reverse(res);
		return res;
	}
}

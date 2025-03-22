package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoute {
	static public int numBusesToDestination(int[][] routes, int source, int target) {

		if (source == target)
			return 0;
		Map<Integer, List<Integer>> mp = new HashMap<>();

		for (int i = 0; i < routes.length; i++) {
			for (int route : routes[i]) {
				mp.computeIfAbsent(route, k -> new ArrayList<>()).add(i);
			}
		}

		// make queue nad visited node for Bfs
		Queue<Integer> q = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		for (int route : mp.get(source)) {
			q.offer(route);
			visited.add(route);
		}

		int level = 1;

		// Time for BFS do a level order traversal
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int temp = q.poll();

				for (int stop : routes[temp]) {
					if (stop == target)
						return level;
					for (int nextStop : mp.get(stop)) {
						if (!visited.contains(nextStop)) {
							visited.add(nextStop);
							q.offer(nextStop);
						}
					}
				}
			}
			level++;

		}

		return -1;
	}

	public static void main(String[] args) {
		int[][] routes = { { 1, 2, 7 }, { 3, 6, 7 } };
		System.out.println(numBusesToDestination(routes, 1, 6));
	}

}

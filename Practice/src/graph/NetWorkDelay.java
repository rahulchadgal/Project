package graph;

import java.util.Arrays;

public class NetWorkDelay {
	static public int networkDelayTime(int[][] times, int n, int k) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		dist[k] = 0;
		for (int i = 1; i < n; i++) {
			for (int[] time : times) {
				int u = time[0], v = time[1], t = time[2];
				if (dist[u] != Integer.MAX_VALUE && dist[u] + t < dist[v]) {
					dist[v] = dist[u] + t;
				}
			}

		}
		int max = Arrays.stream(dist).max().getAsInt();

		return max == Integer.MAX_VALUE ? -1 : max;
	}

	public static void main(String[] args) {
		int[][] times = { { 1, 2, 1 }, { 2, 3, 1 }, { 1, 4, 4 }, { 3, 4, 1 } };
		System.out.println(networkDelayTime(times, 4, 1));
	}

}

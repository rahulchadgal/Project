package greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinRefuelStops {
	static public int minRefuelStops(int target, int startFuel, int[][] stations) {
		int stops = 0;
		// think like a greedy appraoch where we can save the fuels of stations who just
		// passed and are within reach
		// and then used them when we need it, incremented the stops count

		// i is the stations variable
		int i = 0;
		int dist = startFuel;
		int n = stations.length;

		Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

		while (dist < target) {
			if(i < n && stations[i][0] <= dist) {
				heap.add(stations[i][1]);
				i++;
			}
			//condtion for there is stop available
			else if(heap.isEmpty())
				return -1;
			
			//cndition for max distqance is convered and still not at target , incremented the stops
			else {
				dist+=heap.poll();
				stops++;
			}
		}

		return stops;

	}

	public static void main(String[] args) {
		int target = 100;
		int startFuel = 10;
		int[][] stations = { { 10, 60 }, { 20, 30 }, { 30, 30 }, { 60, 40 } };

		System.out.println(minRefuelStops(target, startFuel, stations));
	}

}

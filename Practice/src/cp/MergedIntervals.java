package cp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergedIntervals {
	static public int[][] merge(int[][] intervals) {

		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		int n = intervals.length;

		int[] prev = intervals[0];

		List<int[]> res = new ArrayList<>();

		for (int i = 1; i < n; i++) {
			int[] interval = intervals[i];
			if (interval[0] <= prev[1]) {
				prev[1] = Math.max(prev[1], interval[1]);
			} else {
				res.add(prev);
				prev = interval;
			}
		}

		return res.toArray(new int[res.size()][]);
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } };
		// TODO Auto-generated method stub
		merge(arr);

	}

}

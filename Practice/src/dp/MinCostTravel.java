package dp;

import java.util.HashSet;
import java.util.Set;

public class MinCostTravel {
	static public int mincostTickets(int[] days, int[] costs) {
		int n = days[days.length - 1];

		int dp[] = new int[n + 1];
		Set<Integer> set = new HashSet<>();
		for (int day : days) {
			set.add(day);
		}
		for (int i = 1; i <= n; i++) {
			if (!set.contains(i))
				dp[i] = dp[i - 1];
			else {
				// coin change type problems
				dp[i] = Math.min(dp[i - 1] + costs[0],
						Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]));
			}
		}

		return dp[n];
	}

	public static void main(String[] args) {
		int days[] = { 1, 4, 6, 7, 8, 20 };
		int costs[] = { 2, 7, 15 };
		System.out.println(mincostTickets(days, costs));

	}

}

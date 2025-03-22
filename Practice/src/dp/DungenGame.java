package dp;

import java.util.Arrays;

public class DungenGame {
	static public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;

		int[][] dp = new int[m][n];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		return solve(0, 0, dungeon, dp);
	}

	private static int solve(int i, int j, int[][] dungeon, int[][] dp) {
		int m = dungeon.length;
		int n = dungeon[0].length;

		if (i == m - 1 && j == n - 1)
			return Math.max(1, 1 - dungeon[i][j]);

		if (i >= m || j >= n)
			return Integer.MAX_VALUE;

		// If the value is already calculated
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int right = solve(i, j + 1, dungeon, dp);
		int down = solve(i + 1, j, dungeon, dp);

		int minHealth = Math.min(right, down) - dungeon[i][j];
		dp[i][j] = Math.max(1, minHealth);
		return dp[i][j];
	}

	public static void main(String[] args) {
		int[][] dungen = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		System.out.println(calculateMinimumHP(dungen));
	}

}

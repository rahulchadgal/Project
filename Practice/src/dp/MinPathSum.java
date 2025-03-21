package dp;

public class MinPathSum {

	public static int minSumPath(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (i == 1 || j == 1) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
				}
			}
		}
		return dp[n][m];

	}

	public static void main(String[] args) {
		int matrix[][] = { { 5, 9, 6 }, { 11, 5, 2 } };

		// Calculate and print the minimum sum path in the matrix
		System.out.println(minSumPath(matrix));

	}

}

package dp;

public class MaxFallingPathSum {
	static public int minFallingPathSum(int[][] matrix) {
		int max_sum = Integer.MAX_VALUE;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < n; i++) {
			dp[0][i] = matrix[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <m; j++) {

				if (j == 0) {
					dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
				} else if (j == n - 1) {
					dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
				} else
					// (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1)
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + matrix[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			max_sum = Math.min(max_sum, dp[n - 1][i]);
		}

		return max_sum;

	}

	public static void main(String[] args) {
		int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
		System.out.println(minFallingPathSum(matrix));
	}

}

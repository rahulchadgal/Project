package graph;

public class MaxArea {
	static int max = 0;
	static int maxArea = 0;

	public static int maxAreaOfIsland(int[][] grid) {
		int count = 0, n = grid.length, m = grid[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					maxArea = 0;
					dfs(grid, i, j);
					max = Math.max(maxArea, max);
				}
			}
		}
		return max;
	}

	private static void dfs(int[][] grid, int i, int j) {
		int n = grid.length, m = grid[0].length;
		if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0)
			return;
		grid[i][j] = 0;
		maxArea++;
		dfs(grid, i, j - 1);
		dfs(grid, i - 1, j);
		dfs(grid, i + 1, j);
		dfs(grid, i, j + 1);

	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		System.out.println(maxAreaOfIsland(grid));
	}

}

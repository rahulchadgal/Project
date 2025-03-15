package graph;

public class NumberOfIslands {
	public static int numIslands(char[][] grid) {
		int count = 0, n = grid.length, m = grid[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}
		return count;
	}

	private static void dfs(char[][] grid, int i, int j) {
		int n = grid.length, m = grid[0].length;
		if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		dfs(grid, i, j - 1);
		dfs(grid, i - 1, j);
		dfs(grid, i + 1, j);
		dfs(grid, i, j + 1);

	}

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println(numIslands(grid));

	}

}

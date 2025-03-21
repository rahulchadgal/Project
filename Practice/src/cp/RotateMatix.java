package cp;

public class RotateMatix {

	static public void rotate(int[][] mat) {

		int n = mat.length;
		int m = mat[0].length;

		// transpose matrix
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < m; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}

		// rotate rows matrix
		for (int j = 0; j < m; j++) {
			for(int  i = 0 ; i < n/2 ; i++) {
				int temp = mat[j][n-i-1];
				mat[j][n-i-1] = mat[j][i];
				mat[j][i] = temp;
			}
		}

	}
	

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		rotate(matrix);
	}

}

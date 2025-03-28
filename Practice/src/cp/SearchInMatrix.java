package cp;

public class SearchInMatrix {

	static public boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;

		int l = 0, mid = 0, r = n * m - 1;
		int row = 0, col = 0;

		while (l <= r) {
			mid = (l + r) / 2;
			row = mid / m;
			col = mid % m;

			if (matrix[row][col] == target)
				return true;
			else if (matrix[row][col] > target)
				r = mid - 1;
			else
				l = mid + 1;

		}
		return false;
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		System.out.println(searchMatrix(arr, 15));
	}

}

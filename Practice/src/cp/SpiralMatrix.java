package cp;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	static public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		int n = matrix.length;
		int m = matrix[0].length;
		int left = 0, right = m - 1, top = 0, down = n - 1;
		while (left <= right && top <= down) {
			for (int i = left; i <= right; i++)
				res.add(matrix[top][i]);
			top++;
			for (int i = top; i <= down; i++)
				res.add(matrix[i][right]);
			right--;
			if (top <= down) {
				for (int i = right; i >= left; i--)
					res.add(matrix[down][i]);
				down--;
			}
			if (left <= right) {
				for (int i = down; i >= top; i--)
					res.add(matrix[i][left]);
				left++;
			}

		}
		return res;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		System.out.println(spiralOrder(matrix));

	}

//	 1   2  3  4
//	 5   6  7  8
//	 9  10 11 12

	// [1,2,3,4,8,12,11,10,9,5,6,7]

}

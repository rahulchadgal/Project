package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortAnArray012 {

	public static void sortArray012() {
		int[] arr = { 2, 0, 2, 1, 1, 0 };
		int low = 0, mid = 0, high = arr.length - 1;

		while (mid <= high) {
			if (arr[mid] == 0) {
				int temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				low++;
				mid++;
			} else if (arr[mid] == 1) {
				mid++;
			} else {
				int temp = arr[high];
				arr[high] = arr[mid];
				arr[mid] = temp;
				high--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	// Longest Consecutive Sequence in an Array
	public static void longConsArray() {
		int[] arr = { 3, 1, 4, 6, 2, 10, 12, 8, 9, 7 };
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		int res = 1;
		for (int i : arr) {
			if (!set.contains(i - 1)) {
				int ct = 1;
				int x = i;
				while (set.contains(x + 1)) {
					ct++;
					x = x + 1;
				}
				res = Math.max(ct, res);
			}
		}
		System.out.println(res);
	}

	// rotate matrix
	public static void rotateMatrix() {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int n = 3;
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (i != j) {
					int temp = arr[j][i];
					arr[j][i] = arr[i][j];
					arr[i][j] = temp;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][n - j - 1];
				arr[i][n - j - 1] = temp;
			}
		}

		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

	// print matrix in spriral form
	public static void spiralMatrix() {
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		List<Integer> res = new ArrayList<>();

		int n = 4, m = 4;
		int top = 0, left = 0, right = n - 1, bottom = m - 1;

		while (top <= bottom && left <= right) {
			for (int i = left; i <= right; i++) {
				res.add(mat[top][i]);
			}
			top++;
			for (int i = top; i <= bottom; i++) {
				res.add(mat[i][right]);
			}
			right--;

			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					res.add(mat[bottom][i]);
				}
				bottom--;
			}

			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					res.add(mat[i][left]);
				}
				left++;
			}

		}
		System.out.println(res);

		// Output: 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
	}

	// Height of a tree
	public static void treeHeight() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(6);
		root.left.right.right.right = new Node(7);

		System.out.println("Maximum depth of the binary tree: " + getHeight(root));
		System.out.println(balancedTree(root) != -1);
	}

	public static int getHeight(Node node) {
		if (node == null)
			return 0;

		int leftH = getHeight(node.left);
		int rightH = getHeight(node.right);

		return (Math.max(leftH, rightH) + 1);
	}

	// tree is Balanced or Not
	public static int balancedTree(Node node) {
		if (node == null)
			return 0;
		int leftH = balancedTree(node.left);
		if (leftH == -1)
			return -1;
		int rightH = balancedTree(node.right);
		if (rightH == -1)
			return -1;
		if (Math.abs(rightH - leftH) > 1)
			return -1;

		return Math.max(leftH, rightH) + 1;

	}

	public static void main(String[] args) {
//		sortArray012();
//		longConsArray();
		// rotateMatrix();
		// spiralMatrix();
		treeHeight();

	}

}

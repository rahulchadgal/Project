package cp;

import java.util.Arrays;

public class Array01 {

	private static void sorted01(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			while (left < right && arr[left] == 0) {
				left++;
			}
			while (right > left && arr[right] == 1) {
				right--;
			}

			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 1, 1, 0, 1};
		sorted01(arr);
		System.out.println(Arrays.toString(arr));

	}

}

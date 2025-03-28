package slidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaxSlidingWindow {
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int[] res = new int[nums.length - k + 1];
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		int p = 0;

		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
				dq.pollLast();
			}
			dq.offerLast(i);
		}
		res[p++] = nums[dq.peekFirst()];

		for (int i = k; i < nums.length; i++) {
			if (dq.peekFirst() == i - k) {
				dq.pollFirst();
			}
			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
				dq.pollLast();
			}
			dq.offerLast(i);
			res[p++] = nums[dq.peekFirst()];
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 0, 4, 2, 6 };
		System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));

	}

}

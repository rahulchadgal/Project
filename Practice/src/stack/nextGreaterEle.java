package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class nextGreaterEle {
	public static int[] nextGreaterElement(int[] nums) {
		int[] res = new int[nums.length];
		int n = nums.length;
		Arrays.fill(res, -1);
		Stack<Integer> st = new Stack<>();
		for (int i = 2 * (nums.length - 1); i >= 0; i--) {
			while (!st.isEmpty() && st.peek() <= nums[i % n]) {
				st.pop();
			}
			if (i < n && !st.isEmpty()) {
				res[i] = st.peek();
			}
			st.push(nums[i % n]);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 100, 1, 11, 1, 120, 111, 123, 1, -1, -100 };
		System.out.println(Arrays.toString(nextGreaterElement(nums)));

	}

}

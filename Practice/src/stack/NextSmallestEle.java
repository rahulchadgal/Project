package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallestEle {
	public static int[] prevSmaller(int[] A) {
		int[] res = new int[A.length];
		Arrays.fill(res, -1);
		Stack<Integer> st = new Stack<>();
		int i = 0;
		for (int n : A) {
			while (!st.isEmpty() && st.peek() > n) {
				st.pop();
			}
			if (!st.isEmpty())
				res[i] = st.peek();
			st.push(n);
			i++;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {3, 2, 1};
		System.out.println(Arrays.toString(prevSmaller(nums)));

	}

}

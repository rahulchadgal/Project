package dp;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
	static public int findTargetSumWays(int[] nums, int target) {
		Map<Integer, Integer> mp = new HashMap<>();
		mp.put(0, 1);// means for sum =0 , we have 1 way
		for (int num : nums) {
			Map<Integer, Integer> next = new HashMap<>();

			for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
				int total = entry.getKey(); // current total sum
				int count = entry.getValue(); // current count of ele

				// not taken
				next.put(total + num, next.getOrDefault(total + num, 0) + count);
				next.put(total - num, next.getOrDefault(total - num, 0) + count);
			}
			mp = next;
		}
		return mp.get(target);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

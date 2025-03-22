package dp;

import java.util.Arrays;

public class LostStoneWeight {
	static public int lastStoneWeightII(int[] stones) {
		int totalSum = Arrays.stream(stones).sum();
		int target = (int) Math.ceil(totalSum / 2);

		boolean[] dp = new boolean[target + 1];
		dp[0] = true;
		// code to find the possibles sum for target bound
		for (int num : stones) {
			for (int sum = target; sum >= num; sum--) {
				if (dp[sum - num])
					dp[sum] = true;
			}
		}
		int res = 0;
		int minDiff = 0;
		for (int i = target; i >= 0; i--) {
			if (dp[i]) {
				minDiff = i;
				break;
			}
		}
		int y = totalSum - minDiff;
		res = y - minDiff;

		return res;
	}

	public static void main(String[] args) {
		int[] stones = { 3, 9, 7, 3 };
		System.out.println(lastStoneWeightII(stones));

	}

}

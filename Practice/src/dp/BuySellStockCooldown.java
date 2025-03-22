package dp;

import java.util.HashMap;
import java.util.Map;

public class BuySellStockCooldown {

	static Map<String, Integer> dp = new HashMap<>();

	static public int maxProfit(int[] prices) {

		return dfs(0, true, prices);
	}

	private static int dfs(int i, boolean b, int[] prices) {
		if (i >= prices.length)
			return 0;

		String key = i + "-" + b;
		if (dp.containsKey(key))
			return dp.get(key);

		int cooldown = dfs(i + 1, b, prices);
		if (b) {
			int buy = dfs(i + 1, false, prices) - prices[i];
			dp.put(key, Math.max(buy, cooldown));
		} else {
			int sell = dfs(i + 2, true, prices) + prices[i];
			dp.put(key, Math.max(cooldown, sell));
		}
		return dp.get(key);
	}

	public static void main(String[] args) {
		int[] prices = { 1, 3, 4, 0, 4 };
		System.out.println(maxProfit(prices));

	}

}

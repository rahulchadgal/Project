package cp;

import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of items: ");
		int n = sc.nextInt();
		int[] weights = new int[n];
		int[] values = new int[n];
		System.out.println("Enter weights of items: ");
		for (int i = 0; i < n; i++)
			weights[i] = sc.nextInt();
		System.out.println("Enter values of items: ");
		for (int i = 0; i < n; i++)
			values[i] = sc.nextInt();
		System.out.print("Enter capacity of knapsack: ");
		int capacity = sc.nextInt();
		System.out.println("Maximum value in Knapsack: " + knapsack(weights, values, capacity));
		sc.close();

	}

	private static int knapsack(int[] weights, int[] values, int capacity) {
		// TODO Auto-generated method stub
		int n = weights.length;

		int[][] dp = new int[n + 1][capacity + 1];

		for (int i = 1; i <= n; i++) {
			for (int w = 1; w <= capacity; w++) {
				if (weights[i] <= w) {
					dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
				} else
					dp[i][w] = dp[i - 1][w];
			}
			
		}
		return dp[n][capacity];
	}

}

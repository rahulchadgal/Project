package dp;

public class LIS {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 3, 4, 5, 2, 3 };
		

		System.out.println(lengthOfLIS(arr));
	}

	private static int lengthOfLIS(int[] arr) {
		int dp[] = new int[arr.length];

		int len = 0;

		// run for each element to check it values in Dp array
		for (int num : arr) {
			// these two will tell the size of the dp array, so that we can search in it
			int left = 0, right = len;
			while (left < right) {
				int mid = left + (right - left) / 2;
				if (dp[mid] < num)
					left = mid + 1;
				else
					right = mid;
			}
			// this for adding the element in the dp array if left reached the end
			if (left == len)
				dp[len++] = num;
			// this is replacing elemnt in dp array
			else
				dp[left] = num;
		}
		return len;
	}

}

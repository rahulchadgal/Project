package cp;

import java.util.HashMap;
import java.util.Map;

public class xorKSubarray {

	public static void main(String[] args) {
		int[] a = {4, 2, 2, 6, 4};
		int k = 6;
		int ans = subarraysWithXorK(a, k);
		System.out.println("The number of subarrays with XOR k is: " + ans);

	}

	private static int subarraysWithXorK(int[] a, int k) {
		Map<Integer, Integer> mp = new HashMap<>();
		int count = 0;
		mp.put(0, 1);
		int xori = 0;
		for (int i = 0; i < a.length; i++) {
			xori ^= a[i];
			int searchXor = xori ^ k;
			if (mp.containsKey(searchXor)) {
				count += mp.get(searchXor);
			}
			mp.put(xori, mp.getOrDefault(xori, 0) + 1);

		}
		return count;
	}

}

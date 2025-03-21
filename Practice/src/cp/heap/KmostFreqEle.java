package cp.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class KmostFreqEle {
	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> count = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
				(a, b) -> Integer.compare(b.getValue(), a.getValue()));

		for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
			pq.offer(entry);
		}
		int res[] = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = Objects.requireNonNull(pq.poll()).getKey();
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 2, 2, 3 };
		System.out.println(topKFrequent(arr, 2));
	}
}

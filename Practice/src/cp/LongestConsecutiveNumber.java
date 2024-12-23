package cp;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestConsecutiveNumber {

	static public int longestConsecutive(int[] nums) {

		Set<Integer> set = new HashSet<>();
		set.addAll(IntStream.of(nums).boxed().collect(Collectors.toList()));
		int max = -1;
		for (int i = 0; i < nums.length; i++) {
			int ct = 0;
			if (!set.contains(nums[i] - 1)) {
				int j = 0;
				while (set.contains(nums[i] + j++)) {
					ct++;
				}
				max = Math.max(ct, max);
			}
		}

		return max;

	}

	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));

	}

}

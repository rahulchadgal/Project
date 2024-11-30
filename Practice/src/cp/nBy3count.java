package cp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nBy3count {

	static public List<Integer> majorityElement(int[] nums) {

		int cad1 = 0, cad2 = 0, c1 = 0, c2 = 0;

		for (int num : nums) {
			if (num == cad1)
				c1++;
			else if (num == cad2)
				c2++;
			else if (c1 == 0) {
				cad1 = num;
				c1 = 1;
			} else if (c2 == 0) {
				cad2 = num;
				c2 = 1;
			} else {
				c1--;
				c2--;
			}
		}

		List<Integer> result = new ArrayList<>();
		int threshold = nums.length / 3;
		if (c1 > threshold) {
			result.add(cad1);
		}
		if (c2 > threshold) {
			result.add(cad2);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 4, 5, 4, 5, 4, 4, 3, 3, 3, 3, 3, 4, 4 };
		System.out.println(majorityElement(nums));

	}

}

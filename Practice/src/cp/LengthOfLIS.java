package cp;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLIS {
	static public int lengthOfLIS(int[] nums) {
		
		List<Integer> res = new ArrayList<>();
		
		for(int i =0 ; i< nums.length  ; i++) {
			if(res.isEmpty() || res.get(res.size()-1) < nums[i])
				res.add(nums[i]);
			else {
				int idx = binarySearch(res, nums[i]);
				res.set(idx, nums[i]);
			}
		}

		return res.size();
	}

	static private int binarySearch(List<Integer> res, int n) {

		int l = 0, r = res.size() - 1;

		while (l <= r) {
			int mid = (l + r) / 2;

			if (res.get(mid) == n)
				return mid;
			else if (res.get(mid) > n)
				r = mid - 1;
			else
				l = mid + 1;
		}
		return l;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };

		System.out.println(lengthOfLIS(arr));
	}

}

package cp;

public class DuplicatesNumber {

	static public int findDuplicate_fastSlow(int[] nums) {
		int slow = 0;
		int fast = 0;
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		slow = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}

		return slow;
	}

	public static void main(String[] args) {
		// findDuplicate_fastSlow(new int[]{1,3,4,2,2});

		System.out.println(findDuplicate_fastSlow(new int[] { 1, 3, 2, 2, 4 }));

	}

}

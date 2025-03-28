package tree;

public class KthSmallest {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	static public int inorder(TreeNode root, int counter, int k, int val) {

		if (root == null || counter >= k)
			return val;

		inorder(root.left, counter, k, val);
		counter++;

		if (counter == k) {
			val = root.val;
			return val;
		}
		inorder(root.right, counter, k, val);
		return -1;

	}

	static public int kthSmallest(TreeNode root, int k) {

		int ksmallest = -1;
		int counter = 0;
		ksmallest = inorder(root, counter, k, ksmallest);
		return ksmallest;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(13);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(2);
		root.left.left.right = new TreeNode(4);
		root.left.right = new TreeNode(6);
		root.left.right.right = new TreeNode(9);
		root.right.left = new TreeNode(11);
		root.right.right = new TreeNode(14);

		System.out.println(kthSmallest(root, 3));
	}

}

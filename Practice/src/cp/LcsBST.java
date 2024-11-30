package cp;

public class LcsBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		TreeNode node =root;
		int min = Math.min(p.val, q.val);
		int max = Math.max(p.val, q.val);

		if (min == max)
			return p;
		while (root != null) {
			if (root.val >= min && root.val <= max)
				return root;
			else if (root.val > max)
				root = root.left;
			else
				root = root.right;
		}
		return node;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

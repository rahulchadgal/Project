package tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SerializeDeserialIze {
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

	static public String serialize(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node == null) {
				sb.append(",#");
			} else {
				sb.append("," + String.valueOf(node.val));
				q.add(node.left);
				q.add(node.right);
			}
		}

		return sb.deleteCharAt(0).toString();
	}

//	 Decodes your encoded data to tree.
	static public TreeNode deserialize(String data) {

		String[] str = data.split(",");
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.parseInt(str[0]));
		q.offer(root);
		for (int i = 1; i < str.length; i++) {
			TreeNode parent =  q.poll();
			
			if(!str[i].equals("#")) {
				parent.left = new TreeNode(Integer.parseInt(str[i]));
				q.offer(parent.left);
			}if(!str[++i].equals("#")) {
				parent.right = new TreeNode(Integer.parseInt(str[i]));
				q.offer(parent.right);
			}
		}
		return  root;
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

		String data = serialize(root);
		deserialize(data);
		System.out.println(data);

	}

}

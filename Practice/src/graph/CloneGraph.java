package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CloneGraph {
	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	Map<Node, Node> ht = new HashMap<>();

	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}
		if (ht.containsKey(node))
			return ht.get(node);

		var y = new Node();
		y.val = node.val;

		y.neighbors = node.neighbors.stream().map(this::cloneGraph).collect(Collectors.toCollection(ArrayList::new));
		return y;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

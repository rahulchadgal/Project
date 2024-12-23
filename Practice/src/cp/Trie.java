package cp;

class Node {
	Node links[] = new Node[26];
	boolean flag = false;

	boolean containsKey(char ch) {
		return links[ch - 'a'] != null;
	}

	Node get(char ch) {
		return links[ch - 'a'];
	}

	void put(char ch, Node node) {
		links[ch - 'a'] = node;
	}

	void setEnd() {
		flag = true;
	}

	boolean isEnd() {
		return flag;
	}
}

public class Trie {
	private static Node root;

	Trie() {
		root = new Node();
	}

	void insert(String word) {
		Node node = root;
		for (char ch : word.toCharArray()) {
			if (!node.containsKey(ch)) {
				node.put(ch, new Node());
			}
			node = node.get(ch);
		}
		node.setEnd();
	}

	boolean search(String word) {
		Node node = root;
		for (char ch : word.toCharArray()) {
			if (!node.containsKey(ch)) {
				return false;
			}
			node = node.get(ch);
		}
		if (node.isEnd())
			return true;
		return false;
	}

	boolean startsWith(String word) {
		Node node = root;
		for (char ch : word.toCharArray()) {
			if (!node.containsKey(ch))
				return false;
			node = node.get(ch);
		}
		return true;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();

		// Insert words into the Trie
		trie.insert("apple");
		trie.insert("app");
		trie.insert("application");
		trie.insert("bat");
		trie.insert("ball");

		// Test search
		System.out.println(trie.search("apple")); // Output: true
		System.out.println(trie.search("app")); // Output: true
		System.out.println(trie.search("appl")); // Output: false
		System.out.println(trie.search("bat")); // Output: true
		System.out.println(trie.search("bath")); // Output: false

		// Test startsWith
		System.out.println(trie.startsWith("app")); // Output: true
		System.out.println(trie.startsWith("bat")); // Output: true
		System.out.println(trie.startsWith("ball")); // Output: true
		System.out.println(trie.startsWith("cat")); // Output: false

	}
}

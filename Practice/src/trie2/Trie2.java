package trie2;

class Node {
	Node links[] = new Node[26];
	int ew = 0;
	int cp = 0;
	// boolean flag = false;

	boolean containsKey(char ch) {
		return links[ch - 'a'] != null;
	}

	Node get(char ch) {
		return links[ch - 'a'];
	}

	void put(char ch, Node node) {
		links[ch - 'a'] = node;
	}

	void increaseEnd() {
		ew++;
	}

	void increasePrefix() {
		cp++;
	}

	void reducePrefix() {
		cp--;
	}

	void deleteEnd() {
		ew--;
	}

	int getEnd() {
		return ew;
	}

	int getPRefix() {
		return cp;
	}

}

public class Trie2 {
	private static Node root;

	Trie2() {
		root = new Node();
	}

	void insert(String word) {
		Node node = root;
		for (char ch : word.toCharArray()) {
			if (!node.containsKey(ch)) {
				node.put(ch, new Node());
			}
			node = node.get(ch);
			node.increasePrefix();
		}
		node.increaseEnd();
	}

	int countWordEqualsTo(String word) {
		Node node = root;
		for (char ch : word.toCharArray()) {
			if (!node.containsKey(ch)) {
				return 0;
			}
			node = node.get(ch);
		}
		return node.getEnd();
	}

	int countWordStartsWith(String word) {
		Node node = root;
		for (char ch : word.toCharArray()) {
			if (!node.containsKey(ch))
				return 0;
			node = node.get(ch);
		}
		return node.getPRefix();
	}

	void erase(String word) {
		Node node = root;
		for (char ch : word.toCharArray()) {
			if (!node.containsKey(ch)) {
				return;
			}
			node = node.get(ch);
			node.reducePrefix();
		}
		node.deleteEnd();
	}

	public static void main(String[] args) {
		Trie2 trie = new Trie2();

		// Insert words into the Trie
		trie.insert("apple");
		trie.insert("app");
		trie.insert("application");
		trie.insert("bat");
		trie.insert("ball");

		// Test search
		System.out.println(trie.countWordStartsWith("apple")); // Output: true
		System.out.println(trie.countWordEqualsTo("app")); // Output: true
		System.out.println(trie.countWordStartsWith("appl")); // Output: false
		System.out.println(trie.countWordStartsWith("bat")); // Output: true
		System.out.println(trie.countWordStartsWith("bath")); // Output: false

		trie.erase("app");
		// Test startsWith
		// System.out.println(); // Output: true
		System.out.println(trie.countWordStartsWith("app")); // Output
		System.out.println(trie.countWordEqualsTo("app"));
		// System.out.println(trie.startsWith("bat")); // Output: true
		// System.out.println(trie.startsWith("ball")); // Output: true
		// System.out.println(trie.startsWith("cat")); // Output: false

	}
}

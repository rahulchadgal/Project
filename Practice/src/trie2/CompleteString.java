package trie2;

public class CompleteString {

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

	class Trie {
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

		boolean isCompetedString(String word) {
			Node node = root;
			for (char ch : word.toCharArray()) {
				if (!node.containsKey(ch)) {
					return false;
				}
				node = node.get(ch);
				if (!node.isEnd()) {
					return false;
				}
			}
			return true;
		}

		String longestCompleteString(String[] res) {
			int maxSize = 0;
			String result = "";
			for (String str : res) {
				if (isCompetedString(str) && str.length() > maxSize) {
					result = str;
					maxSize = str.length();
				} else if (isCompetedString(str) && str.length() == maxSize) {
					result = (result.compareTo(str) < 0) ? result : str;
				}
			}
			return result;
		}

	}

	public static void main(String[] args) {
		Trie trie = new CompleteString().new Trie();

		// Insert words into the Trie
		trie.insert("n");
		trie.insert("ninja");
		trie.insert("ninj");
		trie.insert("ni");
		trie.insert("nin");
		trie.insert("ninga");
		trie.insert("ning");
		// trie.insert("");

		String[] res = { "n", "ninjaa", "nin", "ninj", "ninaj", "ningaa", "ni", "ning" };
		trie.longestCompleteString(res);
		// String max = "";
		System.out.print(trie.longestCompleteString(res));

	}

}

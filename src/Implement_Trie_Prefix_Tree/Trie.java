package Implement_Trie_Prefix_Tree;
/*Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.*/
class TrieNode {
	// Initialize your data structure here.
	public TrieNode() {
		this.val = 0;
	}
	public TrieNode(int val) {
		this.val = val;
	}

	int val;
	TrieNode[] next = null;
	boolean isInit = false;
	boolean isEnd = false;

	public void init() {
		next = new TrieNode[26];
		isInit = true;
	}
}

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode cursor = root;
		for (int i = 0; i < word.length(); i++) {
			if (!cursor.isInit) {
				cursor.init();
			}
			if (cursor.next[word.charAt(i) - 'a'] == null)
				cursor.next[word.charAt(i) - 'a'] = new TrieNode(1);
			cursor = cursor.next[word.charAt(i) - 'a'];
			if (i == word.length() - 1) {
				cursor.isEnd = true;
			}
		}
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		if (word.length() <= 0)
			return false;
		TrieNode cursor = root;
		for (int i = 0; i < word.length(); i++) {
			if (cursor.next == null
					|| cursor.next[word.charAt(i) - 'a'] == null
					|| cursor.next[word.charAt(i) - 'a'].val == 0) {
				return false;
			}
			cursor = cursor.next[word.charAt(i) - 'a'];
		}
		if (!cursor.isEnd)
			return false;
		return true;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		if (prefix.length() <= 0)
			return false;
		TrieNode cursor = root;
		for (int i = 0; i < prefix.length(); i++) {
			if (cursor.next == null
					|| cursor.next[prefix.charAt(i) - 'a'] == null
					|| cursor.next[prefix.charAt(i) - 'a'].val == 0) {
				return false;
			}
			cursor = cursor.next[prefix.charAt(i) - 'a'];
		}
		return true;
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
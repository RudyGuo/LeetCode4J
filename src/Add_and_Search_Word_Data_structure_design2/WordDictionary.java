package Add_and_Search_Word_Data_structure_design2;

import java.util.LinkedList;
import java.util.Queue;

public class WordDictionary {

	class TrieNode {
		// Initialize your data structure here.
		boolean isEnd = false;

		public TrieNode() {

		}

		TrieNode[] next;
	}

	TrieNode root = new TrieNode();

	// Adds a word into the data structure.
	public void addWord(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			if (current.next == null)
				current.next = new TrieNode[26];
			if (current.next[word.charAt(i) - 'a'] == null)
				current.next[word.charAt(i) - 'a'] = new TrieNode();
			if (i == word.length() - 1)
				current.next[word.charAt(i) - 'a'].isEnd = true;
			current = current.next[word.charAt(i) - 'a'];
		}
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		Queue<TrieNode> que = new LinkedList<>();
		Queue<TrieNode> next = new LinkedList<>();
		int i = 0;
		que.offer(root);
		while (!que.isEmpty() && i < word.length()) {
			char c = word.charAt(i);
			while (!que.isEmpty()) {
				TrieNode tn = que.poll();
				if (c != '.') {
					if (tn.next == null||tn.next[c - 'a'] == null)
						continue;
					next.offer(tn.next[c - 'a']);
				} else {
					if (tn.next == null) continue;
					for (int j = 0; j < tn.next.length; j++) {
						if (tn.next[j] != null)
							next.offer(tn.next[j]);
					}
				}
			}
			i++;
			if (i == word.length()) {
				while (!next.isEmpty()) {
					if (next.poll().isEnd)
						return true;
				}
				return false;
			} else {
				Queue<TrieNode> tmp = que;
				que = next;
				next = tmp;
				if (que.isEmpty())
					return false;
			}
		}
		throw new IllegalArgumentException();
	}
	
	
	public static void main(String args[]){
		WordDictionary wd = new WordDictionary();
		wd.addWord("bad");
		wd.addWord("dad");
		wd.addWord("mad");
		System.out.println(wd.search("pad")) ;
		System.out.println(wd.search("bad")) ;
		System.out.println(wd.search(".ad")) ;
		System.out.println(wd.search("b..")) ;
	}
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
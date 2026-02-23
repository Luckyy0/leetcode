package leet_code.Problem_211_Medium_Design_Add_And_Search_Words_Data_Structure;

public class WordDictionary {

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return match(word, 0, root);
    }

    // Helper function for DFS matching
    // Hàm bổ trợ cho việc khớp DFS
    private boolean match(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        if (c == '.') {
            // Wildcard: Try all possible children
            // Kí tự đại diện: Thử tất cả các con có thể
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if (match(word, index + 1, node.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            // Regular character match
            // Khớp ký tự thông thường
            int i = c - 'a';
            if (node.children[i] == null) {
                return false;
            }
            return match(word, index + 1, node.children[i]);
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println("pad: " + wordDictionary.search("pad")); // false
        System.out.println("bad: " + wordDictionary.search("bad")); // true
        System.out.println(".ad: " + wordDictionary.search(".ad")); // true
        System.out.println("b..: " + wordDictionary.search("b..")); // true
    }
}

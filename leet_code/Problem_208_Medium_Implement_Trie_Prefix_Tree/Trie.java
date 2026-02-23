package leet_code.Problem_208_Medium_Implement_Trie_Prefix_Tree;

class TrieNode {
    // Links to child nodes
    // Liên kết đến các nút con
    TrieNode[] children;

    // Flag to mark if a word ends at this node
    // Cờ để đánh dấu nếu một từ kết thúc tại nút này
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26]; // 'a' - 'z'
        isEnd = false;
    }
}

public class Trie {

    private final TrieNode root;

    /** Initializes the trie object. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts the word into the trie. */
    public void insert(String word) {
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

    /** Returns true if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isEnd;
    }

    /**
     * Returns true if there is any word in the trie that starts with the given
     * prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = findNode(prefix);
        return node != null;
    }

    // Helper to traverse to the node representing the string
    // Hàm bổ trợ để duyệt đến nút đại diện cho chuỗi
    private TrieNode findNode(String str) {
        TrieNode curr = root;
        for (char c : str.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                return null;
            }
            curr = curr.children[index];
        }
        return curr;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("Search 'apple': " + trie.search("apple")); // true
        System.out.println("Search 'app': " + trie.search("app")); // false
        System.out.println("StatsWith 'app': " + trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println("Search 'app': " + trie.search("app")); // true
    }
}

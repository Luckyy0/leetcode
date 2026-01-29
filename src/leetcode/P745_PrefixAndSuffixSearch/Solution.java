package leetcode.P745_PrefixAndSuffixSearch;

class WordFilter {
    class TrieNode {
        TrieNode[] children = new TrieNode[27]; // 'a'-'z' and '{'
        int weight = -1;
    }

    TrieNode root;

    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            for (int j = 0; j <= w.length(); j++) {
                // Suffix + "{" + word
                insert(w.substring(j) + "{" + w, i);
            }
        }
    }

    private void insert(String s, int index) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            int k = c - 'a';
            if (curr.children[k] == null)
                curr.children[k] = new TrieNode();
            curr = curr.children[k];
            curr.weight = index; // Update with latest index
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode curr = root;
        for (char c : (suffix + "{" + prefix).toCharArray()) {
            int k = c - 'a';
            if (curr.children[k] == null)
                return -1;
            curr = curr.children[k];
        }
        return curr.weight;
    }
}

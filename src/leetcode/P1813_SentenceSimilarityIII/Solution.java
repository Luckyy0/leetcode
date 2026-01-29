package leetcode.P1813_SentenceSimilarityIII;

public class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] w1 = sentence1.split(" ");
        String[] w2 = sentence2.split(" ");

        if (w1.length > w2.length) {
            String[] temp = w1;
            w1 = w2;
            w2 = temp;
        }
        // w1 is shorter or equal
        int n1 = w1.length;
        int n2 = w2.length;

        int l = 0;
        int r = 0;

        // Match prefix
        while (l < n1 && w1[l].equals(w2[l])) {
            l++;
        }

        // Match suffix
        // Be careful not to use index < l for w1 (overlap)
        // Actually, just match from right.
        // We compare w1[n1 - 1 - r] and w2[n2 - 1 - r]
        while (r < n1 && w1[n1 - 1 - r].equals(w2[n2 - 1 - r])) {
            r++;
        }

        // If l + r >= n1, it means the whole w1 is covered.
        // Note: if "A" matches "A A", l=1, r=1. Total 2 >= 1.
        // Overlap is fine in logic: it means prefix and suffix cover the whole word.
        // Example: w1="A", w2="A". l=1, r=1. 2>=1.
        // Example: w1="A", w2="B". l=0, r=0. 0>=1 False.
        return l + r >= n1;
    }
}

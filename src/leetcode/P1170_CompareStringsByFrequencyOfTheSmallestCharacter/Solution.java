package leetcode.P1170_CompareStringsByFrequencyOfTheSmallestCharacter;

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] freqCount = new int[12]; // Max frequency is 10. Indexes 1..10 used.

        for (String w : words) {
            int f = f(w);
            freqCount[f]++;
        }

        // Suffix sum: freqCount[i] becomes count of words with freq >= i
        // Wait, query asks for words with freq > f(query).
        // So we need sum of freqCount[f(q) + 1...10].

        // Optimize: suffix[i] = words width freq >= i
        int[] suffix = new int[12];
        for (int i = 10; i >= 1; i--) {
            suffix[i] = suffix[i + 1] + freqCount[i];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int fq = f(queries[i]);
            if (fq < 10) {
                res[i] = suffix[fq + 1];
            } else {
                res[i] = 0;
            }
        }
        return res;
    }

    private int f(String s) {
        char minChar = 'z';
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c < minChar) {
                minChar = c;
                count = 1;
            } else if (c == minChar) {
                count++;
            }
        }
        return count;
    }
}

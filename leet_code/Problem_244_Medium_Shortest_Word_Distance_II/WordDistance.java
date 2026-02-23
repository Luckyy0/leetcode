package leet_code.Problem_244_Medium_Shortest_Word_Distance_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {

    private Map<String, List<Integer>> locations;

    /**
     * Initializes the WordDistance object.
     * Maps each word to its list of indices.
     * Time: O(N).
     */
    public WordDistance(String[] wordsDict) {
        locations = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            locations.computeIfAbsent(wordsDict[i], k -> new ArrayList<>()).add(i);
        }
    }

    /**
     * Returns the shortest distance between word1 and word2.
     * Uses Two Pointers algorithm on two sorted lists of indices.
     * Time: O(K + L) where K, L are occurrences of the words.
     */
    public int shortest(String word1, String word2) {
        List<Integer> loc1 = locations.get(word1);
        List<Integer> loc2 = locations.get(word2);

        int i = 0, j = 0;
        int minDistance = Integer.MAX_VALUE;

        while (i < loc1.size() && j < loc2.size()) {
            int index1 = loc1.get(i);
            int index2 = loc2.get(j);

            minDistance = Math.min(minDistance, Math.abs(index1 - index2));

            if (index1 < index2) {
                i++;
            } else {
                j++;
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        String[] words = { "practice", "makes", "perfect", "coding", "makes" };
        WordDistance obj = new WordDistance(words);

        System.out.println("Dist(coding, practice): " + obj.shortest("coding", "practice")); // 3
        System.out.println("Dist(makes, coding): " + obj.shortest("makes", "coding")); // 1
    }
}

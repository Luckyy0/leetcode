package leetcode.P950_RevealCardsInIncreasingOrder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < n; i++)
            indexQueue.add(i);

        int[] res = new int[n];
        for (int card : deck) {
            res[indexQueue.poll()] = card;
            if (!indexQueue.isEmpty()) {
                indexQueue.add(indexQueue.poll());
            }
        }

        return res;
    }
}

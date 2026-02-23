package leet_code.Problem_649_Medium_Dota2_Senate;

import java.util.*;

public class Solution_Queue {

    /**
     * Predicts which party will win the Dota2 Senate vote.
     * Strategy: Use two queues for Radiant and Dire senator indices.
     * Time: O(N), Space: O(N).
     */
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();

        // Add indices of senators to their respective queues
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        // Simulate rounds
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIdx = radiant.poll();
            int dIdx = dire.poll();

            // The one with the smaller index acts first and bans the other
            if (rIdx < dIdx) {
                // Radiant acts, Dire senator is gone. Radiant moves to the next round.
                radiant.offer(rIdx + n);
            } else {
                // Dire acts, Radiant senator is gone. Dire moves to the next round.
                dire.offer(dIdx + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        Solution_Queue sol = new Solution_Queue();
        System.out.println("Result for RD: " + sol.predictPartyVictory("RD")); // Radiant
        System.out.println("Result for RDD: " + sol.predictPartyVictory("RDD")); // Dire
    }
}

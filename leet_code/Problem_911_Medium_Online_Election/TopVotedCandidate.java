package leet_code.Problem_911_Medium_Online_Election;

import java.util.*;

/**
 * Problem 911: Online Election
 * https://leetcode.com/problems/online-election/
 */
public class TopVotedCandidate {

    // Store the times array for binary search
    private int[] times;

    // Store the leader at each time index
    // leaders[i] is the leader at time times[i]
    private int[] leaders;

    // Map to store vote counts for each person
    private Map<Integer, Integer> voteCounts;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leaders = new int[persons.length];
        this.voteCounts = new HashMap<>();

        int currentLeader = -1;
        int maxVotes = 0;

        // Iterate through each vote
        for (int i = 0; i < persons.length; i++) {
            int p = persons[i];

            // Update vote count for the person
            voteCounts.put(p, voteCounts.getOrDefault(p, 0) + 1);

            // Check if this person becomes the leader
            // Note: The rule says "In the case of a tie, the most recent vote wins."
            // So we update the leader if count >= maxVotes.
            if (voteCounts.get(p) >= maxVotes) {
                maxVotes = voteCounts.get(p);
                currentLeader = p;
            }

            // Store the leader at this time index
            leaders[i] = currentLeader;
        }
    }

    /**
     * Returns the leading candidate at time t.
     * Strategy: Binary Search to find the relevant time index.
     */
    public int q(int t) {
        // Use binary search to find the index of time t in times array
        // If t is in times, it returns the index.
        // If t is not in times, it returns -(insertion point) - 1.
        int idx = Arrays.binarySearch(times, t);

        if (idx < 0) {
            // If time t is not exactly in the array, find the index just before it.
            // Insertion point is (-idx - 1).
            // We want the index before the insertion point, which is (-idx - 2).
            idx = -idx - 2;
        }

        return leaders[idx];
    }

    public static void main(String[] args) {
        int[] persons = { 0, 1, 1, 0, 0, 1, 0 };
        int[] timesVal = { 0, 5, 10, 15, 20, 25, 30 };

        TopVotedCandidate obj = new TopVotedCandidate(persons, timesVal);

        System.out.println("Result (3): " + obj.q(3)); // 0
        System.out.println("Result (12): " + obj.q(12)); // 1
        System.out.println("Result (25): " + obj.q(25)); // 1
        System.out.println("Result (15): " + obj.q(15)); // 0
        System.out.println("Result (24): " + obj.q(24)); // 0
        System.out.println("Result (8): " + obj.q(8)); // 1
    }
}

package leetcode.P911_OnlineElection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TopVotedCandidate {
    int[] times;
    int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leaders = new int[persons.length];
        Map<Integer, Integer> counts = new HashMap<>();
        int leader = -1;
        int maxVotes = 0;

        for (int i = 0; i < persons.length; i++) {
            int p = persons[i];
            int c = counts.getOrDefault(p, 0) + 1;
            counts.put(p, c);
            if (c >= maxVotes) {
                maxVotes = c;
                leader = p;
            }
            leaders[i] = leader;
        }
    }

    public int q(int t) {
        int idx = Arrays.binarySearch(times, t);
        if (idx < 0)
            idx = -idx - 2;
        return leaders[idx];
    }
}

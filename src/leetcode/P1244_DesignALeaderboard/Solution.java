package leetcode.P1244_DesignALeaderboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Leaderboard {
    Map<Integer, Integer> scores;

    public Leaderboard() {
        scores = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        scores.put(playerId, scores.getOrDefault(playerId, 0) + score);
    }

    public int top(int K) {
        List<Integer> list = new ArrayList<>(scores.values());
        Collections.sort(list, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < K && i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public void reset(int playerId) {
        scores.remove(playerId);
    }
}

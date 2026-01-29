package leetcode.P1311_GetWatchedVideosByYourFriends;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(id);
        visited[id] = true;

        int currLevel = 0;
        while (!q.isEmpty() && currLevel < level) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int u = q.poll();
                for (int v : friends[u]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        q.offer(v);
                    }
                }
            }
            currLevel++;
        }

        Map<String, Integer> freq = new HashMap<>();
        while (!q.isEmpty()) {
            int friendId = q.poll();
            for (String video : watchedVideos.get(friendId)) {
                freq.put(video, freq.getOrDefault(video, 0) + 1);
            }
        }

        List<String> res = new ArrayList<>(freq.keySet());
        Collections.sort(res, (a, b) -> {
            int fa = freq.get(a);
            int fb = freq.get(b);
            if (fa != fb)
                return fa - fb;
            return a.compareTo(b);
        });

        return res;
    }
}

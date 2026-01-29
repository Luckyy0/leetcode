package leetcode.P1733_MinimumNumberOfPeopleToTeach;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        // user -> set of languages
        Set<Integer>[] userLangs = new Set[languages.length + 1];
        for (int i = 0; i < languages.length; i++) {
            userLangs[i + 1] = new HashSet<>();
            for (int l : languages[i]) {
                userLangs[i + 1].add(l);
            }
        }

        Set<Integer> unhappyUsers = new HashSet<>();

        for (int[] f : friendships) {
            int u = f[0];
            int v = f[1];

            boolean compatible = false;
            for (int l : userLangs[u]) {
                if (userLangs[v].contains(l)) {
                    compatible = true;
                    break;
                }
            }

            if (!compatible) {
                unhappyUsers.add(u);
                unhappyUsers.add(v);
            }
        }

        if (unhappyUsers.isEmpty())
            return 0;

        int minTeach = Integer.MAX_VALUE;

        // Try teaching language k to everyone in unhappy set who needs it
        for (int k = 1; k <= n; k++) {
            int teachCount = 0;
            for (int u : unhappyUsers) {
                if (!userLangs[u].contains(k)) {
                    teachCount++;
                }
            }
            minTeach = Math.min(minTeach, teachCount);
        }

        return minTeach;
    }
}

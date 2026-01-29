package leetcode.P1986_MinimumNumberOfWorkSessionsToFinishTheTasks;

import java.util.Arrays;

public class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int limit = 1 << n;

        // dp[mask] stores encoded {sessions, currentTime}
        // Use a single int: sessions * 10000 + currentTime (assuming currentTime <=
        // 10000? sessionTime <= 10^4?)
        // Actually sessionTime range? Usually small or reasonable. Problem constraints?
        // sessionTime <= 15 usually? Or tasks sum.
        // Let's use array of 2 ints per mask or encode.
        // Since sessions <= 14, time <= max(sessionTime).
        // Let's use separate arrays or encoded value.
        // Encoded: sessions << 20 | time.

        int[] dp = new int[limit];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 0 sessions, 0 time? No, actually usually 1 session starts at 0?
                   // Logic: completed 0 tasks needs 0 sessions with 0 time used?
                   // But "0 time used in current session" implies session active or finished?
                   // Usually state: (sessions completed fully, current session usage)
                   // Actually: number of sessions used so far. If usage > 0, it counts as 1.
                   // Let's define: (sessions, current_load). where current_load is valid if <=
                   // sessionTime.
                   // If we start a new session, sessions++. load = task.
                   // 0 mask: (1, 0).

        // To simplify, let's treat 0 mask as (1, 0) and subtract 1 at end if load is 0?
        // Or store {sessions, timeUsed}.
        // Base case: dp[0] = {1, 0}. Result is sessions. If timeUsed==0, (meaning
        // unused fresh session), decrement result?
        // Better: dp[0] = {0, 0}.
        // When adding task to {s, t}:
        // If t + task <= limit, new state {s, t + task}.
        // Else, new state {s + 1, task}.

        // Correct encoding: sessions * 20000 + time.
        // dp[0] = 0.

        for (int mask = 0; mask < limit; mask++) {
            if (dp[mask] == Integer.MAX_VALUE)
                continue;

            int sessions = dp[mask] / 20000;
            int time = dp[mask] % 20000;

            // Try adding task i
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 0) {
                    int newMask = mask | (1 << i);
                    int newSessions, newTime;

                    if (time + tasks[i] <= sessionTime) {
                        newSessions = sessions;
                        newTime = time + tasks[i];
                    } else {
                        newSessions = sessions + 1;
                        newTime = tasks[i];
                    }

                    int encoded = newSessions * 20000 + newTime;
                    if (encoded < dp[newMask]) {
                        dp[newMask] = encoded;
                    }
                }
            }
        }

        // The result is sessions. But note if time > 0, it means we are IN a session.
        // Base case {0, 0}.
        // If result is {s, t}, if t > 0, we started session s+1? No.
        // If we start new session we increment. So we use "sessions" count as index of
        // current.
        // E.g. {0, 0} --add task--> {0, task} (load ok). Means we are in session 0 (1st
        // session).
        // Correct is: session count is 1-based?
        // Let's say s represents "number of FULL sessions before current".
        // Then total sessions = s + (t > 0 ? 1 : 0).
        // Wait, logic:
        // {0, 0} + task -> {0, task}. this is 1 session.
        // {0, full} + task -> {1, task}. this is 2 sessions.
        // So return s + 1 (since t will always be > 0 for full mask, unless NO tasks).
        // If mask=0, ans 0. Else s + 1.

        int res = dp[limit - 1];
        return (res / 20000) + 1;
    }
}

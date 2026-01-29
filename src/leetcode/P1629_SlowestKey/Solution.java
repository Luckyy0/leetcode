package leetcode.P1629_SlowestKey;

public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        int maxDuration = releaseTimes[0];
        char maxChar = keysPressed.charAt(0);

        for (int i = 1; i < n; i++) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            char c = keysPressed.charAt(i);

            if (duration > maxDuration) {
                maxDuration = duration;
                maxChar = c;
            } else if (duration == maxDuration) {
                if (c > maxChar) {
                    maxChar = c;
                }
            }
        }

        return maxChar;
    }
}

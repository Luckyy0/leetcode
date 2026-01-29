package leetcode.P359_LoggerRateLimiter;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Problem 359: Logger Rate Limiter
     * Approach: HashMap
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(M)
     */
    public static class Logger {
        private Map<String, Integer> nextValidTime;

        public Logger() {
            nextValidTime = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!nextValidTime.containsKey(message) || timestamp >= nextValidTime.get(message)) {
                nextValidTime.put(message, timestamp + 10);
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Logger logger = new Logger();

        // 1, "foo" -> true
        runTest(logger, 1, "foo", true);

        // 2, "bar" -> true
        runTest(logger, 2, "bar", true);

        // 3, "foo" -> false
        runTest(logger, 3, "foo", false);

        // 8, "bar" -> false
        runTest(logger, 8, "bar", false);

        // 10, "foo" -> false
        runTest(logger, 10, "foo", false);

        // 11, "foo" -> true
        runTest(logger, 11, "foo", true);
    }

    private static void runTest(Logger l, int ts, String msg, boolean expected) {
        boolean result = l.shouldPrintMessage(ts, msg);
        System.out.println("Time: " + ts + ", Msg: " + msg + " -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}

package leet_code.Problem_681_Medium_Next_Closest_Time;

import java.util.*;

public class Solution {

    /**
     * Finds the next closest time using only digits from the input.
     * Strategy: Brute force simulation of every minute (1440 mins max).
     * Time: O(1), Space: O(1).
     */
    public String nextClosestTime(String time) {
        int minutes = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));

        Set<Integer> allowed = new HashSet<>();
        for (char c : time.toCharArray()) {
            if (c != ':') {
                allowed.add(c - '0');
            }
        }

        while (true) {
            // Move to the next minute (circularly)
            minutes = (minutes + 1) % 1440;

            // Format to HH:MM components
            int h = minutes / 60;
            int m = minutes % 60;

            int[] digits = { h / 10, h % 10, m / 10, m % 10 };

            // Check if all digits are in the allowed set
            boolean isValid = true;
            for (int d : digits) {
                if (!allowed.contains(d)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                return String.format("%02d:%02d", h, m);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 19:34: " + sol.nextClosestTime("19:34")); // 19:39
        System.out.println("Result 23:59: " + sol.nextClosestTime("23:59")); // 22:22
    }
}

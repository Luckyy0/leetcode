package leetcode.P681_NextClosestTime;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public String nextClosestTime(String time) {
        int start = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
        Set<Integer> allowed = new HashSet<>();
        for (char c : time.toCharArray()) {
            if (c != ':')
                allowed.add(c - '0');
        }

        // Simulating minute by minute (at most 1440 minutes)
        // Mô phỏng từng phút một (tối đa 1440 phút)
        int cur = start;
        while (true) {
            cur = (cur + 1) % (24 * 60);
            int[] digits = { cur / 60 / 10, cur / 60 % 10, cur % 60 / 10, cur % 60 % 10 };

            boolean valid = true;
            for (int d : digits) {
                if (!allowed.contains(d)) {
                    valid = false;
                    break;
                }
            }

            if (valid)
                return String.format("%02d:%02d", cur / 60, cur % 60);
        }
    }
}

package leetcode.P539_MinimumTimeDifference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();

        // Convert "HH:MM" to minutes
        // Chuyển đổi "HH:MM" thành phút
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            minutes.add(h * 60 + m);
        }

        // Sort the time points
        // Sắp xếp các điểm thời gian
        Collections.sort(minutes);

        int minDiff = Integer.MAX_VALUE;

        // Calculate difference between adjacent times
        // Tính chênh lệch giữa các thời gian liền kề
        for (int i = 1; i < minutes.size(); i++) {
            minDiff = Math.min(minDiff, minutes.get(i) - minutes.get(i - 1));
        }

        // Handle wrap-around (first and last element)
        // Xử lý vòng lặp (phần tử đầu và cuối)
        int lastDiff = (1440 - minutes.get(minutes.size() - 1)) + minutes.get(0);
        minDiff = Math.min(minDiff, lastDiff);

        return minDiff;
    }
}

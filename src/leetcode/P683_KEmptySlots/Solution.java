package leetcode.P683_KEmptySlots;

class Solution {
    public int kEmptySlots(int[] bulbs, int k) {
        int n = bulbs.length;
        int[] days = new int[n];

        // Convert position-at-day to day-at-position
        // Chuyển đổi vị trí-tại-ngày thành ngày-tại-vị trí
        for (int day = 0; day < n; day++) {
            days[bulbs[day] - 1] = day + 1;
        }

        int res = Integer.MAX_VALUE;
        int left = 0, right = k + 1;

        for (int i = 0; right < n; i++) {
            if (days[i] < days[left] || days[i] <= days[right]) {
                if (i == right) {
                    // Window found!
                    // Tìm thấy cửa sổ!
                    res = Math.min(res, Math.max(days[left], days[right]));
                }
                // Slide window here
                left = i;
                right = i + k + 1;
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

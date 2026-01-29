package leetcode.P731_MyCalendarII;

import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    private List<int[]> calendar;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // Check for triple booking
        // Kiểm tra việc đặt trùng ba
        for (int[] iv : overlaps) {
            if (Math.max(start, iv[0]) < Math.min(end, iv[1]))
                return false;
        }

        // Record new double bookings
        // Ghi lại các lượt đặt trùng đôi mới
        for (int[] iv : calendar) {
            int s = Math.max(start, iv[0]);
            int e = Math.min(end, iv[1]);
            if (s < e) {
                overlaps.add(new int[] { s, e });
            }
        }

        calendar.add(new int[] { start, end });
        return true;
    }
}

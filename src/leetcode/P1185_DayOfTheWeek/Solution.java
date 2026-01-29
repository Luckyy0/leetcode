package leetcode.P1185_DayOfTheWeek;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        // 1971-01-01 was Friday. Offset 5? Friday is index 5.
        // Let's use Zeller or simple count.

        // Simple count from 1971-01-01 (Friday)
        int total = 0;
        for (int y = 1971; y < year; y++) {
            total += isLeap(y) ? 366 : 365;
        }

        int[] mDays = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (isLeap(year))
            mDays[2] = 29;

        for (int m = 1; m < month; m++) {
            total += mDays[m];
        }
        total += day - 1; // 1971-01-01 is day 0 relative to itself

        // 0 days from Fri -> Fri.
        // Index of Friday is 5.
        // (5 + total) % 7
        return days[(5 + total) % 7];
    }

    private boolean isLeap(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }
}

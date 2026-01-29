package leetcode.P1154_DayOfTheYear;

class Solution {
    public int dayOfYear(String date) {
        String[] parts = date.split("-");
        int y = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int d = Integer.parseInt(parts[2]);

        int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (isLeap(y))
            days[2] = 29;

        int res = 0;
        for (int i = 1; i < m; i++) {
            res += days[i];
        }
        res += d;
        return res;
    }

    private boolean isLeap(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }
}

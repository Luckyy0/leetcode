package leetcode.P551_StudentAttendanceRecordI;

class Solution {
    public boolean checkRecord(String s) {
        int absents = 0;
        int consecutiveLates = 0;

        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absents++;
                if (absents >= 2)
                    return false;
                consecutiveLates = 0;
            } else if (c == 'L') {
                consecutiveLates++;
                if (consecutiveLates >= 3)
                    return false;
            } else {
                consecutiveLates = 0;
            }
        }

        return true;
    }
}

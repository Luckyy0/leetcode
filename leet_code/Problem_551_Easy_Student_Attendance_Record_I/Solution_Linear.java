package leet_code.Problem_551_Easy_Student_Attendance_Record_I;

public class Solution_Linear {

    /**
     * Checks if a student is eligible for an attendance award.
     * Strategy: Single pass logic.
     * Time: O(N), Space: O(1).
     */
    public boolean checkRecord(String s) {
        int absentCount = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // Criteria 1: Fewer than 2 'A's
            if (c == 'A') {
                absentCount++;
                if (absentCount >= 2)
                    return false;
            }

            // Criteria 2: No 3 or more consecutive 'L's
            if (c == 'L' && i <= n - 3) {
                if (s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_Linear solution = new Solution_Linear();
        System.out.println("Result 1: " + solution.checkRecord("PPALLP")); // true
        System.out.println("Result 2: " + solution.checkRecord("PPALLL")); // false
    }
}

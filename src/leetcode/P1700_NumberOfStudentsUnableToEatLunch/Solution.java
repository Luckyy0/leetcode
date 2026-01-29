package leetcode.P1700_NumberOfStudentsUnableToEatLunch;

public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int count0 = 0;
        int count1 = 0;

        for (int s : students) {
            if (s == 0)
                count0++;
            else
                count1++;
        }

        for (int s : sandwiches) {
            if (s == 0) {
                if (count0 > 0)
                    count0--;
                else
                    return count0 + count1;
            } else {
                if (count1 > 0)
                    count1--;
                else
                    return count0 + count1;
            }
        }

        return 0;
    }
}

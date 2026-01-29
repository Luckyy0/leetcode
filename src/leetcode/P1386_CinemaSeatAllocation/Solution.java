package leetcode.P1386_CinemaSeatAllocation;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> reserved = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            reserved.put(row, reserved.getOrDefault(row, 0) | (1 << col));
        }

        int count = (n - reserved.size()) * 2;

        for (int mask : reserved.values()) {
            boolean left = (mask & 0b00000111100) == 0; // Cols 2,3,4,5. Bit col corresponds to 1<<col.
            // Wait, 1<<col logic: seat 1 is 1<<1=2. seat 10 is 1<<10.
            // Cols 2,3,4,5: (1<<2)|(1<<3)|(1<<4)|(1<<5) = 4|8|16|32 = 60.
            // Cols 6,7,8,9: (1<<6)|(1<<7)|(1<<8)|(1<<9) = 64|128|256|512 = 960.
            // Cols 4,5,6,7: (1<<4)|(1<<5)|(1<<6)|(1<<7) = 16|32|64|128 = 240.

            boolean l = (mask & 60) == 0;
            boolean r = (mask & 960) == 0;
            boolean m = (mask & 240) == 0;

            if (l && r) {
                count += 2;
            } else if (l || r || m) {
                count += 1;
            }
        }

        return count;
    }
}

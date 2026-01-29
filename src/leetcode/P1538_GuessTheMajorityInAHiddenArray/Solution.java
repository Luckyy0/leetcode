package leetcode.P1538_GuessTheMajorityInAHiddenArray;

interface ArrayReader {
    public int query(int a, int b, int c, int d);

    public int length();
}

class Solution {
    public int guessMajority(ArrayReader reader) {
        int n = reader.length();
        int q0123 = reader.query(0, 1, 2, 3);
        int q0124 = reader.query(0, 1, 2, 4);
        int q0134 = reader.query(0, 1, 3, 4);
        int q0234 = reader.query(0, 2, 3, 4);
        int q1234 = reader.query(1, 2, 3, 4);

        // Relationship to nums[4] is easier to establish?
        // Or relationships to nums[3].

        // q0123 uses 3. q0124 uses 4. If q0123 == q0124 => nums[3] == nums[4].
        // q0124 uses 2. q0134 uses 3. If q0124 == q0134 => nums[2] == nums[3].
        // q0134 uses 1. q0234 uses 2. If q0134 == q0234 => nums[1] == nums[2].
        // q0234 uses 0. q1234 uses 1. If q0234 == q1234 => nums[0] == nums[1].

        // Let's assume Group A is same as nums[3] (index 3).
        int countA = 1; // Index 3 is in A
        int countB = 0;
        int idxA = 3;
        int idxB = -1;

        // Check 4
        if (q0123 == q0124) {
            countA++;
        } else {
            countB++;
            idxB = 4;
        }

        // Check 2
        // compare q0124 (has 2) vs q0134 (has 3).
        // Since we know 3 is in A.
        if (q0124 == q0134) {
            countA++;
        } else {
            countB++;
            idxB = 2;
        }

        // Check 1
        // compare q0134 (has 1) vs q0234 (has 2). Wait.
        // Better: compare q0234 (has 0,2,3,4) vs q1234 (has 1,2,3,4).
        // But we need to relate to 3.
        // Simplest: Relative to 3 is easiest for i >= 4.
        // For 0,1,2:
        // 2: q0124 vs q0134 (swapping 2 and 3). YES.
        // 1: q0124 vs q0234 (swapping 1 and 3? No, swapping 1 and ?).
        // q0124 (0,1,2,4). q0234 (0,2,3,4). Swapped 1 for 3?
        // Yes. q0124 has 1, no 3. q0234 has 3, no 1.
        // If q0124 == q0234 => nums[1] == nums[3].
        if (q0124 == q0234) {
            countA++;
        } else {
            countB++;
            idxB = 1;
        }

        // 0: q0124 (has 0) vs q1234 (has 3? No, q1234 has 1,2,3,4).
        // q0124 has 0,1,2,4. q1234 has 1,2,3,4.
        // Swapped 0 for 3.
        // If q0124 == q1234 => nums[0] == nums[3].
        if (q0124 == q1234) {
            countA++;
        } else {
            countB++;
            idxB = 0;
        }

        // Now check remaining i from 5 to n-1
        for (int i = 5; i < n; i++) {
            // Relate to nums[3].
            // Base: q0123 (has 3). New: q012i (has i).
            // Compare q0123 and q012i?
            // query(0, 1, 2, i).
            if (reader.query(0, 1, 2, i) == q0123) {
                countA++;
            } else {
                countB++;
                idxB = i;
            }
        }

        if (countA > countB)
            return idxA;
        if (countB > countA)
            return idxB;
        return -1;
    }
}

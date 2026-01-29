package leetcode.P927_ThreeEqualParts;

class Solution {
    public int[] threeEqualParts(int[] arr) {
        int ones = 0;
        for (int x : arr)
            if (x == 1)
                ones++;

        if (ones == 0)
            return new int[] { 0, 2 };
        if (ones % 3 != 0)
            return new int[] { -1, -1 };

        int k = ones / 3;
        int p1 = -1, p2 = -1, p3 = -1;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                if (count == 1)
                    p1 = i;
                else if (count == k + 1)
                    p2 = i;
                else if (count == 2 * k + 1)
                    p3 = i;
            }
        }

        while (p3 < arr.length) {
            if (arr[p1] != arr[p2] || arr[p2] != arr[p3])
                return new int[] { -1, -1 };
            p1++;
            p2++;
            p3++;
        }

        return new int[] { p1 - 1, p2 };
    }
}

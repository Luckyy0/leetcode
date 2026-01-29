package leetcode.P1533_FindTheIndexOfTheLargeInteger;

interface ArrayReader {
    // Compares the sum of arr[l..r] with the sum of arr[x..y]
    // return 1 if sum(arr[l..r]) > sum(arr[x..y])
    // return 0 if sum(arr[l..r]) == sum(arr[x..y])
    // return -1 if sum(arr[l..r]) < sum(arr[x..y])
    public int compareSub(int l, int r, int x, int y);

    public int length();
}

class Solution {
    public int getIndex(ArrayReader reader) {
        int left = 0;
        int right = reader.length() - 1;

        while (left < right) {
            int len = right - left + 1;
            int half = len / 2;

            // If len is odd, we compare ranges excluding middle element
            // Middle element is left + half
            // Left range: [left, left + half - 1]
            // Right range: [left + half + 1, right]

            // If len is even, ranges cover everything
            // Left range: [left, left + half - 1]
            // Right range: [left + half, right]

            int rStart = (len % 2 == 0) ? (left + half) : (left + half + 1);
            int cmp = reader.compareSub(left, left + half - 1, rStart, right);

            if (cmp == 0) {
                // Only possible if len is odd and max is the middle excluded element
                return left + half;
            } else if (cmp > 0) {
                // Max in left part
                right = left + half - 1;
            } else {
                // Max in right part
                left = rStart;
            }
        }

        return left;
    }
}

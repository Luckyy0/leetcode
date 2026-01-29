package leetcode.P1064_FixedPoint;

class Solution {
    public int fixedPoint(int[] arr) {
        int left = 0, right = arr.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= mid) {
                if (arr[mid] == mid)
                    ans = mid;
                right = mid - 1; // Try to find smaller index
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}

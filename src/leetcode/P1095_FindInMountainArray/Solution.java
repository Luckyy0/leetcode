package leetcode.P1095_FindInMountainArray;

interface MountainArray {
    public int get(int index);

    public int length();
}

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        // 1. Find Peak
        int left = 0, right = n - 1;
        int peak = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        peak = left;

        // 2. Search Left (Ascending)
        int idx = binarySearch(mountainArr, target, 0, peak, true);
        if (idx != -1)
            return idx;

        // 3. Search Right (Descending)
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }

    private int binarySearch(MountainArray arr, int target, int l, int r, boolean asc) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int val = arr.get(mid);
            if (val == target)
                return mid;

            if (asc) {
                if (val < target)
                    l = mid + 1;
                else
                    r = mid - 1;
            } else {
                if (val < target)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return -1;
    }
}

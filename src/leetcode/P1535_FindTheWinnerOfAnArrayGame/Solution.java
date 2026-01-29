package leetcode.P1535_FindTheWinnerOfAnArrayGame;

class Solution {
    public int getWinner(int[] arr, int k) {
        int curr = arr[0];
        int streak = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > curr) {
                curr = arr[i];
                streak = 1;
            } else {
                streak++;
            }

            if (streak == k)
                return curr;
        }

        return curr;
    }
}

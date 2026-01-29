package leetcode.P1089_DuplicateZeros;

class Solution {
    public void duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;

        // Find the boundary of elements that will fit
        for (int left = 0; left <= length_ - possibleDups; left++) {
            if (arr[left] == 0) {
                // Edge case: This zero is the last element to fit, but no space for duplicate
                if (left == length_ - possibleDups) {
                    arr[length_] = 0; // Copy the single zero
                    length_ -= 1; // Shrink destination size
                    break;
                }
                possibleDups++;
            }
        }

        // Start copying from the last possible element backwards
        int last = length_ - possibleDups;

        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
}

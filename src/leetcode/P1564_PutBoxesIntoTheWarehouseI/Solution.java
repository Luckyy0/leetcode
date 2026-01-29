package leetcode.P1564_PutBoxesIntoTheWarehouseI;

import java.util.Arrays;

public class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        // Preprocess warehouse to store effective heights
        // warehouse[i] becomes min(warehouse[0...i])
        for (int i = 1; i < warehouse.length; i++) {
            warehouse[i] = Math.min(warehouse[i], warehouse[i - 1]);
        }

        // Sort boxes to process greedy
        Arrays.sort(boxes);

        int boxIdx = 0;
        int count = 0;
        // Iterate warehouse from right (deepest) to left
        // warehouse[i] is effective height, so w[0] >= w[1] >= ... >= w[n-1]
        // This means iterating right to left is going Smallest Room -> Largest Room

        for (int i = warehouse.length - 1; i >= 0; i--) {
            // Check if current smallest available box fits in current room
            if (boxIdx < boxes.length && boxes[boxIdx] <= warehouse[i]) {
                count++;
                boxIdx++;
            }
            // If it doesn't fit, we skip this room (it's too small for current box and any
            // bigger box)
            // Implicitly i-- in loop
        }

        return count;
    }
}

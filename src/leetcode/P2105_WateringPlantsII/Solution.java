package leetcode.P2105_WateringPlantsII;

public class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int curA = capacityA;
        int curB = capacityB;
        int refills = 0;

        int l = 0, r = n - 1;
        while (l < r) {
            // Alice
            if (curA < plants[l]) {
                refills++;
                curA = capacityA;
            }
            curA -= plants[l];

            // Bob
            if (curB < plants[r]) {
                refills++;
                curB = capacityB;
            }
            curB -= plants[r];

            l++;
            r--;
        }

        if (l == r) {
            // Meeting point
            if (curA >= curB) {
                // Alice
                if (curA < plants[l])
                    refills++;
            } else {
                // Bob
                if (curB < plants[l])
                    refills++;
            }
        }

        return refills;
    }
}

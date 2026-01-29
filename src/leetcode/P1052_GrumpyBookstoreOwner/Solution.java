package leetcode.P1052_GrumpyBookstoreOwner;

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int baseSatisfaction = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                baseSatisfaction += customers[i];
            }
        }

        int currentRecovered = 0;
        // Init window
        for (int i = 0; i < minutes && i < customers.length; i++) {
            if (grumpy[i] == 1) {
                currentRecovered += customers[i];
            }
        }

        int maxRecovered = currentRecovered;

        // Slide window
        for (int i = minutes; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                currentRecovered += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                currentRecovered -= customers[i - minutes];
            }
            maxRecovered = Math.max(maxRecovered, currentRecovered);
        }

        return baseSatisfaction + maxRecovered;
    }
}

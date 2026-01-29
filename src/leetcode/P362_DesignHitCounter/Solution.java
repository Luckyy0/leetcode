package leetcode.P362_DesignHitCounter;

public class Solution {

    /**
     * Problem 362: Design Hit Counter
     * Approach: Circular Buffer (Buckets)
     * 
     * Time Complexity: O(1) hit, O(300) getHits -> O(1)
     * Space Complexity: O(300) -> O(1)
     */
    public static class HitCounter {
        private int[] times;
        private int[] hits;

        public HitCounter() {
            times = new int[300];
            hits = new int[300];
        }

        public void hit(int timestamp) {
            int index = timestamp % 300;
            if (times[index] != timestamp) {
                times[index] = timestamp;
                hits[index] = 1;
            } else {
                hits[index]++;
            }
        }

        public int getHits(int timestamp) {
            int total = 0;
            for (int i = 0; i < 300; i++) {
                if (timestamp - times[i] < 300) {
                    total += hits[i];
                }
            }
            return total;
        }
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();

        // hit 1, 2, 3
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);

        // getHits(4) -> 3
        System.out.println("getHits(4): " + counter.getHits(4) + " (Expected: 3)");

        // hit 300
        counter.hit(300);

        // getHits(300) -> 4 (1, 2, 3, 300 are all in [1, 300])
        System.out.println("getHits(300): " + counter.getHits(300) + " (Expected: 4)");

        // getHits(301) -> 3 (1 is expired. Window [2, 301]. Hits: 2, 3, 300)
        System.out.println("getHits(301): " + counter.getHits(301) + " (Expected: 3)");
    }
}

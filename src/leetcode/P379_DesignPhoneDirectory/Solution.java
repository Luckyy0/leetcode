package leetcode.P379_DesignPhoneDirectory;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * Problem 379: Design Phone Directory
     * Approach: Queue + Boolean Array
     * 
     * Time Complexity: O(1) ops, O(N) init
     * Space Complexity: O(N)
     */
    public static class PhoneDirectory {
        private Queue<Integer> available;
        private boolean[] used;
        private int max;

        public PhoneDirectory(int maxNumbers) {
            this.max = maxNumbers;
            this.available = new LinkedList<>();
            this.used = new boolean[maxNumbers];

            for (int i = 0; i < maxNumbers; i++) {
                available.offer(i);
            }
        }

        public int get() {
            if (available.isEmpty()) {
                return -1;
            }
            int number = available.poll();
            used[number] = true;
            return number;
        }

        public boolean check(int number) {
            if (number < 0 || number >= max) {
                return false;
            }
            return !used[number];
        }

        public void release(int number) {
            if (number < 0 || number >= max) {
                return;
            }
            if (used[number]) {
                used[number] = false;
                available.offer(number);
            }
        }
    }

    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory(3);

        // get -> 0
        System.out.println("get: " + directory.get());

        // get -> 1
        System.out.println("get: " + directory.get());

        // check(2) -> true
        System.out.println("check(2): " + directory.check(2));

        // get -> 2
        System.out.println("get: " + directory.get());

        // check(2) -> false
        System.out.println("check(2): " + directory.check(2));

        // release(2)
        directory.release(2);
        System.out.println("release(2)");

        // check(2) -> true
        System.out.println("check(2): " + directory.check(2));
    }
}

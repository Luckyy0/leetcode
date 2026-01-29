package leetcode.P2102_SequentiallyOrdinalRankTracker;

import java.util.PriorityQueue;

public class SORTracker {

    static class Location implements Comparable<Location> {
        String name;
        int score;

        Location(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Location other) {
            // "Better" means Higher Score, or Lower Name
            if (this.score != other.score) {
                return Integer.compare(other.score, this.score); // DESC score
            }
            return this.name.compareTo(other.name); // ASC name
        }
    }

    // left stores the top k-1 elements.
    // It should be a Min-Heap of "Goodness", so head is the "Worst" of the Best.
    // Since Location.compareTo defines "Better" as smaller (negative), Max-Heap of
    // Location!
    // Wait. My compareTo returns Negative if 'this' is Better.
    // So 'this' < 'other' means 'this' is Better.
    // Min-Heap (default PQ) will keep the "Better" ones at top.
    // Max-Heap (reversed) will keep the "Worse" ones at top.

    // Left Set (Best k-1): Needs to pop the Worst of them.
    // Worst means Largest in compareTo order.
    // So Left is Max-Heap (Collections.reverseOrder()).

    // Right Set (Rest): Needs to pop the Best of them (Rank k).
    // Best means Smallest in compareTo order.
    // So Right is Min-Heap (default).

    PriorityQueue<Location> left;
    PriorityQueue<Location> right;

    public SORTracker() {
        left = new PriorityQueue<>((a, b) -> b.compareTo(a)); // Max-Heap (WORST of BEST at top)
        right = new PriorityQueue<>(); // Min-Heap (BEST of REST at top)
    }

    public void add(String name, int score) {
        Location loc = new Location(name, score);

        // Add to right initially
        right.add(loc);

        // Balance: Left must have k-1 elements. Right has others.
        // We just added to right.
        // We ensure Left still has correct size?
        // Wait. k is dynamic.
        // The check is: Does the new element belong in Left?
        // If new element is Better than Left's worst, swap.
        // Left.peek is Worst of Best. Right.peek is Best of Rest.
        // Invariant: Left.peek() < Right.peek() (Left is better than Right).
        // Actually Left elements < Right elements.
        // Since we insert to Right, we might violate.
        // Check:

        Location bestOfRest = right.peek();

        // If left is empty, we are fine (k=1).
        if (!left.isEmpty()) {
            Location worstOfBest = left.peek();
            // We want worstOfBest to be Better (<) than bestOfRest.
            // If worstOfBest > bestOfRest, swap.
            if (worstOfBest.compareTo(bestOfRest) > 0) {
                right.poll();
                left.poll();
                right.add(worstOfBest);
                left.add(bestOfRest);
            }
        }
    }

    public String get() {
        Location res = right.peek();

        // k increases by 1.
        // Move best of Right to Left.
        left.add(right.poll());

        return res.name;
    }
}

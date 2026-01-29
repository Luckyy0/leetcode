package leetcode.P1206_DesignSkiplist;

import java.util.Random;

class Skiplist {
    class Node {
        int val;
        Node[] next;

        Node(int val, int level) {
            this.val = val;
            next = new Node[level];
        }
    }

    private static final int MAX_LEVEL = 16;
    private Node head;
    private int currLevel;
    private Random rand;

    public Skiplist() {
        head = new Node(-1, MAX_LEVEL);
        currLevel = 0;
        rand = new Random();
    }

    public boolean search(int target) {
        Node curr = head;
        for (int i = currLevel; i >= 0; i--) {
            while (curr.next[i] != null && curr.next[i].val < target) {
                curr = curr.next[i];
            }
        }
        curr = curr.next[0];
        return curr != null && curr.val == target;
    }

    public void add(int num) {
        int level = randomLevel();
        if (level > currLevel) {
            currLevel = level;
        }

        Node newNode = new Node(num, level + 1);
        Node curr = head;
        for (int i = currLevel; i >= 0; i--) {
            while (curr.next[i] != null && curr.next[i].val < num) {
                curr = curr.next[i];
            }
            if (i <= level) {
                newNode.next[i] = curr.next[i];
                curr.next[i] = newNode;
            }
        }
    }

    public boolean erase(int num) {
        Node curr = head;
        boolean found = false;
        Node targetNode = null;

        // Find node but also keep track to remove pointers
        // Unlike add, we can't just find links. We need exact path.
        // Actually same logic: traverse, if next is target, update next.
        // But need to be careful if multiple same values exist. First instance?
        // Skiplist usually allows duplicates.

        // We can traverse from top, and use an array to store `update` nodes like
        // classic impl.
        Node[] update = new Node[MAX_LEVEL];
        for (int i = currLevel; i >= 0; i--) {
            while (curr.next[i] != null && curr.next[i].val < num) {
                curr = curr.next[i];
            }
            update[i] = curr;
        }

        curr = curr.next[0];
        if (curr != null && curr.val == num) {
            // Found. Delete.
            for (int i = 0; i <= currLevel; i++) {
                if (update[i].next[i] != curr)
                    break;
                update[i].next[i] = curr.next[i];
            }

            // Decrease level if needed
            while (currLevel > 0 && head.next[currLevel] == null) {
                currLevel--;
            }
            return true;
        }
        return false;
    }

    private int randomLevel() {
        int lvl = 0;
        while (lvl < MAX_LEVEL - 1 && rand.nextDouble() < 0.5) {
            lvl++;
        }
        return lvl;
    }
}

package leetcode.P705_DesignHashSet;

class MyHashSet {
    private boolean[] set;

    public MyHashSet() {
        // Range is 0 to 1,000,000 according to typical LeetCode constraint
        set = new boolean[1000001];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }
}

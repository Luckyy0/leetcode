package leetcode.P2158_AmountOfNewAreaPaintedEachDay;

public class Solution {
    class SegmentTree {
        int[] tree;
        boolean[] lazy;
        int n;

        public SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
            lazy = new boolean[4 * n];
        }

        public int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l)
                return 0;

            if (lazy[node]) {
                // If lazy is set, it means this whole range is full (painted)
                // We should propagate if not leaf, but for query we can just return
                // intersection length
                int overlapStart = Math.max(start, l);
                int overlapEnd = Math.min(end, r);
                return Math.max(0, overlapEnd - overlapStart + 1);
            }

            if (l <= start && end <= r) {
                return tree[node];
            }

            int mid = (start + end) / 2;
            return query(2 * node, start, mid, l, r) + query(2 * node + 1, mid + 1, end, l, r);
        }

        public void update(int node, int start, int end, int l, int r) {
            if (r < start || end < l)
                return;

            if (l <= start && end <= r) {
                tree[node] = (end - start + 1);
                lazy[node] = true;
                return;
            }

            if (lazy[node])
                return; // Already fully painted, no need to update sub-parts

            int mid = (start + end) / 2;
            update(2 * node, start, mid, l, r);
            update(2 * node + 1, mid + 1, end, l, r);

            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    public int[] amountPainted(int[][] paint) {
        int maxCoord = 0;
        for (int[] p : paint)
            maxCoord = Math.max(maxCoord, p[1]);

        SegmentTree st = new SegmentTree(maxCoord + 1);
        int[] res = new int[paint.length];

        for (int i = 0; i < paint.length; i++) {
            int start = paint[i][0];
            int end = paint[i][1] - 1; // interval [start, end) corresponds to indices start...end-1

            int existing = st.query(1, 0, maxCoord, start, end);
            int len = end - start + 1;
            res[i] = len - existing;

            st.update(1, 0, maxCoord, start, end);
        }

        return res;
    }
}

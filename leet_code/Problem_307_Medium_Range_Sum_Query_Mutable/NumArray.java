package leet_code.Problem_307_Medium_Range_Sum_Query_Mutable;

public class NumArray {

    private int[] tree; // Fenwick Tree (1-based)
    private int[] nums; // Keep track of current values to calculate delta
    private int n;

    /**
     * Initializes with the input array.
     * Builds the BIT.
     * Time: O(N log N) or O(N), Space: O(N).
     * 
     * Khởi tạo với mảng đầu vào.
     * Xây dựng BIT.
     */
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = new int[n];
        this.tree = new int[n + 1];

        // Build the tree by updating element by element
        // Or copy array and init O(N). Simple update O(N log N) is fine.
        // Xây dựng cây bằng cách cập nhật từng phần tử.
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    /**
     * Updates the value at index.
     * Time: O(log N).
     * 
     * Cập nhật giá trị tại index.
     */
    public void update(int index, int val) {
        int delta = val - nums[index];
        nums[index] = val; // Update stored value

        // Update BIT
        // BIT index = index + 1
        int i = index + 1;
        while (i <= n) {
            tree[i] += delta;
            i += i & (-i); // Move to parent (next range covering this)
        }
    }

    /**
     * Returns sum in range [left, right].
     * Time: O(log N).
     * 
     * Trả về tổng trong phạm vi [left, right].
     */
    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }

    // Returns prefix sum [0...i-1] (BIT index i)
    private int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & (-i); // Move to child (previous range)
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5 };
        NumArray obj = new NumArray(nums);

        System.out.println("Sum(0, 2): " + obj.sumRange(0, 2)); // 9
        obj.update(1, 2);
        System.out.println("Sum(0, 2): " + obj.sumRange(0, 2)); // 8
    }
}

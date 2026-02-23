package leet_code.Problem_46_Medium_Permutations;

public class Solution_Backtracking {

    static class MyArrayList<T> {
        Object[] elements;
        int size;

        public MyArrayList() {
            elements = new Object[10];
            size = 0;
        }

        public MyArrayList(MyArrayList<T> other) {
            this.elements = new Object[other.size];
            this.size = other.size;
            System.arraycopy(other.elements, 0, this.elements, 0, other.size);
        }

        public void add(T e) {
            if (size == elements.length) {
                Object[] newE = new Object[elements.length * 2];
                System.arraycopy(elements, 0, newE, 0, size);
                elements = newE;
            }
            elements[size++] = e;
        }

        public void removeLast() {
            if (size > 0)
                size--;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                sb.append(elements[i]);
                if (i < size - 1)
                    sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    /**
     * Generates all possible permutations of distinct integers.
     * Uses Backtracking.
     * Tạo tất cả các hoán vị có thể có của các số nguyên phân biệt.
     * Sử dụng Quay lui.
     */
    public MyArrayList<MyArrayList<Integer>> permute(int[] nums) {
        MyArrayList<MyArrayList<Integer>> result = new MyArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new MyArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, MyArrayList<Integer> current, boolean[] used,
            MyArrayList<MyArrayList<Integer>> result) {
        // If current permutation is complete
        // Nếu hoán vị hiện tại đã hoàn thành
        if (current.size == nums.length) {
            result.add(new MyArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                // Choose the number
                // Chọn số
                used[i] = true;
                current.add(nums[i]);

                // Recurse
                // Đệ quy
                backtrack(nums, current, used, result);

                // Backtrack
                // Quay lui
                current.removeLast();
                used[i] = false;
            }
        }
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1
        int[] n1 = { 1, 2, 3 };
        System.out.println("Test Case 1: " + solution.permute(n1));
        // Expected: All 6 permutations

        // Test Case 2
        int[] n2 = { 0, 1 };
        System.out.println("Test Case 2: " + solution.permute(n2));
        // Expected: [[0, 1], [1, 0]]
    }
}

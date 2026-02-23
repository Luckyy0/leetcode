package leet_code.Problem_47_Medium_Permutations_II;

import java.util.Arrays;

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
     * Generates all unique permutations of a collection that may contain
     * duplicates.
     * Uses Backtracking with pruning.
     * Tạo tất cả các hoán vị duy nhất của một tập hợp có thể chứa các phần tử trùng
     * lặp.
     * Sử dụng Quay lui với cắt tỉa.
     */
    public MyArrayList<MyArrayList<Integer>> permuteUnique(int[] nums) {
        MyArrayList<MyArrayList<Integer>> result = new MyArrayList<>();
        Arrays.sort(nums); // Sort to group duplicates
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new MyArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, MyArrayList<Integer> current, boolean[] used,
            MyArrayList<MyArrayList<Integer>> result) {
        if (current.size == nums.length) {
            result.add(new MyArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            // If current element is same as previous and previous hasn't been used yet
            // skip it to avoid duplicates at this level.
            // Nếu phần tử hiện tại giống phần tử trước đó và phần tử trước đó chưa được sử
            // dụng,
            // hãy bỏ qua nó để tránh các hoán vị trùng lặp tại cấp độ này.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, current, used, result);
            current.removeLast();
            used[i] = false;
        }
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1
        int[] n1 = { 1, 1, 2 };
        System.out.println("Test Case 1: " + solution.permuteUnique(n1));
        // Expected: [[1, 1, 2], [1, 2, 1], [2, 1, 1]]

        // Test Case 2
        int[] n2 = { 1, 2, 3 };
        System.out.println("Test Case 2: " + solution.permuteUnique(n2));
        // Expected: 6 permutations
    }
}

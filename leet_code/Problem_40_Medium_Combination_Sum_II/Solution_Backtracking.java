package leet_code.Problem_40_Medium_Combination_Sum_II;

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
     * Finds all unique combinations that sum to target.
     * Uses Backtracking (DFS) with pruning for duplicates.
     * Tìm tất cả các tổ hợp duy nhất có tổng bằng target.
     * Sử dụng Quay lui (DFS) với việc cắt tỉa các phần tử trùng lặp.
     */
    public MyArrayList<MyArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        MyArrayList<MyArrayList<Integer>> result = new MyArrayList<>();
        MyArrayList<Integer> currentCombination = new MyArrayList<>();

        // Sorting is necessary to handle duplicates efficiently
        // Sắp xếp là cần thiết để xử lý các phần tử trùng lặp một cách hiệu quả
        Arrays.sort(candidates);

        backtrack(candidates, target, 0, currentCombination, result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int index,
            MyArrayList<Integer> current, MyArrayList<MyArrayList<Integer>> result) {
        if (target == 0) {
            result.add(new MyArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // Pruning: skip duplicates at the same level of recursion
            // Cắt tỉa: bỏ qua các số trùng lặp ở cùng một cấp độ đệ quy
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Pruning: if candidate is greater than remaining target, stop (array is
            // sorted)
            // Cắt tỉa: nếu ứng viên lớn hơn mục tiêu còn lại, dừng lại (mảng đã được sắp
            // xếp)
            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, current, result);
            current.removeLast();
        }
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1
        int[] c1 = { 10, 1, 2, 7, 6, 1, 5 };
        int t1 = 8;
        System.out.println("Test Case 1: " + solution.combinationSum2(c1, t1));
        // Expected: [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]

        // Test Case 2
        int[] c2 = { 2, 5, 2, 1, 2 };
        int t2 = 5;
        System.out.println("Test Case 2: " + solution.combinationSum2(c2, t2));
        // Expected: [[1, 2, 2], [5]]
    }
}

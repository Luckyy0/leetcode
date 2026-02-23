package leet_code.Problem_39_Medium_Combination_Sum;

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
     * Uses Backtracking (DFS).
     * Tìm tất cả các tổ hợp duy nhất có tổng bằng target.
     * Sử dụng Quay lui (DFS).
     */
    public MyArrayList<MyArrayList<Integer>> combinationSum(int[] candidates, int target) {
        MyArrayList<MyArrayList<Integer>> result = new MyArrayList<>();
        MyArrayList<Integer> currentCombination = new MyArrayList<>();
        backtrack(candidates, target, 0, currentCombination, result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int index,
            MyArrayList<Integer> current, MyArrayList<MyArrayList<Integer>> result) {
        // Base case: target is reached
        // Trường hợp cơ sở: đạt được mục tiêu
        if (target == 0) {
            result.add(new MyArrayList<>(current));
            return;
        }

        // Base case: target exceeded or no more candidates
        // Trường hợp cơ sở: vượt quá mục tiêu hoặc không còn ứng viên
        if (target < 0 || index == candidates.length) {
            return;
        }

        // Include candidates[index]
        // Chọn candidates[index]
        current.add(candidates[index]);
        backtrack(candidates, target - candidates[index], index, current, result);

        // Backtrack: Remove candidates[index]
        // Quay lui: Loại bỏ candidates[index]
        current.removeLast();

        // Skip candidates[index] and move to next
        // Bỏ qua candidates[index] và di chuyển đến phần tử tiếp theo
        backtrack(candidates, target, index + 1, current, result);
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1
        int[] c1 = { 2, 3, 6, 7 };
        int t1 = 7;
        System.out.println("Test Case 1: " + solution.combinationSum(c1, t1));
        // Expected: [[2, 2, 3], [7]]

        // Test Case 2
        int[] c2 = { 2, 3, 5 };
        int t2 = 8;
        System.out.println("Test Case 2: " + solution.combinationSum(c2, t2));
        // Expected: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]

        // Test Case 3
        int[] c3 = { 2 };
        int t3 = 1;
        System.out.println("Test Case 3: " + solution.combinationSum(c3, t3));
        // Expected: []
    }
}

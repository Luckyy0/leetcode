package leetcode.P526_BeautifulArrangement;

class Solution {
    int count = 0;

    public int countArrangement(int n) {
        // Initialize the counting variable
        // Khởi tạo biến đếm
        count = 0;

        // Boolean array to keep track of visited numbers (1 to n)
        // Mảng boolean để theo dõi các số đã thăm (1 đến n)
        boolean[] visited = new boolean[n + 1];

        // Start backtracking from position 1
        // Bắt đầu quay lui từ vị trí 1
        backtrack(visited, n, 1);

        return count;
    }

    private void backtrack(boolean[] visited, int n, int pos) {
        // Base case: if we have filled all positions
        // Trường hợp cơ sở: nếu chúng ta đã điền tất cả các vị trí
        if (pos > n) {
            count++;
            return;
        }

        // Try placing number 'i' at 'pos'
        // Thử đặt số 'i' tại 'pos'
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                // Check divisibility condition
                // Kiểm tra điều kiện chia hết
                if (i % pos == 0 || pos % i == 0) {
                    visited[i] = true;
                    backtrack(visited, n, pos + 1);
                    visited[i] = false; // backtrack / quay lui
                }
            }
        }
    }
}

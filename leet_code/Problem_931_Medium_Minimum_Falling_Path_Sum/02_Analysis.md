# Analysis for Minimum Falling Path Sum
# *Phân tích cho bài toán Tổng Đường đi Rơi Tối thiểu*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the minimum sum path from the top row to the bottom row, moving down, down-left, or down-right.
*Tìm đường đi có tổng nhỏ nhất từ hàng trên cùng đến hàng dưới cùng, di chuyển xuống, xuống trái hoặc xuống phải.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- This is a classic **Dynamic Programming** problem.
- To reach `(r, c)`, we must come from `(r-1, c-1)`, `(r-1, c)`, or `(r-1, c+1)`.
- `dp[r][c] = matrix[r][c] + min(dp[r-1][c-1], dp[r-1][c], dp[r-1][c+1])`.
- Handle boundary checks for columns.
- The base case is the first row: `dp[0][c] = matrix[0][c]`.
- The answer is `min(dp[n-1][c])`.
- Space Optimization: Can modify the matrix in-place or use just two rows (current and previous). Given constraints $N \le 100$, in-place modification is fine if allowed, or just allocate $O(N^2)$ or $O(N)$.
*Đây là bài toán Quy hoạch động cổ điển. Để đến được `(r, c)`, ta phải đến từ `(r-1, c-1)`, `(r-1, c)`, hoặc `(r-1, c+1)`. Tối ưu hóa không gian bằng cách sửa đổi ma trận tại chỗ hoặc dùng 2 hàng.*

---

## 2. Strategy: Dynamic Programming (Bottom-Up)
## *2. Chiến lược: Quy hoạch Động (Từ dưới lên)*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Iterate:** Rows from 1 to `n-1`. Cols from 0 to `n-1`.
    *   **Duyệt:** Hàng từ 1 đến `n-1`. Cột từ 0 đến `n-1`.*

2.  **Calculate:**
    - `minPrev = matrix[r-1][c]`.
    - If `c > 0`: `minPrev = min(minPrev, matrix[r-1][c-1])`.
    - If `c < n - 1`: `minPrev = min(minPrev, matrix[r-1][c+1])`.
    - `matrix[r][c] += minPrev`.
    *   **Tính toán:** Cộng giá trị nhỏ nhất của 3 ô phía trên vào ô hiện tại.*

3.  **Find Min:** Traverse the last row to find the global minimum.
    *   **Tìm Min:** Duyệt hàng cuối cùng để tìm giá trị nhỏ nhất toàn cục.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    
    // Start from the second row
    for (int r = 1; r < n; r++) {
        for (int c = 0; c < n; c++) {
            // Option 1: Directly above
            int minPrev = matrix[r - 1][c];
            
            // Option 2: Upper left
            if (c > 0) {
                minPrev = Math.min(minPrev, matrix[r - 1][c - 1]);
            }
            
            // Option 3: Upper right
            if (c < n - 1) {
                minPrev = Math.min(minPrev, matrix[r - 1][c + 1]);
            }
            
            // Add to current cell
            matrix[r][c] += minPrev;
        }
    }
    
    // Find min in the last row
    int result = Integer.MAX_VALUE;
    for (int x : matrix[n - 1]) {
        result = Math.min(result, x);
    }
    
    return result;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$. Visit every cell once.
    *   **Độ phức tạp thời gian:** $O(N^2)$.*
*   **Space Complexity:** $O(1)$. In-place modification.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Straightforward DP. Modifying the input matrix saves space.
*DP trực tiếp. Sửa đổi ma trận đầu vào giúp tiết kiệm không gian.*

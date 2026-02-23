# Analysis for Delete Columns to Make Sorted III
# *Phân tích cho bài toán Xóa Cột để Thực hiện Sắp xếp III*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find minimum deletions so that *each row* becomes lexicographically sorted.
*Tìm số lượng cột xóa tối thiểu sao cho *mỗi hàng* đều được sắp xếp theo thứ tự từ điển.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- This problem is equivalent to finding the **Longest Common Subsequence of Columns** such that every row is non-decreasing using only those columns.
- Or more precisely: Finding the **Longest Increasing Subsequence (LIS)** but generalized for ALL rows simultaneously.
- Let `dp[i]` be the length of the longest valid increasing subsequence of columns ending at column `i`.
- For each column `i`, iterate through all previous columns `j < i`.
- If `strs[k][j] <= strs[k][i]` for ALL rows `k`, then we can extend the subsequence ending at `j` with `i`.
- `dp[i] = max(dp[j]) + 1` for all valid `j`.
- The minimum deletions = `Total Columns - Max(dp[i])`.
- Constraints: $N, M \le 100$. $O(M^2 \cdot N)$ is fine ($100^3 = 10^6$).
*Bài toán tương đương tìm Dãy con Tăng Dài nhất (LIS) chung cho tất cả các hàng. `dp[i]` là độ dài dãy con thỏa mãn kết thúc tại cột `i`.*

---

## 2. Strategy: Dynamic Programming (LIS Variation)
## *2. Chiến lược: Quy hoạch Động (Biến thể LIS)*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `dp` array of size `L` (length of strings). Fill with 1.
    *   **Khởi tạo:** Mảng `dp` kích thước L, khởi tạo bằng 1.*

2.  **Iterate `i`:** From 0 to `L-1` (current column).
    *   **Duyệt `i`:** Cột hiện tại.*

3.  **Iterate `j`:** From 0 to `i-1` (previous column).
    - Check if valid transition: For all rows `k`, `strs[k][j] <= strs[k][i]`.
    - If valid: `dp[i] = max(dp[i], dp[j] + 1)`.
    *   **Duyệt `j`:** Nếu chuyển đổi hợp lệ (tăng trên mọi hàng), cập nhật `dp[i]`.*

4.  **Result:** `L - max(dp)`.
    *   **Kết quả:** Tổng số cột - LIS cực đại.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.Arrays;

public class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        int[] dp = new int[cols];
        Arrays.fill(dp, 1);
        
        int maxLen = 1;
        
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < i; j++) {
                boolean valid = true;
                // Check if column j can precede column i for all rows
                for (int k = 0; k < rows; k++) {
                    if (strs[k].charAt(j) > strs[k].charAt(i)) {
                        valid = false;
                        break;
                    }
                }
                
                if (valid) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return cols - maxLen;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(L^2 \cdot N)$ where $L$ is string length and $N$ is number of strings.
    *   **Độ phức tạp thời gian:** $O(L^2 \cdot N)$.*
*   **Space Complexity:** $O(L)$ for DP array.
    *   **Độ phức tạp không gian:** $O(L)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

This is a classic variation of LIS. Instead of one sequence, we just need to satisfy the increasing condition across multiple sequences simultaneously.
*Đây là biến thể cổ điển của LIS. Thay vì một dãy, ta cần thỏa mãn điều kiện tăng trên nhiều dãy đồng thời.*

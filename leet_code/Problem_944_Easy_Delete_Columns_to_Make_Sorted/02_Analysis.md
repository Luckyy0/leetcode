# Analysis for Delete Columns to Make Sorted
# *Phân tích cho bài toán Xóa Cột để Thực hiện Sắp xếp*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Count columns that are not lexicographically sorted.
*Đếm số cột không được sắp xếp theo thứ tự từ điển.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Simple iteration.
- Iterate through each column index `j` from 0 to `len - 1`.
- For each column `j`, iterate through rows `i` from 0 to `n - 2`.
- Check if `strs[i].charAt(j) > strs[i+1].charAt(j)`.
- If condition met, the column is unsorted. Increment count and `break` (move to next column).
- Return total count.
*Duyệt đơn giản. Duyệt từng cột, kiểm tra từng hàng. Nếu thấy sai thứ tự thì tăng biến đếm và chuyển cột khác. Trả về tổng.*

---

## 2. Strategy: Column-wise Scan
## *2. Chiến lược: Quét theo Cột*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Iterate:** `col` from 0 to `L-1`.
    *   **Duyệt:** Cột từ 0 đến `L-1`.*

2.  **Check Order:** `row` from 0 to `N-2`.
    - If `strs[row].charAt(col) > strs[row+1].charAt(col)`:
    - `count++`
    - `break` (inner loop).
    *   **Kiểm tra:** Nếu sai thứ tự -> tăng đếm -> break.*

3.  **Return:** `count`.
    *   **Trả về:** `count`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public int minDeletionSize(String[] strs) {
        if (strs == null || strs.length == 0) return 0;
        
        int rows = strs.length;
        int cols = strs[0].length();
        int deleteCount = 0;
        
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows - 1; r++) {
                if (strs[r].charAt(c) > strs[r + 1].charAt(c)) {
                    deleteCount++;
                    break;
                }
            }
        }
        
        return deleteCount;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot L)$. Visit each character once.
    *   **Độ phức tạp thời gian:** $O(N \cdot L)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Basic matrix traversal.
*Duyệt ma trận cơ bản.*

# Analysis for Toeplitz Matrix
# *Phân tích cho bài toán Ma trận Toeplitz*

## 1. Problem Essence & Diagonal Check
## *1. Bản chất vấn đề & Kiểm tra Đường chéo*

### The Challenge
### *Thách thức*
In a Toeplitz matrix, `matrix[i][j]` must be equal to `matrix[i+1][j+1]`.
*Trong ma trận Toeplitz, `matrix[i][j]` phải bằng `matrix[i+1][j+1]`.*

This local condition implies the global condition (entire diagonal is same).
*Điều kiện cục bộ này kéo theo điều kiện toàn cục (toàn bộ đường chéo đều giống nhau).*

---

## 2. Strategy: Neighbor Comparison
## *2. Chiến lược: So sánh Lân cận*

### Algorithm
### *Thuật toán*

1.  **Iterate:** Loop through all rows `0` to `m-2` and cols `0` to `n-2`.
2.  **Check:** If `matrix[i][j] != matrix[i+1][j+1]`, return `false`.
3.  **Result:** If loops complete, return `true`.

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public boolean isToeplitzMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length - 1; i++) {
        for (int j = 0; j < matrix[0].length - 1; j++) {
            if (matrix[i][j] != matrix[i+1][j+1]) {
                return false;
            }
        }
    }
    return true;
}
```

### Follow-ups Analysis
### *Phân tích Mở rộng*

1.  **Memory Limited (One Row):**
    If we can only store one row, we can store `row[i]`, read `row[i+1]`. Compare `row[i][k]` with `row[i+1][k+1]` (i.e. compare value at index `k` of older row with index `k+1` of newer row).
    *Nếu chỉ nhớ một hàng, lưu `row[i]`, đọc `row[i+1]`. So sánh `row[i][k]` với `row[i+1][k+1]`.*

2.  **Partial Row:**
    Load small blocks. The diagonal property is global but checked locally. We can verify blocks.
    *Tải từng khối nhỏ. Thuộc tính đường chéo là toàn cục nhưng được kiểm tra cục bộ. Ta có thể xác minh từng khối.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \cdot N)$. Visit each element once.
    *   **Độ phức tạp thời gian:** $O(M \cdot N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Input:**
1 2 3
5 1 2
9 5 1

Check:
(0,0)=1 == (1,1)=1? OK.
(0,1)=2 == (1,2)=2? OK.
(1,0)=5 == (2,1)=5? OK.
(1,1)=1 == (2,2)=1? OK.
All good.
**Result:** True.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Simple neighbor check is sufficient.
*Kiểm tra lân cận đơn giản là đủ.*

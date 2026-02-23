# Analysis for Transpose Matrix
# *Phân tích cho bài toán Chuyển vị Ma trận*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Swap the rows and columns of a given grid. A matrix of size $M \times N$ becomes $N \times M$.
*Hoán đổi hàng và cột của một lưới cho trước. Ma trận kích thước $M \times N$ sẽ trở thành $N \times M$.*

---

## 2. Strategy: Direct Mapping
## *2. Chiến lược: Ánh xạ trực tiếp*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Result Matrix:** Create a new matrix `res` with dimensions $N \times M$ (where original was $M \times N$).
    *   **Khởi tạo Ma trận Kết quả:** Tạo ma trận mới `res` với kích thước $N \times M$.*

2.  **Iterate and Fill:** Traverse the original matrix using nested loops.
    - Set `res[j][i] = matrix[i][j]` for all $i, j$.
    *   **Duyệt và Điền:** Duyệt qua ma trận gốc bằng các vòng lặp lồng nhau. Đặt `res[j][i] = matrix[i][j]` cho tất cả $i, j$.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int[][] transpose(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] res = new int[n][m];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            res[j][i] = matrix[i][j];
        }
    }
    return res;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \cdot N)$, as we visit every element in the grid exactly once.
    *   **Độ phức tạp thời gian:** $O(M \cdot N)$, vì chúng ta ghé thăm mọi phần tử trong lưới đúng một lần.*
*   **Space Complexity:** $O(M \cdot N)$ to store the outcome, or $O(1)$ if the output space is not counted.
    *   **Độ phức tạp không gian:** $O(M \cdot N)$ để lưu trữ kết quả.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple matrix manipulation doesn't require complex strategies. Ensure the dimensions are correctly swapped during initialization.
*Thao tác ma trận đơn giản không yêu cầu các chiến lược phức tạp. Đảm bảo các kích thước được hoán đổi chính xác trong quá trình khởi tạo.*

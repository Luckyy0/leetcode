# Analysis for Magic Squares In Grid
# *Phân tích cho bài toán Hình vuông Ma thuật trong Lưới*

## 1. Problem Essence & Definition
## *1. Bản chất vấn đề & Định nghĩa*

### THE CHALLENGE
### *Thách thức*
We need to count all 3x3 subgrids that fulfill the magic square property:
1.  Elements are exactly the digits 1 to 9.
2.  Rows, columns, and diagonals have the same sum.
*Chúng ta cần đếm tất cả các lưới con 3x3 thỏa mãn tính chất hình vuông ma thuật: Các phần tử là các chữ số từ 1 đến 9 xuất hiện đúng một lần, và tổng các hàng, cột, đường chéo đều bằng nhau.*

---

## 2. Strategy: Brute Force Verification
## *2. Chiến lược: Xác thực duyệt trâu*

### Key Magic Square Properties
### *Tính chất then chốt của Hình vuông ma thuật*
- The sum of 1 to 9 is 45. Since there are 3 rows, each row must sum to $45/3 = 15$.
- The middle element must be 5.
*Tổng từ 1 đến 9 là 45. Vì có 3 hàng, tổng mỗi hàng phải là $45/3 = 15$. Phần tử ở chính giữa luôn phải là 5.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Iterate Subgrids:** Loop through every possible top-left corner $(r, c)$ of a 3x3 subgrid.
    *   **Duyệt lưới con:** Duyệt qua mọi góc trên bên trái $(r, c)$ khả thi của lưới 3x3.*

2.  **Verify Candidates:**
    - Check if the 9 elements are distinct and within the range [1, 9].
    - Check if all rows sum to 15.
    - Check if all columns sum to 15.
    - Check if both diagonals sum to 15.
    *   **Xác thực ứng viên:** Kiểm tra xem 9 phần tử có khác nhau và nằm trong đoạn [1, 9] không. Kiểm tra tổng các hàng, cột và đường chéo có bằng 15 không.*

3.  **Count Result:** Increment counter for each successful verification.
    *   **Đếm kết quả:** Tăng biến đếm cho mỗi lần xác thực thành công.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int numMagicSquaresInside(int[][] grid) {
    int rows = grid.length, cols = grid[0].length;
    int count = 0;
    for (int r = 0; r <= rows - 3; r++) {
        for (int c = 0; c <= cols - 3; c++) {
            if (isMagic(grid, r, c)) count++;
        }
    }
    return count;
}

private boolean isMagic(int[][] g, int r, int c) {
    // Basic check for center
    if (g[r + 1][c + 1] != 5) return false;
    
    // Check 1-9
    int[] count = new int[10];
    for (int i = r; i < r + 3; i++) {
        for (int j = c; j < c + 3; j++) {
            int val = g[i][j];
            if (val < 1 || val > 9 || count[val]++ > 0) return false;
        }
    }
    
    // Check sums (simplified)
    return (g[r][c] + g[r][c+1] + g[r][c+2] == 15 && ...)
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(R \cdot C)$, where $R$ and $C$ are the grid dimensions. For each starting point, we perform a fixed amount of work (9 cells and a few sums).
    *   **Độ phức tạp thời gian:** $O(R \cdot C)$, do với mỗi điểm bắt đầu, ta thực hiện một lượng công việc cố định.*
*   **Space Complexity:** $O(1)$ extra space beyond the input.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Subgrid:**
4 3 8
9 5 1
2 7 6
1. Digits: {1, 2, 3, 4, 5, 6, 7, 8, 9}. OK.
2. Center: 5. OK.
3. Row sums: 4+3+8=15, 9+5+1=15, 2+7+6=15. OK.
4. Col sums: 4+9+2=15, 3+5+7=15, 8+1+6=15. OK.
5. Diagonals: 4+5+6=15, 8+5+2=15. OK.
**Result:** Magic!

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Hardcoding the checksums for each of the 8 lines (3 rows, 3 columns, 2 diagonals) is faster than using loops during verification. Also, the "center must be 5" rule is a powerful early-exit optimization.
*Việc viết mã cứng (hardcode) các phép kiểm tra tổng cho 8 đường (3 hàng, 3 cột, 2 chéo) sẽ nhanh hơn dùng vòng lặp. Quy tắc "tâm phải là 5" cũng là một tối ưu hóa quan trọng.*

# Analysis for Score After Flipping Matrix
# *Phân tích cho bài toán Điểm sau khi Lật Ma trận*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Maximize the sum of binary numbers represented by the rows of a grid. We can flip rows and columns.
*Tối đa hóa tổng của các số nhị phân được biểu diễn bởi các hàng của một lưới. Chúng ta có thể lật các hàng và các cột.*

Key Bitwise Trick: In a binary number, the most significant bit (MSB) contributes more than the sum of all other bits combined (e.g., $2^3 > 2^2 + 2^1 + 2^0$).
*Mẹo Bitwise quan trọng: Trong một số nhị phân, bit quan trọng nhất (MSB) đóng góp nhiều hơn tổng của tất cả các bit khác cộng lại.*

---

## 2. Strategy: Greedy Row and Column Flipping
## *2. Chiến lược: Lật hàng và cột theo kiểu Tham lam*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Row Flipping (Ensuring MSB is 1):** Iterate through each row. If the first element `grid[i][0]` is 0, flip the whole row. This ensures every row starts with a `1`, contributing the maximum possible value for that bit position ($2^{n-1}$).
    *   **Lật hàng (Đảm bảo MSB là 1):** Duyệt qua từng hàng. Nếu phần tử đầu tiên `grid[i][0]` là 0, hãy lật toàn bộ hàng đó. Điều này đảm bảo mỗi hàng đều bắt đầu bằng số `1`, đóng góp giá trị tối đa có thể cho vị trí bit đó.*

2.  **Column Flipping (Maximizing 1s count):** Iterate through each column from index 1 to $n-1$.
    - Count the number of `1`s in the current column.
    - If the number of `0`s is greater than the number of `1`s, flip the column to maximize the number of `1`s.
    *   **Lật cột (Tối đa hóa số lượng số 1):** Duyệt qua từng cột từ chỉ số 1 đến $n-1$. Đếm số lượng số `1` trong cột hiện tại. Nếu số lượng số `0` lớn hơn số lượng số `1`, hãy lật cột đó để tối đa hóa số lượng số `1`.*

3.  **Calculate Total Score:** Convert each processed row back to a decimal number and sum them up.
    *   **Tính tổng điểm:** Chuyển đổi mỗi hàng đã xử lý trở lại thành một số thập phân và cộng chúng lại.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int matrixScore(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    // Every row will start with 1.
    int res = m * (1 << (n - 1));
    
    for (int j = 1; j < n; j++) {
        int countOne = 0;
        for (int i = 0; i < m; i++) {
            // Count 1s in column j. 
            // If row starts with original 0, it was flipped.
            if (grid[i][j] == grid[i][0]) countOne++;
        }
        res += Math.max(countOne, m - countOne) * (1 << (n - 1 - j));
    }
    return res;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \cdot N)$, as we traverse each cell of the grid once.
    *   **Độ phức tạp thời gian:** $O(M \cdot N)$, vì chúng ta duyệt qua mỗi ô của lưới một lần.*
*   **Space Complexity:** $O(1)$ if we calculate the result on the fly without physically flipping elements.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The greedy choice for the MSB is the absolute priority. Once MSBs are all set to 1, we simply maximize the count of 1s in each subsequent column independently.
*Lựa chọn tham lam cho MSB là ưu tiên tuyệt đối. Một khi các MSB đều được đặt thành 1, chúng ta chỉ cần tối đa hóa số lượng số 1 trong mỗi cột tiếp theo một cách độc lập.*

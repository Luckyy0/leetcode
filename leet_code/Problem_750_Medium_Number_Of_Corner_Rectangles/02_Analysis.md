# Analysis for Number Of Corner Rectangles
# *Phân tích cho bài toán Số lượng Hình chữ nhật Góc*

## 1. Problem Essence & Row-Pair Intersection
## *1. Bản chất vấn đề & Giao điểm Cặp Hàng*

### The Challenge
### *Thách thức*
A rectangle is defined by two rows (`r1`, `r2`) and two columns (`c1`, `c2`). For a "corner rectangle" to exist, we must have `grid[r1][c1] == 1`, `grid[r1][c2] == 1`, `grid[r2][c1] == 1`, and `grid[r2][c2] == 1`.
*Một hình chữ nhật được xác định bởi hai hàng (`r1`, `r2`) và hai cột (`c1`, `c2`). Để tồn tại "hình chữ nhật góc", ta phải có cả 4 góc đều bằng 1.*

---

## 2. Strategy: Count Shared Columns
## *2. Chiến lược: Đếm Cột Chung*

If we fix two rows `r1` and `r2`, we can scan all columns to see how many indices `c` satisfy `grid[r1][c] == 1 AND grid[r2][c] == 1`.
*Nếu cố định hai hàng `r1` và `r2`, ta có thể quét qua tất cả các cột để xem bao nhiêu chỉ số `c` thỏa mãn điều kiện cả hai hàng đều có số 1.*

Let this count be `k`.
Any pair of these `k` columns will form a valid rectangle with rows `r1, r2`.
The number of ways to choose 2 columns from `k` is $\binom{k}{2} = \frac{k(k-1)}{2}$.
*Gọi số lượng cột thỏa mãn là `k`. Bất kỳ cặp nào trong số `k` cột này cũng sẽ tạo thành một hình chữ nhật hợp lệ với `r1, r2`. Số cách chọn 2 cột từ `k` là `k(k-1)/2`.*

### Algorithm
### *Thuật toán*
1.  Iterate over all pairs of rows `(i, j)` with `i < j`.
2.  For each pair, count shared ones `count`.
3.  Add `count * (count - 1) / 2` to the total answer.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(R^2 \cdot C)$. Given $R, C \le 200$, total operations roughly $200^3 \approx 8 \times 10^6$. Acceptable.
    *   **Độ phức tạp thời gian:** $O(R^2 \cdot C)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Input:**
Row 0: [1, 0, 0, 1]
Row 1: [0, 0, 1, 0]
Row 2: [0, 0, 1, 0]
Row 3: [1, 0, 0, 1]

- Pair (0, 1): Shared at 0? No (1 vs 0). At 3? No. Count = 0.
- Pair (0, 3): Shared at 0? Yes. Shared at 3? Yes. Count = 2. Ans += 2*1/2 = 1.
- Pair (1, 2): Shared at 2? Yes. Count = 1. Ans += 1*0/2 = 0.
**Total:** 1.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

This row-pair intersection approach is robust. For extremely sparse matrices, we could optimize by storing indices of 1s in lists for each row, reducing the inner loop to intersection of two sorted lists.
*Cách tiếp cận giao cặp hàng này rất mạnh mẽ. Đối với ma trận cực kỳ thưa thớt, ta có thể tối ưu bằng cách lưu trữ danh sách chỉ số các số 1 cho mỗi hàng, giảm vòng lặp bên trong xuống thành việc tìm giao của hai danh sách đã sắp xếp.*
---
*Hình chữ nhật (Rectangle) là sự đồng thuận của hai hàng và hai cột. Để tìm thấy nó, ta cố định một chiều (Rows) và đếm những điểm gặp gỡ trên chiều còn lại (Shared Columns). Dữ liệu dạy ta rằng bằng cách kiểm tra sự tương đồng giữa các tầng lớp (Intersecting rows), ta có thể đong đếm được cấu trúc hình học ẩn giấu trong mạng lưới hỗn độn.*
A rectangle (Rectangle) is the consensus of two rows and two columns. To find it, we fix one dimension (Rows) and count the meeting points on the other (Shared Columns). Data teaches us that by checking the similarity between layers (Intersecting rows), we can quantify the geometric structure hidden in the chaotic grid.

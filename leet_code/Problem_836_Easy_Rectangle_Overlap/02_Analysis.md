# Analysis for Rectangle Overlap
# *Phân tích cho bài toán Chồng lấp Hình chữ nhật*

## 1. Problem Essence & Geometry
## *1. Bản chất vấn đề & Hình học*

### THE CHALLENGE
### *Thách thức*
We need to determine if two rectangles overlap with a positive area. The key is to simplify the 2D condition into two independent 1D conditions (projections on the X and Y axes).
*Chúng ta cần xác định xem hai hình chữ nhật có chồng lên nhau với diện tích dương hay không. Chìa khóa là đơn giản hóa điều kiện 2D thành hai điều kiện 1D độc lập (hình chiếu trên trục X và Y).*

Two rectangles overlap if and only if their projections on the X-axis overlap AND their projections on the Y-axis overlap.
*Hai hình chữ nhật chồng lên nhau khi và chỉ khi hình chiếu của chúng trên trục X chồng nhau VÀ hình chiếu của chúng trên trục Y chồng nhau.*

---

## 2. Strategy: 1D Interval Overlap
## *2. Chiến lược: Chồng lấp Khoảng 1D*

### Condition for 1D Overlap
### *Điều kiện chồng lấp 1D*
Two intervals $[x_1, x_2]$ and $[x_3, x_4]$ overlap if:
$$\max(x_1, x_3) < \min(x_2, x_4)$$
- This ensures that the start of the overlap is strictly before the end of the overlap.
*Hai khoảng $[x_1, x_2]$ và $[x_3, x_4]$ chồng nhau nếu: giá trị lớn nhất của hai điểm bắt đầu nhỏ hơn giá trị nhỏ nhất của hai điểm kết thúc.*

### Algorithm Steps
### *Các bước thuật toán*
1.  Check the X-axis overlap: `max(rec1[0], rec2[0]) < min(rec1[2], rec2[2])`.
2.  Check the Y-axis overlap: `max(rec1[1], rec2[1]) < min(rec1[3], rec2[3])`.
3.  Return `true` if both are `true`.
*1. Kiểm tra chồng lấp trục X. 2. Kiểm tra chồng lấp trục Y. 3. Trả về `true` nếu cả hai đều đúng.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    // Check if the intersection of X-intervals exists
    boolean xOverlap = Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]);
    // Check if the intersection of Y-intervals exists
    boolean yOverlap = Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);
    
    return xOverlap && yOverlap;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$. We only perform a few numerical comparisons.
    *   **Độ phức tạp thời gian:** $O(1)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Rec 1:** `[0,0,2,2]`. **Rec 2:** `[1,1,3,3]`.
1. X-axis: `max(0, 1) = 1`, `min(2, 3) = 2`. $1 < 2$ (True).
2. Y-axis: `max(0, 1) = 1`, `min(2, 3) = 2`. $1 < 2$ (True).
Both true $\implies$ Overlap!
**Result:** true.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Decomposing the problem into two 1D overlapping interval checks is the most foolproof and mathematically robust way to solve geometric overlap problems. It naturally handles edge cases where rectangles only touch (since we use `<` instead of `<=`).
*Phân tích bài toán thành hai phép kiểm tra chồng lấp khoảng 1D là cách chắc chắn và mạnh mẽ nhất về mặt toán học. Nó tự xử lý các trường hợp chạm nhau vì chúng ta dùng dấu `<` thay vì `<=`.*

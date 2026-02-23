# Analysis for Candy
# *Phân tích cho bài toán Kẹo*

## 1. Problem Understanding & Constraints
## *1. Hiểu Đề & Ràng Buộc*

### Two Key Rules
### *Hai Quy Tắc Chính*
1.  **Floor Limit:** Every child gets at least 1 candy.
    *Giới hạn sàn: Mỗi đứa trẻ nhận ít nhất 1 viên kẹo.*
2.  **Neighbor Comparison:** If child `A` has a higher rating than neighbor `B`, `A` must have strictly more candies than `B`.
    *So sánh hàng xóm: Nếu đứa trẻ `A` có xếp hạng cao hơn hàng xóm `B`, `A` phải có nhiều kẹo hơn `B` một cách nghiêm ngặt.*

### The Optimization Goal
### *Mục Tiêu Tối Ưu Hóa*
*   We want the **minimum** total candies. This means we should give each child only as much as absolutely necessary to satisfy the rules.
    *Chúng ta muốn tổng số kẹo **tối thiểu**. Điều này có nghĩa là chúng ta chỉ nên trao cho mỗi đứa trẻ số lượng kẹo tối thiểu tuyệt đối cần thiết để thỏa mãn các quy tắc.*

---

## 2. Approach: Two-Pass Greedy ($O(N)$ Space)
## *2. Hướng Tiếp Cận: Tham Lam Hai Lượt (Không gian O(N))*

A common mistake is trying to solve this in a single pass while only looking in one direction. However, a child's candy count depends on neighbors on **both** sides.
*Một sai lầm phổ biến là cố gắng giải quyết vấn đề này trong một lượt duy nhất trong khi chỉ nhìn theo một hướng. Tuy nhiên, số kẹo của một đứa trẻ phụ thuộc vào hàng xóm ở **cả hai** phía.*

### Strategy
### *Chiến Lược*
1.  **Initial State:** Give every child 1 candy. `candies = [1, 1, 1, ...]`.
    *Trạng thái ban đầu: Trao cho mỗi đứa trẻ 1 viên kẹo.*
2.  **Left-to-Right Pass (Satisfy left neighbors):**
    -   Iterate from `i = 1` to `n - 1`.
    -   If `ratings[i] > ratings[i - 1]`, set `candies[i] = candies[i - 1] + 1`.
    -   This ensures every child with a higher rating than their left neighbor has more candies than them.
3.  **Right-to-Left Pass (Satisfy right neighbors):**
    -   Iterate from `i = n - 2` down to `0`.
    -   If `ratings[i] > ratings[i + 1]`, we must ensure `candies[i]` is strictly greater than `candies[i + 1]`.
    -   **Final Update:** `candies[i] = max(candies[i], candies[i + 1] + 1)`.
    -   Using `max` is crucial because we don't want to break the left-neighbor condition already established.
4.  **Summation:** The total sum of the `candies` array is our answer.

---

## 3. Structural Advantages
## *3. Ưu Điểm Cấu Trúc*

*   **Symmetry:** By splitting the problem into two passes, we simplify the logic. Each pass only cares about one directional neighbor.
    *Sự đối xứng: Bằng cách chia bài toán thành hai lượt, chúng ta đơn giản hóa logic. Mỗi lượt chỉ quan tâm đến hàng xóm theo một hướng.*
*   **Linear Efficiency:** The solution is extremely fast ($O(N)$) and handles the cascading peaks and valleys of ratings efficiently.
    *Hiệu Quả Tuyến Tính: Giải pháp cực kỳ nhanh ($O(N)$) và xử lý hiệu quả các đỉnh và thung lũng xếp hạng xếp chồng lên nhau.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We iterate through the array twice (left-to-right and right-to-left).
    *Độ phức tạp thời gian: $O(N)$. Chúng ta duyệt qua mảng hai lần (trái sang phải và phải sang trái).*
*   **Space Complexity:** $O(N)$. We use an auxiliary array of size $N$ to store the candies for each child. (Note: There is an $O(1)$ space solution using slope tracking, but it is much significantly more complex to implement and explain).
    *Độ phức tạp không gian: $O(N)$. Chúng ta sử dụng một mảng phụ kích thước $N$ để lưu trữ kẹo cho mỗi đứa trẻ.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

`ratings = [1, 0, 2]`
-   Initial: `[1, 1, 1]`
-   Left-to-Right:
    -   `0 > 1`? No.
    -   `2 > 0`? Yes. `candies[2] = candies[1] + 1 = 2`.
    -   Result: `[1, 1, 2]`
-   Right-to-Left:
    -   `0 > 2`? No.
    -   `1 > 0`? Yes. `candies[0] = max(1, candies[1] + 1) = 2`.
    -   Result: `[2, 1, 2]`

**Total:** $2 + 1 + 2 = 5$.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

The two-pass approach is highly recommended for coding interviews as it is much easier to implement correctly than the one-pass $O(1)$ space logic. It effectively demonstrates how to decompose bidirectional constraints into unidirectional ones. This "Double Pass" pattern is also seen in problems like "Trapping Rain Water".
*Cách tiếp cận hai lượt được khuyến nghị mạnh mẽ cho các buổi phỏng vấn lập trình vì nó dễ triển khai chính xác hơn nhiều so với logic một lượt không gian $O(1)$. Nó thể hiện hiệu quả cách phân tách các ràng buộc hai chiều thành các ràng buộc một chiều. Mô hình "Hai Lượt" này cũng được thấy trong các bài toán như "Hứng Nước Mưa".*
---
*Số kẹo trao đi không chỉ là phần thưởng cho xếp hạng, mà là sự cân bằng giữa hai phía láng giềng.*
The candy given isn't just a reward for ratings, but a balance between the two neighbors.

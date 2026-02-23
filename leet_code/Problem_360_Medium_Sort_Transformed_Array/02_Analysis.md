# Analysis for Sort Transformed Array
# *Phân tích cho bài toán Sắp xếp Mảng đã Biến đổi*

## 1. Problem Essence & Quadratic Properties
## *1. Bản chất vấn đề & Tính chất Hàm bậc hai*

### The Challenge
### *Thách thức*
Transforming sorted values through $f(x) = ax^2 + bx + c$ and maintaining the sorted property in $O(N)$ time. The sorted input `nums` is key.

### Parabola Behavior:
### *Hành vi của Parabol:*
1.  **If $a > 0$:** The parabola opens **upwards**. The largest values appear at the two ends (extreme left or extreme right).
    - Strategy: Use two pointers at both ends, compare $f(left)$ and $f(right)$, and pick the **larger** one to fill the result array from **back to front**.
2.  **If $a < 0$:** The parabola opens **downwards**. The smallest values appear at the two ends.
    - Strategy: Use two pointers at both ends, compare $f(left)$ and $f(right)$, and pick the **smaller** one to fill the result array from **front to back**.
3.  **If $a = 0$:** The function is linear ($f(x) = bx + c$). It is monotonic.
    - If $b \ge 0$, it's non-decreasing. If $b < 0$, it's non-increasing.
    - Note: $a=0$ can be treated as $a \ge 0$ case (filling back to front starting with the larger end).

---

## 2. Approach: Two Pointers
## *2. Hướng tiếp cận: Hai Con trỏ*

### Logic
### *Logic*
Using two pointers `i = 0` and `j = n-1`. Calculate $v_1 = f(nums[i])$ and $v_2 = f(nums[j])$.
Depending on the sign of $a$, decide which value to "place" next in the result array and move the corresponding pointer.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Efficiency:** Avoids $O(N \log N)$ sorting by utilizing the mathematical property of quadratics.
    *Hiệu quả O(N): Tránh việc sắp xếp O(N log N) bằng cách sử dụng tính chất toán học của hàm bậc hai.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ for the result array.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5`
Parabola opens up. Fill from end.
$f(x) = x^2 + 3x + 5$.
1. `f(-4) = 9`, `f(4) = 33`. Max is 33. Res: `[_, _, _, 33]`, R--.
2. `f(-4) = 9`, `f(2) = 15`. Max is 15. Res: `[_, _, 15, 33]`, R--.
3. `f(-4) = 9`, `f(-2) = 3`. Max is 9. Res: `[_, 9, 15, 33]`, L++.
4. `f(-2) = 3`. Res: `[3, 9, 15, 33]`.
Result: `[3, 9, 15, 33]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Two pointers based on the sign of 'a'.
*Sử dụng hai con trỏ dựa trên dấu của 'a'.*
---
*Hàm bậc hai (quadratic) có thể làm đảo lộn thứ tự (sorted order), nhưng với sự hiểu biết về điểm cực trị (parabola peak/valley), chúng ta vẫn có thể tìm thấy sự nhất quán (sorted result) từ hai phía của cuộc đời.*
Quadratics can disrupt the sorted order, but with an understanding of extreme points (parabola peak/valley), we can still find consistency (sorted result) from both sides of life.

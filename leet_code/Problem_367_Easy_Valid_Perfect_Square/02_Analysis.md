# Analysis for Valid Perfect Square
# *Phân tích cho bài toán Số chính phương Hợp lệ*

## 1. Problem Essence & Binary Search
## *1. Bản chất vấn đề & Tìm kiếm Nhị phân*

### The Challenge
### *Thách thức*
Checking if $\exists x \in \mathbb{Z}: x^2 = n$ without using `sqrt`. Since $n$ is sorted in the sense that $1^2 < 2^2 < \dots < (2^{31}-1)^2$ is not quite right, but the *search space* $[1, n]$ is sorted.

### Strategy 1: Binary Search
### *Chiến lược 1: Tìm kiếm Nhị phân*
Search for $x$ in the range $[1, num]$.
- If $mid^2 == num$, return true.
- If $mid^2 < num$, move left pointer.
- If $mid^2 > num$, move right pointer.
- **Tip:** Use `long` for product to avoid overflow.

### Strategy 2: Newton's Method
### *Chiến lược 2: Phương pháp Newton*
Finding roots of $f(x) = x^2 - num = 0$.
Iterative update: $x_{n+1} = \frac{1}{2}(x_n + \frac{num}{x_n})$.
Starting from $x = num$, iterate until $x^2 \le num$. If $x^2 = num$, it's a perfect square.

### Strategy 3: Sum of Odd Numbers (Math Property)
### *Chiến lược 3: Tổng các số lẻ (Tính chất Toán học)*
A perfect square $n^2$ is the sum of the first $n$ odd numbers: $1 + 3 + 5 + \dots + (2n-1) = n^2$.
Keep subtracting $1, 3, 5, \dots$ until the result is $\le 0$. If it reaches $0$, it's a perfect square.

---

## 2. Approach: Binary Search
## *2. Hướng tiếp cận: Tìm kiếm Nhị phân*

### Logic
### *Logic*
(See Strategy 1 above). Widely applicable and easy to implement.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(log N) Complexity:** Extremely fast for large integers.
    *Độ phức tạp O(log N): Cực nhanh cho các số nguyên lớn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N)$.
    *Độ phức tạp thời gian: $O(\log N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 16
1. Low=1, High=16. Mid=8. $8^2 = 64 > 16$. High=7.
2. Low=1, High=7. Mid=4. $4^2 = 16$. Match!
Result: True.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Binary Search ($O(\log N)$).
*Tìm kiếm Nhị phân ($O(\log N)$).*
---
*Trong toán học cũng như trong cuộc sống, sự hoàn hảo (perfect square) đôi khi không lộ diện ngay lập tức. Ta cần phải thu hẹp dần (binary search) phạm vi của những khả năng, kiên trì cho đến khi tìm thấy sự cân bằng tuyệt đối giữa thực tại và giấc mơ.*
In math as in life, perfection (perfect square) sometimes doesn't reveal itself immediately. We need to gradually narrow down (binary search) the range of possibilities, persevering until we find absolute balance between reality and dreams.

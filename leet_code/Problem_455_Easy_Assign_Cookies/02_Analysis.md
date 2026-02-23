# Analysis for Assign Cookies
# *Phân tích cho bài toán Phân phối Bánh quy*

## 1. Problem Essence & Greedy Distribution
## *1. Bản chất vấn đề & Phân phối Tham lam*

### The Challenge
### *Thách thức*
Maximizing the number of children whose requirement (greed factor) is met by an available cookie size. We should avoid wasting large cookies on children with small requirements.

### Strategy: Two-Pointer Greedy
### *Chiến lược: Tham lam Hai con trỏ*

1.  **Sort:** Sort both the greed factors array `g` and the cookie sizes array `s` in ascending order.
2.  **Iterate:**
    - Use pointer `i` for children and pointer `j` for cookies.
    - While `i < g.length` and `j < s.length`:
        - If the current cookie `s[j]` is large enough for child `i` (`s[j] >= g[i]`):
            - Successfully satisfied a child! Move to the next child: `i++`.
        - Regardless of whether the child was satisfied, move to the next (larger) cookie: `j++`.
3.  **Result:** The final value of `i` is the count of satisfied children.

---

## 2. Approach: Optimal Matching
## *2. Hướng tiếp cận: Khớp lệnh Tối ưu*

### Logic
### *Logic*
(See above). Sorting allows us to always use the **smallest possible cookie** that satisfies the child with the **smallest current greed factor**. This preserves larger cookies for children with higher greed factors.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Greedy Optimality:** A locally optimal choice (smallest satisfy smallest) leads to a globally optimal solution.
    *Tính tối ưu tham lam: Một lựa chọn tối ưu cục bộ dẫn đến giải pháp tối ưu toàn cục.*
*   **Simple Implementation:** Sorting + Linear Scan.
    *Triển khai đơn giản: Sắp xếp + Duyệt tuyến tính.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N + M \log M)$, where $N$ and $M$ are the lengths of `g` and `s`.
    *Độ phức tạp thời gian: $O(N \log N + M \log M)$.*
*   **Space Complexity:** $O(1)$ additional space (ignoring sorting overhead).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `g = [1, 2, 3], s = [1, 1]`
1. Sort: `g = [1, 2, 3], s = [1, 1]` (Already sorted).
2. `i = 0, j = 0`. `s[0](1) >= g[0](1)`. Child 0 satisfied. `i=1, j=1`.
3. `i = 1, j = 1`. `s[1](1) < g[1](2)`. Child 1 NOT satisfied. `j=2` (out of bounds).
Result: 1.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Greedy distribution with sorting and two pointers.
*Phân phối tham lam kết hợp sắp xếp và hai con trỏ.*
---
*Lòng biết ơn và sự thỏa mãn không nằm ở kích thước của món quà, mà nằm ở việc nó có đáp ứng được nhu cầu tối thiểu hay không. Trong bài toán phân phối (assignment), sự tham lam khôn ngoan (greedy) dạy ta cách tiết kiệm tài nguyên: hãy dùng chiếc bánh nhỏ nhất vừa đủ để làm một đứa trẻ mỉm cười, để những chiếc bánh lớn hơn còn cơ hội sưởi ấm những khao khát lớn lao hơn.*
Gratitude and satisfaction are not in the size of the gift, but in whether it meets the minimum requirements. In the assignment problem (assignment), wise greed (greedy) teaches us how to save resources: use the smallest cake just enough to make a child smile, so that larger cakes have opportunity to warm greater desires.

# Analysis for Remove Duplicate Letters
# *Phân tích cho bài toán Loại bỏ Các Chữ cái Trùng lặp*

## 1. Problem Essence & Monotonic Stack (ish)
## *1. Bản chất vấn đề & Ngăn xếp Đơn điệu (gần như)*

### The Criteria
### *Tiêu chí*
1.  Unique chars.
2.  Preserve relative order (subsequence).
3.  Lexicographically smallest.

### Strategy: Greedy with Stack
### *Chiến lược: Tham lam với Ngăn xếp*
We want smallest characters as early as possible.
Iterate through string `s`.
If current char `c` is smaller than stack top `peek`, AND `peek` appears again later in string (so we can pick it up later):
- Pop `peek`.
This creates a locally increasing sequence where possible.
Conditions:
- Maintain frequency map to know if char appears later.
- Maintain `onStack` boolean to ensure uniqueness.

### Logic Flow
### *Luồng Logic*
1.  Count frequencies of all chars.
2.  Loop char `c`:
    - Decrement freq of `c`.
    - If `c` already on stack, continue (we already picked the best position for it earlier or implicitly).
    - While Stack not empty AND `peek > c` AND `freq[peek] > 0`:
        - `peek` can be discarded now and picked later.
        - `visited[peek] = false`.
        - Stack pop.
    - Stack push `c`.
    - `visited[c] = true`.

---

## 2. Approach: Stack
## *2. Hướng tiếp cận: Ngăn xếp*

### Logic
### *Logic*
(See above)

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Greedy Choice:** Making the locally optimal choice (smaller char first) leads to global optimum because we respect the constraint "must appear later".
    *Lựa chọn tham lam: Đưa ra lựa chọn tối ưu cục bộ (kí tự nhỏ hơn trước) dẫn đến tối ưu toàn cục vì ta tuân thủ ràng buộc "phải xuất hiện sau".*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ (Each char pushed/popped once).
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(26)$ or $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** "bcabc"
Freq: b=2, c=2, a=1.
1.  'b'. Stack [b]. Visited {b}. Freq b=1.
2.  'c'. c > b. Push. Stack [b, c]. Visited {b, c}. Freq c=1.
3.  'a'. Freq a=0.
    - a < c? Yes. Freq c > 0 (1)? Yes. Pop c. Stack [b]. Visited {b}.
    - a < b? Yes. Freq b > 0 (1)? Yes. Pop b. Stack []. Visited {}.
    - Push a. Stack [a]. Vis {a}.
4.  'b'. Freq b=0. b > a. Push. Stack [a, b]. Vis {a, b}.
5.  'c'. Freq c=0. c > b. Push. Stack [a, b, c].
Result "abc".

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Classic "Smallest Subsequence of Distinct Characters" problem using Stack.
*Bài toán "Chuỗi con nhỏ nhất gồm các kí tự khác biệt" kinh điển sử dụng Ngăn xếp.*
---
*Đôi khi phải biết buông bỏ những thứ lớn lao (larger characters) hiện tại nếu biết chắc rằng cơ hội để nắm bắt chúng vẫn còn ở phía trước (appears later), để nhường chỗ cho những điều tốt đẹp hơn (smaller).*
Sometimes you have to let go of current grand things (larger characters) if you are sure that the opportunity to grasp them still lies ahead (appears later), to make room for better things (smaller).

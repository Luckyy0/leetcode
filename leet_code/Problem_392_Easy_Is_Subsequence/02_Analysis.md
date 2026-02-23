# Analysis for Is Subsequence
# *Phân tích cho bài toán Chuỗi con*

## 1. Problem Essence & Sequential Matching
## *1. Bản chất vấn đề & Khớp tuần tự*

### The Challenge
### *Thách thức*
Checking if all characters of `s` appear in `t` in the correct order.

### Strategy: Two Pointers
### *Chiến lược: Hai con trỏ*
1.  Initialize two pointers `i` and `j` at the start of `s` and `t` respectively.
2.  Traverse `t` using `j`.
3.  If `s.charAt(i) == t.charAt(j)`, move `i` forward (found a match for the current required character).
4.  Always move `j` forward to search for the next match.
5.  If `i` reaches the end of `s`, it means all characters were found in sequence. Return `true`.

---

## 2. Approach: Simple Greedy (Two Pointers)
## *2. Hướng tiếp cận: Tham lam đơn giản (Hai con trỏ)*

### Logic
### *Logic*
(See above). This is the most efficient one-pass approach for a single comparison.

---

## 3. Follow-up: High Volume (Binary Search)
## *3. Gợi ý: Khối lượng lớn (Tìm kiếm Nhị phân)*

### Scenario:
### *Tình huống:*
If we have $10^9$ strings to check against the same `t`, we should pre-process `t`:
1.  Create a map or list for each character ('a' to 'z') containing the indices where they appear in `t`.
    - e.g., `t = "ahbgdc"`, `Map['a'] = [0]`, `Map['b'] = [2]`, `Map['g'] = [3]`, etc.
2.  For each `s`, iterate letters and use **Binary Search** to find the smallest index in `t` that is greater than the previously found index.

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(T)$ where $T$ is the length of string `t`.
    *Độ phức tạp thời gian: $O(T)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `s = "abc", t = "ahbgdc"`
1. `i=0 ('a')`. Find 'a' in `t`: match at `j=0`. `i=1`.
2. `i=1 ('b')`. Find 'b' in `t` (starting from `j=1`): match at `j=2`. `i=2`.
3. `i=2 ('c')`. Find 'c' in `t` (starting from `j=3`): match at `j=5`. `i=3`.
4. `i == s.length()`.
Result: True.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Two pointers for single check. Binary search on index map for batch checks.
*Hai con trỏ cho kiểm tra đơn lẻ. Tìm kiếm nhị phân trên bản đồ chỉ số cho kiểm tra hàng loạt.*
---
*Cuộc sống thường đòi hỏi sự kiên nhẫn và thứ tự (order). Để đạt được mục tiêu cuối cùng (s), ta không nhất thiết phải nắm lấy mọi thứ trong dòng đời (t), mà chỉ cần biết chờ đợi và chọn lọc đúng những mảnh ghép cần thiết theo đúng trình tự mà chúng xuất hiện.*
Life often requires patience and order. To achieve the final goal (s), we do not necessarily have to grasp everything in the stream of life (t), but only need to wait and selectively choose the necessary pieces in the correct order they appear.

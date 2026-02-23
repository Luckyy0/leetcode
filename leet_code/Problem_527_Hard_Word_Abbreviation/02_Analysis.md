# Analysis for Word Abbreviation
# *Phân tích cho bài toán Viết tắt Từ*

## 1. Problem Essence & Iterative Resolution
## *1. Bản chất vấn đề & Giải quyết Lặp*

### The Challenge
### *Thách thức*
Generating unique abbreviations.
- Start with shortest abbreviation (prefix length 1).
- If multiple words have same abbreviation, resolve conflict by increasing prefix length.
- Repeat until all are unique.

### Strategy: Greedy + Refinement Loop
### *Chiến lược: Tham lam + Vòng lặp Tinh chỉnh*

1.  **Initial State:** `prefix[i] = 1` for all `i`. Compute initial abbreviations.
2.  **Conflict Detection:** Use a Map/Group to find which indices share the same abbr string.
3.  **Resolution:** For every group with size > 1:
    - Increment `prefix[i]` for all indices in that group.
    - Recompute abbr.
    - Note: This might split the group or keep them together if they still share a longer prefix.
    - We must repeat the detection process for the *entire* array (or at least the affected ones) until no conflicts remain.
    - Actually, checking affected ones recursively is complicated. Simpler to just loop the whole process until `conflitCount == 0`.

### Optimization: Trie?
### *Tối ưu hóa: Trie?*
- We can insert all words into a Trie containing counts.
- For a word, find the shortest prefix in Trie that uniquely identifies it (count == 1).
- Then construct abbr from that prefix.
- Example: "internal", "internet", "interval".
    - Trie path `i` (3), `in` (3), `int` (3), `inte` (3), `inter` (3).
    - `intern` (2), `interna` (1) -> Unique prefix "interna".
    - `interval` (1) -> Unique prefix "interv".
    - Abbr for `interval`: `interv` + count + last char -> `interv1l`.
    - Wait, the rule is "prefix + count + last".
    - Using Trie is strictly better O(N*L).
    - But iterative conflict resolution is also fast enough for N=400.

---

## 2. Approach: Iterative Conflict Resolution
## *2. Hướng tiếp cận: Giải quyết Xung đột Lặp*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Simplicity:** No complex data structure needed.
    *Đơn giản: Không cần cấu trúc dữ liệu phức tạp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2 \cdot L)$ worst case if each step resolves 1 conflict. With Trie, $O(N \cdot L)$.
    *Độ phức tạp thời gian: $O(N^2 \cdot L)$ trường hợp xấu nhất. Với Trie là $O(N \cdot L)$.*
*   **Space Complexity:** $O(N)$.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `like, live`
1. `prefix=[1, 1]`. Abbrs: `l2e, l2e`. Conflict.
2. Incr prefix for both: `[2, 2]`. Abbrs: `li1e, li1e`. Conflict.
3. Incr prefix: `[3, 3]`. Abbrs: `lik, liv` (Full words). Unique. Done.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Loop checking for duplicates and increasing prefix length.
*Vòng lặp kiểm tra trùng lặp và tăng độ dài tiền tố.*
---
*Việc viết tắt (abbreviation) nhằm mục đích đơn giản hóa, nhưng không được đánh mất bản sắc riêng (uniqueness). Khi xảy ra xung đột (conflict), ta buộc phải hiển lộ nhiều hơn về bản thân (longer prefix) để khẳng định vị trí độc tôn của mình trong đám đông.*
Abbreviation is intended to simplify, but must not lose its own identity (Uniqueness). When a conflict occurs (Conflict), we are forced to reveal more about ourselves (Longer Prefix) to assert our unique position in the crowd.

# Analysis for Shortest Word Distance
# *Phân tích cho bài toán Khoảng cách từ ngắn nhất*

## 1. Problem Essence & One Pass
## *1. Bản chất vấn đề & Một lần duyệt*

### The Naive Way
### *Cách ngây thơ*
Find all indices of `word1` (List L1) and `word2` (List L2). Check all pairs. $O(N^2)$.
Or use Two Pointers on sorted lists of indices. $O(N)$.

### The Optimized Way
### *Cách tối ưu*
We iterate the array once.
Keep track of the `lastIndex1` and `lastIndex2`.
Whenever we find `word1`, update `lastIndex1`, and if `lastIndex2` was found previously, calculate distance. Update min.
Same for `word2`.
*Duyệt mảng một lần. Theo dõi chỉ số cuối cùng của word1 và word2. Cập nhật khoảng cách mỗi khi tìm thấy.*

---

## 2. Approach: One Pass Iteration
## *2. Hướng tiếp cận: Duyệt một lần*

### Logic
### *Logic*
1.  Initialize `p1 = -1`, `p2 = -1`, `minDist = infinity`.
2.  Loop `i` from 0 to `n`:
    - If `words[i].equals(word1)`: `p1 = i`.
    - If `words[i].equals(word2)`: `p2 = i`.
    - If both `p1` and `p2` != -1: `minDist = min(minDist, abs(p1 - p2))`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Greedy updates:** Since we want the shortest distance, updating the index of `word1` to the *current* `i` (which is closer to any future `word2`) is always correct.
    *Cập nhật tham lam: Vì muốn khoảng cách ngắn nhất, cập nhật chỉ số word1 thành i hiện tại luôn đúng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot L)$ where L is word length (for string comparison).
    *Độ phức tạp thời gian: $O(N \cdot L)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** "practice", "makes", "perfect", "coding", "makes". w1="makes", w2="coding".

1.  i=0 (practice).
2.  i=1 (makes). p1=1. 
3.  i=2 (perfect).
4.  i=3 (coding). p2=3. Dist = |3-1| = 2. Min=2.
5.  i=4 (makes). p1=4. Dist = |4-3| = 1. Min=1.

Result: 1.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Simple linear scan.
*Quét tuyến tính đơn giản.*
---
*Đôi khi người bạn cần tìm đứng gần hơn bạn nghĩ, chỉ cần bạn chịu khó đi hết con đường (duyệt hết mảng).*
Sometimes the one you seek is closer than you think, if you are willing to walk the whole path.

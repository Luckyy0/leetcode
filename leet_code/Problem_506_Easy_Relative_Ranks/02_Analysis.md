# Analysis for Relative Ranks
# *Phân tích cho bài toán Xếp hạng Tương đối*

## 1. Problem Essence & Sorting with Indices
## *1. Bản chất vấn đề & Sắp xếp với Chỉ số*

### The Challenge
### *Thách thức*
Assigning ranks based on scores while preserving the original order of athletes.
- We need to know which original index corresponds to the highest score, 2nd highest, etc.

### Strategy: Sort Pairs (Score, Index)
### *Chiến lược: Sắp xếp các Cặp (Điểm, Chỉ số)*

1.  **Pairing:** Create an array of pairs `(score[i], i)`.
2.  **Sorting:** Sort the pairs in descending order of score.
3.  **Assignment:** Iterate through the sorted pairs.
    - Rank 0: `result[i] = "Gold Medal"`
    - Rank 1: `result[i] = "Silver Medal"`
    - Rank 2: `result[i] = "Bronze Medal"`
    - Rank k: `result[i] = String.valueOf(k + 1)`

---

## 2. Approach: Indices Array Sorting
## *2. Hướng tiếp cận: Sắp xếp Mảng Chỉ số*

### Logic
### *Logic*
(See above). Instead of Pair class, can just sort an Integer array of indices using a custom comparator that looks up `score`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Simplicity:** Direct mapping after sort.
    *Đơn giản: Ánh xạ trực tiếp sau khi sắp xếp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$.
    *Độ phức tạp thời gian: $O(N \log N)$.*
*   **Space Complexity:** $O(N)$ for indices array and result.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[10, 3, 8]`
1. Indices: `[0, 1, 2]`.
2. Sort indices by score desc: `[0 (10), 2 (8), 1 (3)]`.
3. Loop 0..2:
   - $k=0$, idx=0. `res[0] = "Gold"`.
   - $k=1$, idx=2. `res[2] = "Silver"`.
   - $k=2$, idx=1. `res[1] = "Bronze"`.
Result: `["Gold", "Bronze", "Silver"]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Sort indices based on score values.
*Sắp xếp chỉ số dựa trên giá trị điểm số.*
---
*Giá trị thực sự (score) không phụ thuộc vào vị trí xuất phát (index). Dù bạn đứng ở đâu trong hàng đợi ban đầu, nỗ lực (sorting) sẽ đưa bạn về đúng vị trí xứng đáng. Những tấm huy chương (medals) chỉ là sự công nhận cho những ai dám vươn lên đỉnh cao.*
True value (Score) does not depend on the starting position (Index). Wherever you stand in the initial queue, effort (Sorting) will bring you to the right position. Medals are only recognition for those who dare to rise to the top.

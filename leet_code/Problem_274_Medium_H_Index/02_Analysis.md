# Analysis for H-Index
# *Phân tích cho bài toán Chỉ số H*

## 1. Problem Essence & Definition
## *1. Bản chất vấn đề & Định nghĩa*

### H-Index Intuition
### *Trực giác về H-Index*
We want to find max `h` such that there are at least `h` papers with $\ge h$ citations.
If we sort the citations in descending order: `[6, 5, 3, 1, 0]`.
- Index 1 (1st paper): 6 citations $\ge 1$? Yes.
- Index 2 (2nd paper): 5 citations $\ge 2$? Yes.
- Index 3 (3rd paper): 3 citations $\ge 3$? Yes.
- Index 4 (4th paper): 1 citation $\ge 4$? No.
So $h=3$.

### Strategy
### *Chiến lược*
Two main approaches:
1.  **Sorting:** Sort descending. Find check $citations[i] >= i+1$. Time $O(N \log N)$.
2.  **Counting (Bucket Sort):** Since $h$ cannot exceed $N$ (number of papers), we can use buckets for citation counts. Time $O(N)$.

---

## 2. Approach: Counting Sort (Optimal)
## *2. Hướng tiếp cận: Sắp xếp đếm (Tối ưu)*

### Logic
### *Logic*
1.  Create array `buckets` of size `n + 1`.
2.  For each citation `c`:
    - If `c >= n`, increment `buckets[n]`. (Papers with super high citations count towards max possible h-index).
    - Else, increment `buckets[c]`.
3.  Iterate from `h = n` down to `0`:
    - `count += buckets[h]`. (Cumulative count of papers with $\ge h$ citations).
    - If `count >= h`: return `h`.

### Why it works?
### *Tại sao nó hoạt động?*
We are checking from max possible answer down. The first `h` that satisfies the condition "at least `h` papers have $\ge h$ citations" is the maximum `h`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Bounded Range:** The answer is bounded by $N$. This screams Bucket Sort.
    *Phạm vi bị giới hạn: Câu trả lời bị giới hạn bởi N. Điều này gợi ý Bucket Sort.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ for buckets.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[3, 0, 6, 1, 5]`. $N=5$.
Buckets (size 6):
- 3 -> `buckets[3]++`
- 0 -> `buckets[0]++`
- 6 -> (>=5) -> `buckets[5]++`
- 1 -> `buckets[1]++`
- 5 -> `buckets[5]++`
Buckets: `[1, 1, 0, 1, 0, 2]` (Indices 0 to 5)

Check backwards:
- $h=5$: Count = `buckets[5]` = 2. $2 \ge 5$? No.
- $h=4$: Count = 2 + `buckets[4]` = 2. $2 \ge 4$? No.
- $h=3$: Count = 2 + `buckets[3]` = 3. $3 \ge 3$? **Yes**.
Return 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Counting sort is excellent here.
*Sắp xếp đếm rất tuyệt ở đây.*
---
*Giá trị thực sự (H-index) không nằm ở một đỉnh cao chót vót (single high citation) mà nằm ở sự bền vững và nhất quán của cả quá trình.*
True value (H-index) lies not in a single towering peak (high citation) but in the consistency and sustainability of the whole process.

# Analysis for Longest Uncommon Subsequence II
# *Phân tích cho bài toán Dãy con Không chung Dài nhất II*

## 1. Problem Essence & Subsequence Check
## *1. Bản chất vấn đề & Kiểm tra Dãy con*

### The Challenge
### *Thách thức*
Finding a string in the list that is NOT a subsequence of any other string in the list.
- If a string $S$ is uncommon, it must not be a subsequence of any other string $T$.
- If $S$ appears multiple times, it is a subsequence of its duplicate, so it cannot be the answer.
- We want the longest such $S$.

### Strategy: Sorting and Verification
### *Chiến lược: Sắp xếp và Xác minh*

1.  **Duplicate Check:** Filter out any string that appears more than once. (They can't be generating the answer themselves, but they can be supersets of shorter strings).
    - Actually, simpler logic: For each string `strs[i]`, check if it is a subsequence of data `strs[j]` ($i \neq j$).
    - If `strs[i]` is NOT a subsequence of any `strs[j]`, then `strs[i]` is a candidate. "But wait, if duplicates exist?"
    - Example: `["aaa", "aaa"]`. `i=0` ("aaa" #1). Is it subseq of `strs[1]` ("aaa" #2)? Yes. So not candidate.
    - Example: `["aba", "cdc"]`. `aba` check `cdc` (no). Candidate.
2.  **Algorithm:**
    - Sort `strs` by length descending.
    - Loop `i` from 0 to N-1.
    - Flag `isUncommon = true`.
    - Loop `j` from 0 to N-1.
        - If `i == j` continue.
        - If `isSubsequence(strs[i], strs[j])`: `isUncommon = false`; break.
    - If `isUncommon`, return `strs[i].length()`. (Since we sorted by length, first one found is max).
    - If loop finishes without returning, return -1.

---

## 2. Approach: Brute Force with Pruning
## *2. Hướng tiếp cận: Vét cạn với Cắt tỉa*

### Logic
### *Logic*
(See above). The constraint $N \le 50$, $Len \le 10$ makes $O(N^2 \cdot L)$ very fast.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Small Constraints:** Allows quadratic comparison.
    *Ràng buộc nhỏ: Cho phép so sánh bậc hai.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2 \cdot L)$.
    *Độ phức tạp thời gian: $O(N^2 \cdot L)$.*
*   **Space Complexity:** $O(1)$ (or $O(L)$ for recursion stack).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `["aaa", "aaa", "aa"]`
- Sort: `["aaa", "aaa", "aa"]`.
- `i=0` ("aaa"): Check vs `j=1` ("aaa"). YES subseq. Fail.
- `i=1` ("aaa"): Check vs `j=0` ("aaa"). YES subseq. Fail.
- `i=2` ("aa"): Check vs `j=0` ("aaa"). YES subseq. Fail.
Result: -1.

**Input:** `["aba", "cdc", "eae"]`
- Sort: same length.
- `i=0` ("aba"): vs `cdc` (no), vs `eae` (no). Success. Return 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Compare every string against every other string to check subsequence property.
*So sánh mọi chuỗi với mọi chuỗi khác để kiểm tra tính chất dãy con.*
---
*Độc bản (Uncommon) là khi bạn không phải là cái bóng (subsequence) của bất kỳ ai khác. Ngay cả khi bạn nhỏ bé hơn, việc không thể tìm thấy hình dáng mình trong những kẻ lớn hơn chính là minh chứng cho sự tồn tại riêng biệt.*
Unique (Uncommon) is when you are not a shadow (Subsequence) of anyone else. Even if you are smaller, finding your shape in the larger ones is a testament to separate existence.

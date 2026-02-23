# Analysis for Word Pattern II
# *Phân tích cho bài toán Mẫu Từ II*

## 1. Problem Essence & Backtracking
## *1. Bản chất vấn đề & Quay lui*

### The Challenge
### *Thách thức*
Unlike Word Pattern I, here the mapping is unknown. 'a' could be "red", "r", "re"...
We must *find* if a valid mapping exists.
Constraint: bijection (1-to-1).

### Strategy: Backtracking
### *Chiến lược: Quay lui*
`backtrack(patternIndex, strIndex, map, set)`
- **Base Case:**
    - If both `patternIndex` and `strIndex` reach end -> True.
    - If one ends but not other -> False.
- **Recursive Step:**
    - `char p = pattern[patternIndex]`.
    - If `p` is already mapped to `w`:
        - Check if `s` starts with `w` at `strIndex`.
        - If yes, `backtrack(pIdx + 1, sIdx + w.len)`.
        - If no, False (Backtrack).
    - If `p` is NOT mapped:
        - Try *every possible substring* starting at `strIndex`.
        - `newWord = s.substring(strIndex, k)`.
        - Constraint: `newWord` must NOT be already used by another char (Bijection).
        - If valid, `map.put(p, newWord)`, `set.add(newWord)`.
        - Recurse.
        - Backtrack: Remove from map and set.

---

## 2. Approach: DFS / Backtracking
## *2. Hướng tiếp cận: DFS / Quay lui*

### Logic
### *Logic*
1.  Map `char -> string`. Set `usedStrings`.
2.  DFS function.
3.  Optimizations: Pruning if remaining string length is insufficient for remaining pattern characters (min 1 char per pattern char).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Exhaustive Search:** Explores all partition possibilities.
*   **Constraints:** Length <= 20 allows exponential complexity.
    *Tìm kiếm toàn diện: Khám phá mọi khả năng phân vùng. Ràng buộc: Độ dài <= 20 cho phép độ phức tạp số mũ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** High exponential, roughly $O(N^M)$ where N is s.length, M is pattern.length.
*   **Space Complexity:** $O(M)$ for recursion stack and map.
    *Độ phức tạp thời gian: Số mũ cao. Độ phức tạp không gian: O(M).*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** "abab", "redblueredblue"
1.  'a' maps to "r"? No... eventually 'a' maps to "red".
2.  Next 'b'. Try "b", "bl", "blu", "blue".
3.  Map 'b' -> "blue".
4.  Next 'a'. Map has "red". Check `s` at current pos. Starts with "red"? Yes.
5.  Next 'b'. Map has "blue". Check `s`... Starts with "blue"? Yes.
6.  End. True.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard backtracking for partition problems.
*Quay lui tiêu chuẩn cho các bài toán phân vùng.*
---
*Khi ý nghĩa chưa rõ ràng (unknown mapping), hãy thử nghiệm các giả thuyết. Sự kiên nhẫn thử sai (backtracking) sẽ dẫn đến chân lý.*
When meaning is unclear (unknown mapping), test hypotheses. Patient trial and error (backtracking) will lead to the truth.

# Analysis for Generalized Abbreviation
# *Phân tích cho bài toán Viết tắt Tổng quát*

## 1. Problem Essence & Backtracking
## *1. Bản chất vấn đề & Quay lui*

### The Choice
### *Lựa chọn*
At each character `word[i]`:
1.  **Abbreviate it:** Treat it as a number (`1`). If previous was number, add to it.
2.  **Keep it:** Write the character `word[i]`. If previous was number, finalize that number.

### Strategy: DFS with State
### *Chiến lược: DFS với Trạng thái*
`dfs(index, currentString, currentCount)`
- `index`: current char in `word`.
- `currentString`: built so far.
- `currentCount`: accumulated length of abbrev ending at current pos.

Recursive Steps:
1.  **Keep `word[index]`:**
    - If `currentCount > 0`, append `currentCount` to string.
    - Append `word[index]`.
    - Recurse `(index + 1, newString, 0)`.
2.  **Abbreviate `word[index]`:**
    - Recurse `(index + 1, currentString, currentCount + 1)`.

Base Case: `index == length`.
- If `currentCount > 0`, append `currentCount`.
- Add to result list.

---

## 2. Approach: Backtracking
## *2. Hướng tiếp cận: Quay lui*

### Logic
### *Logic*
(See above). The state `count` nicely handles the "no adjacent numbers" rule implicitly, because we only write the number when we encounter a character or end of string. Merging adjacent abbreviations (like `1` then `1`) is handled by just summing `count`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Implicit Handling:** The Accumulator `count` avoids discrete number merging logic.
    *Xử lý ngầm định: Bộ tích lũy `count` tránh logic gộp số rời rạc.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(2^N)$. Each char 2 choices. $N=15 \Rightarrow 32768$. Fast.
    *Độ phức tạp thời gian: $O(2^N)$.*
*   **Space Complexity:** $O(N)$ for recursion stack.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** "word"
1. `dfs(0, "", 0)`
   - Keep 'w': `dfs(1, "w", 0)`
     - Keep 'o': `dfs(2, "wo", 0)`... -> "word"
     - Abbr 'o': `dfs(2, "w", 1)`
       - Keep 'r': append 1, append r. `dfs(3, "w1r", 0)`... -> "w1r1", "w1rd"
       - Abbr 'r': `dfs(3, "w", 2)`...
   - Abbr 'w': `dfs(1, "", 1)`
     - Keep 'o': append 1, o. `dfs(2, "1o", 0)`...
     - Abbr 'o': `dfs(2, "", 2)`...

Correctly covers all cases including "4" (pure abbreviation).

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Backtracking with accumulator parameter.
*Quay lui với tham số tích lũy.*
---
*Đôi khi sự im lặng (abbreviation) nói lên nhiều điều hơn lời nói. Nhưng quá nhiều im lặng liền kề nhau (adjacent substrings) sẽ trở thành vô nghĩa nếu không được gộp lại thành một thông điệp thống nhất (summed length).*
Sometimes silence (abbreviation) speaks louder than words. But too much adjacent silence (adjacent substrings) becomes meaningless unless merged into a unified message (summed length).

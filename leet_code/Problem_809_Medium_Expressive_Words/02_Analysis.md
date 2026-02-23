# Analysis for Expressive Words
# *Phân tích cho bài toán Từ biểu cảm*

## 1. Problem Essence & Group Comparison
## *1. Bản chất vấn đề & So sánh Nhóm*

### The Challenge
### *Thách thức*
A word `w` can match `s` if:
1. They have the same sequence of unique characters.
2. For each group of character `c` with length `L_w` in `w` and `L_s` in `s`:
   - `L_w` must be $\le L_s$.
   - If `L_w < L_s`, then `L_s` must be at least 3.
*Một từ `w` khớp với `s` nếu chúng có cùng chuỗi ký tự duy nhất và với mỗi nhóm ký tự, độ dài trong `w` nhỏ hơn hoặc bằng độ dài trong `s`. Nếu độ dài trong `w` nhỏ hơn, thì độ dài trong `s` phải ít nhất là 3.*

---

## 2. Strategy: Two Pointers or RLE
## *2. Chiến lược: Hai con trỏ hoặc RLE*

### Algorithm (Two Pointers)
### *Thuật toán (Hai con trỏ)*

1.  Compare each word `word` from `words` with `s`.
2.  Maintain two pointers `i` (for `s`) and `j` (for `word`).
3.  In each step:
    - Verify `s[i] == word[j]`. If not, invalid.
    - Count the length of the current character group in `s` (say `cntS`) and in `word` (say `cntW`).
    - Checks:
      - `cntW > cntS`: Cannot shrink. Invalid.
      - `cntW < cntS` and `cntS < 3`: Cannot extend to length 2. Invalid.
    - Advance pointers by `cntS` and `cntW`.
    *   **Duyệt từng từ:** Dùng hai con trỏ `i` và `j`. Kiểm tra ký tự tại `i` và `j` có giống nhau không. Đếm độ dài nhóm ký tự tại vị trí đó của cả hai. Nếu độ dài trong từ lớn hơn s hoặc độ dài trong từ nhỏ hơn s nhưng s có ít hơn 3 ký tự, thì không hợp lệ.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(words \cdot (L_s + L_{word}))$.
    *   **Độ phức tạp thời gian:** $O(W \cdot S)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**S:** "heeellooo", **Word:** "hello"
1. Group 'h': $cntS=1, cntW=1$. OK.
2. Group 'e': $cntS=3, cntW=1$. $1 < 3$ and $3 \ge 3$. OK.
3. Group 'l': $cntS=2, cntW=2$. $2 = 2$. OK.
4. Group 'o': $cntS=3, cntW=1$. $1 < 3$ and $3 \ge 3$. OK.
**Result:** Match.

**S:** "heeellooo", **Word:** "helo"
...
3. Group 'l': $cntS=2, cntW=1$. $1 < 2$ and $cntS (2) < 3$. **Invalid**.
**Result:** No match.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Simple group counting with two pointers is the most memory-efficient way.
*Đếm số nhóm đơn giản bằng hai con trỏ là cách tiết kiệm bộ nhớ nhất.*

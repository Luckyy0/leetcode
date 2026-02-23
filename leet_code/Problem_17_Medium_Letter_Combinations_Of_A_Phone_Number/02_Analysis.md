# Analysis for Letter Combinations of a Phone Number
# *Phân tích cho bài toán Tổ Hợp Chữ Cái của Số Điện Thoại*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** String `digits`. *Chuỗi `digits`.*
*   **Output:** List of strings. *Danh sách các chuỗi.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Length up to 4. $4^4 = 256$ combinations max. Very small.
    *Độ dài lên tới 4. Tối đa $4^4 = 256$ tổ hợp. Rất nhỏ.*
*   Backtracking or Iteration is perfect.
    *Quay lui hoặc Lặp là hoàn hảo.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Backtracking (DFS)
### *Hướng tiếp cận: Quay lui (DFS)*

*   **Intuition:** For each digit, iterate through its corresponding letters and move to the next digit.
    *Ý tưởng: Với mỗi chữ số, duyệt qua các chữ cái tương ứng của nó và chuyển sang chữ số tiếp theo.*
*   **Mapping:** Array or Switch case to map '2' -> "abc", etc.
    *Ánh xạ: Mảng hoặc Switch case để ánh xạ '2' -> "abc", v.v.*

*   **Algorithm Steps:**
    1.  If input empty, return empty list.
    2.  Define `backtrack(index, currentString)`.
    3.  Base Case: If `index == digits.length`, add `currentString` to result. Return.
    4.  Recursive Step:
        *   Get letters for `digits[index]`.
        *   For each `char` in letters:
            *   `backtrack(index + 1, currentString + char)`.

*   **Complexity:**
    *   Time: $O(4^N \times N)$. (N is length).
    *   Space: $O(N)$ (Recursion stack).

### Dry Run
### *Chạy thử*
`digits = "23"`
1.  `backtrack(0, "")`. Digit '2' -> "abc".
2.  Loop 'a': `backtrack(1, "a")`. Digit '3' -> "def".
    *   Loop 'd': `backtrack(2, "ad")`. Add "ad".
    *   Loop 'e': `backtrack(2, "ae")`. Add "ae".
    *   Loop 'f': `backtrack(2, "af")`. Add "af".
3.  Loop 'b': `backtrack(1, "b")`.
    *   ... Add "bd", "be", "bf".
...

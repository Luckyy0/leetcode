# 320. Generalized Abbreviation / Viết Tắt Tổng Quát

## Problem Description / Mô tả bài toán
A word's **generalized abbreviation** can be constructed by taking any number of non-overlapping and non-adjacent substrings and replacing them with their respective lengths.
Một **từ viết tắt tổng quát** của từ có thể được xây dựng bằng cách lấy bất kỳ số lượng chuỗi con không chồng chéo và không liền kề nào và thay thế chúng bằng độ dài tương ứng của chúng.

- For example, "abcde" can be abbreviated into:
    - "a3e" ("bcd" replaced by 3)
    - "1b1d1" ("a", "c", "e" replaced by 1)
    - "5" ("abcde" replaced by 5)
    - "abcde" (no substrings replaced)

Given a string `word`, return a list of all the possible **generalized abbreviations** of `word`. Return the answer in **any order**.
Cho một chuỗi `word`, trả về danh sách tất cả các **từ viết tắt tổng quát** có thể có của `word`.

### Example 1:
```text
Input: word = "word"
Output: ["4","3d","2r1","2rd","1o2","1o1d","1or1","1ord","w3","w2d","w1r1","w1rd","wo2","wo1d","wor1","word"]
```

## Constraints / Ràng buộc
- `1 <= word.length <= 15`
- `word` consists of only lowercase English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Backtracking (DFS) / Quay Lui
At each character, we have two choices:
1.  **Abbreviate**: Start or continue a count of abbreviated characters.
2.  **Keep**: Keep the character as is. If we kept the previous characters as abbreviated count, we append the count first.

State: `(index, current_count, current_string_builder)`.
- If `index == length`:
    - If `count > 0`, append count.
    - Add to result.
- **Decision 1 (Keep char at index)**:
    - If `count > 0`, append count.
    - Append `word[index]`.
    - Recurse `(index + 1, 0)`.
    - Backtrack (remove char and count).
- **Decision 2 (Skip char / Abbreviate)**:
    - Recurse `(index + 1, count + 1)`.

Wait, order of decisions doesn't matter.
Constraints: Length 15 -> 2^15 is 32768. Feasible.

### Complexity / Độ phức tạp
- **Time**: O(2^N * N). N is string construction cost.
- **Space**: O(N) recursion stack.

---

## Analysis / Phân tích

### Approach: Recursive DFS

**Algorithm**:
1.  `List<String> res`.
2.  `dfs(word, pos, count, sb)`.
3.  Base case: `pos == len`. If `count > 0` sb.append(count). Add to res.
4.  Recursive step:
    - **Abbr**: `dfs(word, pos + 1, count + 1, sb)`.
    - **Keep**:
        - Store length.
        - If `count > 0` sb.append(count).
        - sb.append(word.charAt(pos)).
        - `dfs(word, pos + 1, 0, sb)`.
        - Restore sb length.

---

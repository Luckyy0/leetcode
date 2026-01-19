# 245. Shortest Word Distance III / Khoảng Cách Từ Ngắn Nhất III

## Problem Description / Mô tả bài toán
Given an array of strings `wordsDict` and two strings `word1` and `word2`, return the shortest distance between these two words in the list.
Cho một mảng các chuỗi `wordsDict` và hai chuỗi `word1` và `word2`, hãy trả về khoảng cách ngắn nhất giữa hai từ này trong danh sách.

`word1` and `word2` may be the same. It represents two individual words in the list.
`word1` và `word2` có thể giống nhau. Nó đại diện cho hai từ riêng biệt trong danh sách.

### Example 1:
```text
Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
Output: 1
```

### Example 2:
```text
Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "makes"
Output: 3
```

## Constraints / Ràng buộc
- `1 <= wordsDict.length <= 10^5`
- `1 <= wordsDict[i].length <= 10`
- `word1` and `word2` are in `wordsDict`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Modified Linear Scan / Quét Tuyến Tính Sửa Đổi
This is similar to Problem 243, but we must handle the case `word1 == word2`.
When `word1 == word2`:
- We need to find the shortest distance between **two distinct indices** `i` and `j` such that `words[i] == word1` and `words[j] == word1`.
- This essentially means finding the minimum difference between adjacent occurrences of `word1`.

**Algorithm Logic**:
1.  Initialize `p1 = -1`, `p2 = -1` (or just one `p` if identical).
2.  If `word1 == word2`:
    - Loop through array.
    - If `words[i] == word1`:
        - If `p1 != -1`: `minDist = min(minDist, i - p1)`.
        - `p1 = i` (update previous index to current).
3.  If `word1 != word2`:
    - Same as Problem 243.

**Unified Algorithm**:
- Maintain `p1` and `p2`.
- Loop `i`.
- If `words[i] == word1`:
    - If `word1 == word2` and `p1 != -1`: `minDist = min(minDist, i - p1)`.
    - `p1 = i`.
- If `words[i] == word2`:
    - Since `word1 == word2` case is caught above, we can use `else if` for distinct case?
    - If `word1 == word2`: `p2` becomes `p1`? No, simpler to handle disjoint logic.
    - If distinct, update `p2 = i` and check `p1`.

Wait, **Unified single pass**:
- `p1 = -1`, `p2 = -1`.
- If `word1 == word2`, we can just track `prevIndex`.
- Let's separate the logic for clarity, or combine carefully.
- Combined:
  - If `words[i].equals(word1)`:
    - If `word1 == word2`: 
      - If `p1 != -1`: `min = min(min, i - p1)`.
      - `p1 = i`.
    - Else (distinct):
      - `p1 = i`.
      - If `p2 != -1`: `min = min(min, p1 - p2)`.
  - If `words[i].equals(word2)` (and `word1 != word2`):
    - `p2 = i`.
    - If `p1 != -1`: `min = min(min, p2 - p1)`.

---

## Analysis / Phân tích

### Approach: Linear Scan

**Complexity / Độ phức tạp**:
- **Time**: O(N).
- **Space**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Identical words**: Handled.
2.  **Distant occurrences**: Handled.

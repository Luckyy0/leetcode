# 243. Shortest Word Distance / Khoảng Cách Từ Ngắn Nhất

## Problem Description / Mô tả bài toán
Given an array of strings `wordsDict` and two different strings that already exist in the array `word1` and `word2`, return the shortest distance between these two words in the list.
Cho một mảng các chuỗi `wordsDict` và hai chuỗi khác nhau `word1` và `word2` đã tồn tại trong mảng, hãy trả về khoảng cách ngắn nhất giữa hai từ này trong danh sách.

### Example 1:
```text
Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
Output: 3
```

### Example 2:
```text
Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
Output: 1
```

## Constraints / Ràng buộc
- `1 <= wordsDict.length <= 3 * 10^4`
- `1 <= wordsDict[i].length <= 10`
- `word1` and `word2` are in `wordsDict`.
- `word1 != word2`

---

## Theoretical Foundation / Cơ sở lý thuyết

### One-Pass Scan / Quét Một Lần
We can iterate through the list of words while keeping track of the **most recent indices** where we saw `word1` and `word2`.
Whenever we see `word1`, if we have seen `word2` previously, we calculate the distance (`current_index - index_of_word2`) and update the minimum.
Similarly for `word2`.

### Complexity / Độ phức tạp
- **Time**: O(N) - We iterate through the array once.
- **Space**: O(1) - Only storing two indices.

---

## Analysis / Phân tích

### Approach: Linear Scan

**Algorithm**:
1.  Initialize `p1 = -1` (index of word1), `p2 = -1` (index of word2), `minDist = MAX_INT`.
2.  Loop `i` from 0 to `N-1`:
    - If `words[i].equals(word1)`:
        - `p1 = i`
        - If `p2 != -1`, `minDist = min(minDist, p1 - p2)`
    - If `words[i].equals(word2)`:
        - `p2 = i`
        - If `p1 != -1`, `minDist = min(minDist, p2 - p1)`
3.  Return `minDist`.

---

## Edge Cases / Các trường hợp biên
1.  **Adjacent words**: Distance 1.
2.  **Far apart**: Max distance.
3.  **Multiple occurrences**: The logic always uses the *most recent* index, ensuring we find the shortest distance (Greedy property).

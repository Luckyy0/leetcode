# 72. Edit Distance / Khoảng Cách Chỉnh Sửa

## Problem Description / Mô tả bài toán
Given two strings `word1` and `word2`, return the minimum number of operations required to convert `word1` to `word2`.
Cho hai chuỗi `word1` và `word2`, trả về số lượng thao tác tối thiểu cần thiết để chuyển đổi `word1` thành `word2`.

You have the following three operations permitted on a word:
Bạn được phép thực hiện ba thao tác sau trên một từ:
1.  Insert a character (Chèn một ký tự).
2.  Delete a character (Xóa một ký tự).
3.  Replace a character (Thay thế một ký tự).

### Example 1:
```text
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
```

### Example 2:
```text
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
```

## Constraints / Ràng buộc
- `0 <= word1.length, word2.length <= 500`
- `word1` and `word2` consist of lowercase English letters.

---

## Analysis / Phân tích

### Approach: Dynamic Programming / Quy Hoạch Động
- **Idea**: Use a 2D array `dp[i][j]` representing the min operations to convert `word1[0..i-1]` to `word2[0..j-1]`.
- **Ý tưởng**: Sử dụng mảng 2D `dp[i][j]` đại diện cho các thao tác tối thiểu để chuyển đổi `word1[0..i-1]` thành `word2[0..j-1]`.
- **Base Cases**:
    - `dp[i][0] = i`: Converting `word1[0..i]` to empty string requires `i` deletions.
    - `dp[0][j] = j`: Converting empty string to `word2[0..j]` requires `j` insertions.
- **Transitions**:
    - If `word1[i-1] == word2[j-1]`: No new op needed. `dp[i][j] = dp[i-1][j-1]`.
    - Else: Take minimum of 3 ops + 1.
        - `dp[i-1][j] + 1`: Delete from word1.
        - `dp[i][j-1] + 1`: Insert into word1.
        - `dp[i-1][j-1] + 1`: Replace char.
- **Time Complexity**: O(m * n).
- **Space Complexity**: O(m * n) (can be optimized to O(min(m, n))).

---

## Edge Cases / Các trường hợp biên
1.  **Empty Strings**: "a" -> "" is 1 deletion. "" -> "a" is 1 insertion.
2.  **Identical Strings**: 0 operations.

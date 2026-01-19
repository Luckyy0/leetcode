# 132. Palindrome Partitioning II / Phân Tách Chuỗi Đối Xứng II

## Problem Description / Mô tả bài toán
Given a string `s`, partition `s` such that every substring of the partition is a palindrome. Return the **minimum cuts** needed for a palindrome partitioning of `s`.
Cho một chuỗi `s`, hãy phân tách `s` sao cho mỗi chuỗi con của phân tách đó là một chuỗi đối xứng. Trả về **số lần cắt tối thiểu** cần thiết để phân tách chuỗi đối xứng của `s`.

### Example 1:
```text
Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
```

### Example 2:
```text
Input: s = "a"
Output: 0
```

### Example 3:
```text
Input: s = "ab"
Output: 1
```

## Constraints / Ràng buộc
- `1 <= s.length <= 2000`
- `s` contains only lowercase English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dynamic Programming Optimization / Tối ưu hóa bằng Quy hoạch động
While P131 asked for all partitions (using backtracking), this problem asks for the minimum value, which suggests **Dynamic Programming**:
Trong khi P131 hỏi tất cả các phân tách (sử dụng quay lui), bài toán này hỏi giá trị tối thiểu, điều này gợi ý **Quy hoạch động**:

**State Definition**:
`dp[i]` = Minimum cuts for the prefix `s[0...i]`.

**Transition**:
- If `s[0...i]` is a palindrome, `dp[i] = 0` (no cuts needed).
- Otherwise, for all `0 < j <= i`, if `s[j...i]` is a palindrome, `dp[i] = min(dp[i], dp[j-1] + 1)`.

### Palindrome Check Precomputation / Tính toán trước Kiểm tra Đối xứng
To make the check `s[j...i]` fast (O(1)), we precompute the `isPalindrome[j][i]` table in O(N^2) time.

---

## Analysis / Phân tích

### Approach: 1D DP with 2D Palindrome Table / DP 1 Chiều với Bảng Đối xứng 2 Chiều

**Complexity / Độ phức tạp**:
- **Time**: O(N^2) - N^2 to precompute palindromes, and N^2 for DP transitions.
- **Space**: O(N^2) for the palindrome table.

---

## Edge Cases / Các trường hợp biên
1.  **String is already a palindrome**: 0 cuts.
2.  **String with all unique characters**: N-1 cuts.
3.  **Length 1**: 0 cuts.

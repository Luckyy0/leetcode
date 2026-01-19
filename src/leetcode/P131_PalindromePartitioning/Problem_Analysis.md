# 131. Palindrome Partitioning / Phân Tách Chuỗi Đối Xứng

## Problem Description / Mô tả bài toán
Given a string `s`, partition `s` such that every substring of the partition is a **palindrome**. Return all possible palindrome partitioning of `s`.
Cho một chuỗi `s`, hãy phân tách `s` sao cho mỗi chuỗi con của phân tách đó đều là một **chuỗi đối xứng**. Trả về tất cả các khả năng phân tách chuỗi đối xứng của `s`.

A **palindrome** string is a string that reads the same backward as forward.
Một chuỗi **đối xứng** là một chuỗi đọc xuôi hay ngược đều giống nhau.

### Example 1:
```text
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
```

### Example 2:
```text
Input: s = "a"
Output: [["a"]]
```

## Constraints / Ràng buộc
- `1 <= s.length <= 16`
- `s` contains only lowercase English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Backtracking Pattern / Mô hình Quay lui
This problem is a typical **partitioning** problem that can be solved using **backtracking**:
Bài toán này là một bài toán **phân tách** điển hình có thể giải quyết bằng **quay lui**:
1.  **Choose**: Pick a prefix of the current string.
2.  **Constraint**: Check if the chosen prefix is a palindrome.
3.  **Explore**: If it is a palindrome, recurse on the remaining part of the string.
4.  **Backtrack**: Remove the prefix and try a different length.

### Dynamic Programming Optimization / Tối ưu hóa bằng Quy hoạch động
To avoid repeated palindrome checks for the same substring, we can precompute a `isPalindrome[i][j]` table using DP:
Để tránh việc kiểm tra chuỗi đối xứng lặp đi lặp lại cho cùng một chuỗi con, chúng ta có thể tính toán trước bảng `isPalindrome[i][j]` bằng quy hoạch động:
- `isPalindrome[i][j] = true` if `s[i] == s[j]` and `(j - i <= 2 or isPalindrome[i+1][j-1])`.

---

## Analysis / Phân tích

### Approach: Backtracking with Optional DP Precomputation / Quay lui kết hợp Tối ưu hóa DP

**Complexity / Độ phức tạp**:
- **Time**: Worst case O(N × 2^N) - there are 2^N possible partitions and checking each takes O(N).
- **Space**: O(N^2) for DP table and O(N) for recursion depth.

---

## Edge Cases / Các trường hợp biên
1.  **Length 1**: Just one partition.
2.  **String with all same characters**: Many partitions (e.g., "aaaa").
3.  **String with no palindromes longer than 1**: Only one partition (e.g., "abc").

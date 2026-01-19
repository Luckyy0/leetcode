# 5. Longest Palindromic Substring / Chuỗi Con Đối Xứng Dài Nhất

## Problem Description / Mô tả bài toán
Given a string `s`, return the longest palindromic substring in `s`.
Cho một chuỗi `s`, trả về chuỗi con đối xứng dài nhất trong `s`.

### Example 1:
```text
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
```

### Example 2:
```text
Input: s = "cbbd"
Output: "bb"
```

## Constraints / Ràng buộc
- `1 <= s.length <= 1000`
- `s` consist of only digits and English letters.

---

## Analysis / Phân tích

### Approach 1: Brute Force / Vét cạn
- **Idea**: Check all substrings. If a substring is a palindrome, compare its length with the max length found so far.
- **Ý tưởng**: Kiểm tra tất cả các chuỗi con. Nếu một chuỗi con là đối xứng, so sánh độ dài của nó với độ dài lớn nhất tìm được cho đến nay.
- **Time Complexity**: O(n^3). Generating all substrings takes O(n^2), and checking if each is a palindrome takes O(n).
- **Space Complexity**: O(1).

### Approach 2: Expand Around Center / Mở rộng từ tâm
- **Idea**: A palindrome mirrors around its center. There are `2n - 1` centers (n single characters and n-1 gaps between characters). For each center, we expand outwards as long as the characters match.
- **Ý tưởng**: Một chuỗi đối xứng phản chiếu qua tâm của nó. Có `2n - 1` tâm (n ký tự đơn và n-1 khoảng giữa các ký tự). Với mỗi tâm, chúng ta mở rộng ra ngoài chừng nào các ký tự còn khớp nhau.
- **Time Complexity**: O(n^2). Expanding a palindrome around its center takes O(n), and we do this for each of the `2n - 1` centers.
- **Space Complexity**: O(1).

### Approach 3: Dynamic Programming / Quy hoạch động
- **Idea**: Let `dp[i][j]` be true if `s[i...j]` is a palindrome.
    - `dp[i][j] = true` if `s[i] == s[j]` and `dp[i+1][j-1]` is true.
    - Base cases: `dp[i][i] = true` (single char), `dp[i][i+1] = true` if `s[i] == s[i+1]` (two same chars).
- **Ý tưởng**: Gọi `dp[i][j]` là đúng nếu `s[i...j]` là chuỗi đối xứng.
    - `dp[i][j] = đúng` nếu `s[i] == s[j]` và `dp[i+1][j-1]` là đúng.
    - Trường hợp cơ sở: `dp[i][i] = đúng`, `dp[i][i+1] = đúng` nếu `s[i] == s[i+1]`.
- **Time Complexity**: O(n^2). We fill a table of size n*n.
- **Space Complexity**: O(n^2) for the DP table.

---

## Edge Cases / Các trường hợp biên
1.  **Single Character**: "a" -> "a".
2.  **Two Characters**: "ac" -> "a" (or "c"), "aa" -> "aa".
3.  **Entire String Palindrome**: "racecar" -> "racecar".
4.  **No Palindrome > 1**: "abcde" -> "a".

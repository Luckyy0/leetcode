# 91. Decode Ways / Các Cách Giải Mã

## Problem Description / Mô tả bài toán
A message containing letters from `A-Z` can be **encoded** into numbers using the following mapping:
Một thông điệp chứa các chữ cái từ `A-Z` có thể được **mã hóa** thành các số bằng cách sử dụng ánh xạ sau:
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"

To **decode** an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways).
Để **giải mã** một thông điệp đã mã hóa, tất cả các chữ số phải được nhóm lại sau đó ánh xạ ngược lại thành các chữ cái bằng cách sử dụng ánh xạ ngược lại (có thể có nhiều cách).
For example, "11106" can be mapped into:
- "AAJF" with the grouping (1 1 10 6)
- "KJF" with the grouping (11 10 6)

Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
Lưu ý rằng nhóm (1 11 06) là không hợp lệ vì "06" không thể ánh xạ thành 'F' vì "6" khác với "06".

Given a string `s` containing only digits, return the **number** of ways to **decode** it.
Cho một chuỗi `s` chỉ chứa các chữ số, hãy trả về **số lượng** cách để **giải mã** nó.

The test cases are generated so that the answer fits in a **32-bit** integer.
Các trường hợp kiểm tra được tạo sao cho câu trả lời phù hợp với số nguyên **32-bit**.

### Example 1:
```text
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
```

### Example 2:
```text
Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
```

### Example 3:
```text
Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
```

## Constraints / Ràng buộc
- `1 <= s.length <= 100`
- `s` contains only digits and may contain leading zero(s).

---

## Analysis / Phân tích

### Approach: Dynamic Programming / Quy Hoạch Động
- **Idea**: Let `dp[i]` be number of ways to decode string of length `i` (prefix `s[0..i-1]`).
- **Ý tưởng**: Gọi `dp[i]` là số cách để giải mã chuỗi có độ dài `i` (tiền tố `s[0..i-1]`).
- **Transition**:
    - Consider single digit `s[i-1]`: If `s[i-1] != '0'`, `dp[i] += dp[i-1]`.
    - Consider two digits `s[i-2..i-1]`: If it forms a number between 10 and 26, `dp[i] += dp[i-2]`.
- **Base Cases**: `dp[0] = 1` (empty string has one way).
- **Time Complexity**: O(N).
- **Space Complexity**: O(N) (can be optimized to O(1)).

---

## Edge Cases / Các trường hợp biên
1.  **Starts with 0**: "0..." -> 0 ways.
2.  **Contains '0'**: "10" -> 1 way (J). "30" -> 0 ways (invalid).

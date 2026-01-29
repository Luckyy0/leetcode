# 639. Decode Ways II / Cách Giải Mã II

## Problem Description / Mô tả bài toán
A message containing letters from `A-Z` can be encoded into numbers using the following mapping:
Một tin nhắn chứa các chữ cái từ `A-Z` có thể được mã hóa thành các số bằng cách sử dụng ánh xạ sau:
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"

To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways).
Để giải mã một tin nhắn đã mã hóa, tất cả các chữ số phải được nhóm lại sau đó ánh xạ ngược lại thành các chữ cái bằng cách sử dụng nghịch đảo của ánh xạ trên (có thể có nhiều cách).

In addition to the mapping above, an encoded message may contain the `*` character, which can represent any digit from `1` to `9` ('0' is excluded).
Ngoài ánh xạ trên, một tin nhắn đã mã hóa có thể chứa ký tự `*`, có thể đại diện cho bất kỳ chữ số nào từ `1` đến `9` ('0' bị loại trừ).

Given a string `s` containing digits and the `*` character, return the number of ways to decode it. The answer may be very large, so return it modulo `10^9 + 7`.
Cho một chuỗi `s` chứa các chữ số và ký tự `*`, hãy trả về số cách để giải mã nó. Câu trả lời có thể rất lớn, vì vậy hãy trả về nó modulo `10^9 + 7`.

### Example 1:
```text
Input: s = "*"
Output: 9
Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
```
### Example 2:
```text
Input: s = "1*"
Output: 9 + 9 = 18.
Ex: "11".."19" -> 9 single pairs.
Wait.
As single digit: '1' is 1 way. '*' is 9 ways. Total 9 (if independent)? No.
We decode "1*" as a sequence or as chunks.
- Chunk len 1: "1", "*".
  "1" -> A. Remainder "*" -> 9 ways. Total 9.
- Chunk len 2: "1*".
  "11".."19". 9 ways.
Total 9 + 9 = 18.
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy Hoạch Động
`dp[i]` = ways to decode suffix starting at `i`. Or prefix ending at `i`.
Let's use constant space `dp` (last 2 values).
`current` depends on `prev1` (1-digit decode) and `prev2` (2-digit decode).

1-digit decode (char `s[i]`):
- If '0': 0 ways.
- If '1'-'9': 1 way * prev1.
- If '*': 9 ways * prev1.

2-digit decode (chars `s[i-1]s[i]`):
- `1*`: 9 ways (11-19).
- `2*`: 6 ways (21-26).
- `*d` (where d is digit):
  - If d <= 6: "1d" (valid), "2d" (valid). Total 2 ways.
  - If d > 6: "1d" (valid), "2d" (invalid 27-29). Total 1 way.
- `**`: "11"-"19" (9) + "21"-"26" (6) = 15 ways.
- `dd` (digit digit): Standard check (10-26).
- `d*`? Covered.
- `*0`: "10", "20" -> 2 ways. (If `*` becomes 1 or 2).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear DP with Cases

**Algorithm**:
1.  Initialize previous state counts.
2.  Iterate string.
3.  Calculate contribution from 1-digit decoding.
4.  Calculate contribution from 2-digit decoding (checking prev char).
5.  Update state.

---

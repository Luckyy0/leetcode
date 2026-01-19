# 139. Word Break / Phân Tách Từ

## Problem Description / Mô tả bài toán
Given a string `s` and a dictionary of strings `wordDict`, return `true` if `s` can be segmented into a space-separated sequence of one or more dictionary words.
Cho một chuỗi `s` và một danh sách các chuỗi `wordDict`, hãy trả về `true` nếu `s` có thể được phân tách thành một chuỗi các từ trong từ điển được phân tách bằng dấu cách.

**Note** that the same word in the dictionary may be reused multiple times in the segmentation.
**Lưu ý** rằng cùng một từ trong từ điển có thể được tái sử dụng nhiều lần trong quá trình phân tách.

### Example 1:
```text
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
```

### Example 2:
```text
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
```

### Example 3:
```text
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
```

## Constraints / Ràng buộc
- `1 <= s.length <= 300`
- `1 <= wordDict.length <= 1000`
- `1 <= wordDict[i].length <= 20`
- `s` and `wordDict[i]` consist of only lowercase English letters.
- All the strings of `wordDict` are **unique**.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dynamic Programming (DP) / Quy hoạch động
This is a standard decision problem that can be broken down into subproblems:
Đây là một bài toán quyết định tiêu chuẩn có thể được chia thành các bài toán con:
- If we know that the prefix `s[0...j]` is valid and the substring `s[j...i]` is in the dictionary, then the prefix `s[0...i]` is also valid.
- Nếu chúng ta biết rằng tiền tố `s[0...j]` là hợp lệ và chuỗi con `s[j...i]` nằm trong từ điển, thì tiền tố `s[0...i]` cũng hợp lệ.

**State Definition**:
`dp[i]` is a boolean indicating whether the prefix `s[0...i]` can be segmented into dictionary words.

**Transition**:
`dp[i] = OR (dp[j] AND s[j...i] in wordDict)` for all `0 <= j < i`.

**Base Case**:
`dp[0] = true` (an empty string is considered validly segmented).

---

## Analysis / Phân tích

### Approach: 1D Dynamic Programming / Quy hoạch động 1 Chiều

**Complexity / Độ phức tạp**:
- **Time**: O(N^2 * L) or O(N^3) depending on implementation. We have N states, and for each state, we iterate back up to N times, and string slicing/hashing takes O(L).
- **Space**: O(N) for the DP array and O(M) for the dictionary set.

---

## Edge Cases / Các trường hợp biên
1.  **Empty String**: Handled by base case.
2.  **No words match**: All `dp` values except `dp[0]` remain false.
3.  **Dictionary contains words longer than s**: Handled correctly as `j` only goes up to `i`.
4.  **Prefix matches but suffix doesn't**: The DP state will track this correctly.

# 291. Word Pattern II / Mẫu Từ II

## Problem Description / Mô tả bài toán
Given a `pattern` and a string `s`, return `true` if `s` matches the `pattern`.
Cho một `pattern` và một chuỗi `s`, trả về `true` nếu `s` khớp với `pattern`.

A string `s` matches a `pattern` if there is some **bijective mapping** of single characters to **non-empty** strings such that if each character in `pattern` is replaced by the string it maps to, then the resulting string is `s`.
Một chuỗi `s` khớp với một `pattern` nếu có một **ánh xạ song ánh** nào đó của các ký tự đơn lẻ sang các chuỗi **không rỗng** sao cho nếu mỗi ký tự trong `pattern` được thay thế bằng chuỗi mà nó ánh xạ tới, thì chuỗi kết quả là `s`.

### Example 1:
```text
Input: pattern = "abab", s = "redblueredblue"
Output: true
Explanation: One possible mapping is as follows:
'a' -> "red"
'b' -> "blue"
```

### Example 2:
```text
Input: pattern = "aaaa", s = "asdasdasdasd"
Output: true
Explanation: One possible mapping is as follows:
'a' -> "asd"
```

### Example 3:
```text
Input: pattern = "aabb", s = "xyzabcxzyabc"
Output: false
```

## Constraints / Ràng buộc
- `1 <= pattern.length <= 20`
- `1 <= s.length <= 50`
- `pattern` and `s` consist of only lowercase English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Backtracking / Quay Lui
Unlike Example 290, we don't know the word boundaries. We must try all possibilities.
We maintain two maps: `Map<Char, String>` and `Set<String>` (to ensure bijection, i.e., different chars map to different strings).

**Recursive Function**: `solve(pIndex, sIndex)`
1.  **Base Case**:
    - If `pIndex == pattern.length` and `sIndex == s.length`, return `true` (Full match).
    - If one reaches end but not other, return `false`.
2.  **Logic**:
    - Get `char c = pattern[pIndex]`.
    - If `c` is already mapped to `word`:
        - Check if `s` starts with `word` at `sIndex`.
        - If yes, recurse `solve(pIndex + 1, sIndex + word.length())`.
        - If no, return `false`.
    - If `c` is NOT mapped:
        - Try to map `c` to substrings `s[sIndex ... k]` for all valid `k`.
        - Only map if `substring` is NOT already used by another char (check Set).
        - Update Map and Set.
        - Recurse.
        - Backtrack (Remove mapping).

### Complexity / Độ phức tạp
- **Time**: Combinatorial. Very high, but constraints are small (len 20/50). Pruning helps.
- **Space**: O(N) recursion depth.

---

## Analysis / Phân tích

### Approach: Backtracking

**Edge Cases**:
1.  Pattern length > String length: Impossible (since words non-empty).
2.  Remaining pattern chars > Remaining string chars: Pruning.

---

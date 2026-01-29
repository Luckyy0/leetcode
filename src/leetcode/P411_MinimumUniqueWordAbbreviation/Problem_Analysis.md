# 411. Minimum Unique Word Abbreviation / Viết Tắt Từ Duy Nhất Ngắn Nhất

## Problem Description / Mô tả bài toán
A string can be abbreviated by replacing any number of non-adjacent substrings with their lengths. For example, a string such as `"substitution"` can be abbreviated as `"s10n"`, `"sub4u4"`, `"12"`, `"su3i1u2on"`, etc.
Một chuỗi có thể được viết tắt bằng cách thay đổi các chuỗi con không kề nhau thành độ dài của chúng.

Given a target word `target` and a dictionary of strings `dictionary`, return the length of the **shortest** abbreviation of `target` such that it does not match any word in the dictionary. If there are multiple answers, return any one.
Cho một từ mục tiêu `target` và một từ điển các chuỗi `dictionary`, hãy trả về chữ viết tắt **ngắn nhất** của `target` sao cho nó không khớp với bất kỳ từ nào trong từ điển. Nếu có nhiều kết quả, hãy trả về bất kỳ kết quả nào.

### Example:
```text
Input: target = "apple", dictionary = ["blade"]
Output: "a4" (or "4e", or "1p3", etc.)
Explanation: 
Abbreviations of "apple" are ["5", "a4", "4e", "1p3", "a1p2", "3l1", "a2l1", "2p2", "apple", ...].
"5" matches "blade" (length matches)? No, "5" matches any word of length 5.
Wait, "5" matches "blade" because both have length 5.
"a4" means 'a' followed by 4 chars. "apple" starts with 'a', "blade" doesn't. So "a4" is valid.
"4e" means 4 chars followed by 'e'. "apple" ends with 'e', "blade" ends with 'e'. So "4e" matches "blade".
"a4" is one of the shortest.
```

## Constraints / Ràng buộc
- `1 <= target.length <= 21`
- `0 <= dictionary.length <= 1000`
- All words consist of lowercase English letters.
- Words in `dictionary` have various lengths.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Bitmask + Backtracking / Bitmask + Quay lui
Only dictionary words with the same length as `target` can potentially match its abbreviation. Let `N` be the length of `target`.
1. Compute "difference masks" for each relevant dictionary word. `diffMask[i]` has bit `j` set if `target[j] != dictionary[i][j]`.
2. An abbreviation mask `mask` (where bit `j=1` means keeping `target[j]`, `0` means replacing) matches a dictionary word if `(mask & diffMask) == 0`. (No character kept in the abbreviation differs from the character at the same position in the dictionary word).
3. We need a `mask` such that `(mask & diffMask[i]) != 0` for ALL `i`.
4. We want to find such a `mask` that minimizes the abbreviation length.

Abbreviation length calculation for `mask`:
- Total length of the abbreviation string. Consecutive bits `0` in the mask are merged into one number.
- Example: `10011` (N=5): segment 1 (1 bit), segment 2 (2 bits), segment 3 (1 bit), segment 4 (1 bit). Total length = 4.

### Complexity / Độ phức tạp
- **Time**: Worst case O(2^N). But pruning with bitmasks makes it faster.
- **Space**: O(Dictionary Size).

---

## Analysis / Phân tích

### Approach: Exhaustive Search with Bitmasks

**Algorithm**:
1.  Filter dictionary words by length.
2.  Generate `diffMasks`.
3.  Use DFS to find the mask with the minimum abbreviation length.
4.  Convert the best mask to the string result.

---

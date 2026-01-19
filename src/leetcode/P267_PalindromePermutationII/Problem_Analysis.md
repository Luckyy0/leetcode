# 267. Palindrome Permutation II / Hoán Vị Đối Xứng II

## Problem Description / Mô tả bài toán
Given a string `s`, return all the palindromic permutations (without duplicates) of it.
Cho một chuỗi `s`, trả về tất cả các hoán vị đối xứng (không trùng lặp) của nó.

You may return the answer in **any order**. If `s` has no palindromic permutation, return an empty list.
Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**. Nếu `s` không có hoán vị đối xứng nào, hãy trả về danh sách rỗng.

### Example 1:
```text
Input: s = "aabb"
Output: ["abba","baab"]
```

### Example 2:
```text
Input: s = "abc"
Output: []
```

## Constraints / Ràng buộc
- `1 <= s.length <= 16`
- `s` consists of only lowercase English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Backtracking with Pruning / Quay Lui có Cắt Tỉa
1.  **Check Feasibility**: First, use the logic from Problem 266 to check if a palindrome is possible (at most 1 odd char). If not, return empty.
2.  **Construct Half**: Identify characters that will form the left half and the (optional) middle character.
    - Count frequency of each character.
    - If a char has count `C`, we use `C/2` instances of it for the left half.
    - If `C` is odd, one instance is the `mid` character.
3.  **Permute Half**: Generate all unique permutations of the "half string".
4.  **Mirror**: For each permutation `P`, construct `P + mid + reverse(P)`.

**Algorithm**:
1.  Count chars. Validate odd count <= 1.
2.  Build `halfString` list and identify `mid` char.
3.  Use backtracking to permute `halfString`. Use a `visited` array (or `count` map) to handle duplicates (standard permutation with duplicates logic).
    - Sort `halfString` to easily skip duplicates: `if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue`.
4.  For each valid permutation, combine and add to result.

### Complexity / Độ phức tạp
- **Time**: O( (N/2)! * N ) - Permutations of half length. `N <= 16`, so `N/2 <= 8`. `8! = 40320`. Very fast.
- **Space**: O(N) recursion.

---

## Analysis / Phân tích

### Approach: Generate Permutations of Half

**Edge Cases**:
1.  **No palindrome possible**: Pre-check handles.
2.  **Single char**: "a" -> "a".

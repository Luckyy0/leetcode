# Analysis for Palindrome Permutation II
# *Phân tích cho bài toán Hoán vị Palindrome II*

## 1. Problem Essence & Constructive Backtracking
## *1. Bản chất vấn đề & Quay lui xây dựng*

### Logic
### *Logic*
1.  Check if palindrome permutation is possible (Problem 266). If not, return empty.
2.  If possible, build the "Half String".
    - "aabbc" (Length 5). Odd char 'c'. Half chars: 'a', 'b'.
    - We permute 'a', 'b' -> "ab", "ba".
    - Construct full palindromes: "ab" + 'c' + "ba" = "abcba". "ba" + 'c' + "ab" = "bacab".
3.  The problem reduces to: **Generate all unique permutations of a set of characters (the half set).**
    - This is effectively LeetCode 47 (Permutations II).

### Algorithm
### *Thuật toán*
1.  Map counts. Check odd count (`odd > 1` -> fail).
2.  Create `halfList` of characters.
    - Logic: For each char `c` with count `k`: add `k/2` instances to `halfList`.
    - Note `mid = oddChar` logic.
3.  Generate permutations of `halfList`.
    - Use `visited` array or swapping with sorting for duplicates.
4.  For each permutation `p`:
    - Res = `p + (mid if exists) + reverse(p)`.
    - Add to result.

---

## 2. Approach: Backtracking
## *2. Hướng tiếp cận: Quay lui*

### Logic
### *Logic*
Standard permutation with duplicates handling.
Sort `halfList`.
DFS:
- If `curr.len == n/2`: build and add to result.
- Loop `i`:
    - If used or duplicate (`i>0 && nums[i]==nums[i-1] && !used[i-1]`): skip.
    - Add to path.
    - Recurse.
    - Backtrack.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Reduction:** Solving on `N/2` length is much faster than `N!`.
    *Rút gọn: Giải trên độ dài N/2 nhanh hơn nhiều so với N!.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O((N/2)!)$.
    *Độ phức tạp thời gian: $O((N/2)!)$.*
*   **Space Complexity:** $O(N)$.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** "aabb"
Counts: a:2, b:2.
Half: [a, b]. Mid: "".
Permutations of [a, b]:
1.  "ab" -> "ab" + "" + "ba" -> "abba".
2.  "ba" -> "ba" + "" + "ab" -> "baab".

**Input:** "aabbc"
Counts: a:2, b:2, c:1.
Half: [a, b]. Mid: "c".
Permutations of [a, b]:
1.  "ab" -> "abcba".
2.  "ba" -> "bacab".

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Combine HashMap check with Permutations II.
*Kết hợp kiểm tra HashMap với Hoán vị II.*
---
*Một nửa câu chuyện (half string) cũng đủ để kể lại toàn bộ sự thật (palindrome), nếu bạn biết cách soi gương (reverse) chính mình.*
Half the story (half string) is enough to tell the whole truth (palindrome), if you know how to mirror (reverse) yourself.

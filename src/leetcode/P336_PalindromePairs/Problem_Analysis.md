# 336. Palindrome Pairs / Cặp Palindrome

## Problem Description / Mô tả bài toán
Given a list of **unique** words, return all the pairs of the **distinct** indices `(i, j)` in the given list, so that the concatenation of the two words `words[i] + words[j]` is a palindrome.
Cho một danh sách các từ **duy nhất**, trả về tất cả các cặp chỉ số **khác nhau** `(i, j)` trong danh sách, sao cho việc nối hai từ `words[i] + words[j]` tạo thành một palindrome.

### Example 1:
```text
Input: words = ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
```

### Example 2:
```text
Input: words = ["bat","tab","cat"]
Output: [[0,1],[1,0]]
```

### Example 3:
```text
Input: words = ["a",""]
Output: [[0,1],[1,0]]
```

## Constraints / Ràng buộc
- `1 <= words.length <= 5000`
- `0 <= words[i].length <= 300`
- `words[i]` consists of lower-case English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### HashMap + Word Splitting / HashMap + Cắt Từ
To check if `A + B` is palindrome:
1.  If length A == length B: `A` must be reverse of `B`.
2.  If length A < length B: `B` must end with reverse of `A`, AND the remaining prefix of `B` must be a palindrome.
    - `B = PalindromePrefix + ReverseA`. Then `A + B = A + PalindromePrefix + ReverseA` -> Palindrome.
3.  If length A > length B: `A` must start with reverse of `B`, AND the remaining suffix of `A` must be a palindrome.
    - `A = ReverseB + PalindromeSuffix`. Then `A + B = ReverseB + PalindromeSuffix + B` -> Palindrome.

**Algorithm (O(TotalChars^2) or O(N * K^2))**:
1.  Store all `words` in a Map `{word: index}`.
2.  For each word `w` at index `i`:
    - Iterate split point `j` from 0 to `w.length`.
    - Split `w` into `str1` and `str2`.
    - **Case 1**: If `isPalindrome(str1)`, then if `reverse(str2)` exists in map (at index `k != i`), then `(k, i)` is a valid pair. (Because `map[rev(str2)] + w = str2_rev + str1 + str2`. If str1 is pal, `str2_rev + str1 + str2` is pal. E.g. `s + lls`. `s` is pal(str1), `lls`(str2) rev is `sll`... Not clear.
    Let's rephrase:
    We check for each word `w`.
    **Splitting logic**:
    `w = left + right`.
    - If `isPalindrome(left)`: Check if `reverse(right)` exists. If yes (idx `k`), and `k != i`.
      Then `words[k] + words[i]` = `reverse(right) + left + right`. Since `left` is pal, central part is pal. Outer are mirrors. -> Add `(k, i)`.
    - If `isPalindrome(right)`: Check if `reverse(left)` exists. If yes (idx `k`), and `k != i`.
      Then `words[i] + words[k]` = `left + right + reverse(left)`. Since `right` is pal, central is pal. -> Add `(i, k)`.
    - **Important**: To avoid duplicates (e.g. empty string case), care with split loops. `j` up to `len`. Empty string handling needs care.
    Typically: `left` can be empty, `right` can be empty.
    If `left` empty: `w = "" + w`. isPal("")=true. reverse(w) exists? -> `(k, i)`. `words[k]+words[i]` is pal.
    If `right` empty: `w = w + ""`. isPal("")=true. reverse(w) exists? -> `(i, k)`. `words[i]+words[k]` is pal.
    Duplicate avoidance: Only run `right` empty logic if `j != 0`? Or filter unique.
    Standard: Loop `j` from `0` to `len` (inclusive).
    `left = w.substring(0, j)`, `right = w.substring(j)`.
    If `isPalindrome(left)` ...
    If `isPalindrome(right)` ... `right.length() != 0` to assume strict split or handle duplicates.

### Complexity / Độ phức tạp
- **Time**: `O(N * K^2)` where K is av length. Splitting is K, isPalindrome is K/2.
- **Space**: `O((N + Result) * K)`.

---

## Analysis / Phân tích

### Approach: Hash Map Lookups

**Algorithm**:
1.  `Map<String, Integer> map`.
2.  `List<List<Integer>> res`.
3.  Fill map.
4.  Loop `word` in `words` (idx `i`):
    - Loop `j` from 0 to `word.len`.
    - `str1` (0..j), `str2` (j..len).
    - If `isPalindrome(str1)`:
        - `rev2 = reverse(str2)`.
        - If `map` contains `rev2` at `k` and `k != i`:
            - Add `(k, i)`. (Order: `words[k] + words[i]` -> `rev2 + str1 + str2`. Since `rev2` is mirror of `str2`, and `str1` is pal, it works).
    - If `isPalindrome(str2)`:
        - `rev1 = reverse(str1)`.
        - If `map` contains `rev1` at `k` and `k != i` AND `str2.length() != 0` (avoid duplication with case 1 when full word is pal?):
            - Case `j=len`, `str1=word`, `str2=""`. `isPal("")` true. `rev1=reverse(word)`. Found `k`. `(i, k)`.
            - Case `j=0`, `str1=""`, `str2=word`. `isPal("")` true. `rev2=reverse(word)`. Found `k`. `(k, i)`.
            - `(i, k)` vs `(k, i)`.
            - To avoid double counting when both `str1` and `str2` can be empty or covered:
            - If `str2.length() != 0`: Add `(i, k)`. (Order: `words[i] + words[k]` -> `str1 + str2 + rev1`. Works).
            - Why `str2.length() != 0`? Because if `str2` is empty, `str1` is whole word. This case is covered when `j=0` in the "isPalindrome(str1)" block where `str1` is empty (no wait).
            - When `j=0`: `str1=""`, `str2=word`. Case 1: isPal("") -> check rev(word). Add `(k, i)`.
            - When `j=len`: `str1=word`, `str2=""`. Case 1: isPal(word) -> check rev(""). Empty string in map? Yes. Add `(k, i)`.
            - Case 2 block: `isPalindrome(str2)`.
            - If `j=0`: `str1=""`, `str2=word`. isPal(word) -> check rev(""). Add `(i, k)`. (Dup with `j=len` Case 1?).
            - **Rule**: In Case 2, only proceed if `str2.length() != 0`.

---

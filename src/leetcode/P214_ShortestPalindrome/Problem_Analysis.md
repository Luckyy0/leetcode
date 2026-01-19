# 214. Shortest Palindrome / Chuỗi Đối Xứng Ngắn Nhất

## Problem Description / Mô tả bài toán
You are given a string `s`. You can convert `s` to a palindrome by adding characters in front of it.
Bạn được cung cấp một chuỗi `s`. Bạn có thể chuyển đổi `s` thành một chuỗi đối xứng bằng cách thêm các ký tự vào trước nó.

Return the shortest palindrome you can find by performing this transformation.
Hãy trả về chuỗi đối xứng ngắn nhất bạn có thể tìm thấy bằng cách thực hiện phép biến đổi này.

### Example 1:
```text
Input: s = "aacecaaa"
Output: "aaacecaaa"
```

### Example 2:
```text
Input: s = "abcd"
Output: "dcbabcd"
```

## Constraints / Ràng buộc
- `0 <= s.length <= 5 * 10^4`
- `s` consists of lowercase English letters only.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Longest Palindromic Prefix / Tiền tố Đối xứng Dài nhất
The problem asks to add characters *only* at the front.
To minimize the added characters, we need to maximize the part of the original string `s` that starts at index 0 and is already a palindrome.

Let `P` be the longest palindromic prefix of `s`.
Let `S` be the remaining suffix (`s = P + S`).
The added characters must be `reverse(S)`.
The result is `reverse(S) + P + S` (which simplifies to `reverse(S) + s`).

**How to find `P` efficiently?**
We can use the **KMP Algorithm (Knuth-Morris-Pratt)** logic.
1.  Construct a new string `temp = s + "#" + reverse(s)`.
2.  Compute the **LPS (Longest Prefix Suffix)** array for `temp`.
3.  The last value of the LPS array, `lps[temp.length - 1]`, represents the length of the longest prefix of `s` that is also a suffix of `reverse(s)`. This effectively corresponds to the longest palindromic prefix of `s`.

---

## Analysis / Phân tích

### Approach: KMP Algorithm (LPS Array)

**Algorithm**:
1.  Create `rev = reverse(s)`.
2.  Create `combined = s + "#" + rev`.
3.  Compute LPS array for `combined`.
    - `lps[i]` is the length of the longest proper prefix of `combined[0...i]` that is also a suffix of `combined[0...i]`.
4.  The length of the longest palindromic prefix is `len = lps[combined.length - 1]`.
5.  Extract the non-palindromic suffix of `s`: `suffix = s.substring(len)`.
6.  Result is `reverse(suffix) + s`.

### Complexity / Độ phức tạp
- **Time**: O(N) - Building string and LPS array takes linear time.
- **Space**: O(N) - To store `combined` string and `lps` array.

---

## Edge Cases / Các trường hợp biên
1.  **Empty string**: Returns empty.
2.  **Already Palindrome**: `lps` will handle `len = s.length`. Suffix empty. Result `s`.
3.  **No Palindromic Prefix > 1**: `len = 1` (single char is palindrome) or `0` (if empty).
4.  **All same chars**: `len = s.length`.

# 1392. Longest Happy Prefix / Tiền tố Hạnh phúc Dài nhất

## Problem Description / Mô tả bài toán
String `s`. "Happy prefix" is a non-empty prefix that is also a suffix (excluding the string itself).
Return longest happy prefix.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### KMP Algorithm (LPS Array)
The LPS (Longest Prefix Suffix) array in KMP algorithm computes exactly this value.
`next[i]` = length of longest proper prefix of `s[0...i]` that is also a suffix of `s[0...i]`.
We only need `next[n-1]`.
Algorithm:
`j = 0` (length of previous longest prefix).
Loop `i` from 1 to n-1.
While `j>0` and `s[i] != s[j]`, `j = next[j-1]`.
If `s[i] == s[j]`, `j++`.
`next[i] = j`.
Result is `s.substring(0, next[n-1])`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) for LPS array.

---

## Analysis / Phân tích

### Approach: KMP Preprocessing / Rolling Hash
Implement the preprocessing step of KMP to compute the `lps` array. The value at the last position of the `lps` array gives the length of the longest proper prefix that is also a suffix. Return the substring of that length.
Alternatively, use Rolling Hash to compare prefix and suffix in O(N).
Check hash of `s[0...len-1]` vs `s[n-len...n-1]`. Iterate `len`? Or iterate once updating hashes.
Accumulate `prefixHash` and `suffixHash` as we iterate. Keep track of max valid length.
Example: `s[0]` vs `s[n-1]`, then `s[0..1]` vs `s[n-2..n-1]`.
KMP is safer against collisions (100% correct).

Thực hiện bước tiền xử lý của KMP để tính toán mảng `lps`. Giá trị tại vị trí cuối cùng của mảng `lps` cho biết độ dài của tiền tố thích hợp dài nhất cũng là hậu tố. Trả về chuỗi con có độ dài đó.
Mặt khác, sử dụng Rolling Hash để so sánh tiền tố và hậu tố trong O(N).
KMP an toàn hơn trước các va chạm (chính xác 100%).

---

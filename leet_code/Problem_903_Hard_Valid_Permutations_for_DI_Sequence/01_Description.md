# Result for Valid Permutations for DI Sequence
# *Kết quả cho bài toán Các Hoán vị Hợp lệ cho Dãy DI*

## Description
## *Mô tả*

You are given a string `s` of length `n` where `s[i]` is either:
*Bạn được cho một chuỗi `s` có độ dài `n` trong đó `s[i]` là:*

*   `'D'` means decreasing, or
    *   `'D'` nghĩa là giảm, hoặc*
*   `'I'` means increasing.
    *   `'I'` nghĩa là tăng.*

A permutation `perm` of `n + 1` integers of all the integers in the range `[0, n]` is called a **valid permutation** if for all valid `i`:
*Một hoán vị `perm` của `n + 1` số nguyên bao gồm tất cả các số nguyên trong khoảng `[0, n]` được gọi là **hoán vị hợp lệ** nếu với mọi `i` hợp lệ:*

*   If `s[i] == 'D'`, then `perm[i] > perm[i + 1]`, and
    *   Nếu `s[i] == 'D'`, thì `perm[i] > perm[i + 1]`, và*
*   If `s[i] == 'I'`, then `perm[i] < perm[i + 1]`.
    *   Nếu `s[i] == 'I'`, thì `perm[i] < perm[i + 1]`.*

Return *the number of valid permutations* `perm`. Since the answer may be large, return it **modulo** `10^9 + 7`.
*Hãy trả về *số lượng hoán vị hợp lệ* `perm`. Vì câu trả lời có thể rất lớn, hãy trả về nó **modulo** `10^9 + 7`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "DID"
**Output:** 5
**Explanation:** 
The 5 valid permutations of (0, 1, 2, 3) are:
(1, 0, 3, 2)
(2, 0, 3, 1)
(2, 1, 3, 0)
(3, 0, 2, 1)
(3, 1, 2, 0)

## Example 2:
## *Ví dụ 2:*

**Input:** s = "D"
**Output:** 1

---

## Constraints:
## *Ràng buộc:*

*   `n == s.length`
*   `1 <= n <= 200`
*   `s[i]` is either `'I'` or `'D'`.

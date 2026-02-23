# Result for DI String Match
# *Kết quả cho bài toán Khớp chuỗi DI*

## Description
## *Mô tả*

A permutation `perm` of `n + 1` integers of all the integers in the range `[0, n]` can be represented as a string `s` of length `n` where:
*Một hoán vị `perm` gồm `n + 1` số nguyên của tất cả các số nguyên trong khoảng `[0, n]` có thể được biểu diễn dưới dạng một chuỗi `s` có độ dài `n` trong đó:*

*   `s[i] == 'I'` if `perm[i] < perm[i + 1]`, and
    *   `s[i] == 'I'` nếu `perm[i] < perm[i + 1]`, và*
*   `s[i] == 'D'` if `perm[i] > perm[i + 1]`.
    *   `s[i] == 'D'` nếu `perm[i] > perm[i + 1]`.*

Given a string `s`, reconstruct the permutation `perm` and return it. If there are multiple valid permutations perm, return **any of them**.
*Cho một chuỗi `s`, hãy tái tạo hoán vị `perm` và trả về nó. Nếu có nhiều hoán vị hợp lệ perm, hãy trả về **bất kỳ hoán vị nào trong số đó**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "IDID"
**Output:** [0,4,1,3,2]

## Example 2:
## *Ví dụ 2:*

**Input:** s = "III"
**Output:** [0,1,2,3]

## Example 3:
## *Ví dụ 3:*

**Input:** s = "DDI"
**Output:** [3,2,0,1]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 10^5`
*   `s[i]` is either `'I'` or `'D'`.

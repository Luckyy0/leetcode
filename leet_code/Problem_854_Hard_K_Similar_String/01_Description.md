# Result for K-Similar Strings
# *Kết quả cho bài toán Chuỗi K-Tương đồng*

## Description
## *Mô tả*

Strings `s1` and `s2` are `k`-similar if we can swap the positions of two letters in `s1` exactly `k` times so that the resulting string equals `s2`.
*Các chuỗi `s1` và `s2` là `k`-tương đồng nếu chúng ta có thể tráo đổi vị trí của hai chữ cái trong `s1` đúng `k` lần sao cho chuỗi kết quả bằng `s2`.*

Given two anagrams `s1` and `s2`, return the smallest `k` for which `s1` and `s2` are `k`-similar.
*Cho hai chuỗi hoán vị `s1` và `s2`, hãy trả về giá trị `k` nhỏ nhất để `s1` và `s2` là `k`-tương đồng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s1 = "ab", s2 = "ba"
**Output:** 1

## Example 2:
## *Ví dụ 2:*

**Input:** s1 = "abc", s2 = "bca"
**Output:** 2

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s1.length <= 20`
*   `s2.length == s1.length`
*   `s1` and `s2` contain only lowercase letters from `'a'` to `'f'`.
*   `s2` is an anagram of `s1`.

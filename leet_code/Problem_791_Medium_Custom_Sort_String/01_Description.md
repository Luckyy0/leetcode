# Result for Custom Sort String
# *Kết quả cho bài toán Sắp xếp Chuỗi Tùy chỉnh*

## Description
## *Mô tả*

You are given two strings `order` and `s`. All the characters of `order` are **unique** and were sorted in some custom order previously.
*Bạn được cho hai chuỗi `order` và `s`. Tất cả các ký tự của `order` là **duy nhất** và đã được sắp xếp theo một thứ tự tùy chỉnh nào đó trước đây.*

Permute the characters of `s` so that they match the order that `order` was sorted. More specifically, if a character `x` occurs before a character `y` in `order`, then `x` should occur before `y` in the permuted string.
*Hãy hoán vị các ký tự của `s` sao cho chúng khớp với thứ tự đã được sắp xếp của `order`. Cụ thể hơn, nếu ký tự `x` xuất hiện trước ký tự `y` trong `order`, thì `x` nên xuất hiện trước `y` trong chuỗi đã hoán vị.*

Return *any permutation of `s` that satisfies this property*.
*Trả về *bất kỳ hoán vị nào của `s` thỏa mãn tính chất này*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** order = "cba", s = "abcd"
**Output:** "cbad"
**Explanation:** 
"a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", "a". 
Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid.

## Example 2:
## *Ví dụ 2:*

**Input:** order = "cbafg", s = "abcd"
**Output:** "cbad"

---

## Constraints:
## *Ràng buộc:*

*   `1 <= order.length <= 26`
*   `1 <= s.length <= 200`
*   `order` and `s` consist of lowercase English letters.
*   All the characters of `order` are **unique**.

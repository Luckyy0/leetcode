# Result for Count Binary Substrings
# *Kết quả cho bài toán Đếm Chuỗi con Nhị phân*

## Description
## *Mô tả*

Given a binary string `s`, return the number of non-empty substrings that have the same number of `0`'s and `1`'s, and all the `0`'s and all the `1`'s in these substrings are grouped consecutively.
*Cho một chuỗi nhị phân `s`, hãy trả về số lượng các chuỗi con không rỗng có số lượng `0` và `1` bằng nhau, và tất cả các chữ số `0` cũng như tất cả các chữ số `1` trong các chuỗi con này được nhóm liên tiếp.*

Substrings that occur multiple times are counted the number of times they occur.
*Các chuỗi con xuất hiện nhiều lần được tính theo số lần chúng xuất hiện.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "00110011"
**Output:** 6
**Explanation:** There are 6 substrings that have equal number of consecutive 0's and 1's: "0011", "01", "1100", "10", "0011", and "01".
Notice that some of these substrings repeat, but they are from different positions.
"00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.

## Example 2:
## *Ví dụ 2:*

**Input:** s = "10101"
**Output:** 4
**Explanation:** There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 0's and 1's.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 10^5`
*   `s[i]` is either `'0'` or `'1'`.

# Result for Strange Printer
# *Kết quả cho bài toán Máy in Kỳ lạ*

## Description
## *Mô tả*

There is a strange printer with the following two special properties:
*Có một chiếc máy in kỳ lạ với hai đặc tính đặc biệt sau:*
1.  The printer can only print a sequence of the **same character** each time.
    *   *Máy in chỉ có thể in một dãy các **ký tự giống nhau** mỗi lần.*
2.  At each turn, the printer can print new characters starting from and ending at any place and will cover the original existing characters.
    *   *Tại mỗi lượt, máy in có thể in các ký tự mới bắt đầu và kết thúc tại bất kỳ vị trí nào và sẽ bao phủ các ký tự gốc hiện có.*

Given a string `s`, return the minimum number of turns the printer needed to print it.
*Cho một chuỗi `s`, hãy trả về số lượt tối thiểu mà máy in cần để in nó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "aaabbb"
**Output:** 2
**Explanation:** Print "aaa" first and then print "bbb".

## Example 2:
## *Ví dụ 2:*

**Input:** s = "aba"
**Output:** 2
**Explanation:** Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 100`
*   `s` consists of lowercase English letters.

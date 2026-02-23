# Result for UTF-8 Validation
# *Kết quả cho bài toán Xác thực UTF-8*

## Description
## *Mô tả*

Given an integer array `data` representing the data, return whether it is a valid UTF-8 encoding.
*Cho một mảng số nguyên `data` đại diện cho dữ liệu, hãy trả về kết quả liệu nó có phải là mã hóa UTF-8 hợp lệ hay không.*

A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
*Một ký tự trong UTF8 có thể dài từ 1 đến 4 byte, tuân theo các quy tắc sau:*

1. For a 1-byte character, the first bit is a 0, followed by its Unicode code.
2. For an n-bytes character, the first n bits are all one's, the n + 1 bit is 0, followed by n - 1 bytes with the most significant 2 bits being 10.
*1. Đối với ký tự 1 byte, bit đầu tiên là 0, theo sau là mã Unicode của nó.*
*2. Đối với ký tự n byte, n bit đầu tiên đều là số 1, bit n+1 là 0, theo sau là n-1 byte với 2 bit quan trọng nhất là 10.*

This is how the UTF-8 encoding would look:
```
   Char. length |   UTF-8 Octet Sequence
      (bytes)   |            (binary)
   -----------------------------------------
      1         | 0xxxxxxx
      2         | 110xxxxx 10xxxxxx
      3         | 1110xxxx 10xxxxxx 10xxxxxx
      4         | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
```
*Note: The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. This means each integer represents only 1 byte of data.*

## Example 1:
## *Ví dụ 1:*

**Input:** `data = [197, 130, 1]`
**Output:** `true`
**Explanation:** data represents the octet sequence: 11000101 10000010 00000001.
This is a valid 2-byte character followed by a 1-byte character.

## Example 2:
## *Ví dụ 2:*

**Input:** `data = [235, 140, 4]`
**Output:** `false`
**Explanation:** data represents the octet sequence: 11101011 10001100 00000100.
The first 3 bits are 111 and the 4th bit is 0, which means it is a 3-byte character.
The next byte is 10001100, which is correct.
The next byte is 00000100, which is incorrect since it should be 10xxxxxx.

## Constraints:
## *Ràng buộc:*

*   `1 <= data.length <= 2 * 10^4`
*   `0 <= data[i] <= 255` (Each integer is a byte).

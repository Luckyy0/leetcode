# Result for Magical String
# *Kết quả cho bài toán Chuỗi Ma thuật*

## Description
## *Mô tả*

A magical string `s` consists of only '1' and '2' and obeys the following rules:
*   The string `s` is magical because concatenating the number of contiguous occurrences of characters '1' and '2' generates the string `s` itself.
    *Chuỗi `s` được gọi là ma thuật vì việc nối số lần xuất hiện liên tiếp của các ký tự '1' và '2' sẽ tạo ra chính chuỗi `s`.*

The first few elements of string `s` is the following: `s = "1221121221221121122...`
*Vài phần tử đầu tiên của chuỗi `s` là: `s = "1221121221221121122...`*

If we group the consecutive '1's and '2's in `s`, it will be:
*Nếu chúng ta nhóm các số '1' và '2' liên tiếp trong `s`, nó sẽ là:*
`1 22 11 2 1 22 1 22 11 2 11 22 ......`

and the occurrences of each group are:
*và số lần xuất hiện của mỗi nhóm là:*
`1 2 2 1 1 2 1 2 2 1 2 2 ......`

You can see that the occurrence sequence above is the `s` itself.
*Bạn có thể thấy rằng dãy số lần xuất hiện ở trên chính là `s`.*

Given an integer `n`, return the number of '1's in the first `n` number in the magical string `s`.
*Cho một số nguyên `n`, hãy trả về số lượng số '1' trong `n` số đầu tiên của chuỗi ma thuật `s`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 6`
**Output:** `3`
**Explanation:** The first 6 elements of magical string s is "122112" and it contains three 1's, so return 3.

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 1`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 10^5`

# Result for Split Array into Fibonacci Sequence
# *Kết quả cho bài toán Chia Mảng thành Dãy Fibonacci*

## Description
## *Mô tả*

You are given a string of digits `num`, such as `"123456579"`. We can split it into a Fibonacci-like sequence `[a, b, c, d, ...]` such that:
*Bạn được cho một chuỗi các chữ số `num`, ví dụ `"123456579"`. Chúng ta có thể chia nó thành một dãy giống Fibonacci `[a, b, c, d, ...]` sao cho:*

1.  Each piece is interpreted as a non-negative integer.
    *Mỗi phần được hiểu là một số nguyên không âm.*
2.  Each piece does not have leading zeroes, except for the integer `0` itself.
    *Mỗi phần không có số 0 ở đầu, ngoại trừ chính số 0.*
3.  The sequence has at least **3** numbers.
    *Dãy có ít nhất **3** số.*
4.  `a + b == c`, `b + c == d`, and so on.
    *`a + b == c`, `b + c == d`, và cứ tiếp tục như vậy.*

Return *any such sequence as a list of integers, or return an empty list if it's impossible*.
*Hãy trả về *bất kỳ dãy nào như vậy dưới dạng danh sách các số nguyên, hoặc trả về danh sách trống nếu không khả thi*.*

Note: The integers in the sequence must fit in a 32-bit signed integer (`<= 2^31 - 1`).
*Lưu ý: Các số nguyên trong dãy phải vừa với số nguyên có dấu 32-bit (`<= 2^31 - 1`).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** num = "1101111"
**Output:** [11,0,11,11]
**Explanation:** The output [110, 1, 111] would also be accepted.

## Example 2:
## *Ví dụ 2:*

**Input:** num = "123456579"
**Output:** [123,456,579]

## Example 3:
## *Ví dụ 3:*

**Input:** num = "0123"
**Output:** []
**Explanation:** Leading zeroes are not allowed, so "01", "2", "3" is not valid.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= num.length <= 200`
*   `num` contains only digits.

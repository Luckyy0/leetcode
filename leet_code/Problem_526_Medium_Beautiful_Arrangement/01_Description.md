# Result for Beautiful Arrangement
# *Kết quả cho bài toán Sắp xếp Đẹp*

## Description
## *Mô tả*

Suppose you have `n` integers from `1` to `n`. We define a beautiful arrangement as an array that is constructed by these `n` numbers successfully if one of the following is true for the `i^th` position (`1 <= i <= n`) in this array:
*Giả sử bạn có `n` số nguyên từ `1` đến `n`. Chúng tôi định nghĩa một cách sắp xếp đẹp là một mảng được xây dựng thành công bởi `n` số này nếu một trong những điều sau đây là đúng cho vị trí thứ `i` (`1 <= i <= n`) trong mảng này:*

*   The number at the `i^th` position is divisible by `i`.
    *Số ở vị trí thứ `i` chia hết cho `i`.*
*   `i` is divisible by the number at the `i^th` position.
    *`i` chia hết cho số ở vị trí thứ `i`.*

Given an integer `n`, return *the number of the beautiful arrangements that you can construct*.
*Cho một số nguyên `n`, hãy trả về *số lượng các cách sắp xếp đẹp mà bạn có thể xây dựng*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 2`
**Output:** `2`
**Explanation:** 
The first beautiful arrangement is [1, 2]:
Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
The second beautiful arrangement is [2, 1]:
Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 1`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 15`

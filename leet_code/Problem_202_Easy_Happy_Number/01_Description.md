# Result for Happy Number
# *Kết quả cho bài toán Số hạnh phúc*

## Description
## *Mô tả*

Write an algorithm to determine if a number `n` is happy.
*Viết một thuật toán để xác định xem số `n` có hạnh phúc hay không.*

A **happy number** is a number defined by the following process:
*Một **số hạnh phúc** là một số được định nghĩa bởi quy trình sau:*

1.  Starting with any positive integer, replace the number by the sum of the squares of its digits.
    *Bắt đầu với bất kỳ số nguyên dương nào, thay thế số đó bằng tổng bình phương các chữ số của nó.*
2.  Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    *Lặp lại quy trình cho đến khi số bằng 1 (nơi nó sẽ dừng lại), hoặc nó lặp vô tận trong một chu kỳ không bao gồm 1.*
3.  Those numbers for which this process ends in 1 are happy.
    *Những số mà quy trình kết thúc bằng 1 là số hạnh phúc.*

Return `true` *if* `n` *is a happy number, and* `false` *if not*.
*Trả về `true` *nếu* `n` *là số hạnh phúc, và* `false` *nếu không.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 19`
**Output:** `true`
**Explanation:**
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 2`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 2^31 - 1`

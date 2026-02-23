# Result for Elimination Game
# *Kết quả cho bài toán Trò chơi Loại trừ*

## Description
## *Mô tả*

You have a list of sorted integers from `1` to `n`. Beginning from left to right, remove the first number and every other number afterward until you reach the end of the list.
*Bạn có một danh sách các số nguyên được sắp xếp từ `1` đến `n`. Bắt đầu từ trái sang phải, hãy loại bỏ con số đầu tiên và sau đó là mọi con số cách quãng khác cho đến khi bạn đi đến cuối danh sách.*

Repeat the previous step again, but this time from right to left, remove the rightmost number and every other number from the remaining numbers.
*Lặp lại bước trước đó một lần nữa, nhưng lần này từ phải sang trái, loại bỏ con số ngoài cùng bên phải và mọi con số cách quãng khác từ các con số còn lại.*

We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
*Chúng ta tiếp tục lặp lại các bước, xen kẽ từ trái sang phải và từ phải sang trái, cho đến khi chỉ còn lại một con số duy nhất.*

Given the integer `n`, return *the last remaining number*.
*Cho số nguyên `n`, hãy trả về *con số còn lại cuối cùng*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 9`
**Output:** `6`
**Explanation:**
1 2 3 4 5 6 7 8 9
2 4 6 8 (left to right)
2 6 (right to left)
6 (left to right)

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 1`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 10^9`

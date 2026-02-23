# Result for Couples Holding Hands
# *Kết quả cho bài toán Các Cặp đôi Nắm Tay*

## Description
## *Mô tả*

There are `n` couples sitting in `2n` seats arranged in a row and wanting to hold hands.
*Có `n` cặp đôi đang ngồi trên `2n` chiếc ghế được sắp xếp thành một hàng và muốn nắm tay nhau.*

The people and seats are represented by an integer array `row` where `row[i]` is the ID of the person sitting in the `i-th` seat. The couples are numbered in order of their IDs. The first couple is `(0, 1)`, the second couple is `(2, 3)`, and so on with the last couple being `(2n - 2, 2n - 1)`.
*Mọi người và chỗ ngồi được đại diện bởi một mảng số nguyên `row` trong đó `row[i]` là ID của người ngồi ở ghế thứ `i`. Các cặp đôi được đánh số theo thứ tự ID của họ. Cặp đầu tiên là `(0, 1)`, cặp thứ hai là `(2, 3)`, và cứ thế cho đến cặp cuối cùng là `(2n - 2, 2n - 1)`.*

Return *the minimum number of swaps so that every couple is sitting side by side*. A swap consists of choosing any two people, then they stand up and switch seats.
*Trả về *số lần hoán đổi tối thiểu để mọi cặp đôi đều ngồi cạnh nhau*. Một lần hoán đổi bao gồm việc chọn bất kỳ hai người nào, sau đó họ đứng dậy và đổi chỗ cho nhau.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** row = [0,2,1,3]
**Output:** 1
**Explanation:** We only need to swap the second (row[1]) and third (row[2]) person.
row becomes [0,1,2,3].

## Example 2:
## *Ví dụ 2:*

**Input:** row = [3,2,0,1]
**Output:** 0
**Explanation:** All couples are already seated side by side.

---

## Constraints:
## *Ràng buộc:*

*   `2n == row.length`
*   `2 <= n <= 30`
*   `n` is even.
*   `0 <= row[i] < 2n`
*   All the elements of `row` are unique.

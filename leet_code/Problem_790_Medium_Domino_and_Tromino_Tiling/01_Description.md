# Result for Domino and Tromino Tiling
# *Kết quả cho bài toán Lát gạch Domino và Tromino*

## Description
## *Mô tả*

You have two types of tiles: a `2 x 1` domino shape and a tromino shape. You may rotate these shapes.
*Bạn có hai loại gạch: hình domino `2 x 1` và hình tromino. Bạn có thể xoay các hình này.*

Given an integer `n`, return the number of ways to tile an `2 x n` board. Since the answer may be very large, return it **modulo** `10^9 + 7`.
*Cho một số nguyên `n`, trả về số cách để lát một bảng `2 x n`. Vì câu trả lời có thể rất lớn, hãy trả về kết quả **modulo** `10^9 + 7`.*

In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.
*Trong một cách lát, mỗi ô vuông phải được che phủ bởi một viên gạch. Hai cách lát là khác nhau khi và chỉ khi có hai ô liền kề theo 4 hướng trên bảng sao cho chính xác một trong các cách lát có cả hai ô được chiếm giữ bởi một viên gạch.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 3
**Output:** 5
**Explanation:** The five different ways are show below:
(Images of tiling configurations)

## Example 2:
## *Ví dụ 2:*

**Input:** n = 1
**Output:** 1

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 1000`

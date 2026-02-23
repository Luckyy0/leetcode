# Result for Max Sum of Rectangle No Larger Than K
# *Kết quả cho bài toán Tổng Hình chữ nhật Lớn nhất không vượt quá K*

## Description
## *Mô tả*

Given an `m x n` matrix `matrix` and an integer `k`, return the max sum of a rectangle in the matrix such that its sum is no larger than `k`.
*Cho một ma trận `m x n` `matrix` và một số nguyên `k`, hãy trả về tổng lớn nhất của một hình chữ nhật trong ma trận sao cho tổng của nó không lớn hơn `k`.*

It is guaranteed that there will be a rectangle with a sum no larger than `k`.
*Đảm bảo rằng sẽ có ít nhất một hình chữ nhật với tổng không lớn hơn `k`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `matrix = [[1,0,1],[0,-2,3]], k = 2`
**Output:** `2`
**Explanation:** Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).

## Example 2:
## *Ví dụ 2:*

**Input:** `matrix = [[2,2,-1]], k = 3`
**Output:** `3`

## Constraints:
## *Ràng buộc:*

*   `m == matrix.length`
*   `n == matrix[i].length`
*   `1 <= m, n <= 100`
*   `-100 <= matrix[i][j] <= 100`
*   `-10^5 <= k <= 10^5`

**Follow up:** What if the number of rows is much larger than the number of columns?
**Câu hỏi mở rộng:** Điều gì xảy ra nếu số hàng lớn hơn nhiều so với số cột?

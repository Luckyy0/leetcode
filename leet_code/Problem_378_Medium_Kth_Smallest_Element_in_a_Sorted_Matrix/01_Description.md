# Result for Kth Smallest Element in a Sorted Matrix
# *Kết quả cho bài toán Phần tử nhỏ thứ K trong Ma trận đã Sắp xếp*

## Description
## *Mô tả*

Given an `n x n` `matrix` where each of the rows and columns is sorted in ascending order, return *the `kth` smallest element in the matrix*.
*Cho một ma trận `n x n` `matrix` trong đó mỗi hàng và cột đều được sắp xếp theo thứ tự tăng dần, hãy trả về *phần tử nhỏ thứ `k` trong ma trận*.*

Note that it is the `kth` smallest element **in the sorted order**, not the `kth` **distinct** element.
*Lưu ý rằng đây là phần tử nhỏ thứ `k` **trong thứ tự đã được sắp xếp**, không phải phần tử **khác biệt** thứ `k`.*

You must find a solution with a memory complexity better than $O(n^2)$.
*Bạn phải tìm một giải pháp với độ phức tạp bộ nhớ tốt hơn $O(n^2)$.*

## Example 1:
## *Ví dụ 1:*

**Input:** `matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8`
**Output:** `13`
**Explanation:** The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13.

## Example 2:
## *Ví dụ 2:*

**Input:** `matrix = [[-5]], k = 1`
**Output:** `-5`

## Constraints:
## *Ràng buộc:*

*   `n == matrix.length == matrix[i].length`
*   `1 <= n <= 300`
*   `-10^9 <= matrix[i][j] <= 10^9`
*   `1 <= k <= n^2`

**Follow up:**
*   Could you solve it with $O(n)$ time complexity? (This is extremely difficult, using Median of Medians or similar).
*   The $O(n \log(max-min))$ solution is the most practical standard.

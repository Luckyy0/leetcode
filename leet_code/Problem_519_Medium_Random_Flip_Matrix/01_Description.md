# Result for Random Flip Matrix
# *Kết quả cho bài toán Lật Ma trận Ngẫu nhiên*

## Description
## *Mô tả*

There is an `m x n` binary grid, where all values are initially `0`. Design an algorithm to randomly pick an index `(i, j)` where `matrix[i][j] == 0` and flips it to `1`. All the indices `(i, j)` where `matrix[i][j] == 0` should be equally likely to be returned.
*Có một lưới nhị phân `m x n`, trong đó tất cả các giá trị ban đầu là `0`. Thiết kế một thuật toán để chọn ngẫu nhiên một chỉ số `(i, j)` trong đó `matrix[i][j] == 0` và lật nó thành `1`. Tất cả các chỉ số `(i, j)` trong đó `matrix[i][j] == 0` phải có cùng khả năng được trả về.*

Optimize the algorithm to minimize the number of calls to the built-in random function and optimize the time and space complexity.
*Tối ưu hóa thuật toán để giảm thiểu số lần gọi hàm ngẫu nhiên tích hợp sẵn và tối ưu hóa độ phức tạp về thời gian và không gian.*

Implement the `Solution` class:

*   `Solution(int m, int n)` Initializes the object with the size of the binary matrix `m` and `n`.
*   `int[] flip()` Returns a random index `[i, j]` of the matrix where `matrix[i][j] == 0` and flips it to `1`.
*   `void reset()` Resets all the values of the matrix to `0`.

## Example 1:
## *Ví dụ 1:*

**Input**
`["Solution", "flip", "flip", "flip", "reset", "flip"]`
`[[3, 1], [], [], [], [], []]`
**Output**
`[null, [1, 0], [2, 0], [0, 0], null, [2, 0]]`

**Explanation**
`Solution solution = new Solution(3, 1);`
`solution.flip();`  // return [1, 0], then matrix is [0,1,0].
`solution.flip();`  // return [2, 0], then matrix is [0,1,1].
`solution.flip();`  // return [0, 0], then matrix is [1,1,1].
`solution.reset();` // All values are reset to 0 and can be returned.
`solution.flip();`  // return [2, 0], matrix is [0,0,1]

## Constraints:
## *Ràng buộc:*

*   `1 <= m, n <= 10^4`
*   There will be at least one free cell for each call to `flip`.
*   At most `1000` calls will be made to `flip` and `reset`.

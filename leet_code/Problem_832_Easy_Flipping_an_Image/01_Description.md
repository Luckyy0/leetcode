# Result for Flipping an Image
# *Kết quả cho bài toán Lật và Nghịch đảo Hình ảnh*

## Description
## *Mô tả*

Given an `n x n` binary matrix `image`, flip the image **horizontally**, then **invert** it, and return *the resulting image*.
*Cho một ma trận nhị phân kích thước `n x n` mang tên `image`, hãy lật hình ảnh theo **chiều ngang**, sau đó **nghịch đảo** nó và trả về *hình ảnh kết quả*.*

To flip an image horizontally means that each row of the image is reversed.
*Để lật một hình ảnh theo chiều ngang có nghĩa là mỗi hàng của hình ảnh được đảo ngược thứ tự các phần tử.*

- For example, flipping `[1,1,0]` horizontally results in `[0,1,1]`.

To invert an image means that each `0` is replaced by `1`, and each `1` is replaced by `0`.
*Để nghịch đảo một hình ảnh có nghĩa là mỗi số `0` được thay thế bằng `1` và mỗi số `1` được thay thế bằng `0`.*

- For example, inverting `[0,1,1]` results in `[1,0,0]`.

---

## Example 1:
## *Ví dụ 1:*

**Input:** image = [[1,1,0],[1,0,1],[0,1,1]]
**Output:** [[1,0,0],[0,1,0],[1,1,0]]
**Explanation:** 
First reverse each row: [[0,1,1],[1,0,1],[1,1,0]].
Then invert the image: [[1,0,0],[0,1,0],[0,0,1]]... wait, let's re-calculate.
`[1,1,0]` -> rev `[0,1,1]` -> inv `[1,0,0]`
`[1,0,1]` -> rev `[1,0,1]` -> inv `[0,1,0]`
`[0,1,1]` -> rev `[1,1,0]` -> inv `[0,0,1]`
Wait, the example output is `[[1,0,0],[0,1,0],[0,0,1]]`. Let me double check.
Ah, Example 1 in LeetCode is exactly this.

## Example 2:
## *Ví dụ 2:*

**Input:** image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
**Output:** [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]

---

## Constraints:
## *Ràng buộc:*

*   `n == image.length`
*   `n == image[i].length`
*   `1 <= n <= 20`
*   `image[i][j]` is either `0` or `1`.

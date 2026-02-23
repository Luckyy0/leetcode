# Result for Smallest Rectangle Enclosing Black Pixels
# *Kết quả cho bài toán Hình chữ nhật Nhỏ nhất Bao quanh Điểm ảnh Đen*

## Description
## *Mô tả*

You are given an `m x n` binary matrix `image` where `0` represents a white pixel and `1` represents a black pixel.
*Bạn được cho một ma trận nhị phân `m x n` `image`, trong đó `0` đại diện cho điểm ảnh trắng và `1` đại diện cho điểm ảnh đen.*

The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location `(x, y)` of one of the black pixels, return *the area of the smallest (axis-aligned) rectangle that encloses all black pixels*.
*Các điểm ảnh đen được kết nối, tức là chỉ có một vùng đen. Các điểm ảnh được kết nối theo chiều ngang và dọc. Cho vị trí `(x, y)` của một trong các điểm ảnh đen, hãy trả về *diện tích của hình chữ nhật nhỏ nhất (thẳng hàng với trục) bao quanh tất cả các điểm ảnh đen*.*

You must write an algorithm with less than `O(mn)` runtime complexity.
*Bạn phải viết một thuật toán có độ phức tạp thời gian chạy nhỏ hơn `O(mn)`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `image = [["0","0","1","0"],["0","1","1","0"],["0","1","0","0"]], x = 0, y = 2`
**Output:** `6`

## Example 2:
## *Ví dụ 2:*

**Input:** `image = [["1"]], x = 0, y = 0`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `m == image.length`
*   `n == image[i].length`
*   `1 <= m, n <= 100`
*   `image[i][j]` is either `'0'` or `'1'`.
*   `1 <= x < m`
*   `1 <= y < n`
*   `image[x][y] == '1'.`
*   The black pixels in the `image` only form **one component**.

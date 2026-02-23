# Result for Flood Fill
# *Kết quả cho bài toán Đổ màu (Flood Fill)*

## Description
## *Mô tả*

An image is represented by an `m x n` integer grid `image` where `image[i][j]` represents the pixel value of the image.
*Một bức ảnh được đại diện bởi một lưới số nguyên `image` kích thước `m x n`, trong đó `image[i][j]` đại diện cho giá trị điểm ảnh của bức ảnh đó.*

You are also given three integers `sr`, `sc`, and `newColor`. You should perform a **flood fill** on the image starting from the pixel `image[sr][sc]`.
*Bạn cũng được cho ba số nguyên `sr`, `sc`, và `newColor`. Bạn nên thực hiện một thao tác **đổ màu (flood fill)** trên bức ảnh bắt đầu từ điểm ảnh `image[sr][sc]`.*

To perform a flood fill, consider the starting pixel, plus any pixels connected **4-directionally** to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with `newColor`.
*Để thực hiện đổ màu, hãy xem xét điểm ảnh bắt đầu, cùng với bất kỳ điểm ảnh nào kết nối **4 hướng** với điểm bắt đầu có cùng màu với điểm bắt đầu, cộng với bất kỳ điểm ảnh nào kết nối 4 hướng với các điểm ảnh đó (cũng có cùng màu đó), v.v. Thay thế màu của tất cả các điểm ảnh nói trên bằng `newColor`.*

Return the modified image after performing the flood fill.
*Hãy trả về bức ảnh đã được sửa đổi sau khi thực hiện đổ màu.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
**Output:** [[2,2,2],[2,2,0],[2,0,1]]
**Explanation:** From the center of the image, all pixels connected by path of the same color (1) are colored with 2. 
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

---

## Constraints:
## *Ràng buộc:*

*   `m == image.length`
*   `n == image[i].length`
*   `1 <= m, n <= 50`
*   `0 <= image[i][j], newColor < 2^16`

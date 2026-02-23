# Result for Image Smoother
# *Kết quả cho bài toán Làm mịn Hình ảnh*

## Description
## *Mô tả*

An **image smoother** is a filter of the size `3 x 3` that can be applied to each cell of an image by rounding down the average of the cell and its 8 surrounding cells (i.e., the average of the 9 cells in the blue smoother). If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the average of the cells that are present).
*Một **bộ làm mịn hình ảnh** là một bộ lọc có kích thước `3 x 3` có thể được áp dụng cho từng ô của hình ảnh bằng cách làm tròn xuống giá trị trung bình của ô đó và 8 ô xung quanh nó (tức là trung bình cộng của 9 ô trong bộ làm mịn). Nếu một hoặc nhiều tế bào xung quanh của một ô không tồn tại, chúng ta không tính nó vào giá trị trung bình (tức là trung bình cộng của các ô hiện có).*

Given an `m x n` integer matrix `img` representing the grayscale of an image, return the image after applying the smoother on each cell of it.
*Cho một ma trận số nguyên `img` kích thước `m x n` đại diện cho mức độ xám của một hình ảnh, hãy trả về hình ảnh sau khi áp dụng bộ làm mịn lên từng ô của nó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** img = [[1,1,1],[1,0,1],[1,1,1]]
**Output:** [[0,0,0],[0,0,0],[0,0,0]]
**Explanation:**
For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0

## Example 2:
## *Ví dụ 2:*

**Input:** img = [[100,200,100],[200,50,200],[100,200,100]]
**Output:** [[137,141,137],[141,138,141],[137,141,137]]
**Explanation:**
For the point (0,0): floor((100+200+200+50)/4) = floor(137.5) = 137
For the point (0,1): floor((100+200+100+200+50+200)/6) = floor(141.666667) = 141
For the point (0,2): floor((200+100+50+200)/4) = floor(137.5) = 137
For the point (1,0): floor((100+200+200+50+100+200)/6) = floor(141.666667) = 141
For the point (1,1): floor((100+200+100+200+50+200+100+200+100)/9) = floor(138.888889) = 138
For the point (1,2): floor((200+100+50+200+200+100)/6) = floor(141.666667) = 141
For the point (2,0): floor((200+50+100+200)/4) = floor(137.5) = 137
For the point (2,1): floor((200+50+200+100+200+100)/6) = floor(141.666667) = 141
For the point (2,2): floor((50+200+200+100)/4) = floor(137.5) = 137

---

## Constraints:
## *Ràng buộc:*

*   `m == img.length`
*   `n == img[i].length`
*   `1 <= m, n <= 200`
*   `0 <= img[i][j] <= 255`

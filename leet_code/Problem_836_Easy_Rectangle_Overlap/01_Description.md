# Result for Rectangle Overlap
# *Kết quả cho bài toán Chồng lấp Hình chữ nhật*

## Description
## *Mô tả*

An axis-aligned rectangle is represented as a list `[x1, y1, x2, y2]`, where `(x1, y1)` is the coordinate of its bottom-left corner, and `(x2, y2)` is the coordinate of its top-right corner.
*Một hình chữ nhật song song với các trục tọa độ được biểu diễn dưới dạng danh sách `[x1, y1, x2, y2]`, trong đó `(x1, y1)` là tọa độ của góc dưới bên trái và `(x2, y2)` là tọa độ của góc trên bên phải.*

Two rectangles overlap if the area of their intersection is **positive**. To be clear, two rectangles that only touch at the corner or edges do not overlap.
*Hai hình chữ nhật chồng lên nhau nếu diện tích phần giao của chúng là **số dương**. Để làm rõ, hai hình chữ nhật chỉ chạm nhau ở góc hoặc cạnh thì không được coi là chồng lên nhau.*

Given two rectangles `rec1` and `rec2`, return `true` *if they overlap, otherwise return `false`*.
*Cho hai hình chữ nhật `rec1` và `rec2`, trả về `true` *nếu chúng chồng lên nhau, ngược lại trả về `false`*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** rec1 = [0,0,2,2], rec2 = [1,1,3,3]
**Output:** true

## Example 2:
## *Ví dụ 2:*

**Input:** rec1 = [0,0,1,1], rec2 = [1,0,2,1]
**Output:** false

## Example 3:
## *Ví dụ 3:*

**Input:** rec1 = [0,0,1,1], rec2 = [2,2,3,3]
**Output:** false

---

## Constraints:
## *Ràng buộc:*

*   `rec1.length == 4`
*   `rec2.length == 4`
*   `-10^9 <= rec1[i], rec2[i] <= 10^9`
*   `rec1[0] < rec1[2]` and `rec1[1] < rec1[3]`
*   `rec2[0] < rec2[2]` and `rec2[1] < rec2[3]`

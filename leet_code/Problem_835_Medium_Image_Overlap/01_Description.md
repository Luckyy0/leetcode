# Result for Image Overlap
# *Kết quả cho bài toán Chồng lấp Hình ảnh*

## Description
## *Mô tả*

You are given two images, `img1` and `img2`, represented as binary, square matrices of size `n x n`. A binary matrix has only `0`s and `1`s as values.
*Bạn được cho hai hình ảnh `img1` và `img2`, được biểu diễn dưới dạng các ma trận nhị phân hình vuông kích thước `n x n`. Một ma trận nhị phân chỉ chứa các giá trị `0` và `1`.*

We **translate** one image however we choose (sliding it left, right, up, or down any number of units). We then place it on top of the other image. We can then calculate the **overlap** by counting the number of positions that have a `1` in **both** images.
*Chúng ta **dịch chuyển** một hình ảnh theo bất kỳ cách nào (trượt sang trái, phải, lên hoặc xuống bất kỳ đơn vị nào). Sau đó, đặt nó lên trên hình ảnh kia. Chúng ta tính mức độ **chồng lấp** bằng cách đếm số lượng vị trí có số `1` ở **cả hai** hình ảnh.*

Note also that a translation does **not** include any kind of rotation. Any `1`s that are translated outside the matrix borders are erased.
*Lưu ý rằng phép dịch chuyển **không** bao gồm phép xoay. Bất kỳ số `1` nào bị dịch ra ngoài biên ma trận sẽ bị xóa bỏ.*

Return *the largest possible overlap*.
*Trả về *mức độ chồng lấp lớn nhất có thể*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
**Output:** 3
**Explanation:** We translate img1 to right by 1 unit and down by 1 unit.
The number of positions that have a 1 in both images is 3.

## Example 2:
## *Ví dụ 2:*

**Input:** img1 = [[1]], img2 = [[1]]
**Output:** 1

## Example 3:
## *Ví dụ 3:*

**Input:** img1 = [[0]], img2 = [[0]]
**Output:** 0

---

## Constraints:
## *Ràng buộc:*

*   `n == img1.length == img1[i].length`
*   `n == img2.length == img2[i].length`
*   `1 <= n <= 30`
*   `img1[i][j]` is either `0` or `1`.
*   `img2[i][j]` is either `0` or `1`.

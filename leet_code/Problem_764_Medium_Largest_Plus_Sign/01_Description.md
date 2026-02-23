# Result for Largest Plus Sign
# *Kết quả cho bài toán Dấu Cộng Lớn nhất*

## Description
## *Mô tả*

You are given an integer `n`. You have an `n x n` binary grid `grid` with all values initially `1`'s except for some indices given in the array `mines`. The `i-th` element of the array `mines` is defined as `mines[i] = [xi, yi]` where `grid[xi][yi] == 0`.
*Bạn được cho một số nguyên `n`. Bạn có một lưới nhị phân `n x n` `grid` với tất cả các giá trị ban đầu là `1` ngoại trừ một số chỉ số được cho trong mảng `mines`. Phần tử thứ `i` của mảng `mines` được định nghĩa là `mines[i] = [xi, yi]` nơi `grid[xi][yi] == 0`.*

Return *the order of the largest **axis-aligned** plus sign of 1's contained in `grid`*. If there is none, return `0`.
*Trả về *bậc của dấu cộng **thẳng hàng với trục** lớn nhất gồm các số 1 chứa trong `grid`*. Nếu không có, trả về `0`.*

An **axis-aligned** plus sign of 1's of order `k` has some center `grid[r][c] == 1` along with four arms of length `k - 1` going up, down, left, and right, and made of `1`'s. Note that the center `1` is common to all four arms, so the total number of `1`'s in the plus sign is `4 * (k - 1) + 1`. A plus sign of order 1 is simply center `1`.
*Một dấu cộng 1 thẳng hàng với trục có bậc `k` có một tâm `grid[r][c] == 1` cùng với bốn nhánh có độ dài `k - 1` đi lên, xuống, trái và phải, và được tạo thành từ các số `1`. Lưu ý rằng số `1` ở tâm là chung cho cả bốn nhánh, vì vậy tổng số lượng số `1` trong dấu cộng là `4 * (k - 1) + 1`. Một dấu cộng bậc 1 chỉ đơn giản là tâm `1`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 5, mines = [[4,2]]
**Output:** 2
**Explanation:** In the above grid, the largest plus sign can only be of order 2. One of them is centered at (2,2).

## Example 2:
## *Ví dụ 2:*

**Input:** n = 1, mines = [[0,0]]
**Output:** 0
**Explanation:** There is no plus sign, so return 0.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 500`
*   `1 <= mines.length <= 5000`
*   `0 <= xi, yi < n`
*   All the pairs `(xi, yi)` are unique.

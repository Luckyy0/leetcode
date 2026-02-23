# Result for Rectangle Area II
# *Kết quả cho bài toán Diện tích Hình chữ nhật II*

## Description
## *Mô tả*

You are given a 2D array of `rectangles` where `rectangles[i] = [x1, y1, x2, y2]` indicates the `i`-th rectangle. The bottom-left corner is at `(x1, y1)` and the top-right corner is at `(x2, y2)`.
*Bạn được cho một mảng 2D gồm các `rectangles`, trong đó `rectangles[i] = [x1, y1, x2, y2]` cho biết hình chữ nhật thứ `i`. Góc dưới bên trái nằm tại `(x1, y1)` và góc trên bên phải nằm tại `(x2, y2)`.*

Return *the **total area** covered by all `rectangles` in the plane*. Since the answer may be too large, return it **modulo `10^9 + 7`**.
*Hãy trả về *tổng diện tích** được bao phủ bởi tất cả các `rectangles` trên mặt phẳng. Vì kết quả có thể rất lớn, hãy trả về theo **modulo `10^9 + 7`**.*

Any area covered by multiple rectangles should only be counted once.
*Bất kỳ diện tích nào được bao phủ bởi nhiều hình chữ nhật chỉ được tính một lần.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** rectangles = [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
**Output:** 6
**Explanation:** A total area of 6 is covered by these three rectangles, as shown in the grid.
(0,0) to (2,2) - Area 4
(1,0) to (2,3) - Extra area 2
(1,0) to (3,1) - Extra area 0 (already covered)
Total = 6.

## Example 2:
## *Ví dụ 2:*

**Input:** rectangles = [[0,0,1000000000,1000000000]]
**Output:** 49
**Explanation:** The answer is 10^18 modulo (10^9 + 7), which is 49.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= rectangles.length <= 200`
*   `rectangles[i].length == 4`
*   `0 <= x1, y1, x2, y2 <= 10^9`

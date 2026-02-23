# Result for Lonely Pixel II
# *Kết quả cho bài toán Điểm ảnh Cô đơn II*

## Description
## *Mô tả*

Given an `m x n` picture consisting of black `'B'` and white `'W'` pixels, and an integer target `N`, return *the number of black lonely pixels*.
*Cho một bức tranh kích thước `m x n` bao gồm các điểm ảnh đen `'B'` và trắng `'W'`, và một số nguyên mục tiêu `N`, hãy trả về *số lượng điểm ảnh đen cô đơn*.*

The definition of a black lonely pixel is as follows:
*Định nghĩa về điểm ảnh đen cô đơn như sau:*

1.  It is a character `'B'`.
    *Nó là ký tự `'B'`.*
2.  The number of black pixels in the row `r` and column `c` where the square `(r, c)` is located is both exactly `N`.
    *Số lượng điểm ảnh đen trong hàng `r` và cột `c` nơi ô `(r, c)` tọa lạc đều là chính xác `N`.*
3.  For all rows that have a black pixel in the column `c`, they should be exactly the same as row `r`.
    *Đối với tất cả các hàng có điểm ảnh đen trong cột `c`, chúng phải giống hệt như hàng `r`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `picture = [["W","B","W","B","B","W"],["W","B","W","B","B","W"],["W","B","W","B","B","W"],["W","W","B","W","B","W"]], N = 3`
**Output:** `6`
**Explanation:** All the bold 'B' are the black lonely pixels.
- Row 0, 1, 2 are exactly the same 'WBWBBW'.
- Row 0, 1, 2 have 'B' at col 1, 3, 4.
- Col 1 has 3 'B's (row 0, 1, 2). Matches N=3.
- Col 3 has 3 'B's (row 0, 1, 2). Matches N=3.
- Col 4 has 3 'B's (row 0, 1, 2). Matches N=3.
- Therefore, all 9 'B's in row 0,1,2 col 1,3,4 are candidates? Wait.
- Rule 2: Row 0 has 3 'B's. Col 1 has 3 'B's. Correct.
- Rule 3: Rows with B in col 1 are 0, 1, 2. Are they same? Yes.
So (0,1), (0,3), (0,4), (1,1)... are lonely. Total 6?
Wait, description says 6. Let's trace.
Row 0: 'WBWBBW' (3Bs).
Row 1: 'WBWBBW' (3Bs).
Row 2: 'WBWBBW' (3Bs).
Row 3: 'WWBWBW' (2Bs).
Col 1 has B at 0, 1, 2. Col Count = 3.
Col 3 has B at 0, 1, 2. Col Count = 3.
Col 4 has B at 0, 1, 2, 3? No, row 3 col 4 is 'B'. So Col 4 has 4Bs.
- So (r, 4) fails because Col 4 has 4Bs != N(3).
- So only Col 1 and Col 3 are valid.
- Col 1 has 0, 1, 2. All 3 rows same? Yes. valid.
- Col 3 has 0, 1, 2. All 3 rows same? Yes. Valid.
- Total valid pixels: Row 0,1,2 * Col 1,3 = 3 * 2 = 6 pixels.

## Constraints:
## *Ràng buộc:*

*   `m == picture.length`
*   `n == picture[i].length`
*   `1 <= m, n <= 200`
*   `picture[i][j]` is `'W'` or `'B'`.
*   `1 <= N <= m` (Actually N is target number).

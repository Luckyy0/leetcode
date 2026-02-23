# Result for Lonely Pixel I
# *Kết quả cho bài toán Điểm ảnh Cô đơn I*

## Description
## *Mô tả*

Given an `m x n` `picture` consisting of black `'B'` and white `'W'` pixels, return *the number of **black** lonely pixels*.
*Cho một bức tranh `picture` kích thước `m x n` bao gồm các điểm ảnh đen `'B'` và trắng `'W'`, hãy trả về *số lượng điểm ảnh **đen** cô đơn*.*

A black lonely pixel is a character `'B'` that located at a specific position `(r, c)` such that:
*Một điểm ảnh đen cô đơn là ký tự `'B'` nằm ở vị trí cụ thể `(r, c)` sao cho:*

*   It is the only black pixel in row `r`, and
    *Nó là điểm ảnh đen duy nhất trong hàng `r`, và*
*   It is the only black pixel in column `c`.
    *Nó là điểm ảnh đen duy nhất trong cột `c`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `picture = [["W","W","B"],["W","B","W"],["B","W","W"]]`
**Output:** `3`
**Explanation:** All the three 'B's are black lonely pixels.

## Example 2:
## *Ví dụ 2:*

**Input:** `picture = [["B","B","B"],["B","B","B"],["B","B","B"]]`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `m == picture.length`
*   `n == picture[i].length`
*   `1 <= m, n <= 500`
*   `picture[i][j]` is `'W'` or `'B'`.

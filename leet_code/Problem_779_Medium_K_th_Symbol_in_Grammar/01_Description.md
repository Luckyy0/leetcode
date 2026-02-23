# Result for K-th Symbol in Grammar
# *Kết quả cho bài toán Ký tự thứ K trong Văn phạm*

## Description
## *Mô tả*

We build a table of `n` rows (1-indexed). We start by writing `0` in the 1st row. Now in every subsequent row, we look at the previous row and replace each occurrence of `0` with `01`, and each occurrence of `1` with `10`.
*Chúng ta xây dựng một bảng gồm `n` hàng (đánh số từ 1). Chúng ta bắt đầu bằng cách viết `0` ở hàng thứ nhất. Bây giờ trong mỗi hàng tiếp theo, chúng ta nhìn vào hàng trước đó và thay thế mỗi lần xuất hiện của `0` bằng `01`, và mỗi lần xuất hiện của `1` bằng `10`.*

*   For example, for `n = 3`, the 1st row is `0`, the 2nd row is `01`, and the 3rd row is `0110`.
*   *Ví dụ, với `n = 3`, hàng thứ nhất là `0`, hàng thứ hai là `01`, và hàng thứ ba là `0110`.*

Given two integer `n` and `k`, return the `k`-th (1-indexed) symbol in the `n`-th row of a table of `n` rows.
*Cho hai số nguyên `n` và `k`, trả về ký tự thứ `k` (đánh số từ 1) trong hàng thứ `n` của bảng `n` hàng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 1, k = 1
**Output:** 0
**Explanation:** row 1: 0

## Example 2:
## *Ví dụ 2:*

**Input:** n = 2, k = 1
**Output:** 0
**Explanation:**
row 1: 0
row 2: 01

## Example 3:
## *Ví dụ 3:*

**Input:** n = 2, k = 2
**Output:** 1
**Explanation:**
row 1: 0
row 2: 01

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 30`
*   `1 <= k <= 2^(n - 1)`

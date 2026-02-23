# Result for Rotate Function
# *Kết quả cho bài toán Hàm Xoay*

## Description
## *Mô tả*

You are given an integer array `nums` of length `n`.
*Bạn được cho một mảng số nguyên `nums` có độ dài `n`.*

Assume `bk` to be an array obtained by rotating `nums` by `k` positions clock-wise. We define the **rotation function** `F` on `nums` as follows:
*Giả sử `bk` là một mảng có được bằng cách xoay `nums` theo chiều kim đồng hồ `k` vị trí. Chúng ta định nghĩa **hàm xoay** `F` trên `nums` như sau:*

`F(k) = 0 * bk[0] + 1 * bk[1] + ... + (n - 1) * bk[n - 1].`

Return *the maximum value of `F(0), F(1), ..., F(n - 1)`*.
*Trả về *giá trị lớn nhất của `F(0), F(1), ..., F(n - 1)`*.*

The test cases are generated so that the answer fits in a **32-bit** integer.
*Các trường hợp kiểm thử được tạo ra sao cho câu trả lời nằm gọn trong một số nguyên **32-bit**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [4,3,2,6]`
**Output:** `26`
**Explanation:**
F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [100]`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `n == nums.length`
*   `1 <= n <= 10^5`
*   `-100 <= nums[i] <= 100`

# Result for Sort Colors
# *Kết quả cho bài toán Sắp Xếp Màu Sắc*

## Description
## *Mô tả*

Given an array `nums` with `n` objects colored red, white, or blue, sort them **in-place** so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
*Cho một mảng `nums` gồm `n` đối tượng có màu đỏ, trắng hoặc xanh lam, hãy sắp xếp chúng **tại chỗ** sao cho các đối tượng cùng màu đứng cạnh nhau, theo thứ tự đỏ, trắng và xanh lam.*

We will use the integers `0`, `1`, and `2` to represent the color red, white, and blue, respectively.
*Chúng ta sẽ sử dụng các số nguyên `0`, `1` và `2` để đại diện lần lượt cho màu đỏ, trắng và xanh lam.*

You must solve this problem without using the library's sort function.
*Bạn phải giải quyết bài toán này mà không sử dụng hàm sắp xếp của thư viện.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [2,0,2,1,1,0]`
**Output:** `[0,0,1,1,2,2]`

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [2,0,1]`
**Output:** `[0,1,2]`

## Constraints:
## *Ràng buộc:*

*   `n == nums.length`
*   `1 <= n <= 300`
*   `nums[i]` is either `0`, `1`, or `2`.

## Follow up:
*   Could you come up with a one-pass algorithm using only constant extra space?

# Result for Pascal's Triangle II
# *Kết quả cho bài toán Tam Giác Pascal II*

## Description
## *Mô tả*

Given an integer `rowIndex`, return the `rowIndex`-th (**0-indexed**) row of the **Pascal's triangle**.
*Cho một số nguyên `rowIndex`, hãy trả về hàng thứ `rowIndex` (**chỉ số bắt đầu từ 0**) của **tam giác Pascal**.*

In **Pascal's triangle**, each number is the sum of the two numbers directly above it as shown:
*Trong **tam giác Pascal**, mỗi số là tổng của hai số ngay bên trên nó như hình minh họa:*

![Pascal's Triangle Animation](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

## Example 1:
## *Ví dụ 1:*

**Input:** `rowIndex = 3`
**Output:** `[1,3,3,1]`

## Example 2:
## *Ví dụ 2:*

**Input:** `rowIndex = 0`
**Output:** `[1]`

## Example 3:
## *Ví dụ 3:*

**Input:** `rowIndex = 1`
**Output:** `[1,1]`

## Constraints:
## *Ràng buộc:*

*   `0 <= rowIndex <= 33`

## Follow up:
*   Could you optimize your algorithm to use only $O(rowIndex)$ extra space?

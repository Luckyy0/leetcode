# Result for Container With Most Water
# *Kết quả cho bài toán Thùng Chứa Nhiều Nước Nhất*

## Description
## *Mô tả*

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `i-th` line are `(i, 0)` and `(i, height[i])`.
*Bạn được cho một mảng số nguyên `height` có độ dài `n`. Có `n` đường thẳng đứng được vẽ sao cho hai điểm đầu mút của đường thẳng thứ `i` là `(i, 0)` và `(i, height[i])`.*

Find two lines that together with the x-axis form a container, such that the container contains the most water.
*Tìm hai đường thẳng cùng với trục hoành tạo thành một thùng chứa, sao cho thùng chứa chứa được nhiều nước nhất.*

Return the maximum amount of water a container can store.
*Trả về lượng nước tối đa mà một thùng chứa có thể lưu trữ.*

**Notice** that you may not slant the container.
***Lưu ý** rằng bạn không được làm nghiêng thùng chứa.*

## Example 1:
## *Ví dụ 1:*

**Input:** `height = [1,8,6,2,5,4,8,3,7]`
**Output:** `49`
**Explanation:** The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
***Giải thích:** Các đường thẳng đứng ở trên được đại diện bởi mảng [1,8,6,2,5,4,8,3,7]. Trong trường hợp này, diện tích nước tối đa (phần màu xanh) mà thùng chứa có thể chứa là 49.*

## Example 2:
## *Ví dụ 2:*

**Input:** `height = [1,1]`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `n == height.length`
*   `2 <= n <= 10^5`
*   `0 <= height[i] <= 10^4`

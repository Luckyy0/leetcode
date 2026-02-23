# Result for Maximum Gap
# *Kết quả cho bài toán Khoảng cách tối đa*

## Description
## *Mô tả*

Given an integer array `nums`, return *the maximum difference between two successive elements in its sorted form*. If the array contains less than two elements, return `0`.
*Cho một mảng số nguyên `nums`, hãy trả về *khoảng cách lớn nhất giữa hai phần tử liên tiếp trong dạng đã sắp xếp của nó*. Nếu mảng chứa ít hơn hai phần tử, hãy trả về `0`***.*

You must write an algorithm that runs in **linear time** and uses **linear extra space**.
*Bạn phải viết một thuật toán chạy trong **thời gian tuyến tính** và sử dụng **không gian bổ sung tuyến tính***.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [3,6,9,1]`
**Output:** `3`
**Explanation:** The sorted form of the array is [1,3,6,9], either (3,1), (6,3) or (9,6) has the maximum difference 3.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [10]`
**Output:** `0`
**Explanation:** The array contains less than 2 elements, therefore return 0.

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^5`
*   `0 <= nums[i] <= 10^9`

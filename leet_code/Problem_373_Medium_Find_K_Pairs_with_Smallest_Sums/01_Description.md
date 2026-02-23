# Result for Find K Pairs with Smallest Sums
# *Kết quả cho bài toán Tìm K cặp có Tổng nhỏ nhất*

## Description
## *Mô tả*

You are given two integer arrays `nums1` and `nums2` sorted in **ascending order** and an integer `k`.
*Bạn được cho hai mảng số nguyên `nums1` và `nums2` đã được sắp xếp theo thứ tự **tăng dần** và một số nguyên `k`.*

Define a pair `(u, v)` which consists of one element from `nums1` and one element from `nums2`.
*Định nghĩa một cặp `(u, v)` gồm một phần tử từ `nums1` và một phần tử từ `nums2`.*

Return *the `k` pairs `(u1, v1), (u2, v2), ..., (uk, vk)` with the smallest sums*.
*Trả về *`k` cặp `(u1, v1), (u2, v2), ..., (uk, vk)` có tổng nhỏ nhất*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums1 = [1,7,11], nums2 = [2,4,6], k = 3`
**Output:** `[[1,2],[1,4],[1,6]]`
**Explanation:** The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

## Example 2:
## *Ví dụ 2:*

**Input:** `nums1 = [1,1,2], nums2 = [1,2,3], k = 2`
**Output:** `[[1,1],[1,1]]`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums1.length, nums2.length <= 10^5`
*   `-10^9 <= nums1[i], nums2[i] <= 10^9`
*   `nums1` and `nums2` are sorted in **ascending order**.
*   `1 <= k <= 10^4`
*   `k <= nums1.length * nums2.length`

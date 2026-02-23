# Result for Create Maximum Number
# *Kết quả cho bài toán Tạo Số Lớn nhất*

## Description
## *Mô tả*

You are given two integer arrays `nums1` and `nums2` of lengths `m` and `n` respectively. `nums1` and `nums2` represent the digits of two numbers. You are also given an integer `k`.
*Bạn được cho hai mảng số nguyên `nums1` và `nums2` có độ dài lần lượt là `m` và `n`. `nums1` và `nums2` đại diện cho các chữ số của hai số. Bạn cũng được cho một số nguyên `k`.*

Create the maximum number of length `k <= m + n` from digits of the two numbers. The relative order of the digits from the same array must be preserved.
*Tạo số lớn nhất có độ dài `k <= m + n` từ các chữ số của hai số. Thứ tự tương đối của các chữ số từ cùng một mảng phải được bảo toàn.*

Return an array of the `k` digits representing the answer.
*Trả về một mảng gồm `k` chữ số đại diện cho câu trả lời.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums1 = [3,4,6,5], nums2 = [9,1,2,5,8,3], k = 5`
**Output:** `[9,8,6,5,3]`

## Example 2:
## *Ví dụ 2:*

**Input:** `nums1 = [6,7], nums2 = [6,0,4], k = 5`
**Output:** `[6,7,6,0,4]`

## Example 3:
## *Ví dụ 3:*

**Input:** `nums1 = [3,9], nums2 = [8,9], k = 3`
**Output:** `[9,8,9]`

## Constraints:
## *Ràng buộc:*

*   `m == nums1.length`
*   `n == nums2.length`
*   `1 <= m, n <= 1000`
*   `1 <= k <= m + n`
*   `0 <= nums1[i], nums2[i] <= 9`

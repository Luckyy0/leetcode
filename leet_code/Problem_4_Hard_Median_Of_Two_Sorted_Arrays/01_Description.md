# Result for Median of Two Sorted Arrays
# *Kết quả cho bài toán Trung vị của Hai Mảng Đã Sắp Xếp*

## Description
## *Mô tả*

Given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return the **median** of the two sorted arrays.
*Cho hai mảng đã sắp xếp `nums1` và `nums2` có kích thước lần lượt là `m` và `n`, hãy trả về **trung vị** của hai mảng đã sắp xếp đó.*

The overall run time complexity should be `O(log (m+n))`.
*Độ phức tạp thời gian tổng thể nên là `O(log (m+n))`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums1 = [1,3]`, `nums2 = [2]`
**Output:** `2.00000`
**Explanation:** merged array = `[1,2,3]` and median is 2.
***Giải thích:** mảng đã gộp = `[1,2,3]` và trung vị là 2.*

## Example 2:
## *Ví dụ 2:*

**Input:** `nums1 = [1,2]`, `nums2 = [3,4]`
**Output:** `2.50000`
**Explanation:** merged array = `[1,2,3,4]` and median is `(2 + 3) / 2 = 2.5`.
***Giải thích:** mảng đã gộp = `[1,2,3,4]` và trung vị là `(2 + 3) / 2 = 2.5`.*

## Constraints:
## *Ràng buộc:*

*   `nums1.length == m`
*   `nums2.length == n`
*   `0 <= m <= 1000`
*   `0 <= n <= 1000`
*   `1 <= m + n <= 2000`
*   `-10^6 <= nums1[i], nums2[i] <= 10^6`

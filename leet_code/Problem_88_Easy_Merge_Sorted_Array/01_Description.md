# Result for Merge Sorted Array
# *Kết quả cho bài toán Hợp Nhất Mảng Đã Sắp Xếp*

## Description
## *Mô tả*

You are given two integer arrays `nums1` and `nums2`, sorted in **non-decreasing order**, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively.
*Cho hai mảng số nguyên `nums1` và `nums2` được sắp xếp theo **thứ tự không giảm**, và hai số nguyên `m` và `n`, đại diện cho số lượng phần tử trong `nums1` và `nums2` tương ứng.*

**Merge** `nums1` and `nums2` into a single array sorted in **non-decreasing order**.
*Hãy **hợp nhất** `nums1` và `nums2` thành một mảng duy nhất được sắp xếp theo **thứ tự không giảm**.*

The final sorted array should not be returned by the function, but instead be **stored inside the array `nums1`**. To accommodate this, `nums1` has a length of `m + n`, where the first `m` elements denote the elements that should be merged, and the last `n` elements are set to `0` and should be ignored. `nums2` has a length of `n`.
*Mảng đã sắp xếp cuối cùng không nên được trả về bởi hàm, mà thay vào đó nên được **lưu trữ bên trong mảng `nums1`**. Để đáp ứng điều này, `nums1` có độ dài `m + n`, trong đó `m` phần tử đầu tiên là các phần tử cần được hợp nhất, và `n` phần tử cuối cùng được đặt thành `0` và nên được bỏ qua. `nums2` có độ dài `n`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3`
**Output:** `[1,2,2,3,5,6]`
**Explanation:** The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums1 = [1], m = 1, nums2 = [], n = 0`
**Output:** `[1]`
**Explanation:** The arrays we are merging are [1] and [].
The result of the merge is [1].

## Example 3:
## *Ví dụ 3:*

**Input:** `nums1 = [0], m = 0, nums2 = [1], n = 1`
**Output:** `[1]`
**Explanation:** The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

## Constraints:
## *Ràng buộc:*

*   `nums1.length == m + n`
*   `nums2.length == n`
*   `0 <= m, n <= 200`
*   `1 <= m + n <= 200`
*   `-10^9 <= nums1[i], nums2[j] <= 10^9`

## Follow up:
*   Can you come up with an algorithm that runs in $O(m + n)$ time?

# Result for Advantage Shuffle
# *Kết quả cho bài toán Tráo đổi Lợi thế*

## Description
## *Mô tả*

You are given two integer arrays `nums1` and `nums2` of the same length.
*Bạn được cho hai mảng số nguyên `nums1` và `nums2` có cùng độ dài.*

The **advantage** of `nums1` with respect to `nums2` is the number of indices `i` for which `nums1[i] > nums2[i]`.
*Lợi thế (advantage) của `nums1` đối với `nums2` là số lượng các chỉ số `i` mà `nums1[i] > nums2[i]`.*

Return *any permutation of `nums1` that maximizes its **advantage** with respect to `nums2`*.
*Hãy trả về *bất kỳ hoán vị nào của `nums1` giúp tối đa hóa **lợi thế** của nó đối với `nums2`*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums1 = [2,7,11,15], nums2 = [1,10,4,11]
**Output:** [2,11,7,15]

## Example 2:
## *Ví dụ 2:*

**Input:** nums1 = [12,24,8,32], nums2 = [13,25,32,11]
**Output:** [24,32,8,12]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums1.length <= 10^5`
*   `nums2.length == nums1.length`
*   `0 <= nums1[i], nums2[i] <= 10^9`

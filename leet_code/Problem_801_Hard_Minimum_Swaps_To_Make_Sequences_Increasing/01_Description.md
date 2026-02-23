# Result for Minimum Swaps To Make Sequences Increasing
# *Kết quả cho bài toán Số lần hoán đổi tối thiểu để tạo các chuỗi tăng dần*

## Description
## *Mô tả*

You are given two integer arrays of the same length `nums1` and `nums2`. In one operation, you are allowed to swap `nums1[i]` and `nums2[i]`.
*Bạn được cho hai mảng số nguyên có cùng độ dài `nums1` và `nums2`. Trong một phép toán, bạn được phép hoán đổi `nums1[i]` và `nums2[i]`.*

Return *the minimum number of needed operations to make `nums1` and `nums2` **strictly increasing***. The test cases are generated so that the given input always makes it possible.
*Trả về *số lượng phép toán tối thiểu cần thiết để làm cho `nums1` và `nums2` **tăng dần nghiêm ngặt***. Các trường hợp kiểm thử được đảm bảo sao cho dữ liệu nhập vào luôn có thể giải được.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums1 = [1,3,5,4], nums2 = [1,2,3,7]
**Output:** 1
**Explanation:** 
Swap nums1[3] and nums2[3]. Then the sequences are:
nums1 = [1, 3, 5, 7] and nums2 = [1, 2, 3, 4]
Both are strictly increasing.

## Example 2:
## *Ví dụ 2:*

**Input:** nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
**Output:** 1

---

## Constraints:
## *Ràng buộc:*

*   `2 <= nums1.length <= 10^5`
*   `nums2.length == nums1.length`
*   `0 <= nums1[i], nums2[i] <= 2 * 10^5`

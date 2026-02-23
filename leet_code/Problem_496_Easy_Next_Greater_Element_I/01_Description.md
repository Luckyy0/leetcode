# Result for Next Greater Element I
# *Kết quả cho bài toán Phần tử Lớn hơn Tiếp theo I*

## Description
## *Mô tả*

The **next greater element** of some element `x` in an array is the first greater element that is to the right of `x` in the same array.
*Phần tử **lớn hơn tiếp theo** của một phần tử `x` nào đó trong mảng là phần tử lớn hơn đầu tiên nằm bên phải của `x` trong cùng một mảng.*

You are given two distinct 0-indexed integer arrays `nums1` and `nums2`, where `nums1` is a subset of `nums2`.
*Bạn được cho hai mảng số nguyên 0-indexed khác nhau `nums1` và `nums2`, trong đó `nums1` là tập con của `nums2`.*

For each `0 <= i < nums1.length`, find the index `j` such that `nums1[i] == nums2[j]` and determine the **next greater element** of `nums2[j]` in `nums2`. If there is no next greater element, then the answer for this query is `-1`.
*Đối với mỗi `0 <= i < nums1.length`, tìm chỉ số `j` sao cho `nums1[i] == nums2[j]` và xác định **phần tử lớn hơn tiếp theo** của `nums2[j]` trong `nums2`. Nếu không có phần tử lớn hơn tiếp theo, thì câu trả lời cho truy vấn này là `-1`.*

Return *an array `ans` of length `nums1.length` such that `ans[i]` is the next greater element as described above*.
*Trả về *một mảng `ans` có độ dài `nums1.length` sao cho `ans[i]` là phần tử lớn hơn tiếp theo như mô tả ở trên*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums1 = [4,1,2], nums2 = [1,3,4,2]`
**Output:** `[-1,3,-1]`
**Explanation:** The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,<u>4</u>,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [<u>1</u>,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,<u>2</u>]. There is no next greater element, so the answer is -1.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums1 = [2,4], nums2 = [1,2,3,4]`
**Output:** `[3,-1]`
**Explanation:** The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,<u>2</u>,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,<u>4</u>]. There is no next greater element, so the answer is -1.

## Constraints:
## *Ràng buộc:*

*   `1 <= nums1.length <= nums2.length <= 1000`
*   `0 <= nums1[i], nums2[i] <= 10^4`
*   All integers in `nums1` and `nums2` are **unique**.
*   All the integers of `nums1` also appear in `nums2`.

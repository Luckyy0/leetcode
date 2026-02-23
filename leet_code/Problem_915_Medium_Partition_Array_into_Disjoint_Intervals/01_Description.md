# Result for Partition Array into Disjoint Intervals
# *Kết quả cho bài toán Phân chia Mảng thành các Khoảng Rời rạc*

## Description
## *Mô tả*

Given an integer array `nums`, partition it into two (contiguous) subarrays `left` and `right` so that:
*Cho một mảng số nguyên `nums`, hãy chia nó thành hai mảng con (liên tiếp) `left` và `right` sao cho:*

*   Every element in `left` is less than or equal to every element in `right`.
    *   *Mọi phần tử trong `left` đều nhỏ hơn hoặc bằng mọi phần tử trong `right`.*
*   `left` and `right` are non-empty.
    *   *`left` và `right` không rỗng.*
*   `left` has the smallest possible size.
    *   *`left` có kích thước nhỏ nhất có thể.*

Return *the length of `left` after such a partitioning*.
*Hãy trả về *độ dài của `left` sau khi phân chia như vậy*.*

Test cases are generated such that partitioning exists.
*Các trường hợp thử nghiệm được tạo ra sao cho phân chia luôn tồn tại.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [5,0,3,8,6]
**Output:** 3
**Explanation:** left = [5,0,3], right = [8,6]

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,1,1,0,6,12]
**Output:** 4
**Explanation:** left = [1,1,1,0], right = [6,12]

---

## Constraints:
## *Ràng buộc:*

*   `2 <= nums.length <= 10^5`
*   `0 <= nums[i] <= 10^6`
*   There is at least one valid answer for the partition.

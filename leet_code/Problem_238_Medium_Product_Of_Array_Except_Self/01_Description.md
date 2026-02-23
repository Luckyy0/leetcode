# Result for Product of Array Except Self
# *Kết quả cho bài toán Tích của mảng ngoại trừ chính nó*

## Description
## *Mô tả*

Given an integer array `nums`, return *an array* `answer` *such that* `answer[i]` *is equal to the product of all the elements of* `nums` *except* `nums[i]`.
*Cho một mảng số nguyên `nums`, hãy trả về *một mảng* `answer` *sao cho* `answer[i]` *bằng tích của tất cả các phần tử của* `nums` *ngoại trừ* `nums[i]`.*

The product of any prefix or suffix of `nums` is **guaranteed** to fit in a **32-bit** integer.
*Tích của bất kỳ tiền tố hoặc hậu tố nào của `nums` **được đảm bảo** nằm gọn trong số nguyên **32-bit**.*

You must write an algorithm that runs in `O(n)` time and without using the division operation.
*Bạn phải viết một thuật toán chạy trong thời gian `O(n)` và không sử dụng phép chia.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,2,3,4]`
**Output:** `[24,12,8,6]`

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [-1,1,0,-3,3]`
**Output:** `[0,0,9,0,0]`

## Constraints:
## *Ràng buộc:*

*   `2 <= nums.length <= 10^5`
*   `-30 <= nums[i] <= 30`
*   The product of any prefix or suffix of `nums` is **guaranteed** to fit in a **32-bit** integer.

**Follow up:** Can you solve the problem in `O(1)` extra space complexity? (The output array does not count as extra space for space complexity analysis.)
**Câu hỏi mở rộng:** Bạn có thể giải quyết bài toán với độ phức tạp không gian `O(1)` không?

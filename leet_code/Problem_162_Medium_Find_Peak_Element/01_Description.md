# Result for Find Peak Element
# *Kết quả cho bài toán Tìm phần tử cực đại*

## Description
## *Mô tả*

A peak element is an element that is strictly greater than its neighbors.
*Một phần tử cực đại là một phần tử lớn hơn hẳn các phần tử lân cận của nó.*

Given a **0-indexed** integer array `nums`, find a peak element, and return its index. If the array contains multiple peaks, return the index to **any of the peaks**.
*Cho một mảng số nguyên `nums` được đánh chỉ số từ 0, hãy tìm một phần tử cực đại và trả về chỉ số của nó. Nếu mảng chứa nhiều cực đại, hãy trả về chỉ số của **bất kỳ cực đại nào***.*

You may imagine that `nums[-1] = nums[n] = -∞`. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
*Bạn có thể tưởng tượng rằng `nums[-1] = nums[n] = -∞`. Nói cách khác, một phần tử luôn được coi là lớn hơn hẳn một phần tử lân cận nằm ngoài mảng.*

You must write an algorithm that runs in **O(log n)** time.
*Bạn phải viết một thuật toán chạy trong thời gian **O(log n)***.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,2,3,1]`
**Output:** `2`
**Explanation:** 3 is a peak element and your function should return the index number 2.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,2,1,3,5,6,4]`
**Output:** `5`
**Explanation:** Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 1000`
*   `-2^31 <= nums[i] <= 2^31 - 1`
*   `nums[i] != nums[i + 1]` for all valid `i`.

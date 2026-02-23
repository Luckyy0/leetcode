# Result for Maximum Sum of 3 Non-Overlapping Subarrays
# *Kết quả cho bài toán Tổng Cực đại của 3 Mảng con không Gối nhau*

## Description
## *Mô tả*

Given an integer array `nums` and an integer `k`, find three non-overlapping subarrays of length `k` with maximum sum and return their starting indices.
*Cho một mảng số nguyên `nums` và một số nguyên `k`, hãy tìm ba mảng con không gối nhau có độ dài `k` với tổng cực đại và trả về các chỉ số bắt đầu của chúng.*

Every subarray will be of size `k`, and we want to maximize the sum of all $3 \times k$ entries.
*Mỗi mảng con sẽ có kích thước `k`, và chúng ta muốn tối đa hóa tổng của tất cả $3 \times k$ phần tử.*

Return the result as an array of indices representing the starting position of each subarray (0-indexed). If there are multiple answers, return the lexicographically smallest one.
*Hãy trả về kết quả dưới dạng một mảng các chỉ số đại diện cho vị trí bắt đầu của mỗi mảng con (từ 0). Nếu có nhiều đáp án, hãy trả về đáp án nhỏ nhất theo thứ tự từ điển.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,2,1,2,6,7,5,1], k = 2
**Output:** [0,3,5]
**Explanation:** Subarrays [1, 2], [2, 6], [7, 5] correspond to starting indices [0, 3, 5].
The sum is 3 + 8 + 12 = 23.
Another combination [1, 2], [2, 6], [5, 1] has sum 21.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,2,1,2,1,2,1,2,1], k = 2
**Output:** [0,2,4]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 2 * 10^4`
*   `1 <= nums[i] <= 2^16`
*   `1 <= k <= floor(nums.length / 3)`

# Result for Maximum Average Subarray I
# *Kết quả cho bài toán Mảng con có Trung bình cộng Lớn nhất I*

## Description
## *Mô tả*

You are given an integer array `nums` consisting of `n` elements, and an integer `k`.
*Bạn được cho một mảng số nguyên `nums` gồm `n` phần tử và một số nguyên `k`.*

Find a contiguous subarray whose **length is equal to k** that has the maximum average value and return this value. Any answer with a calculation error less than `10^-5` will be accepted.
*Hãy tìm một mảng con liên tiếp có **độ dài bằng k** có giá trị trung bình lớn nhất và trả về giá trị này. Bất kỳ câu trả lời nào có sai số tính toán nhỏ hơn `10^-5` đều sẽ được chấp nhận.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,12,-5,-6,50,3], k = 4
**Output:** 12.75000
**Explanation:** Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [5], k = 1
**Output:** 5.00000

---

## Constraints:
## *Ràng buộc:*

*   `n == nums.length`
*   `1 <= k <= n <= 10^5`
*   `-10^4 <= nums[i] <= 10^4`

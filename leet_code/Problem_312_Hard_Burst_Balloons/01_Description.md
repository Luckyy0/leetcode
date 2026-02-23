# Result for Burst Balloons
# *Kết quả cho bài toán Nổ Bong bóng*

## Description
## *Mô tả*

You are given `n` balloons, indexed from `0` to `n - 1`. Each balloon is painted with a number on it represented by an array `nums`. You are asked to burst all the balloons.
*Bạn được cho `n` quả bong bóng, được đánh số từ `0` đến `n - 1`. Mỗi quả bong bóng được sơn một con số được biểu diễn bởi mảng `nums`. Bạn được yêu cầu nổ tất cả các quả bong bóng.*

If you burst the `i^th` balloon, you will get `nums[i - 1] * nums[i] * nums[i + 1]` coins. If `i - 1` or `i + 1` goes out of bounds of the array, then treat it as if there is a balloon with a `1` painted on it.
*Nếu bạn nổ quả bong bóng thứ `i`, bạn sẽ nhận được `nums[i - 1] * nums[i] * nums[i + 1]` xu. Nếu `i - 1` hoặc `i + 1` nằm ngoài giới hạn của mảng, hãy coi như có một quả bong bóng với số `1` được sơn trên đó.*

Return *the maximum coins you can collect by bursting the balloons wisely*.
*Trả về *số xu tối đa bạn có thể thu thập được bằng cách nổ bong bóng một cách khôn ngoan*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [3,1,5,8]`
**Output:** `167`
**Explanation:**
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 15 + 120 + 24 + 8 = 167

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,5]`
**Output:** `10`

## Constraints:
## *Ràng buộc:*

*   `n == nums.length`
*   `1 <= n <= 300`
*   `0 <= nums[i] <= 100`

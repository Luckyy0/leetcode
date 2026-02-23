# Result for Smallest Rotation with Highest Score
# *Kết quả cho bài toán Vòng xoay nhỏ nhất với điểm số cao nhất*

## Description
## *Mô tả*

You are given an array `nums`. You can rotate it by a non-negative integer `k` so that the array becomes `[nums[k], nums[k + 1], ..., nums[n - 1], nums[0], ..., nums[k - 1]]`.
*Bạn được cho một mảng `nums`. Bạn có thể xoay nó bởi một số nguyên không âm `k` để mảng trở thành `[nums[k], nums[k + 1], ..., nums[n - 1], nums[0], ..., nums[k - 1]]`.*

A score is calculated for each rotation:
- The score is the number of indices `i` such that `nums[i] <= i`.
*Một điểm số được tính cho mỗi vòng xoay: Điểm số là số lượng các chỉ số `i` sao cho `nums[i] <= i`.*

Return *the rotation `k` that has the highest score*. If there are multiple answers, return the smallest such `k`.
*Trả về *vòng xoay `k` có điểm số cao nhất*. Nếu có nhiều câu trả lời, hãy trả về `k` nhỏ nhất.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [2,3,1,4,0]
**Output:** 3
**Explanation:** 
Scores for each k are:
k = 0,  nums = [2,3,1,4,0],    score 2
k = 1,  nums = [3,1,4,0,2],    score 3
k = 2,  nums = [1,4,0,2,3],    score 3
k = 3,  nums = [0,2,3,1,4],    score 4
k = 4,  nums = [2,3,1,4,0],    score 3
So we should choose k = 3, which has the highest score.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,3,0,2,4]
**Output:** 0
**Explanation:** 
For k = 0, nums = [1,3,0,2,4], score 5.
For k = 1 to 4, score will be lower than 5.
So we should choose k = 0.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^5`
*   `0 <= nums[i] < nums.length`

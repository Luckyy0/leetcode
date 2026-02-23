# Result for Largest Sum of Averages
# *Kết quả cho bài toán Tổng các trung bình cộng lớn nhất*

## Description
## *Mô tả*

You are given an integer array `nums` and an integer `k`. You can partition the array into **at most** `k` non-empty adjacent subarrays. The **score** of a partition is the sum of the averages of each subarray.
*Cho một mảng số nguyên `nums` và một số nguyên `k`. Bạn có thể chia mảng thành **tối đa** `k` mảng con kề nhau không rỗng. **Điểm số** của việc phân chia là tổng của các trung bình cộng của mỗi mảng con.*

Note that every element of the array must be in exactly one subarray.
*Lưu ý rằng mọi phần tử của mảng phải nằm trong đúng một mảng con.*

Return *the maximum score you can achieve of all the possible partitions*. Answers within `10^-6` of the actual answer will be accepted.
*Trả về *điểm số lớn nhất bạn có thể đạt được trong tất cả các cách phân chia có thể*. Các câu trả lời nằm trong khoảng `10^-6` so với kết quả thực tế sẽ được chấp nhận.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [9,1,2,3,9], k = 3
**Output:** 20.00000
**Explanation:** 
The best way is to partition nums into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
We could have also partitioned [9, 1, 2], [3, 9], for example.
That partition would lead to a score of 4 + 6 = 10. The score would be (9+1+2)/3 + (3+9)/2 = 4 + 6 = 10.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,2,3,4,5,6,7], k = 4
**Output:** 12.75000

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 100`
*   `1 <= nums[i] <= 10^4`
*   `1 <= k <= nums.length`

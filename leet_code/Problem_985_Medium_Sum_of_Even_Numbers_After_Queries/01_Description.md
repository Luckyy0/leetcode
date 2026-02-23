# Result for Sum of Even Numbers After Queries
# *Kết quả cho bài toán Tổng của các số Chẵn sau các Câu truy vấn*

## Description
## *Mô tả*

You are given an integer array `nums` and an array `queries` where `queries[i] = [val_i, index_i]`.
*Bạn được cho một mảng số nguyên `nums` và một mảng `queries` trong đó `queries[i] = [val_i, index_i]`.*

For each query `i`, first, apply `nums[index_i] = nums[index_i] + val_i`, then print the sum of the even values of `nums`.
*Đối với mỗi câu truy vấn `i`, trước tiên, áp dụng `nums[index_i] = nums[index_i] + val_i`, sau đó in ra tổng của các giá trị chẵn của `nums`.*

Return *an integer array* `answer` *where* `answer[i]` *is the answer to the* `i`-th *query*.
*Trả về *một mảng số nguyên* `answer` *trong đó* `answer[i]` *là câu trả lời cho câu truy vấn thứ* `i`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
**Output:** [8,6,2,4]
**Explanation:** At the beginning, the array is [1,2,3,4].
After adding 1 to nums[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
After adding -3 to nums[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
After adding -4 to nums[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
After adding 2 to nums[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1], queries = [[4,0]]
**Output:** [0]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^4`
*   `-10^4 <= nums[i] <= 10^4`
*   `1 <= queries.length <= 10^4`
*   `-10^4 <= val_i <= 10^4`
*   `0 <= index_i < nums.length`

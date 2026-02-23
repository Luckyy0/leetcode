# Result for Top K Frequent Elements
# *Kết quả cho bài toán Top K Phần tử Thường xuyên nhất*

## Description
## *Mô tả*

Given an integer array `nums` and an integer `k`, return *the* `k` *most frequent elements*. You may return the answer in **any order**.
*Cho một mảng số nguyên `nums` và một số nguyên `k`, trả về *`k` *phần tử thường xuyên nhất*. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,1,1,2,2,3], k = 2`
**Output:** `[1,2]`

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1], k = 1`
**Output:** `[1]`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^5`
*   `-10^4 <= nums[i] <= 10^4`
*   `k` is in the range `[1, the number of unique elements in the array]`.
*   It is **guaranteed** that the answer is **unique**.

**Follow up:** Your algorithm's time complexity must be better than $O(n \log n)$, where $n$ is the array's size.
**Câu hỏi mở rộng:** Độ phức tạp thời gian của thuật toán phải tốt hơn $O(n \log n)$, trong đó $n$ là kích thước của mảng.

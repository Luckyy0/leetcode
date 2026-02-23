# Result for Sliding Window Maximum
# *Kết quả cho bài toán Cửa sổ trượt lớn nhất*

## Description
## *Mô tả*

You are given an array of integers `nums`, there is a sliding window of size `k` which is moving from the very left of the array to the very right. You can only see the `k` numbers in the window. Each time the sliding window moves right by one position.
*Bạn được cho một mảng số nguyên `nums`, có một cửa sổ trượt kích thước `k` di chuyển từ phía trái cùng của mảng sang phải. Bạn chỉ có thể nhìn thấy `k` số trong cửa sổ. Mỗi lần cửa sổ trượt di chuyển sang phải một vị trí.*

Return *the max sliding window*.
*Trả về *cửa sổ trượt lớn nhất*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,3,-1,-3,5,3,6,7], k = 3`
**Output:** `[3,3,5,5,6,7]`
**Explanation:** 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       **3**
 1 [3  -1  -3] 5  3  6  7       **3**
 1  3 [-1  -3  5] 3  6  7       **5**
 1  3  -1 [-3  5  3] 6  7       **5**
 1  3  -1  -3 [5  3  6] 7       **6**
 1  3  -1  -3  5 [3  6  7]      **7**

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1], k = 1`
**Output:** `[1]`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^5`
*   `-10^4 <= nums[i] <= 10^4`
*   `1 <= k <= nums.length`

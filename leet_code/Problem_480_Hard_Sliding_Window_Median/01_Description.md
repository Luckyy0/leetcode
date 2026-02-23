# Result for Sliding Window Median
# *Kết quả cho bài toán Trung vị Cửa sổ Trượt*

## Description
## *Mô tả*

The **median** is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle values.
*Trung vị là giá trị ở giữa trong một danh sách số nguyên được sắp xếp. Nếu kích thước của danh sách là chẵn, không có giá trị ở giữa. Vì vậy, trung vị là trung bình cộng của hai giá trị ở giữa.*

- For examples, if `arr = [2,3,4]`, the median is `3`.
- For examples, if `arr = [2,3]`, the median is `(2 + 3) / 2 = 2.5`.

You are given an integer array `nums` and an integer `k`. There is a sliding window of size `k` which is moving from the very left of the array to the very right. You can only see the `k` numbers in the window. Each time the sliding window moves right by one position.
*Bạn được cho một mảng số nguyên `nums` và một số nguyên `k`. Có một cửa sổ trượt kích thước `k` di chuyển từ bên trái cùng của mảng sang bên phải cùng. Bạn chỉ có thể nhìn thấy `k` số trong cửa sổ. Mỗi lần cửa sổ trượt di chuyển sang phải một vị trí.*

Return *the median array for each window in the original array*. Answers within `10^-5` of the actual value will be accepted.
*Hãy trả về *mảng trung vị cho mỗi cửa sổ trong mảng ban đầu*. Các câu trả lời nằm trong khoảng `10^-5` so với giá trị thực tế sẽ được chấp nhận.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,3,-1,-3,5,3,6,7], k = 3`
**Output:** `[1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]`
**Explanation:** 
Window position                Median
---------------                -----
[1  3  -1] -3  5  3  6  7        1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7        3
 1  3  -1  -3 [5  3  6] 7        5
 1  3  -1  -3  5 [3  6  7]       6

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,2,3,4,2,3,1,4,2], k = 3`
**Output:** `[2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000,3.00000]`

## Constraints:
## *Ràng buộc:*

*   `1 <= k <= nums.length <= 10^5`
*   `-2^{31} <= nums[i] <= 2^{31} - 1`

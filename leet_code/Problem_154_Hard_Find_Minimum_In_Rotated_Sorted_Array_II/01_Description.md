# Result for Find Minimum in Rotated Sorted Array II
# *Kết quả cho bài toán Tìm phần tử nhỏ nhất trong mảng đã sắp xếp bị xoay II*

## Description
## *Mô tả*

Suppose an array of length `n` sorted in ascending order is **rotated** between `1` and `n` times. For example, the array `nums = [0,1,4,4,5,6,7]` might become:
*Giả sử một mảng độ dài `n` đã được sắp xếp theo thứ tự tăng dần bị **xoay** từ `1` đến `n` lần. Ví dụ, mảng `nums = [0,1,4,4,5,6,7]` có thể trở thành:*

*   `[4,5,6,7,0,1,4]` if it was rotated 4 times.
*   `[0,1,4,4,5,6,7]` if it was rotated 7 times.

Notice that **rotating** an array `[a[0], a[1], a[2], ..., a[n-1]]` 1 time results in the array `[a[n-1], a[0], a[1], a[2], ..., a[n-2]]`.
*Lưu ý rằng việc **xoay** một mảng 1 lần sẽ dẫn đến mảng `[a[n-1], a[0], a[1], a[2], ..., a[n-2]]`.*

Given the sorted rotated array `nums` that may contain **duplicates**, return *the minimum element of this array*.
*Cho mảng đã sắp xếp bị xoay `nums` có thể chứa các phần tử **trùng lặp**, hãy trả về *phần tử nhỏ nhất của mảng này***.*

You must decrease the overall operation steps as much as possible.
*Bạn phải giảm bớt các bước thực thi tổng thể nhiều nhất có thể.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,3,5]`
**Output:** `1`

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [2,2,2,0,1]`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `n == nums.length`
*   `1 <= n <= 5000`
*   `-5000 <= nums[i] <= 5000`
*   `nums` is sorted and rotated between `1` and `n` times.

**Follow up:** This problem is similar to **Find Minimum in Rotated Sorted Array**, but `nums` may contain **duplicates**. Would this affect the runtime complexity? How and why?
**Câu hỏi mở rộng:** Bài toán này tương tự như **Tìm phần tử nhỏ nhất trong mảng đã sắp xếp bị xoay**, nhưng `nums` có thể chứa các phần tử **trùng lặp**. Điều này có ảnh hưởng đến độ phức tạp thời gian không? Tại sao và như thế nào?

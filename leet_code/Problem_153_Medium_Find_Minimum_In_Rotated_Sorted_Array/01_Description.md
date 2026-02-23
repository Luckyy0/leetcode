# Result for Find Minimum in Rotated Sorted Array
# *Kết quả cho bài toán Tìm phần tử nhỏ nhất trong mảng đã sắp xếp bị xoay*

## Description
## *Mô tả*

Suppose an array of length `n` sorted in ascending order is **rotated** between `1` and `n` times. For example, the array `nums = [0,1,2,4,5,6,7]` might become:
*Giả sử một mảng độ dài `n` đã được sắp xếp theo thứ tự tăng dần bị **xoay** từ `1` đến `n` lần. Ví dụ, mảng `nums = [0,1,2,4,5,6,7]` có thể trở thành:*

*   `[4,5,6,7,0,1,2]` if it was rotated 4 times.
*   `[0,1,2,4,5,6,7]` if it was rotated 7 times.

Notice that **rotating** an array `[a[0], a[1], a[2], ..., a[n-1]]` 1 time results in the array `[a[n-1], a[0], a[1], a[2], ..., a[n-2]]`.
*Lưu ý rằng việc **xoay** một mảng 1 lần sẽ dẫn đến mảng `[a[n-1], a[0], a[1], a[2], ..., a[n-2]]`.*

Given the sorted rotated array `nums` of **unique** elements, return *the minimum element of this array*.
*Cho mảng đã sắp xếp bị xoay `nums` gồm các phần tử **duy nhất**, hãy trả về *phần tử nhỏ nhất của mảng này***.*

You must write an algorithm that runs in **O(log n)** time.
*Bạn phải viết một thuật toán chạy trong thời gian **O(log n)***.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [3,4,5,1,2]`
**Output:** `1`
**Explanation:** The original array was [1,2,3,4,5] rotated 3 times.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [4,5,6,7,0,1,2]`
**Output:** `0`
**Explanation:** The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = [11,13,15,17]`
**Output:** `11`
**Explanation:** The original array was [11,13,15,17] and it was rotated 4 times.

## Constraints:
## *Ràng buộc:*

*   `n == nums.length`
*   `1 <= n <= 5000`
*   `-5000 <= nums[i] <= 5000`
*   All the integers of `nums` are **unique**.
*   `nums` is sorted and rotated between `1` and `n` times.

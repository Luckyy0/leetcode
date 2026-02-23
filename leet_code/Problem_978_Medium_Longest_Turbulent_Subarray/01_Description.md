# Result for Longest Turbulent Subarray
# *Kết quả cho bài toán Mảng con Hỗn loạn Dài nhất*

## Description
## *Mô tả*

Given an integer array `arr`, return *the length of a maximum size turbulent subarray of* `arr`.
*Cho một mảng số nguyên `arr`, trả về *độ dài của mảng con hỗn loạn có kích thước lớn nhất của* `arr`.*

A subarray is **turbulent** if the comparison sign flips between each adjacent pair of elements in the subarray.
*Một mảng con được gọi là **hỗn loạn** nếu dấu so sánh đảo ngược giữa mỗi cặp phần tử liền kề trong mảng con.*

More formally, a subarray `[arr[i], arr[i + 1], ..., arr[j]]` of `arr` is said to be turbulent if and only if:
*Chính thức hơn, một mảng con `[arr[i], arr[i + 1], ..., arr[j]]` của `arr` được gọi là hỗn loạn khi và chỉ khi:*

*   For `i <= k < j`:
    *   `arr[k] > arr[k + 1]` when `k` is odd, and
    *   `arr[k] < arr[k + 1]` when `k` is even.
*   Or, for `i <= k < j`:
    *   `arr[k] > arr[k + 1]` when `k` is even, and
    *   `arr[k] < arr[k + 1]` when `k` is odd.

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [9,4,2,10,7,8,8,1,9]
**Output:** 5
**Explanation:** arr[1] > arr[2] < arr[3] > arr[4] < arr[5]

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [4,8,12,16]
**Output:** 2

## Example 3:
## *Ví dụ 3:*

**Input:** arr = [100]
**Output:** 1

---

## Constraints:
## *Ràng buộc:*

*   `1 <= arr.length <= 4 * 10^4`
*   `0 <= arr[i] <= 10^9`

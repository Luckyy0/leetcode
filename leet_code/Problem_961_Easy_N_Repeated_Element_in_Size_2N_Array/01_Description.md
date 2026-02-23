# Result for N-Repeated Element in Size 2N Array
# *Kết quả cho bài toán Phần tử Lặp lại N lần trong Mảng kích thước 2N*

## Description
## *Mô tả*

You are given an integer array `nums` with the following properties:
*Bạn được cho một mảng số nguyên `nums` với các thuộc tính sau:*

*   `nums.length == 2 * n`.
*   `nums` contains `n + 1` **unique** elements.
    *   *`nums` chứa `n + 1` phần tử **duy nhất**.*
*   Exactly one element of `nums` is repeated `n` times.
    *   *Chính xác một phần tử của `nums` được lặp lại `n` lần.*

Return *the element that is repeated* `n` *times*.
*Trả về *phần tử được lặp lại* `n` *lần*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,2,3,3]
**Output:** 3

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [2,1,2,5,3,2]
**Output:** 2

## Example 3:
## *Ví dụ 3:*

**Input:** nums = [5,1,5,2,5,3,5,4]
**Output:** 5

---

## Constraints:
## *Ràng buộc:*

*   `2 <= n <= 5000`
*   `nums.length == 2 * n`
*   `0 <= nums[i] <= 10^4`
*   `nums` contains `n + 1` **unique** elements and one of them is repeated exactly `n` times.

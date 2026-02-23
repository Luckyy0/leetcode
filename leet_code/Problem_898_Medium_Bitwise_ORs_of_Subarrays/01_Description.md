# Result for Bitwise ORs of Subarrays
# *Kết quả cho bài toán OR bit của các mảng con*

## Description
## *Mô tả*

We have an array `arr` of non-negative integers.
*Chúng ta có một mảng `arr` gồm các số nguyên không âm.*

For every (contiguous) subarray `sub = [arr[i], arr[i + 1], ..., arr[j]]` (with `i <= j`), we take the bitwise OR of all the elements in `sub`, obtaining a result `arr[i] | arr[i + 1] | ... | arr[j]`.
*Đối với mọi mảng con (liên tiếp) `sub = [arr[i], arr[i + 1], ..., arr[j]]` (với `i <= j`), chúng ta lấy phép OR bit của tất cả các phần tử trong `sub`, thu được kết quả `arr[i] | arr[i + 1] | ... | arr[j]`.*

Return the number of possible results. Results that occur more than once are only counted once in the final answer.
*Trả về số lượng kết quả có thể có. Các kết quả xuất hiện nhiều hơn một lần chỉ được đếm một lần trong câu trả lời cuối cùng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [0]
**Output:** 1
**Explanation:** 
There is only one possible result: 0.

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [1,1,2]
**Output:** 3
**Explanation:** 
The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
These yield the results 1, 1, 2, 1, 3, 3.
There are 3 unique values: 1, 2, 3.

## Example 3:
## *Ví dụ 3:*

**Input:** arr = [1,2,4]
**Output:** 6
**Explanation:** 
The possible results are 1, 2, 3, 4, 6, 7.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= arr.length <= 5 * 10^4`
*   `0 <= arr[i] <= 10^9`

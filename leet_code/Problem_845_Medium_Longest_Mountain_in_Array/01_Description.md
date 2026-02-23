# Result for Longest Mountain in Array
# *Kết quả cho bài toán Ngọn núi Dài nhất trong Mảng*

## Description
## *Mô tả*

You may recall that an array `arr` is a **mountain array** if and only if:
*Bạn có thể nhớ rằng một mảng `arr` là một **mảng hình núi** khi và chỉ khi:*

1.  `arr.length >= 3`
2.  There exists some index `i` (`0 < i < arr.length - 1`) such that:
    *Tồn tại một chỉ số `i` (`0 < i < arr.length - 1`) sao cho:*
    `arr[0] < arr[1] < ... < arr[i - 1] < arr[i]`
    `arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`

Given an integer array `arr`, return *the length of the longest subarray, which is a mountain*. Return `0` if there is no mountain subarray.
*Cho một mảng số nguyên `arr`, hãy trả về *độ dài của mảng con dài nhất là một ngọn núi*. Trả về `0` nếu không có mảng con hình núi nào.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [2,1,4,7,3,2,5]
**Output:** 5
**Explanation:** The longest mountain is [1,4,7,3,2] which has length 5.

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [2,2,2]
**Output:** 0
**Explanation:** There is no mountain.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= arr.length <= 10^4`
*   `0 <= arr[i] <= 10^4`

---

## Follow up:
*   Can you solve it using only one pass?
    *Bạn có thể giải quyết nó chỉ bằng một lượt duyệt không?*
*   Can you solve it in `O(1)` space?
    *Bạn có thể giải quyết nó trong không gian `O(1)` không?*

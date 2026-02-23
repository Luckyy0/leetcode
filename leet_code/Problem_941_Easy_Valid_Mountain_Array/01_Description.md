# Result for Valid Mountain Array
# *Kết quả cho bài toán Mảng Núi Hợp lệ*

## Description
## *Mô tả*

Given an array of integers `arr`, return `true` *if and only if it is a valid mountain array*.
*Cho một mảng các số nguyên `arr`, trả về `true` *nếu và chỉ nếu đó là một mảng núi hợp lệ*.*

Recall that `arr` is a mountain array if and only if:
*Nhắc lại rằng `arr` là một mảng núi nếu và chỉ nếu:*

*   `arr.length >= 3`
*   There exists some `i` with `0 < i < arr.length - 1` such that:
    *   `arr[0] < arr[1] < ... < arr[i - 1] < arr[i]`
    *   `arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`
    *   *Tồn tại một số `i` với `0 < i < arr.length - 1` sao cho:*
        *   `arr[0] < arr[1] < ... < arr[i - 1] < arr[i]`
        *   `arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [2,1]
**Output:** false

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [3,5,5]
**Output:** false

## Example 3:
## *Ví dụ 3:*

**Input:** arr = [0,3,2,1]
**Output:** true

---

## Constraints:
## *Ràng buộc:*

*   `1 <= arr.length <= 10^4`
*   `0 <= arr[i] <= 10^4`

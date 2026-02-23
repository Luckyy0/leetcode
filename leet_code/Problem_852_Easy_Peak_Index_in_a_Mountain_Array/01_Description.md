# Result for Peak Index in a Mountain Array
# *Kết quả cho bài toán Chỉ số Đỉnh trong Mảng Ngọn núi*

## Description
## *Mô tả*

An array `arr` is a **mountain** if the following properties hold:
*Một mảng `arr` được gọi là một **ngọn núi** nếu các thuộc tính sau được thỏa mãn:*

- `arr.length >= 3`
- There exists some `i` with `0 < i < arr.length - 1` such that:
    - `arr[0] < arr[1] < ... < arr[i - 1] < arr[i]`
    - `arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`

Given a mountain array `arr`, return the index `i` such that `arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`.
*Cho một mảng ngọn núi `arr`, hãy trả về chỉ số `i` sao cho `arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`.*

You must solve it in `O(log(arr.length))` time complexity.
*Bạn phải giải nó với độ phức tạp thời gian là `O(log(arr.length))`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [0,1,0]
**Output:** 1

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [0,2,1,0]
**Output:** 1

## Example 3:
## *Ví dụ 3:*

**Input:** arr = [0,10,5,2]
**Output:** 1

---

## Constraints:
## *Ràng buộc:*

*   `3 <= arr.length <= 10^5`
*   `0 <= arr[i] <= 10^6`
*   `arr` is guaranteed to be a mountain array.

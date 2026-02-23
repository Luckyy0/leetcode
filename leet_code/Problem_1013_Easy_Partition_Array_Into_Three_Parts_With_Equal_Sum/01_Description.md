# Result for Partition Array Into Three Parts With Equal Sum
# *Kết quả cho bài toán Chia mảng thành 3 phần có tổng bằng nhau*

## Description
## *Mô tả*

Given an array of integers `arr`, return `true` if we can partition the array into three **non-empty** parts with equal sums.
*Cho một mảng các số nguyên `arr`, trả về `true` nếu chúng ta có thể chia mảng thành ba phần **không rỗng** có tổng bằng nhau.*

Formally, we can partition the array if we can find indexes `i + 1 < j` with `(arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])`
*Nói một cách toán học, ta có thể chia mảng nếu có thể tìm thấy các chỉ số `i + 1 < j` sao cho: `(arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])`*

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [0,2,1,-6,6,-7,9,1,2,0,1]
**Output:** true
**Explanation:** 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [0,2,1,-6,6,7,9,-1,2,0,1]
**Output:** false

## Example 3:
## *Ví dụ 3:*

**Input:** arr = [3,3,6,5,-2,2,5,1,-9,4]
**Output:** true
**Explanation:** 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4

---

## Constraints:
## *Ràng buộc:*

*   `3 <= arr.length <= 5 * 10^4`
*   `-10^4 <= arr[i] <= 10^4`

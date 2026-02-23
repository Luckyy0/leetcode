# Result for Three Equal Parts
# *Kết quả cho bài toán Ba phần Bằng nhau*

## Description
## *Mô tả*

You are given an array `arr` which consists of only zeros and ones, divide the array into **three non-empty parts** such that all of these parts represent the same binary value.
*Bạn được cho một mảng `arr` chỉ bao gồm các số 0 và 1, hãy chia mảng thành **ba phần không rỗng** sao cho tất cả các phần này đều đại diện cho cùng một giá trị nhị phân.*

If it is possible, return any `[i, j]` with `i + 1 < j`, such that:
*Nếu có thể, hãy trả về bất kỳ `[i, j]` nào với `i + 1 < j`, sao cho:*

*   `arr[0], arr[1], ..., arr[i]` is the first part,
    *   *`arr[0], arr[1], ..., arr[i]` là phần đầu tiên,*
*   `arr[i + 1], arr[i + 2], ..., arr[j - 1]` is the second part, and
    *   *`arr[i + 1], arr[i + 2], ..., arr[j - 1]` là phần thứ hai, và*
*   `arr[j], arr[j + 1], ..., arr[arr.length - 1]` is the third part.
    *   *`arr[j], arr[j + 1], ..., arr[arr.length - 1]` là phần thứ ba.*
*   All three parts have equal binary value.
    *   *Cả ba phần đều có giá trị nhị phân bằng nhau.*

If it is not possible, return `[-1, -1]`.
*Nếu không thể, hãy trả về `[-1, -1]`.*

Note that the entire part is used when considering what binary value it represents. For example, `[1,1,0]` represents `6` in decimal, not `3`. Also, leading zeros are allowed, so `[0,1,1]` and `[1,1]` represent the same value.
*Lưu ý rằng toàn bộ phần được sử dụng khi xem xét giá trị nhị phân mà nó đại diện. Ví dụ, `[1,1,0]` đại diện cho `6` trong hệ thập phân, không phải `3`. Ngoài ra, các số 0 ở đầu được cho phép, vì vậy `[0,1,1]` và `[1,1]` đại diện cho cùng một giá trị.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [1,0,1,0,1]
**Output:** [0,3]

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [1,1,0,1,1]
**Output:** [-1,-1]

## Example 3:
## *Ví dụ 3:*

**Input:** arr = [1,1,0,0,1]
**Output:** [0,2]

---

## Constraints:
## *Ràng buộc:*

*   `3 <= arr.length <= 3 * 10^4`
*   `arr[i]` is `0` or `1`.

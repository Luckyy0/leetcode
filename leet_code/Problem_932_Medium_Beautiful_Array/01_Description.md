# Result for Beautiful Array
# *Kết quả cho bài toán Mảng Đẹp*

## Description
## *Mô tả*

An array `nums` of length `n` is **beautiful** if:
*Một mảng `nums` có độ dài `n` là **đẹp** nếu:*

*   `nums` is a permutation of the integers in the range `[1, n]`.
    *   *`nums` là một hoán vị của các số nguyên trong khoảng `[1, n]`.*
*   For every `0 <= i < j < n`, there is no index `k` with `i < k < j` where `2 * nums[k] == nums[i] + nums[j]`.
    *   *Mọi cặp chỉ số `i < j`, không tồn tại chỉ số `k` nào nằm giữa `i < k < j` sao cho `2 * nums[k] == nums[i] + nums[j]`.*

Given the integer `n`, return *any **beautiful** array `nums` of length `n`*. There will be at least one valid answer for the given `n`.
*Cho số nguyên `n`, hãy trả về *bất kỳ mảng **đẹp** `nums` nào có độ dài `n`*. Sẽ luôn có ít nhất một câu trả lời hợp lệ cho `n` đã cho.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 4
**Output:** [2,1,4,3]

## Example 2:
## *Ví dụ 2:*

**Input:** n = 5
**Output:** [3,1,2,5,4]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 1000`

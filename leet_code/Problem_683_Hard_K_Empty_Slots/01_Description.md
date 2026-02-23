# Result for K Empty Slots
# *Kết quả cho bài toán K Vị trí Trống*

## Description
## *Mô tả*

You have `n` bulbs in a row numbered from `1` to `n`. Initially, all the bulbs are turned off. We turn on exactly one bulb every day until all `n` bulbs are on after `n` days.
*Bạn có `n` bóng đèn xếp thành một hàng được đánh số từ `1` đến `n`. Ban đầu, tất cả các bóng đèn đều tắt. Mỗi ngày chúng ta bật đúng một bóng đèn cho đến khi toàn bộ `n` bóng đèn đều bật sau `n` ngày.*

You are given an array `bulbs` of length `n` where `bulbs[i] = x` means that on the `(i+1)th` day, we will turn on the bulb at position `x`.
*Bạn được cho một mảng `bulbs` có độ dài `n` trong đó `bulbs[i] = x` nghĩa là vào ngày thứ `(i+1)`, chúng ta sẽ bật bóng đèn tại vị trí `x`.*

Given an integer `k`, return the **earliest day** such that there exists two turned on bulbs that have exactly `k` bulbs between them that are all turned off.
*Cho một số nguyên `k`, hãy trả về **ngày sớm nhất** sao cho tồn tại hai bóng đèn đang bật mà có đúng `k` bóng đèn ở giữa chúng đều đang tắt.*

If there isn't such day, return `-1`.
*Nếu không có ngày như vậy, hãy trả về `-1`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** bulbs = [1,3,2], k = 1
**Output:** 2
**Explanation:**
On the first day: bulbs[0]=1, first bulb is on: [1,0,0]
On the second day: bulbs[1]=3, third bulb is on: [1,0,1]
After 2 days, there are 1 bulb between the first and third bulbs, which is turned off.

## Example 2:
## *Ví dụ 2:*

**Input:** bulbs = [1,2,3], k = 1
**Output:** -1

---

## Constraints:
## *Ràng buộc:*

*   `n == bulbs.length`
*   `1 <= n <= 2 * 10^4`
*   `1 <= bulbs[i] <= n`
*   `bulbs` is a permutation of numbers from `1` to `n`.
*   `0 <= k <= 2 * 10^4`

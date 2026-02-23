# Result for Bulb Switcher
# *Kết quả cho bài toán Công tắc Bóng đèn*

## Description
## *Mô tả*

There are `n` bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb.
*Có `n` bóng đèn ban đầu đều tắt. Đầu tiên bạn bật tất cả các bóng đèn, sau đó bạn tắt mỗi bóng đèn thứ hai.*

On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the `i^th` round, you toggle every `i` bulb. For the `n^th` round, you only toggle the last bulb.
*Vào vòng thứ ba, bạn chuyển đổi trạng thái mỗi bóng đèn thứ ba (bật nếu nó tắt hoặc tắt nếu nó bật). Đối với vòng thứ `i`, bạn chuyển đổi trạng thái mỗi bóng đèn thứ `i`. Đối với vòng thứ `n`, bạn chỉ chuyển đổi trạng thái bóng đèn cuối cùng.*

Return *the number of bulbs that are on after* `n` *rounds*.
*Trả về *số lượng bóng đèn đang bật sau* `n` *vòng*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 3`
**Output:** `1`
**Explanation:**
At first, the three bulbs are [off, off, off].
After the first round, the three bulbs are [on, on, on].
After the second round, the three bulbs are [on, off, on].
After the third round, the three bulbs are [on, off, off].
So you should return 1 because there is only one bulb is on.

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 0`
**Output:** `0`

## Example 3:
## *Ví dụ 3:*

**Input:** `n = 1`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `0 <= n <= 10^9`

# Result for Frog Jump
# *Kết quả cho bài toán Ếch Nhảy*

## Description
## *Mô tả*

A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not be a stone. The frog can jump on a stone, but it must not jump into the water.
*Một con ếch đang băng qua sông. Con sông được chia thành một số đơn vị, và tại mỗi đơn vị, có thể có hoặc không có một tảng đá. Con ếch có thể nhảy lên một tảng đá, nhưng không được nhảy xuống nước.*

Given a list of `stones` positions (in units) in sorted ascending order, determine if the frog can reach the last stone.
*Cho một danh sách các vị trí `stones` (theo đơn vị) được sắp xếp theo thứ tự tăng dần, hãy xác định liệu con ếch có thể nhảy được đến tảng đá cuối cùng hay không.*

Initially, the frog is on the first stone and assumes the first jump must be `1` unit.
*Ban đầu, con ếch ở tảng đá đầu tiên và giả định rằng bước nhảy đầu tiên phải là `1` đơn vị.*

If the frog's last jump was `k` units, its next jump must be either `k - 1`, `k`, or `k + 1` units. The frog can only jump in the forward direction.
*Nếu bước nhảy cuối cùng của con ếch là `k` đơn vị, thì bước nhảy tiếp theo của nó phải là `k - 1`, `k` hoặc `k + 1` đơn vị. Con ếch chỉ có thể nhảy theo hướng về phía trước.*

## Example 1:
## *Ví dụ 1:*

**Input:** `stones = [0,1,3,5,6,8,12,17]`
**Output:** `true`
**Explanation:** The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.

## Example 2:
## *Ví dụ 2:*

**Input:** `stones = [0,1,2,3,4,8,9,11]`
**Output:** `false`
**Explanation:** There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.

## Constraints:
## *Ràng buộc:*

*   `2 <= stones.length <= 2000`
*   `0 <= stones[i] <= 2^31 - 1`
*   `stones[0] == 0`
*   `stones` is sorted in a strictly increasing order.

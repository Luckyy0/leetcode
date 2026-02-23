# Result for Chalkboard XOR Game
# *Kết quả cho bài toán Trò chơi XOR trên bảng*

## Description
## *Mô tả*

You are given an array of integers `nums` represents the numbers written on a chalkboard.
*Bạn được cho một mảng số nguyên `nums` đại diện cho các con số viết trên bảng.*

Two players take turns erasing a number from the chalkboard. If erasing a number causes the bitwise XOR sum of all the remaining numbers on the chalkboard to become `0`, then that player loses. The bitwise XOR sum of the empty chalkboard is `0`.
*Hai người chơi lần lượt xóa một số trên bảng. Nếu việc xóa một số làm cho tổng XOR của tất cả các số còn lại trở thành `0`, người chơi đó thua. Tổng XOR của bảng trống là `0`.*

Also, if any player starts their turn with the bitwise XOR sum of all the numbers on the chalkboard equal to `0`, then that player wins.
*Ngoài ra, nếu bất kỳ người chơi nào bắt đầu lượt của mình với tổng XOR của tất cả các số trên bảng bằng `0`, người chơi đó thắng.*

Return `true` if and only if Alice wins the game, assuming both players play optimally.
*Trả về `true` khi và chỉ khi Alice thắng cuộc, giả định cả hai đều chơi tối ưu.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,1,2]
**Output:** false
**Explanation:** 
Alice has two choices: erase 1 or erase 2. 
If she erases 1, the remaining numbers are [1,2]. The XOR sum is 1 ^ 2 = 3. Now it's Bob's turn.
Bob erases 2, the remaining number is [1], XOR sum is 1. Now it's Alice's turn.
Alice erases 1, the remaining chalkboard is empty, XOR sum is 0. Alice loses. 
Each other case is also a loss for Alice.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [0,1]
**Output:** true

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 1000`
*   `0 <= nums[i] < 2^16`

# Result for Race Car
# *Kết quả cho bài toán Đua xe*

## Description
## *Mô tả*

Your car starts at position `0` and speed `+1` on an infinite number line. Your car can go into negative positions. Your car drives based on a sequence of instructions: `'A'` (accelerate) and `'R'` (reverse):
*Xe của bạn bắt đầu ở vị trí `0` và vận tốc `+1`. Xe có thể đi vào các vị trí âm. Xe di chuyển dựa trên chuỗi lệnh: `'A'` (tăng tốc) và `'R'` (quay đầu):*

*   When you get an instruction `'A'`, your car does the following:
    - `position += speed`
    - `speed *= 2`
*   When you get an instruction `'R'`, your car does the following:
    - If your speed is positive: `speed = -1`
    - otherwise: `speed = 1`
    - Your position stays the same.

For example, after commands `"AAR"`, your car goes to positions `0 -> 1 -> 3 -> 3`, and speed goes to `1 -> 2 -> 4 -> -1`.
*Ví dụ, sau các lệnh `"AAR"`, xe di chuyển đến các vị trí `0 -> 1 -> 3 -> 3`, và vận tốc là `1 -> 2 -> 4 -> -1`.*

Given a target position `target`, return *the length of the shortest sequence of instructions to get there*.
*Cho một vị trí đích `target`, trả về *độ dài của chuỗi lệnh ngắn nhất để đến được đó*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** target = 3
**Output:** 2
**Explanation:** 
The shortest instruction sequence is "AA".
Your position goes from 0 -> 1 -> 3.

## Example 2:
## *Ví dụ 2:*

**Input:** target = 6
**Output:** 5
**Explanation:** 
The shortest instruction sequence is "AAARA".
Your position goes from 0 -> 1 -> 3 -> 7 -> 7 -> 6.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= target <= 10^4`

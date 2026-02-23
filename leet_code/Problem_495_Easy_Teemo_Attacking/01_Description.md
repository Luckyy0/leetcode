# Result for Teemo Attacking
# *Kết quả cho bài toán Teemo Tấn công*

## Description
## *Mô tả*

Our hero Teemo is attacking an enemy Ashe with poison attacks! When Teemo attacks Ashe, Ashe gets poisoned for a exactly `duration` seconds. More formally, an attack at second `t` will mean Ashe is poisoned during the inclusive time interval `[t, t + duration - 1]`. If Teemo attacks again before the poison effect ends, the timer for it is reset, and the poison effect will end `duration` seconds after the new attack.
*Anh hùng Teemo của chúng ta đang tấn công kẻ thù Ashe bằng các đòn tấn công độc! Khi Teemo tấn công Ashe, Ashe bị trúng độc trong chính xác `duration` giây. Cụ thể hơn, một đòn tấn công ở giây thứ `t` có nghĩa là Ashe bị trúng độc trong khoảng thời gian `[t, t + duration - 1]`. Nếu Teemo tấn công lại trước khi hiệu ứng độc kết thúc, bộ đếm thời gian cho nó sẽ được đặt lại và hiệu ứng độc sẽ kết thúc sau `duration` giây kể từ đòn tấn công mới.*

You are given a non-decreasing integer array `timeSeries`, where `timeSeries[i]` denotes that Teemo attacks Ashe at second `timeSeries[i]`, and an integer `duration`.
*Bạn được cho một mảng số nguyên không giảm `timeSeries`, trong đó `timeSeries[i]` biểu thị rằng Teemo tấn công Ashe ở giây thứ `timeSeries[i]`, và một số nguyên `duration`.*

Return *the total number of seconds that Ashe is poisoned*.
*Hãy trả về *tổng số giây mà Ashe bị trúng độc*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `timeSeries = [1,4], duration = 2`
**Output:** `4`
**Explanation:** Teemo's attacks on Ashe go as follows:
- At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
- At second 4, Teemo attacks, and Ashe is poisoned for seconds 4 and 5.
Ashe is poisoned for seconds 1, 2, 4, and 5, which is 4 seconds in total.

## Example 2:
## *Ví dụ 2:*

**Input:** `timeSeries = [1,2], duration = 2`
**Output:** `3`
**Explanation:** Teemo's attacks on Ashe go as follows:
- At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
- At second 2 however, Teemo attacks again and resets the poison timer. Ashe is poisoned for seconds 2 and 3.
Ashe is poisoned for seconds 1, 2, and 3, which is 3 seconds in total.

## Constraints:
## *Ràng buộc:*

*   `1 <= timeSeries.length <= 10^4`
*   `0 <= timeSeries[i], duration <= 10^7`
*   `timeSeries` is sorted in non-decreasing order.

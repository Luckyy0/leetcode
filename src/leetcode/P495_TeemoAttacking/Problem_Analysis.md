# 495. Teemo Attacking / Teemo Tấn Công

## Problem Description / Mô tả bài toán
Our hero Teemo is attacking an enemy Ashe with poison attacks! When Teemo attacks Ashe, Ashe gets poisoned for a exactly `duration` seconds. More formally, an attack at second `t` will mean Ashe is poisoned during the **inclusive** time interval `[t, t + duration - 1]`. If Teemo attacks again **before** the poison effect ends, the timer for it is reset, and the poison effect will end `duration` seconds after the new attack.
Anh hùng Teemo đang tấn công kẻ địch Ashe bằng các đòn tấn công độc! Khi Teemo tấn công Ashe, Ashe bị nhiễm độc trong đúng `duration` giây. Cụ thể hơn, một đòn tấn công tại giây `t` có nghĩa là Ashe bị nhiễm độc trong khoảng thời gian `[t, t + duration - 1]`. Nếu Teemo tấn công lại **trước khi** độc hết hiệu lực, bộ đếm thời gian sẽ được đặt lại và hiệu ứng độc sẽ kết thúc sau `duration` giây kể từ đòn tấn công mới.

You are given a **non-decreasing** integer array `timeSeries`, where `timeSeries[i]` denotes that Teemo attacks Ashe at second `timeSeries[i]`, and an integer `duration`.
Bạn được cho một mảng số nguyên **không giảm** `timeSeries`, trong đó `timeSeries[i]` biểu thị Teemo tấn công Ashe tại giây `timeSeries[i]`, và một số nguyên `duration`.

Return the total number of seconds that Ashe is poisoned.
Hãy trả về tổng số giây mà Ashe bị nhiễm độc.

### Example 1:
```text
Input: timeSeries = [1,4], duration = 2
Output: 4
Explanation: Teemo's attacks on Ashe go as follows:
- At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
- At second 4, Teemo attacks, and Ashe is poisoned for seconds 4 and 5.
Ashe is poisoned for seconds 1, 2, 4, 5, which is 4 seconds in total.
```

### Example 2:
```text
Input: timeSeries = [1,2], duration = 2
Output: 3
Explanation: Teemo's attacks on Ashe go as follows:
- At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
- At second 2, Teemo attacks, and Ashe is poisoned for seconds 2 and 3.
Ashe is poisoned for seconds 1, 2, 3, which is 3 seconds in total.
```

## Constraints / Ràng buộc
- `1 <= timeSeries.length <= 10^4`
- `0 <= timeSeries[i], duration <= 10^7`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation / Mô phỏng
We can iterate through the `timeSeries` and calculate the overlap between consecutive intervals.

Algorithm:
1. Initialize `totalTime = 0`.
2. For each attack at `timeSeries[i]` and the next attack at `timeSeries[i+1]`:
   - Calculate the gap `gap = timeSeries[i+1] - timeSeries[i]`.
   - The poison duration from `timeSeries[i]` will be `min(gap, duration)`. (If the next attack comes before `duration` is over, only `gap` seconds are counted).
3. The last attack always adds the full `duration` to `totalTime`.
4. Return `totalTime`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Interval Summation with Overlap Deduction

**Algorithm**:
1.  Iterate through pairs.
2.  Sum the minimum of gap or duration.
3.  Add full duration for last element.

---

# 1344. Angle Between Hands of a Clock / Góc Giữa Các Kim Đồng Hồ

## Problem Description / Mô tả bài toán
Given `hour` and `minutes`.
Return smaller angle between hour and minute hands.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Geometry / Degrees
Circle = 360 degrees.
Minute hand:
- Moves 360 deg in 60 min.
- Rate: 6 deg/min.
- Pos: `minutes * 6`.

Hour hand:
- Moves 360 deg in 12 hours (720 min).
- Rate: 0.5 deg/min.
- Pos: `(hour % 12 * 60 + minutes) * 0.5`.
- Or `(hour % 12) * 30 + minutes * 0.5`.

Angle: `|PosH - PosM|`.
If angle > 180, take `360 - angle`.

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Math Calculation
Calculate the absolute position (in degrees from 12 o'clock) for both the hour hand and the minute hand.
Minute hand position: `minutes * 6` degrees.
Hour hand position: `(hour % 12) * 30 + minutes * 0.5` degrees.
Calculate the absolute difference. Return `min(diff, 360 - diff)`.
Tính vị trí tuyệt đối (theo độ từ 12 giờ) cho cả kim giờ và kim phút.
Vị trí kim phút: `minutes * 6` độ.
Vị trí kim giờ: `(hour % 12) * 30 + minutes * 0.5` độ.
Tính sự khác biệt tuyệt đối. Trả về `min(diff, 360 - diff)`.

---

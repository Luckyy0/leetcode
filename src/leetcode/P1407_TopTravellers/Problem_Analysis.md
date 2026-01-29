# 1407. Top Travellers / Những Người Du lịch Hàng đầu

## Problem Description / Mô tả bài toán
Tables `Users` (id, name), `Rides` (id, user_id, distance).
Report distance for each user.
Order by distance DESC, name ASC.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Left Join and Group By
Join Users with Rides.
Sum distance. Handle NULL (users with no rides) -> 0.

---

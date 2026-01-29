# 853. Car Fleet / Đội xe

## Problem Description / Mô tả bài toán
There are `n` cars at given `position` and `speed` traveling to a `target`.
Có `n` chiếc xe tại các `position` và `speed` cho trước đang di chuyển tới một `target`.

A car can never pass another car ahead of it. If a car catches up, they form a **fleet** and travel at the speed of the slowest car.
Một chiếc xe không bao giờ có thể vượt qua một chiếc xe khác ở phía trước nó. Nếu một chiếc xe đuổi kịp, chúng sẽ tạo thành một **đội xe (fleet)** và di chuyển với vận tốc của chiếc xe chậm nhất.

Return the total number of fleets that arrive at the destination.
Trả về tổng số đội xe sẽ đến đích.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting and Arrival Time / Sắp xếp và Thời gian đến
Algorithm:
1. Calculate the time needed for each car to reach the target: `time = (target - position) / speed`.
2. Sort the cars based on their starting positions (descending, closest to target first).
3. Closest car always forms its own fleet (initially).
4. If a car behind has an arrival time `<=` the fleet ahead of it, it will catch up and join the fleet.
5. If a car behind has an arrival time `>` the fleet ahead, it becomes the head of a new fleet.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Rear-to-Front Pursuit
By processing cars from closest to target to farthest, we can establish the arrival bottleneck for each group. Any trailing car that could arrive earlier than the one in front is blocked and merged into the same arrival event.
Bằng cách xử lý các xe từ gần đích nhất đến xa đích nhất, chúng ta có thể thiết lập "nút thắt cổ chai" về thời gian đến cho từng nhóm. Bất kỳ chiếc xe nào đi sau có khả năng đến sớm hơn xe phía trước sẽ bị chặn lại và hợp nhất vào cùng một sự kiện đến đích.

---

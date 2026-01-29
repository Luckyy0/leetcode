# 1226. The Dining Philosophers / Các Triết gia Ăn tối

## Problem Description / Mô tả bài toán
Five philosophers sit at a round table with bowls of spaghetti. Forks are placed between each pair of adjacent philosophers.
Each philosopher needs two forks to eat: one on the left and one on the right.
Design a thread-safe solution.
Method `wantsToEat(philosopher, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork)`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Deadlock Prevention
Classic concurrency problem.
Approaches:
1. Resource Hierarchy: Always pick lower numbered fork first.
   - For philosopher 4 (last one), left=4, right=0. If he picks 0 (lower) first, then everyone picks smallest first.
   - P0 picks 0, P1 picks 1, P2 picks 2, P3 picks 3, P4 picks 0.
   - Problem: If P0 picks 0 and P4 wants 0, contention.
   - Circular wait is prevented if P4 picks 0 then 4, while others pick i then i+1. Wait, if everyone picks left then right (assuming left is i, right is i+1), P4 picks 4 then 0. This causes deadlock.
   - Hierarchy Rule: Pick `min(left, right)` first, then `max(left, right)`.
   - P0: min(0,1)=0, max(0,1)=1.
   - ...
   - P4: min(4,0)=0, max(4,0)=4.
   - Everyone picks lower ID fork first. Circular wait impossible.
2. Global Lock / Semaphore: Limit eaters to 4 (at least 1 fork free, prevent deadlock). Or strict mutex around picking.

### Complexity / Độ phức tạp
- **Time**: Dependent on scheduling.
- **Space**: O(1) + Locks.

---

## Analysis / Phân tích

### Approach: Resource Hierarchy (Fork Ordering)
To prevent deadlock (circular wait), enforce a strict ordering on resource acquisition. Each philosopher must pick up the fork with the smaller ID first, then the fork with the larger ID. For philosophers 0 to 3, this means picking the left fork then the right fork. For philosopher 4, the forks are 4 (left) and 0 (right), so they must pick fork 0 first, then fork 4. This breaks the symmetry and ensures deadlock freedom. Use 5 semaphores or locks to represent the forks.
Để ngăn chặn bế tắc (chờ vòng tròn), hãy thực thi một trật tự nghiêm ngặt về việc thu thập tài nguyên. Mỗi triết gia phải cầm cái nĩa có ID nhỏ hơn trước, sau đó là cái nĩa có ID lớn hơn. Đối với các triết gia từ 0 đến 3, điều này có nghĩa là cầm cái nĩa bên trái sau đó là cái nĩa bên phải. Đối với triết gia 4, các cái nĩa là 4 (trái) và 0 (phải), vì vậy họ phải cầm cái nĩa 0 trước, sau đó là cái nĩa 4. Điều này phá vỡ sự đối xứng và đảm bảo không có bế tắc. Sử dụng 5 semaphore hoặc khóa để đại diện cho các cái nĩa.

---

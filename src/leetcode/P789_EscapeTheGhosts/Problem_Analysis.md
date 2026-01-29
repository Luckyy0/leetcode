# 789. Escape The Ghosts / Trốn thoát khỏi Bóng ma

## Problem Description / Mô tả bài toán
You are playing a simplified Pacman game. You start at `(0, 0)`. There is a target at `(tx, ty)`. There are several ghosts at `ghosts[i] = [gx, gy]`.
Bạn đang chơi một trò chơi Pacman đơn giản. Bạn bắt đầu tại `(0, 0)`. Có một điểm đến tại `(tx, ty)`. Có một số bóng ma tại `ghosts[i] = [gx, gy]`.

In each step, you and all ghosts move one unit distance (4 directions). If any ghost reaches the target or catches you before/at the target, you lose.
Trong mỗi bước, bạn và tất cả các bóng ma di chuyển một đơn vị khoảng cách (4 hướng). Nếu bất kỳ con ma nào đến được điểm đến hoặc bắt được bạn trước/tại điểm đến, bạn sẽ thua.

Return `true` if you can reach the target successfully.
Trả về `true` nếu bạn có thể tiếp cận điểm đến thành công.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Manhattan Distance / Khoảng cách Manhattan
Crucial observation: If a ghost can intercept you, the best strategy for the ghost is to go directly to the target.
Quan sát quan trọng: Nếu một bóng ma có thể chặn bạn, chiến lược tốt nhất cho nó là đi thẳng đến mục tiêu.

Why? If you can get to the target in `D` steps and a ghost can get to the target in `G` steps where `G <= D`, the ghost can simply reach the target first and wait for you.
Tại sao? Nếu bạn có thể đến được mục tiêu trong `D` bước và một con ma có thể đến đó trong `G` bước với `G <= D`, con ma chỉ cần đến đó trước và đợi bạn.

Algorithm:
1. `yourDist = |tx| + |ty|`.
2. For each ghost:
   - `ghostDist = |gx - tx| + |gy - ty|`.
   - if `ghostDist <= yourDist`, return `false`.
3. Return `true`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is number of ghosts.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Proximity Duel
The game is essentially a race to the finish line. If any opponent is naturally closer to the finish line than you are, they win by default in the optimal scenario.
Trò chơi về cơ bản là một cuộc chạy đua về đích. Nếu bất kỳ đối thủ nào vốn dĩ ở gần đích hơn bạn, họ sẽ thắng theo mặc định trong kịch bản tối ưu.

---

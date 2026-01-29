# 913. Cat and Mouse / Mèo và Chuột

## Problem Description / Mô tả bài toán
A game on a graph. The mouse starts at 1, the cat starts at 2, and the hole is at 0.
Một trò chơi trên đồ thị. Chuột bắt đầu ở 1, mèo bắt đầu ở 2, và hang ở 0.

- The mouse wants to reach 0.
- The cat wants to catch the mouse.
- The cat cannot enter the hole.
- If mouse reaches 0, Mouse wins.
- If cat catches mouse, Cat wins.
- If the game can go on forever, it's a Draw.

Return 1 (Mouse wins), 2 (Cat wins), or 0 (Draw).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Game Theory / Topological Sort on Game States / Lý thuyết Trò chơi / Sắp xếp Tôpô trên Trạng thái Trò chơi
State: `(m, c, turn)` where `turn` is 1 (Mouse) or 2 (Cat).
Trạng thái: `(m, c, turn)` trong đó `turn` là 1 (Chuột) hoặc 2 (Mèo).

Algorithm:
1. Define all terminal states:
   - `(0, c, turn)` -> Mouse wins (Status 1).
   - `(m, m, turn)` where `m != 0` -> Cat wins (Status 2).
2. For all states, count degree (number of possible next moves).
3. Use a Queue to propagate status from terminal states backward (similar to Kahn's algorithm or retro-analysis).
4. If a player can reach a state where they win, they win that state.
5. If all possible next moves for a player lead to them losing, they lose that state.
6. Return status of `(1, 2, 1)`.

### Complexity / Độ phức tạp
- **Time**: O(N^3).
- **Space**: O(N^3).

---

## Analysis / Phân tích

### Approach: Status Propagation (Backward Induction)
Start from the known outcomes (hole reached or mouse caught) and work backward. A state's value is determined by whether the current player can force a win or is forced into a loss. Remaining uncolored states are effectively draws.
Bắt đầu từ các kết quả đã biết (đã vào hang hoặc đã bắt được chuột) và thực hiện ngược lại. Giá trị của một trạng thái được xác định bởi việc người chơi hiện tại có thể ép buộc thắng hay bị buộc phải thua. Các trạng thái còn lại chưa được gán giá trị về cơ bản là hòa.

---

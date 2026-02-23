# Analysis for Design Snake Game
# *Phân tích cho bài toán Thiết kế Trò chơi Rắn săn mồi*

## 1. Problem Essence & Snake Mechanics
## *1. Bản chất vấn đề & Cơ chế của Rắn*

### The Challenge
### *Thách thức*
Simulating the motion of a snake in 2D space. Key aspects:
1.  **Head and Tail:** The snake moves by adding a new head and removing its old tail (unless it eats food).
2.  **Collision Detection:** Boundary check and self-collision check.
3.  **Food Consumption:** Incrementally appearing food that makes the snake grow.

### Strategy: Deque and Set
### *Chiến lược: Deque và Set*
-   **`Deque<Integer>` (Snake Body):** Stores coordinates of the body parts in order. Using a 1D index `row * width + col` simplifies storage.
-   **`HashSet<Integer>` (Body Set):** For $O(1)$ self-collision check.
-   **Food Pointer:** Index of the next food to appear.

### Movement Logic:
### *Logic Di chuyển:*
1.  Calculate new head position based on `direction`.
2.  **Boundary Check:** If out of bounds, return -1.
3.  **Self-Collision (Pre-check):** Temporarily remove the tail from the `set` before checking if the new head hits the body. Why? Because the tail will vacate its spot as the head moves in (unless food is eaten).
4.  **Food Check:**
    - If head matches current food: Do not remove tail (snake grows). Increment food pointer and score.
    - If head does NOT match food: Remove tail from `deque` and `set`.
5.  **Final Collision Check:** If head is still in `set`, return -1.
6.  Add new head to `deque` and `set`. Return `score`.

---

## 2. Approach: Deque + Set (Optimized)
## *2. Hướng tiếp cận: Deque + Set (Tối ưu)*

### Logic
### *Logic*
(See Movement Logic above). Using `Deque` allows $O(1)$ head addition and tail removal. `HashSet` ensures $O(1)$ collision detection.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Efficient Simulation:** Each move is $O(1)$.
    *Mô phỏng hiệu quả: Mỗi nước đi là $O(1)$.*
*   **Coordinate Serialization:** Using `row * width + col` reduces memory overhead and simplifies collection usage.
    *Tuần tự hóa tọa độ: Sử dụng `row * width + col` giảm chi phí bộ nhớ và đơn giản hóa việc sử dụng tập hợp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ per `move()` call.
    *Độ phức tạp thời gian: $O(1)$ cho mỗi lần gọi `move()`.*
*   **Space Complexity:** $O(N + F)$ where N is number of body parts (max $H \times W$) and F is the total number of foods.
    *Độ phức tạp không gian: $O(N + F)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Operation:** Move "R" (Right)
1. Old head: `(0,0)`. New head: `(0,1)`.
2. No food at `(0,1)`.
3. Pop tail `(0,0)`.
4. Add new head `(0,1)`.
Snake is now at `(0,1)`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Deque + HashSet is the most efficient simulation way.
*Deque + HashSet là cách mô phỏng hiệu quả nhất.*
---
*Cuộc sống giống như trò chơi Rắn săn mồi (Snake Game), ta luôn tiến về phía trước để tìm kiếm những mục tiêu mới (food). Nhưng hãy cẩn thận, đừng để quá khứ nặng nề (body) ngăn cản bước tiến hoặc làm ta vấp ngã bởi chính những sai lầm của bản thân.*
Life is like a Snake Game, we always move forward searching for new goals (food). But be careful, don't let a heavy past (body) block your progress or make you trip over your own mistakes.

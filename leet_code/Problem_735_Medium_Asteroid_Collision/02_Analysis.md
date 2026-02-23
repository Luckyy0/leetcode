# Analysis for Asteroid Collision
# *Phân tích cho bài toán Va chạm Thiên thạch*

## 1. Problem Essence & Stack Simulation
## *1. Bản chất vấn đề & Mô phỏng dùng Ngăn xếp*

### The Challenge
### *Thách thức*
We need to simulate a sequence of physical collisions. The key observation is that collisions only happen between a right-moving asteroid (positive) that is to the **left** of a left-moving asteroid (negative). This "first-in, last-out" collision behavior for the right-moving asteroids makes a **Stack** the perfect data structure.
*Chúng ta cần mô phỏng một chuỗi các va chạm vật lý. Quan sát quan trọng là va chạm chỉ xảy ra giữa một thiên thạch đi sang phải (dương) nằm bên **trái** của một thiên thạch đi sang trái (âm). Hành vi va chạm "vào trước, ra trước" này đối với các thiên thạch đi sang phải khiến **Ngăn xếp (Stack)** trở thành cấu trúc dữ liệu hoàn hảo.*

---

## 2. Strategy: Collision Resolution Logic
## *2. Chiến lược: Logic Giải quyết Va chạm*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Right-moving (`a > 0`):** These never collide with existing asteroids in the stack (since the stack only contains those already moving to the left or safe right-movers). Simply push to the stack.
    * **Thiên thạch đi sang phải:** Không bao giờ va chạm với các thiên thạch hiện có trong ngăn xếp. Chỉ cần đưa vào ngăn xếp.*

2.  **Left-moving (`a < 0`):** These might collide with right-moving asteroids at the top of the stack.
    - **While** `stack.top()` is positive:
        - If `top < |a|`: `top` explodes. `pop()` and continue checking the next.
        - If `top == |a|`: Both explode. `pop()` and move to the next asteroid in the input.
        - If `top > |a|`: `a` explodes. Move to the next asteroid in the input.
    - **Final Step:** If `a` survives (the stack becomes empty or the top is now a left-mover), push `a` to the stack.
    * **Thiên thạch đi sang trái:** Có thể va chạm với các thiên thạch ở đỉnh ngăn xếp (nếu chúng đi sang phải). So sánh kích thước: cái nhỏ hơn biến mất; nếu bằng nhau thì cả hai cùng biến mất; nếu cái đi sang trái nhỏ hơn thì nó biến mất luôn.*

3.  **Result Construction:** Convert the stack back to an array.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of asteroids. Each asteroid is pushed and popped at most once.
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ for the stack storage in the worst case (no collisions).
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**asteroids = [5, 10, -5]**
1. 5: `[5]`
2. 10: `[5, 10]`
3. -5: 
   - Top 10 is positive and 10 > 5. 
   - -5 is destroyed.
**Result:** [5, 10]

**asteroids = [8, -8]**
1. 8: `[8]`
2. -8: 
   - Top 8 is positive and 8 == 8. 
   - Both explode. `pop()`.
**Result:** []

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Using a `Stack` (or a `LinkedList` acting as a stack) is the cleanest way to handle sequential collision problems. It ensures that we always resolve the "nearest" potential collision first.
*Sử dụng `Stack` là cách sạch sẽ nhất để xử lý các bài toán va chạm tuần tự. Nó đảm bảo rằng chúng ta luôn giải quyết các va chạm tiềm năng "gần nhất" trước.*
---
*Cuộc đời là một chuỗi hành trình (Asteroids) với những mục tiêu và hướng đi khác nhau. Trên con đường đó, những va chạm (Collisions) là không thể tránh khỏi. Kẻ mạnh hơn sẽ đi tiếp (Greater size), trong khi những sự đối đầu tương đương (Equal size) có thể dẫn đến sự tan vỡ của cả hai. Dữ liệu dạy ta rằng bằng cách duy trì một trật tự thời gian (Stack) và đối mặt với thực tại một cách trực diện (Simulation), ta có thể thấu thị được sự tồn tại cuối cùng giữa những biến động không ngừng.*
Life is a series of journeys (Asteroids) with different goals and directions. On that path, collisions (Collisions) are inevitable. The stronger will move on (Greater size), while equal confrontations (Equal size) can lead to the destruction of both. Data teaches us that by maintaining a chronological order (Stack) and facing reality directly (Simulation), we can see ultimate existence amidst constant fluctuations.

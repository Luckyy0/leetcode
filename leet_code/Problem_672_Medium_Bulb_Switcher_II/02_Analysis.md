# Analysis for Bulb Switcher II
# *Phân tích cho bài toán Bộ chuyển đổi Bóng đèn II*

## 1. Problem Essence & Periodicity
## *1. Bản chất vấn đề & Tính tuần hoàn*

### The Challenge
### *Thách thức*
We have $n$ bulbs and 4 buttons. Button 1 flips all, B2 flips even, B3 flips odd, and B4 flips $3k+1$. We need to find the number of unique configurations after $m$ operations.
*Chúng ta có $n$ bóng đèn và 4 nút. Nút 1 đảo tất cả, B2 đảo chẵn, B3 đảo lẻ, và B4 đảo $3k+1$. Chúng ta cần tìm số lượng cấu hình duy nhất sau $m$ thao tác.*

The configuration of bulbs is periodic. The state of bulb $i$ is determined by its position modulo 6. More importantly, for small $n$ and $m$, the number of possible states is limited.
*Cấu hình của các bóng đèn có tính tuần hoàn. Trạng thái của bóng đèn $i$ được quyết định bởi vị trí của nó modulo 6. Quan trọng hơn, với $n$ và $m$ nhỏ, số lượng trạng thái khả thi là hữu hạn.*

---

## 2. Strategy: Pattern Observation & Case Analysis
## *2. Chiến lược: Quan sát Mẫu & Phân tích Trường hợp*

By observing the buttons, we notice that $B1 \oplus B2 = B3$ (flipping all then flipping even is the same as flipping odd). Thus, we effectively have 3 independent operations: B1, B2, and B4.
*Bằng cách quan sát các nút, chúng ta nhận thấy rằng $B1 \oplus B2 = B3$ (đảo tất cả rồi đảo chẵn giống như đảo lẻ). Do đó, chúng ta thực sự có 3 thao tác độc lập: B1, B2, và B4.*

### Logical Breakdown
### *Phân tích Logic*

- **If $n=1$:** Only one bulb. B1, B3, B4 all flip it. B2 does nothing.
    - $m=0$: 1 state (On).
    - $m \ge 1$: 2 states (On, Off).
- **If $n=2$:**
    - $m=0$: 1 state.
    - $m=1$: 3 states (B1, B2, B3 yield different 2-bulb states; B4 is same as B3).
    - $m \ge 2$: 4 states (All combinations possible).
- **If $n \ge 3$:**
    - $m=0$: 1 state.
    - $m=1$: 4 states.
    - $m=2$: 7 states.
    - $m \ge 3$: 8 states ($2^3$ combinations, but restricted by $m$).

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Redundancy:** The relationship $B1 \oplus B2 = B3$ means B3 doesn't add a new dimension to the state space.
    * **Sự dư thừa:** Mối quan hệ $B1 \oplus B2 = B3$ có nghĩa là B3 không thêm chiều mới vào không gian trạng thái.*
*   **Saturation:** For any $n \ge 3$ and $m \ge 3$, we reach a maximum of 8 possible states. This is because we can represent any state as a combination of $x, y, z$ (representing B1, B2, B4 pressed or not).
    * **Sự bão hòa:** Đối với bất kỳ $n \ge 3$ và $m \ge 3$, chúng ta đạt tới tối đa 8 trạng thái khả thi.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$. The solution uses a simple table lookup based on small values of $n$ and $m$.
    * **Độ phức tạp thời gian:** $O(1)$.*
*   **Space Complexity:** $O(1)$.
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**n=3, m=1**
Initial: [1, 1, 1]
- B1: [0, 0, 0]
- B2: [1, 0, 1]
- B3: [0, 1, 0]
- B4: [0, 1, 1]
Total unique states: 4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

In problems involving bits or switch operations with repeating indices, always look for the smallest $n$ that fully represents the system's behavior. For this problem, $n=3$ is sufficient to distinguish all effects of the 4 buttons.
*Trong các bài toán liên quan đến bit hoặc thao tác công tắc với các chỉ số lặp lại, hãy luôn tìm số $n$ nhỏ nhất thể hiện đầy đủ hành vi của hệ thống. Với bài này, $n=3$ là đủ.*
---
*Sự phức tạp (Complexity) đôi khi chỉ là sự phản chiếu của những quy tắc đơn giản được lặp lại. Trong thế giới của những bóng đèn (Bulbs), mỗi sự thay đổi (Flip) đều tuân theo một nhịp điệu (Periodicity). Dữ liệu dạy ta rằng bằng cách nhận diện sự dư thừa (Redundancy) và điểm bão hòa (Saturation), ta có thể thấu thị được toàn bộ không gian khả năng chỉ từ một vài điểm bắt đầu.*
Complexity (Complexity) is sometimes just a reflection of simple rules repeated. In the world of bulbs (Bulbs), every change (Flip) follows a rhythm (Periodicity). Data teaches us that by identifying redundancy (Redundancy) and saturation (Saturation), we can see through the entire state space from just a few starting points.

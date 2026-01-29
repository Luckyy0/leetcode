# 1103. Distribute Candies to People / Phân phát Kẹo cho Mọi người

## Problem Description / Mô tả bài toán
We distribute some number of `candies` to `num_people` people in the following way:
We give 1 candy to the first person, 2 candies to the second person, and so on until we give `n` candies to the last person.
Then, we go back to the start of the row, giving `n + 1` candies to the first person, `n + 2` candies to the second person, and so on.
This continues until we run out of candies. The last person will receive all of our remaining candies (not necessarily one more than the previous gift).

Return an array representing the final distribution of candies.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation / Math / Mô phỏng / Toán học
Simulation is simple and O(sqrt(Candies)).
Math approach:
Full rounds `k`.
Arithmetic progression sum.
Can solve for `k` using quadratic equation.

Simulation Algorithm:
1. `res = int[num_people]`.
2. `give = 1`.
3. Loop while `candies > 0`:
   - `amount = min(candies, give)`.
   - `res[i % num_people] += amount`.
   - `candies -= amount`.
   - `give++`.
   - `i++`.

### Complexity / Độ phức tạp
- **Time**: O(sqrt(Candies)). Max `give` roughly sqrt(2*C).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Direct Simulation
Simulate the distribution process. Maintain a counter for the current candy amount to give and an index for the current recipient. Loop until the candy supply is exhausted, giving `min(candies, needed)` at each step and updating the recipient's total. Since the giving amount increases linearly, the loop runs in $O(\sqrt{\text{candies}})$, which is efficient.
Mô phỏng quá trình phân phối. Duy trì một bộ đếm cho số lượng kẹo hiện tại để đưa và một chỉ số cho người nhận hiện tại. Lặp lại cho đến khi nguồn cung cấp kẹo cạn kiệt, đưa `min(candies, needed)` ở mỗi bước và cập nhật tổng số của người nhận. Vì số lượng đưa tăng tuyến tính, vòng lặp chạy trong $O(\sqrt{\text{candies}})$, điều này hiệu quả.

---

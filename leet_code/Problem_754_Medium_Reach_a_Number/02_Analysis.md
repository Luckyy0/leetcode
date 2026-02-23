# Analysis for Reach a Number
# *Phân tích cho bài toán Đạt tới một Số*

## 1. Problem Essence & Parity Check
## *1. Bản chất vấn đề & Kiểm tra Chẵn lẻ*

### The Challenge
### *Thách thức*
We take steps $1, 2, 3, \dots, k$. The maximum reach is $S = \sum_{i=1}^k i = \frac{k(k+1)}{2}$.
If we choose to go left at step $x$ instead of right, the final sum decreases by $2x$ (from $+x$ to $-x$).
Thus, the final position will be $S - 2 \times (\text{sum of flipped steps})$.
This implies two conditions for reaching `target` (take absolute value since symmetric):
1. $S \ge \text{target}$.
2. $S - \text{target}$ must be **even** (divisible by 2).
*Chúng ta thực hiện các bước $1, 2, \dots, k$. Tổng tối đa đạt được là $S$. Nếu đi sang trái ở bước $x$, tổng giảm đi $2x$. Do đó, vị trí cuối cùng là $S - 2 \times (\text{tổng các bước đảo dấu})$. Điều này dẫn đến hai điều kiện: $S \ge \text{target}$ và độ lệch $S - \text{target}$ phải **chẵn**.*

---

## 2. Strategy: Mathematical Simulation
## *2. Chiến lược: Mô phỏng Toán học*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Normalization:** Work with `target = abs(target)`.
    *   **Chuẩn hóa:** Làm việc với giá trị tuyệt đối của `target`.*

2.  **Find Minimum k:** Increment $k$ until sum $S = \frac{k(k+1)}{2} \ge \text{target}$.
    *   **Tìm k tối thiểu:** Tăng $k$ cho đến khi tổng $S$ lớn hơn hoặc bằng `target`.*

3.  **Check Parity:**
    - Calculate `delta = S - target`.
    - If `delta` is even, we are done! We can just flip some step $x = \text{delta}/2$ to match exactly.
    - If `delta` is odd, we must continue adding steps:
        - Add next step $k+1$. New `delta`.
        - If still odd, add next step $k+2$.
        - One of these will make `delta` even guaranteed.
    *   **Kiểm tra tính chẵn lẻ:** Tính độ lệch. Nếu chẵn, xong. Nếu lẻ, thêm bước tiếp theo cho đến khi độ lệch chẵn.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\sqrt{\text{target}})$. The sum grows quadratically, so $k$ grows with square root.
    *   **Độ phức tạp thời gian:** $O(\sqrt{\text{target}})$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Target = 2**
1. k=1, S=1. (1 < 2). Continue.
2. k=2, S=3. (3 >= 2).
   - Delta = 3 - 2 = 1 (Odd).
   - Add step 3. S = 3 + 3 = 6.
   - Delta = 6 - 2 = 4 (Even).
   - Return k=3.
   - Check: 1 + 2 = 3. Flip something? We need sum 2. 1+2-3? No wait. We need S - 2*X = target. 6 - 2*X = 2 => 2*X = 4 => X = 2. Flip step 2? Actually logic is: Steps 1, 2, 3. Flip 2? 1 - 2 + 3 = 2. Yes! Steps: +1, -2, +3.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Simple mathematical loop is faster and cleaner than BFS.
*Vòng lặp toán học đơn giản nhanh hơn và gọn gàng hơn BFS.*
---
*Đôi khi để đến đích (Reach target), ta phải đi quá đà (Overshoot) rồi mới tìm cách cân bằng lại (Adjust parity). Tập hợp các bước đi tự nhiên là một chuỗi tổng hòa (Summation), và quyền năng thay đổi dấu (Flipping signs) cho phép ta điều chỉnh kết quả theo từng nấc chẵn (Even increments). Dữ liệu dạy ta rằng nếu chưa khớp, hãy kiên nhẫn bước thêm (Next step); sự trùng khớp sẽ đến khi tính chẵn lẻ đồng điệu.*
Sometimes to reach the destination (Reach target), we must overshoot (Overshoot) and then find a way to rebalance (Adjust parity). The set of natural steps is a harmonious series (Summation), and the power to change signs (Flipping signs) allows us to adjust the result by even increments (Even increments). Data teaches us that if it doesn't fit yet, patiently take another step (Next step); coincidence will come when parity aligns.

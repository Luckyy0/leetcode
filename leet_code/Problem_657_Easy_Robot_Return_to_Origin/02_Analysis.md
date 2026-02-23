# Analysis for Robot Return to Origin
# *Phân tích cho bài toán Robot Quay về Vị trí Ban đầu*

## 1. Problem Essence & Displacement Equilibrium
## *1. Bản chất vấn đề & Sự cân bằng Độ dịch chuyển*

### The Challenge
### *Thách thức*
We need to determine if a sequence of 2D movements results in a net displacement of zero. Each move is a unit vector in one of the four cardinal directions.
*Chúng ta cần xác định xem một chuỗi các chuyển động 2D có mang lại độ dịch chuyển ròng bằng không hay không. Mỗi bước đi là một véc-tơ đơn vị theo một trong bốn hướng chính.*

---

## 2. Strategy: Coordinate Tracking or Frequency Counting
## *2. Chiến lược: Theo dõi Tọa độ hoặc Đếm Tần suất*

Since each direction has a direct opposite, the robot returns to the origin if and only if the total vertical movement and total horizontal movement are both zero.
*Vì mỗi hướng đều có một hướng đối diện trực tiếp, robot quay trở lại điểm gốc khi và chỉ khi tổng chuyển động theo chiều dọc và tổng chuyển động theo chiều ngang đều bằng không.*

### Logical Nuance
### *Sắc thái Logic*
- **Vertical Equilibrium:** Count of 'U' must equal Count of 'D'.
- **Horizontal Equilibrium:** Count of 'L' must equal Count of 'R'.

### Step-by-Step Logic
### *Logic từng bước*

1.  **Initialize:** `x = 0`, `y = 0`.
    * **Khởi tạo:** `x = 0`, `y = 0`.*
2.  **Process Moves:** Iterate through each character in the `moves` string:
    * **Xử lý Chuyển động:** Duyệt qua từng ký tự trong chuỗi `moves`:*
    - If 'U': `y++`.
    - If 'D': `y--`.
    - If 'L': `x--`.
    - If 'R': `x++`.
3.  **Check Result:** Return `x == 0 && y == 0`.
    * **Kiểm tra Kết quả:** Trả về `x == 0 && y == 0`.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Linear Scan:** The problem is solved in a single pass $O(N)$.
    * **Quét tuyến tính:** Bài toán được giải trong một lần quét.*
*   **Constant Space:** No extra storage is needed regardless of the number of moves.
    * **Không gian không đổi:** Không cần lưu trữ thêm bất kể số lượng chuyển động.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the string.
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** "UDLR"
1. Start: (0,0).
2. 'U': (0,1).
3. 'D': (0,0).
4. 'L': (-1,0).
5. 'R': (0,0).
**Result:** true.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For 2D movement problems, the coordinate approach is almost always the best. It transforms a sequence of commands into a simple algebraic sum, making the final check trivial.
*Đối với các bài toán chuyển động 2D, cách tiếp cận theo tọa độ hầu như luôn là tốt nhất. Nó chuyển đổi một chuỗi các lệnh thành một tổng đại số đơn giản.*
---
*Sự quay về (Return) là sự triệt tiêu của các hành động đối nghịch. Trong không gian của những sự lựa chọn (Moves), mỗi bước đi tiến lên (U) được cân bằng bởi một bước lùi lại (D). Dữ liệu dạy ta rằng chỉ khi mọi nỗ lực theo mọi hướng (x, y) đều tìm thấy sự đối trọng hoàn hảo, ta mới có thể tìm lại được nơi mình đã bắt đầu (Origin).*
Returning (Return) is the cancellation of opposing actions. In the space of choices (Moves), each step forward (U) is balanced by a step back (D). Data teaches us that only when every effort in every direction (x, y) find perfect counterweights, can we find our way back to where we started (Origin).

# Analysis for Linked List Cycle II
# *Phân tích cho bài toán Chu trình trong Danh sách liên kết II*

## 1. Problem Understanding & Mathematical Logic
## *1. Hiểu vấn đề & Logic toán học*

### Beyond Detection
### *Hơn cả việc phát hiện*
*   While Part I (141) only asked if a cycle exists, Part II requires us to find the **exact entry point** of that cycle.
    *Trong khi Phần I (141) chỉ hỏi liệu chu trình có tồn tại hay không, Phần II yêu cầu chúng ta tìm **điểm bắt đầu chính xác** của chu trình đó.*
*   The constraint remains: **O(N) time** and **O(1) space**. This immediately disqualifies using a `HashSet` to store nodes. We must again rely on Floyd's Tortoise and Hare algorithm, but with a mathematical twist.
    *Ràng buộc vẫn là: **thời gian O(N)** và **không gian O(1)**. Điều này ngay lập tức loại bỏ việc sử dụng `HashSet` để lưu trữ các nút. Chúng ta phải một lần nữa dựa vào thuật toán Rùa và Thỏ của Floyd, nhưng với một biến thể toán học.*

### The Mathematical Derivation
### *Dẫn giải toán học*
Let's define the distances:
- $L_1$: Distance from the head to the cycle entry point.
- $L_2$: Distance from the entry point to the meeting point of `slow` and `fast`.
- $C$: The length of the cycle.
- $n$: The number of full laps `fast` made in the cycle before meeting `slow`.

When `slow` and `fast` meet:
- Distance traveled by `slow` = $L_1 + L_2$.
- Distance traveled by `fast` = $L_1 + L_2 + n \cdot C$.

Since `fast` travels twice as fast as `slow`:
$2 \cdot (L_1 + L_2) = L_1 + L_2 + n \cdot C$
$\Rightarrow L_1 + L_2 = n \cdot C$
$\Rightarrow L_1 = n \cdot C - L_2$
$\Rightarrow L_1 = (n - 1) \cdot C + (C - L_2)$

**Key Insight:** $(C - L_2)$ is the distance from the meeting point back to the entry point. This formula tells us that the distance from the **head to the entry point** ($L_1$) is exactly the same as the distance from the **meeting point to the entry point** (plus some full laps of the cycle).
*Điểm mấu chốt: $(C - L_2)$ là khoảng cách từ điểm gặp nhau quay ngược lại điểm bắt đầu. Công thức này cho chúng ta biết rằng khoảng cách từ **đầu đến điểm vào** ($L_1$) hoàn toàn bằng khoảng cách từ **điểm gặp nhau đến điểm vào** (cộng thêm một số vòng quay đầy đủ của chu trình).*

---

## 2. Approach: Two-Phase Algorithm
## *2. Hướng tiếp cận: Thuật toán Hai giai đoạn*

### Phase 1: Detect Cycle
### *Giai đoạn 1: Phát hiện chu trình*
1.  Run the standard Floyd algorithm with `slow` and `fast` pointers.
2.  If they meet at some point `M`, a cycle exists. If `fast` reaches `null`, return `null`.

### Phase 2: Find Entry Point
### *Giai đoạn 2: Tìm điểm bắt đầu*
1.  Once they meet at `M`, keep `slow` at point `M` and reset `fast` to the `head` (or vice versa).
    *Một khi chúng gặp nhau tại `M`, hãy giữ `slow` tại điểm `M` và đặt lại `fast` về `head` (hoặc ngược lại).*
2.  Move both pointers at the **same speed** (one step at a time).
    *Di chuyển cả hai con trỏ với **cùng tốc độ** (mỗi lần một bước).*
3.  The point where they meet again is the **entry point** of the cycle.
    *Điểm mà chúng gặp lại nhau chính là **điểm bắt đầu** của chu trình.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **No Extra Memory:** Using only pointer manipulations ensures memory efficiency.
    *Không tốn thêm bộ nhớ: Chỉ sử dụng các thao tác con trỏ đảm bảo hiệu quả bộ nhớ.*
*   **Provable Correctness:** The solution isn't based on heuristics but on a rigorous mathematical relationship between speeds and distances.
    *Khả năng chứng minh tính đúng đắn: Giải pháp không dựa trên các suy nghiệm mà dựa trên mối liên hệ toán học chặt chẽ giữa tốc độ và khoảng cách.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. 
    -   Phase 1: $O(N)$.
    -   Phase 2: $O(N)$ (at most $N$ steps to reach the entry point).
    *Độ phức tạp thời gian: $O(N)$. Giai đoạn 1: $O(N)$. Giai đoạn 2: $O(N)$ (tối đa $N$ bước để đạt đến điểm vào).*
*   **Space Complexity:** $O(1)$. No additional data structures are used.
    *Độ phức tạp không gian: $O(1)$. Không sử dụng cấu trúc dữ liệu bổ sung.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `3 -> 2 -> 0 -> -4 (to 2)`
- $L_1 = 1$ (distance to '2').
- $L_2 = 2$ (assume they meet at '-4').
- $C = 3$ (cycle length '2-0--4').
- Formula Check: $L_1 + L_2 = 1 + 2 = 3$, which is $1 \cdot C$. Valid!
- Resetting `fast` to `head` (3).
- `fast` (at 3) moves 1 step -> `fast` at 2.
- `slow` (at -4) moves 1 step -> `slow` at 2.
- **They meet at 2!**

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This problem is a quintessential follow-up to "Linked List Cycle I". It explicitly tests if you understand the underlying mathematics of the two-pointer approach, rather than just memorizing the code. Knowing the proof $L_1 = (n-1)C + (C - L2)$ is often what separates an average candidate from a top-tier one in interviews.
*Bài toán này là một phần tiếp theo điển hình của "Linked List Cycle I". Nó kiểm tra rõ ràng liệu bạn có hiểu toán học cơ bản của phương pháp hai con trỏ hay không, thay vì chỉ ghi nhớ mã. Việc nắm vững phép chứng minh $L_1 = (n-1)C + (C - L2)$ thường là điều phân biệt một ứng viên trung bình với một ứng viên hàng đầu trong các cuộc phỏng vấn.*
---
*Điểm bắt đầu của một vòng lặp thường ẩn giấu trong sự cân bằng hoàn hảo của những bước chân xa lạ.*
The starting point of a loop is often hidden in the perfect balance of unfamiliar footsteps.

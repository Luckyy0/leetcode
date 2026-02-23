# Analysis for Linked List Random Node
# *Phân tích cho bài toán Nút Ngẫu nhiên trong Danh sách Liên kết*

## 1. Problem Essence & Reservoir Sampling
## *1. Bản chất vấn đề & Lấy mẫu Hồ chứa (Reservoir Sampling)*

### The Challenge
### *Thách thức*
Picking a random element from a stream of data (a linked list) where you don't know the total count beforehand, using $O(1)$ extra space.

### Strategy: Reservoir Sampling
### *Chiến lược: Lấy mẫu Hồ chứa*
1.  Initialize `res` with the value of the first node.
2.  Traverse the list starting from the second node (index $i=2$).
3.  For each node at position $i$, generate a random number $r$ between $0$ and $i-1$.
4.  If $r == 0$ (which happens with probability $1/i$), update `res` to the current node's value.
5.  Continue until the end of the list.

### Math Proof:
### *Chứng minh Toán học:*
The probability that the $k$-th node is selected is $1/k$.
The probability that it stays is ensured by not being replaced by any subsequent node $j > k$.
Probability = $\frac{1}{k} \times \frac{k}{k+1} \times \frac{k+1}{k+2} \dots \times \frac{n-1}{n} = \frac{1}{n}$.

---

## 2. Approach: Single Pass Sampling
## *2. Hướng tiếp cận: Lấy mẫu Một lần duyệt*

### Logic
### *Logic*
(See above). This algorithm is robust even for infinite streams where we can't store previous data.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Space:** No need to convert the list to an array or store extra data.
    *Không gian O(1): Không cần chuyển danh sách sang mảng hay lưu trữ dữ liệu phụ.*
*   **Uniformity:** Every node has exactly $1/N$ probability of being returned.
    *Tính đồng nhất: Mỗi nút đều có chính xác 1/N xác suất được trả về.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ per `getRandom` call.
    *Độ phức tạp thời gian: $O(N)$ mỗi lần gọi.*
*   **Space Complexity:** $O(1)$ (excluding the list itself).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**List:** `1 -> 2 -> 3`
1. `i = 1`: `res = 1`.
2. `i = 2`: Random number $[0, 1]$. If 0 (prob 1/2), `res = 2`.
3. `i = 3`: Random number $[0, 2]$. If 0 (prob 1/3), `res = 3`.
The chance for `1` to win: $1/1 \times 1/2 \times 2/3 = 1/3$.
The chance for `2` to win: $1/2 \times 2/3 = 1/3$.
The chance for `3` to win: $1/3$.
Result: All 1/3. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Reservoir Sampling for unknown stream size.
*Lấy mẫu Hồ chứa cho luồng dữ liệu không biết trước kích thước.*
---
*Trong một dòng chảy liên tục của cuộc đời (unknown stream), đôi khi ta không thể nhìn thấy toàn bộ bức tranh ngay lập tức. Bằng cách luôn mở lòng đón nhận những cơ hội mới với một xác suất công bằng (Reservoir Sampling), ta đảm bảo rằng mọi khoảnh khắc đều có giá trị và cơ hội như nhau để trở thành tâm điểm của hiện tại.*
In the continuous flow of life (unknown stream), sometimes we can't see the whole picture immediately. By always being open to new opportunities with a fair probability (Reservoir Sampling), we ensure that every moment has the same value and opportunity to become the focus of the present.

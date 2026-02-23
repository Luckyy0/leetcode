# Analysis for Implement Queue using Stacks
# *Phân tích cho bài toán Triển khai Hàng đợi bằng Ngăn xếp*

## 1. Problem Essence & Stack properties
## *1. Bản chất vấn đề & Tính chất Ngăn xếp*

### Stack vs Queue
### *Ngăn xếp vs Hàng đợi*
- **Stack:** LIFO.
- **Queue:** FIFO.
To invert the order (LIFO -> FIFO), we need two inversions. Reversing a list twice yields the original order.
*Để đảo ngược thứ tự (LIFO -> FIFO), cần hai lần đảo ngược. Đảo ngược danh sách hai lần sẽ trả về thứ tự ban đầu.*

---

## 2. Approach: Two Stacks (Amortized O(1))
## *2. Hướng tiếp cận: Hai ngăn xếp (Khấu hao O(1))*

### Storage
### *Lưu trữ*
1.  **Input Stack (`s1`)**: Handles `push`.
2.  **Output Stack (`s2`)**: Handles `pop` and `peek`.

### Logic
### *Logic*
- **Push(x):** Always push to `s1`. $O(1)$.
- **Pop():**
    - If `s2` is empty, move all elements from `s1` to `s2`. This reverses the order, so the bottom of `s1` (oldest) becomes the top of `s2`.
    - Pop from `s2`.
- **Peek():** Same as Pop (move if empty), then peek `s2`.

### Amortized Analysis
### *Phân tích khấu hao*
Each element is:
1.  Pushed to `s1`.
2.  Popped from `s1`.
3.  Pushed to `s2`.
4.  Popped from `s2`.
Total operations per element: 4.
So average cost is $O(1)$.
*Mỗi phần tử được di chuyển tối đa 4 lần. Chi phí trung bình O(1).*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Lazy Migration:** We only move elements when we strictly need to read an output. This minimizes unnecessary shuffling.
    *Di chuyển lười: Chỉ di chuyển khi cần đọc đầu ra. Giảm thiểu xáo trộn không cần thiết.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:**
    - Push: $O(1)$.
    - Pop: Amortized $O(1)$. Worst case $O(N)$ (when `s2` empty).
    - Empty: $O(1)$.
*   **Space Complexity:** $O(N)$.

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Push 1, 2, 3**:
`s1 = [1, 2, 3]`, `s2 = []`.

**Pop**:
`s2` is empty. Move `s1` to `s2`.
Pop 3 from s1 -> push to s2.
Pop 2 from s1 -> push to s2.
Pop 1 from s1 -> push to s2.
`s1 = []`, `s2 = [3, 2, 1]`.
Pop from `s2`: Returns 1. `s2 = [3, 2]`.

**Push 4**:
`s1 = [4]`, `s2 = [3, 2]`.

**Pop**:
`s2` not empty. Pop from `s2`: Returns 2. `s2 = [3]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard "Queue from Stacks" implementation. Remember the "Amortized" part is because the expensive moving operation only happens occasionally.
*Triển khai tiêu chuẩn. Nhớ rằng "Khấu hao" có nghĩa là thao tác đắt đỏ chỉ xảy ra thỉnh thoảng.*
---
*Hai lần phủ định làm nên một khẳng định. Hai ngăn xếp làm nên một hàng đợi.*
Two negatives make a positive. Two stacks make a queue.

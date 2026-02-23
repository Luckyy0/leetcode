# Analysis for Escape The Ghosts
# *Phân tích cho bài toán Trốn thoát khỏi Bóng ma*

## 1. Problem Essence & Manhattan Distance
## *1. Bản chất vấn đề & Khoảng cách Manhattan*

### The Challenge
### *Thách thức*
Can any ghost reach the target faster than or equal to the time you take?
The ghosts are optimal and know your moves. The best strategy for a ghost is to intercept you at the target. Why?
Because if a ghost can intercept you *before* the target, it can certainly reach the target *before or at the same time* as you.
The critical point is the Target itself.
*Liệu có bóng ma nào đến đích nhanh hơn hoặc bằng thời gian bạn đi không? Chiến lược tốt nhất của ma là chặn bạn tại Đích. Nếu ma có thể chặn bạn *trước* đích, nó chắc chắn có thể đến Đích *trước hoặc cùng lúc* với bạn. Điểm mấu chốt là Đích.*

So, if `Distance(Ghost, Target) <= Distance(You, Target)`, the ghost catches you (or arrives same time). You lose.
*Vì vậy, nếu `Khoảng cách(Ma, Đích) <= Khoảng cách(Bạn, Đích)`, ma bắt được bạn. Bạn thua.*

---

## 2. Strategy: Distance Comparison
## *2. Chiến lược: So sánh Khoảng cách*

### Algorithm
### *Thuật toán*

1.  **Your Distance:** Calculate Manhattan distance from `(0,0)` to `target`.
    `myDist = abs(target[0]) + abs(target[1])`.
    *   **Khoảng cách của bạn:** Tính khoảng cách Manhattan từ `(0,0)` đến `target`.*

2.  **Ghost Distances:** For each ghost, calculate distance to `target`.
    `ghostDist = abs(ghost[0] - target[0]) + abs(ghost[1] - target[1])`.
    *   **Khoảng cách của ma:** Tính khoảng cách của từng ma đến `target`.*

3.  **Check:** If any `ghostDist <= myDist`, return `false`. If loop finishes, return `true`.
    *   **Kiểm tra:** Nếu bất kỳ ma nào gần hơn hoặc bằng, trả về `false`.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public boolean escapeGhosts(int[][] ghosts, int[] target) {
    int myDist = Math.abs(target[0]) + Math.abs(target[1]);
    for (int[] ghost : ghosts) {
        int ghostDist = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
        if (ghostDist <= myDist) return false;
    }
    return true;
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ where N is number of ghosts.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Target:** `[0,1]`. My Start: `[0,0]`. My Dist: 1.
**Ghost 1:** `[1,0]`. Ghost Dist to `[0,1]`: `abs(1-0) + abs(0-1) = 2`. $2 > 1$. Safe.
**Ghost 2:** `[0,3]`. Ghost Dist to `[0,1]`: `abs(0-0) + abs(3-1) = 2`. $2 > 1$. Safe.
All safe. Return True.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Simple Manhattan distance comparison suffices because on a grid, the shortest path is Manhattan distance.
*So sánh khoảng cách Manhattan đơn giản là đủ vì trên lưới, đường đi ngắn nhất là khoảng cách Manhattan.*

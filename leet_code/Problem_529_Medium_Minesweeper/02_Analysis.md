# Analysis for Minesweeper
# *Phân tích cho bài toán Dò mìn*

## 1. Problem Essence & BFS/DFS Expansion
## *1. Bản chất vấn đề & Mở rộng BFS/DFS*

### The Challenge
### *Thách thức*
Simulating the Minesweeper click logic.
- Main complexity is the recursive reveal of blank 'B' squares (Flood Fill).
- Adjacent means 8 directions.

### Strategy: DFS/BFS
### *Chiến lược: DFS/BFS*

1.  **Click Handling:**
    - If `M`: Game Over -> `X`.
    - If `E`: Start expansion.
2.  **Expansion (`E` -> `B` or Digit):**
    - Count adjacent mines (check 8 neighbors).
    - If count > 0: Set cell to char(count). Stop here.
    - If count == 0: Set cell to 'B'. Recursively process all 8 'E' neighbors.

---

## 2. Approach: DFS
## *2. Hướng tiếp cận: DFS*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Grid Graph:** Standard grid traversal.
    *Đồ thị lưới: Duyệt lưới chuẩn.*
*   **State Machine:** Explicit transitions M->X, E->B/Digit.
    *Máy trạng thái: Chuyển đổi rõ ràng M->X, E->B/Digit.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \cdot N)$. Each cell processed once.
    *Độ phức tạp thời gian: $O(M \cdot N)$.*
*   **Space Complexity:** $O(M \cdot N)$ for recursion.
    *Độ phức tạp không gian: $O(M \cdot N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** Click empty area.
1. Check neighbors. No mines. Set 'B'.
2. Recurse neighbors.
3. Neighbor has mine? Set '1'. Stop.
4. Neighbor no mine? Set 'B'. Recurse.
Wave propagates until it hits mine boundaries (digits).

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

DFS Flood fill with adjacency counting.
*DFS Flood fill với việc đếm lân cận.*
---
*Dò mìn (Minesweeper) là trò chơi của logic và sự cẩn trọng. Một khoảng trống an toàn (Blank) sẽ mở ra (reveal) những cơ hội mới, nhưng một con số cảnh báo (Digit) là dấu hiệu để dừng lại và suy tính. Khi chưa biết rõ tương lai (Unrevealed), hãy luôn bước đi với sự tính toán kỹ lưỡng.*
Minesweeper is a game of logic and caution. A safe blank (Blank) will open (Reveal) new opportunities, but a warning number (Digit) is a sign to stop and calculate. When the future is unknown (Unrevealed), always walk with careful calculation.

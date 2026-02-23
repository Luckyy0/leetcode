# Analysis for IPO
# *Phân tích cho bài toán IPO*

## 1. Problem Essence & Greedy Selection
## *1. Bản chất vấn đề & Lựa chọn Tham lam*

### The Challenge
### *Thách thức*
Maximizing capital by picking up to `k` projects.
- Constraint: Can only pick project if `current_capital >= required_capital`.
- Goal: Maximize profit at each step (since profit adds to capital, increasing ability to pick expensive projects). This is a greedy problem.

### Strategy: Two Heaps (Min-Heap + Max-Heap)
### *Chiến lược: Hai Hàng đợi Ưu tiên (Min-Heap + Max-Heap)*

1.  **Structure:**
    - Pair projects as `(capital, profit)`.
    - `projects`: Sort by capital (or use Min-Heap by capital).
    - `available`: Max-Heap storing `profits` of all projects that we can *currently afford*.
2.  **Simulation:**
    - Loop `k` times.
    - Move all projects from `projects` list (where `cap <= currentW`) into `available` Max-Heap.
    - If `available` is empty, we can't do any more projects. Break.
    - Pick top project from `available` (max profit).
    - Add profit to `currentW`.
3.  **Efficiency:**
    - Since we only add each project to heap once and remove once, complexity is dominated by heap operations.

---

## 2. Approach: Sorting + PriorityQueue
## *2. Hướng tiếp cận: Sắp xếp + PriorityQueue*

### Logic
### *Logic*
(See above).
- Sort projects by capital ascending. Use a pointer `idx` to track how many we've added to the heap.
- `PriorityQueue<Integer>` for profits (reverse order).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Decoupling:** Separation of "eligibility" (Capital) and "desirability" (Profit).
    *Tách biệt: Tách biệt "điều kiện" (Vốn) và "mong muốn" (Lợi nhuận).*
*   **Lazy Update:** Only update the set of available projects when our capital increases.
    *Cập nhật lười: Chỉ cập nhật tập hợp các dự án khả dụng khi vốn của chúng ta tăng lên.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N + K \log N)$. Sorting takes $N \log N$. Heap ops take $\log N$ per project.
    *Độ phức tạp thời gian: $O(N \log N + K \log N)$.*
*   **Space Complexity:** $O(N)$ to store projects.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `w=0, k=2`, Proj `[(0,1), (1,2), (1,3)]`. Sorted by Cap.
1. `w=0`. Add eligible (`cap <= 0`).
   - Add `(0, 1)` to PQ. PQ: `[1]`.
2. Step 1: Pop `1`. `w` becomes `0+1=1`.
3. `w=1`. Add eligible (`cap <= 1`).
   - Add `(1, 2)` and `(1, 3)`. PQ: `[3, 2]`.
4. Step 2: Pop `3`. `w` becomes `1+3=4`.
Result: 4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Sort by Capital, use Max-Heap for Profits.
*Sắp xếp theo Vốn, sử dụng Max-Heap cho Lợi nhuận.*
---
*Đầu tư (IPO) là nghệ thuật nắm bắt thời cơ. Ta không thể với tới những vì sao (high capital projects) nếu không có bệ phóng vững chắc (current capital). Hãy bắt đầu từ những gì trong tầm tay (available projects) để tích lũy nguồn lực, và luôn chọn những cơ hội mang lại giá trị lớn nhất (max profit) để mở rộng đường chân trời của chính mình.*
Investment (IPO) is the art of seizing the opportunity. We cannot reach the stars (High Capital Projects) without a solid launch pad (Current Capital). Start with what is available (available projects) to accumulate resources, and always choose opportunities that bring the greatest value (MAX Profit) to expand your own horizon.

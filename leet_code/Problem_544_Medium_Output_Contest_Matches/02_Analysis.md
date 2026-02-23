# Analysis for Output Contest Matches
# *Phân tích cho bài toán Xuất Kết quả Trận đấu*

## 1. Problem Essence & Recursive Folding
## *1. Bản chất vấn đề & Gấp nếp Đệ quy*

### The Challenge
### *Thách thức*
Generating a tournament bracket string.
- Input `N` is power of 2.
- Pairing logic: `(First, Last)`, `(Second, SecondLast)`, etc.
- This process repeats $\log_2 N$ times until 1 match remains.

### Strategy: Simulation with Array/List
### *Chiến lược: Mô phỏng với Mảng/Danh sách*

1.  **Init:** Start with list of strings `["1", "2", ..., "n"]`.
2.  **Loop:** While `n > 1`:
    - New list size `n / 2`.
    - For `i` from 0 to `n/2 - 1`:
    - Combine `list[i]` and `list[n - 1 - i]` into `(list[i],list[n - 1 - i])`.
    - Update `n = n / 2`.
3.  **Result:** The single remaining element.

---

## 2. Approach: Iterative Folding
## *2. Hướng tiếp cận: Gấp nếp Lặp*

### Logic
### *Logic*
See Strategy. We can modify array in-place to save space allocation. `arr[i] = "(" + arr[i] + "," + arr[n-1-i] + ")"`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Logarithmic Steps:** $\log N$ rounds.
    *Các bước Logarithmic: $\log N$ vòng.*
*   **Space Efficient:** In-place modification reduces overhead.
    *Hiệu quả không gian: Sửa đổi tại chỗ giảm chi phí.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. In iteration 1: N/2 ops. Iteration 2: N/4. Sum = N. String concatenation adds length factor -> $O(N \log N)$ or just $O(N)$ total string length is $O(N)$. Wait, output string length is proportional to N. So time is $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ for string array.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `n=4`
Start: `["1", "2", "3", "4"]`.
Round 1:
- `i=0`: `(1,4)`.
- `i=1`: `(2,3)`.
- List: `["(1,4)", "(2,3)"]`. `n=2`.
Round 2:
- `i=0`: `((1,4),(2,3))`.
- List: `["((1,4),(2,3))"]`. `n=1`.
Result: `((1,4),(2,3))`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Iteratively pair elements `i` and `n-1-i`.
*Gấp nếp lặp lại các phần tử `i` và `n-1-i`.*
---
*Cuộc thi đấu (Contest) là quá trình thu gọn dần những đối thủ (Folding). Kẻ mạnh (1) và kẻ yếu (n) gặp nhau để tạo nên sự cân bằng, rồi từ sự cân bằng ấy, những người chiến thắng lại tiếp tục hành trình hướng tới đỉnh cao duy nhất.*
The contest is a process of gradually folding opponents. The strong (1) and the weak (N) meet to create balance, then from that balance, the winners continue the journey towards the only peak.

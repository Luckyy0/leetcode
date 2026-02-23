# Analysis for Super Washing Machines
# *Phân tích cho bài toán Máy giặt Siêu cấp*

## 1. Problem Essence & Load Balancing
## *1. Bản chất vấn đề & Cân bằng Tải*

### The Challenge
### *Thách thức*
Redistributing items to achieve uniform average.
- Constraints: Move 1 item to 1 neighbor. multiple machines can move simultaneously.
- Condition for solution: Total sum must be divisible by N.

### Strategy: Running Balance / Prefix Sum
### *Chiến lược: Cân bằng Chạy / Tổng Tiền tố*

1.  **Average Check:** `target = sum / N`. If `sum % N != 0`, return -1.
2.  **Flow Analysis:**
    - Consider machine `i`. It needs `target` dresses eventually.
    - `balance`: accumulation of `machines[i] - target`.
    - If `balance` is positive at index `i`, it means the left part [0..i] has `balance` excess dresses that *must* flow to the right across the gap between `i` and `i+1`.
    - If `balance` is negative, dresses must flow from right to left.
    - The number of moves across this gap is at least `abs(balance)`.
3.  **Local Bottleneck:**
    - A single machine might have a huge excess `diff = machines[i] - target`.
    - Since it can only give 1 dress to left and 1 to right per step (at most 2 out - but wait, problem says "choose m machines... pass one dress... to one of its adjacent").
    - Actually, a machine can pass 1 dress to Left OR Right. It cannot pass 2 simultaneously?
    - "pass one dress of each washing machine to one of its adjacent".
    - Means Max Outflow/Inflow per machine is limited?
    - Wait. If machine has 10 excess, it takes at least 10 steps to offload?
    - If machine needs 10, it takes at least 10 steps to receive? No, neighbors can feed it. But feeding is 1 per neighbor.
    - The critical observation:
        - `moves` is determined by the maximum of:
            1. The max flow through any gap (`abs(balance)`).
            2. The max excess of any single individual machine (`machines[i] - target`).
        - Why not max deficit? Because multiple neighbors can feed a deficit machine simultaneously (e.g., L->M<-R). But a machine with huge excess can only output to neighbors. Wait, can it output to L and R simultaneously? "pass one dress... to one of its adjacent". It implies *one* destination per machine per step. So max throughput out is 1?
        - Re-reading: "choose any m machines... pass one dress... to one of its adjacent".
        - Yes. Each machine can active only once per step. So max outflow is 1.
        - Therefore, if a machine has excess 10, it needs 10 steps.
        - Result is `max(abs(balance), diff)`.

---

## 2. Approach: Single Pass Greedy
## *2. Hướng tiếp cận: Tham lam Một lần duyệt*

### Logic
### *Logic*
Iterate `i`:
- `diff = machines[i] - avg`.
- `balance += diff`.
- `maxMoves = max(maxMoves, abs(balance), diff)`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Time:** Single scan tracking accumulated state.
    *Thời gian O(N): Quét một lần theo dõi trạng thái tích lũy.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 0, 5]` -> Sum 6, Avg 2.
1. `i=0`: `val=1`. `diff = 1-2 = -1`. `bal = -1`. `maxMoves = max(0, 1, -1) = 1`.
2. `i=1`: `val=0`. `diff = 0-2 = -2`. `bal = -3`. `maxMoves = max(1, 3, -2) = 3`.
3. `i=2`: `val=5`. `diff = 5-2 = 3`. `bal = 0`. `maxMoves = max(3, 0, 3) = 3`.
Result: 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Calculate flow balance and local excess. Return max.
*Tính toán cân bằng dòng chảy và dư thừa cục bộ. Trả về max.*
---
*Cuộc sống luôn tìm cách cân bằng chính nó (avg). Trong quá trình phân phối lại sự giàu có hay năng lượng, đôi khi gánh nặng lớn nhất không nằm ở tổng thể, mà nằm ở những điểm nghẽn cục bộ (bottlenecks). Để làm dịu đi những bất công (excess), ta cần thời gian và từng bước chuyển dịch kiên nhẫn.*
Life always seeks to balance itself (AVG). In the process of redistributing wealth or energy, sometimes the biggest burden is not in the whole, but in local bottlenecks (Bottlenecks). To soothe injustices (Excess), we need time and step by step patient shifting.

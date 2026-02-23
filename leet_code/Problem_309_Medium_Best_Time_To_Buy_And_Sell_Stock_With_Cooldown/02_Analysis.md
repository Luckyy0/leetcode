# Analysis for Best Time to Buy and Sell Stock with Cooldown
# *Phân tích cho bài toán Thời điểm Tốt nhất để Mua và Bán Cổ phiếu với Thời gian Nghỉ*

## 1. Problem Essence & State Machine
## *1. Bản chất vấn đề & Máy trạng thái*

### The States
### *Các trạng thái*
We have 3 states at end of day `i`:
1.  **Held (H):** Have a stock.
2.  **Sold (S):** Just sold stock today.
3.  **Rest (R):** Don't have stock, and didn't sell today (cooldown or idling).

### Transitions
### *Chuyển đổi*
- `Held[i]`:
    - Kept holding: `Held[i-1]`
    - Just bought: `Rest[i-1] - price` (Must come from Rest, implies cooldown met).
    - `H[i] = max(H[i-1], R[i-1] - price)`
- `Sold[i]`:
    - Just sold: `Held[i-1] + price`
    - `S[i] = H[i-1] + price`
- `Rest[i]`:
    - Was Rest: `Rest[i-1]`
    - Was Sold (yesterday): `Sold[i-1]`
    - `R[i] = max(R[i-1], S[i-1])`

### Base Cases
### *Trường hợp cơ sở*
- `H[0] = -prices[0]`
- `S[0] = 0` (Can't sell) -> Actually logic `min_val` but 0 works if we assume sell profit 0. Correct is `-infinity`? No, 0 implies no profit.
- `R[0] = 0`

Result is `max(Sold[n], Rest[n])`. Cannot end in Held (waste of money).

### Optimization
### *Tối ưu hóa*
Space complexity can be $O(1)$ since we only use `i-1`.
`prevH`, `prevS`, `prevR`.

---

## 2. Approach: DP with State Machine
## *2. Hướng tiếp cận: DP với Máy trạng thái*

### Logic
### *Logic*
1.  Init `held = -infinity`, `sold = 0`, `rest = 0`.
    - Wait, for day 0: `held = -prices[0]`. `sold = 0`. `rest = 0`.
2.  Loop `price` in `prices`:
    - `prevSold = sold`
    - `sold = held + price`
    - `held = max(held, rest - price)`
    - `rest = max(rest, prevSold)`
3.  Return `max(sold, rest)`.

Wait, order of updates matters if using variables.
`oldRest = rest`
`rest = max(rest, sold)`
`sold = held + price`
`held = max(held, oldRest - price)`

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Explicit Rules:** Directly models the business logic rules into transitions.
    *Quy tắc rõ ràng: Mô hình hóa trực tiếp các quy tắc nghiệp vụ thành các chuyển đổi.*

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

**Input:** `[1, 2, 3, 0, 2]`
Init: `H=-1, S=0, R=0`.
1.  Price 1 (Day 0 handling implicitly done or start loop from 1?).
    - Let's say Init valid before loop.
    - Start loop at Day 1 (Price 2).
    - `prevR = 0`.
    - `R = max(0, 0) = 0`.
    - `S = -1 + 2 = 1`.
    - `H = max(-1, 0 - 2) = -1`.
    - States: H=-1, S=1, R=0.
2.  Price 3.
    - `prevR = 0`.
    - `R = max(0, 1) = 1`.
    - `S = -1 + 3 = 2`.
    - `H = max(-1, 0 - 3) = -1`.
    - States: H=-1. S=2. R=1.
3.  Price 0.
    - `prevR = 1`.
    - `R = max(1, 2) = 2`.
    - `S = -1 + 0 = -1`.
    - `H = max(-1, 1 - 0) = 1`. (Buy at 0).
    - States: H=1, S=-1, R=2.
4.  Price 2.
    - `prevR = 2`.
    - `R = max(2, -1) = 2`.
    - `S = 1 + 2 = 3`. (Sell the stock bought at 0).
    - `H = max(1, 2 - 2) = 1`.
    - States: H=1, S=3, R=2.
Result: `max(3, 2) = 3`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

State machine is the correct mental model.
*Máy trạng thái là mô hình tư duy đúng đắn.*
---
*Nghỉ ngơi (cooldown) không phải là sự trì hoãn, mà là một phần chiến lược để lấy đà cho lần mua tiếp theo giá trị hơn.*
Targeted rest (cooldown) is not procrastination, but a strategic part to gain momentum for the next, more valuable acquisition.

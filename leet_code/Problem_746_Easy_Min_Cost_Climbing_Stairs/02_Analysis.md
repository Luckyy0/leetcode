# Analysis for Min Cost Climbing Stairs
# *Phân tích cho bài toán Chi phí Tối thiểu để Leo Cầu thang*

## 1. Problem Essence & Reaching the Top
## *1. Bản chất vấn đề & Lên đến Đỉnh*

### The Challenge
### *Thách thức*
The goal is to reach the "top", which is conceptually `index n` (beyond the last element of the array). We can arrive at `n` from either `n-1` or `n-2`. To minimize the total cost, we must decide at each step whether paying the cost of the current step is worth the jump it provides.
*Mục tiêu là lên đến "đỉnh", về mặt khái niệm là chỉ số `n` (vượt quá phần tử cuối cùng của mảng). Ta có thể đến `n` từ `n-1` hoặc `n-2`. Để tối thiểu hóa tổng chi phí, ta phải quyết định tại mỗi bước xem liệu việc trả phí cho bậc hiện tại có xứng đáng với cú nhảy mà nó mang lại hay không.*

---

## 2. Strategy: Dynamic Programming
## *2. Chiến lược: Quy hoạch động*

### Recurrence Relation
### *Công thức Truy hồi*
Let `dp[i]` be the minimum cost to reach step `i`.
*Gọi `dp[i]` là chi phí tối thiểu để đến bậc `i`.*
To reach step `i`:
- We could have come from step `i-1`. Cost: `dp[i-1] + cost[i-1]`.
- We could have come from step `i-2`. Cost: `dp[i-2] + cost[i-2]`.
- Thus: `dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])`.

### Base Cases
### *Trường hợp Cơ sở*
- `dp[0] = 0` (You can start at index 0 without paying anything *before* stepping on it, but wait, the standard interpretation is usually: to *leave* step 0 requires paying `cost[0]`. Actually, the problem says "pay cost, then climb". So cost to reach index 0 is 0. Cost to reach index 1 is 0. Wait? No.
- Re-reading: "Start from... index 0 or index 1".
- So cost to reach "Start state" is 0.
- `dp[0] = 0`.
- `dp[1] = 0`.
- Then `dp[2] = min(dp[1] + cost[1], dp[0] + cost[0])`.
- Correct model: `dp[i]` is min cost to reach step `i`.
- Target: `dp[n]`.

### Optimization
### *Tối ưu hóa*
We only need `dp[i-1]` and `dp[i-2]`, so we can reduce space to $O(1)$ variables.
*Ta chỉ cần kết quả của hai bước trước đó, nên có thể giảm không gian xuống còn $O(1)$ biến.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Single pass.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**cost = [10, 15, 20], n=3**
- `step0` (reach 0) = 0.
- `step1` (reach 1) = 0.
- `step2` (reach 2): min(step1 + cost[1], step0 + cost[0]) = min(0+15, 0+10) = 10.
- `step3` (reach top): min(step2 + cost[2], step1 + cost[1]) = min(10+20, 0+15) = 15.
- Wait. My recurrence logic for `dp` meaning might be slightly off versus "paying to leave".
- Let's trace Example 1: `[10, 15, 20]`, Start idx 1. Pay 15, jump 2 steps -> top. Total 15.
- My manual trace:
  - `dp[0]` = cost[0]?, no. `dp[i]` = cost to *reach* i.
  - To reach 0: 0.
  - To reach 1: 0.
  - To reach 2: min(from 1: 0+15, from 0: 0+10) = 10.
  - To reach 3 (top): min(from 2: 10+20=30, from 1: 0+15=15) = 15. Correct.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

This is the simplest form of DP. Understanding that the "top" is step `n` (outside the array) is the key to setting up the loop range correctly.
*Đây là dạng đơn giản nhất của DP. Việc hiểu rằng "đỉnh" là bậc `n` (bên ngoài mảng) là chìa khóa để thiết lập phạm vi vòng lặp chính xác.*
---
*Mỗi bước chân leo lên (Climb) đều có cái giá của nó (Cost). Để chinh phục đỉnh cao (Reach the top) mà ít tốn kém nhất, ta buộc phải nhìn lại quá khứ gần nhất (Previous steps). Dữ liệu dạy ta rằng bằng cách liên tục chọn lựa con đường ít chông gai hơn trong từng bước nhảy (Local Min), ta sẽ đạt được sự tiết kiệm tối ưu cho cả hành trình (Global Min).*
Every step upward (Climb) has its price (Cost). To conquer the peak (Reach the top) with the least expense, we are forced to look back at the immediate past (Previous steps). Data teaches us that by continually choosing the less thorny path in each jump (Local Min), we will achieve optimal savings for the entire journey (Global Min).

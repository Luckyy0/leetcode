# Analysis for Minimum Cost For Tickets
# *Phân tích cho bài toán Chi phí Tối thiểu cho Vé*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Minimize cost to cover travel days using 1-day, 7-day, 30-day passes.
*Tối thiểu hóa chi phí để phủ kín các ngày đi du lịch bằng các loại vé.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Simple DP. `dp[i]` = min cost for travel up to day `i`.
- Max day is 365.
- If we don't travel on day `i`, `dp[i] = dp[i-1]`.
- If we travel, `dp[i] = min(dp[i-1] + cost[0], dp[i-7] + cost[1], dp[i-30] + cost[2])`.
- Handle `i-7` and `i-30` checks (if i < 7, use 0).
- Mark travel days in a boolean array for $O(1)$ check.
*Quy hoạch động theo ngày trong năm (1-365). Nếu ngày không đi thì chi phí bằng ngày trước đó. Nếu đi thì chọn min của 3 lựa chọn.*

---

## 2. Strategy: DP Array 365
## *2. Chiến lược: Mảng QP 365*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Mark Days:** `isTravel[366] = false`. Fill from `days`. `lastDay = days[N-1]`.
    *   **Đánh dấu:** Các ngày đi du lịch.*

2.  **DP Loop:** `i` from 1 to `lastDay` (or 365).
    - If `!isTravel[i]`: `dp[i] = dp[i-1]`.
    - Else:
      - `cost1 = dp[i-1] + costs[0]`
      - `cost7 = dp[max(0, i-7)] + costs[1]`
      - `cost30 = dp[max(0, i-30)] + costs[2]`
      - `dp[i] = min(cost1, cost7, cost30)`.
    *   **Vòng lặp:** Tính chi phí tối thiểu.*

3.  **Return:** `dp[lastDay]`.
    *   **Trả về:** `dp[lastDay]`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // Last travel day
        int lastDay = days[days.length - 1];
        // DP array up to the last day
        int[] dp = new int[lastDay + 1];
        boolean[] isTravelDay = new boolean[lastDay + 1];
        
        for (int d : days) {
            isTravelDay[d] = true;
        }
        
        for (int i = 1; i <= lastDay; i++) {
            if (!isTravelDay[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            
            // Try buying 1-day pass
            int one = dp[i - 1] + costs[0];
            
            // Try buying 7-day pass
            int seven = dp[Math.max(0, i - 7)] + costs[1];
            
            // Try buying 30-day pass
            int thirty = dp[Math.max(0, i - 30)] + costs[2];
            
            dp[i] = Math.min(one, Math.min(seven, thirty));
        }
        
        return dp[lastDay];
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(D)$ where D is the last travel day (at most 365).
    *   **Độ phức tạp thời gian:** $O(D)$.*
*   **Space Complexity:** $O(D)$.
    *   **Độ phức tạp không gian:** $O(D)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Iterating up to the last day is simple and efficient given max day is 365.
*Duyệt đến ngày cuối cùng là đơn giản và hiệu quả vì số ngày tối đa là 365.*

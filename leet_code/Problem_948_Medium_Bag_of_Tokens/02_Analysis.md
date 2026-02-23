# Analysis for Bag of Tokens
# *Phân tích cho bài toán Túi Token*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Maximize score by trading power for score (buy low) and score for power (sell high).
*Tối đa hóa điểm số bằng cách đổi sức mạnh lấy điểm (mua thấp) và đổi điểm lấy sức mạnh (bán cao).*

### KEY INSIGHT
### *Nhận xét quan trọng*
- **Greedy Strategy**:
  - To gain points (Face Up): Consume the *smallest* possible tokens to save power.
  - To gain power (Face Down): Consume the *largest* possible tokens to maximize power gain.
- **Sorting**: We must sort the tokens array first.
- **Two Pointers**: `low` pointer for buying (smallest tokens) and `high` pointer for selling (largest tokens).
- Maintain `maxScore` throughout the process.
- Loop condition: `while (low <= high)`.
  - If `power >= tokens[low]`: Buy token. `power -= tokens[low]`, `score++`, `low++`. Update `maxScore`.
  - Else if `score > 0` and `high > low` (need to ensure we have tokens left to buy back later): Sell token. `power += tokens[high]`, `score--`, `high--`.
  - Else: Cannot proceed. Break.
- Why only sell if `high > low`? Because if `low == high`, selling the last token gives us power but we can't use it to buy any more tokens to increase score. So we shouldn't sacrifice our score.
*Chiến lược Tham lam: Mua token rẻ nhất để tiết kiệm sức mạnh, bán token đắt nhất để lấy nhiều sức mạnh nhất. Sắp xếp mảng và dùng 2 con trỏ.*

---

## 2. Strategy: Greedy Two Pointers
## *2. Chiến lược: Hai con trỏ Tham lam*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Sort:** `Arrays.sort(tokens)`.
    *   **Sắp xếp:** `tokens` tăng dần.*

2.  **Initialize:** `low = 0`, `high = n - 1`, `score = 0`, `maxScore = 0`.
    *   **Khởi tạo:** Con trỏ và điểm số.*

3.  **Loop:** `low <= high`.
    - Case 1: If can buy (`power >= tokens[low]`):
      - Buy `tokens[low]`. Increase score. Move `low`.
      - Important: Update `maxScore` here.
    - Case 2: Else if can sell (`score > 0`):
      - Only sell if there are future tokens to buy (`low < high` is sufficient check? Actually standard check is fine, breaking if useless).
      - Normally, we want to maximize score. Selling reduces score. So we only sell if we MUST get power to buy cheaper tokens.
      - Sell `tokens[high]`. Decrease score. Move `high`.
      - **Wait**: We should prioritize buying. If we can't buy, then sell.
    - Case 3: Else (cannot buy and cannot sell/no need to sell): Break.
    *   **Vòng lặp:** Nếu mua được thì mua. Nếu không mua được nhưng bán được thì bán. Còn lại thì dừng.*

4.  **Return:** `maxScore`.
    *   **Trả về:** `maxScore`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.Arrays;

public class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int low = 0;
        int high = tokens.length - 1;
        int score = 0;
        int maxScore = 0;
        
        while (low <= high) {
            // Option 1: Play Face Up (Spend Power, Gain Score)
            // Always prefer buying the cheapest token available
            if (power >= tokens[low]) {
                power -= tokens[low];
                score++;
                low++;
                maxScore = Math.max(maxScore, score);
            }
            // Option 2: Play Face Down (Spend Score, Gain Power)
            // Only do this if we can't buy, have score to spend, and there are still tokens left to buy later
            else if (score > 0) {
                power += tokens[high];
                score--;
                high--;
            }
            // Option 3: Cannot play any move
            else {
                break;
            }
        }
        
        return maxScore;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ due to sorting. The two-pointer scan is $O(N)$.
    *   **Độ phức tạp thời gian:** $O(N \log N)$.*
*   **Space Complexity:** $O(\log N)$ or $O(N)$ for sorting recursion stack.
    *   **Độ phức tạp không gian:** $O(\log N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Sorting enables optimal decision making at each step: trade currently useless large tokens for power to buy many small tokens.
*Sắp xếp cho phép đưa ra quyết định tối ưu ở mỗi bước: đổi các token lớn vô dụng hiện tại lấy sức mạnh để mua nhiều token nhỏ.*

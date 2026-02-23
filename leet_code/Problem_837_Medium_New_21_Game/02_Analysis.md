# Analysis for New 21 Game
# *Phân tích cho bài toán Trò chơi 21 Mới*

## 1. Problem Essence & Dynamic Programming
## *1. Bản chất vấn đề & Quy hoạch động*

### THE CHALLENGE
### *Thách thức*
We need to calculate the probability of Alice ending up with a score between $K$ and $N$. Since at each step her next score depends on her current score, this is a probability-based DP problem. The score range can go up to $K + maxPts - 1$.
*Chúng ta cần tính xác suất Alice kết thúc với số điểm từ $K$ đến $N$. Vì tại mỗi bước, điểm số tiếp theo phụ thuộc vào điểm hiện tại, đây là bài toán DP về xác suất. Phạm vi điểm số có thể lên đến $K + maxPts - 1$.*

---

## 2. Strategy: Sliding Window DP
## *2. Chiến lược: Cửa sổ trượt DP*

### DP State Definition
### *Định nghĩa trạng thái DP*
Let `dp[i]` be the probability of having exactly `i` points at any point in the game.
*Gọi `dp[i]` là xác suất đạt được đúng `i` điểm tại bất kỳ thời điểm nào trong trò chơi.*

### Recurrence
### *Truy hồi*
To reach score $i$, Alice must have drawn a card value $x$ from a previous score $i-x$.
$$dp[i] = \sum_{j=\max(0, i-maxPts)}^{i-1} \frac{dp[j]}{maxPts}$$
- Only scores $j < K$ can be transitioned from (game continues only if $j < K$).
- Calculating this sum for every $i$ would take $O(K \times maxPts)$, which is too slow ($10^8$ operations).
*Để đạt điểm $i$, Alice phải rút được thẻ giá trị $x$ từ điểm $i-x$. Chú ý: Chỉ những điểm $j < K$ mới có thể rút tiếp. Tính tổng này trực tiếp sẽ tốn $O(K \times maxPts)$, quá chậm.*

### Sliding Window Sum Optimization
### *Tối ưu hóa tổng cửa sổ trượt*
We maintain a running sum `windowSum` of the `dp` values in the transition window $[i-maxPts, i-1]$.
- Update `windowSum` as we iterate from $i=1$ to $K+maxPts-1$:
    - If $i \le K$, add `dp[i-1]` to `windowSum`.
    - If $i > maxPts$, subtract `dp[i-maxPts-1]` from `windowSum`.
- `dp[i] = windowSum / maxPts`.
*Duy trì một biến `windowSum` lưu tổng các giá trị `dp` trong cửa sổ có thể nhảy tới `i`. Khi $i \le K$, ta thêm `dp[i-1]` vào `windowSum`. Khi $i > maxPts$, ta loại bỏ giá trị ra khỏi cửa sổ.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public double new21Game(int n, int k, int maxPts) {
    if (k == 0 || n >= k + maxPts) return 1.0;
    double[] dp = new double[n + 1];
    dp[0] = 1.0;
    double windowSum = 1.0;
    double result = 0.0;
    
    for (int i = 1; i <= n; i++) {
        dp[i] = windowSum / maxPts;
        if (i < k) windowSum += dp[i];
        else result += dp[i]; // Score >= K, game stops
        
        if (i >= maxPts) windowSum -= dp[i - maxPts];
    }
    return result;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We iterate through the DP array once.
    *   **Độ phức tạp thời gian:** $O(N)$, do duyệt qua mảng DP một lần.*
*   **Space Complexity:** $O(N)$, to store the DP array.
    *   **Độ phức tạp không gian:** $O(N)$ để lưu mảng DP.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `n=6, k=1, maxPts=10`
1. `dp[0] = 1.0`. `windowSum = 1.0`.
2. i=1: `dp[1] = 1.0 / 10 = 0.1`.
   - $i \ge k$, so `result += 0.1`.
   - `windowSum` update: $i < k$ (false), skip. $i \ge maxPts$ (false), skip.
3. Similar for i=2 to 6...
**Final Result:** `0.1 * 6 = 0.6`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using a sliding window to optimize range sums in DP is a standard technique for path-counting or probability problems with fixed-step ranges. Always consider edge cases like $K=0$ where the probability is immediate.
*Sử dụng cửa sổ trượt để tối ưu hóa tổng khoảng trong DP là kỹ thuật tiêu chuẩn cho các bài toán đếm đường đi hoặc xác suất với bước nhảy cố định. Luôn cân nhắc các trường hợp biên như $K=0$.*

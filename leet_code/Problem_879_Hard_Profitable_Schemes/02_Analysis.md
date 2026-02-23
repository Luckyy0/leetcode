# Analysis for Profitable Schemes
# *Phân tích cho bài toán Các kế hoạch Có lợi*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Select a subset of crimes such that the total members used $\le N$ and total profit $\ge minProfit$. This is a multidimensional knapsack problem.
*Chọn một tập hợp các tội phạm sao cho tổng số thành viên $\le N$ và tổng lợi nhuận $\ge minProfit$. Đây là bài toán cái túi đa chiều.*

---

## 2. Strategy: 2D Dynamic Programming (Knapsack)
## *2. Chiến lược: Quy hoạch động 2D (Bài toán Cái túi)*

### State Definition
### *Định nghĩa trạng thái*
Let `dp[i][j]` be the number of schemes using exactly `i` members and achieving at least `j` profit.
*Gọi `dp[i][j]` là số lượng kế hoạch sử dụng `i` thành viên và đạt được ít nhất `j` lợi nhuận.*

Note: Any profit above `minProfit` is treated as `minProfit` since we only care about reaching the threshold.
*Lưu ý: Bất kỳ lợi nhuận nào lớn hơn `minProfit` đều được coi là `minProfit` vì chúng ta chỉ quan tâm đến việc đạt được ngưỡng.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize DP Table:** `dp[0][0] = 1`. (0 members, 0 profit is initially 1 scheme).
    *   **Khởi tạo bảng DP:** `dp[0][0] = 1`.*

2.  **Iterate through crimes:**
    - For each crime `(g, p)` (group required, profit generated):
        - Iterate backwards from $N$ down to $g$ (members used: `i`):
            - Iterate backwards from $minProfit$ down to 0 (profit achieved: `j`):
                - `newProfit = min(minProfit, j + p)`
                - `dp[i][newProfit] = (dp[i][newProfit] + dp[i - g][j]) % MOD`
    *   **Duyệt qua các tội phạm:** Với mỗi tội phạm `(g, p)`, duyệt ngược từ $N$ xuống $g$ và từ $minProfit$ xuống 0. Tính toán `newProfit` (không vượt quá `minProfit`) và cập nhật bảng DP.*

3.  **Result:** Sum all `dp[i][minProfit]` for `i` from 0 to $N$.
    *   **Kết quả:** Tổng tất cả `dp[i][minProfit]` với `i` từ 0 đến $N$.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
    int[][] dp = new int[n + 1][minProfit + 1];
    dp[0][0] = 1;
    int MOD = 1000000007;
    
    for (int k = 0; k < group.length; k++) {
        int g = group[k], p = profit[k];
        for (int i = n; i >= g; i--) {
            for (int j = minProfit; j >= 0; j--) {
                int nextP = Math.min(minProfit, j + p);
                dp[i][nextP] = (dp[i][nextP] + dp[i - g][j]) % MOD;
            }
        }
    }
    
    int sum = 0;
    for (int i = 0; i <= n; i++) sum = (sum + dp[i][minProfit]) % MOD;
    return sum;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(CrimeCount \cdot N \cdot minProfit)$. With constraints $100 \cdot 100 \cdot 100 = 10^6$, this is very efficient.
    *   **Độ phức tạp thời gian:** $O(CrimeCount \cdot N \cdot minProfit)$, xấp xỉ $10^6$.*
*   **Space Complexity:** $O(N \cdot minProfit)$.
    *   **Độ phức tạp không gian:** $O(N \cdot minProfit)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Capping the profit at `minProfit` in the DP state is the key optimization to keep the complexity manageable.
*Giới hạn lợi nhuận ở mức `minProfit` trong trạng thái DP là chìa khóa tối ưu hóa để giữ cho độ phức tạp trong mức cho phép.*

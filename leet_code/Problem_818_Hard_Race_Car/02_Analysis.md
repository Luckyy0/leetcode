# Analysis for Race Car
# *Phân tích cho bài toán Đua xe*

## 1. Problem Essence & State Space
## *1. Bản chất vấn đề & Không gian trạng thái*

### THE CHALLENGE
### *Thách thức*
We need to find the shortest sequence of 'A' (Accelerate) and 'R' (Reverse) instructions to reach a specific `target` position.
Each 'A' doubles the speed and moves the car. Each 'R' flips the speed direction and resets magnitude to 1.
While this looks like a BFS problem (shortest path in state space), the `target` value of $10^4$ makes the state space large. Dynamic Programming is more efficient here.
*Chúng ta cần tìm chuỗi lệnh ngắn nhất gồm 'A' (tăng tốc) và 'R' (quay đầu) để đến vị trí `target`. 'A' gấp đôi tốc độ và di chuyển xe. 'R' đảo ngược hướng và reset độ lớn vận tốc về 1. Mặc dù trông giống bài toán BFS, giá trị `target` lên tới $10^4$ khiến không gian trạng thái lớn. Quy hoạch động sẽ hiệu quả hơn.*

---

## 2. Strategy: Dynamic Programming
## *2. Chiến lược: Quy hoạch động*

### DP State Definition
### *Định nghĩa trạng thái DP*
Let `dp[i]` be the minimum number of instructions to reach position `i` starting from `0` with speed `1`.
*Gọi `dp[i]` là số lượng lệnh tối thiểu để đi từ `0` đến `i` với vận tốc bắt đầu là `1`.*

### Recurrence Scenarios
### *Các kịch bản truy hồi*
To reach `i`, let $k$ be the number of consecutive 'A' commands such that $2^{k-1}-1 < i$.
*Để đến `i`, gọi $k$ là số lệnh 'A' liên tiếp sao cho $2^{k-1}-1 < i$.*

1.  **Direct match:** If $2^k-1 = i$, then `dp[i] = k`.
    *   **Khớp trực tiếp:** Nếu $2^k-1 = i$, thì `dp[i] = k`.*

2.  **Overstepping:** We go past $i$ using $k$ 'A's (reaching $pos = 2^k-1 > i$). Then we reversal ('R'), and we still need to reach the remaining distance $pos - i$.
    - Steps = $k$ (As) + 1 (R) + `dp[pos - i]`.
    *   **Vượt quá:** Chúng ta đi quá $i$ bằng $k$ lệnh 'A' (đến $2^k-1 > i$). Sau đó quay đầu ('R'), và cần đi tiếp khoảng cách còn lại. Số bước = $k$ + 1 + `dp[pos - i]`.*

3.  **Understepping:** We go up to $k-1$ 'A's (reaching $pos = 2^{k-1}-1 < i$). We reverse ('R'), go back $j$ steps (using $j$ 'A's), reverse again ('R'), and then reach $i$.
    - Distance reached after first reversal and back-stepping: $(2^{k-1}-1) - (2^j-1)$.
    - Remaining distance to `i`: $i - [(2^{k-1}-1) - (2^j-1)]$.
    - Steps = $(k-1)$ (As) + 1 (R) + $j$ (As) + 1 (R) + `dp[remaining]`.
    - We iterate through all possible $j < k-1$.
    *   **Chưa tới:** Ta đi $k-1$ lệnh 'A' ($2^{k-1}-1 < i$). Quay đầu ('R'), đi lùi $j$ bước (dùng $j$ lệnh 'A'), quay đầu lần nữa ('R'), rồi mới đến $i$. Số bước = $(k-1) + 1 + j + 1 + dp[i - (2^{k-1}-1) + (2^j-1)]$. Duyệt qua mọi $j < k-1$.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int racecar(int target) {
    int[] dp = new int[target + 1];
    
    for (int i = 1; i <= target; i++) {
        // Find smallest k such that 2^k - 1 >= i
        int k = 32 - Integer.numberOfLeadingZeros(i);
        if (i == (1 << k) - 1) {
            dp[i] = k;
            continue;
        }
        
        // Scenario 2: Overstep and reverse once
        // k (As) + 1 (R) + steps to reach (2^k - 1) - i
        dp[i] = k + 1 + dp[(1 << k) - 1 - i];
        
        // Scenario 3: Understep (k-1 As), reverse back j steps, reverse again
        for (int j = 0; j < k - 1; j++) {
            // (k-1) As + R + j As + R + remaining distance
            int distMoved = (1 << (k - 1)) - (1 << j);
            dp[i] = Math.min(dp[i], (k - 1) + 1 + j + 1 + dp[i - distMoved]);
        }
    }
    return dp[target];
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(T \cdot \log T)$, where $T$ is the target. For each $i$, we iterate up to $k = \lceil \log_2(i+1) \rceil$.
    *   **Độ phức tạp thời gian:** $O(T \cdot \log T)$, với $T$ là đích. Với mỗi $i$, ta duyệt qua khoảng $\log_2(i)$ bước.*
*   **Space Complexity:** $O(T)$, to store the `dp` array.
    *   **Độ phức tạp không gian:** $O(T)$, để lưu mảng `dp`.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `target = 3`
1. `i=1`: $k=1, 2^1-1=1=i \Rightarrow dp[1]=1$.
2. `i=2`: $k=2, 2^2-1=3 > 2$.
   - Overstep (k=2): $2+1+dp[3-2] = 3+1 = 4$.
   - Understep (k=1): $j=0, (2-1)+1+0+1+dp[2-(2^1-1)+(2^0-1)] = 1+1+0+1+dp[1] = 4$.
   - Wait, `AA` is 2 steps for 3 (i=3). 
3. `i=3`: $k=2, 2^2-1=3=i \Rightarrow dp[3]=2$.
**Result:** 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

DP is significantly better than BFS here because the structure of the problem allows us to break the path into sub-problems: "How to reach the remaining distance after a strategic reversal." This reduces the redundant search significantly.
*DP tốt hơn đáng kể so với BFS ở đây vì cấu trúc bài toán cho phép chúng ta chia nhỏ đường đi thành các bài toán con: "Cách đi khoảng cách còn lại sau một lần quay đầu chiến lược". Điều này giúp giảm đáng kể việc tìm kiếm dư thừa.*

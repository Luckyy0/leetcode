# Analysis for Prison Cells After N Days
# *Phân tích cho bài toán Tế bào Nhà tù sau N Ngày*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Simulate evolution of 8 binary cells for $N$ days. $N$ can be up to $10^9$.
*Mô phỏng 8 tế bào nhị phân trong N ngày. N rất lớn.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Cells length is only 8.
- 1st and last cells become 0 after day 1 and stay 0 forever (rule: "can't have two adjacent neighbors").
- So effectively only 6 cells change.
- Total possible states for 6 cells is $2^6 = 64$.
- Since $N$ is large ($10^9$) and total states are small (64), the states must **cycle**.
- We can simulate the process and detect a cycle using a HashMap (state -> day seen).
- Once a cycle is detected (state `S` seen at day `d1` and `d2`):
  - Cycle length `L = d2 - d1`.
  - Remaining days `(N - d2)`.
  - Skip remaining full cycles: `remaining % L`.
- Be careful with 0-indexed vs 1-indexed days and where the cycle starts.
*Có tối đa 64 trạng thái. Chu trình chắc chắn xảy ra. Dùng HashMap để phát hiện chu trình và nhảy cóc thời gian.*

---

## 2. Strategy: Cycle Detection
## *2. Chiến lược: Phát hiện Chu trình*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Map:** `state -> day`.
    *   **Map:** Trạng thái -> Ngày.*

2.  **Iterate:** `day` from 1 to `N`.
    - Calculate next state.
    - If seen before:
      - `cycleLength = day - map.get(state)`.
      - `remainingDays = N - day`.
      - `daysToSkip = remainingDays % cycleLength`.
      - Fast forward: `day = N - daysToSkip`. (Or simply simulate `daysToSkip` more steps?)
      - Actually, simpler logic: `N = (N - seenDay) % cycleLength + seenDay`. Wait, let's just simulate the remaining `rem % L` days? No, once cycle detected, we can calculate the final position.
      - Better: `N = (N - 1) % 14 + 1`? No, cycle length might not be 14.
      - Let's stick to standard map detection.
    - Else: `map.put(state, day)`.
    *   **Duyệt:** Tính trạng thái tiếp theo. Nếu lặp lại, tính chu trình và nhảy cóc.*

3.  **Simulation Function:** Helper to compute next state.
    *   **Hàm mô phỏng:** Tính trạng thái kế tiếp.*

4.  **Return:** Final state.
    *   **Trả về:** Trạng thái cuối.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> seen = new HashMap<>();
        boolean cycleDetected = false;
        
        for (int i = 0; i < n; i++) {
            int[] next = nextDay(cells);
            String state = Arrays.toString(next);
            
            if (!cycleDetected && seen.containsKey(state)) {
                // Cycle detected
                int prevDay = seen.get(state);
                int day = i;
                int cycleLen = day - prevDay;
                int remainingDays = n - 1 - i; // days left after today
                int daysToSkip = (remainingDays / cycleLen) * cycleLen;
                
                // Jump forward
                i += daysToSkip; 
                cycleDetected = true; // Don't detect again to avoid messed up logic
            } else {
                seen.put(state, i);
            }
            cells = next;
        }
        
        return cells;
    }
    
    private int[] nextDay(int[] cells) {
        int[] next = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i-1] == cells[i+1]) {
                next[i] = 1;
            } else {
                next[i] = 0;
            }
        }
        return next;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(2^C)$ where $C=6$. Constant time effectively (max 64 iterations before cycle).
    *   **Độ phức tạp thời gian:** $O(1)$.*
*   **Space Complexity:** $O(2^C)$ for map.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

State space is very small. Cycle detection is the standard way to handle large $N$. Note cycle length is actually always 1, 7, or 14 for this specific problem but generic detection handles all cases.
*Không gian trạng thái rất nhỏ. Phát hiện chu trình là cách tiêu chuẩn để xử lý N lớn.*

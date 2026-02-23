# Analysis for Powerful Integers
# *Phân tích cho bài toán Các Số nguyên Mạnh mẽ*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find all unique $v = x^i + y^j \le \text{bound}$ where $i, j \ge 0$.
*Tìm tất cả các số v thỏa mãn điều kiện.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Simple brute force.
- Since `bound <= 10^6`, the powers $x^i$ and $y^j$ grow very fast if $x, y \ge 2$.
- $2^{20} > 10^6$, so max exponent is around 20.
- If $x=1$, then $x^i = 1$ always. Loop runs once. Same for $y=1$.
- Strategy: Generate all valid powers of $x$ and $y$. Then use nested loops to sum them. Store in a HashSet to avoid duplicates.
*Vét cạn đơn giản vì số lượng lũy thừa nhỏ hơn bound rất ít (tối đa ~20 với cơ số 2). Xử lý riêng trường hợp x=1 hoặc y=1.*

---

## 2. Strategy: Brute Force with HashSet
## *2. Chiến lược: Vét cạn với HashSet*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Set:** `seen` to store unique sums.
    *   **Khởi tạo Set:** Lưu tổng duy nhất.*

2.  **Outer Loop (i):** Iterate powers of $x$: $a = x^0, x^1, \dots$ while $a \le \text{bound}$.
    - If $x=1$, iterate once then break.
    *   **Vòng lặp ngoài:** Duyệt lũy thừa của x.*

3.  **Inner Loop (j):** Iterate powers of $y$: $b = y^0, y^1, \dots$ while $a + b \le \text{bound}$.
    - If $y=1$, iterate once then break.
    - Add $a+b$ to `seen`.
    *   **Vòng lặp trong:** Duyệt lũy thừa của y và tính tổng.*

4.  **Return:** Convert Set to List.
    *   **Trả về:** Chuyển Set thành List.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();
        
        for (int i = 1; i <= bound; i *= x) {
            for (int j = 1; i + j <= bound; j *= y) {
                result.add(i + j);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        
        return new ArrayList<>(result);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log_x(\text{bound}) \cdot \log_y(\text{bound}))$. Very small.
    *   **Độ phức tạp thời gian:** Nhỏ.*
*   **Space Complexity:** $O(\text{bound})$ in worst case (though actually much smaller, related to number of powerful integers).
    *   **Độ phức tạp không gian:** Nhỏ.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple nested loops work perfectly due to the logarithmic growth of powers.
*Vòng lặp lồng nhau hoạt động hoàn hảo do sự tăng trưởng logarit của lũy thừa.*

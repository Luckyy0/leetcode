# Analysis for Broken Calculator
# *Phân tích cho bài toán Máy Tính Hỏng*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Reach `target` from `startValue` using operations: multiply by 2 or subtract 1.
*Đi từ `startValue` đến `target` chỉ bằng cách: nhân 2 hoặc trừ 1.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Working forward from `startValue` can have multiple branches (should I multiply then subtract, or subtract then multiply?).
- Working backward from `target` is deterministic and greedy!
  - The reverse operations are: **divide by 2 (only if even)**, and **add 1**.
  - If `target` is greater than `startValue` and is odd, we *must* add 1 to make it even so we can divide by 2.
  - If `target` is greater than `startValue` and is even, we *should* divide by 2 to reduce it quickly towards `startValue`.
  - Doing `target + 1` twice then dividing by 2 `(target + 2) / 2 = target/2 + 1` takes 3 operations. Dividing by 2 then adding 1 `(target/2) + 1` takes 2 operations and reaches the same value. Thus, dividing when even is always optimal.
  - Once `target` falls equal to or below `startValue`, we have no choice but to keep adding 1 (which translates to subtracting 1 going forward). The number of operations needed is exactly `startValue - target`.
*Giải bài toán theo hướng ngược lại, đi từ target về start. Nếu target lẻ thì bắt buộc phải cộng 1. Nếu target chẵn thì chia 2. Nếu target nhỏ hơn start thì chỉ còn cách cộng thêm.*

---

## 2. Strategy: Backwards Greedy
## *2. Chiến lược: Tham lam Ngược*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `operations = 0`.
    *   **Khởi tạo:** `operations = 0`.*

2.  **Loop Backwards:** While `target > startValue`:
    - Increment `operations++`.
    - If `target` is odd (`target % 2 != 0`), make it even: `target++`.
    - If `target` is even (`target % 2 == 0`), reduce it: `target /= 2`.
    *   **Vòng lặp ngược:** Chia 2 nếu chẵn, cộng 1 nếu lẻ.*

3.  **Finish Remainder:** Once `target <= startValue`, we must add `startValue - target` to operations (because we can only add 1 at a time).
    *   **Phần còn lại:** Cộng khoản cách từ target đến startValue.*

4.  **Return:** `operations`.
    *   **Trả về:** Tổng số thao tác.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public int brokenCalc(int startValue, int target) {
        int operations = 0;
        
        while (target > startValue) {
            operations++;
            // If odd, we must add 1
            if (target % 2 != 0) {
                target++;
            } else {
                // If even, we are better off dividing by 2
                target /= 2;
            }
        }
        
        // Once target is <= startValue, the only way is to add 1 repeatedly
        return operations + (startValue - target);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log_{2}(\text{target}))$. We halve the target whenever it is even. In the worst case, we do an addition then a division, so it's bounded by operations proportional to the logarithm of the `target`.
    *   **Độ phức tạp thời gian:** $O(\log(\text{target}))$.*
*   **Space Complexity:** $O(1)$. We only use a few integer variables.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Working backwards reduces the state space drastically and turns a tree-search problem into a simple greedy algorithm.
*Làm việc từ đích ngược lại giúp thu nhỏ không gian trạng thái đáng kể và biến bài toán tìm kiếm thành thuật toán tham lam.*

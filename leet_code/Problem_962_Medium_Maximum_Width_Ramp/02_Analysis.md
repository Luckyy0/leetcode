# Analysis for Maximum Width Ramp
# *Phân tích cho bài toán Đoạn đường nối Rộng nhất*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find `(i, j)` with `i < j` and `nums[i] <= nums[j]` such that `j - i` is maximized.
*Tìm cặp `(i, j)` thỏa mãn điều kiện và hiệu `j - i` lớn nhất.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- We want to find an `i` as small as possible and a `j` as large as possible.
- Consider a decreasing sequence of initial elements. Why? If `nums[k] >= nums[m]` where `k < m`, then `k` is a strictly worse candidate for `i` than `m`? Wait, no.
  - If `nums[k] >= nums[m]` with `k < m`:
    - Any `j` that satisfies `nums[j] >= nums[k]` will also satisfy `nums[j] >= nums[m]`.
    - Since `k < m`, `j - k > j - m`. So `k` is actually a BETTER candidate for `i` if valid.
  - But what if `nums[k] < nums[m]` where `k < m`?
    - `k` is smaller (easier to satisfy) and more to the left (larger width). `k` dominates `m` as a starting point.
    - Thus, we only care about possible starting points `i` that are strictly decreasing.
- Algorithm:
  1. Build a Monotonic Stack of indices `s` such that `nums[s[0]] > nums[s[1]] > ...`.
     - Iterate `i` from 0 to `N-1`. Push `i` if stack empty or `nums[i] < nums[stack.peek()]`.
     - These are the candidates for the LEFT end of the ramp.
  2. Iterate `j` backwards from `N-1` to 0.
     - While stack not empty and `nums[stack.peek()] <= nums[j]`:
       - We found a valid pair `(stack.peek(), j)`.
       - `maxWidth = max(maxWidth, j - stack.peek())`.
       - `stack.pop()`.
     - Why pop? because for any `k < j`, the width `k - stack.peek()` will be smaller than `j - stack.peek()`. Since we want max width, we already found the best `j` for this specific `stack.peek()`.
*Dùng Monotonic Stack để lưu các chỉ số giảm dần (ứng viên tốt nhất cho đầu trái). Duyệt ngược từ cuối để tìm đầu phải tốt nhất.*

---

## 2. Strategy: Monotonic Stack
## *2. Chiến lược: Monotonic Stack*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Build Decrease Stack:**
    - Iterate `i` from 0 to `N-1`.
    - If stack empty or `nums[i] < nums[stack.peek()]`, push `i`.
    *   **Xây dựng Stack Giảm:** Lưu các chỉ số có giá trị giảm dần.*

2.  **Iterate Backwards:**
    - Iterate `j` from `N-1` down to 0.
    - While `!stack.isEmpty()` and `nums[stack.peek()] <= nums[j]`:
      - `maxWidth = max(maxWidth, j - stack.peek())`.
      - `stack.pop()`.
    *   **Duyệt Ngược:** Tìm đầu phải `j` lớn nhất cho mỗi đầu trái trong stack.*

3.  **Return:** `maxWidth`.
    *   **Trả về:** `maxWidth`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.Stack;

public class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        
        // Step 1: Build a decreasing stack of indices
        // Possible left boundaries of the ramp
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        
        int maxWidth = 0;
        
        // Step 2: Iterate from the end and try to match with the stack top
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                maxWidth = Math.max(maxWidth, j - stack.peek());
                stack.pop();
            }
        }
        
        return maxWidth;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Each element pushed and popped at most once.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ for stack.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using a monotonic stack to store potential "best starting indices" allows us to efficiently query the widest ramp in a single linear pass backwards.
*Sử dụng stack đơn điệu để lưu trữ các "chỉ số bắt đầu tốt nhất" tiềm năng cho phép truy vấn đoạn đường nối rộng nhất một cách hiệu quả trong một lần duyệt ngược tuyến tính.*

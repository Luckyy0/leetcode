# Analysis for Sum of Subarray Minimums
# *Phân tích cho bài toán Tổng Các Giá trị Nhỏ nhất của Mảng con*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Calculate $\sum_{i, j} \min(arr[i \dots j])$.
*Tính tổng các giá trị nhỏ nhất của tất cả các mảng con liên tiếp.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Instead of iterating all subarrays (which is $O(N^2)$), let's consider each element `arr[i]` and count **how many subarrays have `arr[i]` as their minimum**.
- For `arr[i]` to be the minimum of a subarray `[L, R]`, the subarray must satisfy:
  - `L <= i <= R`
  - All elements in `arr[L \dots i]` are $\ge arr[i]$.
  - All elements in `arr[i \dots R]` are $\ge arr[i]$.
- To avoid double counting (when there are duplicate minimum values), we can establish a convention:
  - Extend to the **left** as strictly greater (`>`).
  - Extend to the **right** as greater or equal (`>=`).
- We need to find:
  - `PLE[i]`: Previous Less Element index. The nearest index to the left strictly smaller than `arr[i]`.
  - `NLE[i]`: Next Less Element index. The nearest index to the right smaller or equal to `arr[i]` (wait, strictly smaller to handle duplicates correctly).
- Let `left = i - PLE[i]` be the distance to the left boundary.
- Let `right = NLE[i] - i` be the distance to the right boundary.
- The number of subarrays where `arr[i]` is min is `left * right`.
- Total sum = $\sum (arr[i] \times left[i] \times right[i])$.

*Thay vì duyệt mọi mảng con, ta xét xem mỗi phần tử `arr[i]` đóng vai trò là giá trị nhỏ nhất trong bao nhiêu mảng con. Cần tìm `PLE` (Phần tử Nhỏ hơn Trước đó) và `NLE` (Phần tử Nhỏ hơn Tiếp theo). Số lượng mảng con là khoảng cách từ `i` đến `PLE` nhân với khoảng cách từ `i` đến `NLE`. Để tránh đếm trùng lặp các giá trị bằng nhau, một bên dùng so sánh nghiêm ngặt, bên kia dùng so sánh không nghiêm ngặt.*

---

## 2. Strategy: Monotonic Stack
## *2. Chiến lược: Ngăn xếp Đơn điệu*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Find PLE (Previous Less Element):**
    - Use a monotonic increasing stack.
    - Iterate `i` from 0 to `n-1`.
    - Pop elements from stack that are GE (greater or equal) to `arr[i]`.
    - `PLE[i]` is the index at the top of stack (or -1 if empty).
    - Push `i`.
    *   **Tìm PLE:** Dùng ngăn xếp tăng dần. Pop các phần tử lớn hơn hoặc bằng. `PLE` là đỉnh stack.*

2.  **Find NLE (Next Less Element):**
    - Use a monotonic increasing stack.
    - Iterate `i` from `n-1` to 0.
    - Pop elements from stack that are GT (strictly greater) to `arr[i]`. (Using strict here ensures we handle duplicates correctly with the GE in PLE step, or vice-versa).
    - Actually, standard way:
        - PLE: pop while `stack.top > arr[i]`. (Strictly greater). Boundary is `>=`.
        - NLE: pop while `stack.top >= arr[i]`. (Greater or equal). Boundary is `<`.
        - If we use `>` for left and `>=` for right, we cover duplicates exactly once.
    - Let's stick to convention: Find nearest element on left which is `<` arr[i]. Find nearest element on right which is `<=`.
    *   **Tìm NLE:** Dùng ngăn xếp tăng dần. Pop các phần tử lớn hơn. Quy ước: Trái tìm số `<`, Phải tìm số `<=`.*

3.  **Calculate Sum:**
    - `ans = 0`.
    - For each `i`: `count = (i - PLE[i]) * (NLE[i] - i)`. `ans = (ans + arr[i] * count) % MOD`.
    *   **Tính tổng:** `count = khoảng cách trái * khoảng cách phải`. Cộng dồn vào kết quả.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int sumSubarrayMins(int[] arr) {
    long MOD = 1_000_000_007;
    int n = arr.length;
    
    int[] ple = new int[n]; // Previous Less Element
    int[] nle = new int[n]; // Next Less Element (or equal)
    
    Stack<Integer> stack = new Stack<>();
    
    // Calculate PLE: nearest index j < i such that arr[j] < arr[i]
    // If none, assume -1
    for (int i = 0; i < n; i++) {
        // We pop if stack top > arr[i]. 
        // We want left boundary to be strict less. So we stop at <= arr[i].
        // Wait, if duplicates: 3, 1, 2, 1, 4.
        // For the first 1 (at idx 1): PLE is -1. NLE is 3 (second 1).
        // Range: includes itself.
        // Let's use:
        // Left: strictly smaller. (pop while top >= arr[i]) -> nearest is < arr[i].
        // Right: smaller or equal. (pop while top > arr[i]) -> nearest is <= arr[i].
        
        while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
            stack.pop();
        }
        ple[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(i);
    }
    
    stack.clear();
    
    // Calculate NLE: nearest index j > i such that arr[j] <= arr[i]
    // If none, assume n
    for (int i = n - 1; i >= 0; i--) {
        // Logic must be complementary.
        // Above we popped >=, so we found nearest <.
        // Here we pop >, so we find nearest <=.
        
        while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
            stack.pop();
        }
        nle[i] = stack.isEmpty() ? n : stack.peek();
        stack.push(i);
    }
    
    long sum = 0;
    for (int i = 0; i < n; i++) {
        long left = i - ple[i];
        long right = nle[i] - i;
        long contribution = (left * right % MOD) * arr[i] % MOD;
        sum = (sum + contribution) % MOD;
    }
    
    return (int) sum;
}
```

Wait, let's double check duplicate handling.
Example: `[1, 1]`.
i=0 (val=1):
- Left: -1. dist = 1.
- Right: Nearest <= is idx 1. dist = 1.
- Contrib = 1 * 1 * 1 = 1. (Subarray `[1]`)
i=1 (val=1):
- Left: Nearest < is -1. dist = 2.
- Right: Nearest <= is n(2). dist = 1.
- Contrib = 2 * 1 * 1 = 2. (Subarrays `[1]`, `[1, 1]`)
Total = 3. Correct.
Subarrays are `[1]`, `[1]`, `[1, 1]`. Mins are 1, 1, 1. Sum 3. Correct.

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Two passes with monotonic stack. Each element pushed/popped once.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ for stacks and arrays.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The key is handling duplicates correctly by breaking the symmetry (one side strict, one side non-strict). Monotonic stack is the standard tool for "Next Less/Greater Element" problems.
*Chìa khóa nằm ở việc xử lý các giá trị trùng lặp bằng cách phá vỡ tính đối xứng (một bên so sánh nghiêm ngặt, một bên không). Ngăn xếp đơn điệu là công cụ tiêu chuẩn cho các bài toán tìm phần tử nhỏ hơn/lớn hơn tiếp theo.*

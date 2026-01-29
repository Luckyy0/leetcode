# 1425. Constrained Subsequence Sum / Tổng Chuỗi con Bị ràng buộc

## Problem Description / Mô tả bài toán
Array `nums`. `k`.
Subsequence `nums[i_1], nums[i_2]...` such that `i_{j+1} - i_j <= k`.
Maximize sum.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DP with Sliding Window Maximum (Deque)
`dp[i]` = max sum ending at `i`.
`dp[i] = nums[i] + max(0, max(dp[i-k] ... dp[i-1]))`.
To find `max` efficiently in range `[i-k, i-1]`, use a Monotonic Deque (decreasing).
Deque stores indices `j` such that `dp[j]` is decreasing.
Remove indices `< i-k` from front.
Current max is `dp[front]`.
Update result.
Push `i` to deque (remove elements <= `dp[i]` from back).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) or O(K).

---

## Analysis / Phân tích

### Approach: Deque Optimization
Standard DP: `dp[i] = nums[i] + max(0, max in previous k)`.
Use `LinkedList` or `ArrayDeque` to maintain the sliding window maximum of the `dp` values.
Deque stores indices.
1. Remove expired indices from head (`idx < i - k`).
2. Get max from head (`dp[head]`). If `dp[head] > 0`, `dp[i] += dp[head]`.
3. Update global max.
4. Insert `i` into deque: remove indices from tail where `dp[tail] <= dp[i]`. Add `i`.
Chuẩn DP: `dp[i] = nums[i] + max(0, max trong k trước đó)`.
Sử dụng `LinkedList` hoặc `ArrayDeque` để duy trì giá trị tối đa của cửa sổ trượt của các giá trị `dp`.
Deque lưu trữ các chỉ số.
1. Xóa các chỉ số đã hết hạn khỏi đầu (`idx < i - k`).
2. Lấy tối đa từ đầu (`dp[head]`). Nếu `dp[head] > 0`, `dp[i] += dp[head]`.
3. Cập nhật tối đa toàn cục.
4. Chèn `i` vào deque: xóa các chỉ số từ đuôi nơi `dp[tail] <= dp[i]`. Thêm `i`.

---

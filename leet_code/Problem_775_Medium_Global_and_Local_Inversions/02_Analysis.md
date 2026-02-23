# Analysis for Global and Local Inversions
# *Phân tích cho bài toán Nghịch thế Toàn cục và Cục bộ*

## 1. Problem Essence & Relationship
## *1. Bản chất vấn đề & Mối quan hệ*

### The Challenge
### *Thách thức*
A local inversion `(i, i+1)` is *always* a global inversion.
Therefore, Global Inversions $\ge$ Local Inversions.
*Một nghịch thế cục bộ `(i, i+1)` *luôn* là một nghịch thế toàn cục. Do đó, Nghịch thế Toàn cục $\ge$ Nghịch thế Cục bộ.*

For them to be equal, there must be **no global inversions that are NOT local inversions**.
*Để chúng bằng nhau, phải **không có nghịch thế toàn cục nào KHÔNG PHẢI là nghịch thế cục bộ**.*

This means we cannot have `i < j` such that `nums[i] > nums[j]` where `j > i + 1`.
Basically, any inversion must be between neighbors.
*Điều này có nghĩa là ta không thể có `i < j` sao cho `nums[i] > nums[j]` với `j > i + 1`. Về cơ bản, mọi nghịch thế phải nằm giữa các phần tử kề nhau.*

---

## 2. Strategy: Running Min/Max or Absolute Position
## *2. Chiến lược: Min/Max Chạy hoặc Vị trí Tuyệt đối*

### Method 1: Running Max
### *Phương pháp 1: Max Chạy*

For every `i`, we must ensure `nums[i]` is not greater than any element `nums[j]` where `j >= i + 2`.
Or simpler: `max(nums[0...i-2])` must be less than `nums[i]`.
*Với mỗi `i`, ta phải đảm bảo `nums[i]` không lớn hơn bất kỳ phần tử `nums[j]` nào với `j >= i + 2`. Hoặc đơn giản hơn: `max(nums[0...i-2])` phải nhỏ hơn `nums[i]`.*

Iterate `i` from 2 to `n-1`. Maintain `max_val` of `nums[0...i-2]`. Check if `max_val > nums[i]`. If so, return false.

### Method 2: Absolute Difference
### *Phương pháp 2: Chênh lệch Tuyệt đối*

Since `nums` is a permutation of `0..n-1`, if we only allow local inversions (swaps of neighbors), an element `x` can only be at index `x-1`, `x`, or `x+1`.
If `abs(nums[i] - i) > 1`, return false.
*Vì `nums` là một hoán vị, nếu chỉ cho phép nghịch thế cục bộ, một phần tử `x` chỉ có thể ở chỉ số `x-1`, `x`, hoặc `x+1`. Nếu `abs(nums[i] - i) > 1`, trả về false.*

Proof intuition: If `nums[i]` is at `i+2`, it had to "jump" over at least two elements, creating a non-local inversion.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Single pass.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**In:** `[1, 0, 2]`
- i=0, v=1. `abs(1-0)=1`. OK.
- i=1, v=0. `abs(0-1)=1`. OK.
- i=2, v=2. `abs(2-2)=0`. OK.
Result: `True`.

**In:** `[1, 2, 0]`
- i=0, v=1. OK.
- i=1, v=2. OK.
- i=2, v=0. `abs(0-2)=2`. Fail.
Result: `False`. (Global inversions: (1,0), (2,0). Local: (2,0). Extra global (1,0) where dist > 1).

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Checking `Math.abs(nums[i] - i) <= 1` is the most elegant solution.
*Kiểm tra `Math.abs(nums[i] - i) <= 1` là giải pháp thanh lịch nhất.*

# Analysis for Minimum Number of K Consecutive Bit Flips
# *Phân tích cho bài toán Số lượng lật bit K liên tiếp Tối thiểu*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Flip sub-arrays of exactly length `k` to turn all elements in a binary array to `1`. Find minimum flips or return `-1`.
*Lật các mảng con có độ dài chính xác là `k` để biến tất cả các phần tử trong mảng nhị phân thành `1`. Tìm số thao tác tối thiểu hoặc trả về `-1`.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- **Greedy approach:** We must read the array from left to right. Whenever we see a `0`, we have no choice but to flip the next `k` elements starting from this position to make it `1`. If we don't flip it now, we can never flip it later without messing up earlier numbers we already fixed.
- **Naïve Simulation is Too Slow:** Physically flipping $K$ bits takes $O(K)$. Doing this at potentially $O(N)$ indices takes $O(N \cdot K)$, pushing $10^{10}$ operations (Time Limit Exceeded).
- **Difference Array / Event Tracking:** Instead of flipping `k` elements, we simply record that a flip *started* at index `i`. This flip affects all elements from `i` up to `i + k - 1`.
- We can track the number of active flips affecting the current index `i`.
- A queue can store the *end indices* of active flips (specifically, the index where the flip *stops* affecting: `i + k - 1`).
- Or, use a boolean array `isFlipped[]` of size $N$ to mark the start of a flip. Track a current `flipCount`. When we reach `i`, check if `i >= k`. If `isFlipped[i - k]` was true, we decrement `flipCount` because that flip no longer affects index `i`.
- We can even optimize the boolean array by modifying the original array `nums` (e.g., adding 2 contextually) to achieve $O(1)$ space.
*Tham lam từ trái qua phải. Khi gặp 0, BẮT BUỘC phải lật mảng bắt đầu từ vị trí đó. Để lật trong $O(1)$ thay vì $O(K)$, ta dùng hàng đợi (queue) để theo dõi các thao tác lật "đang có hiệu lực" ảnh hưởng đến vị trí hiện tại.*

---

## 2. Strategy: Greedy + Sliding Window Tracker
## *2. Chiến lược: Tham lam + Theo dõi Cửa sổ trượt*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Variables:** `flipCount = 0` (current active flips), `result = 0` (total flips), `Deque` or boolean array `isFlipped`.
    *   **Khởi tạo Biến:** Đếm số lần lật hiện tại, tổng số lần lật.*

2.  **Iterate Over `nums`:** For `i = 0` to `N - 1`:
    - Check if a previous flip expired: If `i >= k` and `isFlipped[i - k]` is true, decrement `flipCount`.
    - Determine if we need to flip at `i`:
      - The current state of `nums[i]` is affected by `flipCount`.
      - State = `nums[i] ^ (flipCount % 2)`.
      - If State == 0, we MUST flip.
          - If `i + k > N`, a flip of length `k` is impossible. Return `-1`.
          - Otherwise, `isFlipped[i] = true`, `flipCount++`, `result++`.
    *   **Duyệt mảng:** Cập nhật hiệu lực lật. Kiểm tra giá trị đã lật, nếu bằng 0 thì buộc lật k phần tử tiếp theo.*

3.  **Return:** `result`.
    *   **Trả về:** `result`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] isFlipped = new int[n];
        int currentFlipState = 0;
        int totalFlips = 0;
        
        for (int i = 0; i < n; i++) {
            // Remove the effect of the flip that started k elements ago
            if (i >= k) {
                currentFlipState ^= isFlipped[i - k];
            }
            
            // Current value is nums[i] flipped by currentFlipState
            // If it is 0, we MUST initiate a new flip
            if (nums[i] == currentFlipState) { // Equivalent to nums[i] ^ currentFlipState == 0
                // If there is not enough room for a k-bit flip, return -1
                if (i + k > n) {
                    return -1;
                }
                
                // Record the flip
                isFlipped[i] = 1;
                currentFlipState ^= 1; // Toggle state (0 to 1, or 1 to 0)
                totalFlips++;
            }
        }
        
        return totalFlips;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We make a single pass through the array, performing $O(1)$ operations at each index.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ for the `isFlipped` tracking array. (Can be $O(1)$ by mutating `nums`, e.g., setting `nums[i] += 2` to represent a flip and using modulo behavior).
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

This is a classic line-sweep / difference-array pattern mapped to binary logic (XOR). It elegantly reduces an $O(N \cdot K)$ problem to $O(N)$.
*Đây là mẫu thuật toán quét đường/mảng hiệu số chuẩn hóa áp dụng vào logic nhị phân (phép XOR). Giúp giảm độ phức tạp mạnh mẽ.*

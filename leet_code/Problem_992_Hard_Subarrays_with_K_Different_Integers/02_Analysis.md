# Analysis for Subarrays with K Different Integers
# *Phân tích cho bài toán Mảng con Có K Số nguyên Khác nhau*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Count the exact number of contiguous subarrays that contain exactly `K` distinct integers.
*Đếm số lượng chính xác các mảng con liên tiếp chứa đúng `K` số nguyên phân biệt.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Counting subarrays with *exactly* `K` elements directly using a single sliding window is hard because when the window shrinks, we don't know how many valid subarrays start at the left pointer and end inside the window.
- Instead, use a powerful standard sliding window trick:
  `Exact(K) = AtMost(K) - AtMost(K - 1)`
- `AtMost(K)` is easy to compute. We use a sliding window (Two Pointers).
- As we expand the window `[left, right]`, if the number of distinct elements exceeds `K`, we move `left` until it falls back inside the limit.
- For every valid window `[left, right]`, the number of valid subarrays ending at `right` is exactly `right - left + 1`. We sum these up.
*Kỹ thuật AtMost: Tính chính xác K bằng cách lấy số lượng "Tối đa K" trừ đi "Tối đa K - 1". Tìm Tối đa K cực kỳ dễ bằng phương pháp Cửa sổ trượt (Sliding Window).*

---

## 2. Strategy: Sliding Window (AtMost)
## *2. Chiến lược: Cửa sổ trượt (Tối đa)*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Define `atMost(nums, K)`:**
    - Initialize `count = 0`, `left = 0`.
    - Use a frequency array or hash map `freq` to count element occurrences within the window.
    - Also track `distinctCount`.
    - Loop `right` from 0 to `nums.length - 1`:
      - Add `nums[right]` to `freq`. If `freq[nums[right]] == 1`, increment `distinctCount`.
      - `while (distinctCount > K)`:
        - Decrement `freq[nums[left]]`.
        - If `freq[nums[left]] == 0`, decrement `distinctCount`.
        - Increment `left`.
      - The number of valid subarrays ending at `right` is `right - left + 1`. Add to `count`.
    - Return `count`.
    *   **Hàm AtMost:** Tính số mảng con có tối đa K phần tử.*

2.  **Calculate Exact K:**
    - Call `atMost(nums, k) - atMost(nums, k - 1)`.
    *   **Tính Chính xác K:** Gọi hiệu số của hai hàm AtMost.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    private int atMost(int[] nums, int k) {
        if (k < 0) return 0;
        
        int n = nums.length;
        // Frequency array up to array length (as per constraints nums[i] <= nums.length)
        int[] freq = new int[n + 1];
        int count = 0;
        int left = 0;
        int distinct = 0;
        
        for (int right = 0; right < n; right++) {
            if (freq[nums[right]] == 0) {
                distinct++;
            }
            freq[nums[right]]++;
            
            // Shrink window if more than k distinct elements
            while (distinct > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    distinct--;
                }
                left++;
            }
            
            // All subarrays ending at right and starting from left to right are valid
            count += right - left + 1;
        }
        
        return count;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. `atMost` processes each element at most twice (once entering the window, once exiting). Calling it twice takes $O(N)$ time overall.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ for the frequency array.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The `Exact(K) = AtMost(K) - AtMost(K-1)` trick transforms a hard exact-matching counting problem into two simple standard limit-based sliding window problems.
*Kỹ thuật phân rã Exact(K) = AtMost(K) - AtMost(K-1) biến bài toán đếm chính xác phức tạp thành hai bài toán cửa sổ trượt giới hạn cơ bản phổ biến.*

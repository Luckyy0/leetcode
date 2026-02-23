# Analysis for Binary Subarrays With Sum
# *Phân tích cho bài toán Mảng con Nhị phân Có Tổng Bằng S*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Count contiguous subarrays that sum to `goal`. `nums` contains only 0s and 1s.
*Đếm số mảng con liên tiếp có tổng bằng `goal`. `nums` chỉ chứa 0 và 1.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- This is equivalent to finding subarrays with sum `k`.
- Can be solved using **Prefix Sum + HashMap**: Store frequency of prefix sums. For each current prefix sum `P`, add `count[P - goal]` to answer. $O(N)$ time, $O(N)$ space.
- Since elements are non-negative (0 or 1), can also be solved using **Sliding Window (Two Pointers)**.
- `countSubarraysWithSum(goal)` is tricky with 0s because zeros don't increase the sum, leading to multiple valid windows ending at the same position.
- Trick: `atMost(goal) - atMost(goal - 1)`.
  - `atMost(S)` returns number of subarrays with sum <= S.
  - This is standard sliding window. Expand right, shrink left while sum > S. Add `right - left + 1` to count.
- Alternatively, "Three Pointers": `i_lo`, `i_hi`, `j`.
*Tương đương tìm mảng con có tổng `k`. Dùng Prefix Sum + Map ($O(N)$ không gian) hoặc Sliding Window ($O(1)$ không gian). Sliding Window: `atMost(goal) - atMost(goal - 1)`. `atMost(S)` đếm số mảng con có tổng <= S.*

---

## 2. Strategy: Sliding Window (atMost)
## *2. Chiến lược: Cửa sổ Trượt (atMost)*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Define `atMost(S)`:**
    - If `S < 0`, return 0.
    - `left = 0`, `res = 0`, `sum = 0`.
    - Iterate `right` from 0 to `n`:
        - `sum += nums[right]`.
        - While `sum > S`:
            - `sum -= nums[left]`.
            - `left++`.
        - `res += right - left + 1`.
    - Return `res`.
    *   **Định nghĩa `atMost(S)`:** Đếm số mảng con có tổng <= S. Dùng cửa sổ trượt.*

2.  **Main Logic:**
    - Return `atMost(goal) - atMost(goal - 1)`.
    *   **Logic chính:** Trả về `atMost(goal) - atMost(goal - 1)`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int numSubarraysWithSum(int[] nums, int goal) {
    return atMost(nums, goal) - atMost(nums, goal - 1);
}

private int atMost(int[] nums, int s) {
    if (s < 0) return 0;
    
    int left = 0;
    int res = 0;
    int sum = 0;
    
    for (int right = 0; right < nums.length; right++) {
        sum += nums[right];
        
        while (sum > s) {
            sum -= nums[left];
            left++;
        }
        
        res += right - left + 1;
    }
    
    return res;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Two passes of sliding window.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The `atMost(K) - atMost(K-1)` trick is a powerful pattern for exact-match sliding window problems involving sums of non-negative numbers.
*Kỹ thuật `atMost(K) - atMost(K-1)` là một mẫu mạnh mẽ cho các bài toán cửa sổ trượt khớp chính xác liên quan đến tổng các số không âm.*

# Analysis for Maximum Sum Circular Subarray
# *Phân tích cho bài toán Tổng Mảng con Vòng tròn Lớn nhất*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the maximum sum of a subarray in a circular array.
*Tìm tổng lớn nhất của một mảng con trong một mảng vòng tròn.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- A circular subarray can be:
  1. A normal subarray (consecutive elements in the original array).
  2. A subarray that wraps around (prefix + suffix).
- For case 1: Standard **Kadane's Algorithm** finds the maximum sum subarray.
- For case 2: A wrapped subarray is basically the Total Sum of the array minus a "middle" subarray. To maximize (Total - Middle), we need to **minimize** the Middle subarray sum.
- So, `MaxCircular = max(MaxSubarraySum, TotalSum - MinSubarraySum)`.
- **Corner Case:** If all numbers are negative, `TotalSum - MinSubarraySum` would be `TotalSum - TotalSum = 0` (empty subarray logic), but the problem says non-empty. Also, in the all-negative case, the wrapped sum effectively takes 0 elements (or requires taking all, which is just sum).
- If all numbers are negative, `MaxSubarraySum` will be the maximum single element (e.g., -1). `MinSubarraySum` will be the total sum. `TotalSum - MinSubarraySum` = 0. We should return `MaxSubarraySum` in this case.
*Mảng con vòng tròn có thể là mảng con thường hoặc mảng con bao quanh (tiền tố + hậu tố). Trường hợp 1 dùng Kadane tìm max. Trường hợp 2 tương đương Tổng - Min(Mảng con giữa). Cẩn thận trường hợp tất cả số âm.*

---

## 2. Strategy: Two-Pass Kadane
## *2. Chiến lược: Kadane Hai Lượt*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Iterate:** Calculate `totalSum`, `currMax`, `maxSum`, `currMin`, `minSum`.
    - `currMax`: standard Kadane for max.
    - `currMin`: standard Kadane for min.
    *   **Duyệt:** Tính tổng, max Kadane, min Kadane.*

2.  **Logic:**
    - `maxSum` is the result of normal subarray.
    - `minSum` is the minimum subarray sum.
    - `circularSum = totalSum - minSum`.
    *   **Logic:** `maxSum` là kết quả mảng thường. `circularSum` là kết quả mảng vòng tròn.*

3.  **Check All Negative:**
    - If `maxSum < 0`, it means all numbers are negative (or `maxSum` is the single largest negative number). In this case, wrapped sum implies taking empty middle, which isn't allowed or leads to 0. But valid subarray must be non-empty. The max circular sum is just `maxSum`.
    - Return `max(maxSum, circularSum)` normally, but if `maxSum < 0` return `maxSum`.
    *   **Kiểm tra toàn âm:** Nếu `maxSum < 0`, trả về `maxSum`. Ngược lại trả về `max(maxSum, circularSum)`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int maxSubarraySumCircular(int[] nums) {
    int totalSum = 0;
    int currMax = 0;
    int maxSum = nums[0];
    int currMin = 0;
    int minSum = nums[0];
    
    for (int num : nums) {
        // Calculate max subarray sum using Kadane's
        currMax = Math.max(currMax + num, num);
        maxSum = Math.max(maxSum, currMax);
        
        // Calculate min subarray sum using Kadane's
        currMin = Math.min(currMin + num, num);
        minSum = Math.min(minSum, currMin);
        
        totalSum += num;
    }
    
    // If all numbers are negative, maxSum will be the max element (negative),
    // and circularSum would be 0 (Total - Total). We should return maxSum.
    if (maxSum < 0) {
        return maxSum;
    }
    
    return Math.max(maxSum, totalSum - minSum);
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Single pass.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Calculating both max and min subarray sums in one pass allows checking both the standard case and the wrapped case efficiently.
*Tính toán cả tổng mảng con lớn nhất và nhỏ nhất trong một vòng lặp cho phép kiểm tra cả trường hợp tiêu chuẩn và trường hợp vòng tròn một cách hiệu quả.*

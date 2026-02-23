# Analysis for Minimum Increment to Make Array Unique
# *Phân tích cho bài toán Tăng tối thiểu để Mảng trở nên Duy nhất*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Increment elements to make all unique using minimum total increments.
*Tăng các phần tử để làm tất cả đều duy nhất với tổng số lượng tăng tối thiểu.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Sort the array first.
- If `nums[i] <= nums[i-1]`, it means `nums[i]` is not unique (or smaller than needed).
- To minimize increments, `nums[i]` should become exactly `nums[i-1] + 1`.
- Increment count = `(nums[i-1] + 1) - nums[i]`.
- Update `nums[i]` to `nums[i-1] + 1` for the next comparison.
- This greedy approach works because sorting ensures we satisfy smaller requirements before moving to larger ones.
- Alternatively, use frequency counting (Bucket Sort) since range is small ($10^5$).
  - Count frequencies.
  - If `count[x] > 1`, carry over `count[x] - 1` duplicates to `x + 1`.
  - Add `duplicates` to answer at each step.
*Sắp xếp mảng trước. Nếu `nums[i] <= nums[i-1]`, tăng `nums[i]` lên `nums[i-1] + 1`. Hoặc dùng Đếm tần suất (Bucket Sort).*

---

## 2. Strategy: Sorting
## *2. Chiến lược: Sắp xếp*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Sort:** `Arrays.sort(nums)`.
    *   **Sắp xếp:** `Arrays.sort(nums)`.*

2.  **Iterate:** From `i = 1` to `n - 1`.
    - If `nums[i] <= nums[i-1]`:
    - `diff = nums[i-1] + 1 - nums[i]`.
    - `moves += diff`.
    - `nums[i] = nums[i-1] + 1`.
    *   **Duyệt:** Nếu nhỏ hơn hoặc bằng số trước -> tăng lên.*

3.  **Return:** `moves`.
    *   **Trả về:** `moves`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.Arrays;

public class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                // Determine target value
                int target = nums[i - 1] + 1;
                // Add the difference to moves
                moves += target - nums[i];
                // Update current value
                nums[i] = target;
            }
        }
        
        return moves;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ due to sorting.
    *   **Độ phức tạp thời gian:** $O(N \log N)$.*
*   **Space Complexity:** $O(\log N)$ or $O(N)$ for sorting stack space.
    *   **Độ phức tạp không gian:** $O(\log N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Sorting is the most straightforward approach. Counting sort can be $O(N + K)$ if $K$ is small, but sorting is robust enough here.
*Sắp xếp là cách tiếp cận trực tiếp nhất. Counting sort có thể $O(N + K)$ nhưng sắp xếp đủ tốt.*

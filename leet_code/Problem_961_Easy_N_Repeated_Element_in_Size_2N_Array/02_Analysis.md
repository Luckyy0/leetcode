# Analysis for N-Repeated Element in Size 2N Array
# *Phân tích cho bài toán Phần tử Lặp lại N lần trong Mảng kích thước 2N*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the element that appears $N$ times in an array of size $2N$.
*Tìm phần tử xuất hiện N lần trong mảng kích thước 2N.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The array has $2N$ elements. One element appears $N$ times. The other $N$ elements are unique.
- This means the repeated element occupies half of the array.
- By Pigeonhole Principle, if we pick any small window of elements, the repeated element is very likely to appear multiple times.
- Simpler Logic: Check for duplicates.
- Since only ONE element is repeated (and it's repeated $N$ times), the FIRST number we see twice MUST be the answer.
  - Why? Because all other numbers appear exactly once.
- Algorithm: Use a HashSet to track seen numbers. The first number already in the set is the answer.
- Alternative (O(1) space):
  - Since it appears $N$ times in $2N$ slots, it's very dense.
  - Check `nums[i] == nums[i+1]` or `nums[i] == nums[i+2]` (gap of 1 or 2).
  - Given constraint $N \le 10000$, HashSet is totally fine and easiest.
*Mảng 2N phần tử, 1 phần tử lặp N lần, còn lại duy nhất. Phần tử lặp lại là phần tử DUY NHẤT có bản sao. Chỉ cần tìm phần tử trùng lặp đầu tiên.*

---

## 2. Strategy: HashSet
## *2. Chiến lược: HashSet*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Iterate:** Loop through `nums`.
    *   **Duyệt:** Quét qua mảng.*

2.  **Check Set:**
    - If `set` contains `num`: Return `num`.
    - Else: Add `num` to `set`.
    *   **Kiểm tra Set:** Nếu đã có -> Trả về. Nếu chưa -> Thêm vào.*

3.  **Return:** Should not reach here.
    *   **Trả về:** Không bao giờ đến đây.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1; // Should not happen
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ for HashSet. (Can be $O(1)$ with probabilistic check, but HashSet is robust).
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simply finding the first duplicate is sufficient because the problem guarantees only one element repeats.
*Chỉ cần tìm phần tử trùng lặp đầu tiên là đủ vì đề bài đảm bảo chỉ có một phần tử lặp lại.*

# Analysis for Largest Perimeter Triangle
# *Phân tích cho bài toán Chu vi Tam giác Lớn nhất*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find three numbers $a, b, c$ to maximize $a + b + c$ subject to triangle inequality.
*Tìm 3 số tối đa hóa tổng và thỏa mãn bất đẳng thức tam giác.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Triangle inequality: $a + b > c$ (assuming sorted $a \le b \le c$).
- To maximize $a+b+c$, we want $c$ (largest side) to be as large as possible.
- If we fix $c$ as the largest element, we need the next two largest elements $a, b$ to satisfy $a+b > c$.
- Why next two largest? Because if the sum of the two largest available smaller sides doesn't exceed $c$, no other pair will.
- Strategy:
  1. Sort `nums` descending (or ascending and iterate from end).
  2. Check triplets $(nums[i], nums[i-1], nums[i-2])$ from largest indices.
  3. Since they are sorted, these are the best candidates for a given largest side $nums[i]$.
  4. Condition: `nums[i-2] + nums[i-1] > nums[i]`.
  5. If met, return sum immediately (greedy works).
  6. If loop finishes, return 0.
*Sắp xếp mảng. Duyệt từ các phần tử lớn nhất. Kiểm tra điều kiện tam giác cho bộ ba liên tiếp.*

---

## 2. Strategy: Greedy Sort
## *2. Chiến lược: Sắp xếp Tham lam*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Sort:** `Arrays.sort(nums)`.
    *   **Sắp xếp:** `Arrays.sort`.*

2.  **Iterate:** `i` from `N-1` down to 2.
    - Check if `nums[i-2] + nums[i-1] > nums[i]`.
    - If yes, return sum.
    *   **Duyệt:** Kiểm tra bộ ba lớn nhất.*

3.  **Return:** `0`.
    *   **Trả về:** `0`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.Arrays;

public class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ due to sorting.
    *   **Độ phức tạp thời gian:** $O(N \log N)$.*
*   **Space Complexity:** $O(\log N)$ for sorting stack.
    *   **Độ phức tạp không gian:** $O(\log N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Sorting and checking adjacent triplets is both sufficient and optimal.
*Sắp xếp và kiểm tra bộ ba liền kề là đủ và tối ưu.*

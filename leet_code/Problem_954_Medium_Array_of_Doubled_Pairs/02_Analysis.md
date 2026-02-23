# Analysis for Array of Doubled Pairs
# *Phân tích cho bài toán Mảng các Cặp Đôi Gấp Đôi*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Check if the array can be partitioned into pairs $(x, 2x)$.
*Kiểm tra xem mảng có thể chia thành các cặp $(x, 2x)$ hay không.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Similar to finding pairs, but specifically $y = 2x$.
- Use a Frequency Map to count occurrences of each number.
- Sort the unique numbers by absolute value.
  - Why absolute value? Because for negative numbers, $x$ is "smaller" (closer to 0) than $2x$ if we look at magnitude. e.g., -2 and -4. $|-2| < |-4|$. We want to process -2 first to find -4.
  - Wait, simpler: process based on magnitude.
  - If we sort by absolute value ascending:
    - Smallest magnitude number $x$ MUST be paired with $2x$. It cannot be the $2y$ part of a pair $(y, 2y)$ because $|y| < |x|$ would contradict $x$ being smallest.
    - Example: `[4, -2, 2, -4]`. Sorted absolute: `[-2, 2, 4, -4]` (or `[2, -2, 4, -4]`).
    - Take `2`: need `4`. Remove both.
    - Take `-2`: need `-4`. Remove both.
- Implementation:
  - Count frequencies.
  - Get keys, sort by absolute value.
  - Iterate through keys `x`. If `count[x] > 0`:
    - Check if `count[2*x] >= count[x]`.
    - If so, decrement `count[2*x]` by `count[x]`.
    - Else, return `false`.
*Sắp xếp theo giá trị tuyệt đối. Số nhỏ nhất `x` bắt buộc phải là phần tử nhỏ trong cặp `(x, 2x)`. Dùng Map đếm tần suất.*

---

## 2. Strategy: Sorting by Absolute Value + HashMap
## *2. Chiến lược: Sắp xếp theo Giá trị Tuyệt đối + HashMap*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Count Frequencies:** `Map<Integer, Integer> count`.
    *   **Đếm tần suất:** Dùng Map.*

2.  **Sort Keys:** Get unique elements and sort based on `abs(x)`.
    *   **Sắp xếp khóa:** Theo giá trị tuyệt đối tăng dần.*

3.  **Iterate & Match:** For each `x` in sorted keys:
    - If `count[x] == 0`, skip (already used).
    - Target `target = 2 * x`.
    - Check `count[target]`. If `count[target] < count[x]`, return `false`.
    - `count[target] -= count[x]`.
    *   **Duyệt & Ghép cặp:** Kiểm tra xem có đủ `2*x` cho `x` không.*

4.  **Return:** `true` if loop finishes.
    *   **Trả về:** `true`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : arr) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        
        Integer[] index = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) index[i] = arr[i];
        
        Arrays.sort(index, Comparator.comparingInt(Math::abs));
        
        for (int x : index) {
            if (count.get(x) == 0) continue;
            
            int target = 2 * x;
            if (count.getOrDefault(target, 0) < 1) return false;
            
            count.put(x, count.get(x) - 1);
            count.put(target, count.get(target) - 1);
        }
        
        return true;
    }
}
```
*Wait, iterating through sorted `arr` (converted to Integer for flexible sort) is slightly inefficient ($O(N \log N)$) but simplest to implement. Iterating through sorted distinct keys is better if many duplicates. But given constraints $N \le 30000$, basic sort is fine.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$. Sorting dominates.
    *   **Độ phức tạp thời gian:** $O(N \log N)$.*
*   **Space Complexity:** $O(N)$ for Map and sorting.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Sorting by absolute value is the key to ensure we always process the "smaller" element of a potential pair first.
*Sắp xếp theo giá trị tuyệt đối là chìa khóa để đảm bảo luôn xử lý phần tử "nhỏ hơn" của một cặp tiềm năng trước.*

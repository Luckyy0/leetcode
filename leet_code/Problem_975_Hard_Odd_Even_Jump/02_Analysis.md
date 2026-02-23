# Analysis for Odd Even Jump
# *Phân tích cho bài toán Nhảy Chẵn Lẻ*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find starting indices that can reach the end of the array following specific alternating jump rules.
*Tìm các chỉ số bắt đầu có thể đến được cuối mảng tuân theo quy tắc nhảy xen kẽ.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Jumps depend on values to the right.
- **Odd Jump (1, 3, 5...):** Need smallest value $v \ge arr[i]$ at index $j > i$. Smallest $j$ if tie.
- **Even Jump (2, 4, 6...):** Need largest value $v \le arr[i]$ at index $j > i$. Smallest $j$ if tie.
- This is a "Next Greater Element" problem but based on value order, not just position.
- Since we need to query "smallest >= X" or "largest <= X", a Balanced BST (TreeMap in Java) is perfect.
- Process from right to left (end to start).
  - Why? Because to know if `i` is good, we need to know if `next_jump(i)` is good.
  - `next_jump(i)` is always $> i$. So processing backwards ensures we have the answer for `next_jump(i)`.
- State:
  - `odd[i]`: Can we reach end from `i` starting with an odd jump (1st jump)?
  - `even[i]`: Can we reach end from `i` starting with an even jump (2nd jump)?
- Transitions:
  - `odd[i] = even[next_odd_jump_index]`
  - `even[i] = odd[next_even_jump_index]`
  - Base case: `odd[N-1] = even[N-1] = true`.
- TreeMap stores `Value -> Index`. When iterating backwards, Map contains indices $j > i$.
- `ceilingEntry(arr[i])` gives next odd jump target.
- `floorEntry(arr[i])` gives next even jump target.
*Duyệt ngược từ cuối mảng. Sử dụng TreeMap để tìm đích đến cho bước nhảy lẻ (ceiling) và chẵn (floor). Quy hoạch động trạng thái odd/even.*

---

## 2. Strategy: DP + TreeMap
## *2. Chiến lược: QP + TreeMap*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `N`, `odd[]`, `even[]` arrays (boolean). `odd[N-1] = even[N-1] = true`. `TreeMap`.
    *   **Khởi tạo:** Mảng DP và TreeMap.*

2.  **Iterate Backwards:** `i` from `N-2` down to 0.
    - `val = arr[i]`.
    - **Odd Jump:** `ceiling = map.ceilingEntry(val)`.
      - If exists, `odd[i] = even[ceiling.getValue()]`.
    - **Even Jump:** `floor = map.floorEntry(val)`.
      - If exists, `even[i] = odd[floor.getValue()]`.
    - **Update Map:** `map.put(val, i)`. (Since we iterate backwards, this `i` becomes a future candidate for smaller indices. If value exists, overwriting with smaller index is correct because we want smallest index).
    *   **Duyệt Ngược:** Tìm đích đến và cập nhật trạng thái.*

3.  **Count Good Indices:** Sum of `odd[i]` (since 1st jump is odd).
    *   **Đếm:** Tổng số `odd[i]` là true.*

4.  **Return:** Count.
    *   **Trả về:** Số lượng.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.TreeMap;
import java.util.Map;

public class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return n;
        
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        
        // Base case: End is reachable from itself
        odd[n - 1] = true;
        even[n - 1] = true;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);
        
        int goodIndices = 1; // Last index counts
        
        for (int i = n - 2; i >= 0; i--) {
            int val = arr[i];
            
            // Odd jump: Smallest value >= val
            Map.Entry<Integer, Integer> ceiling = map.ceilingEntry(val);
            if (ceiling != null) {
                // If we make an odd jump, we land at ceiling.getValue()
                // The next jump from there will be even.
                odd[i] = even[ceiling.getValue()];
            }
            
            // Even jump: Largest value <= val
            Map.Entry<Integer, Integer> floor = map.floorEntry(val);
            if (floor != null) {
                // If we make an even jump, we land at floor.getValue()
                // The next jump from there will be odd.
                even[i] = odd[floor.getValue()];
            }
            
            // Update map with current index. 
            // Since we iterate backwards, this index is smaller than any previous occurrence.
            // This satisfies the "smallest index" requirement.
            map.put(val, i);
            
            if (odd[i]) {
                goodIndices++;
            }
        }
        
        return goodIndices;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$. TreeMap operations take $O(\log N)$.
    *   **Độ phức tạp thời gian:** $O(N \log N)$.*
*   **Space Complexity:** $O(N)$. Arrays and Map.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Backwards iteration combines perfectly with TreeMap to resolve "next greater/smaller" queries efficiently while maintaining DP state.
*Duyệt ngược kết hợp hoàn hảo với TreeMap để giải quyết các truy vấn "lớn hơn/nhỏ hơn tiếp theo" một cách hiệu quả trong khi duy trì trạng thái DP.*

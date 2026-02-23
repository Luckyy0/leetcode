# Analysis for Pancake Sorting
# *Phân tích cho bài toán Sắp xếp Bánh kếp*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Sort array using prefix reversals (flips). Max 10*N flips allowed.
*Sắp xếp mảng bằng cách đảo ngược tiền tố. Cho phép tối đa 10*N lần lật.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Standard sorting algorithm: Selection Sort idea.
- Place the largest number in its correct position at the end. Then the second largest, etc.
- To place the largest number `X` (currently at index `i`) to the end (`N-1`):
  1. Flip `k = i + 1`: Moves `X` to the front (index 0).
  2. Flip `k = N`: Moves `X` from front to index `N-1`.
- This takes 2 flips per element.
- Since we do this for $N$ elements, total flips $\approx 2N$.
- This satisfies the $10N$ constraint easily.
*Tìm số lớn nhất, đưa về đầu bằng 1 cú lật, rồi đưa về cuối đúng vị trí bằng 1 cú lật nữa. Giảm kích thước bài toán và lặp lại.*

---

## 2. Strategy: Max Element to End
## *2. Chiến lược: Đưa Phần tử Lớn nhất về Cuối*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Iterate:** `size` from `N` down to 1.
    *   **Duyệt:** Kích thước từ N giảm về 1.*

2.  **Find Max:** Find index `idx` of the value `size` (since values are 1 to N permutation).
    *   **Tìm Max:** Tìm vị trí của giá trị `size`.*

3.  **Check Position:**
    - If `idx == size - 1`: Already in place. Continue.
    - If `idx != 0`:
      - Flip `k = idx + 1`. Add to result. (Max now at 0).
      - Reverse subarray `0` to `idx`.
    - Flip `k = size`. Add to result. (Max now at `size - 1`).
    - Reverse subarray `0` to `size - 1`.
    *   **Kiểm tra Vị trí:** Lật về đầu, rồi lật về cuối.*

4.  **Return:** `result` list.
    *   **Trả về:** Danh sách kết quả.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        
        // Iterate downwards, placing the largest elements first
        for (int value = n; value >= 1; value--) {
            int index = findIndex(arr, value);
            
            // If the element is already at the correct position (index value-1), skip
            if (index == value - 1) {
                continue;
            }
            
            // Step 1: Bring the element to the front (index 0) if it's not already there
            if (index != 0) {
                result.add(index + 1);
                reverse(arr, index);
            }
            
            // Step 2: Bring the element from front to its correct position (value - 1)
            result.add(value);
            reverse(arr, value - 1);
        }
        
        return result;
    }
    
    // Helper to find index of a target value
    private int findIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    // Helper to reverse array from 0 to k
    private void reverse(int[] arr, int k) {
        int i = 0, j = k;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$. Scanning for max element takes $O(N)$, reversing takes $O(N)$, total loop $N$.
    *   **Độ phức tạp thời gian:** $O(N^2)$.*
*   **Space Complexity:** $O(N)$ for result list.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The 2-flip strategy (Move max to front, then to end) is simple and efficient enough ($2N \le 10N$).
*Chiến lược 2 lần lật (Đưa max về đầu, rồi về cuối) đơn giản và đủ hiệu quả.*

# Analysis for Longest Turbulent Subarray
# *Phân tích cho bài toán Mảng con Hỗn loạn Dài nhất*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find longest subarray where comparison signs flip: `> < > <` or `< > < >`.
*Tìm mảng con dài nhất mà dấu so sánh đảo chiều liên tục.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Only consecutive elements matter.
- Let `c[k] = compare(arr[k], arr[k+1])`.
  - `c[k] = 1` if `arr[k] > arr[k+1]`
  - `c[k] = -1` if `arr[k] < arr[k+1]`
  - `c[k] = 0` if `arr[k] == arr[k+1]`
- We want a sequence of `c[k]` where $c[k] \neq 0$ and $c[k] = -c[k-1]$.
- Iterate and maintain current turbulent length.
- If pattern breaks:
  - If equal (`c[k] == 0`), reset length to 1.
  - If redundant (`c[k] == c[k-1]`), length becomes 2 (the current pair is valid, just not extending the previous one).
- Max length is answer.
*Duyệt một lần, so sánh dấu của cặp hiện tại với cặp trước đó. Nếu dấu đảo ngược -> tăng độ dài. Nếu bằng nhau -> reset về 1. Nếu cùng dấu -> reset về 2.*

---

## 2. Strategy: Sliding Window / DP
## *2. Chiến lược: Cửa sổ trượt / QP*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Init:** `maxLen = 1`, `start = 0`.
    *   **Khởi tạo:** `maxLen = 1`, `start = 0`.*

2.  **Iterate:** `i` from 1 to `N-1`.
    - Check compare `c = Integer.compare(arr[i-1], arr[i])`.
    - Compare previous `c_prev = Integer.compare(arr[i-2], arr[i-1])`? Or just track contiguous.
    - Simply: `maxLen` tracks subarray ending at `i`. Or use simple sliding window.
    - If `arr[i-1] == arr[i]`: `start = i`.
    - Else if `i >= 2` and `compare(i-1, i) == compare(i-2, i-1)` (same direction): `start = i - 1`.
    - `maxLen = max(maxLen, i - start + 1)`.
    *   **Duyệt:** Cập nhật vị trí bắt đầu `start` khi vi phạm điều kiện hỗn loạn.*

3.  **Return:** `maxLen`.
    *   **Trả về:** `maxLen`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n == 1) return 1;
        
        int maxLen = 1;
        int start = 0;
        
        for (int i = 1; i < n; i++) {
            int c = Integer.compare(arr[i-1], arr[i]);
            
            if (c == 0) {
                // Equal elements break turbulence completely
                start = i;
            } else if (i >= 2) {
                int prevC = Integer.compare(arr[i-2], arr[i-1]);
                if ((c > 0 && prevC > 0) || (c < 0 && prevC < 0)) {
                    // Same direction, break. New sequence starts at i-1
                    start = i - 1;
                }
            }
            
            // Length is (i - start + 1)
            maxLen = Math.max(maxLen, i - start + 1);
        }
        
        return maxLen;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple linear scan tracking the start of the valid subarray is optimal.
*Quét tuyến tính theo dõi điểm bắt đầu của mảng con hợp lệ là tối ưu.*

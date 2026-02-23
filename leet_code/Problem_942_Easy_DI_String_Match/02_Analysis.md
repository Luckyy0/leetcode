# Analysis for DI String Match
# *Phân tích cho bài toán Khớp chuỗi DI*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Construct a permutation of `0..n` that satisfies 'I' (increase) and 'D' (decrease) relations.
*Xây dựng hoán vị của `0..n` thỏa mãn quan hệ 'I' (tăng) và 'D' (giảm).*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Simple greedy approach works perfectly.
- We have numbers available from `low = 0` to `high = n`.
- If `s[i] == 'I'`, we need `perm[i] < perm[i+1]`.
  - Strategy: Use the smallest available number (`low`) for `perm[i]`. Whatever we pick for `perm[i+1]` later (from remaining `low+1` to `high`) will be larger.
- If `s[i] == 'D'`, we need `perm[i] > perm[i+1]`.
  - Strategy: Use the largest available number (`high`) for `perm[i]`. Whatever we pick for `perm[i+1]` later will be smaller.
- After filling `0..n-1`, one number remains (`low == high`). Put it at the end.
*Cách tiếp cận tham lam đơn giản. Dùng `low` cho 'I' và `high` cho 'D'. Phần tử cuối cùng là số còn lại.*

---

## 2. Strategy: Two Pointers (Greedy)
## *2. Chiến lược: Hai con trỏ (Tham lam)*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `low = 0`, `high = n`, result array `perm` size `n+1`.
    *   **Khởi tạo:** `low`, `high`.*

2.  **Iterate:** `i` from 0 to `n-1`.
    - If `s[i] == 'I'`: `perm[i] = low++`.
    - If `s[i] == 'D'`: `perm[i] = high--`.
    *   **Duyệt:** Điền `low` hoặc `high`.*

3.  **Finalize:** `perm[n] = low`. (Low and High meet here).
    *   **Hoàn tất:** Điền phần tử cuối.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int low = 0;
        int high = n;
        int[] perm = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                perm[i] = low++;
            } else { // s.charAt(i) == 'D'
                perm[i] = high--;
            }
        }
        
        perm[n] = low; // checking loop condition, low == high here
        return perm;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ for result (or $O(1)$ auxiliary).
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Greedy selection ensures constraints for future elements are trivially met.
*Lựa chọn tham lam đảm bảo các ràng buộc cho các phần tử tương lai được đáp ứng một cách hiển nhiên.*

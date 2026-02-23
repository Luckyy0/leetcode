# Analysis for Distinct Subsequences II
# *Phân tích cho bài toán Chuỗi con Riêng biệt II*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Count distinct non-empty subsequences. Modulo $10^9 + 7$.
*Đếm số chuỗi con không rỗng riêng biệt. Modulo $10^9 + 7$.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Let `dp[k]` be sum of distinct subsequences ending with character `k` ('a' to 'z').
- When iterating through string `s`:
  - Current char `c`.
  - We can append `c` to ALL existing distinct subsequences.
  - Plus `c` itself is a new subsequence.
  - BUT, if we have counted subsequences ending in `c` before, we are essentially updating the count.
  - The number of distinct subsequences ending with `c` becomes: `sum(all previous subsequences) + 1` (the `+1` is for `c` alone).
  - Wait, a better state definition:
  - Let `last[char]` be the count of subsequences ending with `char`.
  - Total subsequences so far `S = sum(last)`.
  - When we encounter char `x`:
    - New subsequences ending with `x` will be formed by appending `x` to ALL existing subsequences. That count is `S`.
    - Plus the single character `x` itself. So `S + 1`.
    - So `new_last[x] = S + 1`.
    - All other `last[y]` remain same.
    - Updated `S` will increase by `(S + 1) - old_last[x]`.
- Algorithm:
  - Maintain an array `last[26]` storing counts of subsequences ending with 'a'...'z'.
  - Iterate `c` in `s`.
  - Calculate `total = sum(last)`.
  - `last[c - 'a'] = total + 1`.
  - Finally, return `sum(last) % MOD`.
- Example "aba":
  - Init: `last` all 0.
  - 'a': `total=0`. `last['a'] = 1`. (`a`)
  - 'b': `total=1`. `last['b'] = 1 + 1 = 2`. (`b`, `ab`)
  - 'a': `total=1+2=3`. `last['a'] = 3 + 1 = 4`. (`aa`, `ba`, `aba`, `a`). Note `a` was overwritten. Previous `a` count was 1, new is 4. Added 3.
  - Total: `4 + 2 = 6`. Correct.
*Duyệt qua chuỗi. `last[k]` là số lượng chuỗi con kết thúc bằng ký tự `k`. Tổng số chuỗi con hiện tại là `S`. Khi gặp ký tự `c`, số lượng chuỗi con mới kết thúc bằng `c` là `S + 1`. Cập nhật `last[c]`.*

---

## 2. Strategy: Dynamic Programming (Last Occurrence)
## *2. Chiến lược: Quy hoạch Động (Lần xuất hiện cuối)*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `last[26]` with 0. `MOD = 1e9 + 7`.
    *   **Khởi tạo:** `last[26]` bằng 0.*

2.  **Iterate:** For each char `c` in `s`:
    - Calculate `currentTotal = sum(last) % MOD`.
    - Update `last[c - 'a'] = (currentTotal + 1) % MOD`.
    - Wait, computing sum every time is $O(26 \cdot N)$. Acceptable. Optimization: maintain running total.
    *   **Duyệt:** Tính tổng hiện tại. Cập nhật `last[c]`. Có thể tối ưu bằng cách duy trì tổng chạy.*

3.  **Return:** `sum(last) % MOD`.
    *   **Trả về:** Tổng cuối cùng.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.Arrays;

public class Solution {
    public int distinctSubseqII(String s) {
        long MOD = 1_000_000_007;
        long[] last = new long[26];
        
        for (char c : s.toCharArray()) {
            long total = 0;
            for (long count : last) {
                total = (total + count) % MOD;
            }
            // The number of distinct subsequences ending with 'c' 
            // is (total existing subsequences) + 1 (for 'c' itself).
            last[c - 'a'] = (total + 1) % MOD;
        }
        
        long result = 0;
        for (long count : last) {
            result = (result + count) % MOD;
        }
        
        return (int) result;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot 26) \approx O(N)$.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$ (array of size 26).
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using an array to track counts ending with each character correctly handles duplicates by overwriting the previous count for that character.
*Sử dụng mảng để theo dõi số lượng kết thúc bằng mỗi ký tự xử lý đúng các bản sao bằng cách ghi đè số lượng trước đó cho ký tự đó.*

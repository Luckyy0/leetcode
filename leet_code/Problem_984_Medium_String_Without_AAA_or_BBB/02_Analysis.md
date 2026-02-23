# Analysis for String Without AAA or BBB
# *Phân tích cho bài toán Chuỗi không có AAA hoặc BBB*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Construct a string of length $A+B$ with $A$ 'a's and $B$ 'b's without 'aaa' or 'bbb'.
*Xây dựng chuỗi gồm A chữ 'a' và B chữ 'b' mà không có 'aaa' hoặc 'bbb'.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- We need to place the characters greedily.
- In each step, we have to decide whether to append 'a' or 'b'.
- If the last two characters placed are the same (e.g., 'aa'), we are FORCED to place the other character ('b') next to avoid 'aaa'.
- If we are not forced by the last two characters, we should place the character that has the larger remaining count. This prevents running out of one character while too many of the other remain (which would end up forcing 'aaa' or 'bbb' later).
- E.g., if $A > B$, we prefer placing 'a'.
- This greedy choice guarantees a valid string if one exists (and the problem states it always does).
*Chiến lược tham lam: Ưu tiên chọn ký tự còn lại nhiều hơn, TRỪ KHI 2 ký tự cuối cùng vừa thêm đã giống ký tự đó (thì bắt buộc phải chọn ký tự còn lại).*

---

## 2. Strategy: Greedy Construction
## *2. Chiến lược: Xây dựng Tham lam*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `StringBuilder sb`.
    *   **Khởi tạo:** Đối tượng `StringBuilder`.*

2.  **Loop:** While `a > 0` or `b > 0`.
    - Check length of `sb`. Let it be `L`.
    - If `L >= 2` and `sb.charAt(L-1) == sb.charAt(L-2)`:
      - We are forced to pick the opposite character.
      - If last character was 'b', append 'a' and `a--`.
      - If last character was 'a', append 'b' and `b--`.
    - Else (we are free to choose):
      - We pick the character with the maximum remaining count.
      - If `a >= b`, append 'a' and `a--`.
      - Else, append 'b' and `b--`.
    *   **Vòng lặp:** Quyết định thêm 'a' hay 'b' dựa trên 2 ký tự cuối và số lượng còn lại.*

3.  **Return:** `sb.toString()`.
    *   **Trả về:** Chuỗi kết quả.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        
        while (a > 0 || b > 0) {
            int len = sb.length();
            boolean writeA = false;
            
            // Check if we are forced to write the opposite character
            if (len >= 2 && sb.charAt(len - 1) == sb.charAt(len - 2)) {
                if (sb.charAt(len - 1) == 'b') {
                    writeA = true;
                }
            } else {
                // Not forced, so write the one with the larger remaining count
                if (a >= b) {
                    writeA = true;
                }
            }
            
            if (writeA) {
                sb.append('a');
                a--;
            } else {
                sb.append('b');
                b--;
            }
        }
        
        return sb.toString();
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(A + B)$. We iterate exactly $A + B$ times.
    *   **Độ phức tạp thời gian:** $O(A + B)$.*
*   **Space Complexity:** $O(A + B)$ to store the result in StringBuilder.
    *   **Độ phức tạp không gian:** $O(A + B)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The greedy approach is intuitive, safe, and guarantees an optimal solution efficiently without backtracking.
*Phương pháp tham lam rất trực quan, an toàn và đảm bảo giải pháp tối ưu một cách hiệu quả mà không cần quay lui.*

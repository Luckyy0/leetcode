# Analysis for Numbers With Same Consecutive Differences
# *Phân tích cho bài toán Các Số có Hiệu Liên tiếp Giống nhau*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find all numbers of length $N$ where adjacent digits differ by $K$.
*Tìm tất cả các số có độ dài N mà các chữ số liền kề chênh nhau K.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- We can construct the numbers digit by digit.
- Start with leading digits 1 to 9 (since no leading zeros, unless N=1, but N>=2 here).
- If current last digit is `d`, the next digit can be `d + k` or `d - k`.
- Check if `0 <= next_digit <= 9`.
- Perform DFS or BFS to build numbers up to length $N$.
- Special case: If `k = 0`, then `d + k` and `d - k` are the same. Check to avoid duplicates in BFS/DFS.
- Constraint $N \le 9$, so result fits in Integer.
*Duyệt DFS hoặc BFS từ các chữ số đầu tiên 1-9. Nếu chữ số cuối là d, chữ số tiếp theo là d+k hoặc d-k.*

---

## 2. Strategy: BFS
## *2. Chiến lược: BFS*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Queue:** Add digits 1 to 9.
    *   **Khởi tạo Queue:** Thêm 1-9.*

2.  **Level-by-Level:** Loop `N-1` times.
    - At each level, process all numbers in queue.
    - For each `num`, get `lastDigit = num % 10`.
    - Try `nextDigit1 = lastDigit + k`. If valid, add `num * 10 + nextDigit1`.
    - Try `nextDigit2 = lastDigit - k`. If valid and distinct from `nextDigit1` (i.e., `k != 0`), add `num * 10 + nextDigit2`.
    *   **Theo từng mức:** Mở rộng số thêm 1 chữ số.*

3.  **Return:** Queue contents converted to array.
    *   **Trả về:** Nội dung queue.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        if (n == 1) return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        List<Integer> currentLevel = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            currentLevel.add(i);
        }
        
        for (int level = 1; level < n; level++) {
            List<Integer> nextLevel = new ArrayList<>();
            for (int num : currentLevel) {
                int lastDigit = num % 10;
                
                // Option 1: lastDigit + k
                int nextDigit1 = lastDigit + k;
                if (nextDigit1 >= 0 && nextDigit1 <= 9) {
                    nextLevel.add(num * 10 + nextDigit1);
                }
                
                // Option 2: lastDigit - k
                if (k > 0) { // Avoid duplicates when k=0
                    int nextDigit2 = lastDigit - k;
                    if (nextDigit2 >= 0 && nextDigit2 <= 9) {
                        nextLevel.add(num * 10 + nextDigit2);
                    }
                }
            }
            currentLevel = nextLevel;
        }
        
        int[] result = new int[currentLevel.size()];
        for (int i = 0; i < currentLevel.size(); i++) {
            result[i] = currentLevel.get(i);
        }
        return result;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(2^N)$. In worst case (k=1), numbers branch by 2 at each step.
    *   **Độ phức tạp thời gian:** $O(2^N)$.*
*   **Space Complexity:** $O(2^N)$ to store results.
    *   **Độ phức tạp không gian:** $O(2^N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

BFS is intuitive for constructing numbers by length. Handled the `k=0` duplicate case and `N=1` edge case (though constraints say N>=2).
*BFS trực quan để xây dựng số theo độ dài. Xử lý trường hợp k=0 trùng lặp.*

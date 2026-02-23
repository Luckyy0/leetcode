# Analysis for Numbers At Most N Given Digit Set
# *Phân tích cho bài toán Các Số Nhỏ Nhất N Được Cho Bởi Tập Hợp Chữ Số*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Count positive integers $\le N$ composed only of digits from a given set $D$.
*Đếm số lượng số nguyên dương $\le N$ được tạo thành chỉ từ các chữ số trong tập $D$.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Let $S$ be the string representation of $N$. Let $K$ be the number of digits in $S$.
- Any number with **fewer than K digits** is strictly less than $N$.
  - For length $L < K$, we can choose any digit from $D$ for each of the $L$ positions.
  - Total count for length $L$: $|D|^L$.
  - Sum these up for $L = 1$ to $K-1$.
- For numbers with **exactly K digits**, we need to be careful. We iterate from the most significant digit (index 0) to the least.
  - Let current digit of $N$ be $d = S[i]$.
  - For each digit $x \in D$:
    - If $x < d$: We can place $x$ at index $i$, and for all remaining $K-1-i$ positions, we can pick any digit. Total: $|D|^{K-1-i}$.
    - If $x == d$: We place $x$ and move to the next position $i+1$.
    - If $x > d$: We can't place $x$ here because the resulting number would exceed $N$. We stop checking this position.
  - If we finish processing all digits of $N$ and find exact matches all the way, it means $N$ itself is valid. We add 1.

*Gọi $S$ là chuỗi biểu diễn của $N$, $K$ là độ dài của $S$. Bất kỳ số nào có ít hơn $K$ chữ số đều nhỏ hơn $N$. Tổng số lượng là $\sum |D|^L$. Với các số có đúng $K$ chữ số, ta duyệt từ trái sang phải. Nếu chọn chữ số $x < S[i]$, ta có thể điền tùy ý các vị trí còn lại. Nếu chọn $x == S[i]$, ta tiếp tục xét vị trí tiếp theo. Nếu $x > S[i]$, dừng lại. Nếu duyệt hết mà vẫn khớp, cộng thêm 1 (chính là $N$).*

---

## 2. Strategy: Digit DP / Mathematical Counting
## *2. Chiến lược: Quy hoạch Động Chữ số / Đếm Toán học*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Preparation:** Convert $N$ to string $S$. Let $K = S.length()$. Let $M = digits.length$.
    *   **Chuẩn bị:** Chuyển $N$ sang chuỗi $S$. $K$ là độ dài, $M$ là số lượng chữ số cho phép.*

2.  **Count Shorter Numbers:**
    - `ans = 0`.
    - For `len` from 1 to `K-1`: `ans += pow(M, len)`.
    *   **Đếm số ngắn hơn:** Cộng dồn lũy thừa của $M$ cho các độ dài nhỏ hơn $K$.*

3.  **Count Same Length Numbers:**
    - Iterate `i` from 0 to `K-1`.
    - `hasSame = false`.
    - For each `digit` in `digits`:
        - If `digit < S[i]`: `ans += pow(M, K-1-i)`.
        - If `digit == S[i]`: `hasSame = true`, break loop (move to next `i`).
        - If `digit > S[i]`: break inner loop immediately (sorted digits).
    - If `!hasSame`, we cannot form the prefix matching $N$, so return `ans` immediately.
    *   **Đếm số cùng độ dài:** Duyệt từng vị trí. Với mỗi chữ số cho phép: nhỏ hơn -> cộng tổ hợp; bằng -> tiếp tục; lớn hơn -> dừng. Nếu không tìm thấy chữ số bằng, dừng toàn bộ.*

4.  **Final Check:** If loop finishes (all digits matched), `ans += 1` (for $N$ itself).
    *   **Kiểm tra cuối:** Nếu vòng lặp kết thúc, cộng 1.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int atMostNGivenDigitSet(String[] digits, int n) {
    String s = String.valueOf(n);
    int k = s.length();
    int m = digits.length;
    int ans = 0;
    
    // 1. Count numbers with fewer digits
    for (int i = 1; i < k; i++) {
        ans += Math.pow(m, i);
    }
    
    // 2. Count numbers with same number of digits
    for (int i = 0; i < k; i++) {
        boolean hasSame = false;
        int currentDigit = s.charAt(i) - '0';
        
        for (String dStr : digits) {
            int d = Integer.parseInt(dStr);
            if (d < currentDigit) {
                ans += Math.pow(m, k - 1 - i);
            } else if (d == currentDigit) {
                hasSame = true;
                break; // Move to next position
            } else {
                // d > currentDigit
                break; 
            }
        }
        
        if (!hasSame) return ans;
    }
    
    return ans + 1;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N \cdot |D|)$. Since $\log N \le 10$ and $|D| \le 9$, this is extremely fast.
    *   **Độ phức tạp thời gian:** $O(\log N \cdot |D|)$. Rất nhanh.*
*   **Space Complexity:** $O(\log N)$ to store the string representation of $N$.
    *   **Độ phức tạp không gian:** $O(\log N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Splitting the problem into "fewer digits" and "same digits" simplifies the logic significantly. The "same digits" part is a classic prefix-matching problem.
*Chia bài toán thành "ít chữ số hơn" và "cùng số chữ số" giúp đơn giản hóa logic đáng kể. Phần "cùng số chữ số" là một bài toán khớp tiền tố cổ điển.*

# Analysis for Rotated Digits
# *Phân tích cho bài toán Các chữ số Xoay*

## 1. Problem Essence & Digit Checking
## *1. Bản chất vấn đề & Kiểm tra Chữ số*

### The Challenge
### *Thách thức*
A number is Good if:
1.  All digits are valid: {0, 1, 8, 2, 5, 6, 9}. (No {3, 4, 7}).
2.  At least one digit causes a change: {2, 5, 6, 9}.
    - If all digits are {0, 1, 8}, the number is unchanged, so not Good.
*Một số là Tốt nếu: Tất cả chữ số đều hợp lệ và có ít nhất một chữ số gây thay đổi {2, 5, 6, 9}. Nếu toàn bộ là {0, 1, 8}, số không đổi, nên không Tốt.*

---

## 2. Strategy: Brute Force or DP
## *2. Chiến lược: Duyệt trâu hoặc Quy hoạch động (DP)*

### Method 1: Check Each Number (O(N log N))
### *Phương pháp 1: Kiểm tra Từng số*
Traverse from 1 to N. Convert to string or check digits.
Check valid digits. Track if we saw a "change" digit.
If valid and changed, count++.
Given $N \le 10000$, $10000 \times 4 \approx 40000$ operations. Very fast.
*Duyệt từ 1 đến N. Kiểm tra chữ số. Nếu hợp lệ và có thay đổi, tăng biến đếm. Với N nhỏ, cách này đủ nhanh.*

### Method 2: DP (Digit DP)
### *Phương pháp 2: Quy hoạch động Chữ số*
For $N$ very large (e.g. $10^9$), need digit DP.
State: `(index, isLess, changesFound)`.
Count numbers with valid digits s.t. `changesFound` is true.
*Với N rất lớn, cần DP. Trạng thái: `(index, isLess, changesFound)`.*

Since $N=10000$, simple digit check is fine.

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public int rotatedDigits(int n) {
    int count = 0;
    for (int i = 1; i <= n; i++) {
        if (isValid(i)) count++;
    }
    return count;
}

boolean isValid(int x) {
    boolean diff = false;
    while (x > 0) {
        int d = x % 10;
        if (d == 3 || d == 4 || d == 7) return false; // Invalid
        if (d == 2 || d == 5 || d == 6 || d == 9) diff = true;
        x /= 10;
    }
    return diff;
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ (since `log N` is digits count).
    *   **Độ phức tạp thời gian:** $O(N \log N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**N = 10**
- 1: {1}. No change. Bad.
- 2: {2}. Change. **Good**.
- 3: {3}. Invalid. Bad.
- 4: {4}. Invalid. Bad.
- 5: {5}. Change. **Good**.
- 6: {6}. Change. **Good**.
- 7: {7}. Invalid.
- 8: {8}. No change.
- 9: {9}. Change. **Good**.
- 10: {1, 0}. No change.
**Result:** 4.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Simple iterative check is sufficient.
*Kiểm tra lặp đơn giản là đủ.*

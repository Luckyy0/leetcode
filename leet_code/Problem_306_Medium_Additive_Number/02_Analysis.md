# Analysis for Additive Number
# *Phân tích cho bài toán Số Cộng*

## 1. Problem Essence & Exhaustive Search (First Two Digits)
## *1. Bản chất vấn đề & Tìm kiếm Toàn diện (Hai số đầu)*

### The Determinism
### *Tính tất định*
Once first two numbers `n1` and `n2` are chosen, the entire sequence is fixed.
`n3 = n1 + n2`, `n4 = n2 + n3`, ...
We just need to check if the string matches this generated sequence.

### Strategy: Iterate lengths of n1 and n2
### *Chiến lược: Lặp độ dài của n1 và n2*
Length of string N <= 35.
Loop `i` (len of n1) from 1 to `N/2`.
Loop `j` (len of n2) from 1 to `(N-i)/2`? Note: `2nd number` starts at index `i`.
Restrictions:
- No leading zeros for n1 (unless "0") and n2 (unless "0").
- `max(len1, len2) <= len3`. Sum of lengths > N is invalid start.

### Handling Large Numbers
### *Xử lý số lớn*
Input length 35 means numbers won't fit in `long` (19 digits).
Actually 35 digits total. Maybe `long` works if `n1, n2` are small? If `n1` is 17 digits, `n2` 18 digits.
But wait, Java `BigInteger` handles arbitrary precision. Or `Long` if we assume split is reasonably balanced.
35 split into 3 numbers: 11, 11, 13 digits. `Long` holds ~19 digits.
So `Long` is sufficient for checking sum! The sum of two 18-digit numbers is 18 or 19 digits.
If we reach >19 digits, it implies we have fewer than 3 numbers, which is handled.
Constraint says "at least three numbers".
So `Long` is definitely enough because even if we split `35` by 3, max len is `12`.
Wait, what if `1` and `1` and `rest`? `rest` is 33 chars.
It fails immediately `1 + 1 != 2...`.
What if `1, 2, ... very long`?
The longest valid number could be around `N/2` (approx 17 digits).
So `Long` works. `BigInteger` is safer but slower. I will use `Long`. Actually `BigInteger` for safety doesn't hurt logic clarity.

---

## 2. Approach: Iterative check
## *2. Hướng tiếp cận: Kiểm tra lặp*

### Logic
### *Logic*
1.  Loop `i` (end index of first num) from 0 to `n/2`.
2.  Loop `j` (end index of second num) from `i+1` to `n-1`.
    - Extract `s1 = num[0...i]`.
    - Extract `s2 = num[i+1...j]`.
    - Check leading zeros: `s1.len > 1 && s1[0]=='0'` -> Break. Same for `s2`.
    - Call `isValid(s1, s2, remainingStr)`.

### Helper `isValid`
### *Hàm trợ giúp `isValid`*
While `remaining` is not empty:
- `sum = n1 + n2`.
- `sumStr = toString(sum)`.
- If `!remaining.startsWith(sumStr)`: return False.
- Update `n1 = n2`, `n2 = sum`. Advance `remaining` index.
Return True.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Fixed Sequence:** The "domino effect" means we only branch at the very beginning.
    *Chuỗi cố định: "Hiệu ứng domino" nghĩa là chúng ta chỉ phân nhánh ngay từ đầu.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^3)$. Two loops $O(N^2)$, string check $O(N)$.
    *Độ phức tạp thời gian: $O(N^3)$.*
*   **Space Complexity:** $O(N)$ for substrings.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** "112358"
i=0 ("1"), j=1 ("1"). Next need "2". Found "2".
Next need "3". Found "3".
Next need "5". Found "5".
Next need "8". Found "8". End. Return True.

**Input:** "199100199"
i=0 ("1"), j=1 ("9"). Need "10". Found "9". Fail.
...
i=0 ("1"), j=2 ("99"). Need "100". Found "100".
Next need "199". Found "199". Return True.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Straightforward simulation. use `Long` or `BigInteger`.
*Mô phỏng trực tiếp. Sử dụng `Long` hoặc `BigInteger`.*
---
*Đôi khi tương lai (số tiếp theo) hoàn toàn được định hình bởi quá khứ gần (hai số trước). Nếu bạn chọn sai điểm bắt đầu, cả chuỗi sẽ sai lệch.*
Sometimes the future (next number) is entirely shaped by the recent past (two previous numbers). If you choose the wrong starting point, the whole sequence will be off.

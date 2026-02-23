# Analysis for Find the Difference
# *Phân tích cho bài toán Tìm sự Khác biệt*

## 1. Problem Essence & Bitwise Elimination
## *1. Bản chất vấn đề & Triệt tiêu Bitwise*

### The Challenge
### *Thách thức*
Identifying a single extra character added to a shuffled version of a known string.

### Strategy 1: XOR (Bit Manipulation)
### *Chiến lược 1: XOR (Thao tác Bit)*
The XOR operation has the property that $x \oplus x = 0$ and $x \oplus 0 = x$.
If we XOR all characters from both strings `s` and `t` together, every character that appears in both will cancel itself out. The final result will be the extra character.

### Strategy 2: Char Sum Difference
### *Chiến lược 2: Hiệu tổng ký tự*
Calculate the sum of ASCII values of all characters in `t` and subtract the sum of ASCII values of all characters in `s`. The difference is the ASCII value of the added character.

---

## 2. Approach: Bitwise XOR
## *2. Hướng tiếp cận: Bitwise XOR*

### Logic
### *Logic*
(See Strategy 1 above). It's elegant and avoids any issues with integer overflow that could theoretically occur with very large strings in the sum approach (though not here due to constraints).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Complexity:** Linear pass through both strings.
    *Hiệu quả O(N): Duyệt qua cả hai chuỗi một cách tuyến tính.*
*   **O(1) Space:** only one variable needed to store the XOR result.
    *Không gian O(1): Chỉ cần một biến để lưu kết quả XOR.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ where $N$ is the length of string `t`.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**s:** `abc`, **t:** `bacd`
1. `res = 0`.
2. XOR characters in `s`: `res ^= 'a' ^ 'b' ^ 'c'`.
3. XOR characters in `t`: `res ^= 'b' ^ 'a' ^ 'c' ^ 'd'`.
Grouping: `('a'^'a') ^ ('b'^'b') ^ ('c'^'c') ^ 'd'` = `0 ^ 0 ^ 0 ^ 'd'` = `'d'`.
Result: 'd'.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Bitwise XOR.
*Bitwise XOR.*
---
*Trong cuộc sống, sự khác biệt (the difference) thường bị che lấp bởi những thứ quen thuộc (shuffled string). Nhưng nếu chúng ta biết cách "triệt tiêu" những gì đã biết (XORing mutual elements), bản chất thật sự của điều mới mẻ sẽ tự động hiện ra một cách rõ ràng nhất.*
In life, the difference is often hidden by familiar things (shuffled string). But if we know how to "eliminate" what is known (XORing mutual elements), the true nature of the new thing will automatically emerge most clearly.

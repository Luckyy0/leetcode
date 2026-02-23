# Analysis for Add Digits
# *Phân tích cho bài toán Cộng các chữ số*

## 1. Problem Essence & Digital Root
## *1. Bản chất vấn đề & Căn số*

### The Naive Way
### *Cách ngây thơ*
Loop while `num >= 10`:
  Sum digits.
  Update num.
Complexity: $O(\log n)$ per iteration. Number of iterations applies $\log$. Very fast actually.
*Cách dùng vòng lặp rất nhanh, nhưng có cách nhanh hơn.*

### The Math Way (Digital Root)
### *Cách toán học (Căn số)*
This is knowing as the **Digital Root** property.
$num \equiv sum\_of\_digits(num) \pmod 9$
Why?
$10^k \equiv 1 \pmod 9$.
$a_n \cdot 10^n + ... + a_0 \cdot 10^0 \equiv a_n \cdot 1 + ... + a_0 \cdot 1 \pmod 9$.
So `num % 9` gives the digital root... almost.

Cases:
- `num = 0` -> 0.
- `num = 9` -> `9 % 9 = 0`, but expected 9 (sum digit of 9 is 9).
- `num = 18` -> `18 % 9 = 0`, expected 9.
- `num = 38` -> `38 % 9 = 2`, expected 2.

Formula:
If `num == 0`: return 0.
If `num % 9 == 0`: return 9.
Else: return `num % 9`.

Unified formula: `1 + (num - 1) % 9`.

---

## 2. Approach: O(1) Math
## *2. Hướng tiếp cận: Toán học O(1)*

### Logic
### *Logic*
`return num == 0 ? 0 : 1 + (num - 1) % 9;`

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Congruence modulo 9:** Exploits base-10 number properties.
    *Đồng dư module 9: Khai thác tính chất số hệ thập phân.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$.
    *Độ phức tạp thời gian: $O(1)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 38
`(38 - 1) % 9` = `37 % 9` = `1` (because $36=4*9$).
`1 + 1 = 2`. Correct.

**Input:** 9
`(9 - 1) % 9` = `8 % 9` = `8`.
`1 + 8 = 9`. Correct.

**Input:** 18
`(18 - 1) % 9` = `17 % 9` = `8`.
`1 + 8 = 9`. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Cool math trick. Should know for trivia. Loop is fine too.
*Mẹo toán thú vị. Nên biết để đố vui. Vòng lặp cũng ổn.*
---
*Cuối cùng, mọi con số phức tạp đều quy về bản chất đơn giản nhất (1 chữ số). Vấn đề lớn bắt nguồn từ những hạt nhân nhỏ.*
Ultimately, every complex number reduces to its simplest essence (1 digit). Big problems stem from small nuclei.

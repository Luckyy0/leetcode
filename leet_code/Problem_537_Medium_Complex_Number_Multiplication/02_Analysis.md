# Analysis for Complex Number Multiplication
# *Phân tích cho bài toán Nhân Số Phức*

## 1. Problem Essence & Math Formula
## *1. Bản chất vấn đề & Công thức Toán học*

### The Challenge
### *Thách thức*
Parsing string `"a+bi"` and implementing `(a+bi)(c+di)`.

### Strategy: Split and Calculate
### *Chiến lược: Tách và Tính toán*

1.  **Formula:** `(a + bi) * (c + di) = ac + adi + bci + bidi = (ac - bd) + (ad + bc)i`.
    - Real part: `ac - bd`.
    - Imaginary part: `ad + bc`.
2.  **Parse:** Split string by `+` and remove `i`. Parse integers.

---

## 2. Approach: String Manipulation
## *2. Hướng tiếp cận: Thao tác Chuỗi*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Simple Math:** Direct application of algebraic expansion.
    *Toán học đơn giản: Áp dụng trực tiếp khai triển đại số.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ (Fixed length strings).
    *Độ phức tạp thời gian: $O(1)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `1+1i`, `1+1i`
1. `a=1, b=1`. `c=1, d=1`.
2. Real: `1*1 - 1*1 = 0`.
3. Imag: `1*1 + 1*1 = 2`.
4. Output: `0+2i`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Split strings, parse ints, apply formula `(ac-bd) + (ad+bc)i`.
*Tách chuỗi, phân tích số nguyên, áp dụng công thức `(ac-bd) + (ad+bc)i`.*
---
*Số ảo (imaginary) kết hợp với số thực (real) tạo nên một thế giới phức hợp (complex). Nhưng quy luật vận hành của chúng (multiplication) vẫn tuân theo những logic đại số chặt chẽ. Đừng để vẻ ngoài phức tạp đánh lừa, hãy tách chúng ra từng phần để nhìn rõ bản chất.*
Imaginary numbers combined with Real numbers create a Complex world. But their operating rules (Multiplication) still follow strict algebraic logic. Don't let the complex appearance deceive you, separate them into parts to see the essence clearly.

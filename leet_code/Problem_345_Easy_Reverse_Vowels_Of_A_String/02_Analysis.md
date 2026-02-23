# Analysis for Reverse Vowels of a String
# *Phân tích cho bài toán Đảo ngược Nguyên âm của một Chuỗi*

## 1. Problem Essence & Two Pointers
## *1. Bản chất vấn đề & Hai Con trỏ*

### The Challenge
### *Thách thức*
Swap vowels `a, e, i, o, u` (case insensitive) while keeping others in place.

### Strategy: Two Pointers
### *Chiến lược: Hai Con trỏ*
`left` moves right until vowel found.
`right` moves left until vowel found.
If `left < right`, swap.
Repeat.

### Set/String for Vowels
### *Tập hợp/Chuỗi cho Nguyên âm*
Fast lookup using `Set` or checking `indexOf` in string "aeiouAEIOU".

---

## 2. Approach: Two Pointers
## *2. Hướng tiếp cận: Hai Con trỏ*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Time:** Single pass.
    *Thời gian O(N): Một lần duyệt.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ for char array conversion (Java strings are immutable).
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** "hello"
L at h (no). L at e (yes).
R at o (yes).
Swap e, o -> "holle".
L at l (no). L at l (no). L at e (L>R?).
Stop.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Two pointers with vowel check.
*Hai con trỏ với kiểm tra nguyên âm.*
---
*Nguyên âm (vowels) là linh hồn của ngôn ngữ. Đảo ngược chúng là thay đổi cảm xúc của câu nói, nhưng khung xương (phụ âm) vẫn giữ nguyên.*
Vowels are the soul of language. Reversing them changes the emotion of the sentence, but the skeleton (consonants) remains the same.

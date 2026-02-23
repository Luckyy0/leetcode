# Analysis for Strobogrammatic Number
# *Phân tích cho bài toán Số Strobogrammatic*

## 1. Problem Essence & Valid Pairs
## *1. Bản chất vấn đề & Các cặp hợp lệ*

### Rotatable Digits
### *Các chữ số có thể xoay*
- `0` becomes `0`.
- `1` becomes `1`.
- `6` becomes `9`.
- `8` becomes `8`.
- `9` becomes `6`.
- `2, 3, 4, 5, 7` become invalid.

### The Check
### *Kiểm tra*
For a string to be strobogrammatic:
- The first char must rotate to the last char.
- The second char must rotate to the second-to-last char.
- Middle char (if any) must rotate to itself (`0`, `1`, `8`).
*Ký tự đầu phải xoay thành ký tự cuối. Ký tự giữa phải tự xoay thành chính nó.*

---

## 2. Approach: Two Pointers
## *2. Hướng tiếp cận: Hai con trỏ*

### Logic
### *Logic*
1.  Initialize `left = 0`, `right = n - 1`.
2.  While `left <= right`:
    - `c1 = num[left]`, `c2 = num[right]`.
    - Check if pair `(c1, c2)` is valid.
    - Valid pairs: `(0,0), (1,1), (8,8), (6,9), (9,6)`.
    - If not valid, return `false`.
    - `left++`, `right--`.
3.  Return `true`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Symmetry:** We leverage the symmetric nature of the problem.
    *Tính đối xứng: Khai thác bản chất đối xứng của vấn đề.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** "69"
- Left '6', Right '9'. Pair (6, 9) valid? Yes.
- Move pointers. Loop ends. True.

**Input:** "692"
- Left '6', Right '2'. Pair (6, 2) valid? No. False.

**Input:** "818"
- Left '8', Right '8'. Valid.
- Mid '1'. Pair (1, 1). Valid? Yes.
- True.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Simple mapping check.
*Kiểm tra ánh xạ đơn giản.*
---
*6 và 9 là đôi tri kỷ, nhìn ngược lại thì thấy nhau. Nhưng 8 và 1 thì tự soi gương cũng thấy chính mình.*
6 and 9 are soulmates, seeing each other when flipped. But 8 and 1 see themselves in the mirror.

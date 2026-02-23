# Analysis for Palindrome Permutation
# *Phân tích cho bài toán Hoán vị Palindrome*

## 1. Problem Essence & Character Counts
## *1. Bản chất vấn đề & Đếm ký tự*

### Properties of Palindrome
### *Tính chất của Palindrome*
A string can form a palindrome if and only if **at most one character** appears an odd number of times.
- "abba" -> 'a':2, 'b':2. (0 odd). True.
- "aba" -> 'a':2, 'b':1. (1 odd). True.
- "code" -> 'c':1, 'o':1, 'd':1, 'e':1. (4 odd). False.

### Strategy
### *Chiến lược*
Count frequencies of all characters.
Count how many characters have odd frequencies.
Return `odd_count <= 1`.

---

## 2. Approach: HashSet / Array
## *2. Hướng tiếp cận: HashSet / Mảng*

### Logic
### *Logic*
1.  Use `Set`.
2.  Iterate char `c` in `s`:
    - If `set` contains `c`, remove it (pair found).
    - Else, add `c`.
3.  Finally, `set.size() <= 1`.
    - If size is 0, all pairs.
    - If size is 1, one separate char (center).
    - If size > 1, impossible.

Alternatively, use `int[26]` array for counts.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Set Toggle:** Adding/Removing acts like a bit toggle. Very efficient.
    *Set Toggle: Thêm/Xóa hoạt động như bật tắt bit. Rất hiệu quả.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$ (limit 26 chars) or $O(N)$ (if unicode).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** "carerac"
1.  'c': Add. Set {c}.
2.  'a': Add. Set {c, a}.
3.  'r': Add. Set {c, a, r}.
4.  'e': Add. Set {c, a, r, e}.
5.  'r': Remove. Set {c, a, e}.
6.  'a': Remove. Set {c, e}.
7.  'c': Remove. Set {e}.
Size 1. True.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Set logic is cleaner than array counting.
*Logic Set gọn hơn đếm mảng.*
---
*Sự cân bằng hoàn hảo (palindrome) cho phép tối đa một sự khác biệt (odd count). Quá nhiều sự khác biệt sẽ phá vỡ sự đối xứng.*
Perfect balance (palindrome) allows at most one oddity. Too many differences break the symmetry.

# Analysis for Longest Substring with At Most K Distinct Characters
# *Phân tích cho bài toán Chuỗi con Dài nhất với Tối đa K Ký tự Khác nhau*

## 1. Problem Essence & Sliding Window
## *1. Bản chất vấn đề & Cửa sổ Trượt*

### The Challenge
### *Thách thức*
Find max length valid window.
Validity: count of unique chars $\le k$.

### Strategy: Sliding Window
### *Chiến lược: Cửa sổ Trượt*
Pointers `left`, `right`.
Expand `right`. Add char to Map.
If `map.size() > k`:
  Shrink `left`. Remove char from map (if count 0).
Update `maxLen`.

### Map Optimization
### *Tối ưu hóa Map*
Use `int[128]` for ASCII or `HashMap`. Since K is small (50), HashMap overhead is negligible but array is faster.

---

## 2. Approach: Sliding Window + Map
## *2. Hướng tiếp cận: Cửa sổ Trượt + Map*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Time:** Each character added/removed at most once.
    *Thời gian O(N): Mỗi ký tự được thêm/xóa tối đa một lần.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$ (limited by charset size).
    *Độ phức tạp không gian: $O(1)$ (giới hạn bởi kích thước bộ ký tự).*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** "eceba", k=2.
r=0 'e'. Map {e:1}. Size 1. Len 1.
r=1 'c'. Map {e:1, c:1}. Size 2. Len 2.
r=2 'e'. Map {e:2, c:1}. Size 2. Len 3. (ece)
r=3 'b'. Map {e:2, c:1, b:1}. Size 3 > 2. Shrink left.
  l=0 remove 'e'. Map {e:1, c:1, b:1}. Size 3.
  l=1 remove 'c'. Map {e:1, c:0 -> removed, b:1}. Map {e:1, b:1}. Size 2.
  New window eba (l=2..3). Len 2. (Actually l needs to move past 'c').
  Valid window "eb". Len 2.
Max was 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard Sliding Window.
*Cửa sổ Trượt tiêu chuẩn.*
---
*Đôi khi phải biết buông bỏ những điều cũ (shrink window) để đón nhận những điều mới mẻ (new chars), giữ cho cuộc sống luôn nằm trong giới hạn chịu đựng (limit k) nhưng vẫn đạt được trải nghiệm phong phú nhất (max length).*
Sometimes we must let go of the old (shrink window) to embrace the new (new chars), keeping life within tolerable limits (limit k) while still achieving the richest experience (max length).

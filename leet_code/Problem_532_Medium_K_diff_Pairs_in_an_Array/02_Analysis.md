# Analysis for K-diff Pairs in an Array
# *Phân tích cho bài toán Cặp K-khác biệt trong Mảng*

## 1. Problem Essence & Unique Pairs
## *1. Bản chất vấn đề & Cặp Duy nhất*

### The Challenge
### *Thách thức*
Counting unique pairs `(a, b)` such that `|a - b| == k`.
- `k=0`: Need to find elements that appear at least twice.
- `k>0`: Need to find `a` such that `a + k` exists in the array.

### Strategy: Frequency Map
### *Chiến lược: Map Tần suất*

1.  **Count Frequencies:** Use a `HashMap` to count occurrences of each number.
2.  **Iterate:** Iterate through the *keySet* (unique numbers).
3.  **Check:**
    - If `k > 0`: Check if `num + k` is in the map. If yes, count++.
    - If `k == 0`: Check if `count(num) >= 2`. If yes, count++.
    - `k < 0`: Impossible (absolute difference is non-negative), return 0.

---

## 2. Approach: Hash Map
## *2. Hướng tiếp cận: Hash Map*

### Logic
### *Logic*
(See above). Why iterate keyset? To avoid duplicate pairs `(1, 3)` and `(1, 3)` if 1 appears twice. We count unique *values* of `a`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Time:** Single pass for counting and checking.
    *Thời gian O(N): Một lần duyệt để đếm và kiểm tra.*
*   **O(N) Space:** Map storage.
    *Không gian O(N): Lưu trữ Map.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[3, 1, 4, 1, 5]`, `k=2`
1. Map: `{3:1, 1:2, 4:1, 5:1}`.
2. Loop Keys:
   - `1`: Check `1+2=3`. Exists? Yes. Count=1.
   - `3`: Check `3+2=5`. Exists? Yes. Count=2.
   - `4`: Check `4+2=6`. Exists? No.
   - `5`: Check `5+2=7`. Exists? No.
Result: 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Frequency Map handles both k=0 and k>0 cases efficiently.
*Bản đồ tần suất xử lý cả hai trường hợp k=0 và k>0 hiệu quả.*
---
*Sự khác biệt (difference) tạo nên cặp đôi, nhưng chính sự tồn tại độc lập (unique numbers) mới là nền tảng để so sánh. Với k=0, ta tìm sự đồng điệu trong chính bản thân (duplicates). Với k>0, ta tìm mảnh ghép còn thiếu (complement) để hoàn thiện bức tranh.*
Difference creates couples, but independent existence (Unique Numbers) is the basis for comparison. With k = 0, we find harmony in ourselves (Duplicates). With k> 0, we find the missing piece (Complement) to complete the picture.

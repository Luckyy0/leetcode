# Analysis for Longest Repeating Character Replacement
# *Phân tích cho bài toán Chuỗi con có Ký tự Lặp lại Dài nhất sau khi Thay thế*

## 1. Problem Essence & Sliding Window Dynamics
## *1. Bản chất vấn đề & Cơ chế Cửa sổ trượt*

### The Challenge
### *Thách thức*
Finding the maximum length of a substring that can become unicharacter with at most $k$ changes.
A window is "valid" if:
`WindowSize - CountOfMostFrequentChar <= k`.
This means we need to change all characters except the most frequent one to match it.

### Strategy: Two Pointers (Sliding Window)
### *Chiến lược: Hai con trỏ (Cửa sổ trượt)*
1.  **Initialize:** `left = 0`, `maxFreq = 0`, and a frequency map `count[26]`.
2.  **Expand:** Iterate `right` from 0 to `s.length() - 1`.
    -   Update `count[s[right]]`.
    -   Update `maxFreq = max(maxFreq, count[s[right]])`.
3.  **Validate:** If `(right - left + 1) - maxFreq > k`:
    -   The window is too large to fix with $k$ modifications.
    -   Shrink from the left: `count[s[left]]--`, then `left++`.
    -   *Crucially:* We don't need to decrement `maxFreq` when shrinking. Because we only care about a new `maxFreq` that is strictly greater than the current one to potentially expand the global maximum window size.
4.  **Result:** The maximum value of `right - left + 1` during the process.

---

## 2. Approach: Optimal Window Maintenance
## *2. Hướng tiếp cận: Duy trì Cửa sổ Tối ưu*

### Logic
### *Logic*
The window size `right - left + 1` only grows or shifts. It never shrinks globally. If a bigger valid window is found, it grows. Otherwise, it slides forward at its current max size.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Efficiency:** Single pass with two pointers.
    *Hiệu quả O(N): Duyệt một lần với hai con trỏ.*
*   **Constant Space:** Frequency map of size 26.
    *Không gian hằng số: Bản đồ tần suất kích thước 26.*

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

**Input:** `s = "AABABB", k = 1`
1. `right=0 ('A')`: `count[A]=1, maxFreq=1, len=1`.
2. `right=1 ('A')`: `count[A]=2, maxFreq=2, len=2`.
3. `right=2 ('B')`: `count[B]=1, maxFreq=2, len=3`. `3-2 <= 1` (Valid).
4. `right=3 ('A')`: `count[A]=3, maxFreq=3, len=4`. `4-3 <= 1` (Valid).
5. `right=4 ('B')`: `count[B]=2, maxFreq=3, len=5`. `5-3 > 1` (Invalid). Shift `left`.
...
Result: 4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Sliding window with `maxFreq` tracking.
*Cửa sổ trượt với việc theo dõi tần suất lớn nhất (maxFreq).*
---
*Trong cuộc sống, sự kiên trì (longest repeating) đôi khi đòi hỏi một chút linh hoạt (replacements). Bằng cách mở rộng tầm nhìn (expanding window) và điều chỉnh những sai sót nhỏ (at most k changes), ta có thể tìm thấy một vùng không gian nơi sự đồng nhất (same letter) đạt đến quy mô lớn nhất, mở ra cơ hội cho những thành tựu vĩ đại.*
In life, persistence (longest repeating) sometimes requires a bit of flexibility (replacements). By expanding our vision (expanding window) and adjusting small mistakes (at most k changes), we can find a space where uniformity (same letter) reaches its greatest scale, opening up opportunities for great achievements.

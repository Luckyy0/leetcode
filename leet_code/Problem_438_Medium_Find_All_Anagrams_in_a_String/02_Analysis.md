# Analysis for Find All Anagrams in a String
# *Phân tích cho bài toán Tìm tất cả các từ Đảo chữ trong một Chuỗi*

## 1. Problem Essence & Fixed-Size Window
## *1. Bản chất vấn đề & Cửa sổ kích thước Cố định*

### The Challenge
### *Thách thức*
Finding all occurrences of permutations of string `p` within string `s`. Comparing whole strings at every position would be $O(N \times M)$. We need a more efficient way to verify the anagram property as we slide across `s`.

### Strategy: Sliding Window with Frequency Map
### *Chiến lược: Cửa sổ trượt với Bản đồ Tần suất*

1.  **Requirement:** An anagram must have the exact same character frequencies as `p`.
2.  **Tracking:** Use an array `count[26]` to store the required frequencies of `p`.
3.  **Sliding Window:**
    - Maintain a window of length `p.length()` in `s`.
    - As the window slides:
        - Add the new character (decrement its required count).
        - Remove the old character (increment its required count).
    - If at any point the current window's frequency matches `count`, the window is an anagram.
4.  **Optimization:** Instead of comparing arrays of size 26 at each step, keep a `diff` or `match` counter.

---

## 2. Approach: Optimal Window Logic
## *2. Hướng tiếp cận: Logic Cửa sổ Tối ưu*

### Logic
### *Logic*
(See above). We maintain two frequency arrays (one for `p` and one for the current window of `s`) and compare them. Since the array size is only 26, the comparison is $O(1)$. Total time complexity becomes $O(N)$.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Efficiency:** Optimal linear scan.
    *Hiệu quả O(N): Duyệt tuyến tính tối ưu.*
*   **Constant Overhead:** Character set is fixed (26).
    *Chi phí hằng số: Bộ ký tự được cố định (26).*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of `s`.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$ for the frequency arrays (size 26).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `s = "cbaebabacd", p = "abc"`
1. Target Freq: `{a:1, b:1, c:1}`.
2. Initial Window (0-2): `cba`. Window Freq: `{a:1, b:1, c:1}`. **Match! Index 0**.
3. Slide to (1-3): Remove `c`, add `e`. Window: `bae`. `{a:1, b:1, e:1}`. No match.
...
4. Slide to (6-8): Window: `bac`. `{a:1, b:1, c:1}`. **Match! Index 6**.
Result: `[0, 6]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Sliding window with character frequency arrays.
*Cửa sổ trượt với mảng tần suất ký tự.*
---
*Mọi sự đảo chữ (anagram) thực chất là sự bảo toàn của vật chất (characters). Khi ta trượt qua dòng thời gian (string s) với một thước đo cố định (length of p), ta chỉ cần kiểm tra xem "thành phần" (frequencies) có khớp với nguyên mẫu hay không. Sự kiên trì trong từng dịch chuyển nhỏ sẽ mang lại những chỉ số (indices) của sự thật.*
Every anagram (anagram) is essentially the conservation of matter (characters). When we slide through time (string s) with a fixed measure (length of p), we only need to check if the "ingredients" (frequencies) match the prototype. Persistence in each small shift will bring about indices of truth.

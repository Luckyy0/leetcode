# Analysis for License Key Formatting
# *Phân tích cho bài toán Định dạng Khóa Giấy phép*

## 1. Problem Essence & Backward Processing
## *1. Bản chất vấn đề & Xử lý Ngược*

### The Challenge
### *Thách thức*
Structuring a alphanumeric string into groups of size `k`, separated by dashes, starting from the end. The first group gets whatever remains. Case conversion is needed.

### Strategy: Iterate Backwards
### *Chiến lược: Duyệt Ngược*

1.  **Direction:** Since the last groups *must* be size `k` and the *first* group takes the remainder, it's easiest to build the string from **end to start**.
2.  **Steps:**
    - Initialize a `StringBuilder`.
    - Iterate `s` from `s.length() - 1` down to `0`.
    - If `char` is not '-', append it (to upper case).
    - Maintain a counter `count`. If `count % k == 0` (and not start of string), append '-'.
    - Finally, reverse the `StringBuilder`.
3.  **Alternative:** Iterate forwards but handle modulo arithmetic carefully. `(totalChars % k)` gives size of first group. Backwards is simpler.

---

## 2. Approach: StringBuilder with Dash Logic
## *2. Hướng tiếp cận: StringBuilder với Logic Dấu gạch ngang*

### Logic
### *Logic*
(See above). Note on dash insertion: append dash *before* adding the character if `sb.length() % (k+1) == k`?
Simpler logic:
- Iterate backwards.
- Add char.
- Check `if (sb.length() - dashes) % k == 0`.
Actually, simpler: use a specific counter for alphanumeric chars added. When `count` hits `k`, insert dash `-` *next time*? Or insert dash immediately?
Standard approach:
- Count alphanumerics added so far.
- If `count > 0 && count % k == 0`, append `-`.
- Then append char.
- But wait, if we append dash *after* `k` chars, and we run out of chars, we might have a trailing dash at the start (end of SB).
- Correct order: Append char. Increment count. If `count % k == 0` and we have more chars coming, append dash?
- **Easiest:** Just append all alphanumeric chars to SB. Then iterate the SB and insert dashes at correct positions? Or use the backward loop and append dashes appropriately.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Reverse Build:** Automatically handles the "first group shorter" rule without calculating total length first.
    *Xây dựng ngược: Tự động xử lý quy tắc "nhóm đầu ngắn hơn" mà không cần tính tổng độ dài trước.*
*   **Single Pass:** Only one traversal of the string.
    *Một lần duyệt: Chỉ duyệt chuỗi một lần.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is length of `s`.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ for the result.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `5F3Z-2e-9-w`, k=4
1. Backward loop.
2. `w` -> `W`. SB=`W`, count=1.
3. `9` -> `9`. SB=`W9`, count=2.
4. `-` -> skip.
5. `e` -> `E`. SB=`W9E`, count=3.
6. `2` -> `2`. SB=`W9E2`, count=4.
   - count is 4. Next alphanumeric needs dash.
7. `-` -> skip.
8. `Z` -> `Z`.
   - Before adding `Z`, check `count % k == 0`? Yes. Add `-`.
   - SB=`W9E2-`, then add `Z` -> `W9E2-Z`. count=5.
9. `3` -> `3`. SB=`W9E2-Z3`. count=6.
...
Final SB: `W9E2-Z3F5`.
Reverse: `5F3Z-2E9W`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Iterate backwards, accumulating alphanumerics and inserting dashes every $k$ characters.
*Duyệt ngược, tích lũy các ký tự chữ số và chèn dấu gạch ngang mỗi $k$ ký tự.*
---
*Đôi khi để sắp xếp mọi thứ ngăn nắp từ đầu (first group), ta phải bắt đầu từ đích (end). Bằng cách đi ngược dòng chảy (backwards), những ràng buộc cứng nhắc ở phía sau (fixed size groups) được giải quyết trước, để lại sự linh hoạt tùy ý cho phần khởi đầu (remainder).*
Sometimes to arrange things neatly from the beginning (First Group), we have to start from the destination (End). By going upstream (Backwards), the rigid constraints behind (Fixed Size Groups) are resolved first, leaving flexibility for the beginning (remainder).

# Analysis for Strobogrammatic Number II
# *Phân tích cho bài toán Số Strobogrammatic II*

## 1. Problem Essence & Constructive Recursion
## *1. Bản chất vấn đề & Đệ quy xây dựng*

### The Pattern
### *Mẫu*
To build a strobogrammatic number of length `n`:
- Take valid pairs: `(0,0), (1,1), (6,9), (8,8), (9,6)`.
- Wrap them around numbers of length `n-2`.
*Để xây dựng: Bao quanh các số có độ dài `n-2` bằng các cặp hợp lệ.*

### Base Cases
### *Các trường hợp cơ sở*
- `n = 0`: `[""]` (Empty string).
- `n = 1`: `["0", "1", "8"]`. (Middle elements).
*n=0 trả về chuỗi rỗng. n=1 trả về 0, 1, 8.*

### Leading Zero Constraint
### *Ràng buộc số 0 ở đầu*
- Numbers cannot start with '0', EXCEPT if the number is just "0".
- E.g., `n=2`: "00" is invalid.
- But if we are building the *inner* part of a larger number (e.g. constructing middle 2 digits of a 4-digit number), "00" IS valid (like "1001").
*00 không hợp lệ ở n=2, nhưng hợp lệ nếu nó nằm bên trong (ví dụ 1001).*

---

## 2. Approach: Recursion
## *2. Hướng tiếp cận: Đệ quy*

### Algorithm
### *Thuật toán*
function `helper(n, finalLength)`:
1.  Base cases `n=0` or `n=1`.
2.  Recursive call `subList = helper(n-2, finalLength)`.
3.  For each `s` in `subList`:
    - Add `1` + s + `1`
    - Add `6` + s + `9`
    - Add `8` + s + `8`
    - Add `9` + s + `6`
    - If `n != finalLength` (not outermost layer):
        - Add `0` + s + `0`.
4.  Return new list.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Recursive Construction:** Builds the string from inside out.
    *Xây dựng từ trong ra ngoài.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Roughly $5^{N/2}$.
    *Độ phức tạp thời gian: $5^{N/2}$.*
*   **Space Complexity:** Output storage.

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `n=2`
- Call `helper(2, 2)`.
- Recurse `helper(0, 2)`. Returns `[""]`.
- Processing `""`:
    - "1" + "" + "1" -> "11"
    - "69", "88", "96"
    - "00" -> Skipped because `n == finalLength`.
- Returns `["11", "69", "88", "96"]`.

**Input:** `n=4`
- Recurse `helper(2, 4)`.
    - Recurse `helper(0, 4)`. Returns `[""]`.
    - Returns `["00", "11", "69", "88", "96"]`. (00 included because `2 != 4`).
- Processing each of inner list:
    - Inner "00": "1001", "6009"... (Valid)
    - Inner "11": "1111", "6119"...
    - ...

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Key challenge is managing the `0` pair at the outermost layer. Passing `finalLength` helps distinguish.
*Thử thách chính là quản lý cặp 0 ở layer ngoài cùng.*
---
*Xây dựng một cấu trúc vững chắc (như số này) bắt đầu từ lõi (n=0,1) và đắp dần các lớp bao bọc bên ngoài, nhưng đừng bao giờ để sự trống rỗng (số 0) dẫn đầu.*
Building a solid structure (like this number) starts from the core (n=0,1) and layering outwards, but never let emptiness (zero) take the lead.

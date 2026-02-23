# Analysis for Longest Palindrome
# *Phân tích cho bài toán Chuỗi đối xứng Dài nhất*

## 1. Problem Essence & Symmetrical Balance
## *1. Bản chất vấn đề & Sự cân bằng Đối xứng*

### The Challenge
### *Thách thức*
Creating the longest possible palindrome using any combination of characters from a given set. A palindrome requires characters to appear in pairs, with at most one character standing alone in the center.

### Strategy: Frequency Pairs (Greedy)
### *Chiến lược: Cặp tần suất (Tham lam)*
1.  **Counting:** Count the occurrences of each character.
2.  **Pairing:** For any character appearing $C$ times:
    - We can use $\lfloor C/2 \rfloor \times 2$ instances of that character to form pairs.
    - If $C$ is even, we use all.
    - If $C$ is odd, we use $C-1$.
3.  **Center Piece:** If after collecting all pairs, there's at least one unused character (someone whose count was odd), we can pick exactly one to be the center of the palindrome.

---

## 2. Approach: Frequency Map / Array
## *2. Hướng tiếp cận: Bản đồ Tần suất / Mảng*

### Logic
### *Logic*
(See above). We can use an integer array of size 128 (ASCII) to store counts since the input only contains English letters.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Efficiency:** Single pass to count, single pass to sum.
    *Hiệu quả O(N): Một lần duyệt để đếm, một lần duyệt để tổng hợp.*
*   **Constant Space:** Only a small fixed-size array is needed.
    *Không gian hằng số: Chỉ cần một mảng kích thước cố định nhỏ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the string.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$ (fixed size character array).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `s = "abccccdd"`
1. Counts: `a:1, b:1, c:4, d:2`
2. Pairs:
   - `a`: $1/2 * 2 = 0$
   - `b`: $1/2 * 2 = 0$
   - `c`: $4/2 * 2 = 4$
   - `d`: $2/2 * 2 = 2$
   - Total pairs length = $0 + 0 + 4 + 2 = 6$.
3. Check for center: Total 6 < Original 8. Yes, someone was left out. Add 1.
Result: 7.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Count all even occurrences and add 1 for center if needed.
*Đếm tất cả các lần xuất hiện chẵn và cộng thêm 1 cho tâm nếu cần.*
---
*Đối xứng (palindrome) là vẻ đẹp của sự cân bằng. Trong một tập hợp lộn xộn của các mảnh ghép (characters), ta tìm kiếm những "đôi lứa" (pairs) để tạo nên sự hài hòa hai bên, và để lại một vị trí đặc biệt ở chính giữa (center) cho một cá nhân đơn lẻ - điểm nhấn hoàn thiện cho một bức tranh hoàn mỹ.*
Symmetry (palindrome) is the beauty of balance. In a cluttered set of pieces (characters), we look for "pairs" to create harmony on both sides, and leave a special position in the middle (center) for a single individual - the finishing highlight for a perfect picture.

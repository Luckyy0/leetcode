# Analysis for Valid Word Square
# *Phân tích cho bài toán Hình vuông Từ vựng Hợp lệ*

## 1. Problem Essence & Matrix Symmetry
## *1. Bản chất vấn đề & Tính đối xứng Ma trận*

### The Challenge
### *Thách thức*
Checking if a 2D structure of words is symmetric across its main diagonal. The tricky part is that the words may have different lengths, making the "matrix" irregular.

### Strategy: Direct Boundary-Safe Comparison
### *Chiến lược: So sánh Trực tiếp và An toàn biên*
1.  Iterate through each word at row `i`.
2.  For each character at index `j` in word `i`:
    -   We need to compare `words[i][j]` with its mirror `words[j][i]`.
3.  **Correctness constraints:**
    -   If `j >= words.size()`, there's no word at index `j` to form column `j`. Fail.
    -   If `i >= words[j].length()`, the mirror word `j` doesn't have enough characters to match row `i`. Fail.
    -   If `words[i][j] != words[j][i]`, characters don't match. Fail.
4.  If all checks pass, return `true`.

---

## 2. Approach: Iterative Character Matching
## *2. Hướng tiếp cận: Khớp ký tự Lặp*

### Logic
### *Logic*
(See above). The algorithm simply verifies the symmetry property $M[i][j] = M[j][i]$ while carefully handling the irregular boundaries of the strings.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(Total Chars) Efficiency:** Each character is visited once.
    *Hiệu quả O(Tổng số ký tự): Mỗi ký tự được truy cập một lần.*
*   **Minimal Overhead:** No extra storage needed for transposing or rebuilding strings.
    *Tối giản chi phí: Không cần lưu trữ thêm để chuyển vị hoặc xây dựng lại chuỗi.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot L)$, where $N$ is the number of words and $L$ is max length.
    *Độ phức tạp thời gian: $O(N \cdot L)$.*
*   **Space Complexity:** $O(1)$ additional space.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `["abcd", "bnrt", "crm", "dt"]`
1. `i=0, j=1`: `words[0][1]` ('b') compared with `words[1][0]` ('b'). OK.
2. `i=2, j=3`: `words[2][3]` (out of bounds for "crm"). But wait, we iterate row by row.
   For `i=0`, check `j=0,1,2,3`.
   `words[0][3]` ('d') vs `words[3][0]` ('d'). OK.
3. If at any point the "column word" is shorter than the row index or doesn't exist, it's invalid.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Direct double-loop with boundary checks.
*Vòng lặp kép trực tiếp với kiểm tra biên.*
---
*Sự đối xứng (symmetry) là một vẻ đẹp toán học thuần khiết. Trong một hình vuông từ vựng, mỗi từ không chỉ nằm trên hàng (row) mà còn tự phản chiếu mình qua lăng kính của các cột (columns). Khi mỗi chữ cái ở vị trí (i, j) tìm thấy bản sao hoàn hảo của mình tại (j, i), bức tranh ngôn từ mới thực sự trở nên vẹn tròn và hợp lệ.*
Symmetry (symmetry) is a pure mathematical beauty. In a word square, each word not only lies on a row (row) but also reflects itself through the prism of the columns (columns). When each letter at position (i, j) finds its perfect replica at (j, i), the word picture truly becomes complete and valid.

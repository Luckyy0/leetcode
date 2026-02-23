# Analysis for Number of Lines To Write String
# *Phân tích cho bài toán Số dòng để viết chuỗi*

## 1. Problem Essence & Iterative Counting
## *1. Bản chất vấn đề & Đếm lặp*

### The Challenge
### *Thách thức*
We need to simulate writing a string on lines of fixed width. If the current character doesn't fit in the remaining space of the line, it moves to a new line.
*Chúng ta cần mô phỏng việc viết chuỗi trên các dòng có độ rộng cố định. Nếu ký tự hiện tại không vừa với không gian còn lại của dòng, nó sẽ chuyển sang một dòng mới.*

---

## 2. Strategy: Simulation
## *2. Chiến lược: Mô phỏng*

### Algorithm
### *Thuật toán*

1.  **Initialize:** Start with `lines = 1` and `currentWidth = 0`.
    *   **Khởi tạo:** Bắt đầu với `lines = 1` và `currentWidth = 0`.*

2.  **Iterate through String:** For each character `c` in `s`:
    - Lookup its width: `w = widths[c - 'a']`.
    - If `currentWidth + w > 100`:
      - Increment `lines`.
      - Start the new line with the current width `w`.
    - Else:
      - Add `w` to `currentWidth`.
    *   **Duyệt qua chuỗi:** Với mỗi ký tự, tra cứu độ rộng của nó. Nếu tổng vượt quá 100, tăng số dòng và bắt đầu dòng mới với độ rộng của chính ký tự đó. Nếu không, cộng dồn vào độ rộng hiện tại.*

3.  **Return Result:** Return `[lines, currentWidth]`.
    *   **Trả về kết quả:** Mảng chứa `lines` và `currentWidth` cuối cùng.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(S)$, where $S$ is the length of string `s`.
    *   **Độ phức tạp thời gian:** $O(S)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Input:** `widths = [10, ...], s = "abcdefghij..."`
1. 'a': width 10. `currentWidth = 10`.
2. 'b': width 10. `currentWidth = 20`.
...
10. 'j': width 10. `currentWidth = 100`.
11. 'k': width 10. `100 + 10 > 100`. `lines = 2`, `currentWidth = 10`.
**Result:** [lines, last_width]

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

A simple linear scan is the most efficient and direct way to solve this simulation problem.
*Một lượt quét tuyến tính đơn giản là cách hiệu quả nhất và trực tiếp nhất để giải quyết bài toán mô phỏng này.*

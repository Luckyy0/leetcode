# Analysis for String Compression
# *Phân tích cho bài toán Nén Chuỗi*

## 1. Problem Essence & Read-Write Pointers
## *1. Bản chất vấn đề & Con trỏ Đọc-Ghi*

### The Challenge
### *Thách thức*
Compressing an array of characters in-place ($O(1)$ extra space). We need to count consecutive identical characters and overwrite the array with the character followed by its count (if $> 1$).

### Strategy: Two Pointers
### *Chiến lược: Hai con trỏ*

1.  **Read Pointer (`i`):** Moves through the original array to identify groups of repeating characters.
2.  **Write Pointer (`res`):** Tracks the current position for writing the compressed results.
3.  **Process:**
    - While `i < chars.length`:
        - Save the current character `char curr = chars[i]`.
        - Count how many times `curr` repeats starting from `i` (let's say `count`).
        - Write `curr` to `chars[res++]`.
        - If `count > 1`:
            - Convert the integer `count` to a string or characters (e.g., `12` becomes `'1'`, `'2'`).
            - Write each digit to `chars[res++]`.
        - Advance `i += count`.
4.  **Result:** Return the value of `res`.

---

## 2. Approach: In-Place Modification
## *2. Hướng tiếp cận: Chỉnh sửa tại chỗ*

### Logic
### *Logic*
(See above). The `res` pointer will never overtake `i` because the compressed representation (a char + its count digits) is always shorter than or equal to the original sequence of identical characters (e.g., "aaaaa" $\to$ "a5", "aaaaaaaaaaaa" $\to$ "a12").

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Memory:** No new arrays or string builders (except for temporary small digit arrays).
    *Bộ nhớ O(1): Không tạo mảng mới hay chuỗi xây dựng.*
*   **Linear Efficiency:** Single pass through the input array.
    *Hiệu quả tuyến tính: Duyệt mảng một lần.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(n)$, where $n$ is the length of `chars`.
    *Độ phức tạp thời gian: $O(n)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `["a","a","b","b","c","c","c"]`
1. `i = 0, curr = 'a'`. Count = 2.
   - Write 'a' at `res=0`. `res=1`.
   - `count > 1`: Write '2' at `res=1`. `res=2`.
2. `i = 2, curr = 'b'`. Count = 2.
   - Write 'b' at `res=2`. `res=3`.
   - `count > 1`: Write '2' at `res=3`. `res=4`.
3. `i = 4, curr = 'c'`. Count = 3.
   - Write 'c' at `res=4`. `res=5`.
   - `count > 1`: Write '3' at `res=5`. `res=6`.
Result: 6.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Two pointers (Read and Write) with in-place overwriting.
*Hai con trỏ (Đọc và Ghi) thực hiện ghi đè tại chỗ.*
---
*Những gì lặp lại quá nhiều có thể làm cho bức tranh cuộc sống trở nên rườm rà. Nén chuỗi (string compression) giúp ta cô đọng lại những giá trị cốt lõi, thay thế sự dư thừa bằng những con số định lượng sắc sảo. Bằng cách sử dụng chính không gian hiện tại của mình để tái cấu trúc (in-place), ta rèn luyện sự tinh gọn và hiệu quả trong mọi dòng code.*
Too many repetitions can make the picture of life cumbersome. String compression (string compression) helps us condense core values, replacing redundancy with sharp quantitative numbers. By using our own current space to restructure (in-place), we practice conciseness and efficiency in every line of code.

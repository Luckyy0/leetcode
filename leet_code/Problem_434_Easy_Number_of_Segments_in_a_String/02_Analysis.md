# Analysis for Number of Segments in a String
# *Phân tích cho bài toán Số lượng Phân đoạn trong một Chuỗi*

## 1. Problem Essence & Word Boundary
## *1. Bản chất vấn đề & Ranh giới từ*

### The Challenge
### *Thách thức*
Counting contiguous blocks of non-space characters. The main difficulty is handling multiple spaces between segments or spaces at the beginning/end of the string.

### Strategy: One-Pass Tracking
### *Chiến lược: Theo dõi một lần duyệt*

1.  Iterate through the string.
2.  Count a segment **only at its start**.
3.  A segment starts at index `i` if:
    -   `s[i]` is not a space.
    -   Either it's the beginning of the string (`i == 0`) OR the previous character was a space (`s[i-1] == ' '`).

---

## 2. Approach: Simple Linear Scan
## *2. Hướng tiếp cận: Quét tuyến tính đơn giản*

### Logic
### *Logic*
(See above). This approach avoids using `split(" ")` which can be tricky with multiple spaces and leading/trailing whitespace. It's safe and uses $O(1)$ extra space.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Robustness:** Handles any number of spaces correctly.
    *Độ tin cậy: Xử lý chính xác bất kể số lượng khoảng trắng.*
*   **Space Efficient:** $O(1)$ additional memory.
    *Hiệu quả không gian: Bộ nhớ bổ sung O(1).*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the string.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `"  Hello World "`
1. `i = 0`: ' '. Skip.
2. `i = 1`: ' '. Skip.
3. `i = 2`: 'H'. Not space, prev `i=1` was space. **Count = 1**.
4. Skip `e, l, l, o`.
5. `i = 7`: ' '. Skip.
6. `i = 8`: 'W'. Not space, prev `i=7` was space. **Count = 2**.
7. Skip `o, r, l, d`.
8. `i = 13`: ' '. Skip.
Result: 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Single pass with boundary check.
*Một lần duyệt với kiểm tra ranh giới.*
---
*Những khoảng trống (spaces) trong ngôn từ không làm mất đi giá trị của những gì ta muốn nói. Đôi khi, chính sự im lặng ấy lại là dấu hiệu để báo hiệu một chương mới, một phân đoạn mới (segment) bắt đầu. Bằng cách tập trung vào điểm khởi đầu (start of segment), ta thấu hiểu được trọn vẹn nhịp điệu của một chuỗi ký tự.*
The gaps (spaces) in words do not diminish the value of what we want to say. Sometimes, that silence is the sign to herald a new chapter, a new segment (segment) to begin. By focusing on the starting point (start of segment), we fully understand the rhythm of a string.

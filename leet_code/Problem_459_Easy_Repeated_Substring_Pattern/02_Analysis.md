# Analysis for Repeated Substring Pattern
# *Phân tích cho bài toán Mẫu Chuỗi con được Lặp lại*

## 1. Problem Essence & Cyclical Shift
## *1. Bản chất vấn đề & Dịch chuyển Vòng*

### The Challenge
### *Thách thức*
Checking if a string $S$ is of the form $P+P+\dots+P$. This means $S$ is periodic.

### Strategy: The Doubling Trick
### *Chiến lược: Thủ thuật Nhân đôi*

1.  **Fundamental Property:** A string $S$ consists of a repeated substring if and only if $S$ is a non-trivial **cyclic shift** of itself.
2.  **Implementation:**
    - Concatenate the string with itself: `T = S + S`.
    - If $S$ is periodic, it must appear somewhere inside `T` other than at the very beginning (index 0) and the very end (index $N$).
    - To check this, we remove the first and last characters of `T`: `T_prime = T.substring(1, T.length() - 1)`.
    - Check if `T_prime` contains `S`.

---

## 2. Approach: String Manipulation Logic
## *2. Hướng tiếp cận: Logic Thao tác Chuỗi*

### Logic
### *Logic*
(See above). If $S = P \times k$, then $S + S = P \times 2k$. By removing the first and last characters, we have $2k-2$ occurrences of $P$ potentially joined in ways that recreate $S$. If we can still find $S$, it means $k \ge 2$.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Concise Logic:** No need for manual substring trial and error.
    *Logic ngắn gọn: Không cần thử sai các chuỗi con một cách thủ công.*
*   **Built-in Efficiency:** Uses the highly optimized string searching algorithms of the language ($O(N)$ or $O(N \log N)$).
    *Hiệu quả tích hợp: Sử dụng các thuật toán tìm kiếm chuỗi đã được tối ưu hóa của ngôn ngữ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of `s` (assuming `String.contains` uses an efficient algorithm like KMP or Boyer-Moore).
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ for the concatenated string.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `s = "abab"`
1. `doubled = "abababab"`
2. `clipped = "bababa"` (removed first 'a' and last 'b')
3. Does `clipped` contain `"abab"`?
   - `ba[abab]a` $\to$ **Yes!**
Result: `true`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

String doubling and clipping trick.
*Thủ thuật nhân đôi và cắt chuỗi.*
---
*Sự lặp lại (repetition) đôi khi tạo nên một vẻ đẹp nhịp nhàng, nhưng cũng có thể che giấu đi bản chất thực sự của một cấu trúc. Bằng cách nhân đôi thực tại (S+S) và quan sát những gì xảy ra khi ta phá vỡ các ranh giới (clip), ta có thể nhận ra liệu một chuỗi sự kiện được xây dựng từ những mảnh ghép đồng nhất hay là một thực thể độc nhất vô nhị.*
Repetition (repetition) sometimes creates a rhythmic beauty, but can also hide the true nature of a structure. By doubling reality (S+S) and observing what happens when we break boundaries (clip), we can realize whether a sequence of events built from identical pieces or is a unique entity.

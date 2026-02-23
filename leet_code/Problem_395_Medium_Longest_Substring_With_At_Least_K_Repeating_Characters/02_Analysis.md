# Analysis for Longest Substring with At Least K Repeating Characters
# *Phân tích cho bài toán Chuỗi con Dài nhất có Ít nhất K Ký tự Lặp lại*

## 1. Problem Essence & Divide and Conquer
## *1. Bản chất vấn đề & Chia để trị*

### The Challenge
### *Thách thức*
Finding a substring where *all* its unique characters satisfy a threshold condition. If any character appears fewer than $k$ times in the current string, it *cannot* be part of the optimal substring.

### Strategy: Divide and Conquer
### *Chiến lược: Chia để trị*
1.  **Frequency Count:** Count all character frequencies in the given range.
2.  **Splitter Identification:** Find the first character whose frequency is $0 < count < k$.
3.  **Recursion:**
    - If no such character exists, the entire string is valid. Return its length.
    - If a splitter $c$ is found at index $i$, the result is $\max($
        `solve(left_part)`,
        `solve(right_part)`
    $)$.
    *(Actually, we should split at all occurrences of $c$ or any other invalid character).*

---

## 2. Approach: Recursive Splitting
## *2. Hướng tiếp cận: Tách Đệ quy*

### Logic
### *Logic*
(See above). The sub-problems are smaller segments of the original string.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N * 26) Complexity:** In each recursive step, we scan at most 26 characters (alphabet size).
    *Hiệu quả O(N * 26): Trong mỗi bước đệ quy, chúng ta quét tối đa 26 ký tự.*
*   **Intuition:** Directly uses the constraint to eliminate invalid candidates.
    *Trực quan: Sử dụng trực tiếp ràng buộc để loại bỏ các ứng cử viên không hợp lệ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$ in the worst case (like `aaaaa...` with $k=2$), but effectively $O(N \cdot 26)$ due to the nature of splitting.
    *Độ phức tạp thời gian: $O(N \cdot 26)$.*
*   **Space Complexity:** $O(N)$ for the recursion stack.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `s = "ababbc", k = 2`
1. Counts: `a:2, b:3, c:1`.
2. 'c' is the splitter because $count('c') = 1 < 2$.
3. Split around 'c':
   - Left: `"ababb"`.
   - Right: `""`.
4. Recurse on `"ababb"`:
   - Counts: `a:2, b:3`. Both $\ge 2$.
   - Valid! Return 5.
Result: 5.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Divide and Conquer by splitting at "invalid" characters.
*Chia để trị bằng cách tách tại các ký tự "không hợp lệ".*
---
*Trong cuộc tìm kiếm những cái tên tiêu biểu (substring with threshold), đôi khi ta cần phải loại bỏ những kẻ không đạt chuẩn (invalid characters). Bằng cách chia nhỏ (divide) thế giới và loại bỏ những mắt xích yếu, ta sẽ dần cô lập được vẻ đẹp thực sự của những gì bền bỉ và mạnh mẽ nhất.*
In the search for typical names (substring with threshold), sometimes we need to remove those who do not meet the standard (invalid characters). By dividing the world and removing the weak links, we will slowly isolate the true beauty of what is most persistent and powerful.

# Analysis for Minimum Window Subsequence
# *Phân tích cho bài toán Chuỗi con tối thiểu chứa Dãy con*

## 1. Problem Essence & Window Optimization
## *1. Bản chất vấn đề & Tối ưu hóa Cửa sổ*

### The Challenge
### *Thách thức*
We are looking for a contiguous substring in `s1` that contains `s2` as a non-contiguous subsequence. Unlike the standard "Minimum Window Substring" (where order doesn't matter), here the **order of characters is strictly preserved**.
*Chúng ta đang tìm kiếm một chuỗi con liên tục trong `s1` mang `s2` như một dãy con không liên tục. Khác với bài toán "Chuỗi con tối thiểu" thông thường (nơi thứ tự không quan trọng), ở đây **thứ tự các ký tự phải được bảo toàn nghiêm ngặt**.*

---

## 2. Strategy: Forward and Backward Pointers
## *2. Chiến lược: Con trỏ Tiến và Lùi*

The most intuitive and efficient approach is a "Two-Pass" pointer strategy within a loop.
*Cách tiếp cận trực quan và hiệu quả nhất là chiến lược con trỏ "Hai lượt" trong một vòng lặp.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Forward Pass (Search):**
    - Iterate through `s1` using `p1`. Keep track of `p2` in `s2`.
    - If `s1[p1] == s2[p2]`, move `p2` forward.
    - Stop when `p2` reaches the end of `s2`. This current `p1` is the end of a valid candidate window.
    * **Lượt Tiến (Tìm kiếm):** Duyệt qua `s1`. Nếu ký tự khớp với `s2`, ta tăng con trỏ `p2`. Khi `p2` đi hết `s2`, ta đã tìm thấy điểm kết thúc của một cửa sổ hợp lệ.*

2.  **Backward Pass (Shrink):**
    - From the current `p1`, walk backwards to find the *rightmost* possible starting index for this specific sequence.
    - Decrement `p2`. For each `s2[p2]`, move `p1` backwards until they match.
    - When `p2 < 0`, the current `p1` is the optimized start of the window.
    * **Lượt Lùi (Thu hẹp):** Từ điểm kết thúc vừa tìm được, ta quay ngược lại để tìm chỉ số bắt đầu gần nhất có thể. Điều này giúp thu hẹp cửa sổ đến mức tối thiểu cho trình tự đó.*

3.  **Update & Advance:**
    - Record the window length. If smaller than the current minimum, update the result.
    - Reset `p1 = optimized_start + 1` and `p2 = 0` to search for the next possible window.
    * **Cập nhật & Tiến tiếp:** Ghi lại độ dài. Nếu nhỏ hơn mức đang có thì lưu lại. Bắt đầu tìm kiếm cửa sổ tiếp theo từ ngay sau điểm bắt đầu vừa tìm được.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(S1 \cdot S2)$, where $S1$ and $S2$ are the lengths of the strings. In the worst case (many repeating characters), we might re-scan parts of $s1$. However, for most cases, it behaves close to linear.
    * **Độ phức tạp thời gian:** $O(S1 \cdot S2)$.*
*   **Space Complexity:** $O(1)$ ignoring the space for the output string.
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**s1 = "abcdebdde", s2 = "bde"**
1. **Forward:** Match 'b' (idx 1), 'd' (idx 3), 'e' (idx 4). `end` = 4.
2. **Backward:** Match 'e' at 4, 'd' at 3, 'b' at 1. `start` = 1.
3. Window: "bcde" (len 4).
4. **Rescan from 2:** Next forward matches 'b' (5), 'd' (6), 'e' (8). `end` = 8.
5. **Backward:** Match 'e' at 8, 'd' at 7, 'b' at 5. `start` = 5.
6. Window: "bdde" (len 4, but start 5 > 1).
**Result:** "bcde".

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

The "Two-pointer forward/backward" technique is the de-facto standard for subsequence window problems. It avoids the complexity of $O(S1 \cdot S2)$ DP tables while remaining easy to debug.
*Kỹ thuật "Hai con trỏ tiến/lùi" là tiêu chuẩn thực tế cho các bài toán về dãy con trong cửa sổ. Nó tránh được sự phức tạp của bảng DP mà vẫn dễ dàng gỡ lỗi.*
---
*Sự tối thiểu (Minimality) trong một dải băng của các ký tự là kết quả của việc xác định ranh giới rộng nhất rồi thu hẹp về phía sự thật. Trong dòng chảy của `s1`, ta tìm kiếm dấu vết của `s2` bằng cách tiến tới để bao trùm (Forward) và lùi lại để tinh lọc (Backward). Dữ liệu dạy ta rằng bằng cách liên tục tối ưu hóa từng khoảnh khắc khớp lệnh (Optimization), ta có thể tìm thấy sự biểu hiện ngắn gọn nhất của một trình tự ẩn giấu.*
Minimality (Minimality) in a ribbon of characters is the result of defining the widest boundary and then narrowing it toward the truth. In the flow of `s1`, we search for traces of `s2` by moving forward to encompass (Forward) and backward to refine (Backward). Data teaches us that by continuously optimizing each matching moment (Optimization), we can find the most concise expression of a hidden sequence.

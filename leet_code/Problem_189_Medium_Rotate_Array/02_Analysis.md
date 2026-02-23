# Analysis for Rotate Array
# *Phân tích cho bài toán Xoay mảng*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### Understanding "Rotation"
### *Hiểu về "Xoay"*
Rotating an array to the right by `k` steps means taking the last `k` elements and moving them to the front. 
*Xoay một mảng sang phải `k` bước có nghĩa là lấy `k` phần tử cuối cùng và chuyển chúng lên đầu.*

If `k` is greater than the length of the array `n`, it effectively rotates `k % n` times. For example, if $n=5$ and $k=7$, it's the same as rotating 2 times.
*Nếu `k` lớn hơn độ dài của mảng `n`, nó thực sự xoay `k % n` lần. Ví dụ, nếu $n=5$ và $k=7$, nó giống như xoay 2 lần.*

### The Constraint of O(1) Space
### *Ràng buộc không gian O(1)*
Using an extra array is trivial: copy the last `k` elements to the new start, copy the first `n-k` elements to the new end. The real challenge, and the interview standard, is to do this **in-place** with $O(1)$ extra memory.
*Sử dụng một mảng phụ là tầm thường. Thử thách thực sự, và là tiêu chuẩn phỏng vấn, là thực hiện điều này **tại chỗ** với bộ nhớ phụ $O(1)$.*

---

## 2. Approach: The Reverse Trick
## *2. Hướng tiếp cận: Thủ thuật đảo ngược*

This is the most popular and elegant solution.
*Đây là giải pháp phổ biến và thanh lịch nhất.*

### Logic
### *Logic*
To rotate the array `[1, 2, 3, 4, 5, 6, 7]` by `k=3`:
1.  **Reverse the entire array:** `[7, 6, 5, 4, 3, 2, 1]`
    - Now the elements that need to be at the front (`5, 6, 7`) are at the front, but in reverse order (`7, 6, 5`).
    - The elements that need to be at the back (`1, 2, 3, 4`) are at the back, but in reverse order (`4, 3, 2, 1`).
2.  **Reverse the first k elements:** `[5, 6, 7 | 4, 3, 2, 1]`
3.  **Reverse the remaining n-k elements:** `[5, 6, 7 | 1, 2, 3, 4]`

The result is exactly what we want!

---

## 3. Alternative Approach: Cyclic Replacements
## *3. Hướng tiếp cận thay thế: Thay thế vòng tròn*

We can move elements one by one directly to their final positions.
- Place element at `i` to `(i + k) % n`.
- Store the element being overwritten in a `temp` variable and move it next.
- Repeat this process.
- **Cycle detection:** If we return to the starting `i`, we move to `i+1` and start a new cycle. We do this until we have moved `n` elements total.
*Chúng ta có thể di chuyển từng phần tử trực tiếp đến vị trí cuối cùng của nó. Đặt phần tử tại `i` vào `(i + k) % n`. Lưu trữ phần tử bị ghi đè vào biến `temp` và di chuyển nó tiếp theo. Lặp lại quá trình này. Nếu quay lại điểm bắt đầu, chuyển sang `i+1`.*

This is mathematically sound but harder to implement correctly compared to the **Reverse Trick**.
*Cách này đúng về mặt toán học nhưng khó triển khai chính xác hơn so với Thủ thuật đảo ngược.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We reverse the array three times. $N + k + (N-k) = 2N$ operations, which is $O(N)$.
    *Độ phức tạp thời gian: $O(N)$. Chúng ta đảo ngược mảng ba lần.*
*   **Space Complexity:** $O(1)$. We only use a temporary variable for swapping in the reverse helper function.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 2, 3, 4, 5, 6, 7]`, `k = 3`.

1.  Reverse All: `[7, 6, 5, 4, 3, 2, 1]`
2.  Reverse [0...2]: `[5, 6, 7, 4, 3, 2, 1]`
3.  Reverse [3...6]: `[5, 6, 7, 1, 2, 3, 4]`

**Result:** `[5, 6, 7, 1, 2, 3, 4]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Always use the **Reverse Trick** for array rotation in interviews. It is easy to write, bug-free, and optimally efficient. Just remember to handle `k %= nums.length` at the very beginning to avoid out-of-bounds errors if `k` is huge.
*Luôn sử dụng **Thủ thuật đảo ngược** để xoay mảng trong các cuộc phỏng vấn. Nó dễ viết, không có lỗi và hiệu quả tối ưu. Chỉ cần nhớ xử lý `k %= nums.length` ngay từ đầu để tránh lỗi vượt quá giới hạn nếu `k` quá lớn.*
---
*Đôi khi để tiến lên phía trước một cách đúng đắn, ta cần đảo lộn tất cả, sau đó sắp xếp lại từng phần nhỏ.*
Sometimes to move forward correctly, we need to turn everything upside down, then rearrange each small part.

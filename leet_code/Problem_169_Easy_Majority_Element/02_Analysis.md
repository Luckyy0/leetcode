# Analysis for Majority Element
# *Phân tích cho bài toán Phần tử đa số*

## 1. Problem Essence & Efficiency
## *1. Bản chất vấn đề & Hiệu quả*

### Defining Majority
### *Định nghĩa đa số*
The "Majority Element" is not just the most frequent element, but one that occupies more than **half** of the array ($> N/2$). This strict definition allows for some very clever optimizations that would not be possible for a general "mode" (most frequent) problem.
*Phần tử "Đa số" không chỉ là phần tử thường xuyên nhất, mà là phần tử chiếm hơn **nửa** mảng ($> N/2$). Định nghĩa nghiêm ngặt này cho phép thực hiện một số tối ưu hóa rất thông minh mà không khả thi đối với bài toán tìm "mốt" (giá trị thường xuyên nhất) thông thường.*

### Approach Selection
### *Lựa chọn hướng tiếp cận*
- **Sorting:** $O(N \log N)$ time, $O(1)$ space. After sorting, the element at $N/2$ must be the majority.
- **HashMap:** $O(N)$ time, $O(N)$ space. Store counts of each number.
- **Boyer-Moore Voting Algorithm:** $O(N)$ time, $O(1)$ space. This is the gold standard for this problem.
*- **Sắp xếp**: Thời gian $O(N \log N)$. Sau khi sắp xếp, phần tử ở vị trí $N/2$ chắc chắn là phần tử đa số.*
*- **HashMap**: Thời gian $O(N)$, không gian $O(N)$.*
*- **Thuật toán bỏ phiếu Boyer-Moore**: Thời gian $O(N)$, không gian $O(1)$. Đây là tiêu chuẩn vàng cho bài toán này.*

---

## 2. Approach: Boyer-Moore Voting Algorithm
## *2. Hướng tiếp cận: Thuật toán bỏ phiếu Boyer-Moore*

### The Intuition
### *Nhận thức cảm tính*
Imagine the array is a battlefield of different parties. If two different elements fight, they both "die" (cancel each other out). Since the majority element appears more than half the time, it can "cancel out" every other element in the array and still have at least one survivor left.
*Hãy tưởng tượng mảng là một chiến trường của các phe phái khác nhau. Nếu hai phần tử khác nhau chiến đấu, cả hai đều "chết" (triệt tiêu lẫn nhau). Vì phần tử đa số xuất hiện hơn một nửa số lần, nó có thể "triệt tiêu" mọi phần tử khác trong mảng mà vẫn còn ít nhất một người sống sót.*

### Algorithm Logic
### *Logic thuật toán*
1.  Maintain a `candidate` and a `count`.
2.  Initialize `count = 0`.
3.  For each `num` in the array:
    a. If `count == 0`, assign `candidate = num` and set `count = 1`.
    b. If `num == candidate`, increment `count`.
    c. If `num != candidate`, decrement `count`.
4.  At the end of the loop, the `candidate` is the majority element.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Extreme Space Efficiency:** It uses only two integer variables, making it ideal for large streaming data or memory-constrained environments.
    *Hiệu quả không gian cực cao: Nó chỉ sử dụng hai biến nguyên, lý tưởng cho dữ liệu luồng lớn hoặc môi trường hạn chế bộ nhớ.*
*   **One-Pass Logic:** The algorithm only scans the array once ($O(N)$). 
    *Logic một lượt: Thuật toán chỉ quét mảng một lần.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Every element is visited exactly once.
    *Độ phức tạp thời gian: $O(N)$. Mọi phần tử được truy cập đúng một lần.*
*   **Space Complexity:** $O(1)$. Regardless of the input size, the extra space used remains constant.
    *Độ phức tạp không gian: $O(1)$. Không phụ thuộc vào kích thước đầu vào.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[2, 2, 1, 1, 1, 2, 2]`

1. `num=2`: `count=0` -> `candidate=2, count=1`.
2. `num=2`: `num==cand` -> `count=2`.
3. `num=1`: `num!=cand` -> `count=1`.
4. `num=1`: `num!=cand` -> `count=0`.
5. `num=1`: `count=0` -> `candidate=1, count=1`.
6. `num=2`: `num!=cand` -> `count=0`.
7. `num=2`: `count=0` -> `candidate=2, count=1`.

**Final Candidate:** 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Boyer-Moore is one of the most famous and specialized algorithms in computer science. While sorting is easy to remember, Boyer-Moore is much more efficient. Always ensure that the problem guarantees a majority element exists, as the standard Boyer-Moore only finds the "potential" candidate (in cases where a majority might not exist, a second pass would be needed to verify).
*Boyer-Moore là một trong những thuật toán nổi tiếng và chuyên biệt nhất. Trong khi sắp xếp dễ nhớ, Boyer-Moore lại hiệu quả hơn nhiều. Luôn đảm bảo rằng bài toán cam đoan phần tử đa số tồn tại, vì thuật toán Boyer-Moore tiêu chuẩn chỉ tìm thấy ứng cử viên "tiềm năng" (trong trường hợp đa số có thể không tồn tại, cần một lượt quét thứ hai để xác minh).*
---
*Kẻ mạnh nhất không nhất thiết phải thắng mọi trận chiến, họ chỉ cần tồn tại lâu hơn mọi đối thủ cộng lại.*
The strongest doesn't necessarily have to win every battle; they just need to outlast every opponent combined.

# Analysis for Longest Consecutive Sequence
# *Phân tích cho bài toán Chuỗi Liên Tiếp Dài Nhất*

## 1. Problem Core & Efficiency Goal
## *1. Cốt Lõi Vấn Đề & Mục Tiêu Hiệu Quả*

### The O(N) Constraint
### *Ràng Buộc O(N)*
*   The most intuitive way to solve this is to sort the array first. Sorting takes $O(N \log N)$ time. After sorting, we can easily find consecutive sequences by checking adjacent elements.
    *Cách trực quan nhất để giải quyết vấn đề này là sắp xếp mảng trước. Việc sắp xếp mất thời gian $O(N \log N)$. Sau khi sắp xếp, chúng ta có thể dễ dàng tìm thấy các chuỗi liên tiếp bằng cách kiểm tra các phần tử liền kề.*
*   However, the problem explicitly requires an $O(N)$ time complexity. This means we cannot use standard comparison-based sorting.
    *Tuy nhiên, bài toán yêu cầu rõ ràng độ phức tạp thời gian là $O(N)$. Điều này có nghĩa là chúng ta không thể sử dụng các thuật toán sắp xếp dựa trên so sánh tiêu chuẩn.*

---

## 2. Approach: HashSet for Intelligent Exploration
## *2. Hướng Tiếp Cận: HashSet Để Khám Phá Thông Minh*

To achieve $O(N)$, we need a way to look up elements in $O(1)$ time. A `HashSet` is the perfect tool for this.
*Để đạt được $O(N)$, chúng ta cần một cách để tra cứu các phần tử trong thời gian $O(1)$. `HashSet` là công cụ hoàn hảo cho việc này.*

### Logic
### *Logic*
1.  Insert all elements of the array into a `HashSet`. This takes $O(N)$ time and removes duplicates.
    *Chèn tất cả các phần tử của mảng vào một `HashSet`. Việc này mất thời gian $O(N)$ và loại bỏ các phần tử trùng lặp.*
2.  Iterate through each number `num` in the set:
    -   **Identify the Start of a Sequence:** A number `num` is the start of a consecutive sequence only if `num - 1` is **not** in the set.
        *Xác định điểm bắt đầu của một chuỗi: Một số `num` là điểm bắt đầu của một chuỗi liên tiếp chỉ khi `num - 1` **không** nằm trong tập hợp.*
    -   If `num` is a start:
        -   Count how many consecutive numbers follow it (`num + 1`, `num + 2`, etc.) by checking their existence in the set.
            *Đếm xem có bao nhiêu số liên tiếp theo sau nó (`num + 1`, `num + 2`, v.v.) bằng cách kiểm tra sự tồn tại của chúng trong tập hợp.*
        -   Update the maximum sequence length found so far.
            *Cập nhật độ dài chuỗi tối đa được tìm thấy cho đến nay.*

### Why is this O(N)?
### *Tại sao lại là O(N)?*
At first glance, it might look like $O(N^2)$ because of the nested `while` loop. However, notice that the inner `while` loop only executes for the **first** element of each sequence.
Each element is visited at most twice: once in the outer loop and once in the inner `while` loop of its sequence. This results in a strictly linear time complexity.
*Thoạt nhìn, nó có vẻ giống $O(N^2)$ do vòng lặp `while` lồng nhau. Tuy nhiên, lưu ý rằng vòng lặp `while` bên trong chỉ thực thi cho phần tử **đầu tiên** của mỗi chuỗi. Mỗi phần tử được truy cập tối đa hai lần: một lần trong vòng lặp bên ngoài và một lần trong vòng lặp `while` bên trong của chuỗi của nó. Điều này dẫn đến độ phức tạp thời gian tuyến tính nghiêm ngặt.*

---

## 3. Structural Advantages
## *3. Ưu Điểm Cấu Trúc*

*   **Handling Duplicates:** The `HashSet` naturally ignores duplicate values, which don't contribute to the length of a consecutive sequence anyway.
    *Xử Lý Trùng Lặp: `HashSet` tự nhiên bỏ qua các giá trị trùng lặp, vốn không đóng góp vào độ dài của một chuỗi liên tiếp.*
*   **Arbitrary Order:** Since we look for the start of sequences, the order of elements in the original array or the set doesn't matter.
    *Thứ Tự Tùy Ý: Vì chúng ta tìm kiếm điểm bắt đầu của các chuỗi, thứ tự của các phần tử trong mảng ban đầu hoặc tập hợp không quan trọng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We iterate over the array to build the set ($O(N)$), then iterate over the set's contents exactly once for the starts of sequences.
    *Độ phức tạp thời gian: $O(N)$. Chúng ta lặp qua mảng để xây dựng tập hợp ($O(N)$), sau đó lặp qua nội dung của tập hợp đúng một lần cho các điểm bắt đầu của chuỗi.*
*   **Space Complexity:** $O(N)$. We need to store all unique elements in the `HashSet`.
    *Độ phức tạp không gian: $O(N)$. Chúng ta cần lưu trữ tất cả các phần tử duy nhất trong `HashSet`.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums = [100, 4, 200, 1, 3, 2]`
**Set:** `{100, 4, 200, 1, 3, 2}`

-   Process `100`: `99` not in set? Yes. Sequence: `100`. Length 1.
-   Process `4`: `3` in set? Yes. Skip (not a start).
-   Process `200`: `199` not in set? Yes. Sequence: `200`. Length 1.
-   Process `1`: `0` not in set? Yes. Sequence: `1, 2, 3, 4`. Length 4.
-   Process `3`: `2` in set? Yes. Skip.
-   Process `2`: `1` in set? Yes. Skip.

**Result:** 4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

The HashSet approach is the canonical $O(N)$ solution for this problem. The "Skip if `num - 1` exists" trick is the key optimization move. It turns an exhaustive search into a targeted traversal, minimizing redundant work. This pattern is often called "Identifying the Head" of a structure.
*Cách tiếp cận HashSet là giải pháp $O(N)$ chuẩn mực cho bài toán này. Thủ thuật "Bỏ qua nếu `num - 1` tồn tại" là bước tối ưu hóa then chốt. Nó biến một cuộc tìm kiếm toàn diện thành một cuộc duyệt có mục tiêu, giảm thiểu công việc dư thừa. Mô hình này thường được gọi là "Xác định đầu" của một cấu trúc.*
---
*Đôi khi lùi lại một bước để thấy rằng mình không phải là người đứng đầu chính là cách để tiết kiệm năng lượng nhất.*
Sometimes stepping back to see that you're not the leader is the best way to save energy.

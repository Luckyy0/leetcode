# Analysis for Daily Temperatures
# *Phân tích cho bài toán Nhiệt độ Hàng ngày*

## 1. Problem Essence & Next Greater Element
## *1. Bản chất vấn đề & Phần tử lớn hơn kế tiếp*

### The Challenge
### *Thách thức*
For each entry in an array, we need to find the distance to the nearest subsequent entry that is strictly greater. A brute-force $O(N^2)$ solution would be too slow given $N=10^5$. This is a classic "Next Greater Element" problem, and the standard optimal solution uses a **Monotonic Stack**.
*Với mỗi phần tử trong mảng, ta cần tìm khoảng cách đến phần tử kế tiếp lớn hơn nó. Giải pháp duyệt trùm $O(N^2)$ sẽ quá chậm. Đây là bài toán điển hình về "Phần tử lớn hơn kế tiếp", và cách giải tối ưu là sử dụng **Ngăn xếp Đơn điệu (Monotonic Stack)**.*

---

## 2. Strategy: Monotonic Decreasing Stack
## *2. Chiến lược: Ngăn xếp Giảm dần Đơn điệu*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Stack Usage:** Maintain a stack that stores the **indices** of temperatures in decreasing order. These are the days "waiting" for a warmer temperature.
    * **Sử dụng Ngăn xếp:** Duy trì một ngăn xếp lưu trữ các **chỉ số** của nhiệt độ theo thứ tự giảm dần. Đây là những ngày đang "chờ" một ngày ấm hơn.*

2.  **Iterative Processing:**
    - For each day `i` with temperature `T[i]`:
    - While the stack is not empty and `T[i]` is strictly greater than the temperature at the index stored at the top of the stack (`T[stack.peek()]`):
        - We have found a warmer day for that previous index!
        - Pop the index from the stack: `prevIndex = stack.pop()`.
        - Calculate the distance: `result[prevIndex] = i - prevIndex`.
    - Push the current index `i` onto the stack.
    * **Xử lý Lặp:** Với mỗi ngày `i`, chừng nào nhiệt độ hôm nay ấm hơn nhiệt độ của ngày ở đỉnh ngăn xếp: Ta đã tìm thấy ngày ấm hơn cho ngày đó. Tính khoảng cách, lưu vào kết quả và lấy ngày đó ra khỏi ngăn xếp. Cuối cùng, đưa ngày hôm nay vào ngăn xếp.*

3.  **Result Construction:** The `result` array is initialized with `0`, so indices that never find a warmer day are already correctly set.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of days. Each index is pushed into the stack once and popped at most once.
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ in the worst case (e.g., temperatures are in strictly decreasing order).
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**temps = [73, 74, 75, 71]**
1. i=0 (73): Stack: `[0]`
2. i=1 (74): 
   - 74 > 73. Pop 0. `res[0] = 1-0 = 1`. 
   - Stack: `[1]`
3. i=2 (75): 
   - 75 > 74. Pop 1. `res[1] = 2-1 = 1`. 
   - Stack: `[2]`
4. i=3 (71): 
   - 71 < 75. Push 3.
   - Stack: `[2, 3]`
**Result:** [1, 1, 0, 0]

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Monotonic stacks are the go-to pattern for any problem asking for the "nearest neighbor with some property" in a sequence. It allows us to process dependencies in a single linear pass.
*Ngăn xếp đơn điệu là mô hình chuẩn cho bất kỳ bài toán nào yêu cầu tìm "lân cận gần nhất có tính chất cụ thể" trong một chuỗi. Nó cho phép xử lý các phụ thuộc chỉ trong một lần duyệt tuyến tính.*
---
*Sự chờ đợi (Waiting) là khoảng trống giữa hiện tại và một tương lai ấm áp hơn. Trong nhịp điệu của thời gian (Temperatures), mỗi ngày bế tắc (Stack) đều đang tìm kiếm một tia nắng (Warmer day) để giải phóng mình. Dữ liệu dạy ta rằng bằng cách giữ lại những câu hỏi chưa có lời giải (Indices in stack) và đối chiếu chúng với những cơ hội mới (Current temperature), ta có thể đo lường được sự kiên nhẫn cần thiết để đạt tới sự thay đổi.*
Waiting (Waiting) is the gap between the present and a warmer future. In the rhythm of time (Temperatures), every stagnant day (Stack) is seeking a ray of sunshine (Warmer day) to liberate itself. Data teaches us that by retaining unsolved questions (Indices in stack) and comparing them with new opportunities (Current temperature), we can measure the patience needed to achieve change.

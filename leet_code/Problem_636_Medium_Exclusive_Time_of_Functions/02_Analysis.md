# Analysis for Exclusive Time of Functions
# *Phân tích cho bài toán Thời gian Thực thi Riêng của các Hàm*

## 1. Problem Essence & Call Stack Simulation
## *1. Bản chất vấn đề & Mô phỏng Ngăn xếp Cuộc gọi*

### The Challenge
### *Thách thức*
We need to calculate the exclusive execution time for multiple functions given their start and end logs. The exclusive time excludes any time taken by child functions called during its execution.
*Chúng ta cần tính thời gian thực thi riêng cho nhiều hàm dựa trên nhật ký bắt đầu và kết thúc của chúng. Thời gian riêng loại trừ bất kỳ thời gian nào được sử dụng bởi các hàm con được gọi trong quá trình thực thi của nó.*

Since the system is single-threaded and use start/end markers, this is a perfect candidate for a **Stack** simulation.
*Vì hệ thống là đơn luồng và sử dụng các điểm đánh dấu bắt đầu/kết thúc, đây là một ứng cử viên hoàn hảo để mô phỏng bằng **Ngăn xếp (Stack)**.*

---

## 2. Strategy: Stack-Based Time Accounting
## *2. Chiến lược: Kế toán Thời gian dựa trên Ngăn xếp*

As we process logs, the function at the top of the stack is the only one currently consuming "exclusive time".
*Khi chúng ta xử lý các nhật ký, hàm ở đầu ngăn xếp là hàm duy nhất hiện đang tiêu thụ "thời gian riêng".*

### Step-by-Step Logic
### *Logic từng bước*

1.  **State Management:**
    - `Stack<Integer> stack`: Stores IDs of active functions.
    - `int lastTimestamp`: Stores the time when the last event (start or end) occurred.
    - `int[] res`: Stores the accrued exclusive time for each function ID.

2.  **Iterate Through Logs:**
    * **Duyệt qua các Nhật ký:** *
    - For each log `"{id}:{type}:{timestamp}"`:
        - Parse the component values.

3.  **Handling "start" logs:**
    * **Xử lý nhật ký "start":** *
    - If the stack is not empty, add the time elapsed since the last event to the function at the top: `res[stack.peek()] += (timestamp - lastTimestamp)`.
    - Push the current function `id` onto the stack.
    - Update `lastTimestamp = timestamp`.

4.  **Handling "end" logs:**
    * **Xử lý nhật ký "end":** *
    - An "end" log at time `T` means the function finished at the *end* of second `T`.
    - Add the time including the current second: `res[stack.peek()] += (timestamp - lastTimestamp + 1)`.
    - Pop the function from the stack.
    - Update `lastTimestamp = timestamp + 1`. (The next event starts at the beginning of the next second).

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Boundary Inclusion:** The most critical detail is that a "start" happens at the beginning of a timestamp, while an "end" happens at the end of a timestamp. Using `+1` logic for "end" events correctly accounts for the full duration of the terminal second.
    * **Tính bao quát Ranh giới:** Chi tiết quan trọng nhất là "start" xảy ra vào đầu dấu thời gian, trong khi "end" xảy ra vào cuối dấu thời gian. Sử dụng logic `+1` cho các sự kiện "end" sẽ tính toán chính xác toàn bộ thời lượng của giây cuối cùng.*
*   **LIFO Property:** The Stack naturally handles nested calls. When a child ends, the parent implicitly "resumes" being at the top of the stack.
    * **Thuộc tính LIFO:** Ngăn xếp xử lý tự nhiên các cuộc gọi lồng nhau. Khi một hàm con kết thúc, hàm cha mặc nhiên "tiếp tục" ở vị trí đầu ngăn xếp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(L)$ where $L$ is the number of logs. Each log is processed once.
    * **Độ phức tạp thời gian:** $O(L)$ trong đó $L$ là số lượng nhật ký. Mỗi nhật ký được xử lý một lần.*
*   **Space Complexity:** $O(N)$ for the result array and $O(L)$ for the stack in the worst case (deeply nested calls).
    * **Độ phức tạp không gian:** $O(N)$ cho mảng kết quả và $O(L)$ cho ngăn xếp trong trường hợp xấu nhất.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Logs:** ["0:start:0", "1:start:2", "1:end:5", "0:end:6"]
1. "0:start:0": Stack=[0]. last=0.
2. "1:start:2": res[0] += (2-0) = 2. Stack=[0, 1]. last=2.
3. "1:end:5": res[1] += (5-2+1) = 4. Stack=[0]. last=6.
4. "0:end:6": res[0] += (6-6+1) = 1. Stack=[]. last=7.
**Result:** res[0]=3, res[1]=4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Whenever you have paired "start/end" events or nested structures (parenthesis, tags), a Stack is the primary tool. The key is defining exactly how the time/value is distributed to the top of the stack and how ranh giới (boundaries) are calculated.
*Bất cứ khi nào bạn có các sự kiện "start/end" theo cặp hoặc các cấu trúc lồng nhau, Ngăn xếp là công cụ chính. Chìa khóa là xác định chính xác cách thời gian/giá trị được phân phối cho phần tử ở đầu ngăn xếp và cách tính toán các ranh giới.*
---
*Mỗi khoảnh khắc (Timestamp) đều có chủ sở hữu của nó. Trong kiến trúc cuộc gọi (Call Stack), thời gian riêng (Exclusive time) là phần hiện hữu của một cá thể khi không bị xao nhãng bởi những nhiệm vụ phụ (Sub-calls). Dữ liệu dạy ta rằng bằng cách theo dõi sự tập trung (Stack top), ta có thể bóc tách sự đóng góp thực sự của mỗi thành phần trong một chuỗi hành động phức tạp.*
Every moment (Timestamp) has its owner. In call architecture (Call Stack), exclusive time (Exclusive time) is the existing part of an individual when not distracted by sub-tasks (Sub-calls). Data teaches us that by tracking focus (Stack top), we can peel away the true contribution of each component in a complex sequence of actions.

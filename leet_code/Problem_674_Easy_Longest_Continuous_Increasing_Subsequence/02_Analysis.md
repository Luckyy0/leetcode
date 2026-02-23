# Analysis for Longest Continuous Increasing Subsequence
# *Phân tích cho bài toán Dãy con Tăng Liên tục dài nhất*

## 1. Problem Essence & Continuous Property
## *1. Bản chất vấn đề & Tính chất liên tục*

### The Challenge
### *Thách thức*
We need to find the longest subarray (a continuous part of the array) that is strictly increasing. Unlike the general subseqence problem, we don't skip elements; any violation of the increasing order immediately resets the sequence.
*Chúng ta cần tìm mảng con (một phần liên tục của mảng) dài nhất mà tăng nghiêm ngặt. Khác với bài toán dãy con tổng quát, chúng ta không bỏ qua phần tử nào; bất kỳ sự vi phạm trật tự tăng dần nào cũng sẽ đặt lại dãy ngay lập tức.*

---

## 2. Strategy: Greedy Linear Scan
## *2. Chiến lược: Quét tuyến tính Tham lam*

Since we only care about adjacent elements, we can solve this in a single pass.
*Vì chúng ta chỉ quan tâm đến các phần tử liền kề, chúng ta có thể giải quyết vấn đề này trong một lần quét.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Initialize Variables:** `maxLen = 0`, `currentLen = 0`.
    * **Khởi tạo biến:** `maxLen = 0`, `currentLen = 0`.*

2.  **Iterate through Array:** Use a loop to visit each element `nums[i]`.
    * **Duyệt qua mảng:** Sử dụng vòng lặp để ghé thăm từng phần tử.*
    - If it's the first element (`i == 0`) OR `nums[i] > nums[i-1]`:
        - The increasing property holds. `currentLen++`.
    - Else (`nums[i] <= nums[i-1]`):
        - The sequence is broken. Start a new sequence with the current element: `currentLen = 1`.
    - Update `maxLen = max(maxLen, currentLen)`.

3.  **Result:** Return `maxLen`.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Linear Efficiency:** The $O(N)$ complexity is optimal as we must look at every element at least once.
    * **Hiệu suất tuyến tính:** Độ phức tạp $O(N)$ là tối ưu.*
*   **Constant Space:** We don't need any extra arrays, making it memory-efficient.
    * **Không gian không đổi:** Chúng ta không cần thêm mảng nào.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the array.
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [1, 3, 5, 4, 7]
1. `i=0`: current=1, max=1.
2. `i=1` (3): 3 > 1. current=2, max=2.
3. `i=2` (5): 5 > 3. current=3, max=3.
4. `i=3` (4): 4 <= 5. Sequence broken. current=1, max=3.
5. `i=4` (7): 7 > 4. current=2, max=3.
**Result:** 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Always distinguish between "subsequence" (can skip elements) and "subarray/continuous subsequence" (cannot skip). Continuous problems are usually solvable with a single pass or a sliding window, yielding much better complexity than general subsequence problems.
*Luôn phân biệt giữa "dãy con" (có thể bỏ qua phần tử) và "mảng con/dãy con liên tục" (không thể bỏ qua). Các bài toán liên tục thường có thể giải quyết trong một lần quét hoặc cửa sổ trượt.*
---
*Sự liên tục (Continuity) là sợi dây kết nối của sự tăng trưởng (Increase). Trong dòng chảy của dữ liệu, một bước thụt lùi (Decrease) sẽ đặt dấu chấm hết cho một hành trình liên mạch. Dữ liệu dạy ta rằng bằng cách tập trung vào hiện tại và so sánh với quá khứ gần nhất (Adjacent elements), ta có thể nhận diện được đoạn đường phát triển bền bỉ nhất của mình.*
Continuity (Continuity) is the connection of growth (Increase). In the flow of data, a step back (Decrease) will end a seamless journey. Data teaches us that by focusing on the present and comparing with the immediate past (Adjacent elements), we can identify our most persistent developmental path.

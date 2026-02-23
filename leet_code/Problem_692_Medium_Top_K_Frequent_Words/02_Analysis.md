# Analysis for Top K Frequent Words
# *Phân tích cho bài toán Top K Từ phổ biến nhất*

## 1. Problem Essence & Custom Ranking
## *1. Bản chất vấn đề & Xếp hạng Tùy chỉnh*

### The Challenge
### *Thách thức*
We need to find the `k` most frequent words from a list. There's a secondary sorting criterion: for words with the same frequency, the one that is lexicographically smaller comes first.
*Chúng ta cần tìm `k` từ xuất hiện nhiều nhất. Có một tiêu chí sắp xếp phụ: đối với các từ có cùng tần suất, từ đứng trước trong từ điển sẽ được ưu tiên.*

---

## 2. Strategy: HashMap + PriorityQueue (Min-Heap)
## *2. Chiến lược: HashMap + PriorityQueue (Min-Heap)*

To achieve the follow-up efficiency of $O(N \log K)$, we use a **Min-Heap** of size $K$.
*Để đạt được hiệu suất $O(N \log K)$, chúng ta sử dụng một **Min-Heap** có kích thước $K$.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Count Frequencies:** Use a `HashMap<String, Integer>` to count occurrences of each word.
    * **Đếm Tần suất:** Sử dụng một `HashMap` để đếm số lần xuất hiện của từng từ.*

2.  **Maintain Top K with Min-Heap:**
    - Insert words into a `PriorityQueue`.
    - **Custom Comparator:**
        - If `freq(a) != freq(b)`: The one with **smaller** frequency is at the top (Min-Heap behavior for frequency).
        - If `freq(a) == freq(b)`: The one that is **lexicographically larger** is at the top.
    - If the heap size exceeds $K$, remove the top element. The element being removed is either the one with the smallest frequency or, in a tie, the lexicographically larger one. This ensures only the "best" $K$ words remain.
    * **Duy trì Top K bằng Min-Heap:** Chèn các từ vào hàng đợi ưu tiên. Nếu kích thước vượt quá $K$, hãy loại bỏ phần tử ở đỉnh. Điều này đảm bảo chỉ giữ lại $K$ từ tốt nhất.*

3.  **Result Construction:**
    - Extract all elements from the heap.
    - Since it was a Min-Heap, the results will be in increasing order of "goodness." Reverse the list to get the final descending order.
    * **Xây dựng Kết quả:** Lấy tất cả các phần tử ra và đảo ngược danh sách để có thứ tự giảm dần.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Follow-up Optimization:** By keeping the heap size at $K$, we perform $\log K$ operations for each of the $N$ words, resulting in $O(N \log K)$ instead of $O(N \log N)$ for a full sort.
    * **Tối ưu hóa:** Việc giữ kích thước heap ở mức $K$ giúp đạt độ phức tạp $O(N \log K)$ thay vì $O(N \log N)$ nếu sắp xếp toàn bộ.*
*   **Tie-breaking:** The inverse lexicographical order in the Min-Heap (`b.compareTo(a)`) is critical so that the "greater" (worse) word is expelled first.
    * **Xử lý bằng nhau:** Thứ tự từ điển đảo ngược trong Min-Heap rất quan trọng để từ "lớn hơn" (tệ hơn) bị loại bỏ trước.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log K)$, where $N$ is the number of words.
    * **Độ phức tạp thời gian:** $O(N \log K)$.*
*   **Space Complexity:** $O(N)$ for the HashMap and $O(K)$ for the priority queue.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**words:** ["i", "love", "i", "love", "coding"], **k = 2**
1. Map: {i: 2, love: 2, coding: 1}
2. Heap (Size 2):
   - Add "i": [i]
   - Add "love": Heap keeps both. Comparator: same freq, "love" > "i". Heap: [love, i] (top is love).
   - Add "coding": Freq 1 < Freq 2. Heap adds it then pops the minimum (coding). Heap remains [love, i].
3. Result: Collect and reverse -> ["i", "love"].

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For "Top K" problems with secondary sorting criteria, always carefuly design the Min-Heap comparator so that the "least desirable" element is consistently at the top for expulsion.
*Đối với các bài toán "Top K" có tiêu chí phụ, hãy thiết kế bộ so sánh của Min-Heap một cách cẩn thận sao cho phần tử "ít được mong đợi nhất" luôn nằm ở đỉnh để bị loại bỏ.*
---
*Số lượng (Frequency) định nghĩa tầm quan trọng, nhưng thứ tự bản thân (Lexicographical order) định nghĩa đẳng cấp khi mọi sự đóng góp là như nhau. Trong thế giới của ngôn từ (Words), chúng ta lọc bỏ những kẻ yếu thế (Min-Heap) để giữ lại tinh hoa (Top K). Dữ liệu dạy ta rằng bằng cách sắp xếp sự ưu tiên một cách chuẩn xác (Priority Queue), ta có thể thấu thị được những gì thực sự nổi bật giữa một rừng thông tin hỗn loạn.*
Quantity (Frequency) defines importance, but the order of self (Lexicographical order) defines class when every contribution is equal. In the world of words (Words), we filter out the weak (Min-Heap) to preserve excellence (Top K). Data teaches us that by arranging priorities accurately (Priority Queue), we can see what truly stands out amidst a forest of chaotic information.

# Analysis for Array Partition
# *Phân tích cho bài toán Phân vùng Mảng*

## 1. Problem Essence & The Greedy Intuition
## *1. Bản chất vấn đề & Trực giác Tham lam*

### The Challenge
### *Thách thức*
We are given an array of $2n$ integers and asked to group them into $n$ pairs. For each pair $(a, b)$, we only keep the minimum value $\min(a, b)$. Our goal is to maximize the sum of these minimums.
*Chúng ta được trao một mảng gồm $2n$ số nguyên và được yêu cầu nhóm chúng thành $n$ cặp. Đối với mỗi cặp $(a, b)$, chúng ta chỉ giữ lại giá trị nhỏ nhất $\min(a, b)$. Mục tiêu của chúng ta là tối đa hóa tổng của các giá trị nhỏ nhất này.*

The fundamental tradeoff is that in every pair $(a, b)$, the larger element is "sacrificed" or "lost". To maximize the sum of what remains, we must minimize our total losses.
*Sự đánh đổi cơ bản là trong mọi cặp $(a, b)$, phần tử lớn hơn sẽ bị "hy sinh" hoặc "mất đi". Để tối đa hóa tổng của những gì còn lại, chúng ta phải giảm thiểu tổng mức tổn thất của mình.*

---

## 2. Strategy: Sorting for Minimal Loss
## *2. Chiến lược: Sắp xếp để Giảm thiểu Tổn thất*

If we pair a very small number with a very large number, the large number is wasted.
*Nếu chúng ta ghép một con số rất nhỏ với một con số rất lớn, con số lớn đó sẽ bị lãng phí.*

### The Logic
### *Logic*

1.  **Minimize Gaps:** To lose as little value as possible, we should pair numbers that are closest to each other.
    * **Giảm thiểu khoảng cách:** Để mất ít giá trị nhất có thể, chúng ta nên ghép các con số gần nhau nhất.*
2.  **Sorting:** When the array is sorted, the numbers that are closest to each other become neighbors.
    * **Sắp xếp:** Khi mảng được sắp xếp, các con số gần nhau nhất sẽ trở thành láng giềng của nhau.*
3.  **Optimal Pairing:** The optimal strategy is to pair index 0 with 1, index 2 with 3, and so on.
    * **Ghép cặp tối ưu:** Chiến lược tối ưu là ghép chỉ số 0 với 1, chỉ số 2 với 3, v.v.*
    - In each pair `(nums[2i], nums[2i+1])`, since the array is sorted, `nums[2i]` is always the minimum.
    - *Trong mỗi cặp `(nums[2i], nums[2i+1])`, vì mảng đã được sắp xếp, `nums[2i]` luôn là giá trị nhỏ nhất.*
4.  **Summation:** The result is simply the sum of elements at every even index (0, 2, 4, ...).
    * **Tổng hợp:** Kết quả đơn giản là tổng của các phần tử tại mọi chỉ số chẵn (0, 2, 4, ...).*

---

## 3. Structural Advantages & Mathematical Proof
## *3. Ưu điểm Cấu trúc & Chứng minh Toán học*

*   **Greedy Choice Property:** At each step, taking the smallest available number and pairing it with the next smallest ensures we lose the minimum amount of "potential" value for future pairs.
    * **Đặc tính Lựa chọn Tham lam:** Tại mỗi bước, việc lấy số nhỏ nhất có sẵn và ghép nó với số nhỏ tiếp theo đảm bảo chúng ta mất lượng giá trị "tiềm năng" tối thiểu cho các cặp trong tương lai.*
*   **Proof Sketch:** Suppose we have $a \le b \le c \le d$.
    - Option 1: $(a, b), (c, d) \rightarrow \min(a, b) + \min(c, d) = a + c$.
    - Option 2: $(a, c), (b, d) \rightarrow \min(a, c) + \min(b, d) = a + b$.
    - Option 3: $(a, d), (b, c) \rightarrow \min(a, d) + \min(b, c) = a + b$.
    - Since $b \le c$, then $a + c \ge a + b$. Thus, pairing neighbors is always better or equal.
    - *Vì $b \le c$, nên $a + c \ge a + b$. Do đó, việc ghép các láng giềng luôn tốt hơn hoặc bằng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ due to the sorting step. The subsequent linear scan is $O(N)$.
    * **Độ phức tạp thời gian:** $O(N \log N)$ do bước sắp xếp. Lượt quét tuyến tính sau đó là $O(N)$.*
*   **Space Complexity:** $O(1)$ if the sorting is done in-place, or $O(\log N)$ depending on the implementation of the sort algorithm's recursion stack.
    * **Độ phức tạp không gian:** $O(1)$ nếu việc sắp xếp được thực hiện tại chỗ, hoặc $O(\log N)$ tùy thuộc vào triển khai ngăn xếp đệ quy của thuật toán sắp xếp.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `[6, 2, 6, 5, 1, 2]`
1. **Sort:** `[1, 2, 2, 5, 6, 6]`
2. **Select even indices:**
   - Index 0: 1
   - Index 2: 2
   - Index 4: 6
3. **Sum:** 1 + 2 + 6 = 9.
**Result:** 9.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Sorting is the bridge that transforms a complex grouping problem into a simple summation task.
*Sắp xếp là chiếc cầu nối biến một bài toán nhóm phức tạp thành một nhiệm vụ tính tổng đơn giản.*
---
*Trong cuộc sống, sự kết hợp (Pairing) hiệu quả nhất thường đến từ những yếu tố tương đồng. Bằng cách sắp xếp lại (Sorting) các nguồn lực, ta giảm thiểu sự lãng phí (Loss) và tối đa hóa giá trị cốt lõi (Core value) mà mỗi cặp mang lại.*
In life, the most effective pairing (Pairing) often comes from similar elements. By rearranging (Sorting) resources, we minimize waste (Loss) and maximize the core value (Core value) that each pair brings.

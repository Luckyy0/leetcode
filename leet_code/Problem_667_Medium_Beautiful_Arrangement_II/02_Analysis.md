# Analysis for Beautiful Arrangement II
# *Phân tích cho bài toán Sắp đặt Đẹp mắt II*

## 1. Problem Essence & Constructive Pattern Matching
## *1. Bản chất vấn đề & Khớp mẫu Kiến tạo*

### The Challenge
### *Thách thức*
We need to generate a permutation of numbers $1 \dots n$ such that the differences between adjacent elements yield exactly $k$ unique absolute values.
*Chúng ta cần tạo ra một hoán vị của các số $1 \dots n$ sao cho các hiệu số giữa các phần tử liền kề mang lại đúng $k$ giá trị tuyệt đối duy nhất.*

---

## 2. Strategy: Segmented Construction (Linear + Zigzag)
## *2. Chiến lược: Xây dựng Phân đoạn (Tuyến tính + Zigzag)*

The most effective way to control the number of distinct differences is to split the sequence into two parts:
*Cách hiệu quả nhất để kiểm soát số lượng hiệu số phân biệt là chia chuỗi thành hai phần:*

1.  **Linear Segment (Difference = 1):** Produce a series of the same difference (1) repeatedly.
2.  **Zigzag Segment (Distinct Differences):** Alternatingly pick from the remaining smallest and largest values to create a descending staircase of differences ($k, k-1, \dots, 2$).

### Step-by-Step Logic
### *Logic từng bước*

1.  **Initialize Result Array:** Length $n$.
    * **Khởi tạo Mảng Kết quả:** Độ dài $n$.*

2.  **Fill First $n-k$ elements:** 
    *   Set `res[0...n-k-1]` to values $1, 2, \dots, n-k$. 
    *   This sequence produces only **one** distinct difference: `|i - (i+1)| = 1`.
    * **Điền $n-k$ phần tử đầu tiên:** Tập hợp các giá trị tăng dần từ 1 đến $n-k$. Đoạn này chỉ tạo ra một hiệu số duy nhất là 1.*

3.  **Fill remaining $k$ spaces:**
    *   We have $k$ more spots and we need $k-1$ more distinct differences ($2, 3, \dots, k$).
    *   Use two pointers: `low = n-k+1` and `high = n`.
    *   Iterate and alternate:
        - If the index is even (relative to the start of this segment), pick `high`, then decrement `high`.
        - If the index is odd, pick `low`, then increment `low`.
    * **Điền $k$ vị trí còn lại:** Sử dụng hai con trỏ `low` và `high`. Luân phiên chọn giá trị lớn nhất và nhỏ nhất còn lại để tạo ra các hiệu số $k, k-1 \dots$.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Greedy Differentiation:** Starting the zigzag immediately after $n-k$ creates a difference of exactly $k$ between $res[n-k-1]$ and $res[n-k]$. The next difference will be $k-1$, and so on.
    * **Phân biệt Tham lam:** Việc bắt đầu zigzag ngay sau $n-k$ tạo ra hiệu số đúng bằng $k$ tại điểm giao. Các hiệu số tiếp theo sẽ giảm dần $k-1, k-2 \dots$.*
*   **Efficiency:** $O(N)$ time and $O(N)$ space (for the output).
    * **Hiệu suất:** $O(N)$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. One pass to fill the array.
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$ extra space if we don't count the result array. $O(N)$ total.
    * **Độ phức tạp không gian:** $O(1)$ không gian phụ.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** n=5, k=3
1. `n-k=2`. First 2 elements: `1, 2`. (Difference: 1)
2. `low=3, high=5`.
3. 3rd element (idx 2): pick `high=5`. Array: `[1, 2, 5]`. (Difference: |5-2|=3). `high=4`.
4. 4th element (idx 3): pick `low=3`. Array: `[1, 2, 5, 3]`. (Difference: |3-5|=2). `low=4`.
5. 5th element (idx 4): pick `high=4`. Array: `[1, 2, 5, 3, 4]`. (Difference: |4-3|=1).
**Differences:** 1, 3, 2, 1. Distinct set: {1, 2, 3}. Size: 3.
**Result:** [1, 2, 5, 3, 4].

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Constructive problems involving differences are best handled by "exhausting" options from both ends of the available range. By anchoring the first part of the array to a single difference (1), you gain maximum flexibility to use the remaining range for the $k-1$ higher differences.
*Các bài toán kiến tạo liên quan đến hiệu số được xử lý tốt nhất bằng cách "khai thác" các lựa chọn từ cả hai đầu của phạm vi khả dụng. Bằng cách cố định phần đầu với hiệu số 1, bạn có được sự linh hoạt tối đa để sử dụng phần còn lại cho các hiệu số cao hơn.*
---
*Vẻ đẹp (Beautiful) của một sự sắp xếp nằm ở sự biến thiên có trật tự (Difference). Trong không gian của các con số, ta tạo ra sự đơn điệu (Linear) để rồi bứt phá bằng những bước nhảy đối lập (Zigzag). Dữ liệu dạy ta rằng bằng cách kiểm soát nhịp độ (k), ta có thể tạo ra một chuỗi nhịp nhàng, nơi mỗi sự khác biệt đều có lý do của nó, dẫn dắt từ sự giản đơn đến sự phức tạp đầy tính toán.*
The beauty (Beautiful) of an arrangement lies in ordered variation (Difference). In the space of numbers, we create monotony (Linear) and then break through with opposing jumps (Zigzag). Data teaches us that by controlling the tempo (k), we can create a rhythmic sequence where every difference has its reason, leading from simplicity to calculated complexity.

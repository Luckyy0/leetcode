# Analysis for Find the Derangement of An Array
# *Phân tích cho bài toán Tìm số Hoán vị Không cố định của một Mảng*

## 1. Problem Essence & Combinatorial Recursion
## *1. Bản chất vấn đề & Đệ quy Tổ hợp*

### The Challenge
### *Thách thức*
A derangement is a permutation where for every index $i$, $A[i] \ne i$. We need to count how many such permutations exist for $n$ elements.
*Một hoán vị không cố định là một hoán vị mà với mọi chỉ số $i$, $A[i] \ne i$. Chúng ta cần đếm xem có bao nhiêu hoán vị như vậy tồn tại cho $n$ phần tử.*

This is a classic problem in combinatorics involving recursive relations.
*Đây là một bài toán kinh điển trong toán tổ hợp liên quan đến các quan hệ đệ quy.*

---

## 2. Strategy: Dynamic Programming with Subproblem Reduction
## *2. Chiến lược: Quy hoạch động với Giảm bớt Bài toán con*

Let $D_n$ be the number of derangements of $n$ elements.
*Gọi $D_n$ là số lượng hoán vị không cố định của $n$ phần tử.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Placement of Element 1:** Suppose we place the first element in the $i$-th position. There are $n-1$ choices for $i$ (any position except index 1).
    * **Vị trí của Phần tử 1:** Giả sử chúng ta đặt phần tử đầu tiên vào vị trí thứ $i$. Có $n-1$ lựa chọn cho $i$ (bất kỳ vị trí nào ngoại trừ chỉ số 1).*

2.  **Handling Element $i$:** Now we consider where the original element from the $i$-th position goes:
    * **Xử lý Phần tử $i$:** Bây giờ chúng ta xem xét phần tử ban đầu ở vị trí thứ $i$ sẽ đi đâu:*
    - **Case 1: Element $i$ is placed in position 1.** This "swaps" 1 and $i$. We are now left with a derangement problem for the remaining $n-2$ elements.
    - **Case 2: Element $i$ is NOT placed in position 1.** This means element $i$ cannot go to position 1, element 2 cannot go to position 2, ..., and so on. This is equivalent to a derangement problem for $n-1$ elements.

3.  **The Recurrence:** Combining these, we get:
    * **Công thức Đệ quy:** Kết hợp các trường hợp này, ta có:*
    - $D_n = (n - 1) * (D_{n-1} + D_{n-2})$

4.  **Base Cases:**
    - $D_1 = 0$ (A single element cannot be deranged).
    - $D_2 = 1$ (Only [2, 1] works).

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Space Optimization:** Since $D_n$ only depends on the previous two states ($D_{n-1}$ and $D_{n-2}$), we don't need a full $O(N)$ array. We can use three variables to keep memory usage $O(1)$.
    * **Tối ưu hóa Không gian:** Vì $D_n$ chỉ phụ thuộc vào hai trạng thái trước đó, chúng ta không cần một mảng $O(N)$ đầy đủ. Chúng ta có thể sử dụng ba biến để giữ mức sử dụng bộ nhớ ở mức $O(1)$.*
*   **Modulo Operations:** At each addition and multiplication, we must take the modulo to prevent overflow.
    * **Phép toán Modulo:** Tại mỗi phép cộng và nhân, chúng ta phải lấy modulo để ngăn chặn tràn số.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We iterate from 1 to $N$ once.
    * **Độ phức tạp thời gian:** $O(N)$. Chúng ta duyệt qua từ 1 đến $N$ một lần.*
*   **Space Complexity:** $O(1)$ with space optimization.
    * **Độ phức tạp không gian:** $O(1)$ với tối ưu hóa không gian.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**n = 3**
1. $D_1 = 0$.
2. $D_2 = 1$.
3. $D_3 = (3-1) * (D_2 + D_1) = 2 * (1 + 0) = 2$.
**Result:** 2.

**n = 4**
1. $D_4 = (4-1) * (D_3 + D_2) = 3 * (2 + 1) = 9$.
**Result:** 9.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Derangement problems are a great example of how a complex combinatorial task can be broken down into smaller instances of the same problem. This "divide and conquer" approach leads directly to an efficient linear DP solution.
*Bài toán hoán vị không cố định là một ví dụ tuyệt vời về cách một nhiệm vụ tổ hợp phức tạp có thể được chia nhỏ thành các trường hợp nhỏ hơn của cùng một vấn đề. Cách tiếp cận "chia để trị" này dẫn thẳng đến một giải pháp DP tuyến tính hiệu quả.*
---
*Mọi sự thay đổi (Permutation) đều mang tính hệ thống. Trong âm hưởng của toán học, một hoán vị không cố định (Derangement) là một sự xáo trộn hoàn hảo (Perfect chaos), nơi không ai còn ở vị trí cũ (No Fixed Point). Dữ liệu dạy ta rằng từ những mảnh vỡ của sự phá vỡ trật tự, ta có thể tìm thấy một quy luật đệ quy (Recurrence) bền vững để định lượng sự hỗn loạn.*
Every change (Permutation) is systematic. In the resonance of mathematics, a derangement (Derangement) is a perfect disorder (Perfect chaos), where no one remains in their old position (No Fixed Point). Data teaches us that from the fragments of order-breaking, we can find a sustainable recursive rule (Recurrence) to quantify chaos.

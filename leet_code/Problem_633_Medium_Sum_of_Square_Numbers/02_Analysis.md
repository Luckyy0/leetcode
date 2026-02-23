# Analysis for Sum of Square Numbers
# *Phân tích cho bài toán Tổng của hai Số Chính phương*

## 1. Problem Essence & Square Property
## *1. Bản chất vấn đề & Thuộc tính Số chính phương*

### The Challenge
### *Thách thức*
We need to determine if an integer $c$ can be decomposed into the sum of two squares: $a^2 + b^2 = c$.
*Chúng ta cần xác định xem một số nguyên $c$ có thể phân tách thành tổng của hai số chính phương hay không: $a^2 + b^2 = c$.*

This is a classic variation of the "Two Sum" problem, but instead of searching a list, we are searching the domain of perfect squares.
*Đây là một biến thể kinh điển của bài toán "Two Sum", nhưng thay vì tìm kiếm trong một danh sách, chúng ta đang tìm kiếm trong miền của các số chính phương.*

---

## 2. Strategy: Two Pointers within sqrt(c)
## *2. Chiến lược: Hai con trỏ trong phạm vi căn bậc hai của c*

Since $a^2$ and $b^2$ must be at most $c$, both $a$ and $b$ must be in the range $[0, \sqrt{c}]$.
*Vì $a^2$ và $b^2$ tối đa phải là $c$, cả $a$ và $b$ phải nằm trong phạm vi $[0, \sqrt{c}]$.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Search Boundaries:** Initialize `left = 0` and `right = floor(sqrt(c))`.
    * **Ranh giới Tìm kiếm:** Khởi tạo `left = 0` và `right = floor(sqrt(c))`.*

2.  **Pointer Movement:** Calculate the sum of squares $S = left^2 + right^2$.
    * **Di chuyển Con trỏ:** Tính tổng các số chính phương $S = left^2 + right^2$.*
    - If $S == c$: **Found.** Return `true`.
    - If $S < c$: The current sum is too small. Since `right` is at its maximum for the current `left`, we must increase `left` to increase the sum.
    - If $S > c$: The current sum is too large. We must decrease `right` to decrease the sum.

3.  **Termination:** If `left > right` without finding a match, no such combination exists. Return `false`.
    * **Kết thúc:** Nếu `left > right` mà không tìm thấy kết quả phù hợp, không tồn tại sự kết hợp nào như vậy. Trả về `false`.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Efficiency:** The space of $a$ and $b$ is $O(\sqrt{c})$. Two pointers allow us to search this linearly rather than using a nested $O(c)$ loop.
    * **Hiệu suất:** Không gian của $a$ và $b$ là $O(\sqrt{c})$. Hai con trỏ cho phép chúng ta tìm kiếm theo đường thẳng thay vì sử dụng vòng lặp lồng nhau $O(c)$.*
*   **Integer Overflow:** Note that $a^2 + b^2$ can exceed the range of a 32-bit signed integer if not handled carefully (though $c$ itself is within range). Using `long` for intermediate calculations is safer.
    * **Tràn số Nguyên:** Lưu ý rằng $a^2 + b^2$ có thể vượt quá phạm vi của số nguyên có dấu 32-bit nếu không được xử lý cẩn thận (mặc dù bản thân $c$ nằm trong phạm vi). Sử dụng kiểu `long` cho các phép tính trung gian sẽ an toàn hơn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\sqrt{c})$. We perform a linear scan from $0$ to $\sqrt{c}$.
    * **Độ phức tạp thời gian:** $O(\sqrt{c})$. Chúng ta thực hiện một lần quét tuyến tính từ $0$ đến $\sqrt{c}$.*
*   **Space Complexity:** $O(1)$. No extra data structures are used.
    * **Độ phức tạp không gian:** $O(1)$. Không sử dụng cấu trúc dữ liệu bổ sung nào.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** c = 5
1. left = 0, right = 2. $0^2 + 2^2 = 4 < 5$. 
2. Increment left: left = 1, right = 2. $1^2 + 2^2 = 5$. 
**Result:** Match found. Return `true`.

**Input:** c = 3
1. left = 0, right = 1. $0^2 + 1^2 = 1 < 3$.
2. Increment left: left = 1, right = 1. $1^2 + 1^2 = 2 < 3$.
3. Increment left: left = 2, right = 1. Termination condition `left > right` met.
**Result:** Return `false`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The Two Pointers technique is powerful when you have a sorted range of candidates. Since integers $x$ always have $x^2 \ge (x-1)^2$, the squares are implicitly sorted, making this approach ideal for sum detection.
*Kỹ thuật Hai con trỏ rất mạnh mẽ khi bạn có một phạm vi ứng cử viên đã được sắp xếp. Vì các số nguyên $x$ luôn có $x^2 \ge (x-1)^2$, các số chính phương mặc nhiên được sắp xếp, giúp cách tiếp cận này trở nên lý tưởng cho việc phát hiện tổng.*
---
*Mọi sự tồn tại (Number c) có thể là sự cộng hưởng của những thái cực hoàn hảo (Squares). Trong toán học, việc đi tìm những "mảnh ghép" $(a, b)$ đòi hỏi sự cân bằng giữa sự tối thiểu (Left) và tối đa (Right). Dữ liệu dạy ta rằng thay vì tìm kiếm mù quáng, việc thu hẹp dần ranh giới (Two Pointers) giúp ta chạm tới chân lý một cách chính xác và hiệu quả nhất.*
Every existence (Number c) can be a resonance of perfect extremes (Squares). In mathematics, looking for "puzzle pieces" $(a, b)$ requires a balance between minimum (Left) and maximum (Right). Data teaches us that instead of searching blindly, gradually narrowing the boundary (Two Pointers) helps us reach the truth in the most accurate and efficient way.

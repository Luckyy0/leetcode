# Analysis for Pascal's Triangle
# *Phân tích cho bài toán Tam Giác Pascal*

## 1. Mathematical Foundation
## *1. Cơ sở Toán học*

### Definition
### *Định nghĩa*
*   Pascal's Triangle is a geometric arrangement of binomial coefficients.
    *Tam giác Pascal là một cách sắp xếp hình học của các hệ số nhị thức.*
*   Each entry at row $n$ and column $k$ is given by the combination formula: $\binom{n}{k} = \frac{n!}{k!(n-k)!}$.
    *Mỗi mục tại hàng $n$ và cột $k$ được đưa ra bởi công thức tổ hợp: $\binom{n}{k} = \frac{n!}{k!(n-k)!}$.*

### Construction Rule
### *Quy tắc xây dựng*
The triangle starts with a single `1` at the top (Row 0). Every entry of each subsequent row is constructed by adding the number above and to the left with the number above and to the right, treating blank spaces as `0`.
*Tam giác bắt đầu với một số `1` duy nhất ở đỉnh (Hàng 0). Mỗi mục của mỗi hàng tiếp theo được xây dựng bằng cách cộng số ở trên bên trái với số ở trên bên phải, coi các khoảng trống là `0`.*

Mathematically: `Triangle[i][j] = Triangle[i-1][j-1] + Triangle[i-1][j]`.
*Về mặt toán học: `Triangle[i][j] = Triangle[i-1][j-1] + Triangle[i-1][j]`.*

---

## 2. Algorithmic Approach: Dynamic Programming Simulation
## *2. Hướng tiếp cận: Mô phỏng Quy hoạch động*

Since each row depends purely on the row immediately preceding it, this problem is a classic example of iterative simulation.
*Vì mỗi hàng hoàn toàn phụ thuộc vào hàng ngay trước đó, bài toán này là một ví dụ điển hình về mô phỏng lặp.*

### Implementation Steps
### *Các bước triển khai*
1.  Initialize a list of lists `triangle`.
    *Khởi tạo một danh sách các danh sách `triangle`.*
2.  The first row is always `[1]`. Add it to `triangle`.
    *Hàng đầu tiên luôn là `[1]`. Thêm nó vào `triangle`.*
3.  Loop from `i = 1` to `numRows - 1`:
    -   Create a new list `row`.
    -   Get the `prevRow = triangle.get(i-1)`.
    -   The first element of `row` is always `1`.
        *Phần tử đầu tiên của hàng luôn là `1`.*
    -   For each element between the first and last (`j` from 1 to `i - 1`):
        -   `row[j] = prevRow[j-1] + prevRow[j]`.
    -   The last element of `row` is always `1`.
        *Phần tử cuối cùng của hàng luôn là `1`.*
    -   Add `row` to `triangle`.

---

## 3. Structural Properties
## *3. Các đặc tính cấu trúc*

*   **Symmetry:** Pascal's Triangle is symmetric. The values at index `j` and `i-j` in row `i` are identical.
    *Tính đối xứng: Tam giác Pascal có tính đối xứng. Các giá trị tại chỉ số `j` và `i-j` trong hàng `i` là giống hệt nhau.*
*   **Row Sums:** The sum of elements in row $n$ is $2^n$.
    *Tổng hàng: Tổng các phần tử trong hàng $n$ là $2^n$.*
*   **Number of Elements:** Row $n$ has $n+1$ elements.
    *Số lượng phần tử: Hàng $n$ có $n+1$ phần tử.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(numRows^2)$. The number of elements in the triangle is $\frac{numRows \times (numRows + 1)}{2}$. Since we calculate each element once using a simple addition, the total time is proportional to the number of elements.
    *Độ phức tạp thời gian: $O(numRows^2)$. Số lượng phần tử trong tam giác là $\frac{numRows \times (numRows + 1)}{2}$. Vì chúng ta tính toán mỗi phần tử một lần bằng phép cộng đơn giản, tổng thời gian tỷ lệ thuận với số lượng phần tử.*
*   **Space Complexity:** $O(numRows^2)$. This is the space required to store the returned list of lists containing all the values of the triangle.
    *Độ phức tạp không gian: $O(numRows^2)$. Đây là không gian cần thiết để lưu trữ danh sách các danh sách được trả về chứa tất cả các giá trị của tam giác.*

---

## 5. Summary Recommendation
## *5. Khuyến nghị tổng kết*

This is a fundamental array manipulation problem. The key is to manage the indices correctly, specifically ensuring that you don't access out-of-bounds elements from the previous row. Using the boundaries (first and last elements as 1) simplifies the internal logic significantly.
*Đây là một bài toán thao tác mảng cơ bản. Chìa khóa là quản lý các chỉ số một cách chính xác, cụ thể là đảm bảo bạn không truy cập các phần tử ngoài phạm vi từ hàng trước đó. Sử dụng các biên (phần tử đầu tiên và cuối cùng là 1) giúp đơn giản hóa logic bên trong một cách đáng kể.*
---
*Vẻ đẹp của tam giác Pascal nằm ở sự đơn giản của quy tắc cộng, từ đó tạo ra những dãy số phức tạp trong toán học.*
The beauty of Pascal's triangle lies in the simplicity of the addition rule, which in turn creates complex numerical sequences in mathematics.

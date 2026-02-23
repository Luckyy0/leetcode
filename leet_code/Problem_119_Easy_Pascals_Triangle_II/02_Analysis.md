# Analysis for Pascal's Triangle II
# *Phân tích cho bài toán Tam Giác Pascal II*

## 1. Dimensional Optimization
## *1. Tối ưu hóa kích thước*

### The Challenge
### *Thách thức*
*   While the previous problem (118) asked for the *entire* triangle, this problem only asks for a *single specific row*.
    *Mặc dù bài toán trước (118) yêu cầu toàn bộ tam giác, bài toán này chỉ yêu cầu một hàng cụ thể.*
*   The brute-force way is to generate the whole triangle $O(N^2)$ and return the last row. However, we are challenged to use only $O(rowIndex)$ extra space.
    *Cách làm thô bạo là tạo ra toàn bộ tam giác $O(N^2)$ và trả về hàng cuối cùng. Tuy nhiên, chúng ta được thách thức chỉ sử dụng không gian bổ sung $O(rowIndex)$.*

---

## 2. Approach 1: In-Place Row Update ($O(N)$ Space)
## *2. Hướng tiếp cận 1: Cập nhật hàng tại chỗ (Không gian O(N))*

### Logic
### *Logic*
We can maintain a single list and update it iteratively. To avoid overwriting values we still need, we process each row **from right to left**.
*Chúng ta có thể duy trì một danh sách duy nhất và cập nhật nó lặp đi lặp lại. Để tránh ghi đè các giá trị vẫn còn cần thiết, chúng ta xử lý mỗi hàng **từ phải sang trái**.*

*   Start with `row = [1, 0, 0, ...]`.
*   For each new row index `i`:
    -   `row[i] = 1`.
    -   For `j` from `i-1` down to `1`:
        -   `row[j] = row[j] + row[j-1]`.
*   By going backwards, `row[j]` is updated using its old value and the value to its left `row[j-1]`, both of which are from the *previous* virtual row.
    *Bằng cách đi ngược lại, `row[j]` được cập nhật bằng giá trị cũ của nó và giá trị bên trái `row[j-1]`, cả hai đều thuộc về hàng ảo trước đó.*

---

## 3. Approach 2: Direct Formula (Optimal)
## *3. Hướng tiếp cận 2: Công thức trực tiếp (Tối ưu)*

### Mathematical Insight
### *Cơ sở Toán học*
Each element in row $n$ is a combination $\binom{n}{k}$.
*Mỗi phần tử trong hàng $n$ là một tổ hợp $\binom{n}{k}$.*
The relationship between adjacent elements is: $\binom{n}{k} = \binom{n}{k-1} \times \frac{n-k+1}{k}$.
*Mối liên hệ giữa các phần tử liền kề là: $\binom{n}{k} = \binom{n}{k-1} \times \frac{n-k+1}{k}$.*

### Implementation detail
### *Chi tiết triển khai*
Using this formula, we can compute each element in $O(1)$ based on the previous one. However, we must use `long` to prevent integer overflow during the intermediate multiplication $current \times (n-k+1)$.
*Sử dụng công thức này, chúng ta có thể tính toán mỗi phần tử trong $O(1)$ dựa trên phần tử trước đó. Tuy nhiên, chúng ta phải sử dụng kiểu `long` để ngăn tràn số nguyên trong quá trình nhân trung gian $current \times (n-k+1)$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(rowIndex)$. If using the mathematical formula, we only perform $N$ multiplications and divisions. (Using the in-place update method would be $O(rowIndex^2)$).
    *Độ phức tạp thời gian: $O(rowIndex)$. Nếu sử dụng công thức toán học, chúng ta chỉ thực hiện $N$ phép nhân và chia. (Sử dụng phương pháp cập nhật tại chỗ sẽ là $O(rowIndex^2)$).*
*   **Space Complexity:** $O(rowIndex)$. We only need to store the resulting row.
    *Độ phức tạp không gian: $O(rowIndex)$. Chúng ta chỉ cần lưu trữ hàng kết quả.*

---

## 5. Summary Recommendation
## *5. Khuyến nghị tổng kết*

While the in-place update (right-to-left) is more intuitive for those who just finished Problem 118, the mathematical combination formula is the "Gold Standard" for this problem. It achieves true linear time $O(N)$ and satisfies the space constraint perfectly.
*Trong khi cập nhật tại chỗ (từ phải sang trái) trực quan hơn đối với những người vừa hoàn thành Bài 118, công thức tổ hợp toán học là "Tiêu chuẩn Vàng" cho bài toán này. Nó đạt được thời gian tuyến tính thực sự $O(N)$ và thỏa mãn hoàn hảo ràng buộc không gian.*
---
*Toán học thường cung cấp những phím tắt tuyệt vời để tối ưu hóa mã nguồn từ bậc bình phương xuống bậc tuyến tính.*
Mathematics often provides excellent shortcuts to optimize source code from quadratic to linear time.

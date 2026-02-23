# Analysis for Triangle
# *Phân tích cho bài toán Tam Giác*

## 1. Problem Essence & Decision Making
## *1. Bản chất của bài toán & Đưa ra quyết định*

### Structure of the Triangle
### *Cấu trúc của Tam giác*
*   The input is a list of lists representing a triangle. Each row has one more element than the previous row.
    *Đầu vào là một danh sách các danh sách đại diện cho một hình tam giác. Mỗi hàng có nhiều hơn hàng trước đó một phần tử.*
*   From index `j` in row `i`, you can move to `j` or `j+1` in row `i+1`.
    *Từ chỉ số `j` ở hàng `i`, bạn có thể di chuyển đến `j` hoặc `j+1` ở hàng `i+1`.*

### The Objective
### *Mục tiêu*
*   Find the shortest (minimum sum) path from the apex (top) to the base (bottom).
    *Tìm con đường ngắn nhất (tổng tối thiểu) từ đỉnh xuống đáy.*
*   This is a classic optimization problem where greedy choices don't work (choosing the smallest neighbor at each step locally might lead to a dead-end with very large numbers later).
    *Đây là một bài toán tối ưu hóa cổ điển mà các lựa chọn tham lam không hoạt động (việc chọn người hàng xóm nhỏ nhất ở mỗi bước cục bộ có thể dẫn đến bế tắc với các số rất lớn sau này).*

---

## 2. Approach: Dynamic Programming (Bottom-Up)
## *2. Hướng tiếp cận: Quy hoạch động (Từ dưới lên)*

While Top-Down DP with memoization is possible, **Bottom-Up DP** is cleaner and more efficient for this specific structure.
*Mặc dù DP Từ trên xuống với ghi nhớ là có thể, nhưng **DP Từ dưới lên** sạch sẽ và hiệu quả hơn cho cấu trúc cụ thể này.*

### Logic
### *Logic*
1.  Instead of starting at the top, we start at the penultimate (second to last) row.
    *Thay vì bắt đầu từ đỉnh, chúng ta bắt đầu từ hàng áp chót.*
2.  For each element in the current row, its minimum path sum to the bottom is:
    `Value[i][j] + min(PathSumToBottom[i+1][j], PathSumToBottom[i+1][j+1])`.
    *Đối với mỗi phần tử ở hàng hiện tại, tổng đường đi tối thiểu của nó xuống đáy là: `Giá trị[i][j] + min(TổngĐườngĐiĐáy[i+1][j], TổngĐườngĐiĐáy[i+1][j+1])`.*
3.  We propagate these minimum sums upward until we reach the root at `[0][0]`.
    *Chúng ta truyền các tổng tối thiểu này lên trên cho đến khi đạt được gốc tại `[0][0]`.*

---

## 3. Dimensional Optimization ($O(N)$ Space)
## *3. Tối ưu hóa kích thước (Không gian O(N))*

The Follow-up asks for $O(N)$ extra space, where $N$ is the number of rows.
*Yêu cầu bổ sung yêu cầu không gian $O(N)$, trong đó $N$ là số hàng.*

*   We only need the information from the row directly below the one we are currently processing.
    *Chúng ta chỉ cần thông tin từ hàng ngay bên dưới hàng chúng ta đang xử lý.*
*   We can use a 1D array `dp` of size $N$ (number of elements in the last row).
    *Chúng ta có thể sử dụng mảng 1 chiều `dp` kích thước $N$ (số lượng phần tử ở hàng cuối).*
*   Initialize `dp` with the values of the last row of the triangle.
    *Khởi tạo `dp` với các giá trị của hàng cuối cùng của tam giác.*
*   Iterate from the second to last row up to the top row:
    -   Update `dp[j] = Triangle[i][j] + min(dp[j], dp[j+1])`.
*   After the loops, `dp[0]` will contain the result.

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$, where $N$ is the number of rows. We visit each element of the triangle exactly once. The total number of elements is $\frac{N(N+1)}{2}$.
    *Độ phức tạp thời gian: $O(N^2)$, trong đó $N$ là số hàng. Chúng ta truy cập mỗi phần tử của tam giác đúng một lần. Tổng số phần tử là $\frac{N(N+1)}{2}$.*
*   **Space Complexity:** $O(N)$. We use an auxiliary 1D array to store the minimum path sums of the "current" row being processed.
    *Độ phức tạp không gian: $O(N)$. Chúng ta sử dụng một mảng 1 chiều phụ trợ để lưu trữ các tổng đường đi tối thiểu của hàng "hiện tại" đang được xử lý.*

---

## 5. Summary Recommendation
## *5. Khuyến nghị tổng kết*

Bottom-up DP is superior here because it naturally avoids the boundary checks required by top-down (e.g., checking if `j-1` or `j` is valid when moving down). By starting from the bottom and working upwards, the "apex" naturally converges to the final answer.
*DP từ dưới lên vượt trội hơn ở đây vì nó tự nhiên tránh được các kiểm tra biên theo yêu cầu của từ trên xuống. Bằng cách bắt đầu từ đáy và làm việc ngược lên, "đỉnh" sẽ hội tụ một cách tự nhiên về câu trả lời cuối cùng.*
---
*Kỹ thuật chuyển đổi từ 2D xuống 1D là một trong những cách tối ưu hóa không gian kinh điển nhất trong Quy hoạch động.*
The technique of converting from 2D to 1D is one of the most classic space optimizations in Dynamic Programming.

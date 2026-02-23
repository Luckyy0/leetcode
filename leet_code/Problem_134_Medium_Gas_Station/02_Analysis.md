# Analysis for Gas Station
# *Phân tích cho bài toán Trạm Xăng*

## 1. Mathematical Logic & Intuition
## *1. Logic Toán Học & Trực Giác*

### The Feasibility Condition
### *Điều Kiện Khả Thi*
*   First, the total amount of gas available across all stations must be greater than or equal to the total cost to travel the entire loop.
    *Đầu tiên, tổng lượng xăng có sẵn tại tất cả các trạm phải lớn hơn hoặc bằng tổng chi phí để đi hết toàn bộ vòng lặp.*
*   If `sum(gas) < sum(cost)`, it is mathematically impossible to complete the circuit, and we should return `-1`.
    *Nếu `sum(gas) < sum(cost)`, thì về mặt toán học không thể hoàn thành vòng lặp, và chúng ta nên trả về `-1`.*

### The Greedy Insight
### *Cái Nhìn Tham Lam*
*   Suppose we start at station `A` and get "stuck" at station `B` (meaning we run out of gas between `A` and `B`).
    *Giả sử chúng ta bắt đầu tại trạm `A` và bị "kẹt" tại trạm `B` (nghĩa là chúng ta hết xăng giữa `A` và `B`).*
*   This implies that starting at **any** station between `A` and `B` would also result in getting stuck. Why? Because starting at `A` gave us some non-negative gas surplus (or zero) as we arrived at those intermediate stations. If starting with a surplus didn't help us pass `B`, starting with an empty tank surely won't.
    *Điều này ngụ ý rằng việc bắt đầu tại **bất kỳ** trạm nào giữa `A` và `B` cũng sẽ dẫn đến việc bị kẹt. Tại sao? Bởi vì bắt đầu tại `A` đã mang lại cho chúng ta một lượng xăng thừa không âm (hoặc bằng không) khi chúng ta đến các trạm trung gian đó. Nếu việc bắt đầu với một lượng xăng thừa không giúp chúng ta vượt qua `B`, thì việc bắt đầu với một bình xăng trống chắc chắn sẽ không thể.*
*   Therefore, if we get stuck at `B`, our next potential starting station should be `B + 1`.
    *Do đó, nếu chúng ta bị kẹt tại `B`, trạm bắt đầu tiềm năng tiếp theo của chúng ta nên là `B + 1`.*

---

## 2. Approach: Single Pass Greedy ($O(N)$)
## *2. Hướng Tiếp Cận: Tham Lam Một Lần Duyệt (O(N))*

### Logic
### *Logic*
1.  Initialize `totalGas = 0`, `currentGas = 0`, and `startStation = 0`.
2.  Iterate through each station `i`:
    -   `totalGas += gas[i] - cost[i]`.
    -   `currentGas += gas[i] - cost[i]`.
    -   If `currentGas < 0`:
        -   Reset `currentGas = 0`.
        -   Set `startStation = i + 1`. (We failed to reach the next station, so try starting from the next one).
            *Đặt `startStation = i + 1`. (Chúng ta không tới được trạm tiếp theo, vì vậy hãy thử bắt đầu từ trạm kế).*
3.  After the loop:
    -   If `totalGas < 0`, return `-1`.
    -   Otherwise, return `startStation`.

---

## 3. Structural Advantages: Why Single Pass?
## *3. Ưu Điểm Cấu Trúc: Tại Sao Một Lần Duyệt?*

*   **Linear Efficiency:** The brute force approach would try starting at every station $O(N)$ and simulating the circuit $O(N)$, resulting in $O(N^2)$. The greedy insight reduces this to $O(N)$.
    *Hiệu Quả Tuyến Tính: Cách tiếp cận thô bạo sẽ thử bắt đầu tại mọi trạm $O(N)$ và mô phỏng vòng lặp $O(N)$, dẫn đến $O(N^2)$. Cái nhìn tham lam giảm con số này xuống $O(N)$.*
*   **One Condition for Success:** The fact that `totalGas >= 0` guarantees *some* starting point exists is a powerful mathematical property of this specific problem.
    *Thực tế là `totalGas >= 0` đảm bảo tồn tại *một số* điểm bắt đầu là một đặc tính toán học mạnh mẽ của bài toán cụ thể này.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We only traverse the gas and cost arrays once.
    *Độ phức tạp thời gian: $O(N)$. Chúng ta chỉ duyệt qua các mảng xăng và chi phí một lần duy nhất.*
*   **Space Complexity:** $O(1)$. We only use a constant amount of extra space for variables like `totalGas`, `currentGas`, and `startStation`.
    *Độ phức tạp không gian: $O(1)$. Chúng ta chỉ sử dụng một lượng không gian bổ sung hằng số cho các biến như `totalGas`, `currentGas` và `startStation`.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

`gas = [1,2,3,4,5], cost = [3,4,5,1,2]`
`diff = [-2, -2, -2, 3, 3]`

-   `i=0`: `currentGas = -2`. Reset! `start = 1`.
-   `i=1`: `currentGas = -2`. Reset! `start = 2`.
-   `i=2`: `currentGas = -2`. Reset! `start = 3`.
-   `i=3`: `currentGas = 3`.
-   `i=4`: `currentGas = 3 + 3 = 6`.
Loop End. `totalGas = (-2) + (-2) + (-2) + 3 + 3 = 0`.
`totalGas >= 0`, so Result: 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

The greedy solution is the elegant and optimal way to address this circular dependency problem. The key trick is understanding that failures at a station invalidate all preceding stations in that specific sequence. This is a common pattern in array-based optimization problems where prefixes matter.
*Giải pháp tham lam là cách trang nhã và tối ưu để giải quyết bài toán phụ thuộc vòng tròn này. Thủ thuật then chốt là hiểu rằng sự thất bại tại một trạm sẽ vô hiệu hóa tất cả các trạm đứng trước trong chuỗi cụ thể đó. Đây là một mô hình phổ biến trong các bài toán tối ưu hóa dựa trên mảng nơi các tiền tố đóng vai trò quan trọng.*
---
*Đôi khi điểm kết thúc thực sự của một hành trình thất bại lại chính là điểm khởi đầu mới đầy hứa hẹn.*
Sometimes the actual end of a failed journey is exactly the promising new starting point.

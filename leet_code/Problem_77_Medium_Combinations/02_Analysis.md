# Analysis for Combinations
# *Phân tích cho bài toán Tổ Hợp*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Integers `n` and `k`. *Hai số nguyên `n` và `k`.*
*   **Output:** List of all combinations. *Danh sách tất cả các tổ hợp.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `n` is small (up to 20).
*   Need to find all subsets of size `k`.
*   *`n` nhỏ (lên tới 20).*
*   *Cần tìm tất cả các tập con có kích thước `k`.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Backtracking
### *Hướng tiếp cận: Quay lui*

*   **Intuition:** Starting from 1, recursively choice numbers to include in the current combination. Once the combination size reaches `k`, add it to the result.
*   *Ý tưởng: Bắt đầu từ 1, chọn các số theo cách đệ quy để đưa vào tổ hợp hiện tại. Khi kích thước tổ hợp đạt tới `k`, hãy thêm nó vào kết quả.*

*   **Optimization:** In the loop `for i from start to n`, we can stop early if there aren't enough numbers left to reach size `k`. The loop limit can be `n - (k - combination.size()) + 1`.
*   *Tối ưu hóa: Trong vòng lặp `for i từ start đến n`, chúng ta có thể dừng sớm nếu không còn đủ số để đạt tới kích thước `k`. Giới hạn vòng lặp có thể là `n - (k - combination.size()) + 1`.*

*   **Complexity:**
    *   Time: $O(k \cdot \binom{n}{k})$.
    *   Space: $O(k)$ for recursion depth.

### Dry Run
### *Chạy thử*
`n = 4, k = 2`
1. Start with 1. List: `[1]`.
   - Remaining needed: 1. Try 2: `[1, 2]`. (Size 2, Add to result).
   - Try 3: `[1, 3]`. (Size 2, Add to result).
   - Try 4: `[1, 4]`. (Size 2, Add to result).
2. Start with 2. List: `[2]`.
   - Try 3: `[2, 3]`. (Size 2, Add to result).
   - Try 4: `[2, 4]`. (Size 2, Add to result).
3. Start with 3. List: `[3]`.
   - Try 4: `[3, 4]`. (Size 2, Add to result).
Result: `[[1,2], [1,3], [1,4], [2,3], [2,4], [3,4]]`.
---
*Quay lui là phương pháp tự nhiên để liệt kê mọi khả năng của cấu trúc tổ hợp.*
Backtracking is the natural method to list all possibilities of combinatorial structures.

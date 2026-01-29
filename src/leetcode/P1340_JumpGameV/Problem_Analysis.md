# 1340. Jump Game V / Trò chơi Nhảy V

## Problem Description / Mô tả bài toán
Array `arr`, jump range `d`.
Can jump from `i` to `j` if:
- `i + 1 <= j <= i + d` OR `i - d <= j <= i - 1`
- `arr[j] < arr[i]`
- All elements between `i` and `j` must specify `arr[k] < arr[i]`. (Wait, condition is "You can jump ... and `arr[i] > arr[j]` and `arr[i] > arr[k]` for all `k` in between").
Max jumps visiting from optimal start.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming with Sorting / Memoization
`dp[i]` = max steps starting from `i`.
Since we only jump to smaller values, there are no cycles. This is a DAG.
We can use memoization.
`dfs(i)`:
  Try all valid `j` left and right.
  Stop direction if blocked (value >= `arr[i]`).
  `res = 1 + max(dfs(j))`.

### Complexity / Độ phức tạp
- **Time**: O(N * D).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: DFS with Memoization
Define `dp[i]` as the maximum number of indices achievable starting from index `i`.
For each index `i`, we can jump to `j` in `[i-d, i-1]` or `[i+1, i+d]`.
Constraint: all elements between `i` and `j` (exclusive of `i`, inclusive of `j`) must be less than `arr[i]`.
Wait, actually condition: "all values between index i and j indices (exclusive) must be less than arr[i]? And `arr[j] < arr[i]`".
Actually "You can check that... arr[k] < arr[i]".
Wait. The condition is strict. We cannot jump OVER a taller building.
So iterating left: if we meet `arr[k] >= arr[i]`, we stop checking further left.
We compute `dp[i]` using DFS with memoization. Since we always jump to smaller values, the recursion is finite.
Final answer is `max(dp[i])` for all `i`.
Xác định `dp[i]` là số lượng chỉ mục tối đa có thể đạt được bắt đầu từ chỉ mục `i`.
Đối với mỗi chỉ mục `i`, chúng ta có thể nhảy đến `j` trong `[i-d, i-1]` hoặc `[i+1, i+d]`.
Ràng buộc: tất cả các phần tử giữa `i` và `j` (không bao gồm `i`, bao gồm `j`) phải nhỏ hơn `arr[i]`.
Chờ đã, thực ra điều kiện: "tất cả các giá trị giữa chỉ mục i và j (không bao gồm) phải nhỏ hơn arr[i]? Và `arr[j] < arr[i]`".
Thực ra "Bạn có thể kiểm tra rằng... arr[k] < arr[i]".
Chờ đã. Điều kiện rất nghiêm ngặt. Chúng ta không thể nhảy QUA một tòa nhà cao hơn.
Vì vậy, lặp sang trái: nếu chúng ta gặp `arr[k] >= arr[i]`, chúng ta dừng kiểm tra xa hơn bên trái.
Chúng ta tính `dp[i]` bằng DFS với ghi nhớ. Vì chúng ta luôn nhảy đến các giá trị nhỏ hơn, đệ quy là hữu hạn.
Câu trả lời cuối cùng là `max(dp[i])` cho tất cả `i`.

---

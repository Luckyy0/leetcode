# 808. Soup Servings / Phục vụ Súp

## Problem Description / Mô tả bài toán
There are two types of soup: type A and type B. Initially, we have `n` ml of each type. There are four kinds of operations:
Có hai loại súp: loại A và loại B. Ban đầu, chúng ta có `n` ml mỗi loại. Có bốn loại thao tác:

1. Serve 100 ml of soup A and 0 ml of soup B.
2. Serve 75 ml of soup A and 25 ml of soup B.
3. Serve 50 ml of soup A and 50 ml of soup B.
4. Serve 25 ml of soup A and 75 ml of soup B.

Each operation has a probability of 0.25. If the remaining volume is less than needed, we serve whatever is left.
Mỗi thao tác có xác suất 0.25. Nếu thể tích còn lại ít hơn mức cần thiết, chúng ta phục vụ bất cứ thứ gì còn lại.

Return the probability that soup A will be empty first, plus half the probability that A and B become empty at the same time.
Trả về xác suất để súp A hết trước, cộng với một nửa xác suất để A và B cùng hết một lúc.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming with Large N / Quy hoạch Động với N lớn
This is a probability DP problem.
Đây là một bài toán quy hoạch động về xác suất.

Observation:
As `n` increases, soup A is consumed faster on average (A: 100, 75, 50, 25 vs B: 0, 25, 50, 75).
Khi `n` tăng lên, súp A trung bình được tiêu thụ nhanh hơn.

Crucially, for very large `n` (approx `n > 5000`), the probability is very close to 1.
Quan trọng là đối với `n` rất lớn (khoảng `n > 5000`), xác suất sẽ rất gần với 1.

Algorithm:
1. Divide `n` by 25 to reduce state space (let `N = ceil(n / 25)`).
2. If `N > 200`, return 1.
3. Use memoization `dp[a][b]` to calculate probabilities.
4. `dp[a][b] = 0.25 * (solve(a-4, b) + solve(a-3, b-1) + solve(a-2, b-2) + solve(a-1, b-3))`.

### Complexity / Độ phức tạp
- **Time**: O(M^2) where M is the threshold (scaled N).
- **Space**: O(M^2).

---

## Analysis / Phân tích

### Approach: Recursive Probability with Thresholding
Due to the statistical bias towards consuming A faster, the result converges rapidly towards 1. We only need to calculate for small values of N and can cap the computation for larger inputs.
Do sai lệch thống kê hướng tới việc tiêu thụ A nhanh hơn, kết quả sẽ hội tụ nhanh chóng về 1. Chúng ta chỉ cần tính toán cho các giá trị N nhỏ và có thể giới hạn tính toán cho các đầu vào lớn hơn.

---

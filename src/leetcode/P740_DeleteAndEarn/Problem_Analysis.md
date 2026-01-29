# 740. Delete and Earn / Xóa và Kiếm tiền

## Problem Description / Mô tả bài toán
You are given an integer array `nums`. You want to maximize the number of points you get by performing the following operation any number of times:
Bạn được cho một mảng số nguyên `nums`. Bạn muốn tối đa hóa số điểm bạn nhận được bằng cách thực hiện thao tác sau bất kỳ số lần nào:

- Pick any `nums[i]` and delete it to earn `nums[i]` points. Afterwards, you must delete **every** element equal to `nums[i] - 1` and **every** element equal to `nums[i] + 1`.

Return the maximum points you can earn.
Trả về số điểm tối đa bạn có thể kiếm được.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / House Robber Variation / Biến thể Ăn trộm nhà
This problem is equivalent to the "House Robber" problem.
Bài toán này tương đương với bài toán "Ăn trộm nhà".

1. Convert `nums` into an array `values` where `values[x]` is the total points if we pick all occurrences of `x`.
   `values[x] = count(x) * x`.
2. We cannot pick `x` if we picked `x-1` or `x+1`.
3. Standard DP:
   `dp[i] = max(dp[i-1], dp[i-2] + values[i])`.

### Complexity / Độ phức tạp
- **Time**: O(N + MaxVal) where N is the length of `nums`.
- **Space**: O(MaxVal).

---

## Analysis / Phân tích

### Approach: Reduction to House Robber
Sum up all occurrences of each number. Then, apply the dynamic programming logic where you decide between taking the current value (and skip the previous) or keep the previous best result.
Tổng hợp tất cả các lần xuất hiện của mỗi số. Sau đó, áp dụng logic quy hoạch động nơi bạn quyết định giữa việc lấy giá trị hiện tại (và bỏ qua giá trị trước đó) hoặc giữ lại kết quả tốt nhất trước đó.

---

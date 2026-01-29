# 997. Find the Town Judge / Tìm Thẩm phán Thị trấn

## Problem Description / Mô tả bài toán
In a town, there are `n` people. There is a rumor that one of these people is the town judge.
Trong một thị trấn có `n` người. Có tin đồn rằng một trong số những người này là thẩm phán của thị trấn.

The town judge satisfies:
- Trusts nobody.
- Everybody trusts the town judge.

Given `trust` array where `trust[i] = [a, b]` means person `a` trusts person `b`, return the town judge.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Indegree and Outdegree / Bậc vào và Bậc ra
Algorithm:
1. Maintain a `score` array of size `n+1`.
2. For each trust `[a, b]`:
   - `score[a]--` (Outdegree)
   - `score[b]++` (Indegree)
3. The town judge will have a score of `n - 1`.
4. If no such person exists, return -1.

### Complexity / Độ phức tạp
- **Time**: O(N + T) where T is trust length.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Net trust Balance
Quantify each person's standing by calculating the difference between how many people trust them and how many they trust. The unique character of the judge (trusted by all but trusting no one) results in a specific net score of $N-1$, making them easily identifiable in a single pass.
Định lượng vị thế của mỗi người bằng cách tính toán sự chênh lệch giữa số người tin tưởng họ và số người họ tin tưởng. Đặc điểm duy nhất của vị thẩm phán (được tất cả mọi người tin tưởng nhưng không tin tưởng ai) dẫn đến một số điểm ròng cụ thể là $N-1$, giúp họ dễ dàng được xác định trong một lần duyệt duy nhất.

---

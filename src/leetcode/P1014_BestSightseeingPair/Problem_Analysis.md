# 1014. Best Sightseeing Pair / Cặp Tham quan Tốt nhất

## Problem Description / Mô tả bài toán
You are given an integer array `values` where `values[i]` represents the value of the `i-th` sightseeing spot. Two sightseeing spots `i` and `j` have a distance `j - i` between them.
Bạn được cho một mảng số nguyên `values` trong đó `values[i]` đại diện cho giá trị của điểm tham quan thứ `i`. Hai điểm tham quan `i` và `j` có khoảng cách `j - i` giữa chúng.

The score of a pair `(i < j)` is `values[i] + values[j] + i - j`.
Điểm số của một cặp `(i < j)` là `values[i] + values[j] + i - j`.

Return the maximum score of a pair of sightseeing spots.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Decomposition / Quy hoạch Động / Phân tách
Rewrite the formula:
`score = (values[i] + i) + (values[j] - j)`.

To maximize this for a fixed `j`, we need to maximize `values[i] + i` for `i < j`.

Algorithm:
1. Iterate `j` from 1 to `n-1`.
2. Maintain `maxI = max(values[i] + i)` seen so far.
3. Update `maxScore = max(maxScore, maxI + values[j] - j)`.
4. Update `maxI = max(maxI, values[j] + j)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Decoupled Maximization
Separate the scoring function into two independent components: one dependent on the start index ($value[i] + i$) and one on the end index ($value[j] - j$). By tracking the historical maximum of the first component while iterating through potential second components, we compute the answer in a single pass.
Tách hàm tính điểm thành hai thành phần độc lập: một phụ thuộc vào chỉ số bắt đầu ($value[i] + i$) và một phụ thuộc vào chỉ số kết thúc ($value[j] - j$). Bằng cách theo dõi giá trị cực đại lịch sử của thành phần đầu tiên trong khi lặp qua các thành phần thứ hai tiềm năng, chúng ta tính toán câu trả lời trong một lần duyệt.

---

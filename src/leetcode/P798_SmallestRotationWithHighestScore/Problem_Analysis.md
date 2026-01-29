# 798. Smallest Rotation with Highest Score / Phép xoay nhỏ nhất có Điểm cao nhất

## Problem Description / Mô tả bài toán
You are given an array `nums`. You can rotate the array by a non-negative integer `k`. Then, the score is the number of indices `i` such that `nums[i] <= i`.
Bạn được cho một mảng `nums`. Bạn có thể xoay mảng theo một số nguyên không âm `k`. Khi đó, điểm số là số lượng chỉ số `i` sao cho `nums[i] <= i`.

Return the rotation `k` that has the highest score. If there are multiple answers, return the smallest such `k`.
Trả về phép xoay `k` có điểm số cao nhất. Nếu có nhiều câu trả lời, hãy trả về `k` nhỏ nhất.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Interval Contributions / Đóng góp của Khoảng
For each element `nums[i]`, identify the rotation `k` for which it contributes a point.
Đối với mỗi phần tử `nums[i]`, hãy xác định phép xoay `k` mà tại đó nó đóng góp một điểm.

An element `nums[i]` at index `i` (before rotation) will move to index `(i - k + N) % N` after rotation `k`.
Phần tử `nums[i]` tại chỉ số `i` sẽ di chuyển đến chỉ số `(i - k + N) % N` sau khi xoay `k`.
Condition: `nums[i] <= (i - k + N) % N`.

This condition is true for a range of `k`.
We can use a "difference array" (change markers) to update scores for these ranges.
Chúng ta có thể sử dụng một "mảng hiệu" để cập nhật điểm cho các phạm vi này.

Algorithm:
1. For each `i`, find the range of `k` values where `nums[i]` is **not** scoring.
2. Specifically, `nums[i]` stops scoring when its index becomes `nums[i] - 1`.
3. Total rotation `k` for which it loses scoring: `(i - nums[i] + 1 + N) % N`.
4. Marking: `bad[k]--` at the point it loses a point, and `bad[0]++` at the start.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Difference Matrix for Score Deltas
Instead of recalculating the score for every `k`, compute how the score **changes** as `k` increments. Summing these deltas gives the total score for each rotation.
Thay vì tính toán lại điểm cho mỗi `k`, hãy tính toán điểm số **thay đổi** như thế nào khi `k` tăng dần. Tổng hợp các thay đổi này sẽ cho điểm tổng cộng cho mỗi lần xoay.

---

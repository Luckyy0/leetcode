# 962. Maximum Width Ramp / Đường dốc có Chiều rộng Tối đa

## Problem Description / Mô tả bài toán
A ramp is a pair `(i, j)` with `i < j` and `nums[i] <= nums[j]`. The width of such a ramp is `j - i`.
Đường dốc là một cặp `(i, j)` với `i < j` và `nums[i] <= nums[j]`. Chiều rộng của đường dốc đó là `j - i`.

Given an integer array `nums`, return the maximum width of a ramp.
Cho một mảng số nguyên `nums`, hãy trả về chiều rộng lớn nhất của một đường dốc.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Monotonic Stack / Ngăn xếp Đơn điệu
We want to finding the best `i` for each `j`. Smaller `nums[i]` and smaller `i` are better.
Chúng ta muốn tìm `i` tốt nhất cho mỗi `j`. `nums[i]` nhỏ hơn và `i` nhỏ hơn sẽ tốt hơn.

Algorithm:
1. Build a monotonic decreasing stack of indices `i`. Only push `i` if `nums[i] < nums[stack.top()]`.
2. Iterate `j` from `n-1` to 0:
   - While the stack is not empty and `nums[stack.peek()] <= nums[j]`:
     - Update `maxWidth = max(maxWidth, j - stack.pop())`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Candidate Pre-selection
Identify a set of potential starting indices (candidates for $i$) that are progressively smaller. Then, scan the array from the end to match each $j$ with the earliest possible $i$ using the pre-built stack, popping consumed candidates to maximize width.
Xác định một tập hợp các chỉ số bắt đầu tiềm năng (ứng cử viên cho $i$) có giá trị nhỏ dần. Sau đó, quét mảng từ cuối để khớp mỗi $j$ với $i$ sớm nhất có thể bằng cách sử dụng ngăn xếp đã tạo trước đó, loại bỏ các ứng cử viên đã sử dụng để tối đa hóa chiều rộng.

---

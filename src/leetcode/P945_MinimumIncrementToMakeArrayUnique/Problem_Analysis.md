# 945. Minimum Increment to Make Array Unique / Số lượng Tăng Tối thiểu để Mảng trở nên Duy nhất

## Problem Description / Mô tả bài toán
Given an integer array `nums`, in one move, you can pick an index `i` and increment `nums[i]` by 1.
Cho một mảng số nguyên `nums`, trong mỗi bước, bạn có thể chọn một chỉ số `i` và tăng `nums[i]` thêm 1 đơn vị.

Return the minimum number of moves to make every value in `nums` unique.
Hãy trả về số lượng bước di chuyển tối thiểu để làm cho mọi giá trị trong `nums` trở nên duy nhất.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting and Greedy Adjustment / Sắp xếp và Điều chỉnh Tham lam
Algorithm:
1. Sort the `nums` array.
2. Iterate from `i = 1` to `n-1`:
   - If `nums[i] <= nums[i-1]`:
     - New value should be at least `nums[i-1] + 1`.
     - Increment `moves` by `(nums[i-1] + 1 - nums[i])`.
     - Update `nums[i] = nums[i-1] + 1`.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(log N).

---

## Analysis / Phân tích

### Approach: Consecutive Slot Allocation
Sort the input to process numbers in order. For each element, if it collides with or is smaller than the newly updated previous element, push it forward to the next available unique slot, tracking the total jump distance as the cost.
Sắp xếp đầu vào để xử lý các số theo thứ tự. Đối với mỗi phần tử, nếu nó trùng hoặc nhỏ hơn phần tử đứng trước vừa được cập nhật, hãy đẩy nó lên vị trí duy nhất tiếp theo có sẵn, theo dõi tổng khoảng cách nhảy như chi phí.

---

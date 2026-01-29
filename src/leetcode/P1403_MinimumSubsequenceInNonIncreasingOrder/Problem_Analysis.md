# 1403. Minimum Subsequence in Non-Increasing Order / Chuỗi con Tối thiểu theo Thứ tự Không tăng

## Problem Description / Mô tả bài toán
Array `nums`. Return subsequence with minimum size such that sum of subsequence > sum of remaining elements.
If multiple, choose max sum. Only one solution guaranteed unique by definition? "If multiple... return subsequence with maximum total sum".
Sort result non-increasing.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy
Sort descending.
Pick largest elements until `current_sum > total_sum - current_sum` (i.e. `current_sum > total / 2`).

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N) or O(log N).

---

## Analysis / Phân tích

### Approach: Sort and Greed
Calculate total sum. Sort `nums` in descending order. Iterate and add elements to a list, accumulating a `subSum`. Stop when `subSum > totalSum / 2`. The collected elements form the answer.
Tính tổng. Sắp xếp `nums` theo thứ tự giảm dần. Lặp lại và thêm các phần tử vào danh sách, tích lũy `subSum`. Dừng khi `subSum > totalSum / 2`. Các phần tử được thu thập tạo thành câu trả lời.

---

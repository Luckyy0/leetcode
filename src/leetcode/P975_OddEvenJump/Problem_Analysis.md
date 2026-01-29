# 975. Odd Even Jump / Nhảy Lẻ Chẵn

## Problem Description / Mô tả bài toán
You are given an integer array `arr`. From some starting index, you can make a series of jumps.
Bạn được cho một mảng số nguyên `arr`. Từ một chỉ số bắt đầu nào đó, bạn có thể thực hiện một loạt các bước nhảy.

Rules:
- **Odd jump** (1st, 3rd...): Jump to index `j > i` such that `arr[j]` is the smallest value $\ge$ `arr[i]`.
- **Even jump** (2nd, 4th...): Jump to index `j > i` such that `arr[j]` is the largest value $\le$ `arr[i]`.
If there are ties, pick the smallest index `j`.

A starting index is **good** if you can reach the end of the array. Return the number of good starting indices.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming and TreeMap / Quy hoạch Động và TreeMap
Algorithm:
1. `odd[i]` = true if we can reach the end starting from `i` with an odd jump.
2. `even[i]` = true if we can reach the end starting from `i` with an even jump.
3. Process the array from right to left.
4. Use a `TreeMap` to find the smallest value $\ge$ current and the largest value $\le$ current.
5. `odd[i] = even[next_odd_jump_idx]`
6. `even[i] = odd[next_even_jump_idx]`
7. Count indices where `odd[i]` is true.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Retroactive Reachability
Determine if an index is "good" by working backward from the goal. By storing previously visited values in a balanced search tree, we can instantly find the targets for both jump types and propagate the "reachability" status through the jump sequence.
Xác định xem một chỉ số là "tốt" hay không bằng cách làm việc ngược lại từ mục tiêu. Bằng cách lưu trữ các giá trị đã truy cập trước đó trong một cây tìm kiếm cân bằng, chúng ta có thể ngay lập tức tìm thấy các mục tiêu cho cả hai loại bước nhảy và lan truyền trạng thái "có thể đạt tới" thông qua chuỗi bước nhảy.

---

# 1215. Stepping Numbers / Số Bước Nhảy

## Problem Description / Mô tả bài toán
A Stepping Number is an integer such that all of its adjacent digits have an absolute difference of exactly 1.
Given `low` and `high`, find all stepping numbers in range `[low, high]`. sorted.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS / DFS Generation / Tạo BFS / DFS
Generate numbers digit by digit.
Start: 1, 2, ..., 9. (0 is special case if low=0).
From `u`, next digits are `last_digit +/- 1`.
Append to `u`: `u * 10 + next`.
If `u > high`, stop.
If `u >= low`, add to result.

### Complexity / Độ phức tạp
- **Time**: Number of stepping numbers up to high (small).
- **Space**: O(Results).

---

## Analysis / Phân tích

### Approach: BFS Generation
Generate stepping numbers using a BFS approach. Start with single-digit numbers 0-9. For each number `num`, generate next potential numbers by appending `last_digit - 1` and `last_digit + 1` (if valid digits 0-9). Continue generating as long as the number does not exceed `high`. If a generated number falls within `[low, high]`, add it to the result list. Finally, sort the list.
Tạo các số bước nhảy bằng phương pháp BFS. Bắt đầu với các số có một chữ số 0-9. Đối với mỗi số `num`, tạo các số tiềm năng tiếp theo bằng cách thêm `last_digit - 1` và `last_digit + 1` (nếu là các chữ số hợp lệ 0-9). Tiếp tục tạo miễn là số đó không vượt quá `high`. Nếu một số được tạo nằm trong `[low, high]`, hãy thêm nó vào danh sách kết quả. Cuối cùng, sắp xếp danh sách.

---

# 1366. Rank Teams by Votes / Xếp hạng các Đội theo Phiếu bầu

## Problem Description / Mô tả bài toán
Array `votes` of strings. e.g. "ABC".
Each vote ranks teams. 'A' 1st, 'B' 2nd, 'C' 3rd.
Sort teams based on criteria:
1. More 1st place votes.
2. If tie, more 2nd place votes.
3. ...
4. If tie, alphabetically.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting with Custom Comparator
Count votes for each rank for each team.
`counts[team][rank]`.
Sort teams `A`, `B`.
Compare `counts[A][0]` vs `counts[B][0]`.
If equal, `counts[A][1]` vs `counts[B][1]`.
...
If completely equal, compare `A` vs `B`.

### Complexity / Độ phức tạp
- **Time**: O(N * L + 26 * L log(26)). N votes, L specific len.
- **Space**: O(26 * L).

---

## Analysis / Phân tích

### Approach: 2D Array Counting and Sort
Use a 2D array (or Map of arrays) to store the vote counts for each team at each position. `counts[teamChar][position]`.
Collect all teams involved. Sort the list of teams using a custom comparator that iterates through positions `0` to `len-1`. If counts differ, larger count wins. If all counts equal, smaller character wins.
Sử dụng mảng 2D (hoặc Bản đồ các mảng) để lưu trữ số phiếu bầu cho mỗi đội tại mỗi vị trí. `counts[teamChar][position]`.
Thu thập tất cả các đội tham gia. Sắp xếp danh sách các đội bằng cách sử dụng bộ so sánh tùy chỉnh lặp qua các vị trí `0` đến `len-1`. Nếu số lượng khác nhau, số lượng lớn hơn sẽ thắng. Nếu tất cả số lượng bằng nhau, ký tự nhỏ hơn sẽ thắng.

---

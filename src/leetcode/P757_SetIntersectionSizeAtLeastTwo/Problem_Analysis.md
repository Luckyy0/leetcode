# 757. Set Intersection Size At Least Two / Kích thước Giao của Tập hợp ít nhất là Hai

## Problem Description / Mô tả bài toán
An integer interval `[a, b]` (a < b) is a set of all integers `x` such that `a <= x <= b`.
Một khoảng số nguyên `[a, b]` (a < b) là một tập hợp tất cả các số nguyên `x` sao cho `a <= x <= b`.

Given a list of intervals `intervals`, find the minimum size of a set `S` such that every interval in `intervals` has at least two integers in `S`.
Cho một danh sách các khoảng `intervals`, hãy tìm kích thước nhỏ nhất của một tập hợp `S` sao cho mọi khoảng trong `intervals` có ít nhất hai số nguyên trong `S`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Strategy / Chiến lược Tham lam
1. Sort intervals by their **end** points (ascending). If ends are equal, sort by their **start** points (descending).
Sắp xếp các khoảng theo điểm **kết thúc** (tăng dần). Nếu các điểm kết thúc bằng nhau, hãy sắp xếp theo điểm **bắt đầu** (giảm dần).

2. Iterate through intervals:
   - For an interval `[s, e]`, check how many elements of `S` it currently contains.
   - If 0: Add `e-1` and `e` to `S`.
   - If 1: Add `e` to `S` (if `e` is already in `S`, add the largest possible value not in `S` but within `[s, e]`).

Actually, to be greedy, always favor larger numbers in `S` because they are more likely to cover future intervals.
Thực tế, để tham lam, hãy luôn ưu tiên các số lớn hơn trong `S` vì chúng có nhiều khả năng bao phủ các khoảng trong tương lai hơn.

### Complexity / Độ phức tạp
- **Time**: O(N log N) for sorting.
- **Space**: O(1) beyond input.

---

## Analysis / Phân tích

### Approach: Interval Tracking
Maintain the two largest values currently added to the set. Update them as you process each interval to ensure the "at least two" constraint is met.
Duy trì hai giá trị lớn nhất hiện được thêm vào tập hợp. Cập nhật chúng khi bạn xử lý từng khoảng để đảm bảo đáp ứng ràng buộc "ít nhất hai".

---

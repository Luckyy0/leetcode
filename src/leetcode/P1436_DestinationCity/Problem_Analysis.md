# 1436. Destination City / Thành phố Điểm đến

## Problem Description / Mô tả bài toán
List of paths `[cityA, cityB]` meaning A -> B.
Guaranteed graph forms a line without loop? No, "exactly one destination city".
Destination city = node with out-degree 0.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Out-degree Check
Store all starting cities in a Set.
Iterate paths. For each dest city `B`, check if `B` is in the Set.
If not, `B` is the destination.
Alternatively, add all `A`s to a set `starts`.
Iterate paths again. If `B` not in `starts`, return `B`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Set Difference
Collect all "from" cities into a set.
Iterate all "to" cities. The one that is not in the set is the destination.
Thu thập tất cả các thành phố "từ" vào một tập hợp.
Lặp lại tất cả các thành phố "đến". Thành phố không có trong tập hợp là điểm đến.

---

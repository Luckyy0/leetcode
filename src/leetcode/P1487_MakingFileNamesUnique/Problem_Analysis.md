# 1487. Making File Names Unique / Làm cho Tên tệp Duy nhất

## Problem Description / Mô tả bài toán
Array `names`.
If name exists, append `(k)` smallest positive integer k.
Return actual names list. "First occurrence is original".
Follow order.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### HashMap Tracking
Map `name -> next_k`.
Iterate names.
If `name` not in map:
  Add `name` to map (k=1). Add to result.
Else:
  Retrieve `k` from map.
  Try `newName = name(k)`.
  While `newName` exists in map:
    `k++`. Update `newName`.
  Update map for `name` to `k+1`.
  Add `newName` to map (k=1). Add to result.

### Complexity / Độ phức tạp
- **Time**: O(N). Ideally. Collisions might cause loop, but amortized O(N) since each name creates new unique entry.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: HashMap
Use a hash map to store the next available suffix index for each base name.
When a name is encountered:
1. If it's not in the map, use it as is, set its next suffix to 1.
2. If it is in the map, generate `name(k)`. If `name(k)` also exists (collision from another base name), increment k until unique.
Wait. Collision handling:
Example: `["a", "a(1)", "a"]`.
1. "a": unique. map["a"] = 1.
2. "a(1)": unique (not in map as key). map["a(1)"] = 1.
3. "a": seen. k=1 -> "a(1)". Exists? Yes. k=2 -> "a(2)". Map["a"] becomes 3 (next checking point). Map["a(2)"] = 1.
Need to check existence in Map using `.containsKey`.
Sử dụng bản đồ băm để lưu trữ chỉ mục hậu tố tiếp theo khả dụng cho mỗi tên cơ sở.
Khi gặp một tên:
1. Nếu nó chưa có trong bản đồ, hãy sử dụng nguyên trạng, đặt hậu tố tiếp theo là 1.
2. Nếu nó có trong bản đồ, hãy tạo `name(k)`. Nếu `name(k)` cũng tồn tại, hãy tăng k cho đến khi duy nhất.

---

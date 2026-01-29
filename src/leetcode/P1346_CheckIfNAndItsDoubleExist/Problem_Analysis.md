# 1346. Check If N and Its Double Exist / Kiểm tra xem N và Gấp đôi của Nó có Tồn tại hay không

## Problem Description / Mô tả bài toán
Array `arr`. Check if there exist `i, j` such that `i != j` and `arr[i] == 2 * arr[j]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Set / Hashing
Iterate `x` in `arr`.
Check if `2 * x` or `x / 2` (if even) exists in seen set.
Add `x` to seen.
Special case `0`: need two zeros. Set approach handles naturally if we check before adding OR count frequencies.
Or check `seen.contains(2*x) || (x%2==0 && seen.contains(x/2))`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Hash Set
Iterate through the array. For each element `x`, check if `2 * x` exists in the set OR if `x` is even and `x / 2` exists in the set. If either is true, return `true` (since `i` will be current index and `j` will be the index of the element already in set). Then add `x` to the set.
Lặp lại qua mảng. Đối với mỗi phần tử `x`, kiểm tra xem `2 * x` có tồn tại trong tập hợp HOẶC nếu `x` là số chẵn và `x / 2` tồn tại trong tập hợp hay không. Nếu một trong hai đúng, trả về `true` (vì `i` sẽ là chỉ số hiện tại và `j` sẽ là chỉ số của phần tử đã có trong tập hợp). Sau đó thêm `x` vào tập hợp.

---

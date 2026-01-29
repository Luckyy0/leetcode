# 1330. Reverse Subarray To Maximize Array Value / Đảo ngược Mảng con để Tối đa hóa Giá trị Mảng

## Problem Description / Mô tả bài toán
Value of array = sum of `|nums[i] - nums[i+1]|`.
Reverse one subarray `[L, R]`. Maximize value.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Mathematical Property
Original Value: `Sum |a_i - a_{i+1}|`.
Reversing `[L, R]` only changes the boundary differences.
Indices affected: `L-1, L` and `R, R+1`.
Old contribution: `|a_{L-1} - a_L| + |a_R - a_{R+1}|`.
New contribution (after swap `a_L` with `a_R`): `|a_{L-1} - a_R| + |a_L - a_{R+1}|`.
Change = `|a_{L-1} - a_R| + |a_L - a_{R+1}| - (|a_{L-1} - a_L| + |a_R - a_{R+1}|)`.
Maximize this change.
Simplify `|x - y|`: it's distance.
Actually, for general indices, it's hard.
But there's a geometric trick.
For standard inner pairs (not boundaries), max improvement is `2 * (min_max - max_min)`.
Where `min_max` is minimum of `max(a_i, a_{i+1})` and `max_min` is maximum of `min(a_i, a_{i+1})`.
Improvement if intervals `[min(u,v), max(u,v)]` overlap? No, improvement if they are disjoint.
If interval `[min(a,b), max(a,b)]` and `[min(c,d), max(c,d)]` are disjoint, reversing can gain `2 * dist`.
Also check boundary cases where `L=0` or `R=n-1`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Geometric Optimization
The gain from reversing subarray `[L, R]` (where `0 < L <= R < n-1`) is determined by the pairs `(nums[L-1], nums[L])` and `(nums[R], nums[R+1])`.
Maximum improvement for "inner" reversals is `2 * (max(min(a, b)) - min(max(a, b)))` over all adjacent pairs `(a, b)`.
Specifically, we track `min_high = min(max(nums[i], nums[i+1]))` and `max_low = max(min(nums[i], nums[i+1]))`.
If `max_low > min_high`, the gain is `2 * (max_low - min_high)`.
We must also check boundary cases where the subarray starts at 0 or ends at `n-1`. Iterating through all possible split points covers these cases separately in O(N).
Mức tăng từ việc đảo ngược mảng con `[L, R]` (trong đó `0 < L <= R < n-1`) được xác định bởi các cặp `(nums[L-1], nums[L])` và `(nums[R], nums[R+1])`.
Sự cải thiện tối đa cho các lần đảo ngược "bên trong" là `2 * (max(min(a, b)) - min(max(a, b)))` trên tất cả các cặp liền kề `(a, b)`.
Cụ thể, chúng ta theo dõi `min_high = min(max(nums[i], nums[i+1]))` và `max_low = max(min(nums[i], nums[i+1]))`.
Nếu `max_low > min_high`, mức tăng là `2 * (max_low - min_high)`.
Chúng ta cũng phải kiểm tra các trường hợp biên nơi mảng con bắt đầu tại 0 hoặc kết thúc tại `n-1`. Việc lặp qua tất cả các điểm tách có thể bao gồm các trường hợp này một cách riêng biệt trong O(N).

---

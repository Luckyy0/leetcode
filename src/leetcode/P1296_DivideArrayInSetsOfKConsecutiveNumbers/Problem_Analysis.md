# 1296. Divide Array in Sets of K Consecutive Numbers / Chia Mảng thành các Tập hợp K Số Liên tiếp

## Problem Description / Mô tả bài toán
Array `nums`, integer `k`.
Divide array into sets of size `k` consisting of consecutive numbers.
Return `true` if possible.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Map
Similar to Hand of Straights (P846).
Count frequencies of all numbers.
Process unique numbers in sorted order.
If `minVal` has count `c`, we need to form `c` sequences starting at `minVal`.
Check if `minVal+1`...`minVal+k-1` have at least count `c`.
Decrement their counts. If not enough, return false.

### Complexity / Độ phức tạp
- **Time**: O(N log N) or O(N log M) where M is unique counts.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Sorted Frequency Map
Store the frequency of each number in a TreeMap (or sort keys from HashMap). Iterate through the keys in ascending order. If a number `x` has a count > 0, we must form groups starting with `x`. We check if we can form `count[x]` such groups; this requires `count[x+1], count[x+2]... count[x+k-1]` to be at least `count[x]`. Decrement their counts accordingly. If any requirement is unmet, return false.
Lưu tần suất của mỗi số trong TreeMap (hoặc sắp xếp khóa từ HashMap). Lặp lại qua các khóa theo thứ tự tăng dần. Nếu một số `x` có số đếm > 0, chúng ta phải tạo các nhóm bắt đầu bằng `x`. Chúng ta kiểm tra xem có thể tạo `count[x]` nhóm như vậy không; điều này yêu cầu `count[x+1], count[x+2]... count[x+k-1]` ít nhất phải là `count[x]`. Giảm số đếm tương ứng. Nếu bất kỳ yêu cầu nào không được đáp ứng, trả về false.

---

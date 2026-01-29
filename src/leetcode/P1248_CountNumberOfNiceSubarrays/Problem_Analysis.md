# 1248. Count Number of Nice Subarrays / Đếm Số lượng Mảng con Đẹp

## Problem Description / Mô tả bài toán
Array `nums` and integer `k`. A subarray is nice if it has `k` odd numbers.
Return count.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window / Prefix Sum
This is exactly "Subarrays with sum K" if we replace odds with 1 and evens with 0.
Method 1: HashMap (Prefix Sum).
- Convert `nums` to binary (1 if odd, 0 if even).
- Count subarrays with sum `k`.
Method 2: Sliding Window (Three Pointers).
- `atMost(k) - atMost(k-1)`.
- Or maintain a window `[left, right]` containing exactly `k` odds.
- Count how many valid subarrays end at `right`.
- Extend even numbers to the left.
- Count = `(number of even prefixes + 1)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) or O(N) for prefix map.

---

## Analysis / Phân tích

### Approach: Sliding Window with Prefix Counting
Iterate through the array with a `right` pointer. Maintain a count of odd numbers in the window. Use a `left` pointer to minimize the window such that it still contains `k` odd numbers. If the window has exactly `k` odds, count how many even numbers precede the first odd number in the window. Adding these even numbers + 1 (the minimum valid start) gives the number of valid subarrays ending at `right`.
Lặp lại qua mảng bằng con trỏ `right`. Duy trì số lượng số lẻ trong cửa sổ. Sử dụng con trỏ `left` để thu nhỏ cửa sổ sao cho nó vẫn chứa `k` số lẻ. Nếu cửa sổ có chính xác `k` số lẻ, hãy đếm xem có bao nhiêu số chẵn đứng trước số lẻ đầu tiên trong cửa sổ. Việc cộng các số chẵn này + 1 (điểm bắt đầu hợp lệ tối thiểu) sẽ cho số lượng mảng con hợp lệ kết thúc tại `right`.

---

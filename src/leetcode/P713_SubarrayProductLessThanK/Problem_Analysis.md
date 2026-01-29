# 713. Subarray Product Less Than K / Mảng con có Tích nhỏ hơn K

## Problem Description / Mô tả bài toán
Given an array of integers `nums` and an integer `k`, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than `k`.
Cho một mảng các số nguyên `nums` và một số nguyên `k`, hãy trả về số lượng các mảng con liên tiếp mà tích của tất cả các phần tử trong mảng con nhỏ hơn `k`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window / Cửa sổ Trượt
Since all elements are positive, the product is monotonically increasing as the window expands.
Vì tất cả các phần tử đều dương, tích sẽ tăng đơn điệu khi cửa sổ mở rộng.

We maintain a sliding window `[left, right]` such that the product is `< k`.
Chúng ta duy trì một cửa sổ trượt `[left, right]` sao cho tích `< k`.

For each `right` position:
1. Multiply the current product by `nums[right]`.
2. While `product >= k`, divide by `nums[left]` and increment `left`.
3. The number of new valid subarrays ending at `right` is `right - left + 1`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `nums`.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Two Pointers (Sliding Window)
Track the current product. Shrink the window from the left whenever the product meets or exceeds `k`. Sum the counts of valid subarrays.
Theo dõi tích hiện tại. Thu hẹp cửa sổ từ bên trái bất cứ khi nào tích bằng hoặc vượt quá `k`. Tổng cộng số lượng các mảng con hợp lệ.

---

# 697. Degree of an Array / Bậc của một Mảng

## Problem Description / Mô tả bài toán
Given a non-empty array of non-negative integers `nums`, the **degree** of this array is defined as the maximum frequency of any one of its elements.
Cho một mảng các số nguyên không âm không trống `nums`, **bậc** của mảng này được định nghĩa là tần suất tối đa của bất kỳ phần tử nào của nó.

Your task is to find the smallest possible length of a (contiguous) subarray of `nums`, that has the same degree as `nums`.
Nhiệm vụ của bạn là tìm độ dài nhỏ nhất có thể của một mảng con (liên tiếp) của `nums`, có cùng bậc với `nums`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency Mapping / Ánh xạ Tần suất
1. Calculate the degree by counting frequencies of each element.
2. For the elements that achieve the maximum frequency, the shortest subarray containing all occurrences of that element is bounded by its **first** and **last** appearance.

Algorithm:
- Use a map `left` to store the first index of each element.
- Use a map `right` to store the last index of each element.
- Use a map `count` for frequencies.
- Result is `min(right[x] - left[x] + 1)` for all `x` where `count[x] == degree`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `nums`.
- **Space**: O(N) to store frequencies and indices in maps.

---

## Analysis / Phân tích

### Approach: Triple Tracking (Frequency, First Pos, Last Pos)
A single pass through the array is sufficient to populate all three pieces of information. Then, a second iteration through the frequency map identifies candidates for the shortest subarray.
Một lần duyệt qua mảng là đủ để điền cả ba thông tin. Sau đó, lần lặp thứ hai qua bản đồ tần suất sẽ xác định các ứng cử viên cho mảng con ngắn nhất.

---
